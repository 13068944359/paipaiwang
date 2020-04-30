package com.paipaiwang.admin.vo;

import java.util.Date;

/**
 * 订单列表信息封装类
 */
public class OrderListVO {
	private String id;
	private String name;
	private double price;
	private Date createDate;
	private String seller;
	private String buyer;
	private String state;
	public final String getId() {
		return id;
	}
	public final void setId(String id) {
		this.id = id;
	}
	public final String getName() {
		return name;
	}
	public final void setName(String name) {
		this.name = name;
	}
	public final double getPrice() {
		return price;
	}
	public final void setPrice(double price) {
		this.price = price;
	}
	public final Date getCreateDate() {
		return createDate;
	}
	public final void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public final String getSeller() {
		return seller;
	}
	public final void setSeller(String seller) {
		this.seller = seller;
	}
	public final String getBuyer() {
		return buyer;
	}
	public final void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	public final String getState() {
		return state;
	}
	public final void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "OrderListVO [id=" + id + ", name=" + name + ", price=" + price
				+ ", createDate=" + createDate + ", seller=" + seller
				+ ", buyer=" + buyer + ", state=" + state + "]";
	}
	
}
