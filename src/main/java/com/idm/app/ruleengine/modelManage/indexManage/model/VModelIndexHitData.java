package com.idm.app.ruleengine.modelManage.indexManage.model;

import java.io.Serializable;

/**
 * V_MODEL_INDEX_HIT_DATA
 * @author 
 */
public class VModelIndexHitData implements Serializable {
    private String querySeqNo;

    private String certNum;

    private String certType;

    private String custName;

    private String custNo;

    private String ruleId;

    private String ruleName;

    private String fieldValue;

    private String fieldName;

    private String sourceName;

    private String indexName;

    private String prodId;

    private String prodName;

    private String modelId;

    private String modelName;

    private String ruleResult;

    private String refuseReason;

    private String dataTime;

    private static final long serialVersionUID = 1L;

    public String getQuerySeqNo() {
        return querySeqNo;
    }

    public void setQuerySeqNo(String querySeqNo) {
        this.querySeqNo = querySeqNo;
    }

    public String getCertNum() {
        return certNum;
    }

    public void setCertNum(String certNum) {
        this.certNum = certNum;
    }

    public String getCertType() {
        return certType;
    }

    public void setCertType(String certType) {
        this.certType = certType;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

    public String getRuleId() {
        return ruleId;
    }

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getRuleResult() {
        return ruleResult;
    }

    public void setRuleResult(String ruleResult) {
        this.ruleResult = ruleResult;
    }

    public String getRefuseReason() {
        return refuseReason;
    }

    public void setRefuseReason(String refuseReason) {
        this.refuseReason = refuseReason;
    }

    public String getDataTime() {
        return dataTime;
    }

    public void setDataTime(String dataTime) {
        this.dataTime = dataTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        VModelIndexHitData other = (VModelIndexHitData) that;
        return (this.getQuerySeqNo() == null ? other.getQuerySeqNo() == null : this.getQuerySeqNo().equals(other.getQuerySeqNo()))
            && (this.getCertNum() == null ? other.getCertNum() == null : this.getCertNum().equals(other.getCertNum()))
            && (this.getCertType() == null ? other.getCertType() == null : this.getCertType().equals(other.getCertType()))
            && (this.getCustName() == null ? other.getCustName() == null : this.getCustName().equals(other.getCustName()))
            && (this.getCustNo() == null ? other.getCustNo() == null : this.getCustNo().equals(other.getCustNo()))
            && (this.getRuleId() == null ? other.getRuleId() == null : this.getRuleId().equals(other.getRuleId()))
            && (this.getRuleName() == null ? other.getRuleName() == null : this.getRuleName().equals(other.getRuleName()))
            && (this.getFieldValue() == null ? other.getFieldValue() == null : this.getFieldValue().equals(other.getFieldValue()))
            && (this.getFieldName() == null ? other.getFieldName() == null : this.getFieldName().equals(other.getFieldName()))
            && (this.getSourceName() == null ? other.getSourceName() == null : this.getSourceName().equals(other.getSourceName()))
            && (this.getIndexName() == null ? other.getIndexName() == null : this.getIndexName().equals(other.getIndexName()))
            && (this.getProdId() == null ? other.getProdId() == null : this.getProdId().equals(other.getProdId()))
            && (this.getProdName() == null ? other.getProdName() == null : this.getProdName().equals(other.getProdName()))
            && (this.getModelId() == null ? other.getModelId() == null : this.getModelId().equals(other.getModelId()))
            && (this.getModelName() == null ? other.getModelName() == null : this.getModelName().equals(other.getModelName()))
            && (this.getRuleResult() == null ? other.getRuleResult() == null : this.getRuleResult().equals(other.getRuleResult()))
            && (this.getRefuseReason() == null ? other.getRefuseReason() == null : this.getRefuseReason().equals(other.getRefuseReason()))
            && (this.getDataTime() == null ? other.getDataTime() == null : this.getDataTime().equals(other.getDataTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getQuerySeqNo() == null) ? 0 : getQuerySeqNo().hashCode());
        result = prime * result + ((getCertNum() == null) ? 0 : getCertNum().hashCode());
        result = prime * result + ((getCertType() == null) ? 0 : getCertType().hashCode());
        result = prime * result + ((getCustName() == null) ? 0 : getCustName().hashCode());
        result = prime * result + ((getCustNo() == null) ? 0 : getCustNo().hashCode());
        result = prime * result + ((getRuleId() == null) ? 0 : getRuleId().hashCode());
        result = prime * result + ((getRuleName() == null) ? 0 : getRuleName().hashCode());
        result = prime * result + ((getFieldValue() == null) ? 0 : getFieldValue().hashCode());
        result = prime * result + ((getFieldName() == null) ? 0 : getFieldName().hashCode());
        result = prime * result + ((getSourceName() == null) ? 0 : getSourceName().hashCode());
        result = prime * result + ((getIndexName() == null) ? 0 : getIndexName().hashCode());
        result = prime * result + ((getProdId() == null) ? 0 : getProdId().hashCode());
        result = prime * result + ((getProdName() == null) ? 0 : getProdName().hashCode());
        result = prime * result + ((getModelId() == null) ? 0 : getModelId().hashCode());
        result = prime * result + ((getModelName() == null) ? 0 : getModelName().hashCode());
        result = prime * result + ((getRuleResult() == null) ? 0 : getRuleResult().hashCode());
        result = prime * result + ((getRefuseReason() == null) ? 0 : getRefuseReason().hashCode());
        result = prime * result + ((getDataTime() == null) ? 0 : getDataTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", querySeqNo=").append(querySeqNo);
        sb.append(", certNum=").append(certNum);
        sb.append(", certType=").append(certType);
        sb.append(", custName=").append(custName);
        sb.append(", custNo=").append(custNo);
        sb.append(", ruleId=").append(ruleId);
        sb.append(", ruleName=").append(ruleName);
        sb.append(", fieldValue=").append(fieldValue);
        sb.append(", fieldName=").append(fieldName);
        sb.append(", sourceName=").append(sourceName);
        sb.append(", indexName=").append(indexName);
        sb.append(", prodId=").append(prodId);
        sb.append(", prodName=").append(prodName);
        sb.append(", modelId=").append(modelId);
        sb.append(", modelName=").append(modelName);
        sb.append(", ruleResult=").append(ruleResult);
        sb.append(", refuseReason=").append(refuseReason);
        sb.append(", dataTime=").append(dataTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}