package com.idm.app.ruleengine.modelManage.modelMonitor.mapper;

import com.idm.app.ruleengine.modelManage.modelMonitor.model.VScoreModelData;
import com.idm.app.ruleengine.modelManage.modelMonitor.model.VScoreModelDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VScoreModelDataMapper {
    long countByExample(VScoreModelDataExample example);

    int deleteByExample(VScoreModelDataExample example);

    int insert(VScoreModelData record);

    int insertSelective(VScoreModelData record);

    List<VScoreModelData> selectByExample(VScoreModelDataExample example);

    int updateByExampleSelective(@Param("record") VScoreModelData record, @Param("example") VScoreModelDataExample example);

    int updateByExample(@Param("record") VScoreModelData record, @Param("example") VScoreModelDataExample example);
}