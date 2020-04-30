package com.paipaiwang.user.vo;


import java.text.SimpleDateFormat;

import com.paipaiwang.po.Item;

public class PublishedVO {

	private Integer id;
	private String name;
	private String brief;
	private String type;
	private Double price;
	private String startDate;
	private String endDate;
	private Integer number;
	private Double priceAdd;
	private String publishTime;
	private String stateValue;
	private Integer state;
	private String picture;
	
	
	public PublishedVO(Item item){
		this.id = item.getId();
		this.name = item.getName();
		this.brief = item.getBrief();
		this.price = item.getPrice();
		this.picture = item.getPicture1();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		this.startDate = sdf.format(item.getStartDate());
		this.endDate = sdf.format(item.getEndDate());
		this.number = item.getNumber();
		this.priceAdd = item.getPriceAdd();
		sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.publishTime = sdf.format(item.getPublishTime());
		
		this.state = item.getState();
		
	}
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Double getPriceAdd() {
		return priceAdd;
	}
	public void setPriceAdd(Double priceAdd) {
		this.priceAdd = priceAdd;
	}
	public String getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}
	public String getStateValue() {
		return stateValue;
	}
	public void setStateValue(String stateValue) {
		this.stateValue = stateValue;
	}











	public String getPicture() {
		return picture;
	}



	public void setPicture(String picture) {
		this.picture = picture;
	}



	public Integer getState() {
		return state;
	}




	@Override
	public String toString() {
		return "PublishedVO [id=" + id + ", name=" + name + ", brief=" + brief
				+ ", type=" + type + ", price=" + price + ", startDate="
				+ startDate + ", endDate=" + endDate + ", number=" + number
				+ ", priceAdd=" + priceAdd + ", publishTime=" + publishTime
				+ ", stateValue=" + stateValue + ", state=" + state + "]";
	}











	public void setState(Integer state) {
		this.state = state;
	}
	
}
