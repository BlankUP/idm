package com.idm.app.ruleengine.statisticanaly.modeldimension.model;

import java.io.Serializable;

public class ModelHit implements Serializable {

    private String modelName;
    private long custNum;

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public long getCustNum() {
        return custNum;
    }

    public void setCustNum(long custNum) {
        this.custNum = custNum;
    }
}
