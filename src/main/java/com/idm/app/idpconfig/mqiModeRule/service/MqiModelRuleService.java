package com.idm.app.idpconfig.mqiModeRule.service;

import com.idm.app.idpconfig.mqiModeRule.mapper.MqiModelRuleMapper;
import com.idm.app.idpconfig.mqiModeRule.model.MqiModelRuleInfo;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;
import java.util.Map;

/**
* <p>Description: 模型质检模型规则信息配置类</p>  
* <p>Company: </p>  
* @author pl  
* @date 2019年8月17日  
* @version 1.0
 */
@Service
public class MqiModelRuleService {

    @Resource
    private MqiModelRuleMapper mqiModelRuleMapper;

    public List<MqiModelRuleInfo> queryPatameteFieldsInfo(MqiModelRuleInfo modelRuleInfo)
    {
    	return mqiModelRuleMapper.queryPatameteFieldsInfo(modelRuleInfo);
    }

    /**
     * @Description：修改表mqi_modeltorule_info中数据状态为‘0’改成‘1’
     * @param updateStatus
     * @param version
     * @return
     */
    public void updateStatusByVersion(String updateStatus,int version){
    	mqiModelRuleMapper.updateStatusByVersion(updateStatus,version);
    }
    
    /**
     * @Description：查询表mqi_modeltorule_info中数据状态为‘0’的版本号
     * @param status
     * @return
     */
    public Integer queryVersion(String status){
    	Integer version = mqiModelRuleMapper.queryVersion(status);
    	return version;
    }
    
    /**
     * @Description：查询表mqi_modeltorule_info中版本号最大值
     * @return
     */
    public Integer queryMaxVersion(){
    	Integer maxVersion= mqiModelRuleMapper.queryMaxVersion();
    	return maxVersion;
    }
    
	public List<MqiModelRuleInfo> queryPatameteFieldsInfo(){
		return mqiModelRuleMapper.queryPatameteFieldsInfo();
	}

	/**
	 * @Description：根据字段名和字段中文名查询数据
	 * @param parameterfields
	 * @param parameternamechs
	 * @return
	 */
	public List<MqiModelRuleInfo> queryPatameterFieldsInfoByExcel(Map<String,List<String>> map){
		List<MqiModelRuleInfo>  list  = mqiModelRuleMapper.getParaBaseInfosByExcel(map);
		return list;
	}
	
	/**
	 * @Description：添加多笔数据
	 * @param list
	 * @throws Exception
	 */
	public int addModelRuleInfoList(List<MqiModelRuleInfo> list){
    	int number = mqiModelRuleMapper.addModelRuleInfoList(list);
    	return number;
    }

	public int selectCountByAll(MqiModelRuleInfo mqiModelRuleInfo) {
		return mqiModelRuleMapper.selectCountByAll(mqiModelRuleInfo);
	}

	public List<MqiModelRuleInfo> queryPatameteFieldsInfoY() {
    	return mqiModelRuleMapper.queryPatameteFieldsInfoY();
	}
	
	public List<MqiModelRuleInfo> queryPatameteFieldsInfoYR() {
		return mqiModelRuleMapper.queryPatameteFieldsInfoY();
	}

	/**
	 * @Description：根据模型编码，查找规则信息
	 * @param modelCode
	 * @return
	 */
	public List<MqiModelRuleInfo> queryMqiModelRuleInfosByModelCode(String modelCode,String ruleType)
    {
    	return mqiModelRuleMapper.queryMqiModelRuleInfosByModelCode(modelCode,ruleType);
    }
}
