package com.idm.app.ruleengine.statisticanaly.custdimension.mapper;

import com.idm.app.ruleengine.statisticanaly.custdimension.model.CustDimension;
import com.idm.app.ruleengine.statisticanaly.custdimension.model.RiskHit;

import java.util.List;

public interface CustDimensionMapper {

    List<CustDimension> getCustDimension(CustDimension custDimension);

    List<RiskHit> getRiskHit(CustDimension custDimension);
}