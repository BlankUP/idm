package com.idm.app.system.auth.mapper;

import java.util.List;
import java.util.Map;

import com.idm.app.system.auth.model.Role;
import com.idm.app.system.auth.model.UserInfo;
import com.idm.app.system.auth.model.UserInfoExample;

public interface UserInfoMapper {

	public Integer selectCountByAll(UserInfoExample example);
	public List<UserInfo> selectByAll(UserInfoExample example);
	
	public List<Map<String, Object>> selectDepList();
	public List<Map<String, Object>> selectRoleList();
	
	public String selectDepByUserId(String userId);
	public List<String> selectRoleListByUserId(String userId);
	
	public UserInfo selectUserInfoByUserId(String userId);
	public UserInfo selectUserInfoByUserName(String userName);
	
	public Integer insertUserInfo(UserInfo user);
	public Integer insertSelective(UserInfo user);
	
	public Integer updateByUserIdSelective(UserInfo user);
	public Integer updateByUserId(UserInfo user);
	
	public Integer deleteUserRoles(String userId);
	public Integer insertUserRole(Map<String, Object> params);
	
	public Integer deleteUserByUserId(String userId);
	
	public Integer updateUserpwdByUserId(UserInfo user);
	public List<Role> getroleNo(String userId);

}