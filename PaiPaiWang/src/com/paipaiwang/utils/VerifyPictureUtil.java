package com.paipaiwang.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import com.paipaiwang.admin.vo.VerifyPictureVO;


public class VerifyPictureUtil {
	/**
	 * 生成验证图片
	 */
	public VerifyPictureVO getVerifyPictureVO() {
		VerifyPictureVO vo = new VerifyPictureVO();
		
		//HttpServletRequest req = new HttpServletRequest();
		int width = 60;
		int height = 18;
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		// 设置图片背景色
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, width, height);
		// 设置边框
		// g.setColor(Color.BLUE);
		// g.drawRect(1, 1, width-2, height-2);
		// 画干扰线
		/*g.setColor(Color.WHITE);
		for (int i = 0; i < 5; i++) {
			int x1 = new Random().nextInt(width);
			int y1 = new Random().nextInt(height);
			int x2 = new Random().nextInt(width);
			int y2 = new Random().nextInt(height);
			g.drawLine(x1, y1, x2, y2);
		}*/
		// 写随机数
		String verifyCode = drawRandomNum((Graphics2D) g);
		
		vo.setBufferedImage(image);
		vo.setVerifyCode(verifyCode);
		return vo;
	}

	/**
	 * 把产生的随机数写到图片上
	 */
	private String drawRandomNum(Graphics2D g) {
		g.setColor(Color.WHITE);
		g.setFont(new Font("宋体", Font.BOLD, 19));
		String check = "";
		// x代表旋转圆心的横坐标
		int x = 4;
		for (int i = 0; i < 4; i++) {
			String ch = new Random().nextInt(10) + "";
			check = check + ch;
			int dre = new Random().nextInt() % 30; // -30到30之间的数字
			g.rotate(dre * Math.PI / 180, x, 14);// 设置旋转弧度
			g.drawString(ch, x, 14);
			g.rotate(-dre * Math.PI / 180, x, 14);
			x += 14;
		}
		return check;
	}
}
