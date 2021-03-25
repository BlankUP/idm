 package com.idm.app.idpconfig.adbVersionManage.controller;

import java.util.Date;
import java.io.File;
import java.text.SimpleDateFormat;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.idm.common.util.getVsesion;
import com.idm.common.util.QueryStringUtil;
import com.idm.app.idpconfig.adbVersionManage.model.AdbApprove;
import com.idm.app.idpconfig.adbVersionManage.model.AdbVerInfo;
import com.idm.app.idpconfig.adbVersionManage.service.AdbApproveService;
import com.idm.app.idpconfig.adbVersionManage.service.AdbVerManageService;
import com.idm.app.idpconfig.adbVersionManage.util.AdbFileUtil;
import com.idm.app.idpconfig.pmmlConfig.model.PmmlConfig;
import com.idm.app.system.login.model.IDMUser;
import com.idm.app.system.loginfo.model.SysLog;
import com.idm.common.util.ResByPageVo;

import net.sf.json.JSONObject;

/**
 * @Controller adb规则文件版本管理
 * @author wengjiawei
 * @Date 2019-03-04
 */
@Controller
public class AdbVerManageController {
	static final Logger logger = Logger.getLogger(AdbVerManageController.class);
	
	@Resource
    AdbFileUtil adbFileUtil;
	
	
	@Value("${FK_ADB_PATH}")
	private String FK_ADB_PATH;
	
	@Autowired
	AdbVerManageService adbVerManageService;
	
	@Autowired
	AdbApproveService adbApproveService;
	
	@Value("${FTP01_IP}")
	private String FTP01_IP;

	@Value("${FTP01_PORT_NUMBER}")
	private String FTP01_PORT_NUMBER;

	@Value("${VISIT01_USER_NAME}")
	private String VISIT01_USER_NAME;
	
	@Value("${VISIT01_PASS_WORD}")
	private String VISIT01_PASS_WORD;


	
	@Value("${FTP01_LOCALPATH}")
	private String FTP01_LOCALPATH;

	@RequestMapping("/adb_ver_manage")
    public String adbVersionManage(){		
		return "idpconfig/adbVersionManage/adbVersionManage";
    }
	
	/**
	 * @Describe adb版本信息查询
	 * @param request
	 * @return
	 */
	@SysLog(module="adb版本管理",operate="首页查询")
	@RequestMapping("/adbVersion_search")
	@ResponseBody
    public Object adbVersionInfoShow(HttpServletRequest request){
		ResByPageVo resByPageVo = null;		
		String versionNo = request.getParameter("versionNo");
		String newVersionNo = QueryStringUtil.queryString(versionNo);
		logger.info("newVersionNo-------" + newVersionNo);
				
		try {
			int page =Integer.parseInt(request.getParameter("page"));
			int size = Integer.parseInt(request.getParameter("rows"));
			resByPageVo = new ResByPageVo(size, page,adbVerManageService.selectCountByAll(newVersionNo));
			resByPageVo.setRows(adbVerManageService.selectByAll(size, page, newVersionNo));
		} catch (Exception e) {
			logger.error("RoleController:组装返回数据失败！", e);
		}
		return JSONObject.fromObject(resByPageVo);
    }
	
	/**
	 * @Describe adb版本信息删除
	 * @param request
	 * @return
	 */
	@SysLog(operate = "删除信息",module= "adb文件版本管理")
	@RequestMapping("/delete_adbVersion")
	@ResponseBody
    public Object deleteAdbVersionInfo(HttpServletRequest request){
		Integer result = 0;	
		Integer check = 0;
		String versionNo = request.getParameter("versionNo");
		check = adbVerManageService.checkAdbVerState(versionNo);
		
		//判断版本是否正在使用,使用中的版本不可进行删除操作
		if(check > 0) {
			return JSONObject.fromObject("{\"success\":false,\"msg\":\"该版本正在使用或已经发布，不允许删除！\"}");
		}else {
			result = adbVerManageService.deleteAdbVerInfo(versionNo);
			if(result > 0){
				return JSONObject.fromObject("{\"success\":true}");
			}else {
				return JSONObject.fromObject("{\"success\":false}");
			}
		}		
    }
	
	/**
	 * @Describe adb版本信息修改
	 * @param request
	 * @param adbVerInfo
	 * @return
	 */
	@SysLog(operate = "修改版本信息",module= "adb文件版本管理")
	@RequestMapping("/update_adbVersion")
	@ResponseBody
    public Object updateAdbVersionInfo(HttpServletRequest request, AdbVerInfo adbVerInfo){
		IDMUser user = (IDMUser)request.getSession().getAttribute("user");
		Integer result = 0;
		String versioenState = "";
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formatDate = sdf1.format(new Date());
		
		String versionNo = request.getParameter("versionNo");
		adbVerInfo.setUpdateTime(formatDate);
		adbVerInfo.setUpdateUser(user.getUserId());
		
		versioenState = adbVerManageService.selectVersionState(versionNo).get(0);
		
		//判断文件是否在使用中,使用中的文件不可进行有效状态的修改
		if(versioenState.equals("1") || versioenState.equals("2") || versioenState.equals("3") || versioenState.equals("4")) {
			return JSONObject.fromObject("{\"success\":false,\"msg\":\"该版本处于正在使用或审批通过待发布或待审批状态，不允许修改！\"}");
		}else {
			result = adbVerManageService.updateAdbVerInfo(adbVerInfo);			
			if(result > 0){
				return JSONObject.fromObject("{\"success\":true}");
			}else {
				return JSONObject.fromObject("{\"success\":false}");
			}
		}		
    }
	
	/**
	 * @Describe 新增adb版本
	 * @param request
	 * @param adbVerInfo
	 * @return
	 */
	@SysLog(operate = "新增版本信息",module= "adb文件版本管理")
	@RequestMapping("/save_adbVersion")
	@ResponseBody
    public synchronized Object saveAdbVersionInfo(HttpServletRequest request, AdbVerInfo adbVerInfo){
		IDMUser user = (IDMUser)request.getSession().getAttribute("user");
		String c_versionName = request.getParameter("c_versionName");
		
		adbVerInfo.setVersionName(c_versionName);
		
		Integer result = 0;
		Integer idInt = 0;
		String id = "";
		String versionNo = "";
		String oldVersionNo = "";
		String dateStr = "";
		Date nowDate = new Date();
		logger.info("******开始进行adb文件版本信息存储******");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
		
	    String formatDate = sdf1.format(new Date());
	    
		adbVerInfo.setCreateTime(formatDate);		
		adbVerInfo.setCreateUser(user.getUserId());		
		adbVerInfo.setIsValid("1");
		adbVerInfo.setVersionState("0");
		
		//设置文件的序列号
		if(adbVerManageService.selectMaxId().isEmpty() || adbVerManageService.selectMaxId().get(0) ==null) {
			id = "1";
		}else {
			idInt = adbVerManageService.selectMaxId().get(0) + 1;
			id = idInt.toString();
			logger.info("生成的文件版本序列号：" + id);
		}
		
		//设置文件的版本号
		if(adbVerManageService.selectMaxVersionNo().isEmpty() || adbVerManageService.selectMaxVersionNo().get(0) ==null) {
			//如果不存在记录,则直接重新生成版本号
			versionNo = getVsesion.newVersio(0);
		}else {
			//如果存在记录则在查询出的版本号基础上生成版本号
		   oldVersionNo = adbVerManageService.selectMaxVersionNo().get(0);
		   dateStr = oldVersionNo.substring(4, oldVersionNo.length()-4);
		   if(dateStr.equals(sdf2.format(nowDate))) {
			   versionNo = getVsesion.newVersio(Integer.valueOf(oldVersionNo.substring(12, oldVersionNo.length())) + 1);
		   }else {
			   versionNo = getVsesion.newVersio(0);
		   }
		}		
		logger.info("生成的文件版本号：" + "adb_" + versionNo);
		
		
		String suffixName = ".adb";
		
		adbVerInfo.setId(id);
		adbVerInfo.setVersionNo("adb_" + versionNo);
		adbVerInfo.setFileName("adb_" + versionNo + suffixName);
		logger.info("文件名称：" + "adb_" + versionNo + suffixName);
		
		String newVerNo = request.getParameter("newVerNo");
		logger.info("版本名称==：" + newVerNo);
	    	AdbVerInfo config1 = new AdbVerInfo();
	    	config1.setVersionNo(newVerNo);
	    	long num1 = adbVerManageService.repeatversionNo(config1);
	    	logger.info("num:["+num1+"]");
	    	if(num1>0) {
	    		return JSONObject.fromObject("{\"success\":false}");
	    	}
		//从服务器上下载文件并上传

		boolean downloadFlag = false;
		
		downloadFlag = adbFileUtil.downLoadAdbFile(FTP01_IP,Integer.parseInt(FTP01_PORT_NUMBER),VISIT01_USER_NAME,VISIT01_PASS_WORD,"adb_"+ versionNo + suffixName,FTP01_LOCALPATH ,FK_ADB_PATH);
		
		if(downloadFlag) {
		 
				adbVerManageService.setAdbVerState("0");
				result = adbVerManageService.saveAdbVerInfo(adbVerInfo);			
				if(result > 0){
					logger.info("******adb文件版本信息存储结束******");
					return JSONObject.fromObject("{\"success\":true}");
				}else {
					logger.info("******adb文件版本信息存储失败！******");
					return JSONObject.fromObject("{\"success\":false}");
				}
		
		}else {
			return JSONObject.fromObject("{\"success\":false,\"msg\":\"新版本文件下载失败！\"}");
		}
		
    }
	
	/**
	 * @Describe 申请发布版本
	 * @param request
	 * @param adbVerInfo
	 * @return
	 */
	@SysLog(operate = "申请发布版本",module= "adb文件版本管理")
	@RequestMapping("/publishOrRecover_adbVersion")
	@ResponseBody
	public Object publishOrRecoverAdbVer(HttpServletRequest request,AdbVerInfo adbVerInfo){
		IDMUser user = (IDMUser)request.getSession().getAttribute("user");
		Integer result = 0;	
		String isValid = "";
		Integer check = 0;
		
		logger.info("******adb文件发布申请开始******");
		String versionNo = request.getParameter("publishVerNo");
		 
		String applicationReason = request.getParameter("applicationReason");
		
		String versionState = adbVerManageService.selectVersionState(versionNo).get(0);
		logger.info("申请发布的adb文件的版本号:" + versionNo);
		logger.info("申请发布的adb文件的版本状态:" + versionState);	
			
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formatDate = sdf1.format(new Date());
		adbVerInfo.setVersionNo(versionNo);
		adbVerInfo.setUpdateTime(formatDate);		
		adbVerInfo.setUpdateUser(user.getUserId());	
		
		isValid = adbVerManageService.selectVersionIsValid(versionNo).get(0);
		logger.info("发布的adb文件状态(1有效0无效)：" + isValid);
		
		//初始化审批表内容
		AdbApprove adbApprove = new AdbApprove();		
		adbApprove.setVersionNo(versionNo);
		adbApprove.setApplicationUserId(user.getUserId());
		adbApprove.setVersionDesc(request.getParameter("descForPublish"));
		adbApprove.setApplicationTime(sdf1.format(new Date()));
		adbApprove.setStatus("1");
		adbApprove.setApplicationReason(applicationReason);
		adbApprove.setVersionName(request.getParameter("publishVersionName"));
		Integer approveCheck = 0;   //检查是否有正在审批的文件，有则不允许进行申请发布
		approveCheck = adbVerManageService.checkApproveOrNot();
		if(approveCheck > 0) {
			logger.info("******已有正在审批的文件，不允许多次申请！******");
			logger.info("******adb文件发布申请结束******");
			return JSONObject.fromObject("{\"success\":false,\"msg\":\"已有正在审批的文件，不允许多次申请！\"}");
		}else {
			//判断文件是否有效,有效的文件才可进行申请发布的操作,并且正在审批的文件不可进行重复申请
			if(isValid.equals("1") && !versionState.equals("3")  && !versionState.equals("4") && !versionState.equals("2")&& !versionState.equals("1")) {
				//将需要发布的文件状态修改为待一级审批
				result = adbVerManageService.publishOrRecoverAdbVer(adbVerInfo);
				
				if(result > 0){	
					//将审批信息存入审批表
					adbApproveService.deleteAdbApproveRecord(versionNo);
					check =  adbApproveService.saveAdbApproveApplication(adbApprove);
					//审核表信息存入成功则发布成功否则将申请发布状态修改回未发布状态
					if(check > 0) {
						logger.info("******adb文件申请发布成功!	******");
						logger.info("******adb文件发布申请结束	******");
						return JSONObject.fromObject("{\"success\":true}");
					}else {
						adbVerManageService.setAdbVerState("3");
						logger.info("******adb文件申请发布失败!	******");
						logger.info("******adb文件发布申请结束	******");
						return JSONObject.fromObject("{\"success\":false}");
					}				
				}else if(result <= 0 && versionState.equals("0")) {
					logger.info("******adb文件申请发布失败	!******");
					logger.info("******adb文件发布申请结束	******");
					return JSONObject.fromObject("{\"success\":false,\"msg\":\"申请发布新版本失败！\"}");
				}else if(result <= 0 && versionState.equals("5")) {
					logger.info("******adb文件申请发布失败	!******");
					logger.info("******adb文件发布申请结束******");
					return JSONObject.fromObject("{\"success\":false,\"msg\":\"申请恢复版本失败！\"}");
				}else {
					logger.info("******adb文件申请发布失败	!******");
					logger.info("******adb文件发布申请结束	******");
					return JSONObject.fromObject("{\"success\":false}");
				}
			}else if(versionState.equals("3") || versionState.equals("4")) {
				logger.info("******该版本已经申请发布!	******");
				logger.info("******adb文件发布申请结束!	*****");
				return JSONObject.fromObject("{\"success\":false,\"msg\":\"该版本已申请发布，请勿重复申请！\"}");
			}else if(versionState.equals("2")){
				logger.info("******该版本已经申请发布 !	******");
				logger.info("******adb文件发布申请结束 	******");
				return JSONObject.fromObject("{\"success\":false,\"msg\":\"该版本已申请发布成功，请勿重复申请！\"}");
			}else if(versionState.equals("0")){
				logger.info("******版本无效，adb文件申请发布失败!******");
				logger.info("******adb文件发布申请结束	******");
				return JSONObject.fromObject("{\"success\":false,\"msg\":\"该版本为无效版本，无法进行申请发布/恢复版本操作！\"}");
			}else {
				logger.info("******版本正在使用，adb文件申请发布失败!******");
				logger.info("******adb文件发布申请结束	******");
				return JSONObject.fromObject("{\"success\":false,\"msg\":\"该版本为正在使用版本，无法重复进行申请发布！\"}");
			}	
		}		
	}
	
	/**
	 * 生成最新版本号
	 * @param request
	 * @param adbVerInfo
	 * @return
	 */
	@RequestMapping("/get_versionNo")
	@ResponseBody
	public Object getVersionNo(HttpServletRequest request,AdbVerInfo adbVerInfo) {
		String versionNo = "";
		String oldVersionNo = "";
		String dateStr = "";
		Date nowDate = new Date();
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
		logger.info("******生成最新版本号******");
		//设置文件的版本号
		if(adbVerManageService.selectMaxVersionNo().isEmpty() || adbVerManageService.selectMaxVersionNo().get(0) ==null) {
			//如果不存在记录,则直接重新生成版本号
			versionNo = "adb_" + getVsesion.newVersio(0);
			logger.info("生成的版本号为：" + versionNo);
			logger.info("******生成最新版本号结束******");
			return JSONObject.fromObject("{\"success\":true,\"value\":\"" + versionNo + "\"}");
		}else if(!adbVerManageService.selectMaxVersionNo().isEmpty() && adbVerManageService.selectMaxVersionNo().get(0) !=null){
			//如果存在记录则在查询出的版本号基础上生成版本号
			oldVersionNo = adbVerManageService.selectMaxVersionNo().get(0);
			dateStr = oldVersionNo.substring(4, oldVersionNo.length()-4);
			if(dateStr.equals(sdf2.format(nowDate))) {
				versionNo = "adb_" + getVsesion.newVersio(Integer.valueOf(oldVersionNo.substring(12, oldVersionNo.length())) + 1);
				logger.info("生成的版本号为：" + versionNo);
				logger.info("******生成最新版本号结束******");
				return JSONObject.fromObject("{\"success\":true,\"value\":\"" + versionNo + "\"}");
			}else {
				versionNo = "adb_" + getVsesion.newVersio(0);
				logger.info("生成的版本号为：" + versionNo);
				logger.info("******生成最新版本号结束******");
				return JSONObject.fromObject("{\"success\":true,\"value\":\"" + versionNo + "\"}");
			}
		}else{
			logger.info("******生成最新版本号结束******");
			return JSONObject.fromObject("{\"success\":false}");
		}
	}
	
	/**
	 * 检测版本有效性  
	 * @param request
	 * @param adbVerInfo
	 * @return
	 */
	@RequestMapping("/check_status")
	@ResponseBody
	public Object checkVersionState(HttpServletRequest request) {
		String versionNo = request.getParameter("versionNo");
		String result = "";
		result = adbVerManageService.selectVersionIsValid(versionNo).get(0);
		return JSONObject.fromObject("{\"success\":true,\"value\":\"" + result + "\"}");
	}
	
    @RequestMapping("/repeatversionName")
    @ResponseBody
    public Object repeatvisoname(HttpServletRequest request)
    {
	    String versionName  = request.getParameter("versionName");				
	    logger.info("pmmlCode:["+versionName+"]");
	    AdbVerInfo config = new AdbVerInfo();
	    config.setVersionName(versionName);;
	    long num = adbVerManageService.repeatvisoname(config);
	    logger.info("num:["+num+"]");
	    if(num>0) {
	    	return JSONObject.fromObject("{\"success\":true}");
	    }
		return JSONObject.fromObject("{\"success\":false}");
    }
    //校验版本编号
    @RequestMapping("/repeatversionNo")
    @ResponseBody
    public Object repeatversionNo(HttpServletRequest request)
    {
    	String versionNo  = request.getParameter("versionNo");
    	logger.info("版本编号versionNo:["+versionNo+"]");
    	AdbVerInfo config = new AdbVerInfo();
    	config.setVersionNo(versionNo);;
    	long num = adbVerManageService.repeatversionNo(config);
    	logger.info("num:["+num+"]");
    	if(num>0) {
    		return JSONObject.fromObject("{\"success\":true}");
    	}
    	return JSONObject.fromObject("{\"success\":false}");
    }
}
