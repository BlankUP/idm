package com.idm.app.ruleengine.exceptionManage.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * ERRORMESSAGE
 * @author 
 */
public class ErrorMessage implements Serializable {
    private String queryseqno;

    private String idnumber;

    private String errorcode;

    private String errortype;

    private String errormessage;

    private String errorstatus;

    @JSONField(format="yyyy-MM-dd")
    private Date createtime;

    private String uuid;

    private static final long serialVersionUID = 1L;

    public String getQueryseqno() {
        return queryseqno;
    }

    public void setQueryseqno(String queryseqno) {
        this.queryseqno = queryseqno;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public String getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(String errorcode) {
        this.errorcode = errorcode;
    }

    public String getErrortype() {
        return errortype;
    }

    public void setErrortype(String errortype) {
        this.errortype = errortype;
    }

    public String getErrormessage() {
        return errormessage;
    }

    public void setErrormessage(String errormessage) {
        this.errormessage = errormessage;
    }

    public String getErrorstatus() {
        return errorstatus;
    }

    public void setErrorstatus(String errorstatus) {
        this.errorstatus = errorstatus;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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
        ErrorMessage other = (ErrorMessage) that;
        return (this.getQueryseqno() == null ? other.getQueryseqno() == null : this.getQueryseqno().equals(other.getQueryseqno()))
            && (this.getIdnumber() == null ? other.getIdnumber() == null : this.getIdnumber().equals(other.getIdnumber()))
            && (this.getErrorcode() == null ? other.getErrorcode() == null : this.getErrorcode().equals(other.getErrorcode()))
            && (this.getErrortype() == null ? other.getErrortype() == null : this.getErrortype().equals(other.getErrortype()))
            && (this.getErrormessage() == null ? other.getErrormessage() == null : this.getErrormessage().equals(other.getErrormessage()))
            && (this.getErrorstatus() == null ? other.getErrorstatus() == null : this.getErrorstatus().equals(other.getErrorstatus()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getQueryseqno() == null) ? 0 : getQueryseqno().hashCode());
        result = prime * result + ((getIdnumber() == null) ? 0 : getIdnumber().hashCode());
        result = prime * result + ((getErrorcode() == null) ? 0 : getErrorcode().hashCode());
        result = prime * result + ((getErrortype() == null) ? 0 : getErrortype().hashCode());
        result = prime * result + ((getErrormessage() == null) ? 0 : getErrormessage().hashCode());
        result = prime * result + ((getErrorstatus() == null) ? 0 : getErrorstatus().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", queryseqno=").append(queryseqno);
        sb.append(", idnumber=").append(idnumber);
        sb.append(", errorcode=").append(errorcode);
        sb.append(", errortype=").append(errortype);
        sb.append(", errormessage=").append(errormessage);
        sb.append(", errorstatus=").append(errorstatus);
        sb.append(", createtime=").append(createtime);
        sb.append(", uuid=").append(uuid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}