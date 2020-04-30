package com.paipaiwang.admin.vo;

import com.paipaiwang.po.User;

/**
 * 用户详细信息封装类
 */
public class UserDetailVO {
	private User user;
	private Integer published;
	private Integer bought;
	private Double freeze;
	@Override
	public String toString() {
		return "UserDetailVO [user=" + user + ", published=" + published
				+ ", bought=" + bought + ", freeze=" + freeze + "]";
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getPublished() {
		return published;
	}
	public void setPublished(Integer published) {
		this.published = published;
	}
	public Integer getBought() {
		return bought;
	}
	public void setBought(Integer bought) {
		this.bought = bought;
	}
	public Double getFreeze() {
		return freeze;
	}
	public void setFreeze(Double freeze) {
		this.freeze = freeze;
	}
	
	
	
}
