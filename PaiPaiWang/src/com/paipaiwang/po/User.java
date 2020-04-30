package com.paipaiwang.po;

public class User {
    private Integer id;

    private String mobiphone;

    private String username;

    private String password;

    private String realname;

    private String idcard;

    private Integer gender;//性别：0女，1男

    private String email;

    private String address;

    private String postcode;

    private String remark;

    private Double userMoney;

    private Boolean freeze;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMobiphone() {
        return mobiphone;
    }

    public void setMobiphone(String mobiphone) {
        this.mobiphone = mobiphone == null ? null : mobiphone.trim();
    }

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

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode == null ? null : postcode.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Double getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(Double userMoney) {
        this.userMoney = userMoney;
    }

    public Boolean getFreeze() {
        return freeze;
    }

    public void setFreeze(Boolean freeze) {
        this.freeze = freeze;
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", mobiphone=" + mobiphone + ", username="
				+ username + ", password=" + password + ", realname="
				+ realname + ", idcard=" + idcard + ", gender=" + gender
				+ ", email=" + email + ", address=" + address + ", postcode="
				+ postcode + ", remark=" + remark + ", userMoney=" + userMoney
				+ ", freeze=" + freeze + "]";
	}
    
    
}