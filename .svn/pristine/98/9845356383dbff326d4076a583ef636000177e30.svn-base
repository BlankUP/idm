package com.idm.app.idpconfig.proModelParaConfig.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.idm.app.idpconfig.proModelParaConfig.mapper.ModelQParaInfoConfigMapper;
import com.idm.app.idpconfig.proModelParaConfig.model.ModelQParaField;

/**
* <p>Description: 模型质检字段信息配置类</p>  
* <p>Company: </p>  
* @author caiwenjian  
* @date 2019年2月23日  
* @version 1.0
 */
@Service
public class ModelQParaInfoConfigService {

    @Resource
    private ModelQParaInfoConfigMapper modelParaInfoConfigMapper;

    public List<ModelQParaField> queryPatameteFieldsInfo(ModelQParaField errBaseInfo)
    {
    	return modelParaInfoConfigMapper.queryPatameteFieldsInfo(errBaseInfo);
    }

    public void addParameterFieldsInfo(ModelQParaField fieldsInfo) throws Exception
    {
    	modelParaInfoConfigMapper.addParameterFieldsInfo(fieldsInfo);
    }

    public void updateParameterFieldsInfo(ModelQParaField fieldsInfo)
    {
    	modelParaInfoConfigMapper.updateParameterFieldsInfo(fieldsInfo);
    }
    
    public List<ModelQParaField> getParaList()
    {
    	return modelParaInfoConfigMapper.getParaList();
    }

	/**  
	 *<p>Descr:校验是否重名 </p>  
	 *@param parameterfields
	 *@param parameternamech
	 *@return  
	 */  
	public Boolean checkByName(String parameterfields, String parameternamech) {
		Boolean isPass =true;
		Integer count = modelParaInfoConfigMapper.countByName(parameterfields,parameternamech);
		if(count!=null&&!"".equals(count)&&count>0){
			isPass = false;
		}
		return isPass;
	}

	public List<ModelQParaField> queryPatameteFieldsInfo(){
		
		return modelParaInfoConfigMapper.queryPatameteFieldsInfo();
	}

	/**
	 * @Description：根据字段名和字段中文名查询数据
	 * @param parameterfields
	 * @param parameternamechs
	 * @return
	 */
	public List<ModelQParaField> queryPatameterFieldsInfoByExcel(Map<String,List<String>> map){
		List<ModelQParaField>  list  = modelParaInfoConfigMapper.getParaBaseInfosByExcel(map);
		return list;
	}
	
	/**
	 * @Description：添加多笔数据
	 * @param list
	 * @throws Exception
	 */
	public int addParaBaseInfoList(List<ModelQParaField> list) throws Exception
    {
    	int number = modelParaInfoConfigMapper.addParaBaseInfoList(list);
    	return number;
    }
 
	public boolean checkIsUsed(String fieldid) {
		Boolean isPass =true;
		Integer count = modelParaInfoConfigMapper.checkIsUsed(fieldid);
		if(count!=null&&!"".equals(count)&&count>0){
			isPass = false;
		}
		return isPass;
	}

	public int selectCountByAll(ModelQParaField paraInfo) {
		
		return modelParaInfoConfigMapper.selectCountByAll(paraInfo);
	}

	
	public List<ModelQParaField> queryPatameteFieldsInfoY() {
		
    	return modelParaInfoConfigMapper.queryPatameteFieldsInfoY();
	}

}
