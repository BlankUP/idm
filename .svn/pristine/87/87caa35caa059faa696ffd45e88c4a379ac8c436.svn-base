package com.idm.app.apiservice.datasourceManage.onlineLoanDataManage.mapper;

import com.idm.app.apiservice.datasourceManage.onlineLoanDataManage.model.OLResponseParam;
import com.idm.app.apiservice.datasourceManage.onlineLoanDataManage.model.OLResponseParamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OLResponseParamMapper {
    long countByExample(OLResponseParamExample example);

    int deleteByExample(OLResponseParamExample example);

    int insert(OLResponseParam record);

    int insertSelective(OLResponseParam record);

    List<OLResponseParam> selectByExample(OLResponseParamExample example);

    int updateByExampleSelective(@Param("record") OLResponseParam record, @Param("example") OLResponseParamExample example);

    int updateByExample(@Param("record") OLResponseParam record, @Param("example") OLResponseParamExample example);
}