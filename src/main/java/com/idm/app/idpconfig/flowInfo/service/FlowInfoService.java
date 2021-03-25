package com.idm.app.idpconfig.flowInfo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.idm.app.idpconfig.flowInfo.mapper.FlowInfoMapper;
import com.idm.app.idpconfig.flowInfo.model.FlowInfo;


@Service
public class FlowInfoService {
    @Resource
    FlowInfoMapper flowInfoMapper;
    
    /**
     * 
     * @Description: 
     * @param FlowInfo
     * @return
     */
    public List<FlowInfo> queryFlowInfo(FlowInfo flowInfo)
    {
        return flowInfoMapper.queryFlowInfo(flowInfo);
    }
    
    public long addFlowInfo(FlowInfo flowInfo) throws Exception
    {
        return flowInfoMapper.addFlowInfo(flowInfo);
    }
    
    public long updateFlowInfo(FlowInfo flowInfo) throws Exception
    {
        return flowInfoMapper.updateFlowInfo(flowInfo);
    }

    public Integer selectCountByAll(FlowInfo flowInfo) 
    {
        return flowInfoMapper.selectCountByAll(flowInfo);
    }
    
    public int addFlowInfoList(List<FlowInfo> list) throws Exception
    {
    	int number =flowInfoMapper.addFlowInfoList(list);
        return number;
    }
    
	
}
