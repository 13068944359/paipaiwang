package com.paipaiwang.admin.vo;

/**
 * 申请介入的列表信息封装类
 */
public class InterveneListVO {

	private String itemId;
	private String seller;
	private String buyer;
	private String requestType;
	private Double price;
	private String finishTime;
	private String requestTime;
	private Integer interveneId;
	private Boolean handled;
	
	
	public Boolean getHandled() {
		return handled;
	}
	public void setHandled(Boolean handled) {
		this.handled = handled;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	public String getRequestType() {
		return requestType;
	}
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(String finishTime) {
		this.finishTime = finishTime;
	}
	public String getRequestTime() {
		return requestTime;
	}
	public void setRequestTime(String requestTime) {
		this.requestTime = requestTime;
	}
	public Integer getInterveneId() {
		return interveneId;
	}
	public void setInterveneId(Integer interveneId) {
		this.interveneId = interveneId;
	}
	@Override
	public String toString() {
		return "InterveneListVO [itemId=" + itemId + ", seller=" + seller
				+ ", buyer=" + buyer + ", requestType=" + requestType
				+ ", price=" + price + ", finishTime=" + finishTime
				+ ", requestTime=" + requestTime + ", interveneId="
				+ interveneId + ", handled=" + handled + "]";
	}
	
}
