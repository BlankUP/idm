package com.idm.app.ruleengine.exceptioninfo.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.idm.app.ruleengine.exceptioninfo.model.IdpExceptionInfo;
import com.idm.app.ruleengine.exceptioninfo.model.DataInterfaceInvokInfo;

/**
 * @Description:数据操作接口  
 * @author: sjf
 * @date:   2019年3月4日
 * @Copyright: 2019 www.sunline.cn All rights reserved. 
 *
 */
public interface IdpExceptionInfoMapper {
	
	
	/**    
	 * @Description: 查询异常信息
	 * @param idpExceptionInfo    
	 * @return: List<IdpExceptionInfo>      
	 * @author sjf 
	 */
	List<IdpExceptionInfo> queryIdpExceptionInfo(IdpExceptionInfo idpExceptionInfo);
	/**
	 * 
	 *@Description:查询批量重跑的异常信息
	 *@return List<IdpExceptionInfo>
	 */
	List<IdpExceptionInfo> queryIdpExceptionInfoList();
	/**    
	 * @Description: 查询异常信息
	 * @param  businessNo - 业务流水号
	 * @return: List<IdpExceptionInfo>      
	 * @author sjf 
	 */
	IdpExceptionInfo queryIdpExceptionInfoBySeqno(String businessNo);
	
	/**    
	 * @Description: 查询数据接口调用信息
	 * @param querySeqNo
	 * @param srcDate   
	 * @return: List<String>      
	 * @author sjf 
	 */
	List<DataInterfaceInvokInfo> queryDataInvokInfo(@Param("businessNo")String businessNo);
	
	/**    
	 * @Description: 修改调用决策引擎的请求报文
	 * @param businessNo    
	 * @return: long      
	 * @author sjf 
	 */
	long updateBlazeData(@Param("businessNo")String businessNo, @Param("invokeBlazeData")String invokeBlazeData) throws SQLException;
	
	
	/**
	 * 
	 * @Description: 更新决策服务平台异常信息表中的重跑操作员、重跑日期、重跑时间
	 * @param userId
	 * @param dateStr
	 * @param timeStr    
	 * @return: long      
	 * @author sjf
	 */
	long updateIdpExceptionInfo(@Param("businessNo")String businessNo,@Param("userId")String userId,@Param("dateStr")String dateStr, @Param("timeStr")String timeStr,
			@Param("reBusinessResult")String reBusinessResult);
	
	String queryReqBlazeData(@Param("businessNo")String businessNo);
	/**
	 * 
	 *@Description:查询总记录数
	 *@param idpExceptionInfo
	 *@return
	 */
	
	int selectCountByAll(IdpExceptionInfo idpExceptionInfo);
}
