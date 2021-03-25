package com.idm.app.apiservice.datasourceManage.externalDatasourceManage.model;

import java.io.Serializable;

/**
 * V_EXTERNAL_DATA
 * @author 
 */
public class VExternalData implements Serializable {
    private String uuid;

    private String querySeqNo;

    private String custName;

    private String certNum;

    private String serviceId;

    private String dataTime;

    private String responseCode;

    private String serviceName;

    private String tableName;

    private static final long serialVersionUID = 1L;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getQuerySeqNo() {
        return querySeqNo;
    }

    public void setQuerySeqNo(String querySeqNo) {
        this.querySeqNo = querySeqNo;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCertNum() {
        return certNum;
    }

    public void setCertNum(String certNum) {
        this.certNum = certNum;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getDataTime() {
        return dataTime;
    }

    public void setDataTime(String dataTime) {
        this.dataTime = dataTime;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
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
        VExternalData other = (VExternalData) that;
        return (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getQuerySeqNo() == null ? other.getQuerySeqNo() == null : this.getQuerySeqNo().equals(other.getQuerySeqNo()))
            && (this.getCustName() == null ? other.getCustName() == null : this.getCustName().equals(other.getCustName()))
            && (this.getCertNum() == null ? other.getCertNum() == null : this.getCertNum().equals(other.getCertNum()))
            && (this.getServiceId() == null ? other.getServiceId() == null : this.getServiceId().equals(other.getServiceId()))
            && (this.getDataTime() == null ? other.getDataTime() == null : this.getDataTime().equals(other.getDataTime()))
            && (this.getResponseCode() == null ? other.getResponseCode() == null : this.getResponseCode().equals(other.getResponseCode()))
            && (this.getServiceName() == null ? other.getServiceName() == null : this.getServiceName().equals(other.getServiceName()))
            && (this.getTableName() == null ? other.getTableName() == null : this.getTableName().equals(other.getTableName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
        result = prime * result + ((getQuerySeqNo() == null) ? 0 : getQuerySeqNo().hashCode());
        result = prime * result + ((getCustName() == null) ? 0 : getCustName().hashCode());
        result = prime * result + ((getCertNum() == null) ? 0 : getCertNum().hashCode());
        result = prime * result + ((getServiceId() == null) ? 0 : getServiceId().hashCode());
        result = prime * result + ((getDataTime() == null) ? 0 : getDataTime().hashCode());
        result = prime * result + ((getResponseCode() == null) ? 0 : getResponseCode().hashCode());
        result = prime * result + ((getServiceName() == null) ? 0 : getServiceName().hashCode());
        result = prime * result + ((getTableName() == null) ? 0 : getTableName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uuid=").append(uuid);
        sb.append(", querySeqNo=").append(querySeqNo);
        sb.append(", custName=").append(custName);
        sb.append(", certNum=").append(certNum);
        sb.append(", serviceId=").append(serviceId);
        sb.append(", dataTime=").append(dataTime);
        sb.append(", responseCode=").append(responseCode);
        sb.append(", serviceName=").append(serviceName);
        sb.append(", tableName=").append(tableName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}