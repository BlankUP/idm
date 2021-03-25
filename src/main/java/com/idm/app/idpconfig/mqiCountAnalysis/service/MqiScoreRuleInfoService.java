package com.idm.app.idpconfig.mqiCountAnalysis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idm.app.idpconfig.mqiCountAnalysis.mapper.MqiScoreRuleInfoMapper;
import com.idm.app.idpconfig.mqiCountAnalysis.model.MqiScoreRuleInfo;
import com.idm.app.idpconfig.mqiCountAnalysis.model.MqiScoreRuleTotalScoreInfo;

/**
 * <p>@Description：评分规则服务层</p>
 * @author：jiamh
 * @createTime：2019年8月22日
 * @version 1.0
 */
@Service
public class MqiScoreRuleInfoService {
	
	
	@Autowired
	MqiScoreRuleInfoMapper mqiScoreRuleInfoMapper;
	
	/**
	 * 获取总分的总数
	 * @param scoreRuleInfo
	 * @return
	 */
	public int selectCountByAll(MqiScoreRuleTotalScoreInfo mqiScoreRuleTotalScoreInfo){
		int count = mqiScoreRuleInfoMapper.selectCountByAll(mqiScoreRuleTotalScoreInfo);
		return count;
	}
	
	/**
	 * 获取规则评分总分
	 * @param scoreRuleInfo
	 * @return
	 */
	public List<MqiScoreRuleTotalScoreInfo> getScoreRuleTotalScoreInfo(MqiScoreRuleTotalScoreInfo mqiScoreRuleTotalScoreInfo){
		List<MqiScoreRuleTotalScoreInfo> list = mqiScoreRuleInfoMapper.getScoreRuleTotalScoreInfo(mqiScoreRuleTotalScoreInfo);
		return list;
	}
	
	/**
	 * 获取规则评分明细
	 * @param scoreRuleInfo
	 * @return
	 */
	public List<MqiScoreRuleInfo> getScoreRuleInfos(MqiScoreRuleInfo mqiScoreRuleInfo){
		List<MqiScoreRuleInfo> list = mqiScoreRuleInfoMapper.getScoreRuleInfos(mqiScoreRuleInfo);
		return list;
	}
  
}
