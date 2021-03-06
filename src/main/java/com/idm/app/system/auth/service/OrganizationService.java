package com.idm.app.system.auth.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idm.app.idpconfig.mqiAdbRuleHotDeploy.model.MqiServerInfo;
import com.idm.app.system.auth.mapper.OrganizationMapper;
import com.idm.app.system.auth.model.Organization;
import com.idm.app.system.auth.model.OrganizationExample;
import com.idm.app.system.auth.model.Role;

@Service
public class OrganizationService {
	@Resource
	@Autowired
   private OrganizationMapper organizationMapper;
	
	
	public Integer saveOrgInfo(Organization org) {
		return organizationMapper.saveOrgInfo(org);
	}

	public Integer updateOrgInfo(Organization org) {
		return organizationMapper.updateOrgInfo(org);
	}
	

	public List<Organization> selectAllByStruts() {
		// TODO Auto-generated method stub
		return organizationMapper.selectAllByStruts();
	}

	public List<MqiServerInfo> queryServers() {
		
		return organizationMapper.queryServers();
		
	}
	
}
