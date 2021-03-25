package com.idm.app.idpconfig.mqiAdbRuleHotDeploy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.idm.app.idpconfig.mqiAdbRuleHotDeploy.model.MqiAdbDeployBaseInfo;
import com.idm.app.idpconfig.mqiAdbRuleHotDeploy.model.MqiServerInfo;

/**
 * adb规则热部署管理 
 * @author caiwenjian  
 * @date 2019年3月11日  
 * @version 1.0
 */
public interface MqiAdbDelpoyMngMapper {
	/**  
	 *查询部署记录表信息
	 *@return  
	 */  
	List<MqiAdbDeployBaseInfo> queryDeployInfoMqi(MqiAdbDeployBaseInfo deployInfo);
	 
	List<MqiServerInfo> queryAdbDeployServersMqi();
	
	/**  
	 *获取待部署的文件名 
	 */  
	List<MqiAdbDeployBaseInfo> queryAdbfileNameAndVerNoMqi();
	
	/**  
	 *部署记录保存
	 * @return 
	 */  
	void saveAdbDeployecordMqi(MqiAdbDeployBaseInfo deployInfo);
	/**
	 * 
	 *@Description:修改部署记录版本状态
	 */
	void updateAdbDeployecordMqi();
	/**  
	 *更新版本管理表的版本状态   
	 * @param updateTime 
	 * @param updateUser 
	 */   
	void updateAdbVerStateMqi(@Param("updateUser") String updateUser, @Param("updateTime")String updateTime);
	/**  
	 *更新版本管理表的版本状态   
	 * @param updateTime 
	 * @param updateUser 
	 */   
	void updateAdbVerState2Mqi(@Param("updateUser") String updateUser, @Param("updateTime")String updateTime);
	/**  
	 *更新版本管理表的版本状态   
	 * @param updateTime 
	 * @param updateUser 
	 */   
	void updateAdbVerState3Mqi(@Param("updateUser") String updateUser, @Param("updateTime")String updateTime);
	/**  
	 *部署记录保存
	 * @return 
	 */  
	void saveAdbDeployecord2Mqi(MqiAdbDeployBaseInfo deployInfo);

	
	int selectCountByAllMqi(MqiAdbDeployBaseInfo deployInfo);

}
