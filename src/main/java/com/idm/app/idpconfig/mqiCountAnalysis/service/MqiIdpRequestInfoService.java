package com.idm.app.idpconfig.mqiCountAnalysis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idm.app.idpconfig.mqiCountAnalysis.mapper.MqiIdpRequestInfoMapper;
import com.idm.app.idpconfig.mqiCountAnalysis.model.MqiRequestReportTest;





@Service
public class MqiIdpRequestInfoService {
	
	@Autowired
	MqiIdpRequestInfoMapper mqiIdpRequestInfoMapper;
  

	public int selectCountByAll(MqiRequestReportTest mqiIdpRequestInfo) {

		return mqiIdpRequestInfoMapper.selectCountByAll(mqiIdpRequestInfo);
	}

	public List<MqiRequestReportTest> queryIdpRequestInfo(MqiRequestReportTest mqiIdpRequestInfo) {

		return mqiIdpRequestInfoMapper.queryIdpRequestInfo(mqiIdpRequestInfo);
	}


  
}
