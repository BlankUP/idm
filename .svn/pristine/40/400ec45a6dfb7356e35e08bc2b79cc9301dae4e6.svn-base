package com.idm.app.ruleengine.statisticanaly.custdimension.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.idm.app.ruleengine.statisticanaly.custdimension.mapper.CustDimensionMapper;
import com.idm.app.ruleengine.statisticanaly.custdimension.model.CustDimension;
import com.idm.app.ruleengine.statisticanaly.custdimension.model.RiskHit;
import com.idm.app.ruleengine.statisticanaly.custdimension.service.CustDimensionService;
import com.idm.common.page.PageVo;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class CustDimensionController {

    private Logger logger = Logger.getLogger(CustDimensionController.class);

    @Autowired
    CustDimensionService custDimensionService;

    @RequestMapping("/cust_dimension")
    public String doCustDimension(Model model)
    {
        return "statisticalAnalysis/cust_dimension";
    }

    @RequestMapping("/cust_dimension_service")
    @ResponseBody
    public Object CustDimensionService(HttpServletRequest request, String page, String rows)
    {
        int pageNum =Integer.parseInt(StringUtils.isNotBlank(page) ? page : "1");
        int pageSize = Integer.parseInt(StringUtils.isNotBlank(rows) ? rows : "10");

        String customName = request.getParameter("customName");
        String paperType = request.getParameter("paperType");
        String paperNo = request.getParameter("paperNo");
        String productName = request.getParameter("productName");
        String productCode = request.getParameter("productCode");
        String modelName = request.getParameter("modelName");
        String modelCode = request.getParameter("modelCode");
        String riskLevel = request.getParameter("riskLevel");
        String sourceSystem = request.getParameter("sourceSystem");
        String receiveSystem = request.getParameter("receiveSystem");
        String startEwDate = request.getParameter("beginDate");
        String endEwDate= request.getParameter("endDate");

        logger.info(">>>>customName["+customName+"]");
        logger.info(">>>>paperType["+paperType+"]");
        logger.info(">>>>paperNo["+paperNo+"]");
        logger.info(">>>>productName["+productName+"]");
        logger.info(">>>>productCode["+productCode+"]");
        logger.info(">>>>modelName["+modelName+"]");
        logger.info(">>>>modelCode["+modelCode+"]");
        logger.info(">>>>riskLevel["+riskLevel+"]");
        logger.info(">>>>sourceSystem["+sourceSystem+"]");
        logger.info(">>>>receiveSystem["+receiveSystem+"]");
        logger.info(">>>>startEwDate["+startEwDate+"]");
        logger.info(">>>>endEwDate["+endEwDate+"]");

        CustDimension custDimension = new CustDimension();
        custDimension.setCustomName(customName);
        custDimension.setPaperNo(paperType);
        custDimension.setPaperNo(paperNo);
        custDimension.setProductName(productName);
        custDimension.setProductCode(productCode);
        custDimension.setModelName(modelName);
        custDimension.setModelCode(modelCode);
        custDimension.setRiskLevel(riskLevel);
        custDimension.setWarnDate(startEwDate);
        custDimension.setSourceSystem(sourceSystem);
        custDimension.setReceiveSystem(receiveSystem);
        custDimension.setStartEwDate(startEwDate);
        custDimension.setEndEwDate(endEwDate);
        PageHelper.startPage(pageNum,pageSize);

        PageInfo pageInfo =null;
        PageVo pv = null;
        List<CustDimension> custDimensionData = custDimensionService.queryCustDimension(custDimension);
        if(custDimensionData!=null && custDimensionData.size()>0)
        {
            logger.info(">>>查询客户维度成功！");
            pageInfo = new PageInfo(custDimensionData);
            pv = new PageVo(pageSize, pageNum, pageInfo.getTotal());
            pv.setRows(custDimensionData);
            return pv;
        }
        else if(custDimensionData!=null && custDimensionData.size()==0)
        {
            pv = new PageVo(pageSize, pageNum,0);
            pv.setError("无记录");
            logger.error(">>>无记录！");
            return pv;
        }
        else
        {
            pv = new PageVo(pageSize, pageNum,0);
            pv.setError("数据库异常");
            logger.error(">>>数据库操作异常！");
            return pv;
        }
    }

    @RequestMapping("/riskWarmSummary")
    @ResponseBody
    public Object riskWarmSummary(HttpServletRequest request, String beginDate, String endDate)
    {
        logger.info("customName>>>"+request.getParameter("customName"));
        logger.info("paperType>>>"+request.getParameter("paperType"));
        logger.info("paperNo>>>"+request.getParameter("paperNo"));
        logger.info("modelName>>>"+request.getParameter("modelName"));
        logger.info("modelCode>>>"+request.getParameter("modelCode"));

        JSONObject result = new JSONObject();
        CustDimension custDimension = new CustDimension();
        custDimension.setCustomName(request.getParameter("customName"));
        custDimension.setPaperType(request.getParameter("paperType"));
        custDimension.setPaperNo(request.getParameter("paperNo"));
        custDimension.setModelName(request.getParameter("ModelName"));
        custDimension.setModelCode(request.getParameter("ModelCode"));
        custDimension.setStartEwDate(beginDate);
        custDimension.setEndEwDate(endDate);
        List<RiskHit> riskHitList = custDimensionService.queryRiskHit(custDimension);
        if(riskHitList!=null && riskHitList.size()>0)
        {
            ArrayList dataArray = new ArrayList();

            for(RiskHit riskHit: riskHitList)
            {
                HashMap hmap = new HashMap();
                hmap.put("name", riskHit.getRiskName());
                hmap.put("value", riskHit.getCustNum());
                dataArray.add(hmap);
            }
            result.put("msg","success");
            result.put("dataArray",JSONObject.toJSON(dataArray));
            logger.info(">>dataArray JSON["+JSONObject.toJSON(dataArray).toString()+"]");
        }
        return result;
    }
}
