package com.idm.app.ruleengine.exceptioninfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.idm.app.ruleengine.exceptioninfo.model.IdpAsyStoredExceptionInfo;

/**
 * <p>Title:IdpAsyStorageExceptionInfoMapper</p>
 * @Description：异步存储数据异常信息表操作接口
 * @author：jiamh
 * @createTime：2019年3月15日
 * @version 1.0
 */
public interface IdpAsyStorageExceptionInfoMapper {

	/**
	 * @Description：查找信息
	 * @param idpAsyStoredExceptionInfo
	 * @return
	 */
	List<IdpAsyStoredExceptionInfo> queryIdpAsyStoredExceptionInfo(IdpAsyStoredExceptionInfo idpAsyStoredExceptionInfo);
	
	/**
	 * @Description：查找数目
	 * @param idpAsyStoredExceptionInfo
	 * @return
	 */
	int selectCountByAll(IdpAsyStoredExceptionInfo idpAsyStoredExceptionInfo);
	
	/**
	 * @Description：根据asyStoredId获取executeSql
	 * @param asyStoredId
	 * @return
	 */
	String queryExecuteSqlByAsyStoredId(@Param("asyStoredId")String asyStoredId);
	
	/**
	 * @Description：根据asyStoredId修改数据中operateStatus和status的值
	 * @param asyStoredId
	 * @param operateStatus
	 * @param status
	 */
	void updateIdpAsyStoredExceptionInfo(@Param("asyStoredId")String asyStoredId, @Param("operateStatus")String operateStatus,@Param("status")String status,@Param("operateTime")String operateTime,@Param("userId")String userId);
}
