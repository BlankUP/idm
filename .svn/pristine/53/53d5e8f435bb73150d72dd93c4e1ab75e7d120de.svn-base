package com.idm.app.ruleengine.statisticanaly.custdimension.service;

import com.idm.app.ruleengine.statisticanaly.custdimension.mapper.CustDimensionMapper;
import com.idm.app.ruleengine.statisticanaly.custdimension.model.CustDimension;
import com.idm.app.ruleengine.statisticanaly.custdimension.model.RiskHit;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class CustDimensionService {

    @Resource
    CustDimensionMapper custDimensionMapper;

    public List<CustDimension> queryCustDimension(CustDimension modelDimension)
    {
        return custDimensionMapper.getCustDimension(modelDimension);
    }

    public List<RiskHit> queryRiskHit(CustDimension custDimension)
    {
        return custDimensionMapper.getRiskHit(custDimension);
    }
}
