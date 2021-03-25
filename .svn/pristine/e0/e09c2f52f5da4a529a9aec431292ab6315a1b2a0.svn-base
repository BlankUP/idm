package com.idm.app.ruleengine.exceptioninfo.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.idm.app.ruleengine.exceptioninfo.controller.IdpAsyStorageExceptionMngController;
import com.idm.app.ruleengine.exceptioninfo.mapper.IdpAsyStorageExceptionInfoMapper;
import com.idm.app.ruleengine.exceptioninfo.model.IdpAsyStoredExceptionInfo;

/**
 * <p>Title:IdpAsyStoredInfoService</p>
 * @Description：异步存储数据异常信息service层
 * @author：jiamh
 * @createTime：2019年4月22日
 * @version 1.0
 */
@Service
public class IdpAsyStoredInfoService {

	
	@Resource
	private IdpAsyStorageExceptionInfoMapper idpAsyStorageExceptionInfoMapper;
	
	
	/**
	 * @Description：查找信息
	 * @param idpAsyStoredExceptionInfo
	 * @return
	 */
	public List<IdpAsyStoredExceptionInfo> queryIdpAsyStoredExceptionInfo(IdpAsyStoredExceptionInfo idpAsyStoredExceptionInfo){
		return idpAsyStorageExceptionInfoMapper.queryIdpAsyStoredExceptionInfo(idpAsyStoredExceptionInfo);
	}
	
	/**
	 *  @Description：查找数目
	 * @param idpAsyStoredExceptionInfo
	 * @return
	 */
	public int selectCountByAll(IdpAsyStoredExceptionInfo idpAsyStoredExceptionInfo){
		return idpAsyStorageExceptionInfoMapper.selectCountByAll(idpAsyStoredExceptionInfo);
	}
	
	/**
	 * @Description：根据asyStoredId获取executeSql
	 * @param asyStoredId
	 * @return
	 */
	public String queryExecuteSqlByAsyStoredId(@Param("asyStoredId")String asyStoredId){
		return idpAsyStorageExceptionInfoMapper.queryExecuteSqlByAsyStoredId(asyStoredId);
	}
	
	/**
	 * @Description：根据asyStoredId修改数据中operateStatus和status的值
	 * @param asyStoredId
	 * @param operateStatus
	 * @param status
	 */
	public void updateIdpAsyStoredExceptionInfo(@Param("asyStoredId")String asyStoredId, @Param("operateStatus")String operateStatus,@Param("status")String status,@Param("operateTime")String operateTime,@Param("userId")String userId){
		idpAsyStorageExceptionInfoMapper.updateIdpAsyStoredExceptionInfo(asyStoredId, operateStatus, status, operateTime, userId);
	}
	

}
