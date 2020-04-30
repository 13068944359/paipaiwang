package com.paipaiwang.po;

public class Type {
    private Integer id;

    private String name;

    private Integer parent;

    private String remark;

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
    

    public Type(Integer id, String name, Integer parent, String remark) {
		super();
		this.id = id;
		this.name = name;
		this.parent = parent;
		this.remark = remark;
	}

	public Type() {
		super();
		// TODO Auto-generated constructor stub
	}

}