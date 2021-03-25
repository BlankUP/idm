package com.idm.app.idpconfig.mqiAdbVersionManage.mapper;

import java.util.List;


import com.idm.app.idpconfig.mqiAdbVersionManage.model.MqiAdbApprove;
import com.idm.app.idpconfig.mqiAdbVersionManage.model.MqiAdbApproveExample;



/**
 * @author wengjiawe
 * @date 2019年3月04日
 */
public interface MqiAdbApproveMapper {
	Integer selectAdbCountAllMqi(MqiAdbApproveExample example);
	List<MqiAdbApprove> selectAdbApplicationMqi(MqiAdbApproveExample example);
	Integer updateRejectAdbApproveMqi(String versionNo);
	Integer updateSecondAdbApproveMqi(String versionNo);
	Integer updatePassAdbApproveMqi(String versionNo);
	Integer saveAdbApproveApplicationMqi(MqiAdbApprove adbApprove);
	List<String> selectStatusMqi(String versionNo);
    Integer deleteAdbApproveRecordMqi(String versionNo);
	Integer selectAdbCountAllMqi(String status);
	List<MqiAdbApprove> selectAdbApproveInfoMqi(String string);
	Integer selectAdbApproveConuntAllMqi();
	List<MqiAdbApprove> selectAdbApproveConuntMqi();
}
