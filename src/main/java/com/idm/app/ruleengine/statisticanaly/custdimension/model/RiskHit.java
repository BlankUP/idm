package com.idm.app.ruleengine.statisticanaly.custdimension.model;

import java.io.Serializable;

public class RiskHit implements Serializable {
    private String riskName; //风险名称
    private long custNum;  //命中客户数

    public String getRiskName() {
        return riskName;
    }

    public void setRiskName(String riskName) {
        this.riskName = riskName;
    }

    public long getCustNum() {
        return custNum;
    }

    public void setCustNum(long custNum) {
        this.custNum = custNum;
    }
}
