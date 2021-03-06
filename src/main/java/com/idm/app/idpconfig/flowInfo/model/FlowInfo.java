package com.idm.app.idpconfig.flowInfo.model;


public class FlowInfo {

	private String flowId;
	private String key;
	private String value;
	private String flowCode;
	private String flowName;
	private String startModelName;
	private String startModel;
	private String nextModelName;
	private String nextModel;
	private String createTime;
	private String updateTime;
	private String createUser;
	private String updateUser;
	private String status;
	private int page;
	private int size;
	private int rnm;
	public String getFlowId() {
		return flowId;
	}
	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getFlowCode() {
		return flowCode;
	}
	public void setFlowCode(String flowCode) {
		this.flowCode = flowCode;
	}
	public String getFlowName() {
		return flowName;
	}
	public void setFlowName(String flowName) {
		this.flowName = flowName;
	}
	public String getStartModelName() {
		return startModelName;
	}
	public void setStartModelName(String startModelName) {
		this.startModelName = startModelName;
	}
	public String getStartModel() {
		return startModel;
	}
	public void setStartModel(String startModel) {
		this.startModel = startModel;
	}
	public String getNextModelName() {
		return nextModelName;
	}
	public void setNextModelName(String nextModelName) {
		this.nextModelName = nextModelName;
	}
	public String getNextModel() {
		return nextModel;
	}
	public void setNextModel(String nextModel) {
		this.nextModel = nextModel;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
		return "FlowInfo [flowId=" + flowId + ", key=" + key + ", value=" + value + ", flowCode=" + flowCode
				+ ", flowName=" + flowName + ", startModelName=" + startModelName + ", startModel=" + startModel
				+ ", nextModelName=" + nextModelName + ", nextModel=" + nextModel + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + ", createUser=" + createUser + ", updateUser=" + updateUser
				+ ", status=" + status + ", page=" + page + ", size=" + size + ", rnm=" + rnm + "]";
	}
	
	
	
}
