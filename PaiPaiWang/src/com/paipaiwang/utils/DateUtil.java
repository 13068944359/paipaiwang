package com.paipaiwang.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	/**
	 * 判断date所指定的日期是不是今天
	 * @param date	要确认的日期
	 * @return	是今天则true，否则false
	 */
	public boolean isToday(Date date) {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		if (fmt.format(date).toString().equals(fmt.format(new Date()).toString())) {// 格式化为相同格式
			return true;
		} else {
			return false;
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse("2017-04-24");
		
		boolean b = new DateUtil().isToday(date);
		System.out.println(b);
		
	}
	
}
