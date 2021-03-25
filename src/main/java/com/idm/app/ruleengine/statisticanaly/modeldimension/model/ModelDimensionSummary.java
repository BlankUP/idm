package com.idm.app.ruleengine.statisticanaly.modeldimension.model;

import java.io.Serializable;

public class ModelDimensionSummary implements Serializable {

    private String modelName;
    private String modelCode;
    private long entryModeCt; //入模客户数
    private long indexHitCt; //命中指标客户数
    private String productCode; //产品码
    private String productName; //产品名称
    private String inputDate;

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    public long getEntryModeCt() {
        return entryModeCt;
    }

    public void setEntryModeCt(long entryModeCt) {
        this.entryModeCt = entryModeCt;
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
