package com.idm.app.apiservice.datasourceManage.externalDatasourceManage.mapper;

import com.idm.app.apiservice.datasourceManage.externalDatasourceManage.model.VExternalData;
import com.idm.app.apiservice.datasourceManage.externalDatasourceManage.model.VExternalDataExample;

import java.util.List;
import java.util.Map;

import oracle.sql.CLOB;
import org.apache.ibatis.annotations.Param;

public interface VExternalDataMapper {
    long countByExample(VExternalDataExample example);

    List<VExternalData> selectByExample(VExternalDataExample example);

    Map selectClobByUUIDAndTableName(@Param("tableName") String tableName, @Param("uuid") String uuid);
}