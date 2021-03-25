package com.idm.app.system.basicdataconfig.service;

import com.idm.app.system.auth.model.UserInfo;
import com.idm.app.system.basicdataconfig.mapper.BasicDataConfigMapper;
import com.idm.app.system.basicdataconfig.model.IdmParamsCfg;
import com.idm.app.system.serverconfig.model.ServerInfo;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BasicDataConfigService {

    @Resource
    BasicDataConfigMapper basicDataConfigMapper;

    public List<IdmParamsCfg> queryBasicDataConfig(IdmParamsCfg idmParamsCfg)
    {
        return basicDataConfigMapper.queryBasicDataConfig(idmParamsCfg);
    }
    public int selectCountByAll(IdmParamsCfg idmParamsCfg)
    {
        return basicDataConfigMapper.selectCountByAll(idmParamsCfg);
    }


    public List<String> queryBaseInfo()
    {
        return basicDataConfigMapper.queryBaseInfo();
    }

    public long addBasicData(IdmParamsCfg idmParamsCfg) throws Exception
    {
        return basicDataConfigMapper.addBasicData(idmParamsCfg);
    }

    public long updateBasicData(IdmParamsCfg idmParamsCfg)
    {
        return basicDataConfigMapper.updateBasicData(idmParamsCfg);
    }

	

}
