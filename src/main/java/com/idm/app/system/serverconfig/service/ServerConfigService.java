package com.idm.app.system.serverconfig.service;

import com.idm.app.system.serverconfig.mapper.ServerConfigMapper;
import com.idm.app.system.serverconfig.model.ServerInfo;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ServerConfigService {

    @Resource
    private ServerConfigMapper serverConfigMapper;


    public void addServer(ServerInfo serverInfo) throws Exception
    {
        serverConfigMapper.addServer(serverInfo);
    }

    public void updateServer(ServerInfo serverInfo) throws Exception
    {
        serverConfigMapper.updateServer(serverInfo);
    }

    public long deleteServer(List<String> serverIdList) throws Exception
    {
        return serverConfigMapper.deleteServer(serverIdList);
    }

	public List<ServerInfo> queryServerInfo(ServerInfo serverInfo) {
		return serverConfigMapper.queryServerInfo(serverInfo);
	}
	
	public List<ServerInfo> queryServerConfig(ServerInfo serverInfo) {
		return serverConfigMapper.queryServerConfig(serverInfo);
	}
	
	public int selectCountByAll(ServerInfo serverInfo) {
		return serverConfigMapper.selectCountByAll(serverInfo);
	}
	
	public List<ServerInfo> selectServerName(ServerInfo serverInfo) {
		return serverConfigMapper.selectServerName(serverInfo);
	}

	public long repeatServerName(ServerInfo serverInfo) {
		return serverConfigMapper.repeatServerName(serverInfo);
	}
	public List<ServerInfo> queryServers() {
		return serverConfigMapper.queryServers();
		
	}
}
