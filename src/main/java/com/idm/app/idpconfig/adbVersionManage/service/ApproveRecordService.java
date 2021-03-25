package com.idm.app.idpconfig.adbVersionManage.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.idm.app.idpconfig.adbVersionManage.mapper.ApproveRecordMapper;
import com.idm.app.idpconfig.adbVersionManage.model.ApproveRecord;
import com.idm.app.idpconfig.adbVersionManage.model.ApproveRecordExample;

/**
 * @Service adb审批记录
 * @author wengjiawei
 * @Date 2019-03-11
 */
@Service
public class ApproveRecordService {
	@Resource 
	ApproveRecordMapper approveRecordMapper;
	
	public Integer selectCountAll(String versionNo){
		ApproveRecordExample example = new ApproveRecordExample();
		if(versionNo!=null && !"".equals(versionNo)&& !"null".equals(versionNo)) example.createCriteria().addVersionNo(versionNo);
		return approveRecordMapper.selectCountAll(example);
	}
	
	public List<ApproveRecord> selectByAll(int size, int page,  String versionNo){
		ApproveRecordExample example = new ApproveRecordExample();
		if(versionNo!=null && !"".equals(versionNo)&& !"null".equals(versionNo)) example.createCriteria().addVersionNo(versionNo);
		example.setPage(page);
		example.setSize(size);
		example.setOrderByClause("APPROVETIME desc");
		
		return approveRecordMapper.selectByAll(example);
	}
	
	public Integer saveApproveRecord(ApproveRecord approveRecord) {
		return approveRecordMapper.saveApproveRecord(approveRecord);
	}
}
