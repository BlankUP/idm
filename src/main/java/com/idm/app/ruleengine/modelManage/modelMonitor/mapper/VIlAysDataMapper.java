package com.idm.app.ruleengine.modelManage.modelMonitor.mapper;

import com.idm.app.ruleengine.modelManage.modelMonitor.model.VIlAysData;
import com.idm.app.ruleengine.modelManage.modelMonitor.model.VIlAysDataExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VIlAysDataMapper {
    long countByExample(VIlAysDataExample example);

    int deleteByExample(VIlAysDataExample example);

    int insert(VIlAysData record);

    int insertSelective(VIlAysData record);

    List<VIlAysData> selectByExample(VIlAysDataExample example);

    int updateByExampleSelective(@Param("record") VIlAysData record, @Param("example") VIlAysDataExample example);

    int updateByExample(@Param("record") VIlAysData record, @Param("example") VIlAysDataExample example);
}