package com.paipaiwang.po;

import java.util.Date;

public class Intervene {
    private Integer id;
    private Boolean type;
    private Integer orderId;
    private String forWhat;
    private String forWhy;
    private Boolean state;
    private String remark;
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getForWhat() {
        return forWhat;
    }

    public void setForWhat(String forWhat) {
        this.forWhat = forWhat == null ? null : forWhat.trim();
    }

    public String getForWhy() {
        return forWhy;
    }

    public void setForWhy(String forWhy) {
        this.forWhy = forWhy == null ? null : forWhy.trim();
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    
    
    @Override
	public String toString() {
		return "Intervene [id=" + id + ", type=" + type + ", orderId="
				+ orderId + ", forWhat=" + forWhat + ", forWhy=" + forWhy
				+ ", state=" + state + ", remark=" + remark + ", createTime="
				+ createTime + "]";
	}



	public final static boolean BUYER_REQUEST = true;
    public final static boolean SELLER_REQUEST = false;
    
    public final static boolean OK = true;//已经处理
    public final static boolean NO = false;//尚未处理
}