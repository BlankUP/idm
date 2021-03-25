package com.idm.app.idpconfig.mqiAdbRuleHotDeploy.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idm.app.idpconfig.mqiAdbRuleHotDeploy.mapper.MqiAdbDelpoyMngMapper;
import com.idm.app.idpconfig.mqiAdbRuleHotDeploy.model.MqiAdbDeployBaseInfo;
import com.idm.app.idpconfig.mqiAdbRuleHotDeploy.model.MqiServerInfo;


/**
* <p>Desc:adb规则热部署后台service类 </p>  
* @author caiwenjian  
* @date 2019年3月15日  
* @version 1.0
 */
@Service
public class MqiAdbDeployMngService {
	
	@Autowired
	MqiAdbDelpoyMngMapper MqiAdbDelpoyMngMapper;	//版本部署类

	/**  
	 *查询代部署列表信息
	 *@return  
	 */  
	public List<MqiAdbDeployBaseInfo> queryDeployInfoMqi(MqiAdbDeployBaseInfo deployInfo) {
		
		return MqiAdbDelpoyMngMapper.queryDeployInfoMqi(deployInfo);
	}
	/**  
	 *获取待部署的服务器
	 */  
	public List<MqiServerInfo> queryAdbDeployServersMqi() {
		
		return MqiAdbDelpoyMngMapper.queryAdbDeployServersMqi();
	}
	
	/**  
	 *获取待部署的文件名
	 */  
	public List<MqiAdbDeployBaseInfo> queryAdbfileNameAndVerNoMqi() {
		
		return MqiAdbDelpoyMngMapper.queryAdbfileNameAndVerNoMqi();
	}
	
	/**  
	 *部署新版本成功部署记录保存
	 */  
	public void saveAdbDeployecordMqi(MqiAdbDeployBaseInfo deployInfo) {
		MqiAdbDelpoyMngMapper.saveAdbDeployecordMqi(deployInfo);
	}
	public void updateAdbDeployecordMqi(){
		MqiAdbDelpoyMngMapper.updateAdbDeployecordMqi();
	}
	/**  
	 *部署新版本成功更新版本管理表的版本状态   
	 * @param string2 
	 * @param string 
	 */  
	public void updateAdbVerStateMqi(String updateUser,String updateTime) {
		MqiAdbDelpoyMngMapper.updateAdbVerStateMqi(updateUser,updateTime);
	}
	/**  
	 *部署新版本失败，恢复历史版本成功，更新版本管理表的版本状态   
	 * @param string2 
	 * @param string 
	 */  
	public void updateAdbVerState3Mqi(String updateUser,String updateTime) {
		MqiAdbDelpoyMngMapper.updateAdbVerState3Mqi(updateUser,updateTime);
	}
	
	/**  
	 *部署新版本失败，恢复历史版本失败，更新版本管理表的版本状态 
	 */  
	public void updateAdbVerState2Mqi(String updateUser,String updateTime) {
		MqiAdbDelpoyMngMapper.updateAdbVerState2Mqi(updateUser,updateTime);
	}
	
	/**  
	 *部署新版本失败部署记录保存
	 */  
	public void saveAdbDeployecord2Mqi(MqiAdbDeployBaseInfo deployInfo) {
		MqiAdbDelpoyMngMapper.saveAdbDeployecord2Mqi(deployInfo);
	}
	
	public int selectCountByAllMqi(MqiAdbDeployBaseInfo deployInfo) {

		return MqiAdbDelpoyMngMapper.selectCountByAllMqi(deployInfo);
	}
	
}
