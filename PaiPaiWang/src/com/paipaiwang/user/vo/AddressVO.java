package com.paipaiwang.user.vo;

public class AddressVO {

	private String username;
	private String phone;
	private String address;
	private String postcode;
	private String other;
	
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	@Override
	public String toString() {
		return "AddressVO [username=" + username + ", phone=" + phone
				+ ", address=" + address + ", postcode=" + postcode + "]";
	}
	
}
