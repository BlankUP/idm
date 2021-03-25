package com.idm.app.idpconfig.proModelParaConfig.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.idm.app.idpconfig.proModelParaConfig.model.ModelQParaField;
 
public interface ModelQParaInfoConfigMapper {

    List<ModelQParaField> queryPatameteFieldsInfo(ModelQParaField errBaseInfo);

    void addParameterFieldsInfo(ModelQParaField fieldsInfo) throws Exception;

    void updateParameterFieldsInfo(ModelQParaField fieldsInfo);
    
    int addParaBaseInfoList(List<ModelQParaField> list);
    
    List<ModelQParaField> getParaList();
 
	Integer countByName(@Param("parameterfields") String parameterfields, @Param("parameternamech") String parameternamech);

	List<ModelQParaField> queryPatameteFieldsInfo();
	
	Integer checkIsUsed(@Param("fieldid") String fieldid);

	List<ModelQParaField> selectByExample(ModelQParaField parainfo);

	int selectCountByAll(ModelQParaField paraInfo);
	
	List<ModelQParaField> getParaBaseInfosByExcel(Map<String,List<String>> map);
	
	List<ModelQParaField> queryPatameteFieldsInfoY();
}
