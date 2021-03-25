package com.idm.app.ruleengine.modelManage.indexManage.mapper;

import com.idm.app.ruleengine.modelManage.indexManage.model.IndexData;
import com.idm.app.ruleengine.modelManage.indexManage.model.VModelIndexHitData;
import com.idm.app.ruleengine.modelManage.indexManage.model.VModelIndexHitDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VModelIndexHitDataMapper {
    long countByExample(VModelIndexHitDataExample example);

    List<VModelIndexHitData> selectByExample(VModelIndexHitDataExample example);

    List<IndexData> selectByLineData(@Param("ruleNo") String ruleNo, @Param("modleName") String modleName,@Param("productNo") String productNo);

    List<IndexData> selectByLineHitData(@Param("ruleNo") String ruleNo, @Param("modleName") String modleName,@Param("productNo") String productNo);
}