package com.paipaiwang.po;

import java.util.Date;

public class Item {
    private Integer id;

    private String name;

    private String brief;

    private Integer type;

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

    private Integer owner;

    private Integer state;

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
        this.name = name == null ? null : name.trim();
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief == null ? null : brief.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
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

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public String getPicture1() {
        return picture1;
    }

    public void setPicture1(String picture1) {
        this.picture1 = picture1 == null ? null : picture1.trim();
    }

    public String getPicture2() {
        return picture2;
    }

    public void setPicture2(String picture2) {
        this.picture2 = picture2 == null ? null : picture2.trim();
    }

    public String getPicture3() {
        return picture3;
    }

    public void setPicture3(String picture3) {
        this.picture3 = picture3 == null ? null : picture3.trim();
    }

    public String getIdentifyPicture() {
        return identifyPicture;
    }

    public void setIdentifyPicture(String identifyPicture) {
        this.identifyPicture = identifyPicture == null ? null : identifyPicture.trim();
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription == null ? null : itemDescription.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getOwner() {
        return owner;
    }

    public void setOwner(Integer owner) {
        this.owner = owner;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

	public final static int VERIFYING = 0;//审核中（等待审核）
	public final static int VERIFY_FAIL = 1;//未通过审核
	public final static int VERIFY_PASS = 2;//通过审核
	public final static int AUCTIONING = 3;//拍卖中
	public final static int AUCTION_FAIL = 4;//流拍
	public final static int AUCTION_SUCCESS = 5;//成交
	
}