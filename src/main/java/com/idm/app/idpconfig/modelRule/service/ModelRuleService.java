package com.idm.app.idpconfig.modelRule.service;

import com.idm.app.idpconfig.modelRule.mapper.ModelRuleMapper;
import com.idm.app.idpconfig.modelRule.model.ModelRuleInfo;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;
import java.util.Map;

/**
* <p>Description: 模型规则信息配置类</p>  
* <p>Company: </p>  
* @author pl  
* @date 2019年8月17日  
* @version 1.0
 */
@Service
public class ModelRuleService {

    @Resource
    private ModelRuleMapper modelRuleMapper;

    public List<ModelRuleInfo> queryPatameteFieldsInfo(ModelRuleInfo modelRuleInfo)
    {
    	return modelRuleMapper.queryPatameteFieldsInfo(modelRuleInfo);
    }

    /**
     * @Description：修改表idm_modeltorule_info中数据状态为‘0’改成‘1’
     * @param updateStatus
     * @param version
     * @return
     */
    public void updateStatusByVersion(String updateStatus,int version){
    	modelRuleMapper.updateStatusByVersion(updateStatus,version);
    }
    
    /**
     * @Description：查询表idm_modeltorule_info中数据状态为‘0’的版本号
     * @param status
     * @return
     */
    public Integer queryVersion(String status){
    	Integer version = modelRuleMapper.queryVersion(status);
    	return version;
    }
    
    /**
     * @Description：查询表idm_modeltorule_info中版本号最大值
     * @return
     */
    public Integer queryMaxVersion(){
    	Integer maxVersion= modelRuleMapper.queryMaxVersion();
    	return maxVersion;
    }
    
	public List<ModelRuleInfo> queryPatameteFieldsInfo(){
		return modelRuleMapper.queryPatameteFieldsInfo();
	}

	/**
	 * @Description：根据字段名和字段中文名查询数据
	 * @param parameterfields
	 * @param parameternamechs
	 * @return
	 */
	public List<ModelRuleInfo> queryPatameterFieldsInfoByExcel(Map<String,List<String>> map){
		List<ModelRuleInfo>  list  = modelRuleMapper.getParaBaseInfosByExcel(map);
		return list;
	}
	
	/**
	 * @Description：添加多笔数据
	 * @param list
	 * @throws Exception
	 */
	public int addModelRuleInfoList(List<ModelRuleInfo> list){
    	int number = modelRuleMapper.addModelRuleInfoList(list);
    	return number;
    }

	public int selectCountByAll(ModelRuleInfo paraInfo) {
		return modelRuleMapper.selectCountByAll(paraInfo);
	}

	public List<ModelRuleInfo> queryPatameteFieldsInfoY() {
    	return modelRuleMapper.queryPatameteFieldsInfoY();
	}
	
	public List<ModelRuleInfo> queryPatameteFieldsInfoYR() {
		return modelRuleMapper.queryPatameteFieldsInfoY();
	}

	/**
	 * @Description：根据模型编码，查找规则信息
	 * @param modelCode
	 * @return
	 */
	public List<ModelRuleInfo> queryModelRuleInfosByModelCode(String modelCode,String ruleType)
    {
    	return modelRuleMapper.queryModelRuleInfosByModelCode(modelCode,ruleType);
    }
}
