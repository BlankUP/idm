package com.idm.app.system.auth.mapper;

import java.util.List;

import com.idm.app.system.auth.model.AuthUser;
import com.idm.app.system.auth.model.AuthUserExample;

public interface AuthUserMapper {
	
	Integer selectCountByRoleNo(AuthUserExample example);
	List<AuthUser> selectByRoleNo(AuthUserExample example);

}
