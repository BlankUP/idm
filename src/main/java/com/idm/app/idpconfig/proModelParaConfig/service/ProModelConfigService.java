package com.idm.app.idpconfig.proModelParaConfig.service;

import com.idm.app.idpconfig.pmmlConfig.model.PmmlConfig;
import com.idm.app.idpconfig.proModelParaConfig.mapper.ProModelConfigMapper;
import com.idm.app.idpconfig.proModelParaConfig.model.ModelParseTemplate;
import com.idm.app.idpconfig.proModelParaConfig.model.ProModelBaseInfo;
import com.idm.app.idpconfig.proModelParaConfig.model.ProductBaseInfo;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;

/**
* <p>Description: 产品上模型配置</p>  
* <p>Company: </p>  
* @author caiwenjian  
* @date 2019年2月23日  
* @version 1.0
 */
@Service
public class ProModelConfigService {

    @Resource
    private ProModelConfigMapper proModelConfigMapper;

    public List<ProModelBaseInfo> queryModelBaseInfo(ProModelBaseInfo proModelBaseInfo){
    	return proModelConfigMapper.queryModelBaseInfo(proModelBaseInfo);
    }

    public void addProModelInfo(ProModelBaseInfo proModelBaseInfo) throws Exception {
    	proModelConfigMapper.addProModelInfo(proModelBaseInfo);
    }
    
    public void addProModelInfoJc(ProModelBaseInfo proModelBaseInfo) throws Exception {
    	proModelConfigMapper.addProModelInfoJc(proModelBaseInfo);
    }

    public void updateProModelInfo(ProModelBaseInfo proModelBaseInfo){
    	proModelConfigMapper.updateProModelInfo(proModelBaseInfo);
    }
    
    /**
     * @Description:根据模型编码获取模型个数
     * @param modelcode
     * @return
     */
    public boolean checkModelCode(String modelcode){
    	Boolean isPass =true;
		Integer count = proModelConfigMapper.countByModelCode(modelcode);
		if(count!=null&&!"".equals(count)&&count>0){
			isPass = false;
		}
		return isPass;
    }
    /**
     * @Description:根据机构代码加载产品信息
     * @param orgno
     * @return
     */
    public List<ProductBaseInfo> queryProductInfo(String orgno) {
		return proModelConfigMapper.queryProdcutInfo(orgno);
	}
    
    /**
     * @Description:根据产品编码获取名称
     * @param productcode
     * @return
     */
	public String getProNameByCode(String productcode) {
		return proModelConfigMapper.getProNameByCode(productcode);
	}
	
	/**
	 * @Description:根据产品编码获取模型编码等信息
	 * @param proModelBaseInfo
	 * @return
	 */
	public List<ProModelBaseInfo> queryModelInfo(ProModelBaseInfo proModelBaseInfo) {
		return proModelConfigMapper.queryModelInfo(proModelBaseInfo);
	}
  
	/**
	 * @Description:校验模型编码和模型名称 
	 * @param productcode
	 * @param modelcode
	 * @param modelname
	 * @return
	 */
	public boolean checkByCodeName(String orgno,String productcode, String modelcode,String modelname) {
		Boolean isPass =true;
		Integer count = proModelConfigMapper.countByCodeName(orgno,productcode,modelcode,modelname);
		if(count!=null&&!"".equals(count)&&count>0){
			isPass = false;
		}
		return isPass;
	}
 
	public ProductBaseInfo getProductBaseInfo(String productcode) {
		
		return proModelConfigMapper.getProductBaseInfo(productcode);		
	}

	
	public List<ModelParseTemplate> queryParseTemplate() {
		
		return proModelConfigMapper.queryParseTemplate();		
	}
	
	public List<PmmlConfig> queryPmmlModel() {
		return proModelConfigMapper.queryPmmlModel();	
	}
 
	public int selectCountByAll(ProModelBaseInfo proModelBaseInfo) {
		
		return proModelConfigMapper.selectCountByAll(proModelBaseInfo);
	}
	
	public List<ProModelBaseInfo> queryAllModelInfo() {
		return proModelConfigMapper.queryAllModelInfo();
	}
}
