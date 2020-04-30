package com.paipaiwang.user.vo;

import java.util.Date;

import com.paipaiwang.po.Item;

public class ItemPageVO {
	private Integer id;
    private String name;
    private String brief;
    private String type;
    private Integer number;
    private Double price;
    private Double priceAdd;
    private Date startDate;
    private Date endDate;

    private String picture1;
    private String picture2;
    private String picture3;
    private String identifyPicture;

    private String itemDescription;

    public ItemPageVO(Item item){
    	this.id = item.getId();
		this.name = item.getName();
		this.brief = item.getBrief();

		this.number = item.getNumber();
		this.price = item.getPrice();
		this.priceAdd = item.getPriceAdd();
		this.startDate = item.getStartDate();
		this.endDate = item.getEndDate();
		
		this.picture1 = item.getPicture1();
		this.picture2 = item.getPicture2();
		this.picture3 = item.getPicture3();
		this.identifyPicture = item.getIdentifyPicture();
		this.itemDescription = item.getItemDescription();
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

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getPriceAdd() {
		return priceAdd;
	}

	public void setPriceAdd(Double priceAdd) {
		this.priceAdd = priceAdd;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getPicture1() {
		return picture1;
	}

	public void setPicture1(String picture1) {
		this.picture1 = picture1;
	}

	public String getPicture2() {
		return picture2;
	}

	public void setPicture2(String picture2) {
		this.picture2 = picture2;
	}

	public String getPicture3() {
		return picture3;
	}

	public void setPicture3(String picture3) {
		this.picture3 = picture3;
	}

	public String getIdentifyPicture() {
		return identifyPicture;
	}

	public void setIdentifyPicture(String identifyPicture) {
		this.identifyPicture = identifyPicture;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	@Override
	public String toString() {
		return "ItemPageVO [id=" + id + ", name=" + name + ", brief=" + brief
				+ ", type=" + type + ", number=" + number + ", price=" + price
				+ ", priceAdd=" + priceAdd + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", picture1=" + picture1
				+ ", picture2=" + picture2 + ", picture3=" + picture3
				+ ", identifyPicture=" + identifyPicture + ", itemDescription="
				+ itemDescription + "]";
	}
    
}
