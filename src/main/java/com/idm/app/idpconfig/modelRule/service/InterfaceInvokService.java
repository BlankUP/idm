package com.idm.app.idpconfig.modelRule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idm.app.idpconfig.modelRule.mapper.InterfaceInvokMapper;
import com.idm.app.idpconfig.modelRule.model.InterfaceInvokInfo;



@Service
public class InterfaceInvokService {

	@Autowired
    private InterfaceInvokMapper interfaceInvokMapper;
	
	
public List<InterfaceInvokInfo> findModelToInter() {
		
		return interfaceInvokMapper.findModelToInter();
	}
}
