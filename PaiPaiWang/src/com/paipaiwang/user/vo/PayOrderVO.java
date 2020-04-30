package com.paipaiwang.user.vo;

public class PayOrderVO {

	private Integer orderId;
	private String name;
	private String phone;
	private String address;
	private String postcode;
	private String other;
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	@Override
	public String toString() {
		return "PayOrderVO [orderId=" + orderId + ", name=" + name + ", phone="
				+ phone + ", address=" + address + ", postcode=" + postcode
				+ ", other=" + other + "]";
	}
	
}
