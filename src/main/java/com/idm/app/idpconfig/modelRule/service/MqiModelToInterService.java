package com.idm.app.idpconfig.modelRule.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idm.app.idpconfig.modelRule.mapper.MqiModelToInterMapper;
import com.idm.app.idpconfig.modelRule.model.MqiModelToInterInfo;



@Service
public class MqiModelToInterService {
	
	@Autowired
    private MqiModelToInterMapper mqiModelToInterMapper;

	public void saveModToInter(MqiModelToInterInfo resp) {
		// TODO Auto-generated method stub
		mqiModelToInterMapper.saveModToInter(resp);
	}

}
