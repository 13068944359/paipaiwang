package com.paipaiwang.user.vo;

public class HomepageItemVO {
	private Integer id;
	private String name;
	private String picture;
	private Double currentPrice;
	private String endDate;
	private Boolean collected;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public Double getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(Double currentPrice) {
		this.currentPrice = currentPrice;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public Boolean getCollected() {
		return collected;
	}
	public void setCollected(Boolean collected) {
		this.collected = collected;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "HomepageItemVO [id=" + id + ", name=" + name + ", picture="
				+ picture + ", currentPrice=" + currentPrice + ", endDate="
				+ endDate + ", collected=" + collected + "]";
	}
	
	
}
