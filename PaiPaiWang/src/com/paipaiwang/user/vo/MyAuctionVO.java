package com.paipaiwang.user.vo;

import java.util.Date;

public class MyAuctionVO {

	private Integer itemId;
	private String seller;//卖家
	private String state;//商品状态
	private Date endDate;//结束时间，在前端计算出剩余拍卖时间
	private String picture;//图片链接
	private String name;
	private String brief;
	private Double currentPrice;
	private Double myAuctionPrice;
	
	
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public Double getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(Double currentPrice) {
		this.currentPrice = currentPrice;
	}
	public Double getMyAuctionPrice() {
		return myAuctionPrice;
	}
	public void setMyAuctionPrice(Double myAuctionPrice) {
		this.myAuctionPrice = myAuctionPrice;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "MyAuctionVO [itemId=" + itemId + ", seller=" + seller
				+ ", state=" + state + ", endDate=" + endDate + ", picture="
				+ picture + ", name=" + name + ", brief=" + brief
				+ ", currentPrice=" + currentPrice + ", myAuctionPrice="
				+ myAuctionPrice + "]";
	}
	
	
	
}
