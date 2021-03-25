package com.idm.app.idpconfig.bom.model;

import java.io.Serializable;

public class BomInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String bomId ;
	private String bomVersionNo ;
	private String versionName ;
	private String versionDepiction ;
	private String status;
	private String createTime;
	private String updateTime;
	private String createUser;
	private String updateUser;
	private String fileId;
	private int page;
	private int size;
	private int rnm;
	
	
	public String getBomId() {
		return bomId;
	}
	public void setBomId(String bomId) {
		this.bomId = bomId;
	}
	public String getBomVersionNo() {
		return bomVersionNo;
	}
	public void setBomVersionNo(String bomVersionNo) {
		this.bomVersionNo = bomVersionNo;
	}
	public String getVersionDepiction() {
		return versionDepiction;
	}
	public void setVersionDepiction(String versionDepiction) {
		this.versionDepiction = versionDepiction;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public String getFileId() {
		return fileId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	public String getVersionName() {
		return versionName;
	}
	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getRnm() {
		return rnm;
	}
	public void setRnm(int rnm) {
		this.rnm = rnm;
	}
	
	
	
}