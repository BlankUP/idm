package com.idm.app.idpconfig.mqiCountAnalysis.mapper;

import java.util.List;

import com.idm.app.idpconfig.mqiCountAnalysis.model.MqiScoreRuleInfo;
import com.idm.app.idpconfig.mqiCountAnalysis.model.MqiScoreRuleTotalScoreInfo;

/**
 * <p>@Description：评分规则方法调用接口</p>
 * @author：jiamh
 * @createTime：2019年8月22日
 * @version 1.0
 */
public interface MqiScoreRuleInfoMapper {

	int selectCountByAll(MqiScoreRuleTotalScoreInfo mqiScoreRuleTotalScoreInfo);
	
	List<MqiScoreRuleTotalScoreInfo> getScoreRuleTotalScoreInfo(MqiScoreRuleTotalScoreInfo mqiScoreRuleTotalScoreInfo);
	
	List<MqiScoreRuleInfo> getScoreRuleInfos(MqiScoreRuleInfo mqiScoreRuleInfo);
}
