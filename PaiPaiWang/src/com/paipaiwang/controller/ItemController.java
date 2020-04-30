package com.paipaiwang.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.paipaiwang.admin.vo.ItemDetailVO;
import com.paipaiwang.exception.AdminUnknowException;
import com.paipaiwang.exception.UserErrorParameterException;
import com.paipaiwang.po.Auction;
import com.paipaiwang.po.Collect;
import com.paipaiwang.po.Item;
import com.paipaiwang.po.Page;
import com.paipaiwang.po.User;
import com.paipaiwang.service.AuctionService;
import com.paipaiwang.service.ItemService;
import com.paipaiwang.service.UserService;
import com.paipaiwang.user.vo.ItemAuctionStateVO;
import com.paipaiwang.user.vo.ItemPageVO;
import com.paipaiwang.user.vo.LatestAuctionVO;
import com.paipaiwang.user.vo.PublishVO;
import com.paipaiwang.user.vo.PublishedVO;

@Controller
@RequestMapping("/item")
public class ItemController {
	
	//用户发布商品
	@ResponseBody
	@RequestMapping("/publish")
	public String publish(PublishVO vo,HttpServletRequest request) throws Exception {
		//空值校验
		if( vo==null || vo.getBrief()==null || vo.getEndDate()==null 
				|| vo.getItemDescription()==null || vo.getName()==null || vo.getNumber()==null 
				|| vo.getPicture1()==null 
				|| vo.getPrice()==null || vo.getPriceAdd()==null || vo.getStartDate()==null 
				|| vo.getType()==null){
			System.out.println("null");
			throw new UserErrorParameterException();
		}
		
		User user = (User)request.getSession().getAttribute("user");
		vo.setOwner(user.getId());
		
		String rootPath = request.getSession().getServletContext().getRealPath("/");
		
		try {
			itemService.publishItem(vo, rootPath,user.getId());
			return "{\"result\":\"ok\"}";
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"result\":\"error\"}";
		}
	}
	
	//用户确认账户是否多于200元，用户扣除保证金
	@ResponseBody
	@RequestMapping("/checkMoneyForFreeze")
	public String checkMoneyForFreeze(HttpServletRequest request) throws Exception {
		User user = (User)request.getSession().getAttribute("user");
		
		try {
			user = userService.getUserById(user.getId());
		} catch (Exception e) {
			return "{\"result\":\"error\"}";
		}
		
		if(user.getUserMoney() >= 200){
			return "{\"result\":\"ok\"}";
		}else{
			return "{\"result\":\"no\"}";
		}
		
	}
	
	//已经发布的商品列表
	@ResponseBody
	@RequestMapping("/publishedPage")
	public Object publishedPage(Page<Item> page,HttpServletRequest request) throws Exception {
		User user = (User)request.getSession().getAttribute("user");
		page.setKeyWord(""+user.getId());//用户id进行查找
		
		try {
			Map<String, Object> map = itemService.getPublishedPage(page);
			map.put("result", "ok");
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"result\":\"error\"}";
		}
	}
	
	//商品拍卖详情页，此接口只用于获取基础信息
	@ResponseBody
	@RequestMapping("/itemPage")
	public Object itemPage(Integer id,HttpServletRequest request) throws Exception {
		//空值校验
		if( id == null){
			System.out.println("null");
			throw new UserErrorParameterException();
		}
		
		try {
			ItemPageVO vo = itemService.getItemPageVOById(id);
			return vo;
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"result\":\"error\"}";
		}
	}
		
	
	//获取商品详情页中商品的最新状态信息，判断是否已经缴纳保证金，判断商品是否已经开始或者结束拍卖等
	@ResponseBody
	@RequestMapping("/itemAuctionState")
	public Object itemAuctionState(Integer id,HttpServletRequest request) throws Exception {
		//空值校验
		if( id == null){
			System.out.println("null");
			throw new UserErrorParameterException();
		}
		
		User user = (User)request.getSession().getAttribute("user");
		Integer userId = user==null?null:user.getId();
		try {
			Map<String,Object> map = new HashMap<String,Object>();
			ItemAuctionStateVO vo = itemService.getItemAuctionStateByUseridAndItemId(id, userId);
			map.put("result", "ok");
			map.put("data", vo);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"result\":\"error\"}";
		}
	}
	
	
	//首页获取最新的15个正在竞拍的商品
	@ResponseBody
	@RequestMapping("/homepageItem")
	public Object homepageItem(HttpServletRequest request)  throws Exception{
		//需要判断商品的收藏状态
		User user = (User)request.getSession().getAttribute("user");
		Integer userId = null;
		if(user!=null){
			userId = user.getId();
		}
		
		try {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("result", "ok");
			map.put("data", itemService.homepageItem(userId));
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"result\":\"error\"}";
		}
	}
	
	//分类分页或者根据关键字分页查询以及每日一拍分页
	@ResponseBody
	@RequestMapping("/sortPage")
	public Object sortPage(String type,String key,Integer page,HttpServletRequest request)  throws Exception{
		//空值校验
		if( type == null || key == null || page == null ){
			System.out.println("null");
			throw new UserErrorParameterException();
		}
		System.out.println(type);
		System.out.println(key);
		System.out.println(page);
		User user = (User)request.getSession().getAttribute("user");
		Integer userId = null;
		if(user!=null){
			userId = user.getId();
		}
		
		try {
			Map<String, Object> map = itemService.getSortPage(type, key, page, userId);
			map.put("result", "ok");
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"result\":\"error\"}";
		}
	}
	
	
	
	////////////////////////////////收藏相关的功能↓↓↓↓↓↓↓↓↓↓
	
	//用户请求收藏商品或者取消某个商品的收藏状态
	@ResponseBody
	@RequestMapping("/changeItemCollect")
	public String changeItemCollect(Integer id,Boolean flag,HttpServletRequest request)throws Exception{
		//空值校验
		if( id == null || flag == null){
			System.out.println("null");
			throw new UserErrorParameterException();
		}
		
		User user = (User)request.getSession().getAttribute("user");
		try {
			itemService.changeCollect(user.getId(), id, flag);
		} catch (Exception e) {
			return "{\"result\":\"error\"}";
		}
		return "{\"result\":\"ok\"}";
	}
	
	
	//用户分页获取已收藏的商品列表
	@ResponseBody
	@RequestMapping("/collectionPage")
	public Object collectionPage(Page<Collect> page,HttpServletRequest request)throws Exception{
		//空值校验
		if(page == null){
			System.out.println("null");
			throw new UserErrorParameterException();
		}
		
		page.setRows(12);//收藏页每页12个
		User user = (User)request.getSession().getAttribute("user");
		page.setKeyWord(user.getId() + "");
		
		try {
			Map<String, Object> map = itemService.getCollectedItemListMap(page);
			map.put("result", "ok");
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"result\":\"error\"}";
		}
	}
	
	
////////////////////////////////收藏相关的功能↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
	
	
	
	
	
	
	//////////////////////////////////管理员部分
	
	//未审核商品列表
	@RequestMapping("/admin_getUnverifyItemPage")
	public String getUnverifyItemPage(Page<Item> page,HttpServletRequest request) throws Exception {
		try {
			itemService.findItems(page,false);
		} catch (Exception e) {
			throw new AdminUnknowException("获取未审核商品列表失败",e);
		}
		request.setAttribute("pageMap", page.getPageMap());
		request.setAttribute("lastPage", page.getLastPage());
		request.setAttribute("nextPage", page.getNextPage());
		request.setAttribute("totalPage", page.getTotalPage());
		request.setAttribute("currentPage", page.getPage());
		
		//操作成功提示
		if(request.getSession().getAttribute("successTip") != null){
			request.getSession().removeAttribute("successTip");
			request.setAttribute("successTip", true);
		}
		return "forward:/WEB-INF/jsps/admin/item/unverifyItemList.jsp";
	}
	
	//审核商品页面
	@RequestMapping("/admin_verifyItemDetail")
	public String verifyItemDetail(Integer id,HttpServletRequest request)throws Exception {
		//空值校验
		if(id == null){
			throw new AdminUnknowException("请求关键字段存在空值",null);
		}
		ItemDetailVO itemDetail ;
		try {
			itemDetail = itemService.findItemDetailById(id,false);
		} catch (Exception e) {
			throw new AdminUnknowException("获取未审核商品详细信息失败",e);
		}
		request.setAttribute("itemDetail", itemDetail);
		return "forward:/WEB-INF/jsps/admin/item/verifyItemDetail.jsp";
	}
	

	//审核商品结果提交
	@RequestMapping("/admin_verifyItem")
	public String verifyItem(Integer id,Boolean flag,HttpServletRequest request)throws Exception {
		//空值校验
		if(id == null || flag == null){
			throw new AdminUnknowException("请求关键字段存在空值",null);
		}
		
		try {
			itemService.verifyItemFinish(id, flag);
		} catch (Exception e) {
			throw new AdminUnknowException("审核商品结果保存失败",e);
		}
		request.getSession().setAttribute("successTip", true);
		return "redirect:/item/admin_getUnverifyItemPage";
	}
	
	
	
	//已审核商品列表
	@RequestMapping("/admin_getVerifiedItemPage")
	public String getVerifiedItemPage(Page<Item> page,HttpServletRequest request) throws Exception {
		try {
			itemService.findItems(page,true);
		} catch (Exception e) {
			throw new AdminUnknowException("获取未审核商品列表失败",e);
		}
		request.setAttribute("pageMap", page.getPageMap());
		request.setAttribute("lastPage", page.getLastPage());
		request.setAttribute("nextPage", page.getNextPage());
		request.setAttribute("totalPage", page.getTotalPage());
		request.setAttribute("currentPage", page.getPage());
		
		//操作成功提示
		if(request.getSession().getAttribute("successTip") != null){
			request.getSession().removeAttribute("successTip");
			request.setAttribute("successTip", true);
		}
		return "forward:/WEB-INF/jsps/admin/item/verifiedItemList.jsp";
	}
	
	//审核商品页面
	@RequestMapping("/admin_itemDetail")
	public String itemDetail(Integer id,HttpServletRequest request)throws Exception {
		//空值校验
		if(id == null){
			throw new AdminUnknowException("请求关键字段存在空值",null);
		}
		ItemDetailVO itemDetail ;
		try {
			itemDetail = itemService.findItemDetailById(id,true);
		} catch (Exception e) {
			throw new AdminUnknowException("获取未审核商品详细信息失败",e);
		}
		request.setAttribute("itemDetail", itemDetail);
		return "forward:/WEB-INF/jsps/admin/item/itemDetail.jsp";
	}
	

	@Autowired
	private ItemService itemService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuctionService auctionService;
	
	
}
