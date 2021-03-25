package com.idm.app.apiservice.datasourceManage.onlineLoanDataManage.model;

import java.io.Serializable;

/**
 * V_OL_REQUEST_DATA
 * @author 
 */
public class OLRequestParam implements Serializable {
    private String serverCode;

    private String querySeqNo;

    private String querySystemCode;

    private String custNo;

    private String userName;

    private String idType;

    private String idNumber;

    private String phoneNo;

    private String productCode;

    private String productName;

    private String authorizationCode;

    private String createTime;

    private String localSeqNo;

    private static final long serialVersionUID = 1L;

    public String getServerCode() {
        return serverCode;
    }

    public void setServerCode(String serverCode) {
        this.serverCode = serverCode;
    }

    public String getQuerySeqNo() {
        return querySeqNo;
    }

    public void setQuerySeqNo(String querySeqNo) {
        this.querySeqNo = querySeqNo;
    }

    public String getQuerySystemCode() {
        return querySystemCode;
    }

    public void setQuerySystemCode(String querySystemCode) {
        this.querySystemCode = querySystemCode;
    }

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getAuthorizationCode() {
        return authorizationCode;
    }

    public void setAuthorizationCode(String authorizationCode) {
        this.authorizationCode = authorizationCode;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getLocalSeqNo() {
        return localSeqNo;
    }

    public void setLocalSeqNo(String localSeqNo) {
        this.localSeqNo = localSeqNo;
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
        OLRequestParam other = (OLRequestParam) that;
        return (this.getServerCode() == null ? other.getServerCode() == null : this.getServerCode().equals(other.getServerCode()))
            && (this.getQuerySeqNo() == null ? other.getQuerySeqNo() == null : this.getQuerySeqNo().equals(other.getQuerySeqNo()))
            && (this.getQuerySystemCode() == null ? other.getQuerySystemCode() == null : this.getQuerySystemCode().equals(other.getQuerySystemCode()))
            && (this.getCustNo() == null ? other.getCustNo() == null : this.getCustNo().equals(other.getCustNo()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getIdType() == null ? other.getIdType() == null : this.getIdType().equals(other.getIdType()))
            && (this.getIdNumber() == null ? other.getIdNumber() == null : this.getIdNumber().equals(other.getIdNumber()))
            && (this.getPhoneNo() == null ? other.getPhoneNo() == null : this.getPhoneNo().equals(other.getPhoneNo()))
            && (this.getProductCode() == null ? other.getProductCode() == null : this.getProductCode().equals(other.getProductCode()))
            && (this.getProductName() == null ? other.getProductName() == null : this.getProductName().equals(other.getProductName()))
            && (this.getAuthorizationCode() == null ? other.getAuthorizationCode() == null : this.getAuthorizationCode().equals(other.getAuthorizationCode()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLocalSeqNo() == null ? other.getLocalSeqNo() == null : this.getLocalSeqNo().equals(other.getLocalSeqNo()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getServerCode() == null) ? 0 : getServerCode().hashCode());
        result = prime * result + ((getQuerySeqNo() == null) ? 0 : getQuerySeqNo().hashCode());
        result = prime * result + ((getQuerySystemCode() == null) ? 0 : getQuerySystemCode().hashCode());
        result = prime * result + ((getCustNo() == null) ? 0 : getCustNo().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getIdType() == null) ? 0 : getIdType().hashCode());
        result = prime * result + ((getIdNumber() == null) ? 0 : getIdNumber().hashCode());
        result = prime * result + ((getPhoneNo() == null) ? 0 : getPhoneNo().hashCode());
        result = prime * result + ((getProductCode() == null) ? 0 : getProductCode().hashCode());
        result = prime * result + ((getProductName() == null) ? 0 : getProductName().hashCode());
        result = prime * result + ((getAuthorizationCode() == null) ? 0 : getAuthorizationCode().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getLocalSeqNo() == null) ? 0 : getLocalSeqNo().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serverCode=").append(serverCode);
        sb.append(", querySeqNo=").append(querySeqNo);
        sb.append(", querySystemCode=").append(querySystemCode);
        sb.append(", custNo=").append(custNo);
        sb.append(", userName=").append(userName);
        sb.append(", idType=").append(idType);
        sb.append(", idNumber=").append(idNumber);
        sb.append(", phoneNo=").append(phoneNo);
        sb.append(", productCode=").append(productCode);
        sb.append(", productName=").append(productName);
        sb.append(", authorizationCode=").append(authorizationCode);
        sb.append(", createTime=").append(createTime);
        sb.append(", localSeqNo=").append(localSeqNo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}