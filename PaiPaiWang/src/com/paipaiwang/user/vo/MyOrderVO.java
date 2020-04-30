package com.paipaiwang.user.vo;

public class MyOrderVO {

	private Integer id;
	private String createDate;
	private String opposite;//对方信息
	private String picture;
	private String name;
	private String brief;
	private Double price;
	private Integer number;
	private Integer state;
	private String sendGoodsMessage;//送货信息
	private Boolean evaluate;//是否已经评价（判断是否显示评价按钮）
	private Boolean intervene;//是否已经申请了平台介入，
	private Boolean handledIntervene;//介入申请是否已处理？
	//如果已经存在了申请记录，那么，尚未处理的时候，则显示“正在等待平台介入”
	//已经处理的时候，则由于订单状态已经显示了“平台介入”，无需做其他显示，或者当订单不是“平台介入”，则说明管理员否决了申请，提示用户
	
	public Integer getId() {
		return id;
	}
	public Boolean getHandledIntervene() {
		return handledIntervene;
	}
	public void setHandledIntervene(Boolean handledIntervene) {
		this.handledIntervene = handledIntervene;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	public String getOpposite() {
		return opposite;
	}
	public void setOpposite(String opposite) {
		this.opposite = opposite;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getSendGoodsMessage() {
		return sendGoodsMessage;
	}
	public void setSendGoodsMessage(String sendGoodsMessage) {
		this.sendGoodsMessage = sendGoodsMessage;
	}
	public Boolean getEvaluate() {
		return evaluate;
	}
	public void setEvaluate(Boolean evaluate) {
		this.evaluate = evaluate;
	}
	public Boolean getIntervene() {
		return intervene;
	}
	public void setIntervene(Boolean intervene) {
		this.intervene = intervene;
	}
	
	
}
