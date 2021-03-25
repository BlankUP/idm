package com.idm.app.idpconfig.pmmlConfig.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.idm.app.idpconfig.pmmlConfig.mapper.PmmlFileMapper;
import com.idm.app.idpconfig.pmmlConfig.model.PmmlFile;
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
public class PmmlFileService {
    @Resource
    PmmlFileMapper pmmlFileMapper;
    
    public List<PmmlFile> queryPmmlFile(PmmlFile pmmlFile)
    {
        return pmmlFileMapper.queryPmmlFile(pmmlFile);
    }
    
    public long addPmmlFile(PmmlFile pmmlFile) throws Exception
    {
        return pmmlFileMapper.addPmmlFile(pmmlFile);
    }
    
    public long updatePmmlFile(PmmlFile pmmlFile) throws Exception
    {
        return pmmlFileMapper.updatePmmlFile(pmmlFile);
    }

	public List<String> selectMaxVersionNo(String pmmlid) {
		
		return pmmlFileMapper.selectMaxVersionNo(pmmlid);
	}

    public long updateAllFile() throws Exception
    {
        return pmmlFileMapper.updateAllFile();
    }
    
    public long updateOneFile(PmmlFile pmmlFile) throws Exception
    {
        return pmmlFileMapper.updateOneFile(pmmlFile);
    }
}
