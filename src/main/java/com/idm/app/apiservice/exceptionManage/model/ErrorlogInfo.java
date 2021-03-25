package com.idm.app.apiservice.exceptionManage.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * FD_ERRORLOG_INFO
 * @author 
 */
public class ErrorlogInfo implements Serializable {
    private String querySeq;

    private String custId;

    private String errorCode;

    private String errorType;

    private String errorMessage;

    private String errorStatus;

    @JSONField(format="yyyy-MM-dd")
    private Date createTime;

    private String errorDetails;

    private static final long serialVersionUID = 1L;

    public String getQuerySeq() {
        return querySeq;
    }

    public void setQuerySeq(String querySeq) {
        this.querySeq = querySeq;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorStatus() {
        return errorStatus;
    }

    public void setErrorStatus(String errorStatus) {
        this.errorStatus = errorStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getErrorDetails() {
        return errorDetails;
    }

    public void setErrorDetails(String errorDetails) {
        this.errorDetails = errorDetails;
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
        ErrorlogInfo other = (ErrorlogInfo) that;
        return (this.getQuerySeq() == null ? other.getQuerySeq() == null : this.getQuerySeq().equals(other.getQuerySeq()))
            && (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
            && (this.getErrorCode() == null ? other.getErrorCode() == null : this.getErrorCode().equals(other.getErrorCode()))
            && (this.getErrorType() == null ? other.getErrorType() == null : this.getErrorType().equals(other.getErrorType()))
            && (this.getErrorMessage() == null ? other.getErrorMessage() == null : this.getErrorMessage().equals(other.getErrorMessage()))
            && (this.getErrorStatus() == null ? other.getErrorStatus() == null : this.getErrorStatus().equals(other.getErrorStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getErrorDetails() == null ? other.getErrorDetails() == null : this.getErrorDetails().equals(other.getErrorDetails()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getQuerySeq() == null) ? 0 : getQuerySeq().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getErrorCode() == null) ? 0 : getErrorCode().hashCode());
        result = prime * result + ((getErrorType() == null) ? 0 : getErrorType().hashCode());
        result = prime * result + ((getErrorMessage() == null) ? 0 : getErrorMessage().hashCode());
        result = prime * result + ((getErrorStatus() == null) ? 0 : getErrorStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getErrorDetails() == null) ? 0 : getErrorDetails().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", querySeq=").append(querySeq);
        sb.append(", custId=").append(custId);
        sb.append(", errorCode=").append(errorCode);
        sb.append(", errorType=").append(errorType);
        sb.append(", errorMessage=").append(errorMessage);
        sb.append(", errorStatus=").append(errorStatus);
        sb.append(", createTime=").append(createTime);
        sb.append(", errorDetails=").append(errorDetails);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}