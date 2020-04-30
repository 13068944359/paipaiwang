package com.paipaiwang.admin.vo;

import java.util.Date;

import com.paipaiwang.po.Order;

/**
 * 订单详细信息封装类
 */
public class OrderDetailVO {

	private Integer id;
	private String buyer;//
	private String seller;//
	private Double price;
	private Date createDate;
	private Date finishTime;
	private String sendName;
	private String sendPhone;
	private String sendAddress;
	private String sendPostcode;
	private String sendOthers;
	private String expressCompany;
	private String expressCode;
	private String state;//
	private String evaluation;
	private String returnReason;
	
	public OrderDetailVO(Order o){
		this.id = o.getId();
		this.price = o.getPrice();
		this.createDate = o.getCreateDate();
		this.finishTime = o.getFinishTime();
		this.sendName = o.getSendName();
		this.sendPhone = o.getSendPhone();
		this.sendAddress = o.getSendAddress();
		this.sendPostcode = o.getSendPostcode();
		this.sendOthers = o.getSendOthers();
		this.evaluation = o.getEvaluation();
		this.returnReason = o.getReturnReason();
		this.expressCompany = o.getExpressCompany();
		this.expressCode = o.getExpressId();
	}
	
	
	public OrderDetailVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public final Integer getId() {
		return id;
	}

	public final void setId(Integer id) {
		this.id = id;
	}

	public final String getBuyer() {
		return buyer;
	}

	public final void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	public final String getSeller() {
		return seller;
	}

	public final void setSeller(String seller) {
		this.seller = seller;
	}

	public final Double getPrice() {
		return price;
	}

	public final void setPrice(Double price) {
		this.price = price;
	}

	public final Date getCreateDate() {
		return createDate;
	}

	public final void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public final Date getFinishTime() {
		return finishTime;
	}

	public final void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public final String getSendName() {
		return sendName;
	}

	public final void setSendName(String sendName) {
		this.sendName = sendName;
	}

	public final String getSendPhone() {
		return sendPhone;
	}

	public final void setSendPhone(String sendPhone) {
		this.sendPhone = sendPhone;
	}

	public final String getSendAddress() {
		return sendAddress;
	}

	public final void setSendAddress(String sendAddress) {
		this.sendAddress = sendAddress;
	}

	public final String getSendPostcode() {
		return sendPostcode;
	}

	public final void setSendPostcode(String sendPostcode) {
		this.sendPostcode = sendPostcode;
	}

	public final String getSendOthers() {
		return sendOthers;
	}

	public final void setSendOthers(String sendOthers) {
		this.sendOthers = sendOthers;
	}


	public final String getState() {
		return state;
	}

	public final void setState(String state) {
		this.state = state;
	}

	public final String getEvaluation() {
		return evaluation;
	}

	public final void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}

	public final String getReturnReason() {
		return returnReason;
	}

	public final void setReturnReason(String returnReason) {
		this.returnReason = returnReason;
	}


	public String getExpressCompany() {
		return expressCompany;
	}


	public void setExpressCompany(String expressCompany) {
		this.expressCompany = expressCompany;
	}


	public String getExpressCode() {
		return expressCode;
	}


	public void setExpressCode(String expressCode) {
		this.expressCode = expressCode;
	}
	
	
}
