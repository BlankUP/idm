package com.idm.app.idpconfig.bom.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.idm.app.idpconfig.bom.mapper.BomInfoMapper;
import com.idm.app.idpconfig.bom.model.BomInfo;
import com.idm.app.idpconfig.bom.model.Field;
import com.idm.app.idpconfig.eventconfig.model.InterfaceInfo;
import com.idm.app.idpconfig.proModelParaConfig.model.ModelQParaField;
import com.idm.app.idpconfig.proModelParaConfig.model.ParaBaseInfo;


@Service
public class BomInfoService {
    @Resource
    BomInfoMapper bomInfoMapper;
    
    /**
     * 
     *@Description:BOM版本信息查询列表
     *@param bomInfo
     *@return
     */
    public List<BomInfo> queryBomInfo(BomInfo bomInfo)
    {
        return bomInfoMapper.queryBomInfo(bomInfo);
    }
    /**
     * 
     *@Description:查询数据源字段列表
     *@return
     */
    public List<Field> queryFieldList()
    {
    	return bomInfoMapper.queryFieldList();
    }
    /**
     * 
     *@Description:查询模型质检所需字段
     *@return
     */
    public List<ModelQParaField> queryModelQFieldList(){
    	return bomInfoMapper.queryModelQFieldList();
    }
    /**
     * 
     * @Description: 
     * @param bomInfo
     * @return
     * @throws Exception
     */
	public long addBomInfo(BomInfo bomInfo) throws Exception {
		
		return bomInfoMapper.addBomInfo(bomInfo);
		
	}
   
	public long updateBomInfo(BomInfo bomInfo) throws Exception {
		
		return bomInfoMapper.updateBomInfo(bomInfo);
		
	}
	
	public long updateAllBomInfoStatus() throws Exception {
		
		return bomInfoMapper.updateAllBomInfoStatus();
		
	}
	
	public long updateBomInfoStatus(BomInfo bomInfo) throws Exception {
		
		return bomInfoMapper.updateBomInfoStatus(bomInfo);
		
	}
	public List<ParaBaseInfo> getParaList()
    {
    	return bomInfoMapper.getParaList();
    }
	
	public Integer selectCountByAll(BomInfo bomInfo) {
		
		return bomInfoMapper.selectCountByAll(bomInfo);
		
	}
	public long addField(Field field) throws Exception{
		return bomInfoMapper.addField(field);
	}
	public long addInterfaceInfo(InterfaceInfo interfaceInfo) throws Exception{
		return bomInfoMapper.addInterfaceInfo(interfaceInfo);
	}
	
	public long updateFieldStatus() throws Exception {
		
		return bomInfoMapper.updateFieldStatus();
		
	}
public long updateInterfaceInfoStatus() throws Exception {
		
		return bomInfoMapper.updateInterfaceInfoStatus();
		
	}
}
