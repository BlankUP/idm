package com.idm.app.idpconfig.proModelParaConfig.service;

import com.idm.app.idpconfig.proModelParaConfig.mapper.ParaInfoConfigMapper;
import com.idm.app.idpconfig.proModelParaConfig.model.ParaBaseInfo;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;
import java.util.Map;

/**
* <p>Description: 参数字段信息配置类</p>  
* <p>Company: </p>  
* @author caiwenjian  
* @date 2019年2月23日  
* @version 1.0
 */
@Service
public class ParaInfoConfigService {

    @Resource
    private ParaInfoConfigMapper paraInfoConfigMapper;

    public List<ParaBaseInfo> queryPatameteFieldsInfo(ParaBaseInfo errBaseInfo)
    {
    	return paraInfoConfigMapper.queryPatameteFieldsInfo(errBaseInfo);
    }

    public void addParameterFieldsInfo(ParaBaseInfo fieldsInfo) throws Exception
    {
    	paraInfoConfigMapper.addParameterFieldsInfo(fieldsInfo);
    }

    public void updateParameterFieldsInfo(ParaBaseInfo fieldsInfo)
    {
    	paraInfoConfigMapper.updateParameterFieldsInfo(fieldsInfo);
    }
    
    public List<ParaBaseInfo> getParaList()
    {
    	return paraInfoConfigMapper.getParaList();
    }

	/**  
	 *<p>Descr:校验是否重名 </p>  
	 *@param parameterfields
	 *@param parameternamech
	 *@return  
	 */  
	public Boolean checkByName(String parameterfields, String parameternamech) {
		Boolean isPass =true;
		Integer count = paraInfoConfigMapper.countByName(parameterfields,parameternamech);
		if(count!=null&&!"".equals(count)&&count>0){
			isPass = false;
		}
		return isPass;
	}

	public List<ParaBaseInfo> queryPatameteFieldsInfo(){
		
		return paraInfoConfigMapper.queryPatameteFieldsInfo();
	}

	/**
	 * @Description：根据字段名和字段中文名查询数据
	 * @param parameterfields
	 * @param parameternamechs
	 * @return
	 */
	public List<ParaBaseInfo> queryPatameterFieldsInfoByExcel(Map<String,List<String>> map){
		List<ParaBaseInfo>  list  = paraInfoConfigMapper.getParaBaseInfosByExcel(map);
		return list;
	}
	
	/**
	 * @Description：添加多笔数据
	 * @param list
	 * @throws Exception
	 */
	public int addParaBaseInfoList(List<ParaBaseInfo> list) throws Exception
    {
    	int number = paraInfoConfigMapper.addParaBaseInfoList(list);
    	return number;
    }
 
	public boolean checkIsUsed(String fieldid) {
		Boolean isPass =true;
		Integer count = paraInfoConfigMapper.checkIsUsed(fieldid);
		if(count!=null&&!"".equals(count)&&count>0){
			isPass = false;
		}
		return isPass;
	}

	public int selectCountByAll(ParaBaseInfo paraInfo) {
		
		return paraInfoConfigMapper.selectCountByAll(paraInfo);
	}

	
	public List<ParaBaseInfo> queryPatameteFieldsInfoY() {
		
    	return paraInfoConfigMapper.queryPatameteFieldsInfoY();
	}

}
