package com.idm.app.ruleengine.statisticanaly.creditdetail.mapper;
import com.idm.app.ruleengine.statisticanaly.creditdetail.model.CreditAmountInfo;
import com.idm.app.ruleengine.statisticanaly.creditdetail.model.RuleResultDetail;
import com.idm.app.ruleengine.statisticanaly.creditdetail.model.CreditResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QueryCreditMapper {

    List<CreditResult> queryCreditResult(@Param("custName") String custName, @Param("paperNo") String paperNo,
                                         @Param("queryDate") String queryDate,@Param("querySeqno") String querySeqno);

    List<RuleResultDetail> queryBlackList(@Param("paperNo") String paperNo,@Param("querySeqno") String querySeqno,
                                          @Param("queryDate") String queryDate);

    List<RuleResultDetail> queryAntiFraud(@Param("paperNo") String paperNo, @Param("querySeqno") String querySeqno,
                                          @Param("queryDate") String queryDate);

    List<RuleResultDetail> queryPreLoanApprove(@Param("paperNo") String paperNo, @Param("querySeqno") String querySeqno,
                                               @Param("queryDate") String queryDate);

    String queryBJHuoMouScore(@Param("querySeqno") String querySeqno, @Param("paperNo") String paperNo, @Param("queryDate") String queryDate);

    CreditAmountInfo queryCreditAmountInfo(@Param("uuid") String uuid, @Param("queryDate") String queryDate);


}
