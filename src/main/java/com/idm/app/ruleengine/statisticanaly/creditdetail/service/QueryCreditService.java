package com.idm.app.ruleengine.statisticanaly.creditdetail.service;

import com.idm.app.ruleengine.statisticanaly.creditdetail.mapper.QueryCreditMapper;
import com.idm.app.ruleengine.statisticanaly.creditdetail.model.CreditAmountInfo;
import com.idm.app.ruleengine.statisticanaly.creditdetail.model.RuleResultDetail;
import com.idm.app.ruleengine.statisticanaly.creditdetail.model.CreditResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class QueryCreditService {

    @Resource
    private QueryCreditMapper queryCreditMapper;

    public List<CreditResult> queryCreditResult(String custName, String paperNo, String queryDate,String querySeqno)
    {
        return queryCreditMapper.queryCreditResult(custName, paperNo, queryDate,querySeqno);
    }

    //黑名单校验结果查询
    public List<RuleResultDetail> queryBlackList(String paperNo, String querySeqno, String queryDate)
    {
        return queryCreditMapper.queryBlackList(paperNo,querySeqno,queryDate);
    }

    //反欺诈检查结果查询
    public List<RuleResultDetail> queryAntiFraud(String paperNo, String querySeqno, String queryDate)
    {
        return queryCreditMapper.queryAntiFraud(paperNo, querySeqno, queryDate);
    }

    //贷前审批结果查询
    public List<RuleResultDetail> queryPreLoanApprove(String paperNo, String querySeqno, String queryDate)
    {
        return queryCreditMapper.queryPreLoanApprove(paperNo, querySeqno,queryDate);
    }

    //客户火眸分查询
    public String queryBJHuoMouScore(String querySeqno,String paperNo, String queryDate)
    {
        return queryCreditMapper.queryBJHuoMouScore(querySeqno, paperNo, queryDate);
    }

    //客户额度信息查询
    public CreditAmountInfo queryCreditAmountInfo(String uuid, String queryDate)
    {
        return queryCreditMapper.queryCreditAmountInfo(uuid, queryDate);
    }



}
