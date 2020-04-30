package com.paipaiwang.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.paipaiwang.admin.vo.InterveneVO;
import com.paipaiwang.admin.vo.OrderDetailVO;
import com.paipaiwang.dao.OrderMapper;
import com.paipaiwang.exception.AdminUnknowException;
import com.paipaiwang.exception.UserErrorParameterException;
import com.paipaiwang.po.Intervene;
import com.paipaiwang.po.Order;
import com.paipaiwang.po.Page;
import com.paipaiwang.po.User;
import com.paipaiwang.service.OrderService;
import com.paipaiwang.user.vo.AddressVO;
import com.paipaiwang.user.vo.PayOrderVO;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	
	
	
	//买家订单列表分页获取
	@ResponseBody
	@RequestMapping("/buyOrderPage")
	public Object buyOrderPage(Integer page,HttpServletRequest request) throws Exception{
		//空值校验
		if( page == null){
			System.out.println("null");
			throw new UserErrorParameterException();
		}
		
		User user = (User)request.getSession().getAttribute("user");
		try {
			Map<String, Object> map = orderService.buyOrderPage(page, user.getId());
			map.put("result", "ok");
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"result\":\"error\"}";
		}
	}
	
	
	//卖家订单列表分页获取
	@ResponseBody
	@RequestMapping("/sellOrderPage")
	public Object sellOrderPage(Integer page,HttpServletRequest request) throws Exception{
		//空值校验
		if( page == null){
			System.out.println("null");
			throw new UserErrorParameterException();
		}
		
		User user = (User)request.getSession().getAttribute("user");
		try {
			Map<String, Object> map = orderService.sellOrderPage(page, user.getId());
			map.put("result", "ok");
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"result\":\"error\"}";
		}
	}
	

	//买家支付订单
	@ResponseBody
	@RequestMapping("/payForOrder")
	public Object payForOrder(PayOrderVO vo,HttpServletRequest request) throws Exception{
		//空值校验
		if( vo == null || vo.getOrderId() == null || vo.getName() == null || vo.getPhone() == null ||
				vo.getAddress() == null || vo.getPostcode() == null || vo.getOther() == null){
			System.out.println("null");
			throw new UserErrorParameterException();
		}
		
		System.out.println(vo);
		
		User user = (User)request.getSession().getAttribute("user");
		try {
			Boolean flag = orderService.payForOrder(vo, user.getId());
			if(flag){
				return "{\"result\":\"ok\"}";
			}else{
				return "{\"result\":\"no\"}";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"result\":\"error\"}";
		}
	}
	
	
	//买家取消订单
	@ResponseBody
	@RequestMapping("/cancelBuyOrder")
	public Object cancelBuyOrder(Integer id,HttpServletRequest request) throws Exception{
		//空值校验
		if( id == null){
			System.out.println("null");
			throw new UserErrorParameterException();
		}
		
		User user = (User)request.getSession().getAttribute("user");
		try {
			orderService.cancelBuyOrder(id, user.getId());
			return "{\"result\":\"ok\"}";
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"result\":\"error\"}";
		}
	}
	
	//买家取消订单
	@ResponseBody
	@RequestMapping("/cancelSellOrder")
	public Object cancelSellOrder(Integer id,HttpServletRequest request) throws Exception{
		//空值校验
		if( id == null){
			System.out.println("null");
			throw new UserErrorParameterException();
		}
		
		User user = (User)request.getSession().getAttribute("user");
		try {
			orderService.cancelSellOrder(id, user.getId());
			return "{\"result\":\"ok\"}";
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"result\":\"error\"}";
		}
	}
	
	
	//买家评价商品 
	@ResponseBody
	@RequestMapping("/evaluate")
	public Object evaluate(Integer id,String evaluation,HttpServletRequest request) throws Exception{
		//空值校验
		if( id == null || evaluation == null ){
			System.out.println("null");
			throw new UserErrorParameterException();
		}

		User user = (User)request.getSession().getAttribute("user");
		try {
			orderService.evaluateItem(id, user.getId(), evaluation);
			return "{\"result\":\"ok\"}";
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"result\":\"error\"}";
		}
	}
	
	//卖家查看商品评价
	@ResponseBody
	@RequestMapping("/findEvaluate")
	public Object findEvaluate(Integer id,HttpServletRequest request) throws Exception{
		//空值校验
		if( id == null ){
			System.out.println("null");
			throw new UserErrorParameterException();
		}

		User user = (User)request.getSession().getAttribute("user");
		try {
			Map<String,Object> map = new HashMap<String,Object>();
			String evaluation = orderService.findEvaluationByOrderId(id, user.getId());
			map.put("result", "ok");
			map.put("data", evaluation);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"result\":\"error\"}";
		}
	}
	
	

	//买家申请平台介入
	@ResponseBody
	@RequestMapping("/buyerRequestIntervene")
	public Object buyerRequestIntervene(Integer id,String forWhat,String forWhy,HttpServletRequest request) throws Exception{
		//空值校验
		if( id == null || forWhat == null || forWhy == null){
			System.out.println("null");
			throw new UserErrorParameterException();
		}
		
		Intervene intervene = new Intervene();
		intervene.setOrderId(id);
		intervene.setForWhat(forWhat);
		intervene.setForWhy(forWhy);
		
		try {
			orderService.buyerRequestIntervene(intervene);
			return "{\"result\":\"ok\"}";
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"result\":\"error\"}";
		}
	}
	
	
	
	//卖家申请平台介入
	@ResponseBody
	@RequestMapping("/sellerRequestIntervene")
	public Object sellerRequestIntervene(Integer id,String forWhat,String forWhy,HttpServletRequest request) throws Exception{
		//空值校验
		if( id == null || forWhat == null || forWhy == null){
			System.out.println("null");
			throw new UserErrorParameterException();
		}
		
		Intervene intervene = new Intervene();
		intervene.setOrderId(id);
		intervene.setForWhat(forWhat);
		intervene.setForWhy(forWhy);
		
		try {
			orderService.sellerRequestIntervene(intervene);
			return "{\"result\":\"ok\"}";
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"result\":\"error\"}";
		}
	}
	
	
	
	
	//卖家想要发货，先获取买家的收货地址信息
	@ResponseBody
	@RequestMapping("/getAddressMessage")
	public Object getAddressMessage(Integer id,HttpServletRequest request) throws Exception{
		//空值校验
		if( id == null){
			System.out.println("null");
			throw new UserErrorParameterException();
		}
		
		User user = (User)request.getSession().getAttribute("user");
		try {
			Map<String,Object> map = new HashMap<String, Object>();
			AddressVO vo = orderService.getAddressMessage(id, user.getId());
			map.put("result", "ok");
			map.put("data", vo);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"result\":\"error\"}";
		}
	}
	
	//发货操作，记录快递信息
	@ResponseBody
	@RequestMapping("/sendGoods")
	public Object sendGoods(Integer id,String express_company,String express_id,HttpServletRequest request) throws Exception{
		//空值校验
		if( id == null || express_company==null || express_id==null){
			System.out.println("null");
			throw new UserErrorParameterException();
		}
		
		User user = (User)request.getSession().getAttribute("user");
		
		try {
			orderService.sendGoods(id, express_company, express_id, user.getId());
			return "{\"result\":\"ok\"}";
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"result\":\"error\"}";
		}
	}
	
	
	//确认收货
	@ResponseBody
	@RequestMapping("/getGoodsConfirm")
	public Object getGoodsConfirm(Integer id,HttpServletRequest request) throws Exception{
		//空值校验
		if( id == null ){
			System.out.println("null");
			throw new UserErrorParameterException();
		}
		
		User user = (User)request.getSession().getAttribute("user");
		
		try {
			orderService.getGoodsConfirm(id, user.getId());
			return "{\"result\":\"ok\"}";
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"result\":\"error\"}";
		}
	}
	
	//查看申请退货的理由returnReason
	@ResponseBody
	@RequestMapping("/returnReason")
	public Object returnReason(Integer id,HttpServletRequest request) throws Exception{
		//空值校验
		if( id == null ){
			System.out.println("null");
			throw new UserErrorParameterException();
		}
		
		User user = (User)request.getSession().getAttribute("user");
		try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("result", "ok");
			String returnReason = orderService.returnReason(id, user.getId());
			map.put("data", returnReason);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"result\":\"error\"}";
		}
	}
	
	
	//申请退货  
	@ResponseBody
	@RequestMapping("/requestReturn")
	public Object requestReturn(Integer id,String return_reason,HttpServletRequest request) throws Exception{
		//空值校验
		if( id == null || return_reason == null ){
			System.out.println("null");
			throw new UserErrorParameterException();
		}
		
		User user = (User)request.getSession().getAttribute("user");
		try {
			orderService.requestReturn(id, return_reason, user.getId());
			return "{\"result\":\"ok\"}";
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"result\":\"error\"}";
		}
	}
	
	
	//同意退货  
	@ResponseBody
	@RequestMapping("/agreeReturn")
	public Object agreeReturn(Integer id,HttpServletRequest request) throws Exception{
		//空值校验
		if( id == null ){
			System.out.println("null");
			throw new UserErrorParameterException();
		}
		
		User user = (User)request.getSession().getAttribute("user");
		try {
			boolean flag = orderService.handelReturnRequest(id, user.getId(), true);
			if(flag){
				return "{\"result\":\"ok\"}";
			}else{
				return "{\"result\":\"no\"}";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"result\":\"error\"}";
		}
	}
	
	//拒绝退货  
	@ResponseBody
	@RequestMapping("/disagreeReturn")
	public Object disagreeReturn(Integer id,HttpServletRequest request) throws Exception{
		//空值校验
		if( id == null ){
			System.out.println("null");
			throw new UserErrorParameterException();
		}
		
		User user = (User)request.getSession().getAttribute("user");
		try {
			orderService.handelReturnRequest(id, user.getId(), false);
			return "{\"result\":\"ok\"}";
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"result\":\"error\"}";
		}
	}
	
	
	
	////////////////////////////////后台管理部分
	
	//跳转订单列表页面
	@RequestMapping("/admin_getOrderListPage")
	public String getOrderPage(Page<Order> page,HttpServletRequest request)  throws Exception  {
		try {
			orderService.findOrders(page);
		} catch (Exception e) {
			throw new AdminUnknowException("查询订单列表出错",e);
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
		return "forward:/WEB-INF/jsps/admin/order/orderList.jsp";
	}
	
	

	@RequestMapping("/admin_orderDetailPage")
	public String orderDetail(Integer id,HttpServletRequest request) throws Exception{
		//空值校验
		if(id == null){
			throw new AdminUnknowException("请求关键字段存在空值",null);
		}
		OrderDetailVO orderVO = orderService.fingOrderDetail(id);
		request.setAttribute("orderVO", orderVO);
		return "forward:/WEB-INF/jsps/admin/order/orderDetail.jsp";
	}
	
	
	//纠纷处理页
	@RequestMapping("/admin_getInterveneListPage")
	public String getInterveneListPage(Page<Intervene> page,HttpServletRequest request)  throws Exception{
		try {
			orderService.findIntervenes(page);
		} catch (Exception e) {
			throw new AdminUnknowException("查询纠纷列表出错",e);
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
		return "forward:/WEB-INF/jsps/admin/order/interveneList.jsp";
	}
	
	@RequestMapping("/admin_interveneDetailPage")
	public String interveneDetailPage(Integer id,HttpServletRequest request) throws Exception{
		//空值校验
		if(id == null){
			throw new AdminUnknowException("请求关键字段存在空值",null);
		}
		InterveneVO interveneVO = orderService.findInterveneDetail(id);
		request.setAttribute("interveneVO", interveneVO);
		return "forward:/WEB-INF/jsps/admin/order/interveneDetail.jsp";
	}
	
	
	@RequestMapping("/admin_handleIntervene")
	public String handleIntervene(Integer id,Boolean agree,HttpServletRequest request) throws Exception{
		//空值校验
		if(id == null || agree == null){
			throw new AdminUnknowException("请求关键字段存在空值",null);
		}
		orderService.handleIntervene(id, agree);

		request.getSession().setAttribute("successTip", true);
		return "redirect:/order/admin_getInterveneListPage";
	}
	
	
}
