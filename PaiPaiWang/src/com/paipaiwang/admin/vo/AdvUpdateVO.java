package com.paipaiwang.admin.vo;

import org.springframework.web.multipart.MultipartFile;

/**
 * 更新广告轮播图请求封装类
 */
public class AdvUpdateVO {
	private Integer id;
	private String title;
	private String url;
	private MultipartFile picture;
	public final Integer getId() {
		return id;
	}
	public final void setId(Integer id) {
		this.id = id;
	}
	public final String getTitle() {
		return title;
	}
	public final void setTitle(String title) {
		this.title = title;
	}
	public final String getUrl() {
		return url;
	}
	public final void setUrl(String url) {
		this.url = url;
	}
	public final MultipartFile getPicture() {
		return picture;
	}
	public final void setPicture(MultipartFile picture) {
		this.picture = picture;
	}
	@Override
	public String toString() {
		return "AdvUpdateVO [id=" + id + ", title=" + title + ", url=" + url
				+ ", picture=" + picture + "]";
	}
	
}
