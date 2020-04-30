package com.paipaiwang.test;

import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.paipaiwang.po.Advertisement;
import com.paipaiwang.service.AdvService;

public class TestAdvService {

	static ApplicationContext context;
	static{
		context =new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	
	@Test
	public void testAdd() throws Exception{
		
		AdvService advService = context.getBean(AdvService.class);
		
		Advertisement adv = new Advertisement();
		adv.setCreateTime(new Date());
		adv.setRemark("balabala");
		adv.setTitle("广告轮播图的标题（鼠标停止的时候显示）");
		adv.setUrl("www.baidu.com");
		
		for(int i = 0;i<4;i++){
			adv.setPicture("abcabcabc"+i+".jpg");
			advService.addAdv(adv);
		}
		
	}
	
}
