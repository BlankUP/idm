package com.idm.app.idpconfig.mqiAdbVersionManage.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import com.idm.app.idpconfig.mqiAdbVersionManage.mapper.MqiAdbVerManageMapper;
import com.idm.app.idpconfig.mqiAdbVersionManage.model.MqiAdbVerExample;
import com.idm.app.idpconfig.mqiAdbVersionManage.model.MqiAdbVerInfo;


/**
 * @Service adb规则文本版本管理
 * @author wengjiawei
 * @Date 2019-03-04
 */
@Service
public class MqiAdbVerManageService {
	@Resource 
	MqiAdbVerManageMapper mqiadbvermanagemapper;
	static final Logger logger = Logger.getLogger(MqiAdbVerManageService.class);
	
	public Integer selectCountByAllMqi(String versionNo){
		MqiAdbVerExample example = new MqiAdbVerExample();
		if(versionNo!=null && !"".equals(versionNo) && !"null".equals(versionNo))	example.createCriteria().andVersionNoLikeTo(versionNo);
		return mqiadbvermanagemapper.selectCountByAllMqi(example);
	}
	
	public List<MqiAdbVerInfo> selectByAllMqi(int size, int page,  String versionNo){
		MqiAdbVerExample example = new MqiAdbVerExample();
		logger.info("versionNo12-------" + versionNo);
		if(versionNo!=null && !"".equals(versionNo) && !"null".equals(versionNo)) example.createCriteria().andVersionNoLikeTo(versionNo);
		example.setPage(page);
		example.setSize(size);
		example.setOrderByClause("versionstate asc");
		
		return mqiadbvermanagemapper.selectByAllMqi(example);
	}
	
	public Integer saveAdbVerInfoMqi(MqiAdbVerInfo adbVerInfo) {
		return mqiadbvermanagemapper.saveAdbVerInfoMqi(adbVerInfo);
	}

	public Integer updateAdbVerInfoMqi(MqiAdbVerInfo adbVerInfo) {
		return mqiadbvermanagemapper.updateAdbVerInfoMqi(adbVerInfo);
	}
	
	public Integer deleteAdbVerInfoMqi(String versionNo) {
		return mqiadbvermanagemapper.deleteAdbVerInfoMqi(versionNo);
	}
	
	public Integer checkAdbVerStateMqi(String versionNo) {
		MqiAdbVerExample example = new MqiAdbVerExample();
		if(versionNo!=null && !"".equals(versionNo)) example.createCriteria().andVersionNoEqualsTo(versionNo);
		return mqiadbvermanagemapper.checkAdbVerStateMqi(example);
	}
	
	public List<Integer> selectMaxIdMqi(){
		return mqiadbvermanagemapper.selectMaxIdMqi();
	}
	
	public Integer setAdbVerStateMqi(String versionState){
		return mqiadbvermanagemapper.setAdbVerStateMqi(versionState);
	}
	
	public Integer publishOrRecoverAdbVerMqi(MqiAdbVerInfo adbVerInfo){
		return mqiadbvermanagemapper.publishOrRecoverAdbVerMqi(adbVerInfo);
	}
	
	public List<String> selectMaxVersionNoMqi(){
		return mqiadbvermanagemapper.selectMaxVersionNoMqi();
	}
	
	public List<String> selectVersionStateMqi(String versionNo){
		return mqiadbvermanagemapper.selectVersionStateMqi(versionNo);
	}
	
	public List<String> selectVersionIsValidMqi(String versionNo){
		return mqiadbvermanagemapper.selectVersionIsValidMqi(versionNo);
	}
	
	public List<String> selectFileNameMqi(){
		return mqiadbvermanagemapper.selectFileNameMqi();
	}
	
	public Integer setAdbVerStatusMqi(String fileName){
		return mqiadbvermanagemapper.setAdbVerStatusMqi(fileName);
	}
	
	public Integer updateApproveStateMqi(MqiAdbVerInfo adbVerInfo){
		return mqiadbvermanagemapper.updateApproveStateMqi(adbVerInfo);
	}
	
	public Integer checkApproveOrNotMqi(){
		return mqiadbvermanagemapper.checkApproveOrNotMqi();
	}

	public long repeatvisonameMqi(MqiAdbVerInfo config) {
		
		return mqiadbvermanagemapper.repeatvisonameMqi(config);
	}
}
