package com.idm.app.ruleengine.modelManage.modelMonitor.mapper;

import com.idm.app.ruleengine.modelManage.modelMonitor.model.VAlRuleIndexData;
import com.idm.app.ruleengine.modelManage.modelMonitor.model.VAlRuleIndexDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VAlRuleIndexDataMapper {
    long countByExample(VAlRuleIndexDataExample example);

    int deleteByExample(VAlRuleIndexDataExample example);

    int insert(VAlRuleIndexData record);

    int insertSelective(VAlRuleIndexData record);

    List<VAlRuleIndexData> selectByExample(VAlRuleIndexDataExample example);

    int updateByExampleSelective(@Param("record") VAlRuleIndexData record, @Param("example") VAlRuleIndexDataExample example);

    int updateByExample(@Param("record") VAlRuleIndexData record, @Param("example") VAlRuleIndexDataExample example);
}