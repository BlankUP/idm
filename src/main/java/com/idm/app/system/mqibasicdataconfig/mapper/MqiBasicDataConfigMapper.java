package com.idm.app.system.mqibasicdataconfig.mapper;

import com.idm.app.system.mqibasicdataconfig.model.MqiParamsCfg;
import com.idm.app.system.serverconfig.model.ServerInfo;


import java.util.List;

public interface MqiBasicDataConfigMapper {

    List<MqiParamsCfg> queryBasicDataConfig(MqiParamsCfg mqiParamsCfg);
    
    int selectCountByAll(MqiParamsCfg mqiParamsCfg);

    List<String> queryBaseInfo();

    long addBasicData(MqiParamsCfg mqiParamsCfg) throws Exception;

    long updateBasicData(MqiParamsCfg idmMngSysParamsCfg);

    List<ServerInfo> queryServerById(List<String> serverIdList);
}
