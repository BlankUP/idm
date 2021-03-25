package com.idm.app.ruleengine.modelManage.modelMonitor.mapper;

import com.idm.app.ruleengine.modelManage.modelMonitor.model.VAlAysData;
import com.idm.app.ruleengine.modelManage.modelMonitor.model.VAlAysDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VAlAysDataMapper {
    long countByExample(VAlAysDataExample example);

    int deleteByExample(VAlAysDataExample example);

    int insert(VAlAysData record);

    int insertSelective(VAlAysData record);

    List<VAlAysData> selectByExample(VAlAysDataExample example);

    int updateByExampleSelective(@Param("record") VAlAysData record, @Param("example") VAlAysDataExample example);

    int updateByExample(@Param("record") VAlAysData record, @Param("example") VAlAysDataExample example);
}