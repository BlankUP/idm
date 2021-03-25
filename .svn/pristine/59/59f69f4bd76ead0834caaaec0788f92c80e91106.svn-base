package com.idm.app.system.monitor.mapper;

import com.idm.app.system.monitor.model.ServerInfo;
import com.idm.app.system.monitor.model.ServerInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServerInfoMapper {
    long countByExample(ServerInfoExample example);

    int deleteByExample(ServerInfoExample example);

    int deleteByPrimaryKey(String serverId);

    int insert(ServerInfo record);

    int insertSelective(ServerInfo record);

    List<ServerInfo> selectByExample(ServerInfoExample example);

    ServerInfo selectByPrimaryKey(String serverId);

    int updateByExampleSelective(@Param("record") ServerInfo record, @Param("example") ServerInfoExample example);

    int updateByExample(@Param("record") ServerInfo record, @Param("example") ServerInfoExample example);

    int updateByPrimaryKeySelective(ServerInfo record);

    int updateByPrimaryKey(ServerInfo record);
}