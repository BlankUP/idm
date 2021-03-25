package com.idm.app.idpconfig.proModelParaConfig.service;

import com.idm.app.idpconfig.proModelParaConfig.mapper.ProModelParaConfigMapper;
import com.idm.app.idpconfig.proModelParaConfig.model.ProModelParaBaseInfo;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;
import java.util.Map;

/**
* <p>Description: 产品上模型配置</p>  
* <p>Company: </p>  
* @author caiwenjian  
* @date 2019年2月23日  
* @version 1.0
 */
@Service
public class ProModelParaConfigService {

	@Resource
	private ProModelParaConfigMapper proModelParaConfigMapper;
    
    public List<ProModelParaBaseInfo> queryModelParaBaseInfo(ProModelParaBaseInfo proModelParaBaseInfo)
    {
    	return proModelParaConfigMapper.queryModelParaBaseInfo(proModelParaBaseInfo);
    }

    /**
     * @Description：添加模型下添加多条字段信息
     * @param list
     */
    public void addModelParaBaseInfoList(List<ProModelParaBaseInfo> list){
    	proModelParaConfigMapper.addModelParaBaseInfoList(list);
    }
    /**
     * @Description：修改模型下多条字段信息的状态
     * @param list
     */
    public void updateStatusInfoByModelIdAndField(Map map){
    	proModelParaConfigMapper.updateStatusInfoByModelIdAndField(map);
    }

 
	public List<Map<String, Object>> modelIdAndField( String modelcode) {
		
		return proModelParaConfigMapper.modelIdAndField(modelcode);
	}

	 
	public int selectCountByAll(ProModelParaBaseInfo proModelParaBaseInfo) {
		return proModelParaConfigMapper.selectCountByAll(proModelParaBaseInfo);
	}

	 
	public List<ProModelParaBaseInfo> queryModelParalist(String modelId) {
		return proModelParaConfigMapper.queryModelParalist(modelId);
	}

}
