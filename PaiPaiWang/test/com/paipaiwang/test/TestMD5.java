package com.paipaiwang.test;

import org.junit.Test;

import com.paipaiwang.utils.MD5Util;

public class TestMD5 {

	@Test
	public void test1(){
		String passwd = MD5Util.decodePasswd("paipaiwang");
		System.out.println(passwd);
		//A28A786E44E23E10B9B02467F691DC1E
	}
	
	
	@Test
	public void testStr(){
		System.out.println("你好".length());
	}
}
