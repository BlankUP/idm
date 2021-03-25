package com.idm.app.system.auth.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.idm.app.system.auth.mapper.AuthUserMapper;
import com.idm.app.system.auth.model.AuthUser;
import com.idm.app.system.auth.model.AuthUserExample;

@Service
public class AuthUserService {
	
	@Resource
	private AuthUserMapper authUserMapper;
	
	public Integer selectCountByRoleNo(String roleNo) {
		AuthUserExample example = new AuthUserExample();
		if(roleNo!=null && !"".equals(roleNo)) example.createCriteria().andUserIdEqualsTo().andRoleNoEqualsTo(roleNo);
		return authUserMapper.selectCountByRoleNo(example);
	}
	
	public List<AuthUser> selectByRoleNo(int size, int page,  String roleNo) {
		AuthUserExample example = new AuthUserExample();
		if(roleNo!=null && !"".equals(roleNo)) example.createCriteria().andUserIdEqualsTo().andRoleNoEqualsTo(roleNo);
		example.setPage(page);
		example.setSize(size);
		example.setOrderByClause("updatetime desc");
		return authUserMapper.selectByRoleNo(example);
	}
	
}
