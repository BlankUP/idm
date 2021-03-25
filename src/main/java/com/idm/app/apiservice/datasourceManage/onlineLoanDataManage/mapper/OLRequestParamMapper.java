package com.idm.app.apiservice.datasourceManage.onlineLoanDataManage.mapper;

import com.idm.app.apiservice.datasourceManage.onlineLoanDataManage.model.OLRequestParam;
import com.idm.app.apiservice.datasourceManage.onlineLoanDataManage.model.OLRequestParamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OLRequestParamMapper {
    long countByExample(OLRequestParamExample example);

    int deleteByExample(OLRequestParamExample example);

    int insert(OLRequestParam record);

    int insertSelective(OLRequestParam record);

    List<OLRequestParam> selectByExample(OLRequestParamExample example);

    int updateByExampleSelective(@Param("record") OLRequestParam record, @Param("example") OLRequestParamExample example);

    int updateByExample(@Param("record") OLRequestParam record, @Param("example") OLRequestParamExample example);
}