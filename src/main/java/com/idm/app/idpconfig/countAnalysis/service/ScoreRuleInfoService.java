package com.idm.app.idpconfig.countAnalysis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idm.app.idpconfig.countAnalysis.mapper.ScoreRuleInfoMapper;
import com.idm.app.idpconfig.countAnalysis.model.ScoreRuleInfo;
import com.idm.app.idpconfig.countAnalysis.model.ScoreRuleTotalScoreInfo;

/**
 * <p>@Description：评分规则服务层</p>
 * @author：jiamh
 * @createTime：2019年8月22日
 * @version 1.0
 */
@Service
public class ScoreRuleInfoService {
	
	
	@Autowired
	ScoreRuleInfoMapper scoreRuleInfoMapper;
	
	/**
	 * 获取总分的总数
	 * @param scoreRuleInfo
	 * @return
	 */
	public int selectCountByAll(ScoreRuleTotalScoreInfo scoreRuleTotalScoreInfo){
		int count = scoreRuleInfoMapper.selectCountByAll(scoreRuleTotalScoreInfo);
		return count;
	}
	
	/**
	 * 获取规则评分总分
	 * @param scoreRuleInfo
	 * @return
	 */
	public List<ScoreRuleTotalScoreInfo> getScoreRuleTotalScoreInfo(ScoreRuleTotalScoreInfo scoreRuleTotalScoreInfo){
		List<ScoreRuleTotalScoreInfo> list = scoreRuleInfoMapper.getScoreRuleTotalScoreInfo(scoreRuleTotalScoreInfo);
		return list;
	}
	
	/**
	 * 获取规则评分明细
	 * @param scoreRuleInfo
	 * @return
	 */
	public List<ScoreRuleInfo> getScoreRuleInfos(ScoreRuleInfo scoreRuleInfo){
		List<ScoreRuleInfo> list = scoreRuleInfoMapper.getScoreRuleInfos(scoreRuleInfo);
		return list;
	}
  
}
