package com.paipaiwang.po;

import java.util.Date;

public class Order {
	private Integer id;

    private Integer userId;

    private Double price;

    private Date createDate;

    private Date finishTime;

    private String sendName;

    private String sendPhone;

    private String sendAddress;

    private String sendPostcode;

    private String sendOthers;

    private String remark;

    private Integer state;

    private Boolean evaluate;

    private String evaluation;

    private String returnReason;

    private Date lastStateTime;

    private String expressCompany;

    private String expressId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public String getSendName() {
        return sendName;
    }

    public void setSendName(String sendName) {
        this.sendName = sendName == null ? null : sendName.trim();
    }

    public String getSendPhone() {
        return sendPhone;
    }

    public void setSendPhone(String sendPhone) {
        this.sendPhone = sendPhone == null ? null : sendPhone.trim();
    }

    public String getSendAddress() {
        return sendAddress;
    }

    public void setSendAddress(String sendAddress) {
        this.sendAddress = sendAddress == null ? null : sendAddress.trim();
    }

    public String getSendPostcode() {
        return sendPostcode;
    }

    public void setSendPostcode(String sendPostcode) {
        this.sendPostcode = sendPostcode == null ? null : sendPostcode.trim();
    }

    public String getSendOthers() {
        return sendOthers;
    }

    public void setSendOthers(String sendOthers) {
        this.sendOthers = sendOthers == null ? null : sendOthers.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Boolean getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(Boolean evaluate) {
        this.evaluate = evaluate;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation == null ? null : evaluation.trim();
    }

    public String getReturnReason() {
        return returnReason;
    }

    public void setReturnReason(String returnReason) {
        this.returnReason = returnReason == null ? null : returnReason.trim();
    }

    public Date getLastStateTime() {
        return lastStateTime;
    }

    public void setLastStateTime(Date lastStateTime) {
        this.lastStateTime = lastStateTime;
    }

    public String getExpressCompany() {
        return expressCompany;
    }

    public void setExpressCompany(String expressCompany) {
        this.expressCompany = expressCompany == null ? null : expressCompany.trim();
    }

    public String getExpressId() {
        return expressId;
    }

    public void setExpressId(String expressId) {
        this.expressId = expressId == null ? null : expressId.trim();
    }
    


	@Override
	public String toString() {
		return "Order [id=" + id + ", userId=" + userId + ", price=" + price
				+ ", createDate=" + createDate + ", finishTime=" + finishTime
				+ ", sendName=" + sendName + ", sendPhone=" + sendPhone
				+ ", sendAddress=" + sendAddress + ", sendPostcode="
				+ sendPostcode + ", sendOthers=" + sendOthers + ", remark="
				+ remark + ", state=" + state + ", evaluate=" + evaluate
				+ ", evaluation=" + evaluation + ", returnReason="
				+ returnReason + ", lastStateTime=" + lastStateTime
				+ ", expressCompany=" + expressCompany + ", expressId="
				+ expressId + "]";
	}



	public final static int UNPAIED = 0;//未付款
	public final static int PAIED = 1;//已付款，待发货
	public final static int SENT = 2;//已发货
	public final static int SUCCESS = 3;//交易成功
	public final static int ASK_RETURN = 4;//申请退货
	public final static int RETURNED = 5;//已退货
	public final static int BUY_CANCEL = 6;//买家取消订单
	public final static int SELL_CANCEL = 7;//卖家取消订单
	public final static int INTERVENED = 8;//平台已介入
}