package com.idm.app.idpconfig.countAnalysis.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.idm.app.idpconfig.countAnalysis.mapper.IdpRequestInfoMapper;
import com.idm.app.idpconfig.countAnalysis.model.IdpRequestInfo;

import javax.annotation.Resource;

@Service
public class IdpRequestInfoService {

	@Resource
	private IdpRequestInfoMapper IdpRequestInfoMapper;
  

	public int selectCountByAll(IdpRequestInfo idprequestinfo) {

		return IdpRequestInfoMapper.selectCountByAll(idprequestinfo);
	}

	public List<IdpRequestInfo> queryIdpRequestInfo(IdpRequestInfo idprequestinfo) {

		return IdpRequestInfoMapper.queryIdpRequestInfo(idprequestinfo);
	}

	//表格下载
    public List<IdpRequestInfo> queryIdpRequestInfoExcel(IdpRequestInfo idprequestinfo) {
		return IdpRequestInfoMapper.queryIdpRequestInfoExcel(idprequestinfo);
    }
}
