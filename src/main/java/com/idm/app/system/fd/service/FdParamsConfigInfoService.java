package com.idm.app.system.fd.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.idm.app.system.auth.model.UserInfo;
import com.idm.app.system.fd.mapper.FdParamsConfigInfoMapper;
import com.idm.app.system.fd.model.FdParamsConfigInfo;
import com.idm.app.system.fd.model.FdParamsConfigInfoExample;

/**
 * @service 批量调度参数配置服务
 * @author liushudong	
 * @date 2019年2月25日
 *
 */
@Service
public class FdParamsConfigInfoService {
	
	@Resource
	private FdParamsConfigInfoMapper fdParamsConfigInfoMapper;
	
	public Integer selectCountByAll(String paramCode,String paramName,String paramType,String status) {
		FdParamsConfigInfoExample example = new FdParamsConfigInfoExample();
		FdParamsConfigInfoExample.Criteria criteria = example.createCriteria();
		
		if(paramCode!=null && !"".equals(paramCode)) criteria.andParamCodeLike(paramCode);
		if(paramName!=null && !"".equals(paramName)) criteria.andParamNameLike(paramName);
		if(paramType!=null && !"".equals(paramType)) criteria.andParamTypeEqualsTo(paramType);
		if(status!=null && !"".equals(status)) criteria.andStatusEqualsTo(status);
		
		return fdParamsConfigInfoMapper.selectCountByAll(example);
	}
	
	public List<UserInfo> selectByAll(int size, int page,  String paramCode,String paramName,String paramType,String status) {
		FdParamsConfigInfoExample example = new FdParamsConfigInfoExample();
		FdParamsConfigInfoExample.Criteria criteria = example.createCriteria();
		
		if(paramCode!=null && !"".equals(paramCode)) criteria.andParamCodeLike(paramCode);
		if(paramName!=null && !"".equals(paramName)) criteria.andParamNameLike(paramName);
		if(paramType!=null && !"".equals(paramType)) criteria.andParamTypeEqualsTo(paramType);
		if(status!=null && !"".equals(status)) criteria.andStatusEqualsTo(status);
		
		example.setPage(page);
		example.setSize(size);
		example.setOrderByClause("update_time desc");
		return fdParamsConfigInfoMapper.selectByAll(example);
	}
	
	public long addFdParamConfigInfo(FdParamsConfigInfo fdParamsConfigInfo) throws Exception
    {
        return fdParamsConfigInfoMapper.addFdParamConfigInfo(fdParamsConfigInfo);
    }

    public long updateFdParamConfigInfo(FdParamsConfigInfo fdParamsConfigInfo)
    {
        return fdParamsConfigInfoMapper.updateFdParamConfigInfo(fdParamsConfigInfo);
    }
    
    public long deleteFdParamConfigInfoByParamCode(String paramCode)
    {
        return fdParamsConfigInfoMapper.deleteFdParamConfigInfoByParamCode(paramCode);
    }

	public  long checkParamCode(FdParamsConfigInfo fdParamsConfigInfo) {
		// TODO Auto-generated method stub
		return fdParamsConfigInfoMapper.checkParamCode(fdParamsConfigInfo);
	}
	
	public  long checkParamName(FdParamsConfigInfo fdParamsConfigInfo) {
		// TODO Auto-generated method stub
		return fdParamsConfigInfoMapper.checkParamName(fdParamsConfigInfo);
	}
}
