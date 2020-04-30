package com.paipaiwang.admin.vo;

import java.util.Date;

/**
 * 商品列表信息封装类
 */
public class ItemListVO {

    private String id;

    private String name;

    private String brief;

    private Double price;

    private Date startDate;

    private Date endDate;

    private Date publishTime;

    private String owner;//发布者

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

	public final String getBrief() {
		return brief;
	}

	public final void setBrief(String brief) {
		this.brief = brief;
	}

	public final Double getPrice() {
		return price;
	}

	public final void setPrice(Double price) {
		this.price = price;
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

	public final String getOwner() {
		return owner;
	}

	public final void setOwner(String owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "ItemListVO [id=" + id + ", name=" + name + ", brief=" + brief
				+ ", price=" + price + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", publishTime=" + publishTime
				+ ", owner=" + owner + "]";
	}
	
}
