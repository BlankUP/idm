package com.idm.app.ruleengine.modelManage.modelMonitor.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * V_SCORE_MODEL_DETAIL
 * @author 
 */
public class VScoreModelDetail implements Serializable {
    private String indexName;

    private BigDecimal indexScore;

    private BigDecimal indexPercent;

    private Date dataTime;

    private String modelName;

    private String modelId;

    private String querySeqNo;

    private String prodId;

    private String prodName;

    private static final long serialVersionUID = 1L;

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    public BigDecimal getIndexScore() {
        return indexScore;
    }

    public void setIndexScore(BigDecimal indexScore) {
        this.indexScore = indexScore;
    }

    public BigDecimal getIndexPercent() {
        return indexPercent;
    }

    public void setIndexPercent(BigDecimal indexPercent) {
        this.indexPercent = indexPercent;
    }

    public Date getDataTime() {
        return dataTime;
    }

    public void setDataTime(Date dataTime) {
        this.dataTime = dataTime;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getQuerySeqNo() {
        return querySeqNo;
    }

    public void setQuerySeqNo(String querySeqNo) {
        this.querySeqNo = querySeqNo;
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
        VScoreModelDetail other = (VScoreModelDetail) that;
        return (this.getIndexName() == null ? other.getIndexName() == null : this.getIndexName().equals(other.getIndexName()))
            && (this.getIndexScore() == null ? other.getIndexScore() == null : this.getIndexScore().equals(other.getIndexScore()))
            && (this.getIndexPercent() == null ? other.getIndexPercent() == null : this.getIndexPercent().equals(other.getIndexPercent()))
            && (this.getDataTime() == null ? other.getDataTime() == null : this.getDataTime().equals(other.getDataTime()))
            && (this.getModelName() == null ? other.getModelName() == null : this.getModelName().equals(other.getModelName()))
            && (this.getModelId() == null ? other.getModelId() == null : this.getModelId().equals(other.getModelId()))
            && (this.getQuerySeqNo() == null ? other.getQuerySeqNo() == null : this.getQuerySeqNo().equals(other.getQuerySeqNo()))
            && (this.getProdId() == null ? other.getProdId() == null : this.getProdId().equals(other.getProdId()))
            && (this.getProdName() == null ? other.getProdName() == null : this.getProdName().equals(other.getProdName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIndexName() == null) ? 0 : getIndexName().hashCode());
        result = prime * result + ((getIndexScore() == null) ? 0 : getIndexScore().hashCode());
        result = prime * result + ((getIndexPercent() == null) ? 0 : getIndexPercent().hashCode());
        result = prime * result + ((getDataTime() == null) ? 0 : getDataTime().hashCode());
        result = prime * result + ((getModelName() == null) ? 0 : getModelName().hashCode());
        result = prime * result + ((getModelId() == null) ? 0 : getModelId().hashCode());
        result = prime * result + ((getQuerySeqNo() == null) ? 0 : getQuerySeqNo().hashCode());
        result = prime * result + ((getProdId() == null) ? 0 : getProdId().hashCode());
        result = prime * result + ((getProdName() == null) ? 0 : getProdName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", indexName=").append(indexName);
        sb.append(", indexScore=").append(indexScore);
        sb.append(", indexPercent=").append(indexPercent);
        sb.append(", dataTime=").append(dataTime);
        sb.append(", modelName=").append(modelName);
        sb.append(", modelId=").append(modelId);
        sb.append(", querySeqNo=").append(querySeqNo);
        sb.append(", prodId=").append(prodId);
        sb.append(", prodName=").append(prodName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}