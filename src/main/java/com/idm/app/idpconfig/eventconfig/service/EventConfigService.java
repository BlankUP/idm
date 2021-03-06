package com.idm.app.idpconfig.eventconfig.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.idm.app.idpconfig.eventconfig.mapper.EventConfigMapper;
import com.idm.app.idpconfig.eventconfig.model.EventConfig;
import com.idm.app.idpconfig.eventconfig.model.InterfaceInfo;
import com.idm.app.idpconfig.proModelParaConfig.model.ParaBaseInfo;
import com.idm.app.idpconfig.proModelParaConfig.model.ProModelBaseInfo;
import com.idm.app.idpconfig.proModelParaConfig.model.ProductBaseInfo;
import com.idm.app.system.auth.model.Organization;

@Service
public class EventConfigService {
    @Resource
    EventConfigMapper eventConfigMapper;
    
    /**
     * 事件基本信息查询方法
     * 黄百超
     * 2019-02-23
     * @param eventConfig
     * @return
     */
    public List<EventConfig> queryEventConfig(EventConfig eventConfig)
    {
        return eventConfigMapper.queryEventConfig(eventConfig);
    }
    
    public long addEventConfig(EventConfig eventConfig) throws Exception
    {
        return eventConfigMapper.addEventConfig(eventConfig);
    }
    
    public long updateEventConfig(EventConfig eventConfig) throws Exception
    {
        return eventConfigMapper.updateEventConfig(eventConfig);
    }

	public List<ProductBaseInfo> queryProductInfo() {
		return eventConfigMapper.queryProductInfo();
	}

	public List<ProModelBaseInfo> queryModelInfo(ProModelBaseInfo proModelBaseInfo) {
		return eventConfigMapper.queryModelInfo(proModelBaseInfo);
	}

	public List<InterfaceInfo> queryInterfaceInfo() {
		return eventConfigMapper.queryInterfaceInfo();
	}
	
    public long repeatEventName(EventConfig eventConfig) 
    {
        return eventConfigMapper.repeatEventName(eventConfig);
    }
    
    public long repeatModel(EventConfig eventConfig) 
    {
        return eventConfigMapper.repeatModel(eventConfig);
    }
    
	public List<Organization> queryOrgInfo() {
		return eventConfigMapper.queryOrgInfo();
	}
    public Integer selectCountByAll(EventConfig eventConfig)
    {
        return eventConfigMapper.selectCountByAll(eventConfig);
    }
	
}
