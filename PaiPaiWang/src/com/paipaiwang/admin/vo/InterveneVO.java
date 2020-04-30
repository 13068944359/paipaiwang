package com.paipaiwang.admin.vo;

import java.util.Date;

/**
 * 申请介入详细信息封装
 */
public class InterveneVO {
	private OrderDetailVO orderDetailVO;
	private String forWhat;
	private String forWhy;
	private Double freezeMoney;//目前订单上冻结的资金
	private Integer interveneId;
	
	public Double getFreezeMoney() {
		return freezeMoney;
	}
	public void setFreezeMoney(Double freezeMoney) {
		this.freezeMoney = freezeMoney;
	}
	public OrderDetailVO getOrderDetailVO() {
		return orderDetailVO;
	}
	public void setOrderDetailVO(OrderDetailVO orderDetailVO) {
		this.orderDetailVO = orderDetailVO;
	}
	public String getForWhat() {
		return forWhat;
	}
	public void setForWhat(String forWhat) {
		this.forWhat = forWhat;
	}
	public String getForWhy() {
		return forWhy;
	}
	public void setForWhy(String forWhy) {
		this.forWhy = forWhy;
	}
	public Integer getInterveneId() {
		return interveneId;
	}
	public void setInterveneId(Integer interveneId) {
		this.interveneId = interveneId;
	}
	
	@Override
	public String toString() {
		return "InterveneVO [orderDetailVO=" + orderDetailVO + ", forWhat="
				+ forWhat + ", forWhy=" + forWhy + ", interveneId="
				+ interveneId + "]";
	}
	
	
}
