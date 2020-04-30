package com.paipaiwang.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.paipaiwang.dao.OrderMapper;
import com.paipaiwang.po.Order;
import com.paipaiwang.po.Page;

public class TestOrderService {

	static ApplicationContext context;
	static{
		context =new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	
	@Test
	public void testSelectPage(){
		OrderMapper orderMapper = context.getBean(OrderMapper.class);
		Page<Order> page = new Page<Order>();
		List<Order> list = orderMapper.selectPageList(page);
		for(Order o : list){
			System.out.println(o);
		}
		
	}
	
	
	
	
	
	
}
