package com.idm.app.ruleengine.modelManage.modelMonitor.mapper;

import com.idm.app.ruleengine.modelManage.modelMonitor.model.VDmAysData;
import com.idm.app.ruleengine.modelManage.modelMonitor.model.VDmAysDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VDmAysDataMapper {
    long countByExample(VDmAysDataExample example);

    int deleteByExample(VDmAysDataExample example);

    int insert(VDmAysData record);

    int insertSelective(VDmAysData record);

    List<VDmAysData> selectByExample(VDmAysDataExample example);

    int updateByExampleSelective(@Param("record") VDmAysData record, @Param("example") VDmAysDataExample example);

    int updateByExample(@Param("record") VDmAysData record, @Param("example") VDmAysDataExample example);
}