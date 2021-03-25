package com.idm.app.idpconfig.pmmlConfig.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.idm.app.idpconfig.pmmlConfig.mapper.PmmlConfigMapper;
import com.idm.app.idpconfig.pmmlConfig.model.PmmlConfig;
/**
 * 
 *<p>Title: PmmlConfigService</p>  
 * @Description: pmml配置service
 * @author 黄百超
 * @date 2019年3月7日
 * @version  1.0
 *
 */
@Service
public class PmmlConfigService {
    @Resource
    PmmlConfigMapper pmmlConfigMapper;
    
    public List<PmmlConfig> queryPmmlConfig(PmmlConfig pmmlConfig)
    {
        return pmmlConfigMapper.queryPmmlConfig(pmmlConfig);
    }
    
    public long addPmmlConfig(PmmlConfig pmmlConfig) throws Exception
    {
        return pmmlConfigMapper.addPmmlConfig(pmmlConfig);
    }
    
    public long updatePmmlConfig(PmmlConfig pmmlConfig) throws Exception
    {
        return pmmlConfigMapper.updatePmmlConfig(pmmlConfig);
    }
    
    public long repeatPmmlCode(PmmlConfig pmmlConfig)
    {
        return pmmlConfigMapper.repeatPmmlCode(pmmlConfig);
    }
    
    public long repeatPmmlName(PmmlConfig pmmlConfig)
    {
        return pmmlConfigMapper.repeatPmmlName(pmmlConfig);
    }
    
    public Integer selectCountByAll(PmmlConfig pmmlConfig)
    {
        return pmmlConfigMapper.selectCountByAll(pmmlConfig);
    }
}
