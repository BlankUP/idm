package com.idm.app.idpconfig.modelRule.mapper;

import java.util.List;

import com.idm.app.idpconfig.modelRule.model.InterfaceInvokInfo;
import com.idm.app.idpconfig.modelRule.model.MqiModelToInterInfo;

public interface MqiModelToInterMapper {

	List<InterfaceInvokInfo> findModelToInter();

	void saveModToInter(MqiModelToInterInfo resp);

}
