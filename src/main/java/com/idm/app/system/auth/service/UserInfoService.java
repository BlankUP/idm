package com.idm.app.system.auth.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.idm.app.system.auth.mapper.UserInfoMapper;
import com.idm.app.system.auth.model.Role;
import com.idm.app.system.auth.model.UserInfo;
import com.idm.app.system.auth.model.UserInfoExample;


@Service
public class UserInfoService {
	
	@Resource
	private UserInfoMapper userInfoMapper;
	
	public Integer selectCountByAll(String userName) {
		UserInfoExample example = new UserInfoExample();
		if(userName!=null && !"".equals(userName)) example.createCriteria().andUserNameLike(userName);
		return userInfoMapper.selectCountByAll(example);
	}
	
	public List<UserInfo> selectByAll(int size, int page,  String userName) {
		UserInfoExample example = new UserInfoExample();
		if(userName!=null && !"".equals(userName)) example.createCriteria().andUserNameLike(userName);
		example.setPage(page);
		example.setSize(size);
		example.setOrderByClause("updatetime desc");
		return userInfoMapper.selectByAll(example);
	}
	
	public List<Map<String, Object>> selectDepList() {
		return userInfoMapper.selectDepList();
	}
	
	public List<Map<String, Object>> selectRoleList() {
		return userInfoMapper.selectRoleList();
	}
	
	public String selectDepByUserId(String userId) {
		return userInfoMapper.selectDepByUserId(userId);
	}
	
	public List<String> selectRoleListByUserId(String userId) {
		return userInfoMapper.selectRoleListByUserId(userId);
	}
	
	public UserInfo selectUserInfoByUserId(String userId) {
		return userInfoMapper.selectUserInfoByUserId(userId);
	}
	
	public UserInfo selectUserInfoByUserName(String userName) {
		return userInfoMapper.selectUserInfoByUserName(userName);
	}
	
	public Integer saveUserInfo(UserInfo user, String roles) {
		Integer result = userInfoMapper.insertUserInfo(user);
		if(roles != null && !"".equals(roles)){
			updateUserRoles(user.getUserId(), roles);
		}
		return result;
	}
	
	public Integer updateUserInfo(UserInfo user, String roles) {
		Integer result = userInfoMapper.updateByUserId(user);
		if(roles != null && !"".equals(roles)){
			updateUserRoles(user.getUserId(), roles);
		}
		return result;
	}
	
	public Integer updateUserRoles(String userId, String roles) {
		userInfoMapper.deleteUserRoles(userId);    //清空用户角色
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		String[] roleArr = roles.split(",");
		for(int i=0; i<roleArr.length; i++) {
			params.put("userId", userId);
			params.put("roleNo", roleArr[i]);
			userInfoMapper.insertUserRole(params);
		}
		return null;
	}
	
	public Integer deleteUserByUserId(String userId) {
		if(userId!=null && !"root".equals(userId)) {
			return userInfoMapper.deleteUserByUserId(userId);
		}
		return null;
	}
	
	public Integer updateUserpwdByUserId(UserInfo user) {
		Integer result = userInfoMapper.updateUserpwdByUserId(user);
		return result;
	}

     public List<Role> getroleno(String userId){
		
		List<Role> roleo = userInfoMapper.getroleNo(userId);
		return roleo;
		
	}
}
