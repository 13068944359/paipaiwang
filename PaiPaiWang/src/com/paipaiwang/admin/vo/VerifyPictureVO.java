package com.paipaiwang.admin.vo;

import java.awt.image.BufferedImage;

//验证图片以及验证码封装vo
public class VerifyPictureVO {
	private BufferedImage bufferedImage;
	private String verifyCode;
	public final BufferedImage getBufferedImage() {
		return bufferedImage;
	}
	public final void setBufferedImage(BufferedImage bufferedImage) {
		this.bufferedImage = bufferedImage;
	}
	public final String getVerifyCode() {
		return verifyCode;
	}
	public final void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}
	
}
