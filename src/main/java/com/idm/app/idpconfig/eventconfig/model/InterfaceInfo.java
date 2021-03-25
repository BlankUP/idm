package com.idm.app.idpconfig.eventconfig.model;


public class InterfaceInfo {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String interfaceId ;
	private String interfaceCode;		//接口编码
	private String interfaceName ;		//接口名称
	private String  parameters ;		//接口参数列表
	private String sysId;    //系统标识
	private String url;   //调用地址
	private String createTime;  //同步时间
	private String status;//有效无效状态
	
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getInterfaceId() {
		return interfaceId;
	}
	public void setInterfaceId(String interfaceId) {
		this.interfaceId = interfaceId;
	}
	public String getInterfaceCode() {
		return interfaceCode;
	}
	public void setInterfaceCode(String interfaceCode) {
		this.interfaceCode = interfaceCode;
	}
	public String getInterfaceName() {
		return interfaceName;
	}
	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}
	public String getParameters() {
		return parameters;
	}
	public void setParameters(String parameters) {
		this.parameters = parameters;
	}
	public String getSysId() {
		return sysId;
	}
	public void setSysId(String sysId) {
		this.sysId = sysId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "InterfaceInfo [interfaceId=" + interfaceId + ", interfaceCode=" + interfaceCode + ", interfaceName="
				+ interfaceName + ", parameters=" + parameters + ", sysId=" + sysId + ", url=" + url + ", createTime="
				+ createTime + "]";
	}
	
	
}
