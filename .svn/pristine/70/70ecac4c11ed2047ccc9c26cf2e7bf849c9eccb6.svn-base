package com.idm.app.idpconfig.countAnalysis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idm.app.idpconfig.countAnalysis.mapper.RejectRuleModelMapper;
import com.idm.app.idpconfig.countAnalysis.model.IdpRuleResult;

@Service
public class RejectRuleModelService {
    @Autowired
	RejectRuleModelMapper RejectRuleModelMapper;
	
	public int selectCountByAll(IdpRuleResult idpruleresult) {
		
		return RejectRuleModelMapper.selectCountByAll(idpruleresult);
	}



	public List<IdpRuleResult> queyRejectRuleModel(IdpRuleResult idpruleresult) {
		
		return RejectRuleModelMapper.queyRejectRuleModel(idpruleresult);
	}


  //规则结果总条数
	public int selectRuleResultCountByAll(IdpRuleResult idpruleresult) {
		return RejectRuleModelMapper.selectRuleResultCountByAll(idpruleresult);
	}


	  //规则结果list
	public List<IdpRuleResult> queyRuleResult(IdpRuleResult idpruleresult) {
		return RejectRuleModelMapper. queyRuleResult( idpruleresult);
	}



	public IdpRuleResult doRuleResultquery(IdpRuleResult idpruleresult) {
		// TODO 自动生成的方法存根
		return RejectRuleModelMapper.doRuleResultquery(idpruleresult);
	}




}
