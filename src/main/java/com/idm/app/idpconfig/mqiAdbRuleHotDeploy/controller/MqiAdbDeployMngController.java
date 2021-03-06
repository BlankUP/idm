package com.idm.app.idpconfig.mqiAdbRuleHotDeploy.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.File;
import java.io.IOException;
import java.net.SocketException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idm.app.idpconfig.mqiAdbRuleHotDeploy.model.MqiAdbDeployBaseInfo;
import com.idm.app.idpconfig.mqiAdbRuleHotDeploy.model.MqiServerInfo;
import com.idm.app.idpconfig.mqiAdbRuleHotDeploy.service.MqiAdbDeployMngService;
import com.idm.app.idpconfig.mqiAdbVersionManage.model.MqiAdbVerInfo;
import com.idm.app.system.login.model.IDMUser;
import com.idm.app.system.loginfo.model.SysLog;
import com.idm.common.http.HttpClient;
import com.idm.common.util.ResByPageVo;
import com.idm.config.resubmit.repeat_form_validator.SameUrlData;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * <p>adb规则热部署管理类<p>
 * @author caiwenjian  
 * @date 2019年3月11日  
 * @version 1.0
 */
@Controller
public class MqiAdbDeployMngController {
	static final Logger logger = Logger.getLogger(MqiAdbDeployMngController.class);
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Autowired
	MqiAdbDeployMngService mqiadbdeploymngservice;
	
	@Value("${MQI_FTP01_LOCALPATH}")
	private String MQI_FTP01_LOCALPATH;

	@Value("${MQI_NAS_ADB_LOCALPATH}")
	private String MQI_NAS_ADB_LOCALPATH;
	
	@Value("${MQI_ETP_PROJECT_NAME}")
	private String MQI_ETP_PROJECT_NAME; 
	
	@Value("${MQI_RELOADADB_URL}")
	private String MQI_RELOADADB_URL;
	
	@RequestMapping("/mqi_adb_rule_deploy")
    public String adbVersionManageMqi(){
        return "idpconfig/mqiAdbRuleHotDeploy/MqiAdbRuleDeploy";
    }
	

	/**
	 *<p>adb规则部署记录查询</p>  
	 *@param request
	 *@return
	 */
	@SysLog(operate = "首页查询",module= "模型质检adb规则热部署")
	@RequestMapping("/mqi_adbRule_search")
	@ResponseBody
    public Object adbDeployInfoShowMqi(HttpServletRequest request){
		logger.info("******部署记录查询开始******");
    	int pageNum =Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("rows"));
		String versionNo = request.getParameter("versionNo");
        ResByPageVo resByPageVo = null;
		try {
			logger.info(">>部署记录查versionNo:["+versionNo+"]");
	        MqiAdbDeployBaseInfo mqiadbdeploybaseinfo = new MqiAdbDeployBaseInfo();
	        mqiadbdeploybaseinfo.setVersionNo(versionNo);
	        mqiadbdeploybaseinfo.setPage(pageNum);
	        mqiadbdeploybaseinfo.setSize(pageSize);
			int count = mqiadbdeploymngservice.selectCountByAllMqi(mqiadbdeploybaseinfo);
			//查询部署记录
	        List<MqiAdbDeployBaseInfo> deployInfoList = mqiadbdeploymngservice.queryDeployInfoMqi(mqiadbdeploybaseinfo);
			resByPageVo = new ResByPageVo(pageSize, pageNum,count);
			resByPageVo.setRows(deployInfoList);
		} catch(Exception e) {
			logger.error("部署记录查询异常:["+versionNo+"]"+e.getMessage());
			e.printStackTrace();
			return "fail";
		}
		logger.info("******部署记录查询结束******");
		return JSONObject.fromObject(resByPageVo);
    }
	
	/**
     * @Desc: 获取服务器信息
     * @param request
     * @return
     */
    @RequestMapping("/mqi_query_adbDeploy_service")
    @ResponseBody
    public Object queryAdbDeployServersMqi(HttpServletRequest request)
    {
    	logger.info("******adbDeploy获取服务器信息开始******");
    	//获取服务器源
		List<MqiServerInfo> serviceInfoList = new ArrayList<>();
		serviceInfoList = mqiadbdeploymngservice.queryAdbDeployServersMqi();
		JSONArray json = null;
		if(serviceInfoList!=null&&serviceInfoList.size()>0){
			json = JSONArray.fromObject(serviceInfoList);
		}
		logger.info("******adbDeploy获取服务器信息结束******");
		return json;
    }
	
    /**
     * @Desc:获取待部署文件名和版本号
     * @param request
     * @return
     */
    @RequestMapping("/mqi_queryAdbfileNameAndVerNo")
    @ResponseBody
    public Object queryAdbfileNameAndVerNoMqi(HttpServletRequest request)
    {
    	logger.info("******获取待部署文件名和版本号开始******");
    	JSONObject json=null;
    	//查询部署记录
	    List<MqiAdbDeployBaseInfo> deployInfoList = mqiadbdeploymngservice.queryAdbfileNameAndVerNoMqi();
	    if(deployInfoList!=null&&!"".equals(deployInfoList)&&deployInfoList.size()>0){
	    	String fileName = deployInfoList.get(0).getFileName();
		    String versionNo = deployInfoList.get(0).getVersionNo();
		    String adbId=deployInfoList.get(0).getAdbId();
		    String versionState=deployInfoList.get(0).getVersionState();
		    String fileNameBack = null;
		    String versionNoBack = null;
		    String adbIdBack = null;
		    Boolean hasTwo = false;
		    if(deployInfoList.size()==1&&versionState!=null&&versionState.equals("2")){
				json = JSONObject.fromObject("{\'hasTwo\':"+"\'"+hasTwo+"\',\'versionState\':"+"\'"+versionState+"\',\'fileName\':"+"\'"+fileName+"\',\'versionNo\':"+"\'"+versionNo+"\',\'adbId\':"+"\'"+adbId+"\',\'fileNameBack\':"+"\'"+fileNameBack+"\',\'versionNoBack\':"+"\'"+versionNoBack+"\',\'adbIdBack\':"+"\'"+adbIdBack+"\'}");
		    }else if(deployInfoList.size()==2){
		    	hasTwo = true;
		    	fileNameBack = deployInfoList.get(1).getFileName();
			    versionNoBack = deployInfoList.get(1).getVersionNo();
			    adbIdBack=deployInfoList.get(1).getAdbId();
				json = JSONObject.fromObject("{\'hasTwo\':"+"\'"+hasTwo+"\',\'versionState\':"+"\'"+versionState+"\',\'fileName\':"+"\'"+fileName+"\',\'versionNo\':"+"\'"+versionNo+"\',\'adbId\':"+"\'"+adbId+"\',\'fileNameBack\':"+"\'"+fileNameBack+"\',\'versionNoBack\':"+"\'"+versionNoBack+"\',\'adbIdBack\':"+"\'"+adbIdBack+"\'}");
		    }else{
		    	json = JSONObject.fromObject("{\'success\':false}");
		    }
			logger.info(">>fileName:["+fileName+"]"+",fileNameBack=["+fileNameBack+"]");
			logger.info(">>versionNo:["+versionNo+"]"+",versionNoBack=["+versionNoBack+"]");
			logger.info(">>adbId:["+adbId+"]"+",adbIdBack=["+adbIdBack+"]");
			logger.info(">>hasTwo:["+hasTwo+",versionState:["+versionState+"]");
	    }else{
	    	logger.info(">>fileName,versionNo,adbId信息:无,返回success=false");
			json = JSONObject.fromObject("{\'success\':false}");
	    }
		logger.info("******获取待部署文件名结束******");
		return json;
    }
    

    /**
     *<p>取adb上传到nas目录</p>  
     *@param request
     *@param adbVerInfo
     *@return
     * @throws IOException 
     * @throws SocketException 
     */
    @SameUrlData
    @SysLog(operate = "模型质检上传adb规则文件",module= "模型质检adb规则热部署")
  	@RequestMapping("/mqi_get_adbVersion_forDeploy")
  	@ResponseBody
  	public Object getAdbVersionForDeployMqi(HttpServletRequest request, MqiAdbVerInfo adbVerInfo) throws SocketException, IOException{
	  		//获取文件名
	  		String fileName = request.getParameter("fileName");
	  		logger.info(">>fileName:["+fileName+"]");
			//读取上传adb文件
			Map<String, String> data  = promptAdb(fileName);
			if(data!=null&&data.size()>0){
				logger.info(">>promptAdb上传规则失败:["+data.get("promptMSG")+"]");
				return JSONObject.fromObject("{\'success\':false,\'msg\':\'"+data.get("promptMSG")+"\'}");
			}else if(data!=null&&data.size()==0){
				logger.info(">>promptAdb上传规则成功");
			}
	    return JSONObject.fromObject("{\"success\":true}");
  	}
  	
  	/**
  	 * 新增adb版本部署记录
  	 */
    @SysLog(operate = "模型质检新增部署记录",module= "模型质检adb规则热部署")
  	@RequestMapping("/mqi_add_adbDeploy_record")
  	@ResponseBody
  	public Object addAdbDeployecordMqi(HttpServletRequest request, MqiAdbVerInfo adbVerInfo){
		logger.info("******新增adb版本部署记录方法开始******");
  		IDMUser user = (IDMUser)request.getSession().getAttribute("user");
  		String fileName = request.getParameter("fileName");
  		String adbId = request.getParameter("adbId");
		//获取服务器地址
		String serversAddress = request.getParameter("serversAddress");
		logger.info(">>fileName:["+fileName+"]");
		logger.info(">>serversAddress:["+serversAddress+"]");
		String fileNameBack = request.getParameter("fileNameBack");
  		String adbIdBack = request.getParameter("adbIdBack");
  		logger.info(">>fileNameBack:["+fileNameBack+"]");
		logger.info(">>adbIdBack:["+adbIdBack+"]");
		String[] addressList = serversAddress.split(",");
		System.out.println(">>addressList:["+addressList+"]");
		MqiAdbDeployBaseInfo deployInfo = new MqiAdbDeployBaseInfo();
		deployInfo.setAdbId(adbId);
		deployInfo.setDeployer(user.getUserId());
		deployInfo.setDeployTime(sdf.format(new Date()));
		JSONObject json = new JSONObject();
		String url="";
		try {
  			for(int i=0;i<addressList.length;i++){
  	        	url = addressList[i]+"/"+MQI_ETP_PROJECT_NAME+"/"+MQI_RELOADADB_URL;
  	        	logger.info("待执行的服务器"+url);
  	    		String str = HttpClient.sendPost(url,json.toString() );     	
  	    		logger.info("重载接口返回结果:"+str);
  	    			 if(str.equals("success")){
  	    				 continue;
  	    			 }else{
  	    				//上传正在使用的adb文件以恢复
  	    				Map<String, String> data  = promptAdb(fileNameBack);
  	    				if(data!=null&&data.size()>0){
  	    					logger.info(">>promptAdb恢复正在使用的规则失败:["+data.get("promptMSG")+"]");
  	    					mqiadbdeploymngservice.updateAdbVerState2Mqi(user.getUserId(),sdf.format(new Date()));
  	    					mqiadbdeploymngservice.updateAdbDeployecordMqi();
  	    					mqiadbdeploymngservice.saveAdbDeployecord2Mqi(deployInfo);
  	    					return JSONObject.fromObject("{\'success\':false");
  	    				}else if(data!=null&&data.size()==0){
  	    					logger.info(">>promptAdb发布正在使用的规则成功");
  	    					String ret = HttpClient.sendPost(url,json.toString());
  	    					if("success".equals(ret)){
  	    						mqiadbdeploymngservice.updateAdbVerState3Mqi(user.getUserId(),sdf.format(new Date()));
  	    						mqiadbdeploymngservice.saveAdbDeployecord2Mqi(deployInfo);
  	    	    				return JSONObject.fromObject("{\'success\':\'rest\'}");
  	    					}else{
  	    						mqiadbdeploymngservice.updateAdbVerState2Mqi(user.getUserId(),sdf.format(new Date()));
  	    						mqiadbdeploymngservice.updateAdbDeployecordMqi();
  	    						mqiadbdeploymngservice.saveAdbDeployecord2Mqi(deployInfo);
  	    	    				return JSONObject.fromObject("{\'success\':false}");
  	    					}
  	    				}
  	    				
  	    			 }
  			}
  			mqiadbdeploymngservice.updateAdbVerStateMqi(user.getUserId(),sdf.format(new Date()));
  			mqiadbdeploymngservice.updateAdbDeployecordMqi();
  			mqiadbdeploymngservice.saveAdbDeployecordMqi(deployInfo);
  			logger.info("******新增adb版本部署记录方法结束******");
  	  		return JSONObject.fromObject("{\"success\":true}");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(">>adb上传成功，新增adb版本部署记录异常结束:"+e.getMessage());
			return JSONObject.fromObject("{\"success\":false}");
		}
    } 
  	/**
  	 * 读取上传adb规则
  	 */
  	public HashMap<String, String> promptAdb(String fileName){
  		HashMap<String, String> data = new HashMap<String, String>();  
  		logger.info("复制文件："+MQI_FTP01_LOCALPATH+fileName);
  		File source = new File(MQI_FTP01_LOCALPATH+fileName); 
  		logger.info("复制文件路径："+MQI_NAS_ADB_LOCALPATH);

  		File dest = new File(MQI_NAS_ADB_LOCALPATH);
		try {
				FileUtils.copyFile(source, dest);
		} catch (IOException e) {
			data.put("promptMSG", "上传失败");
			logger.error("复制文件失败");
	  	    return data;
		} 
  	    return data;
  	}
  	
}
