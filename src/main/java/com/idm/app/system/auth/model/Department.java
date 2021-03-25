package com.idm.app.system.auth.model;

import java.io.Serializable;

public class Department implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String depNo;
	private String depName;
	private String depDesc;
	private String depStatus;
	private String createTime;
	private String updateTime;
	private String createUser;
	private String updateUser;

	public String getdepNo() {
		return depNo;
	}
	public void setdepNo(String depNo) {
		this.depNo = depNo;
	}
	public String getdepName() {
		return depName;
	}
	public void setdepName(String depName) {
		this.depName = depName;
	}
	public String getdepDesc() {
		return depDesc;
	}
	public void setdepDesc(String depDesc) {
		this.depDesc = depDesc;
	}
	public String getdepStatus() {
		return depStatus;
	}
	public void setdepStatus(String depStatus) {
		this.depStatus = depStatus;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
}
