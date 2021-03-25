package com.idm.app.idpconfig.flowInfo.mapper;

import java.util.List;

import com.idm.app.idpconfig.flowInfo.model.FlowInfo;

public interface FlowInfoMapper {

	List<FlowInfo> queryFlowInfo(FlowInfo flowInfo);

	long addFlowInfo(FlowInfo flowInfo) throws Exception;

	long updateFlowInfo(FlowInfo flowInfo) throws Exception;
	
	Integer selectCountByAll(FlowInfo flowInfo);
	
	 int addFlowInfoList(List<FlowInfo> list);
	
}
