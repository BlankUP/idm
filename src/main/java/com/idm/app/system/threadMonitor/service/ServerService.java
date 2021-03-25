package com.idm.app.system.threadMonitor.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import com.idm.app.system.threadMonitor.mapper.ServerMapper;
import com.idm.app.system.threadMonitor.model.ServerInfo;


/** 
* @author: BaiY
* @version 创建时间：2019年5月13日 下午1:28:10 
* 类说明 
*/
@Service
public class ServerService {
	
	
	@Resource
    private ServerMapper serverMapper;
	
	
	public List<ServerInfo> queryServer() {
		
		return serverMapper.queryServerInfo();
	}
     public ServerInfo queryServerById(String id) {
		
		return serverMapper.queryServerById(id);
	}
	  
	

}
