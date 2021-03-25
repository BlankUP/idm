package com.idm.app.ruleengine.statisticanaly.modeldimension.model;

import java.io.Serializable;
import java.util.Date;

public class ModelDimension implements Serializable {

    private String modelCode; //模型编码
    private String modelName;  //模型名称
    private String riskCode;    //风险代码
    private String riskIndex;  //风险等级
    private String riskLevel;  //风险等级
    private long modelcustomCt; //入模客户总数
    private long indexNullCustomCt; //该指标空置客户数
    private long indexHitCt; //该指标命中客户数
    private String productCode; //产品代码
    private String productName; //产品名称
    private String inputDate;  //入库日期

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

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    public String getRiskIndex() {
        return riskIndex;
    }

    public void setRiskIndex(String riskIndex) {
        this.riskIndex = riskIndex;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public long getModelcustomCt() {
        return modelcustomCt;
    }

    public void setModelcustomCt(long modelcustomCt) {
        this.modelcustomCt = modelcustomCt;
    }

    public long getIndexNullCustomCt() {
        return indexNullCustomCt;
    }

    public void setIndexNullCustomCt(long indexNullCustomCt) {
        this.indexNullCustomCt = indexNullCustomCt;
    }

    public long getIndexHitCt() {
        return indexHitCt;
    }

    public void setIndexHitCt(long indexHitCt) {
        this.indexHitCt = indexHitCt;
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

    public String getInputDate() {
        return inputDate;
    }

    public void setInputDate(String inputDate) {
        this.inputDate = inputDate;
    }
}
