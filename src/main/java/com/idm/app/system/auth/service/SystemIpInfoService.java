package com.idm.app.system.auth.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.idm.app.system.auth.mapper.SystemIpInfoMapper;
import com.idm.app.system.auth.model.SystemIpInfo;

@Service
public class SystemIpInfoService {
	
	@Resource
	private SystemIpInfoMapper systemIpInfoMapper;

	public List<SystemIpInfo> selectByAll(SystemIpInfo systemIpInfo) {
		// TODO Auto-generated method stub
		return systemIpInfoMapper.selectByAll(systemIpInfo);
	}

	public void addSystemIp(SystemIpInfo systemIpInfo) {
		// TODO Auto-generated method stub
		systemIpInfoMapper.addSystemIp(systemIpInfo);
	}

	public void updateSystemIp(SystemIpInfo systemIpInfo) {
		// TODO Auto-generated method stub
		systemIpInfoMapper.updateSystemIp(systemIpInfo);
	}

	public Integer deleteIpBySystemId(String systemIpID) {
		// TODO Auto-generated method stub
		if(systemIpID != null && systemIpID != "") {
			return systemIpInfoMapper.deleteIpBySystemId(systemIpID);			
		}
		
		return null;
	}
	
	public Integer selectCountByAll(SystemIpInfo systemIpInfo) {
		return systemIpInfoMapper.selectCountByAll(systemIpInfo);
	}


}
