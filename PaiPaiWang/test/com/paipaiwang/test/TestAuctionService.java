package com.paipaiwang.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.paipaiwang.po.Auction;
import com.paipaiwang.po.Page;
import com.paipaiwang.service.AuctionService;
import com.paipaiwang.user.vo.MyAuctionVO;

public class TestAuctionService {

	static ApplicationContext context;
	static{
		context =new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	@Test
	public void testAddAuction() throws Exception{
		AuctionService service = context.getBean(AuctionService.class);
		
		Auction auction = new Auction();
		auction.setItemId(1000000002);
		auction.setUserId(1);
		auction.setPrice(1100.00);
		System.out.println(service.addAuction(auction));
		
		
		
	}
	
	
	
	
	@Test
	public void testAddOrder() {
		try {
			AuctionService service = context.getBean(AuctionService.class);
			service.createOrderFromFinishedAuction();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	
	}
	
	
	
	@Test
	public void testMyAuction() throws Exception{
		AuctionService service = context.getBean(AuctionService.class);
		
		Page<Auction> page = new Page<Auction>();
		page.setKeyWord("23");
		
	}
}
