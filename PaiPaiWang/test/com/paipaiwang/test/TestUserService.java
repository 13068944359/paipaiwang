package com.paipaiwang.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.paipaiwang.po.Page;
import com.paipaiwang.po.User;
import com.paipaiwang.service.UserService;
import com.paipaiwang.utils.MD5Util;

public class TestUserService {

	static ApplicationContext context;
	static{
		context =new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	@Test
	public void testAddUser() throws Exception{
		UserService userService = context.getBean(UserService.class);
		
		User user = new User();
		user.setUsername("zhangsan");
		user.setPassword(MD5Util.decodePasswd("paipaiwang"));
		user.setRealname("张三");
		user.setIdcard("440888888888888888");
		user.setGender(1);
		user.setEmail("avce@123.com");
		user.setAddress("啊啊啊啊啊啊啊啊啊啊啊啊");
		user.setPostcode("000000");
		user.setRemark("balabalabala");
		user.setUserMoney(0.00);
		user.setFreeze(false);
		
		for(int i= 0;i<=20;i++){
			String str = "130888888"+i;
			user.setMobiphone(str);
			userService.addUser(user);
		}
		
		
		
	}

	@Test
	public void testFindByPage() throws Exception{
		UserService userService = context.getBean(UserService.class);
		Page<User> page = new Page<User>();
		page.setKeyWord("30");
		
		
	}
	
	@Test
	public void testAdSMoney() throws Exception{

		UserService userService = context.getBean(UserService.class);
		userService.subMoneyToUserById(1, 50.00);
		
		
		
		
	}
	
	
}
