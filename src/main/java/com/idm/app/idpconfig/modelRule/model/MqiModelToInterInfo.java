package com.idm.app.idpconfig.modelRule.model;

import java.io.Serializable;

public class MqiModelToInterInfo implements Serializable{
	/**
	 * 接口拆分结果
	 */
	private static final long serialVersionUID = 239003687000465659L;
	
	private String reId;
	private String businessNo;   //流水号
	private String interfaceCode;   //接口名
	private String interfaceName;  
	private String interField;        //接口字段
	private String interValue;   //对应字段值
	public String getReId() {
		return reId;
	}
	public void setReId(String reId) {
		this.reId = reId;
	}
	public String getBusinessNo() {
		return businessNo;
	}
	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
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
	public String getInterField() {
		return interField;
	}
	public void setInterField(String interField) {
		this.interField = interField;
	}
	public String getInterValue() {
		return interValue;
	}
	public void setInterValue(String interValue) {
		this.interValue = interValue;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "MqiModelToInterInfo [reId=" + reId + ", businessNo=" + businessNo + ", interfaceCode=" + interfaceCode
				+ ", interfaceName=" + interfaceName + ", interField=" + interField + ", interValue=" + interValue
				+ "]";
	}
	
}
