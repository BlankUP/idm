package com.idm.app.idpconfig.countAnalysis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.idm.app.idpconfig.countAnalysis.model.ScoreCardInfo;
import com.idm.app.idpconfig.countAnalysis.model.ScoreCardTotalScoreInfo;

/**
 * <p>@Description：评分卡方法调用接口</p>
 * @author：jiamh
 * @createTime：2019年8月23日
 * @version 1.0
 */
public interface ScoreCardInfoMapper {

	int selectTotalScoreCountByAll(@Param(value = "scoreCardTotalScoreInfo") ScoreCardTotalScoreInfo scoreCardTotalScoreInfo,@Param(value = "startDate") String startDate,@Param(value = "endDate") String endDate);
	
	List<ScoreCardTotalScoreInfo> getScoreCardTotalScoreInfo(@Param(value = "scoreCardTotalScoreInfo") ScoreCardTotalScoreInfo scoreCardTotalScoreInfo,@Param(value = "startDate") String startDate,@Param(value = "endDate") String endDate);
	
	int selectCountByAll(ScoreCardInfo scoreCardInfo);
	
	List<ScoreCardInfo> getScoreCardInfo(ScoreCardInfo scoreCardInfo);

	List<ScoreCardTotalScoreInfo> getScoreRuleInfo(@Param(value = "startDate") String startDate,@Param(value = "endDate") String endDate);
}
