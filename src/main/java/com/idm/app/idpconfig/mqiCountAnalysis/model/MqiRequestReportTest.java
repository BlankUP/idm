package com.idm.app.idpconfig.mqiCountAnalysis.model;

import java.io.Serializable;


/**  
* <p>Title: RequestReportTest</p>  
* @Description: 模型质检请求参数实体类
* @author wangke  
* @date 2019年7月22日
* @version  1.0
* 
*/ 

public class MqiRequestReportTest  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String reqId;         //唯一主键
   private String message;         //完整请求报文
   private String serialNo;         //总流程编号
   private String businessNo;         //业务流水号
   private String rkDate;         //请求日期
   private String rkTime;         //请求时间
   private String modelCode;   //模型编码
   private String flowCode;   //流程编码
   private String modelType;   //模型类型
   private String pmmlCode;//pmml编码
   private String CifName;         //客户姓名
	private String CifNo;              //客户编号
	private String IdType;        //证件类型
	private String IdNo;     //证件号码
	private String Sex;
	private String age;
	private String MobilePhone;
	private String DeptId;      //组织机构代码
	private String DeptName;   //组织机构名称
	private String ProductId;     //产品编码
	private String productName;   //产品名称
	private String JnlNo;   //贷款号
    private int page;
    private int size;
    private int rnm;
public String getReqId() {
	return reqId;
}
public void setReqId(String reqId) {
	this.reqId = reqId;
}

public String getJnlNo() {
	return JnlNo;
}
public void setJnlNo(String jnlNo) {
	JnlNo = jnlNo;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public String getSerialNo() {
	return serialNo;
}
public void setSerialNo(String serialNo) {
	this.serialNo = serialNo;
}
public String getBusinessNo() {
	return businessNo;
}
public void setBusinessNo(String businessNo) {
	this.businessNo = businessNo;
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
public String getModelCode() {
	return modelCode;
}
public void setModelCode(String modelCode) {
	this.modelCode = modelCode;
}
public String getFlowCode() {
	return flowCode;
}
public void setFlowCode(String flowCode) {
	this.flowCode = flowCode;
}
public String getModelType() {
	return modelType;
}
public void setModelType(String modelType) {
	this.modelType = modelType;
}
public String getPmmlCode() {
	return pmmlCode;
}
public void setPmmlCode(String pmmlCode) {
	this.pmmlCode = pmmlCode;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}
public String getCifName() {
	return CifName;
}
public void setCifName(String cifName) {
	CifName = cifName;
}
public String getCifNo() {
	return CifNo;
}
public void setCifNo(String cifNo) {
	CifNo = cifNo;
}
public String getIdType() {
	return IdType;
}
public void setIdType(String idType) {
	IdType = idType;
}
public String getIdNo() {
	return IdNo;
}
public void setIdNo(String idNo) {
	IdNo = idNo;
}
public String getSex() {
	return Sex;
}
public void setSex(String sex) {
	Sex = sex;
}
public String getAge() {
	return age;
}
public void setAge(String age) {
	this.age = age;
}
public String getMobilePhone() {
	return MobilePhone;
}
public void setMobilePhone(String mobilePhone) {
	MobilePhone = mobilePhone;
}
public String getDeptId() {
	return DeptId;
}
public void setDeptId(String deptId) {
	DeptId = deptId;
}
public String getDeptName() {
	return DeptName;
}
public void setDeptName(String deptName) {
	DeptName = deptName;
}
public String getProductId() {
	return ProductId;
}
public void setProductId(String productId) {
	this.ProductId = productId;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
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
	return "MqiRequestReportTest [reqId=" + reqId + ", serialNo=" + serialNo + ", businessNo=" + businessNo
			+ ", rkDate=" + rkDate + ", rkTime=" + rkTime + ", modelCode=" + modelCode + ", flowCode=" + flowCode
			+ ", modelType=" + modelType + ", pmmlCode=" + pmmlCode + ", CifName=" + CifName + ", CifNo=" + CifNo
			+ ", IdType=" + IdType + ", IdNo=" + IdNo + ", Sex=" + Sex + ", age=" + age + ", MobilePhone=" + MobilePhone
			+ ", DeptId=" + DeptId + ", DeptName=" + DeptName + ", ProductId=" + ProductId + ", productName="
			+ productName + "]";
}


   
}
