package com.idm.app.idpconfig.proModelParaConfig.mapper;

import com.idm.app.idpconfig.proModelParaConfig.model.ProModelParaBaseInfo;









import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

 
public interface ProModelParaConfigMapper {

    List<ProModelParaBaseInfo> queryModelParaBaseInfo(ProModelParaBaseInfo productBaseInfo);
    
    void addModelParaBaseInfoList(List<ProModelParaBaseInfo> list);       //新增多条模型字段信息
    
    void updateStatusInfoByModelIdAndField(Map map);                      //根据模型id(modelid)和字段id(fieldid)修改数据数据状态
    
	List<Map<String, Object>> modelIdAndField(@Param("modelcode") String modelcode);

	int selectCountByAll(ProModelParaBaseInfo proModelParaBaseInfo);
 
	List<ProModelParaBaseInfo> queryModelParalist(@Param("modelid") String modelid);

}
