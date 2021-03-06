package com.idm.app.idpconfig.proModelParaConfig.service;

import com.idm.app.idpconfig.proModelParaConfig.mapper.ProductConfigMapper;
import com.idm.app.idpconfig.proModelParaConfig.model.ProToOrgInfo;
import com.idm.app.idpconfig.proModelParaConfig.model.ProductBaseInfo;
import com.idm.app.idpconfig.proModelParaConfig.model.ProductInterface;
import com.idm.app.system.auth.model.Organization;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;

/**
* <p>Description: 产品信息配置</p>  
* <p>Company: </p>  
* @author caiwenjian  
* @date 2019年2月23日  
* @version 1.0
 */
@Service
public class ProductConfigService {

    @Resource
    private ProductConfigMapper productConfigMapper;

    public List<ProductBaseInfo> queryProdcutInfo(ProductBaseInfo productBaseInfo)
    {
    	return productConfigMapper.queryProdcutInfo(productBaseInfo);
    }
    
    public List<ProductBaseInfo> queryAllProdcutInfo(ProductBaseInfo productBaseInfo)
    {
    	return productConfigMapper.queryAllProdcutInfo(productBaseInfo);
    }

    public void addProductInfo(ProductBaseInfo productBaseInfo) throws Exception
    {
    	productConfigMapper.addProductInfo(productBaseInfo);
    }

    public void updateProductInfo(ProductBaseInfo productBaseInfo)
    {
    	productConfigMapper.updateProductInfo(productBaseInfo);
    }
    
    public Integer getCounts(){
    	return productConfigMapper.getCounts();
    }

	/**  
	 *校验编码名称
	 */  
	public boolean checkByCodeName(String productcode, String productname) {
		Boolean isPass =true;
		//统计编码或名称
		Integer count = productConfigMapper.countByCodeName(productcode,productname);
		if(count!=null&&!"".equals(count)&&count>0){
			isPass = false;
		}
		return isPass;
	}

	public int selectCountByAll(ProductBaseInfo prodcutBaseInfo) {
		
		return productConfigMapper.selectCountByAll(prodcutBaseInfo);
	}

	public int selectCountByCodeAll(ProductBaseInfo prodcutBaseInfo) {
		
		return productConfigMapper.selectCountByCodeAll(prodcutBaseInfo);
	}
	
    public void addProToCorInfo(ProToOrgInfo proToOrgInfo) throws Exception
    {
    	productConfigMapper.addProToOrgInfo(proToOrgInfo);
    }
    
    public void delProToCorInfo(ProToOrgInfo proToOrgInfo) throws Exception
    {
    	productConfigMapper.delProToOrgInfo(proToOrgInfo);
    }

	public List<Organization> getOrganization(ProToOrgInfo proToOrgInfo) {
		return productConfigMapper.getOrganization(proToOrgInfo);
	}
	
	public List<Organization> getAllOrganization() {
		return productConfigMapper.getAllOrganization();
	}
	

    public void addProductInterface(ProductInterface productInterface) throws Exception
    {
    	productConfigMapper.addProductInterface(productInterface);
    }
}
