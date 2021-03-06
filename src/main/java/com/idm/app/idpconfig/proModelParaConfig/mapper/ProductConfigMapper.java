package com.idm.app.idpconfig.proModelParaConfig.mapper;

import com.idm.app.idpconfig.proModelParaConfig.model.ProToOrgInfo;
import com.idm.app.idpconfig.proModelParaConfig.model.ProductBaseInfo;
import com.idm.app.idpconfig.proModelParaConfig.model.ProductInterface;
import com.idm.app.system.auth.model.Organization;

import java.util.List;

import org.apache.ibatis.annotations.Param;

 
public interface ProductConfigMapper {

    List<ProductBaseInfo> queryProdcutInfo(ProductBaseInfo productBaseInfo);
    
    List<ProductBaseInfo> queryAllProdcutInfo(ProductBaseInfo productBaseInfo);

    void addProductInfo(ProductBaseInfo productBaseInfo) throws Exception;

    void updateProductInfo(ProductBaseInfo productBaseInfo);
    
    Integer getCounts();
    
	Integer countByCodeName(@Param("productcode") String productcode,@Param("productname") String productname);

	int selectCountByAll(ProductBaseInfo prodcutBaseInfo);
	
	int selectCountByCodeAll(ProductBaseInfo prodcutBaseInfo);

	
    void addProToOrgInfo(ProToOrgInfo proToOrgInfo);
    
    Integer delProToOrgInfo(ProToOrgInfo proToOrgInfo);
    
    List<Organization> getAllOrganization();
    
    List<Organization> getOrganization(ProToOrgInfo proToOrgInfo);
    
    void addProductInterface(ProductInterface productInterface) throws Exception;




}
