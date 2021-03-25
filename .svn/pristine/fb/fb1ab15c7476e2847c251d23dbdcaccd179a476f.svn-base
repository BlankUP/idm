package com.idm.app.idpconfig.adbVersionManage.mapper;

import java.util.List;

import com.idm.app.idpconfig.adbVersionManage.model.AdbApprove;
import com.idm.app.idpconfig.adbVersionManage.model.AdbApproveExample;

/**
 * @author wengjiawe
 * @date 2019年3月04日
 */
public interface AdbApproveMapper {
	Integer selectAdbCountAll(AdbApproveExample example);
	List<AdbApprove> selectAdbApplication(AdbApproveExample example);
	Integer updateRejectAdbApprove(String versionNo);
	Integer updateSecondAdbApprove(String versionNo);
	Integer updatePassAdbApprove(String versionNo);
	Integer saveAdbApproveApplication(AdbApprove adbApprove);
	List<String> selectStatus(String versionNo);
    Integer deleteAdbApproveRecord(String versionNo);
	Integer selectAdbCountAll(String status);
	List<AdbApprove> selectAdbApproveInfo(String string);
	Integer selectAdbApproveConuntAll();
	List<AdbApprove> selectAdbApproveConunt();
}
