package com.idm.app.apiservice.exceptionManage.mapper;

import com.idm.app.apiservice.exceptionManage.model.ErrorlogInfo;
import com.idm.app.apiservice.exceptionManage.model.ErrorlogInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErrorlogInfoMapper {
    long countByExample(ErrorlogInfoExample example);

    List<ErrorlogInfo> selectByExampleWithBLOBs(ErrorlogInfoExample example);

    List<ErrorlogInfo> selectByExample(ErrorlogInfoExample example);
}