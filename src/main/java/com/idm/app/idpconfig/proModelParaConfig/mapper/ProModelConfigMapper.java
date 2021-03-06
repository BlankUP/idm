package com.idm.app.idpconfig.proModelParaConfig.mapper;
import com.idm.app.idpconfig.pmmlConfig.model.PmmlConfig;
import com.idm.app.idpconfig.proModelParaConfig.model.ModelParseTemplate;
import com.idm.app.idpconfig.proModelParaConfig.model.ProModelBaseInfo;
import com.idm.app.idpconfig.proModelParaConfig.model.ProductBaseInfo;
import com.idm.app.system.auth.model.Organization;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ProModelConfigMapper {

    List<ProModelBaseInfo> queryModelBaseInfo(ProModelBaseInfo productBaseInfo);

    void addProModelInfo(ProModelBaseInfo productBaseInfo) throws Exception;
    
    void addProModelInfoJc(ProModelBaseInfo productBaseInfo) throws Exception;
    
    void updateProModelInfo(ProModelBaseInfo productBaseInfo);
    
	List<ProductBaseInfo> queryProdcutInfo(@Param("orgno") String orgno);
 
	String getProNameByCode(String productcode);

	/**  
	 *通过模型编码获取数据
	 */  
	Integer countByModelCode(@Param("modelcode") String modelcode);

	/**  
	 *根据产品编码获取模型 
	 */  
	List<ProModelBaseInfo> queryModelInfo(ProModelBaseInfo proModelBaseInfo);

	/**  
	 *校验模型编码和模型名称
	 */  
	Integer countByCodeName(@Param("orgno") String orgno,@Param("productcode") String productcode,@Param("modelcode") String modelcode,@Param("modelname") String modelname);

	/**  
	 *根据产品编码获取产品 
	 */   
	ProductBaseInfo getProductBaseInfo(@Param("productcode") String productcode);

	/**  
	 *获取产品模型的解析模板
	 */  
	List<ModelParseTemplate> queryParseTemplate();

	/**  
	 *获取Pmml模型的编码、名称等
	 */  
	List<PmmlConfig> queryPmmlModel();
	
	int selectCountByAll(ProModelBaseInfo proModelBaseInfo);
	
	/**  
	 *模型全量信息
	 */  
	List<ProModelBaseInfo> queryAllModelInfo();

}
