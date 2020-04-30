package com.paipaiwang.admin.vo;

/**
 * 用户登录操作封装
 */
public class AdminLoginVO {
	private String username;
	private String password;
	private String verifyCode;
	public final String getUsername() {
		return username;
	}
	public final void setUsername(String username) {
		this.username = username;
	}
	public final String getPassword() {
		return password;
	}
	public final void setPassword(String password) {
		this.password = password;
	}
	public final String getVerifyCode() {
		return verifyCode;
	}
	public final void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}
	@Override
	public String toString() {
		return "AdminLoginVO [username=" + username + ", password=" + password
				+ ", verifyCode=" + verifyCode + "]";
	}
	
	
}
