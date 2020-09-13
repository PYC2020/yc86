package com.yc.damai.bean;

import java.util.List;

public class DmCategory {
    private Integer id;

    private String cname;

    private Integer pid;

    public Integer getId() {
        return id;
    }
    //当前分类的子类
    private List<DmCategory>Children;
    
    public List<DmCategory> getChildren() {
		return Children;
	}

	public void setChildren(List<DmCategory> children) {
		this.Children = children;
	}

	public void setId(Integer id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

	@Override
	public String toString() {
		return "DmCategory [id=" + id + ", cname=" + cname + ", pid=" + pid + ", Children=" + Children + "]";
	}

	
	

	
    
}