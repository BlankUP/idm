package com.idm.app.system.auth.service;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.idm.app.system.auth.mapper.RoleMapper;

@Service
public class AuthManager {
	
	@Resource
	private RoleMapper roleMapper;
	
	public String getUserId() {
		return Auth.getUser();
	}
	
	public List<String> getUserAuthorization() {
		return Auth.getAuthList();
	}
	
	public void initUserAuthorization(String userId){
		Auth.clear(); //清空权限数据
	    List<String> functionsList = roleMapper.selectFunctionsByUserId(userId);
	    Auth.setUser(userId);
	    for(String functions: functionsList) {
		   if(functions != null && !"".equals(functions)) {
			   	String[] f = functions.split(";");
			   	Auth.addAuthList(Arrays.asList(f));
		   }
	    }
	}
	
	public void updateAuthByUserId(String userId){
		Auth.clear(); //清空权限数据
	    List<String> functionsList = roleMapper.selectFunctionsByUserId(userId);
	    Auth.setUser(userId);
	    for(String functions: functionsList) {
	    	if(functions != null && !"".equals(functions)) {
	    		String[] f = functions.split(";");
	    		Auth.addAuthList(Arrays.asList(f));
	    	}
	    }
	}
}
