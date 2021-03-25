package com.idm.app.idpconfig.mqiCountAnalysis.mapper;

import java.util.List;

import com.idm.app.idpconfig.mqiCountAnalysis.model.MqiIdpRequestInfo;
import com.idm.app.idpconfig.mqiCountAnalysis.model.MqiRequestReportTest;




public interface MqiIdpRequestInfoMapper {

	int selectCountByAll(MqiRequestReportTest mqiIdpRequestInfo);

	List<MqiRequestReportTest> queryIdpRequestInfo(MqiRequestReportTest mqiIdpRequestInfo);
	
	

}
