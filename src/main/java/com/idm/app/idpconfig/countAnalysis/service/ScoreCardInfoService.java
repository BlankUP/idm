package com.idm.app.idpconfig.countAnalysis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idm.app.idpconfig.countAnalysis.mapper.ScoreCardInfoMapper;
import com.idm.app.idpconfig.countAnalysis.model.ScoreCardInfo;
import com.idm.app.idpconfig.countAnalysis.model.ScoreCardTotalScoreInfo;

/**
* <p>@Description：评分卡服务层</p>
 * @author：jiamh
 * @createTime：2019年8月23日
 * @version 1.0
 */
@Service
public class ScoreCardInfoService {

	@Autowired
	ScoreCardInfoMapper scoreCardInfoMapper;
	
	/**
	 * 获取总分的总数
	 * @param scoreCardTotalScoreInfo
	 * @return
	 */
	public int selectTotalScoreCountByAll(ScoreCardTotalScoreInfo scoreCardTotalScoreInfo,String startDate,String endDate){
		int count = scoreCardInfoMapper.selectTotalScoreCountByAll(scoreCardTotalScoreInfo,startDate,endDate);
		return count;
	}
	
	/**
	 * 获取评分卡总分信息
	 * @param scoreCardTotalScoreInfo
	 * @return
	 */
	public List<ScoreCardTotalScoreInfo> getScoreRuleTotalScoreInfo(ScoreCardTotalScoreInfo scoreCardTotalScoreInfo,String startDate,String endDate){
		List<ScoreCardTotalScoreInfo> list = scoreCardInfoMapper.getScoreCardTotalScoreInfo(scoreCardTotalScoreInfo,startDate,endDate);
		return list;
	}
	
	/**
	 * 获取总数
	 * @param scoreCardTotalScoreInfo
	 * @return
	 */
	public int selectCountByAll(ScoreCardInfo scoreCardInfo){
		int count = scoreCardInfoMapper.selectCountByAll(scoreCardInfo);
		return count;
	}
	
	/**
	 * 获取评分卡总分信息
	 * @param scoreCardTotalScoreInfo
	 * @return
	 */
	public List<ScoreCardInfo> getScoreCardInfo(ScoreCardInfo scoreCardInfo){
		List<ScoreCardInfo> list = scoreCardInfoMapper.getScoreCardInfo(scoreCardInfo);
		return list;
	}

	public List<ScoreCardTotalScoreInfo> getScoreRuleInfo(String startDate, String endDate) {
		// TODO Auto-generated method stub
		return scoreCardInfoMapper.getScoreRuleInfo(startDate,endDate);
	}
}
