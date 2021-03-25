package com.idm.app.system.basicdataconfig.mapper;

import com.idm.app.system.auth.model.UserInfo;
import com.idm.app.system.basicdataconfig.model.IdmParamsCfg;
import com.idm.app.system.serverconfig.model.ServerInfo;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BasicDataConfigMapper {

    List<IdmParamsCfg> queryBasicDataConfig(IdmParamsCfg idmParamsCfg);
    
    int selectCountByAll(IdmParamsCfg idmParamsCfg);

    List<String> queryBaseInfo();

    long addBasicData(IdmParamsCfg idmParamsCfg) throws Exception;

    long updateBasicData(IdmParamsCfg idmMngSysParamsCfg);

    List<ServerInfo> queryServerById(List<String> serverIdList);
}
