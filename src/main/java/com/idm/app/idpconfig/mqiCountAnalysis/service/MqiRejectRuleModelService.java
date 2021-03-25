package com.idm.app.idpconfig.mqiCountAnalysis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idm.app.idpconfig.mqiCountAnalysis.mapper.MqiRejectRuleModelMapper;
import com.idm.app.idpconfig.mqiCountAnalysis.model.MqiIdpRuleResult;

@Service
public class MqiRejectRuleModelService {
    @Autowired
	MqiRejectRuleModelMapper mqiRejectRuleModelMapper;
	
	public int selectCountByAll(MqiIdpRuleResult mqiIdpruleresult) {
		
		return mqiRejectRuleModelMapper.selectCountByAll(mqiIdpruleresult);
	}



	public List<MqiIdpRuleResult> queyRejectRuleModel(MqiIdpRuleResult mqiIdpruleresult) {
		
		return mqiRejectRuleModelMapper.queyRejectRuleModel(mqiIdpruleresult);
	}


  //规则结果总条数
	public int selectRuleResultCountByAll(MqiIdpRuleResult mqiIdpruleresult) {
		return mqiRejectRuleModelMapper.selectRuleResultCountByAll(mqiIdpruleresult);
	}


	  //规则结果list
	public List<MqiIdpRuleResult> queyRuleResult(MqiIdpRuleResult mqiIdpruleresult) {
		return mqiRejectRuleModelMapper. queyRuleResult(mqiIdpruleresult);
	}



	public MqiIdpRuleResult doRuleResultquery(MqiIdpRuleResult mqiIdpruleresult) {
		// TODO 自动生成的方法存根
		return mqiRejectRuleModelMapper.doRuleResultquery(mqiIdpruleresult);
	}




}
