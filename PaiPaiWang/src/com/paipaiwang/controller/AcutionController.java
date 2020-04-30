package com.paipaiwang.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.paipaiwang.exception.UserErrorParameterException;
import com.paipaiwang.po.Auction;
import com.paipaiwang.po.Page;
import com.paipaiwang.po.User;
import com.paipaiwang.service.AuctionService;
import com.paipaiwang.service.ItemService;
import com.paipaiwang.service.UserService;
import com.paipaiwang.user.vo.LatestAuctionVO;
import com.paipaiwang.user.vo.MyAuctionVO;



@Controller
@RequestMapping("/auction")
public class AcutionController {

	//获取商品详情页中商品的最新竞拍
	@ResponseBody
	@RequestMapping("/latestAuction")
	public Object latestAuction(Integer itemId,HttpServletRequest request) throws Exception {
		//空值校验
		if( itemId == null){
			System.out.println("null");
			throw new UserErrorParameterException();
		}
		try {
			LatestAuctionVO vo = auctionService.latestAuction(itemId);
			Map<String,Object> map = new HashMap<>();
			map.put("result", "ok");
			map.put("data", vo);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"result\":\"error\"}";
		}
		
	}
	
	//支付竞拍所需的保证金
	@ResponseBody
	@RequestMapping("/payAuctionFreeze")
	public String payAuctionFreeze(Integer itemId,HttpServletRequest request) throws Exception {
		//空值校验
		if( itemId == null){
			System.out.println("null");
			throw new UserErrorParameterException();
		}
		
		User user = (User)request.getSession().getAttribute("user");
		try {
			//用户余额足够缴扣保证金则为true，否则为false
			Boolean flag = auctionService.payAuctionFreeze(user.getId(), itemId);
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
	
	//竞拍出价
	@ResponseBody
	@RequestMapping("/auction")
	public String auction(Integer itemId,Double price,HttpServletRequest request) throws Exception{
		//空值校验
		if( itemId == null || price == null){
			System.out.println("null");
			throw new UserErrorParameterException();
		}
		
		User user = (User)request.getSession().getAttribute("user");
		Auction a = new Auction();
		a.setItemId(itemId);
		a.setPrice(price);
		a.setUserId(user.getId());
		
		try {
			boolean b = auctionService.addAuction(a);
			if(b){
				return "{\"result\":\"ok\"}";
			}else{
				return "{\"result\":\"no\"}";//提示用户手慢，已经被抢先出价了，并刷新页面竞拍价格
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"result\":\"error\"}";
		}
	}
	
	
	//获取我的参加的竞拍列表
	@ResponseBody
	@RequestMapping("/myAuction")
	public Object myAuction(Page<Auction> page, HttpServletRequest request) throws Exception{
		User user = (User)request.getSession().getAttribute("user");
		page.setKeyWord(user.getId() + "");
		try {
			//封装了page   totalPage   list  的map
			Map<String,Object> map = auctionService.getMyAuctionList(page);
			map.put("result", "ok");
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"result\":\"error\"}";
		}
	}
	
	
	
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuctionService auctionService;
	
	
	
}
