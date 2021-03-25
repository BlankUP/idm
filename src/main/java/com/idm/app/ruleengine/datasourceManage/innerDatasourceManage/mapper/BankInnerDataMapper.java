package com.idm.app.ruleengine.datasourceManage.innerDatasourceManage.mapper;

import com.idm.app.ruleengine.datasourceManage.innerDatasourceManage.model.BankInnerData;
import com.idm.app.ruleengine.datasourceManage.innerDatasourceManage.model.BankInnerDataExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BankInnerDataMapper {
    long countByExample(BankInnerDataExample example);

    int deleteByExample(BankInnerDataExample example);

    int insert(BankInnerData record);

    int insertSelective(BankInnerData record);

    List<BankInnerData> selectByExample(BankInnerDataExample example);

    int updateByExampleSelective(@Param("record") BankInnerData record, @Param("example") BankInnerDataExample example);

    int updateByExample(@Param("record") BankInnerData record, @Param("example") BankInnerDataExample example);

    List<Map<String,Object>> selectByUUID(@Param("uuid") String uuid);
}