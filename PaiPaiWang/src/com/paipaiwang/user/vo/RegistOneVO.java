package com.paipaiwang.user.vo;

public class RegistOneVO {
	private String phone;
	private String name;
	private String pwd;
	private String pwd2;
	private String verifyCode;
	public final String getPhone() {
		return phone;
	}
	public final void setPhone(String phone) {
		this.phone = phone;
	}
	public final String getName() {
		return name;
	}
	public final void setName(String name) {
		this.name = name;
	}
	public final String getPwd() {
		return pwd;
	}
	public final void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public final String getPwd2() {
		return pwd2;
	}
	public final void setPwd2(String pwd2) {
		this.pwd2 = pwd2;
	}
	public final String getVerifyCode() {
		return verifyCode;
	}
	public final void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}
	@Override
	public String toString() {
		return "RegistOneVO [phone=" + phone + ", name=" + name + ", pwd="
				+ pwd + ", pwd2=" + pwd2 + ", verifyCode=" + verifyCode + "]";
	}
	
	
}
