package com.paipaiwang.test;

import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.paipaiwang.po.Admin;
import com.paipaiwang.po.Page;
import com.paipaiwang.service.AdminService;
import com.paipaiwang.utils.MD5Util;

public class TestAdminService {

	
	@Test
	public void testAdd(){
		ApplicationContext context =new ClassPathXmlApplicationContext("applicationContext.xml");
		AdminService adminService = context.getBean(AdminService.class);
		
		Admin admin = new Admin();
		admin.setCreateTime(new Date());
		admin.setSuperUser(true);
		admin.setPassword(MD5Util.decodePasswd("paipaiwang"));
		admin.setRemark("balabala");
		
		try {
			for(int i=0;i<22;i++){
				String usernameStr = "test"+i+"num";
				admin.setUsername(usernameStr);
				
				adminService.addAdmin(admin);
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("==================error");
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testVarchar(){
		ApplicationContext context =new ClassPathXmlApplicationContext("applicationContext.xml");
		AdminService adminService = context.getBean(AdminService.class);
		
		Admin admin = new Admin();
		admin.setCreateTime(new Date());
		admin.setSuperUser(true);
		admin.setPassword(MD5Util.decodePasswd("paipaiwang"));
		admin.setRemark("balabala");
		admin.setUsername("啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊");//无论是全角字符还是半角字符的varchar长度都是1
		
		try {
				adminService.addAdmin(admin);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("==================error");
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testFindAdmins() throws Exception{
		ApplicationContext context =new ClassPathXmlApplicationContext("applicationContext.xml");
		AdminService adminService = context.getBean(AdminService.class);
		
		Page<Admin> page = new Page();
		Page<Admin> admins = adminService.findAdmins(page);
		
		System.out.println(admins.getPageMap().get("rows"));
		
	}
	
	@Test
	public void testNum(){
		int a = 22/10;
		System.out.println(a);
	}
	
}
