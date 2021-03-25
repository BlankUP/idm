package com.idm.app.system.auth.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class Auth {
	
	private static String user;
	private static List<String> authList = new ArrayList<String>();
	
	public static void setUser(String userid) {
		Auth.user = userid;
	}

	public static String getUser() {
		return Auth.user;
	}
	
	public static List<String> getAuthList() {
		return Auth.authList;
	}
	
	public static String getAuthListString() {
		return StringUtils.join(Auth.authList.toArray(), ",");
	}
	
	public static void clear() {
		Auth.user = "";
		Auth.authList = new ArrayList<String>();
	}
	
	public static void addAuth(String auth) {
		boolean flag = false;
		for(String a: Auth.authList) {
			if(a.equals(auth)) {
				flag = true; break;
			}
		}
		if(flag == false) Auth.authList.add(auth);
	}
	
	public static void addAuthList(List<String> list) {
		for(String auth: list) {
			addAuth(auth);
		}
	}
}
