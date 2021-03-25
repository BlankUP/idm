package com.idm.app.idpconfig.mqiCountAnalysis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idm.app.idpconfig.mqiCountAnalysis.mapper.MqiIdpResponseMapper;
import com.idm.app.idpconfig.mqiCountAnalysis.model.MqiResponseInfo;
import com.idm.app.idpconfig.mqiCountAnalysis.model.MqiResponseReport;




@Service
public class MqiIdpResponseService {
	
	@Autowired
	MqiIdpResponseMapper mqiIdpResponseMapper;
  

	public int selectCountByAll(MqiResponseReport mqiResponseInfo ) {

		return mqiIdpResponseMapper.selectCountByAll(mqiResponseInfo);
	}

	public List<MqiResponseReport> queryIdpResponseInfo(MqiResponseReport mqiResponseInfo ) {

		return mqiIdpResponseMapper.queryIdpResponseInfo(mqiResponseInfo);
	}


  
}
