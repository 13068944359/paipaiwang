package com.paipaiwang.user.vo;

public class ItemAuctionStateVO {
	private Boolean Mine;//判断是不是自己发布的，用于后面判断能否出价
	private Integer state;
	private String who;
	private Double price;
	private Boolean freeze;
	
	public Boolean getMine() {
		return Mine;
	}
	public void setMine(Boolean mine) {
		Mine = mine;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
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
	public Boolean getFreeze() {
		return freeze;
	}
	public void setFreeze(Boolean freeze) {
		this.freeze = freeze;
	}
	@Override
	public String toString() {
		return "ItemAuctionStateVO [state=" + state + ", who=" + who
				+ ", price=" + price + ", freeze=" + freeze + "]";
	}
	
}
