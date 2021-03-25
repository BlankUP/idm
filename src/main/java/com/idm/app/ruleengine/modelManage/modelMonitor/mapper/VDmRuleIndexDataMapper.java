package com.idm.app.ruleengine.modelManage.modelMonitor.mapper;

import com.idm.app.ruleengine.modelManage.modelMonitor.model.VDmRuleIndexData;
import com.idm.app.ruleengine.modelManage.modelMonitor.model.VDmRuleIndexDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VDmRuleIndexDataMapper {
    long countByExample(VDmRuleIndexDataExample example);

    int deleteByExample(VDmRuleIndexDataExample example);

    int insert(VDmRuleIndexData record);

    int insertSelective(VDmRuleIndexData record);

    List<VDmRuleIndexData> selectByExample(VDmRuleIndexDataExample example);

    int updateByExampleSelective(@Param("record") VDmRuleIndexData record, @Param("example") VDmRuleIndexDataExample example);

    int updateByExample(@Param("record") VDmRuleIndexData record, @Param("example") VDmRuleIndexDataExample example);
}