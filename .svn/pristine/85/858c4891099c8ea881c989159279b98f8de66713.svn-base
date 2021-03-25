package com.idm.app.idpconfig.proModelParaConfig.mapper;

import com.idm.app.idpconfig.proModelParaConfig.model.ParaBaseInfo;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
 
public interface ParaInfoConfigMapper {

    List<ParaBaseInfo> queryPatameteFieldsInfo(ParaBaseInfo errBaseInfo);

    void addParameterFieldsInfo(ParaBaseInfo fieldsInfo) throws Exception;

    void updateParameterFieldsInfo(ParaBaseInfo fieldsInfo);
    
    int addParaBaseInfoList(List<ParaBaseInfo> list);
    
    List<ParaBaseInfo> getParaList();
 
	Integer countByName(@Param("parameterfields") String parameterfields, @Param("parameternamech") String parameternamech);

	List<ParaBaseInfo> queryPatameteFieldsInfo();
	
	Integer checkIsUsed(@Param("fieldid") String fieldid);

	List<ParaBaseInfo> selectByExample(ParaBaseInfo parainfo);

	int selectCountByAll(ParaBaseInfo paraInfo);
	
	List<ParaBaseInfo> getParaBaseInfosByExcel(Map<String,List<String>> map);
	
	List<ParaBaseInfo> queryPatameteFieldsInfoY();
}
