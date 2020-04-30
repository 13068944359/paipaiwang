package com.paipaiwang.user.vo;

public class LatestAuctionVO {

	private String who;
	private Double price;
	public String getWho() {
		return who;
	}
	public void setWho(String who) {
		this.who = who;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "LatestAuctionVO [who=" + who + ", price=" + price + "]";
	}
	
}
