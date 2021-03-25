package com.idm.app.idpconfig.adbRuleHotDeploy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.idm.app.idpconfig.adbRuleHotDeploy.model.AdbDeployBaseInfo;
import com.idm.app.idpconfig.adbRuleHotDeploy.model.ServerInfo;

/**
 * adb规则热部署管理 
 * @author caiwenjian  
 * @date 2019年3月11日  
 * @version 1.0
 */
public interface AdbDelpoyMngMapper {
	/**  
	 *查询部署记录表信息
	 *@return  
	 */  
	List<AdbDeployBaseInfo> queryDeployInfo(AdbDeployBaseInfo deployInfo);
	 
	List<ServerInfo> queryAdbDeployServers();
	
	/**  
	 *获取待部署的文件名 
	 */  
	List<AdbDeployBaseInfo> queryAdbfileNameAndVerNo();
	
	/**  
	 *部署记录保存
	 * @return 
	 */  
	void saveAdbDeployecord(AdbDeployBaseInfo deployInfo);
	/**
	 * 
	 *@Description:修改部署记录版本状态
	 */
	void updateAdbDeployecord();
	/**  
	 *更新版本管理表的版本状态   
	 * @param updateTime 
	 * @param updateUser 
	 */   
	void updateAdbVerState(@Param("updateUser") String updateUser, @Param("updateTime")String updateTime);
	/**  
	 *更新版本管理表的版本状态   
	 * @param updateTime 
	 * @param updateUser 
	 */   
	void updateAdbVerState2(@Param("updateUser") String updateUser, @Param("updateTime")String updateTime);
	/**  
	 *更新版本管理表的版本状态   
	 * @param updateTime 
	 * @param updateUser 
	 */   
	void updateAdbVerState3(@Param("updateUser") String updateUser, @Param("updateTime")String updateTime);
	/**  
	 *部署记录保存
	 * @return 
	 */  
	void saveAdbDeployecord2(AdbDeployBaseInfo deployInfo);

	
	int selectCountByAll(AdbDeployBaseInfo deployInfo);

}
