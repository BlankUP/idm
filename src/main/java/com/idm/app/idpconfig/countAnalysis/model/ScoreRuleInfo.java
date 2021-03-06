package com.idm.app.idpconfig.countAnalysis.model;

import java.io.Serializable;

/**
 * <p>Description:评分规则信息实体类</p>
 * @author：jiamh
 * @createTime：2019年8月22日
 * @version 1.0
 */
public class ScoreRuleInfo implements Serializable {

	private static final long serialVersionUID = 1932497237535859148L;
	
	private String queryseqNo;  //交易节点流水号
	private String businessNo;  // 业务流水号
	private String cifName;     //姓名
	private String idType;      //证件类型
	private String idNo;        //身份证号
	private String deptId;      //机构编码
	private String deptName;    //机构名称
	private String productId;   //产品编码
	private String productName; //产品名称
	private String modelCode;   //模型编码
	private String modelName;   //模型名称
	private String ruleCode;    //规则编码
	private String ruleName;    //规则名称
	private String ruleResult;  //执行结果
	private String score;       //得分
	private String initializationValue;  //字段初始值
	private String ruleSeverityLevel;  //规则风险等级
	private int page;
    private int size;
    private int rnm;
	
	public String getBusinessNo() {
		return businessNo;
	}
	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}
	public String getQueryseqNo() {
		return queryseqNo;
	}
	public void setQueryseqNo(String queryseqNo) {
		this.queryseqNo = queryseqNo;
	}
	public String getCifName() {
		return cifName;
	}
	public void setCifName(String cifName) {
		this.cifName = cifName;
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
	public String getRuleCode() {
		return ruleCode;
	}
	public void setRuleCode(String ruleCode) {
		this.ruleCode = ruleCode;
	}
	public String getRuleName() {
		return ruleName;
	}
	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}
	public String getRuleResult() {
		return ruleResult;
	}
	public void setRuleResult(String ruleResult) {
		this.ruleResult = ruleResult;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getInitializationValue() {
		return initializationValue;
	}
	public void setInitializationValue(String initializationValue) {
		this.initializationValue = initializationValue;
	}
	public String getRuleSeverityLevel() {
		return ruleSeverityLevel;
	}
	public void setRuleSeverityLevel(String ruleSeverityLevel) {
		this.ruleSeverityLevel = ruleSeverityLevel;
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
