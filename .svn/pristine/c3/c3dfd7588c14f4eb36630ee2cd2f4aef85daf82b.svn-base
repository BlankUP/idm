package com.idm.app.idpconfig.adbVersionManage.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.idm.app.idpconfig.adbVersionManage.mapper.AdbApproveMapper;
import com.idm.app.idpconfig.adbVersionManage.model.AdbApprove;
import com.idm.app.idpconfig.adbVersionManage.model.AdbApproveExample;

/**
 * @Service adb规则文本版本管理
 * @author wengjiawei
 * @Date 2019-03-04
 */
@Service
public class AdbApproveService {
	@Resource 
	AdbApproveMapper adbApproveMapper;
	
   public Integer selectAdbCountAll(String status){
		
		return adbApproveMapper.selectAdbCountAll(status);
	}
	
	public List<AdbApprove> selectAdbApplication(int size, int page,  String userId){
		AdbApproveExample example = new AdbApproveExample();
		if(userId!=null && !"".equals(userId)) example.createCriteria().addUserId(userId);
		example.setPage(page);
		example.setSize(size);
		example.setOrderByClause("APPLICATIONTIME desc");
		
		return adbApproveMapper.selectAdbApplication(example);
	}
	
	public Integer updateRejectAdbApprove(String versionNo) {
		return adbApproveMapper.updateRejectAdbApprove(versionNo);
	}
	
	public Integer updateSecondAdbApprove(String versionNo) {
		return adbApproveMapper.updateSecondAdbApprove(versionNo);
	}
	
	public Integer updatePassAdbApprove(String versionNo) {
		return adbApproveMapper.updatePassAdbApprove(versionNo);
	}
	
	public Integer saveAdbApproveApplication(AdbApprove adbApprove) {
		return adbApproveMapper.saveAdbApproveApplication(adbApprove);
	}
	
	public List<String> selectStatus(String versionNo) {
		return adbApproveMapper.selectStatus(versionNo);
	}
	
	public Integer deleteAdbApproveRecord(String versionNo) {
		return adbApproveMapper.deleteAdbApproveRecord(versionNo);
	}

	public List<AdbApprove> selectAdbApproveInfo(String string) {
		// TODO 自动生成的方法存根
		return adbApproveMapper.selectAdbApproveInfo(string);
	}

	public Integer selectAdbApproveConuntAll() {
		// TODO 自动生成的方法存根
		return adbApproveMapper.selectAdbApproveConuntAll();
	}
	public List<AdbApprove> selectAdbApproveConunt() {
		// TODO 自动生成的方法存根
		return adbApproveMapper.selectAdbApproveConunt();
	}
}
