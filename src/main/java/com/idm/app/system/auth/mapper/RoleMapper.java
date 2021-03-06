package com.idm.app.system.auth.mapper;

import java.util.List;

import com.idm.app.system.auth.model.Role;
import com.idm.app.system.auth.model.RoleExample;

public interface RoleMapper {
	Integer selectCountByAll(RoleExample example);
	List<Role> selectByAll(RoleExample example);
	Integer saveRoleInfo(Role role);
	Integer updateRoleInfo(Role role);
	Integer deleteRoleInfo(String roleNo);
	String selectFunctionsByRole(String roleNo);
	
	Role selectRoleInfoByRoleNo(String roleNo);
	Role selectRoleInfoByRoleName(String Name);
	List<String> selectRolesByUserId(String userId);
	List<String> selectFunctionsByUserId(String userId);
	String getRoleRootByRoleId(String roleNo);
	int selectRoleRoot(String roleRoot);
	
}
