package com.idm.app.system.auth.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.idm.app.system.auth.mapper.RoleMapper;
import com.idm.app.system.auth.model.Role;
import com.idm.app.system.auth.model.RoleExample;

@Service
public class RoleService {
	@Resource
    RoleMapper roleMapper;
	
	public Integer selectCountByAll(String roleNo){
		RoleExample example = new RoleExample();
		if(roleNo!=null && !"".equals(roleNo))	example.createCriteria().andRoleNoEqualsTo(roleNo);
		return roleMapper.selectCountByAll(example);
	}
	
	public List<Role> selectByAll(int size, int page,  String roleNo){
		RoleExample example = new RoleExample();
		if(roleNo!=null && !"".equals(roleNo))	example.createCriteria().andRoleNoEqualsTo(roleNo);
		example.setPage(page);
		example.setSize(size);
		example.setOrderByClause("updatetime desc");
		
		return roleMapper.selectByAll(example);
	}
	
	public Integer saveRoleInfo(Role role) {
		return roleMapper.saveRoleInfo(role);
	}

	public Role selectRoleInfoByRoleNo(String roleNo) {
		return roleMapper.selectRoleInfoByRoleNo(roleNo);
	}
	

	public Role selectRoleInfoByRoleName(String roleName) {
		return roleMapper.selectRoleInfoByRoleName(roleName);
	}

	public Integer updateRoleInfo(Role role) {
		return roleMapper.updateRoleInfo(role);
	}
	
	public Integer deleteRoleInfo(String roleNo) {
		return roleMapper.deleteRoleInfo(roleNo);
	}

   public String getRoleRootByRoleId(String roleNo) {
		
		return roleMapper.getRoleRootByRoleId(roleNo);
	}

   public int selectRoleRoot(String roleRoot) {
	// TODO Auto-generated method stub
	return roleMapper.selectRoleRoot(roleRoot);
}
}
