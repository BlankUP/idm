package com.idm.app.ruleengine.statisticanaly.creditdetail.model;

import java.io.Serializable;

public class CreditAmountInfo implements Serializable {


    private String baseAmount; //基础额度

    private String assetAmount; //资产额度

    private String salaryAmount; //工资额度

    private String amountFactory; //额度系数

    private String creditAmount;  //授信额度

    private String adjustAmount;  //额度调整

    private String whiteFlag;  //是否行内白名单客户 Y-是，N-否

    public String getBaseAmount() {
        return baseAmount;
    }

    public void setBaseAmount(String baseAmount) {
        this.baseAmount = baseAmount;
    }

    public String getAssetAmount() {
        return assetAmount;
    }

    public void setAssetAmount(String assetAmount) {
        this.assetAmount = assetAmount;
    }

    public String getSalaryAmount() {
        return salaryAmount;
    }

    public void setSalaryAmount(String salaryAmount) {
        this.salaryAmount = salaryAmount;
    }

    public String getAmountFactory() {
        return amountFactory;
    }

    public void setAmountFactory(String amountFactory) {
        this.amountFactory = amountFactory;
    }

    public String getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(String creditAmount) {
        this.creditAmount = creditAmount;
    }

    public String getAdjustAmount() {
        return adjustAmount;
    }

    public void setAdjustAmount(String adjustAmount) {
        this.adjustAmount = adjustAmount;
    }

    public String getWhiteFlag() {
        return whiteFlag;
    }

    public void setWhiteFlag(String whiteFlag) {
        this.whiteFlag = whiteFlag;
    }
}
