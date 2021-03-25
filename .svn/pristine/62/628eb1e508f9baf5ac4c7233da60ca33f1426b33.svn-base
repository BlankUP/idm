package com.idm.app.idpconfig.mqiCountAnalysis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idm.app.idpconfig.mqiCountAnalysis.model.MqiScoreCardInfo;
import com.idm.app.idpconfig.mqiCountAnalysis.model.MqiScoreCardTotalScoreInfo;
import com.idm.app.idpconfig.mqiCountAnalysis.mapper.MqiScoreCardInfoMapper;

/**
* <p>@Description：评分卡服务层</p>
 * @author：jiamh
 * @createTime：2019年8月23日
 * @version 1.0
 */
@Service
public class MqiScoreCardInfoService {

	@Autowired
	MqiScoreCardInfoMapper mqiScoreCardInfoMapper;
	
	/**
	 * 获取总分的总数
	 * @param scoreCardTotalScoreInfo
	 * @return
	 */
	public int selectTotalScoreCountByAll(MqiScoreCardTotalScoreInfo mqiScoreCardTotalScoreInfo){
		int count = mqiScoreCardInfoMapper.selectTotalScoreCountByAll(mqiScoreCardTotalScoreInfo);
		return count;
	}
	
	/**
	 * 获取评分卡总分信息
	 * @param scoreCardTotalScoreInfo
	 * @return
	 */
	public List<MqiScoreCardTotalScoreInfo> getScoreRuleTotalScoreInfo(MqiScoreCardTotalScoreInfo mqiScoreCardTotalScoreInfo){
		List<MqiScoreCardTotalScoreInfo> list = mqiScoreCardInfoMapper.getScoreCardTotalScoreInfo(mqiScoreCardTotalScoreInfo);
		return list;
	}
	
	/**
	 * 获取总数
	 * @param scoreCardTotalScoreInfo
	 * @return
	 */
	public int selectCountByAll(MqiScoreCardInfo mqiScoreCardInfo){
		int count = mqiScoreCardInfoMapper.selectCountByAll(mqiScoreCardInfo);
		return count;
	}
	
	/**
	 * 获取评分卡总分信息
	 * @param scoreCardTotalScoreInfo
	 * @return
	 */
	public List<MqiScoreCardInfo> getScoreCardInfo(MqiScoreCardInfo mqiScoreCardInfo){
		List<MqiScoreCardInfo> list = mqiScoreCardInfoMapper.getScoreCardInfo(mqiScoreCardInfo);
		return list;
	}
}
