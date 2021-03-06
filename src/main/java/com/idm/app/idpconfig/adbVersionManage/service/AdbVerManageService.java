package com.idm.app.idpconfig.adbVersionManage.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.idm.app.idpconfig.adbVersionManage.mapper.AdbVerManageMapper;
import com.idm.app.idpconfig.adbVersionManage.model.AdbVerExample;
import com.idm.app.idpconfig.adbVersionManage.model.AdbVerInfo;

/**
 * @Service adb规则文本版本管理
 * @author wengjiawei
 * @Date 2019-03-04
 */
@Service
public class AdbVerManageService {
	@Resource 
	AdbVerManageMapper adbVerManageMapper;
	static final Logger logger = Logger.getLogger(AdbVerManageService.class);
	
	public Integer selectCountByAll(String versionNo){
		AdbVerExample example = new AdbVerExample();
		if(versionNo!=null && !"".equals(versionNo) && !"null".equals(versionNo))	example.createCriteria().andVersionNoLikeTo(versionNo);
		return adbVerManageMapper.selectCountByAll(example);
	}
	
	public List<AdbVerInfo> selectByAll(int size, int page,  String versionNo){
		AdbVerExample example = new AdbVerExample();
		logger.info("versionNo12-------" + versionNo);
		if(versionNo!=null && !"".equals(versionNo) && !"null".equals(versionNo)) example.createCriteria().andVersionNoLikeTo(versionNo);
		example.setPage(page);
		example.setSize(size);
		example.setOrderByClause("versionstate asc");
		
		return adbVerManageMapper.selectByAll(example);
	}
	
	public Integer saveAdbVerInfo(AdbVerInfo adbVerInfo) {
		return adbVerManageMapper.saveAdbVerInfo(adbVerInfo);
	}

	public Integer updateAdbVerInfo(AdbVerInfo adbVerInfo) {
		return adbVerManageMapper.updateAdbVerInfo(adbVerInfo);
	}
	
	public Integer deleteAdbVerInfo(String versionNo) {
		return adbVerManageMapper.deleteAdbVerInfo(versionNo);
	}
	
	public Integer checkAdbVerState(String versionNo) {
		AdbVerExample example = new AdbVerExample();
		if(versionNo!=null && !"".equals(versionNo)) example.createCriteria().andVersionNoEqualsTo(versionNo);
		return adbVerManageMapper.checkAdbVerState(example);
	}
	
	public List<Integer> selectMaxId(){
		return adbVerManageMapper.selectMaxId();
	}
	
	public Integer setAdbVerState(String versionState){
		return adbVerManageMapper.setAdbVerState(versionState);
	}
	
	public Integer publishOrRecoverAdbVer(AdbVerInfo adbVerInfo){
		return adbVerManageMapper.publishOrRecoverAdbVer(adbVerInfo);
	}
	
	public List<String> selectMaxVersionNo(){
		return adbVerManageMapper.selectMaxVersionNo();
	}
	
	public List<String> selectVersionState(String versionNo){
		return adbVerManageMapper.selectVersionState(versionNo);
	}
	
	public List<String> selectVersionIsValid(String versionNo){
		return adbVerManageMapper.selectVersionIsValid(versionNo);
	}
	
	public List<String> selectFileName(){
		return adbVerManageMapper.selectFileName();
	}
	
	public Integer setAdbVerStatus(String fileName){
		return adbVerManageMapper.setAdbVerStatus(fileName);
	}
	
	public Integer updateApproveState(AdbVerInfo adbVerInfo){
		return adbVerManageMapper.updateApproveState(adbVerInfo);
	}
	
	public Integer checkApproveOrNot(){
		return adbVerManageMapper.checkApproveOrNot();
	}

	public long repeatvisoname(AdbVerInfo config) {
		
		return adbVerManageMapper.repeatvisoname(config);
	}

	public long repeatversionNo(AdbVerInfo config) {
		// TODO Auto-generated method stub
		return adbVerManageMapper.repeatversionNo(config);
	}
}
