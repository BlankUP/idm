package com.idm.app.idpconfig.mqiAdbVersionManage.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.idm.app.idpconfig.mqiAdbVersionManage.mapper.MqiAdbApproveMapper;
import com.idm.app.idpconfig.mqiAdbVersionManage.model.MqiAdbApprove;
import com.idm.app.idpconfig.mqiAdbVersionManage.model.MqiAdbApproveExample;

/**
 * @Service adb规则文本版本管理
 * @author wengjiawei
 * @Date 2019-03-04
 */
@Service
public class MqiAdbApproveService {
	@Resource 
	MqiAdbApproveMapper mqiadbapprovemapper;
	
   public Integer selectAdbCountAll(String status){
		
		return mqiadbapprovemapper.selectAdbCountAllMqi(status);
	}
	
	public List<MqiAdbApprove> selectAdbApplication(int size, int page,  String userId){
		MqiAdbApproveExample example = new MqiAdbApproveExample();
		if(userId!=null && !"".equals(userId)) example.createCriteria().addUserId(userId);
		example.setPage(page);
		example.setSize(size);
		example.setOrderByClause("APPLICATIONTIME desc");
		
		return mqiadbapprovemapper.selectAdbApplicationMqi(example);
	}
	
	public Integer updateRejectAdbApproveMqi(String versionNo) {
		return mqiadbapprovemapper.updateRejectAdbApproveMqi(versionNo);
	}
	
	public Integer updateSecondAdbApprove(String versionNo) {
		return mqiadbapprovemapper.updateSecondAdbApproveMqi(versionNo);
	}
	
	public Integer updatePassAdbApprove(String versionNo) {
		return mqiadbapprovemapper.updatePassAdbApproveMqi(versionNo);
	}
	
	public Integer saveAdbApproveApplication(MqiAdbApprove adbApprove) {
		return mqiadbapprovemapper.saveAdbApproveApplicationMqi(adbApprove);
	}
	
	public List<String> selectStatus(String versionNo) {
		return mqiadbapprovemapper.selectStatusMqi(versionNo);
	}
	
	public Integer deleteAdbApproveRecord(String versionNo) {
		return mqiadbapprovemapper.deleteAdbApproveRecordMqi(versionNo);
	}

	public List<MqiAdbApprove> selectAdbApproveInfo(String string) {
		// TODO 自动生成的方法存根
		return mqiadbapprovemapper.selectAdbApproveInfoMqi(string);
	}

	public Integer selectAdbApproveConuntAll() {
		// TODO 自动生成的方法存根
		return mqiadbapprovemapper.selectAdbApproveConuntAllMqi();
	}
	public List<MqiAdbApprove> selectAdbApproveConunt() {
		// TODO 自动生成的方法存根
		return mqiadbapprovemapper.selectAdbApproveConuntMqi();
	}
}
