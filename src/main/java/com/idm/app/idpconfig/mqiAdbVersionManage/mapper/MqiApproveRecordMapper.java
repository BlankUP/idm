package com.idm.app.idpconfig.mqiAdbVersionManage.mapper;

import java.util.List;
import com.idm.app.idpconfig.mqiAdbVersionManage.model.MqiApproveRecord;
import com.idm.app.idpconfig.mqiAdbVersionManage.model.MqiApproveRecordExample;



/**
 * @author wengjiawe
 * @date 2019年3月18日
 */
public interface MqiApproveRecordMapper {
	Integer selectCountAllMqi(MqiApproveRecordExample example);
	List<MqiApproveRecord> selectByAllMqi(MqiApproveRecordExample example);
	Integer saveApproveRecordMqi(MqiApproveRecord approveRecord);
}
