package com.paipaiwang.user.vo;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class PublishVO {
	
	private String name;
	private String brief;
    private Integer type;
    private Integer number;
    private Double price;
    private Double priceAdd;
    
    private Date startDate;
    private Date endDate;
    
    private MultipartFile picture1;
    private MultipartFile picture2;
    private MultipartFile picture3;
    private MultipartFile identifyPicture;
    
    private String itemDescription;
    
    private Integer owner;
    

	public Integer getOwner() {
		return owner;
	}

	public void setOwner(Integer owner) {
		this.owner = owner;
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

	public MultipartFile getPicture1() {
		return picture1;
	}

	public void setPicture1(MultipartFile picture1) {
		this.picture1 = picture1;
	}

	public MultipartFile getPicture2() {
		return picture2;
	}

	public void setPicture2(MultipartFile picture2) {
		this.picture2 = picture2;
	}

	public MultipartFile getPicture3() {
		return picture3;
	}

	public void setPicture3(MultipartFile picture3) {
		this.picture3 = picture3;
	}

	public MultipartFile getIdentifyPicture() {
		return identifyPicture;
	}

	public void setIdentifyPicture(MultipartFile identifyPicture) {
		this.identifyPicture = identifyPicture;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "PublishVO [name=" + name + ", brief=" + brief + ", type="
				+ type + ", number=" + number + ", price=" + price
				+ ", priceAdd=" + priceAdd + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", picture1=" + picture1
				+ ", picture2=" + picture2 + ", picture3=" + picture3
				+ ", identifyPicture=" + identifyPicture + ", itemDescription="
				+ itemDescription + "]";
	}


    
}
