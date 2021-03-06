package com.idm.app.idpconfig.mqiAdbVersionManage.controller;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.idm.app.idpconfig.mqiAdbVersionManage.model.MqiAdbVerInfo;
import com.idm.app.idpconfig.mqiAdbVersionManage.model.MqiApproveRecord;
import com.idm.app.idpconfig.mqiAdbVersionManage.service.MqiAdbApproveService;
import com.idm.app.idpconfig.mqiAdbVersionManage.service.MqiAdbVerManageService;
import com.idm.app.idpconfig.mqiAdbVersionManage.service.MqiApproveRecordService;

import com.idm.app.system.auth.model.Role;
import com.idm.app.system.auth.service.RoleService;
import com.idm.app.system.auth.service.UserInfoService;
import com.idm.app.system.login.model.IDMUser;
import com.idm.app.system.loginfo.model.SysLog;
import com.idm.common.util.ResByPageVo;
import net.sf.json.JSONObject;

/**
 * @Controller adb文件版本发布审批
 * @author wengjiawei
 * @Date 2019-03-11
 */
@Controller
public class MqiAdbApproveController {
	static final Logger logger = Logger.getLogger(MqiAdbApproveController.class);
	@Autowired
	RoleService roleservice;
	@Autowired
	MqiAdbVerManageService mqiadbvermanageservice;

	@Autowired
	MqiAdbApproveService mqiadbapproveservice;
	
	@Autowired
	MqiApproveRecordService mqiapproveRecordService;
	
	@RequestMapping("/mqi_adb_approve")
    public String adbVersionManageMqi(){
        return "idpconfig/mqiAdbVersionManage/MqiAdbApprove";
    }
	@Autowired
	UserInfoService userinfoservice;
	
	/**
	 * @Describe adb审批信息查询
	 * @param request
	 * @return
	 */	
	@SysLog(operate = "首页查询",module= "模型质检adb文件审批")
	@RequestMapping("/mqi_adbApprove_search")
	@ResponseBody
    public Object adbApproveShowMqi(HttpServletRequest request){
		IDMUser user = (IDMUser)request.getSession().getAttribute("user");
		String userId = user.getUserId();
		Set<String > set=new HashSet<String>();
		
		List<Role> getroleno = userinfoservice.getroleno(userId);
		for (Role role : getroleno) {
			String roleroot  = roleservice.getRoleRootByRoleId(role.getRoleNo());
			set.add(roleroot);
		}
		int page =Integer.parseInt(request.getParameter("page"));
		int size = Integer.parseInt(request.getParameter("rows"));
		ResByPageVo resByPageVo = null;
		  
		    if(set.contains("1")&&set.size()==1) {
		    	logger.info("******只有一级审批权限******");
				resByPageVo = new ResByPageVo(size, page,mqiadbapproveservice.selectAdbCountAll("1"));
				System.err.println(mqiadbapproveservice.selectAdbApproveInfo("1"));
				
				resByPageVo.setRows(mqiadbapproveservice.selectAdbApproveInfo("1"));
				return JSONObject.fromObject(resByPageVo);
			}
			 if(set.contains("2")&&set.size()==1) {
		    	logger.info("******只有二级审批权限******");

				resByPageVo = new ResByPageVo(size, page,mqiadbapproveservice.selectAdbCountAll("2"));
				resByPageVo.setRows(mqiadbapproveservice.selectAdbApproveInfo("2"));
				return JSONObject.fromObject(resByPageVo);
			}
			if(set.contains("0")&&set.size()==1) {
		    	logger.info("******只有普通权限******");
				return resByPageVo;
				
				
		    }
			if(set.contains("3")||set.size()>=3){
		    	logger.info("******包含三种级权限******");

			resByPageVo = new ResByPageVo(size, page,mqiadbapproveservice.selectAdbApproveConuntAll());
			resByPageVo.setRows( mqiadbapproveservice.selectAdbApproveConunt());
			return JSONObject.fromObject(resByPageVo);
		   }if (set.size()>1&&set.size()<3 &&set!=null) {
		    	if(set.contains("1")&&set.contains("0")&&set.size()==2) {
		    		logger.info("******只有一级和普通审批权限******");
					resByPageVo = new ResByPageVo(size, page,mqiadbapproveservice.selectAdbCountAll("1"));
					resByPageVo.setRows(mqiadbapproveservice.selectAdbApproveInfo("1"));
					
		    	}
		    	if(set.contains("2")&&set.contains("0")&&set.size()==2) {
		    		logger.info("******只有二级和普通审批权限******");
					resByPageVo = new ResByPageVo(size, page,mqiadbapproveservice.selectAdbCountAll("2"));
					resByPageVo.setRows(mqiadbapproveservice.selectAdbApproveInfo("2"));
					
		    	}if(set.contains("1")&&set.contains("2")&&set.size()==2) {
		    		logger.info("******包含一级二级权限******");
					resByPageVo = new ResByPageVo(size, page,mqiadbapproveservice.selectAdbApproveConuntAll());
					resByPageVo.setRows( mqiadbapproveservice.selectAdbApproveConunt());
					
		    	}
		    		
		    }else {
		    	return resByPageVo;
		    }
		
		
		   return resByPageVo;
    }
	
	/**
	 * @Describe adb审批信息
	 * @param request
	 * @return
	 */	
	@SysLog(operate = "审批通过",module= "模型质检adb文件审批")
	@RequestMapping("/mqi_adbApprove_application")
	@ResponseBody
    public Object adbApproveApplicationMqi(HttpServletRequest request){
		IDMUser user = (IDMUser)request.getSession().getAttribute("user");
		String status = "";
		String versionName = request.getParameter("versionName");
		String versionNo = request.getParameter("versionNo");
		String applicationTime = request.getParameter("applicationTime");
		String applicationUser = request.getParameter("applicationUserId");
		String applicationReason = request.getParameter("applicationReason");
		String approveAdvise = request.getParameter("reason");
		Integer result = 0;
		Integer check = 0;
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		
	    String formatDate = sdf1.format(new Date());
		
		logger.info("******adb审批开始******");
		status =mqiadbapproveservice.selectStatus(versionNo).get(0); 
		logger.info("adb审批版本号：" + versionNo);
		logger.info("adb审批状态：" + status);
		
		MqiApproveRecord  approveRecord = new MqiApproveRecord();
		approveRecord.setVersionName(versionName);
		approveRecord.setVersionNo(versionNo);
		approveRecord.setApplicationTime(applicationTime);
		approveRecord.setApplicationUser(applicationUser);
		approveRecord.setApproveTime(formatDate);
		approveRecord.setApproveUser(user.getUserId());
		approveRecord.setResult("1");
		approveRecord.setRecordId(String.valueOf(System.currentTimeMillis()));
		approveRecord.setApplicationReason(applicationReason);
		approveRecord.setApproveAdvise(approveAdvise);
		
		//初始化adb版本信息
		MqiAdbVerInfo adbVerInfo =new MqiAdbVerInfo();
		adbVerInfo.setVersionNo(versionNo);
		
		if(status.equals("1")) {
			approveRecord.setApproveLevel("1");			
			result = mqiadbapproveservice.updateSecondAdbApprove(versionNo);
			logger.info("******正在审批的版本状态为待一级审批******");
			if(result > 0) {
				adbVerInfo.setVersionState("4");
				check = mqiadbvermanageservice.updateApproveStateMqi(adbVerInfo);
				if(check > 0) {
					mqiapproveRecordService.saveApproveRecord(approveRecord);
					
					return JSONObject.fromObject("{\"success\":true}");
				}else {
					return JSONObject.fromObject("{\"success\":false}");
				}
			}else {
				return JSONObject.fromObject("{\"success\":false}");
			}			
		}else if(status.equals("2")) {
			approveRecord.setApproveLevel("2");
			logger.info("******正在审批的版本状态为待二级审批******");
			result = mqiadbapproveservice.updatePassAdbApprove(versionNo);
			if(result > 0) {
				//将原本已发布状态的版本修改为历史版本再修改新发布版本状态
				mqiadbvermanageservice.setAdbVerStateMqi("2");
				adbVerInfo.setVersionState("2");
				check = mqiadbvermanageservice.updateApproveStateMqi(adbVerInfo);
				if(check > 0) {
					//审批结束将该条信息从审批表中删除
					mqiadbapproveservice.deleteAdbApproveRecord(versionNo);
					mqiapproveRecordService.saveApproveRecord(approveRecord);
					return JSONObject.fromObject("{\"success\":true}");
				}else {
					return JSONObject.fromObject("{\"success\":false}");
				}
			}else {
				return JSONObject.fromObject("{\"success\":false}");
			}	
		}else{
			return JSONObject.fromObject("{\"success\":false}");
		}
    }
	
	/**
	 * @Describe adb文件被审批拒绝
	 * @param request
	 * @return
	 */	
	@SysLog(operate = "审批拒绝",module= "模型质检adb文件审批")
	@RequestMapping("/mqi_adbReject_application")
	@ResponseBody
    public Object adbRejectApplicationMqi(HttpServletRequest request){
		IDMUser user = (IDMUser)request.getSession().getAttribute("user");
		
		
		
		String status = "";
		String versionNo = request.getParameter("versionNo");
		String applicationTime = request.getParameter("applicationTime");
		String applicationUser = request.getParameter("applicationUserId");
		String applicationReason = request.getParameter("applicationReason");
		String approveAdvise = request.getParameter("reason");
		Integer result = 0;
		Integer check = 0;
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		
	    String formatDate = sdf1.format(new Date());
		
		logger.info("******adb审批不通过******");
		status =mqiadbapproveservice.selectStatus(versionNo).get(0); 
		logger.info("不通过的adb版本号：" + versionNo);
		logger.info("adb审批状态：" + status);
		
		MqiApproveRecord  approveRecord = new MqiApproveRecord();
		approveRecord.setVersionNo(versionNo);
		approveRecord.setApplicationTime(applicationTime);
		approveRecord.setApplicationUser(applicationUser);
		approveRecord.setApproveTime(formatDate);
		approveRecord.setApproveUser(user.getUserId());
		approveRecord.setResult("0");
		approveRecord.setRecordId(String.valueOf(System.currentTimeMillis()));
		approveRecord.setApplicationReason(applicationReason);
		approveRecord.setApproveAdvise(approveAdvise);
		
		//初始化adb版本信息
		MqiAdbVerInfo adbVerInfo =new MqiAdbVerInfo();
		adbVerInfo.setVersionNo(versionNo);
		
		if(status.equals("1")) {
			approveRecord.setApproveLevel("1");	
			result = mqiadbapproveservice.updateRejectAdbApproveMqi(versionNo);
			logger.info("******Adb文件在一级审批时被拒绝******");
			if(result > 0) {
				adbVerInfo.setVersionState("6");
				check = mqiadbvermanageservice.updateApproveStateMqi(adbVerInfo);
				if(check > 0) {
					//审批结束将该条信息从审批表中删除
					if(mqiadbapproveservice.deleteAdbApproveRecord(versionNo) > 0) {
						mqiapproveRecordService.saveApproveRecord(approveRecord);
						return JSONObject.fromObject("{\"success\":true}");
					}else {
						return JSONObject.fromObject("{\"success\":false}");
					}
				}else {
					return JSONObject.fromObject("{\"success\":false}");
				}
			}else {
				return JSONObject.fromObject("{\"success\":false}");
			}			
		}else if(status.equals("2")) {
			logger.info("******Adb文件在二级审批时被拒绝******");
			approveRecord.setApproveLevel("2");	
			result = mqiadbapproveservice.updateRejectAdbApproveMqi(versionNo);
			if(result > 0) {
				adbVerInfo.setVersionState("6");
				check = mqiadbvermanageservice.updateApproveStateMqi(adbVerInfo);
				if(check > 0) {
					//审批结束将该条信息从审批表中删除
					if(mqiadbapproveservice.deleteAdbApproveRecord(versionNo) > 0) {
						mqiapproveRecordService.saveApproveRecord(approveRecord);
						return JSONObject.fromObject("{\"success\":true}");
					}else {
						return JSONObject.fromObject("{\"success\":false}");
					}
				}else {
					return JSONObject.fromObject("{\"success\":false}");
				}
			}else {
				return JSONObject.fromObject("{\"success\":false}");
			}	
		}else {
			return JSONObject.fromObject("{\"success\":false}");
		}
    }
}
