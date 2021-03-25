package com.idm.app.idpconfig.adbRuleHotDeploy.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.idm.app.idpconfig.adbRuleHotDeploy.mapper.AdbDelpoyMngMapper;
import com.idm.app.idpconfig.adbRuleHotDeploy.model.AdbDeployBaseInfo;
import com.idm.app.idpconfig.adbRuleHotDeploy.model.ServerInfo;


/**
* <p>Desc:adb规则热部署后台service类 </p>  
* @author caiwenjian  
* @date 2019年3月15日  
* @version 1.0
 */
@Service
public class AdbDeployMngService {
	
	@Resource 
	AdbDelpoyMngMapper adbDelpoyMngMapper;	//版本部署类

	/**  
	 *查询代部署列表信息
	 *@return  
	 */  
	public List<AdbDeployBaseInfo> queryDeployInfo(AdbDeployBaseInfo deployInfo) {
		
		return adbDelpoyMngMapper.queryDeployInfo(deployInfo);
	}
	/**  
	 *获取待部署的服务器
	 */  
	public List<ServerInfo> queryAdbDeployServers() {
		
		return adbDelpoyMngMapper.queryAdbDeployServers();
	}
	
	/**  
	 *获取待部署的文件名
	 */  
	public List<AdbDeployBaseInfo> queryAdbfileNameAndVerNo() {
		
		return adbDelpoyMngMapper.queryAdbfileNameAndVerNo();
	}
	
	/**  
	 *部署新版本成功部署记录保存
	 */  
	public void saveAdbDeployecord(AdbDeployBaseInfo deployInfo) {
		adbDelpoyMngMapper.saveAdbDeployecord(deployInfo);
	}
	public void updateAdbDeployecord(){
		adbDelpoyMngMapper.updateAdbDeployecord();
	}
	/**  
	 *部署新版本成功更新版本管理表的版本状态   
	 * @param string2 
	 * @param string 
	 */  
	public void updateAdbVerState(String updateUser,String updateTime) {
		adbDelpoyMngMapper.updateAdbVerState(updateUser,updateTime);
	}
	/**  
	 *部署新版本失败，恢复历史版本成功，更新版本管理表的版本状态   
	 * @param string2 
	 * @param string 
	 */  
	public void updateAdbVerState3(String updateUser,String updateTime) {
		adbDelpoyMngMapper.updateAdbVerState3(updateUser,updateTime);
	}
	
	/**  
	 *部署新版本失败，恢复历史版本失败，更新版本管理表的版本状态 
	 */  
	public void updateAdbVerState2(String updateUser,String updateTime) {
		adbDelpoyMngMapper.updateAdbVerState2(updateUser,updateTime);
	}
	
	/**  
	 *部署新版本失败部署记录保存
	 */  
	public void saveAdbDeployecord2(AdbDeployBaseInfo deployInfo) {
		adbDelpoyMngMapper.saveAdbDeployecord2(deployInfo);
	}
	
	public int selectCountByAll(AdbDeployBaseInfo deployInfo) {

		return adbDelpoyMngMapper.selectCountByAll(deployInfo);
	}
	
}
