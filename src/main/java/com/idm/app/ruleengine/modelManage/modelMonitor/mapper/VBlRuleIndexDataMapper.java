package com.idm.app.ruleengine.modelManage.modelMonitor.mapper;

import com.idm.app.ruleengine.modelManage.modelMonitor.model.VBlRuleIndexData;
import com.idm.app.ruleengine.modelManage.modelMonitor.model.VBlRuleIndexDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VBlRuleIndexDataMapper {
    long countByExample(VBlRuleIndexDataExample example);

    int deleteByExample(VBlRuleIndexDataExample example);

    int insert(VBlRuleIndexData record);

    int insertSelective(VBlRuleIndexData record);

    List<VBlRuleIndexData> selectByExample(VBlRuleIndexDataExample example);

    int updateByExampleSelective(@Param("record") VBlRuleIndexData record, @Param("example") VBlRuleIndexDataExample example);

    int updateByExample(@Param("record") VBlRuleIndexData record, @Param("example") VBlRuleIndexDataExample example);
}