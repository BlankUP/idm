package com.idm.app.idpconfig.adbVersionManage.mapper;

import java.util.List;

import com.idm.app.idpconfig.adbVersionManage.model.AdbVerInfo;
import com.idm.app.idpconfig.adbVersionManage.model.AdbVerExample;;

/**
 * @author wengjiawe
 * @date 2019年3月04日
 */
public interface AdbVerManageMapper {
	Integer selectCountByAll(AdbVerExample example);
	List<AdbVerInfo> selectByAll(AdbVerExample example);
	Integer saveAdbVerInfo(AdbVerInfo adbVerInfo);
	Integer updateAdbVerInfo(AdbVerInfo adbVerInfo);
	Integer deleteAdbVerInfo(String versionNo);
	Integer checkAdbVerState(AdbVerExample example);
	List<Integer> selectMaxId(); 
	Integer setAdbVerState(String versionState);
	Integer publishOrRecoverAdbVer(AdbVerInfo adbVerInfo);
	List<String> selectMaxVersionNo();
	List<String> selectVersionState(String versionState);	
	List<String> selectVersionIsValid(String versionState);
	List<String> selectFileName();
	Integer setAdbVerStatus(String fileName);
	Integer updateApproveState(AdbVerInfo adbVerInfo);
	Integer checkApproveOrNot();
	long repeatvisoname(AdbVerInfo config);
	long repeatversionNo(AdbVerInfo config);
}
