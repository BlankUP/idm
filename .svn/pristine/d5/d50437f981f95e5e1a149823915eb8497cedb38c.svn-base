package com.idm.app.idpconfig.pmmlConfig.mapper;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.idm.app.idpconfig.pmmlConfig.model.PmmlFile;

/**
 * 
 *<p>Title: PmmlFileMapper</p>  
 * @Description:pmml配置mapper 
 * @author 黄百超
 * @date 2019年3月7日
 * @version  1.0
 *
 */
public interface PmmlFileMapper {


	List<PmmlFile> queryPmmlFile(PmmlFile pmmlFile);

	long addPmmlFile(PmmlFile pmmlFile) throws Exception;

	long updatePmmlFile(PmmlFile pmmlFile) throws Exception;

	List<String> selectMaxVersionNo(String pmmlid);
	 
	long updateAllFile() throws Exception;
	
	long updateOneFile(PmmlFile pmmlFile) throws Exception;

}
