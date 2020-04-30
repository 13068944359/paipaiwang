package com.paipaiwang.timertask;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("taskJob")
public class TimerTask {

	//每天凌晨0时0分2秒触发
	@Scheduled(cron = "2 0 0 * * ?")  
	public void daily(){
//		System.out.println("定时任务day");
	}
	
	//每个小时触发
	@Scheduled(cron = "0 0 * * * ?")  
	public void hourly(){
//		System.out.println("hour");
	}
	
//	@Scheduled(cron = "0 0 3 * * ?")  
//	public void tenSecondly(){
//		System.out.println("10s");
//	}
}


////spring定时任务框架实现对拍卖商品的监督
//@Component("taskJob")
//public class TimerTask {
//	
//	@Autowired
//	private AuctionService auctionService;
//	
//	@Autowired
//	private OrderService orderService;
//
//	//每天凌晨0时0分2秒触发
//	@Scheduled(cron = "2 0 0 * * ?")  
//	public void daily(){
//		System.out.println("每天凌晨0时0分2秒触发");
//		try {
//			auctionService.createOrderFromFinishedAuction();//结束拍卖并生成对应订单，返还未竞拍成功的保证金等
//			auctionService.startAuctionOnItemStartDate();//设置了当天开始竞拍的商品，将状态修改为“竞拍中”
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//}
