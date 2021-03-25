package com.idm.app.system.mqibasicdataconfig.service;


import org.springframework.stereotype.Service;

import com.idm.app.system.mqibasicdataconfig.mapper.MqiBasicDataConfigMapper;
import com.idm.app.system.mqibasicdataconfig.model.MqiParamsCfg;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MqiBasicDataConfigService {

    @Resource
    MqiBasicDataConfigMapper mqibasicDataConfigMapper;

    public List<MqiParamsCfg> queryBasicDataConfig(MqiParamsCfg mqiParamsCfg)
    {
        return mqibasicDataConfigMapper.queryBasicDataConfig(mqiParamsCfg);
    }
    public int selectCountByAll(MqiParamsCfg mqiParamsCfg)
    {
        return mqibasicDataConfigMapper.selectCountByAll(mqiParamsCfg);
    }


    public List<String> queryBaseInfo()
    {
        return mqibasicDataConfigMapper.queryBaseInfo();
    }

    public long addBasicData(MqiParamsCfg mqiParamsCfg) throws Exception
    {
        return mqibasicDataConfigMapper.addBasicData(mqiParamsCfg);
    }

    public long updateBasicData(MqiParamsCfg mqiParamsCfg)
    {
        return mqibasicDataConfigMapper.updateBasicData(mqiParamsCfg);
    }

	

}
