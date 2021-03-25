package com.idm.app.system.threadMonitor.model;

import java.io.Serializable;

/** 
* @author: BaiY
* @version 创建时间：2019年4月30日 下午2:54:08 
* 类说明 :线程实体类
*/
public class  ServerInfo implements Serializable {
	
	
private static final long serialVersionUID = 1L;
	
    private String serverId;

    private String name;

    private String ip;

    private String port;

    private String type;

    private String monitor;

    private String f5Url;

    private String serverUrl;

    private String username;

    private String password;

    private String serverDesc;

    private String status;

    private String createDatetime;

    private String createDate;
    
    private String createTime;
    
    private String createUser;
    
    private String updateTime;
    
    private String updateUser;
    
    private String remark;
    
    private int page;			 //第几页
	private int size;		     //每页条数
	private int rnm;
	
	public String getServerId() {
		return serverId;
	}
	public void setServerId(String serverId) {
		this.serverId = serverId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMonitor() {
		return monitor;
	}
	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}
	public String getF5Url() {
		return f5Url;
	}
	public void setF5Url(String f5Url) {
		this.f5Url = f5Url;
	}
	public String getServerUrl() {
		return serverUrl;
	}
	public void setServerUrl(String serverUrl) {
		this.serverUrl = serverUrl;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getServerDesc() {
		return serverDesc;
	}
	public void setServerDesc(String serverDesc) {
		this.serverDesc = serverDesc;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreateDatetime() {
		return createDatetime;
	}
	public void setCreateDatetime(String createDatetime) {
		this.createDatetime = createDatetime;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	@Override
	public String toString() {
		return "ServerInfo [serverId=" + serverId + ", name=" + name + ", ip=" + ip + ", port=" + port + ", type="
				+ type + ", monitor=" + monitor + ", f5Url=" + f5Url + ", serverUrl=" + serverUrl + ", username="
				+ username + ", password=" + password + ", serverDesc=" + serverDesc + ", status=" + status
				+ ", createDatetime=" + createDatetime + ", createDate=" + createDate + ", createTime=" + createTime
				+ ", createUser=" + createUser + ", updateTime=" + updateTime + ", updateUser=" + updateUser
				+ ", remark=" + remark + ", page=" + page + ", size=" + size + ", rnm=" + rnm + "]";
	}
    
	

}
