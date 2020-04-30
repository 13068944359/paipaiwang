package com.paipaiwang.listener;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.paipaiwang.service.AuctionService;
import com.paipaiwang.service.OrderService;

/**
 * 继承spring的ApplicationListener监听，并监控ContextRefreshedEvent事件
 * @author Administrator
 */
@Component("BeanDefineConfigue")
public class SpringListener implements ApplicationListener<ContextRefreshedEvent>{

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		if(event.getApplicationContext().getParent() == null){
			//root根容器没有父类，他就是老大
		}
		
		System.out.println("spring启动完成》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》");
	}
	

	@PostConstruct
	public void testStart(){
		System.out.println("spring启动完成test》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》");
	}
	
	
	
	
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private AuctionService auctionService;
	
	private Logger logger = LogManager.getLogger(this.getClass());
}
