package com.paipaiwang.admin.vo;

import java.util.Date;

import com.paipaiwang.po.Item;

/**
 * 商品详细信息封装类
 */
public class ItemDetailVO {

    private Integer id;
    private String name;
    private String brief;
    private String type;//需要根据id获取对应的字符串
    private Integer number;
    private Double price;
    private Double priceAdd;
    private Date startDate;
    private Date endDate;
    private Date publishTime;
    private String picture1;
    private String picture2;
    private String picture3;
    private String identifyPicture;
    private String itemDescription;
    private String remark;
    private String owner;//需要根据id获取对应的字符串
    private String state;//字符串在业务层中获取
    
    //构造方法，从po中获取本vo所需要的信息
	public ItemDetailVO(Item item) {
		this.id = item.getId();
		this.name = item.getName();
		this.brief = item.getBrief();
		this.number = item.getNumber();
		this.price = item.getPrice();
		this.priceAdd = item.getPriceAdd();
		this.startDate = item.getStartDate();
		this.endDate = item.getEndDate();
		this.publishTime = item.getPublishTime();
		this.picture1 = item.getPicture1();
		this.picture2 = item.getPicture2();
		this.picture3 = item.getPicture3();
		this.identifyPicture = item.getIdentifyPicture();
		this.itemDescription = item.getItemDescription();
		this.remark = item.getRemark();
	}

	public ItemDetailVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public final Integer getId() {
		return id;
	}

	public final void setId(Integer id) {
		this.id = id;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final String getBrief() {
		return brief;
	}

	public final void setBrief(String brief) {
		this.brief = brief;
	}

	public final String getType() {
		return type;
	}

	public final void setType(String type) {
		this.type = type;
	}

	public final Integer getNumber() {
		return number;
	}

	public final void setNumber(Integer number) {
		this.number = number;
	}

	public final Double getPrice() {
		return price;
	}

	public final void setPrice(Double price) {
		this.price = price;
	}

	public final Double getPriceAdd() {
		return priceAdd;
	}

	public final void setPriceAdd(Double priceAdd) {
		this.priceAdd = priceAdd;
	}

	public final Date getStartDate() {
		return startDate;
	}

	public final void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public final Date getEndDate() {
		return endDate;
	}

	public final void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public final Date getPublishTime() {
		return publishTime;
	}

	public final void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public final String getPicture1() {
		return picture1;
	}

	public final void setPicture1(String picture1) {
		this.picture1 = picture1;
	}

	public final String getPicture2() {
		return picture2;
	}

	public final void setPicture2(String picture2) {
		this.picture2 = picture2;
	}

	public final String getPicture3() {
		return picture3;
	}

	public final void setPicture3(String picture3) {
		this.picture3 = picture3;
	}

	public final String getIdentifyPicture() {
		return identifyPicture;
	}

	public final void setIdentifyPicture(String identifyPicture) {
		this.identifyPicture = identifyPicture;
	}

	public final String getItemDescription() {
		return itemDescription;
	}

	public final void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public final String getRemark() {
		return remark;
	}

	public final void setRemark(String remark) {
		this.remark = remark;
	}

	public final String getOwner() {
		return owner;
	}

	public final void setOwner(String owner) {
		this.owner = owner;
	}

	public final String getState() {
		return state;
	}

	public final void setState(String state) {
		this.state = state;
	}
    
    
}
