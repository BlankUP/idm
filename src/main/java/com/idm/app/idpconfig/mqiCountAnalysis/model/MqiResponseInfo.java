package com.idm.app.idpconfig.mqiCountAnalysis.model;
import java.io.Serializable;

/**
* <p>Title: ResponseReport</p>  
* @Description: 返回上游结果数据实体类
* @author wangke  
* @date 2019年2月25日
* @version  1.0
 */

public class MqiResponseInfo implements Serializable{

	private static final long serialVersionUID=1L;
	private String responseId ;                   //唯一主键
	private String serialNo;               //业务申请流水号
	private String querySeqNo;      //交易节点流水号
	private String businessNo;       //业务流水号
	private String DeptId;               //组织机构代码
	private String DeptName;       //组织机构名称 
	private String ProductId;    //产品编码
	private String productName;   //产品名称
	private String modelCode;       //模型编码
	private String modelName;     //模型名称
	private String ruleResult;          //结果
	private Double suggestAmount;          //建议额度
	private Double score;          //分数
	private Double loanRate;        //贷款利率
	private String customerType;        //客户所属类型
	private String ratingResults;        //评级结果
	private String returnBack1;          //备用字段1
	private String returnBack2;          //备用字段2
	private String Joint;          //拼接组装
	private String elapsedTime;          //耗时
	private String idType;  
	private String errorCode;             //错误码
	private String errorMsg;              //错误消息
	private String srcDate;                     //业务申请日期

	private String srcTime;							  //业务申请时间
	private String rkDate;                  //入库日期 
	private String rkTime;                 //入库时间
	private String messAge;   
	private String querySystemname;   
	public String getQuerySystemname() {
		return querySystemname;
	}
	public void setQuerySystemname(String querySystemname) {
		this.querySystemname = querySystemname;
	}
	 public String getMessAge() {
		return messAge;
	}
	public void setMessAge(String messAge) {
		this.messAge = messAge;
	}
	private String  cifName;
	 private String cifNo;
	 public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	private String idNo;


     private String productnName;

	 private String queryseqNo;

	 private String requestType;
	 
	private int page;
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
	private int size;
	private int rnm;

	public String getResponseId() {
		return responseId;
	}
	public void setResponseId(String responseId) {
		this.responseId = responseId;
	}
	public String getQuerySeqNo() {
		return querySeqNo;
	}
	public void setQuerySeqNo(String querySeqNo) {
		this.querySeqNo = querySeqNo;
	}
	public String getBusinessNo() {
		return businessNo;
	}
	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
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
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
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
	public String getRuleResult() {
		return ruleResult;
	}
	public void setRuleResult(String ruleResult) {
		this.ruleResult = ruleResult;
	}
	public Double getSuggestAmount() {
		return suggestAmount;
	}
	public void setSuggestAmount(Double suggestAmount) {
		this.suggestAmount = suggestAmount;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public String getReturnBack1() {
		return returnBack1;
	}
	public void setReturnBack1(String returnBack1) {
		this.returnBack1 = returnBack1;
	}
	public String getReturnBack2() {
		return returnBack2;
	}
	public void setReturnBack2(String returnBack2) {
		this.returnBack2 = returnBack2;
	}
	public String getElapsedTime() {
		return elapsedTime;
	}
	public void setElapsedTime(String elapsedTime) {
		this.elapsedTime = elapsedTime;
	}
	public String getJoint() {
		return Joint;
	}
	public void setJoint(String joint) {
		Joint = joint;
	}


	public Double getLoanRate() {
		return loanRate;
	}
	public void setLoanRate(Double loanRate) {
		this.loanRate = loanRate;
	}
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	public String getRatingResults() {
		return ratingResults;
	}
	public void setRatingResults(String ratingResults) {
		this.ratingResults = ratingResults;
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
		ProductId = productId;
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
	public String getIdNo() {
		return idNo;
	}
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	public String getProductnName() {
		return productnName;
	}
	public void setProductnName(String productnName) {
		this.productnName = productnName;
	}
	
	
	
	public String getQueryseqNo() {
		return queryseqNo;
	}
	public void setQueryseqNo(String queryseqNo) {
		this.queryseqNo = queryseqNo;
	}
	public String getRequestType() {
		return requestType;
	}
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	@Override
	public String toString() {
		return "ResponseInfo [responseId=" + responseId + ", serialNo=" + serialNo + ", querySeqNo=" + querySeqNo
				+ ", businessNo=" + businessNo + ", DeptId=" + DeptId + ", DeptName=" + DeptName + ", ProductId="
				+ ProductId + ", productName=" + productName + ", modelCode=" + modelCode + ", modelName=" + modelName
				+ ", ruleResult=" + ruleResult + ", suggestAmount=" + suggestAmount + ", score=" + score + ", loanRate="
				+ loanRate + ", customerType=" + customerType + ", ratingResults=" + ratingResults + ", returnBack1="
				+ returnBack1 + ", returnBack2=" + returnBack2 + ", Joint=" + Joint + ", elapsedTime=" + elapsedTime
				+ ", idType=" + idType + ", errorCode=" + errorCode + ", errorMsg=" + errorMsg + ", srcDate=" + srcDate
				+ ", srcTime=" + srcTime + ", rkDate=" + rkDate + ", rkTime=" + rkTime + ", messAge=" + messAge
				+ ", querySystemname=" + querySystemname + ", cifName=" + cifName + ", cifNo=" + cifNo + ", idNo="
				+ idNo + ", productnName=" + productnName + ", queryseqNo=" + queryseqNo + ", requestType="
				+ requestType + "]";
	}
	

	

}
