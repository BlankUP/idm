package com.idm.app.idpconfig.countAnalysis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idm.app.idpconfig.countAnalysis.model.ResponseInfo;




@Service
public class IdpResponseService {
	
	@Autowired
	com.idm.app.idpconfig.countAnalysis.mapper.IdpResponseMapper IdpResponseMapper;
  

	public int selectCountByAll(ResponseInfo ResponseInfo ) {

		return IdpResponseMapper.selectCountByAll(ResponseInfo);
	}

	public List<ResponseInfo> queryIdpResponseInfo(ResponseInfo ResponseInfo ) {

		return IdpResponseMapper.queryIdpResponseInfo(ResponseInfo);
	}


  
}
