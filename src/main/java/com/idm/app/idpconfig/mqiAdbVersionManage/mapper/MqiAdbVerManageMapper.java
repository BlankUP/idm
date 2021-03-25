package com.idm.app.idpconfig.mqiAdbVersionManage.mapper;

import java.util.List;


import com.idm.app.idpconfig.mqiAdbVersionManage.model.MqiAdbVerExample;
import com.idm.app.idpconfig.mqiAdbVersionManage.model.MqiAdbVerInfo;



/**
 * @author wengjiawe
 * @date 2019年3月04日
 */
public interface MqiAdbVerManageMapper {
	Integer selectCountByAllMqi(MqiAdbVerExample example);
	List<MqiAdbVerInfo> selectByAllMqi(MqiAdbVerExample example);
	Integer saveAdbVerInfoMqi(MqiAdbVerInfo adbVerInfo);
	Integer updateAdbVerInfoMqi(MqiAdbVerInfo adbVerInfo);
	Integer deleteAdbVerInfoMqi(String versionNo);
	Integer checkAdbVerStateMqi(MqiAdbVerExample example);
	List<Integer> selectMaxIdMqi(); 
	Integer setAdbVerStateMqi(String versionState);
	Integer publishOrRecoverAdbVerMqi(MqiAdbVerInfo adbVerInfo);
	List<String> selectMaxVersionNoMqi();
	List<String> selectVersionStateMqi(String versionState);	
	List<String> selectVersionIsValidMqi(String versionState);
	List<String> selectFileNameMqi();
	Integer setAdbVerStatusMqi(String fileName);
	Integer updateApproveStateMqi(MqiAdbVerInfo adbVerInfo);
	Integer checkApproveOrNotMqi();
	long repeatvisonameMqi(MqiAdbVerInfo config);
}
