package com.idm.app.ruleengine.statisticanaly.modeldimension.service;
import com.idm.app.ruleengine.statisticanaly.modeldimension.mapper.StatisticAnalyMapper;
import com.idm.app.ruleengine.statisticanaly.modeldimension.model.ModelDimension;
import com.idm.app.ruleengine.statisticanaly.modeldimension.model.ModelDimensionSummary;
import com.idm.app.ruleengine.statisticanaly.modeldimension.model.ModelHit;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class StatisticAnalyService {

    private Logger logger = Logger.getLogger(StatisticAnalyService.class);

    @Resource
    StatisticAnalyMapper statisticanalyMapper;

    public List<ModelDimension> queryModelDimension(ModelDimension modelDimension)
    {
        logger.info(">>>>>queryModelDimension");
        List<ModelDimension> resultList = new ArrayList<ModelDimension>();
        resultList = statisticanalyMapper.getModelDimension(modelDimension);
        if(resultList !=null && resultList.size()>0)
        {
            return resultList;
        }
        return null;
    }

    public List<ModelHit> queryModelHit(ModelDimension modelDimension)
    {
        logger.info(">>>>>queryModelDimensionSummary");
        List<ModelHit> resultList = new ArrayList<ModelHit>();
        resultList = statisticanalyMapper.getModelHit(modelDimension);
        if(resultList !=null && resultList.size()>0)
        {
            return resultList;
        }
        return null;
    }

}
