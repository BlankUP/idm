package com.idm.app.ruleengine.statisticanaly.creditdetail.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.idm.app.ruleengine.statisticanaly.creditdetail.model.CreditAmountInfo;
import com.idm.app.ruleengine.statisticanaly.creditdetail.model.RuleResultDetail;
import com.idm.app.ruleengine.statisticanaly.creditdetail.model.CreditResult;
import com.idm.app.ruleengine.statisticanaly.creditdetail.service.QueryCreditService;
import com.idm.common.page.PageVo;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class QueryCreditControler {

    private Logger logger = Logger.getLogger(QueryCreditControler.class);

    @Autowired
    private QueryCreditService queryCreditService;

    @RequestMapping("/cust_creditdetail")
    public String custCreditdetail(HttpServletRequest request)
    {
        return "creditdetail/cust_creditdetail";
    }

    @RequestMapping("/query_cust_credit")
    @ResponseBody
    public Object queryCreditDetail(HttpServletRequest request,String page, String rows)
    {
        int pageNum = Integer.parseInt(StringUtils.isNotBlank(page) ? page : "1");
        int pageSize = Integer.parseInt(StringUtils.isNotBlank(rows) ? rows : "10");

        String custName=request.getParameter("custName");
        String paperNo=request.getParameter("paperNo");
        String queryDate=request.getParameter("queryDate");
        String querySeqno=request.getParameter("querySeqno");
        logger.info(">>>custName["+custName+"]");
        logger.info(">>>paperNo["+paperNo+"]");
        logger.info(">>>queyDate["+queryDate+"]");
        logger.info(">>>queySeqno["+querySeqno+"]");

        PageHelper.startPage(pageNum, pageSize);
        PageVo pv = null;
        PageInfo pageInfo=null;

        List<CreditResult> resultList = queryCreditService.queryCreditResult(custName,paperNo, queryDate, querySeqno);

        if(resultList!=null && resultList.size()>0)
        {
            logger.info(">>>查询成功 总记录["+resultList.size()+"]");
            pageInfo = new PageInfo(resultList);
            pv = new PageVo(pageSize, pageNum, pageInfo.getTotal());
            pv.setRows(resultList);

        }
        else
        {
            pv = new PageVo(pageSize, pageNum, 0);
        }
        return pv;
    }

    @RequestMapping("/queryBlackListServer")
    @ResponseBody
    public Object queryBlackList(HttpServletRequest request)
    {
        String paperNo=request.getParameter("paperNo");
        String querySeqno=request.getParameter("querySeqno");
        String queryDate=request.getParameter("queryDate");
        logger.info(">>>paperNo["+paperNo+"]");
        logger.info(">>>querySeqno["+querySeqno+"]");
        logger.info(">>>queryDate["+queryDate+"]");

        JSONObject result = new JSONObject();
        if(StringUtils.isNotBlank(paperNo) && StringUtils.isNotBlank(querySeqno))
        {
            List<RuleResultDetail> blackListResult = queryCreditService.queryBlackList(paperNo,querySeqno,queryDate);
            if(blackListResult!=null && blackListResult.size()>0)
            {
                logger.info(">>>查询成功,总记录["+blackListResult.size()+"]");
                ArrayList<Object> arrayBlack = new ArrayList<Object>();
                for(RuleResultDetail blackListCheck: blackListResult)
                {
                    HashMap<String, String> mp =new HashMap<String, String>();
                    mp.put("paperNo", blackListCheck.getPaperNo());
                    mp.put("ruleCode", blackListCheck.getRuleCode());
                    mp.put("ruleName", blackListCheck.getRuleName());
                    mp.put("ruleResult", blackListCheck.getRuleResult());
                    mp.put("ruleReason", blackListCheck.getRuleReason());
                    mp.put("queryDate", blackListCheck.getQueryDate());
                    arrayBlack.add(mp);
                }
                logger.info(">>>arrayBlack to JSON["+JSONObject.toJSON(arrayBlack).toString()+"]");
                result.put("blackData",JSONObject.toJSON(arrayBlack) );
                result.put("msg","success");
            }

        }

        return result;
    }

    @RequestMapping("/antiFruadDetailServer")
    @ResponseBody
    public Object queyAntiApproval(HttpServletRequest request)
    {
        String paperNo=request.getParameter("paperNo");
        String querySeqno=request.getParameter("querySeqno");
        String queryDate=request.getParameter("queryDate");
        logger.info(">>>paperNo["+paperNo+"]");
        logger.info(">>>querySeqno["+querySeqno+"]");
        logger.info(">>>queryDate["+queryDate+"]");

        JSONObject result = new JSONObject();
        if(StringUtils.isNotBlank(paperNo) && StringUtils.isNotBlank(querySeqno))
        {
            List<RuleResultDetail> antiFraudResult = queryCreditService.queryAntiFraud(paperNo,querySeqno,queryDate);
            if(antiFraudResult!=null && antiFraudResult.size()>0)
            {
                logger.info(">>>查询成功,总记录["+antiFraudResult.size()+"]");
                ArrayList<Object> arrayAntiFruad = new ArrayList<Object>();
                for(RuleResultDetail ruleResultDetail: antiFraudResult)
                {
                    HashMap<String, String> mp =new HashMap<String, String>();
                    mp.put("paperNo", ruleResultDetail.getPaperNo());
                    mp.put("ruleCode", ruleResultDetail.getRuleCode());
                    mp.put("ruleName", ruleResultDetail.getRuleName());
                    mp.put("fieldValue", ruleResultDetail.getFieldValue());
                    mp.put("ruleResult", ruleResultDetail.getRuleResult());
                    mp.put("ruleReason", ruleResultDetail.getRuleReason());
                    mp.put("queryDate", ruleResultDetail.getQueryDate());
                    arrayAntiFruad.add(mp);
                }
                logger.info(">>>antiFruad Data to JSON["+JSONObject.toJSON(arrayAntiFruad).toString()+"]");
                result.put("antiFruadData",JSONObject.toJSON(arrayAntiFruad) );
                result.put("msg","success");
            }

        }

        return result;
    }

    @RequestMapping("/preLoanApproveDetailServer")
    @ResponseBody
    public Object queyPreLoanApprove(HttpServletRequest request)
    {
        String paperNo=request.getParameter("paperNo");
        String querySeqno=request.getParameter("querySeqno");
        String queryDate=request.getParameter("queryDate");
        logger.info(">>>paperNo["+paperNo+"]");
        logger.info(">>>querySeqno["+querySeqno+"]");
        logger.info(">>>queryDate["+queryDate+"]");

        JSONObject result = new JSONObject();
        if(StringUtils.isNotBlank(paperNo) && StringUtils.isNotBlank(querySeqno))
        {
            List<RuleResultDetail> preLoanApproveResult = queryCreditService.queryPreLoanApprove(paperNo,querySeqno,queryDate);
            if(preLoanApproveResult!=null && preLoanApproveResult.size()>0)
            {
                logger.info(">>>查询成功,总记录["+preLoanApproveResult.size()+"]");
                ArrayList<Object> arrayPreLoanApprove = new ArrayList<Object>();
                for(RuleResultDetail ruleResultDetail: preLoanApproveResult)
                {
                    HashMap<String, String> mp =new HashMap<String, String>();
                    mp.put("paperNo", ruleResultDetail.getPaperNo());
                    mp.put("ruleCode", ruleResultDetail.getRuleCode());
                    mp.put("ruleName", ruleResultDetail.getRuleName());
                    mp.put("fieldValue", ruleResultDetail.getFieldValue());
                    mp.put("ruleResult", ruleResultDetail.getRuleResult());
                    mp.put("ruleReason", ruleResultDetail.getRuleReason());
                    mp.put("queryDate", ruleResultDetail.getQueryDate());
                    arrayPreLoanApprove.add(mp);
                }
                logger.info(">>>preLoanApproveData to JSON["+JSONObject.toJSON(arrayPreLoanApprove).toString()+"]");
                result.put("preLoanApproveData",JSONObject.toJSON(arrayPreLoanApprove) );
                result.put("msg","success");
            }

        }

        return result;
    }

    @RequestMapping("quotaPriceServer")
    @ResponseBody
    public Object queryQuotaPrice(HttpServletRequest request)
    {
        String paperNo=request.getParameter("paperNo");
        String querySeqno=request.getParameter("querySeqno");
        String queryDate=request.getParameter("queryDate");
        String uuid=request.getParameter("uuid");
        String creditAmount=request.getParameter("creditAmount");
        String creditScore=request.getParameter("creditScore");

        logger.info(">>>paperNo["+paperNo+"]");
        logger.info(">>>querySeqno["+querySeqno+"]");
        logger.info(">>>queryDate["+queryDate+"]");
        logger.info(">>>uuid["+uuid+"]");
        logger.info(">>>creditAmount["+creditAmount+"]");
        logger.info(">>>creditScore["+creditScore+"]");

        JSONObject result = new JSONObject();
        String huomouScore="";
        String baseAmount="";
        String assetAmount="";
        String salaryAmount="";
        String adjustAmount="";
        String whiteFlag="";
        huomouScore = queryCreditService.queryBJHuoMouScore(querySeqno,paperNo, queryDate);

        CreditAmountInfo creditAmountInfo = queryCreditService.queryCreditAmountInfo(uuid, queryDate);
        logger.info(">>>>creditAmountInfo["+creditAmountInfo+"]");
        if(creditAmountInfo==null)
        {
            baseAmount=creditAmount;
            assetAmount="0";
            salaryAmount="0";
            adjustAmount="0";
            whiteFlag="否";
        }
        else
        {
            assetAmount=creditAmountInfo.getAssetAmount();
            salaryAmount=creditAmountInfo.getSalaryAmount();
            adjustAmount=creditAmountInfo.getAdjustAmount();
            whiteFlag=creditAmountInfo.getWhiteFlag();
        }

        HashMap<String, String> hmap = new HashMap<String, String>();
        hmap.put("whiteFlag",whiteFlag );
        hmap.put("huomouScore", huomouScore);
        hmap.put("creditScore", creditScore);
        hmap.put("baseAmount",baseAmount);
        hmap.put("assetAmount",assetAmount);
        hmap.put("salaryAmount",salaryAmount);
        hmap.put("adjustAmount",adjustAmount);
        hmap.put("creditAmount",creditAmount);

        result.put("amountData",JSONObject.toJSON(hmap));

        return result;
    }
}
