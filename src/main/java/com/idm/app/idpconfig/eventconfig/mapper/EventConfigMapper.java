package com.idm.app.idpconfig.eventconfig.mapper;

import java.util.List;

import com.idm.app.idpconfig.eventconfig.model.EventConfig;
import com.idm.app.idpconfig.eventconfig.model.InterfaceInfo;
import com.idm.app.idpconfig.proModelParaConfig.model.ParaBaseInfo;
import com.idm.app.idpconfig.proModelParaConfig.model.ProModelBaseInfo;
import com.idm.app.idpconfig.proModelParaConfig.model.ProductBaseInfo;
import com.idm.app.system.auth.model.Organization;

public interface EventConfigMapper {

	List<EventConfig> queryEventConfig(EventConfig eventConfig);

	long addEventConfig(EventConfig eventConfig) throws Exception;

	long updateEventConfig(EventConfig eventConfig) throws Exception;

	List<ProductBaseInfo> queryProductInfo();

	List<ProModelBaseInfo> queryModelInfo(ProModelBaseInfo proModelBaseInfo);

	List<InterfaceInfo> queryInterfaceInfo();
	
	long repeatEventName(EventConfig eventConfig);
	
	long repeatModel(EventConfig eventConfig);
	
	List<Organization> queryOrgInfo();
	
	Integer selectCountByAll(EventConfig eventConfig);


	
}
