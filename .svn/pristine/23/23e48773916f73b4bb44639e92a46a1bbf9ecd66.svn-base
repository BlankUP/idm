package com.idm.app.ruleengine.statisticanaly.modeldimension.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.idm.app.ruleengine.statisticanaly.modeldimension.model.ModelDimension;
import com.idm.app.ruleengine.statisticanaly.modeldimension.model.ModelDimensionSummary;
import com.idm.app.ruleengine.statisticanaly.modeldimension.model.ModelHit;
import com.idm.app.ruleengine.statisticanaly.modeldimension.service.StatisticAnalyService;
import com.idm.common.page.PageVo;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class StatisticAnalyController {

    private Logger logger = Logger.getLogger(StatisticAnalyController.class);

    @Autowired
    StatisticAnalyService statisticAnalyService;

    @RequestMapping("/model_dimension")
    public String modelDimession(Model model) {
        return "statisticalAnalysis/model_dimension";
    }

    @RequestMapping("/model_dimension_service")
    @ResponseBody
    public Object modelDimessionHandle(HttpServletRequest request, String page, String rows) throws Exception {

        logger.info(">>>>>modelDimessionHandle");
        logger.info(">>>>>modeCode[" + request.getParameter("modelId") + "]");
        logger.info(">>>>>modeName[" + request.getParameter("modleName") + "]");
        logger.info(">>>>>query_date[" + request.getParameter("query_date") + "]");
        int pageNum = Integer.parseInt(StringUtils.isNotBlank(page) ? page : "1");
        int pageSize = Integer.parseInt(StringUtils.isNotBlank(rows) ? rows : "10");

        PageHelper.startPage(pageNum, pageSize);
        PageVo pv = null;
        PageInfo pageInfo=null;
        ModelDimension modelDimension = new ModelDimension();
        modelDimension.setProductCode(request.getParameter("prodId"));
        modelDimension.setProductName(request.getParameter("productName"));
        modelDimension.setModelCode(request.getParameter("modelId"));
        modelDimension.setModelName(request.getParameter("modleName"));
        modelDimension.setInputDate(request.getParameter("query_date"));

        List<ModelDimension> modelDimensionList = new ArrayList<ModelDimension>();
        modelDimensionList = statisticAnalyService.queryModelDimension(modelDimension);
        if (modelDimensionList == null) {
            logger.info("查询失败");
            pv = new PageVo(pageSize, pageNum,0);
            pv.setError("查询失败");
            return pv;
        }
        logger.info("查询成功");
        logger.info(">>>>" + modelDimensionList.size());
        PageHelper.startPage(pageNum, pageSize);
        pageInfo = new PageInfo(modelDimensionList);
        pv = new PageVo(pageSize, pageNum, pageInfo.getTotal());
        pv.setRows(modelDimensionList);
        return pv;
    }

    @RequestMapping("/getModeldimensionData")
    @ResponseBody
    public Object modeldimensionData(String modleName, String modelId, String productName, String prodId, String query_date, HttpServletRequest request) {
        logger.info(">>>modeldimensionData...");
        logger.info(">>>modelName[" + modleName + "]");
        logger.info(">>>modelId[" + modelId + "]");
        logger.info(">>>productName[" + productName + "]");
        logger.info(">>>prodId[" + prodId + "]");
        logger.info(">>>query_date[" + query_date + "]");

        JSONObject result = new JSONObject();
        ModelDimension modelDimension = new ModelDimension();
        modelDimension.setProductCode(prodId);
        modelDimension.setProductName(productName);
        modelDimension.setModelCode(modelId);
        modelDimension.setModelName(modleName);
        modelDimension.setInputDate(query_date);

        List<ModelHit> modehitList = statisticAnalyService.queryModelHit(modelDimension);
        if (modehitList != null) {
            logger.info(">>>>modehitList size[" + modehitList.size() + "]");
            ArrayList dataArray = new ArrayList();
            ArrayList modelArray = new ArrayList();

            for (ModelHit modelhit : modehitList) {
                if (modelhit != null) {
                    HashMap hmap = new HashMap();
                    hmap.put("name", modelhit.getModelName());
                    hmap.put("value", modelhit.getCustNum());
                    logger.info(">>>name[" + modelhit.getModelName() + "]");
                    logger.info(">>>value[" + modelhit.getCustNum() + "]");
                    dataArray.add(hmap);
                    modelArray.add(modelhit.getModelName());
                }

            }
            logger.info(">>modeArray JSON[" + JSONObject.toJSON(modelArray).toString() + "]");
            logger.info(">>dataArray JSON[" + JSONObject.toJSON(dataArray).toString() + "]");
            result.put("modelArray", JSONObject.toJSON(modelArray));
            result.put("dataArray", JSONObject.toJSON(dataArray));
            result.put("msg", "success");
        }

        return result;
    }

    public static void main(String[] args)
    {
        System.out.println("test.....");
        HashMap hmap = null;
        ArrayList modelArray = new ArrayList();
        for(int i=0;i<7;i++)
        {
            hmap=new HashMap();
            hmap.put("name","default"+String.valueOf(i));
            hmap.put("value",0+i);
            modelArray.add(hmap);
            hmap=null;
        }
        System.out.println("modelArray>>"+modelArray);
    }
}
