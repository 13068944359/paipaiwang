package com.paipaiwang.po;

import java.io.Serializable;
import java.util.Date;

public class Admin implements Serializable{
    private String username;

    private String password;

    private Boolean superUser;

    private String remark;

    private Date createTime;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Boolean getSuperUser() {
        return superUser;
    }

    public void setSuperUser(Boolean superUser) {
        this.superUser = superUser;
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
		return "Admin [username=" + username + ", password=" + password
				+ ", superUser=" + superUser + ", remark=" + remark
				+ ", createTime=" + createTime + "]";
	}
    
}