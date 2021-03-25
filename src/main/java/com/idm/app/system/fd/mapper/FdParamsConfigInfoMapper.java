package com.idm.app.system.fd.mapper;

import java.util.List;

import com.idm.app.system.auth.model.UserInfo;
import com.idm.app.system.fd.model.FdParamsConfigInfo;
import com.idm.app.system.fd.model.FdParamsConfigInfoExample;

/**
 * @mapper 批量调度参数配置
 * @author liushudong
 * @date 2019年2月22日
 *
 */
public interface FdParamsConfigInfoMapper {

	public Integer selectCountByAll(FdParamsConfigInfoExample example);
	public List<UserInfo> selectByAll(FdParamsConfigInfoExample example);
	
	long addFdParamConfigInfo(FdParamsConfigInfo fdParamsConfigInfo) throws Exception;

    long updateFdParamConfigInfo(FdParamsConfigInfo fdParamsConfigInfo);
    
    long deleteFdParamConfigInfoByParamCode(String paramCode);
    long checkParamCode(FdParamsConfigInfo fdParamsConfigInfo);
    long checkParamName(FdParamsConfigInfo fdParamsConfigInfo);
}