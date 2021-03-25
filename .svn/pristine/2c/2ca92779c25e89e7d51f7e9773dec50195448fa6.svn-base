package com.idm.app.idpconfig.mqiAdbVersionManage.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.idm.app.idpconfig.mqiAdbVersionManage.mapper.MqiApproveRecordMapper;
import com.idm.app.idpconfig.mqiAdbVersionManage.model.MqiApproveRecord;
import com.idm.app.idpconfig.mqiAdbVersionManage.model.MqiApproveRecordExample;


/**
 * @Service adb审批记录
 * @author wengjiawei
 * @Date 2019-03-11
 */
@Service
public class MqiApproveRecordService {
	@Resource 
	MqiApproveRecordMapper mqiapproverecordmapper;
	
	public Integer selectCountAll(String versionNo){
		MqiApproveRecordExample example = new MqiApproveRecordExample();
		if(versionNo!=null && !"".equals(versionNo)&& !"null".equals(versionNo)) example.createCriteria().addVersionNo(versionNo);
		return mqiapproverecordmapper.selectCountAllMqi(example);
	}
	
	public List<MqiApproveRecord> selectByAll(int size, int page,  String versionNo){
		MqiApproveRecordExample example = new MqiApproveRecordExample();
		if(versionNo!=null && !"".equals(versionNo)&& !"null".equals(versionNo)) example.createCriteria().addVersionNo(versionNo);
		example.setPage(page);
		example.setSize(size);
		example.setOrderByClause("APPROVETIME desc");
		
		return mqiapproverecordmapper.selectByAllMqi(example);
	}
	
	public Integer saveApproveRecord(MqiApproveRecord approveRecord) {
		return mqiapproverecordmapper.saveApproveRecordMqi(approveRecord);
	}
}
