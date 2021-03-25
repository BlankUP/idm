package com.idm.app.idpconfig.mqiModeRule.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.idm.app.idpconfig.mqiModeRule.model.MqiModelRuleInfo;

public interface MqiModelRuleMapper {

    List<MqiModelRuleInfo> queryPatameteFieldsInfo(MqiModelRuleInfo modelRuleInfo);

    void addModelRuleInfo(MqiModelRuleInfo modelRuleInfo) throws Exception;
    
    void updateStatusByVersion(@Param("updateStatus") String updateStatus, @Param("version")int version);
 
	List<MqiModelRuleInfo> queryPatameteFieldsInfo();
	
	List<MqiModelRuleInfo> selectByExample(MqiModelRuleInfo modelRuleInfo);

	int selectCountByAll(MqiModelRuleInfo modelRuleInfo);
	
	List<MqiModelRuleInfo> getParaBaseInfosByExcel(Map<String,List<String>> map);
	
	List<MqiModelRuleInfo> queryPatameteFieldsInfoY();

	int addModelRuleInfoList(List<MqiModelRuleInfo> list);
	
	Integer queryVersion(@Param("status")String status);
	
	Integer queryMaxVersion();
	
	List<MqiModelRuleInfo> queryMqiModelRuleInfosByModelCode(@Param("modelcode") String modelcode,@Param("ruletype") String ruletype);
}
