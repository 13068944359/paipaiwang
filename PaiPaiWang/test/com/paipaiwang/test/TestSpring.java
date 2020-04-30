package com.paipaiwang.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.paipaiwang.dao.UserMapper;

public class TestSpring {

	@Test
	public void go(){
		ApplicationContext context =new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		UserMapper userMapper = context.getBean(UserMapper.class);
		
		System.out.println(userMapper);
		
	}
}
