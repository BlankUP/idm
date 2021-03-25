package com.idm.app.system.serverconfig.mapper;

import com.idm.app.system.serverconfig.model.ServerInfo;

import java.util.List;

public interface ServerConfigMapper {

	List<ServerInfo> queryServerInfo(ServerInfo serverInfo);
	
	List<ServerInfo> queryServerConfig(ServerInfo serverInfo);

	
	int selectCountByAll(ServerInfo serverInfo);
	
	void addServer(ServerInfo serverInfo) throws Exception;

    long updateServer(ServerInfo serverInfo) throws Exception;

    long deleteServer(List<String> serverIdList) throws Exception;
    

	List<ServerInfo> selectServerName(ServerInfo serverInfo);

	long repeatServerName(ServerInfo serverInfo);

	List<ServerInfo> queryServers();
}
