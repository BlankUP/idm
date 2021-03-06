package com.idm.app.idpconfig.mqiCountAnalysis.model;

import java.io.Serializable;

public class MqiIdpRequestInfo implements Serializable {

	/**
	 * idp请求信息实体类
	 */
	private static final long serialVersionUID = 1932497237535859148L;
	
	

			 private String requestId;
		 	 private String  serialNo;
			 private String queryseqNo;
			 private String businessNo;
			 private String requestType;
			 private String  cifName;
			 private String cifNo;
			 private String  sex;
	         private String  age;
	         private String  idType;
	         private String idNo;
	         private String  mobilePhone;
	         private String deptId;
	         private String deptName;
	         private String productId;
	         private String productnName;
	         private String modelCode;
	         private String  modelName;
	         private String   querySystemCode;
	         private String querySystemName;
	         private String  respSystemCode;
	         private String  respSystemName;
	         private String  srcDate;
	         private String  srcTime;
	         private String   rkDate;
	         private String     rkTime;
	         private String  rerunFlag;
	         private String   messAge;
	         
		     private int page;
		     private int size;
		     private int rnm;
			public String getRequestId() {
				return requestId;
			}
			public void setRequestId(String requestId) {
				this.requestId = requestId;
			}
			public String getSerialNo() {
				return serialNo;
			}
			public void setSerialNo(String serialNo) {
				this.serialNo = serialNo;
			}
			public String getQueryseqNo() {
				return queryseqNo;
			}
			public void setQueryseqNo(String queryseqNo) {
				this.queryseqNo = queryseqNo;
			}
			public String getBusinessNo() {
				return businessNo;
			}
			public void setBusinessNo(String businessNo) {
				this.businessNo = businessNo;
			}
			public String getRequestType() {
				return requestType;
			}
			public void setRequestType(String requestType) {
				this.requestType = requestType;
			}
			public String getCifName() {
				return cifName;
			}
			public void setCifName(String cifName) {
				this.cifName = cifName;
			}
			public String getCifNo() {
				return cifNo;
			}
			public void setCifNo(String cifNo) {
				this.cifNo = cifNo;
			}
			public String getSex() {
				return sex;
			}
			public void setSex(String sex) {
				this.sex = sex;
			}
			public String getAge() {
				return age;
			}
			public void setAge(String age) {
				this.age = age;
			}
			public String getIdType() {
				return idType;
			}
			public void setIdType(String idType) {
				this.idType = idType;
			}
			public String getIdNo() {
				return idNo;
			}
			public void setIdNo(String idNo) {
				this.idNo = idNo;
			}
			public String getMobilePhone() {
				return mobilePhone;
			}
			public void setMobilePhone(String mobilePhone) {
				this.mobilePhone = mobilePhone;
			}
			public String getDeptId() {
				return deptId;
			}
			public void setDeptId(String deptId) {
				this.deptId = deptId;
			}
			public String getDeptName() {
				return deptName;
			}
			public void setDeptName(String deptName) {
				this.deptName = deptName;
			}
			public String getProductId() {
				return productId;
			}
			public void setProductId(String productId) {
				this.productId = productId;
			}
			public String getProductnName() {
				return productnName;
			}
			public void setProductnName(String productnName) {
				this.productnName = productnName;
			}
			public String getModelCode() {
				return modelCode;
			}
			public void setModelCode(String modelCode) {
				this.modelCode = modelCode;
			}
			public String getModelName() {
				return modelName;
			}
			public void setModelName(String modelName) {
				this.modelName = modelName;
			}
			public String getQuerySystemCode() {
				return querySystemCode;
			}
			public void setQuerySystemCode(String querySystemCode) {
				this.querySystemCode = querySystemCode;
			}
			public String getQuerySystemName() {
				return querySystemName;
			}
			public void setQuerySystemName(String querySystemName) {
				this.querySystemName = querySystemName;
			}
			public String getRespSystemCode() {
				return respSystemCode;
			}
			public void setRespSystemCode(String respSystemCode) {
				this.respSystemCode = respSystemCode;
			}
			public String getRespSystemName() {
				return respSystemName;
			}
			public void setRespSystemName(String respSystemName) {
				this.respSystemName = respSystemName;
			}
			public String getSrcDate() {
				return srcDate;
			}
			public void setSrcDate(String srcDate) {
				this.srcDate = srcDate;
			}
			public String getSrcTime() {
				return srcTime;
			}
			public void setSrcTime(String srcTime) {
				this.srcTime = srcTime;
			}
			public String getRkDate() {
				return rkDate;
			}
			public void setRkDate(String rkDate) {
				this.rkDate = rkDate;
			}
			public String getRkTime() {
				return rkTime;
			}
			public void setRkTime(String rkTime) {
				this.rkTime = rkTime;
			}
			public String getRerunFlag() {
				return rerunFlag;
			}
			public void setRerunFlag(String rerunFlag) {
				this.rerunFlag = rerunFlag;
			}
			public String getMessAge() {
				return messAge;
			}
			public void setMessAge(String messAge) {
				this.messAge = messAge;
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
				return "MqiIdpRequestInfo [requestId=" + requestId + ", serialNo=" + serialNo + ", queryseqNo="
						+ queryseqNo + ", businessNo=" + businessNo + ", requestType=" + requestType + ", cifName="
						+ cifName + ", cifNo=" + cifNo + ", sex=" + sex + ", age=" + age + ", idType=" + idType
						+ ", idNo=" + idNo + ", mobilePhone=" + mobilePhone + ", deptId=" + deptId + ", deptName="
						+ deptName + ", productId=" + productId + ", productnName=" + productnName + ", modelCode="
						+ modelCode + ", modelName=" + modelName + ", querySystemCode=" + querySystemCode
						+ ", querySystemName=" + querySystemName + ", respSystemCode=" + respSystemCode
						+ ", respSystemName=" + respSystemName + ", srcDate=" + srcDate + ", srcTime=" + srcTime
						+ ", rkDate=" + rkDate + ", rkTime=" + rkTime + ", rerunFlag=" + rerunFlag + "]";
			}
	
		     
		     
		     
			
	
	
	
	

}
