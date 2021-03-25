package com.idm.app.system.auth.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idm.app.system.auth.model.SystemIpInfo;
import com.idm.app.system.auth.service.SystemIpInfoService;
import com.idm.app.system.login.model.IDMUser;
import com.idm.app.system.loginfo.model.SysLog;
import com.idm.common.util.ResByPageVo;
import com.idm.config.resubmit.repeat_form_validator.SameUrlData;

import net.sf.json.JSONObject;

/**
 * <p>Title:SystemIpController</p>
 * @Description：服务系统IP管理控制层
 * @author：houxt
 * @createTime：2019年4月10日
 * @version 1.0
 */

@Controller
public class SystemIpController {

	static Logger logger = Logger.getLogger(SystemIpController.class);
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Autowired
	private SystemIpInfoService systemIpInfoService;

	@RequestMapping("/systemIp")
	public String userInfo(){

		return "systemIp/systemIpPage";
	}

	@RequestMapping("/systemIp_service")
	@ResponseBody
	@SysLog(operate="首页展示",module="服务系统IP管理")
	public Object systemIpInfoView(HttpServletRequest request){

		logger.info("******服务系统IP查询开始******");
		int page =Integer.parseInt(request.getParameter("page"));
		int size = Integer.parseInt(request.getParameter("rows"));
		String systemCode = request.getParameter("systemCode");
		String systemName = request.getParameter("systemName");
		logger.info("systemCode:["+systemCode+"]");
		logger.info("systemName:["+systemName+"]");
		logger.info("page:["+page+"]");
		logger.info("size:["+size+"]");
		ResByPageVo resByPageVo = null;
		try {
			if (systemCode != null && systemCode != "") 
				systemCode = java.net.URLDecoder.decode(systemCode, "UTF-8");
			if (systemName != null && systemName != "") 
				systemName = java.net.URLDecoder.decode(systemName, "UTF-8");

			SystemIpInfo systemIpInfo = new SystemIpInfo();
			systemIpInfo.setSystemCode(systemCode);
			systemIpInfo.setSystemName(systemName);
			systemIpInfo.setPage(page);
			systemIpInfo.setSize(size);
			List<SystemIpInfo> ipList = systemIpInfoService.selectByAll(systemIpInfo);
			resByPageVo = new ResByPageVo(size, page, systemIpInfoService.selectCountByAll(systemIpInfo));
			resByPageVo.setRows(ipList);
		} catch (Exception e) {
			logger.error("RoleController:组装返回数据失败！", e);
		}
		logger.info("******服务系统IP查询结束******");
		return JSONObject.fromObject(resByPageVo);
	}

    @SameUrlData
	@RequestMapping("/systemIp_save")
	@ResponseBody
	@SysLog(operate="新增或修改",module="服务系统IP管理")
	public Object systemIpSaveOrUpdate(HttpServletRequest request) {
		IDMUser user = (IDMUser)request.getSession().getAttribute("user");
		logger.info("******服务系统IP地址新增/修改开始******");
		String systemIpOption = request.getParameter("systemIp_option");
		String ipAddress = request.getParameter("ipAddress");
		String ipPort = request.getParameter("ipPort");
		String method = request.getParameter("method");
		String systemCode = request.getParameter("systemCode");
		String systemName = request.getParameter("systemName");
		logger.info(">>>ipAddress[" + ipAddress + "]");
		logger.info(">>>ipPort[" + ipPort + "]");
		logger.info(">>>method[" + method + "]");
		logger.info(">>>systemCode[" + systemCode + "]");
		logger.info(">>>systemName[" + systemName + "]");

		SystemIpInfo systemIpInfo = new SystemIpInfo();
		systemIpInfo.setIpAddress(ipAddress);
		systemIpInfo.setIpPort(ipPort);
		systemIpInfo.setMethod(method);
		systemIpInfo.setSystemCode(systemCode);
		systemIpInfo.setSystemName(systemName);

		if ("add".equals(systemIpOption)) {
			try {
				systemIpInfo.setCreateUser(user.getUserId());
				systemIpInfo.setCreateTime(sdf.format(new Date()));
				systemIpInfoService.addSystemIp(systemIpInfo);
				logger.info("******服务IP地址新增结束******");
			} catch (Exception e) {
				logger.error(">>>服务IP地址新增发生异常:" + e.getMessage());
				logger.error("******服务IP地址新增异常结束******");
				e.printStackTrace();
				return "添加数据失败";
			}
		}else if ("update".equals(systemIpOption)) {
			try {
				String createUser = request.getParameter("createUser");
				String createTime = request.getParameter("createTime");
				String systemIpID = request.getParameter("systemIpID");
				systemIpInfo.setCreateUser(createUser);
				systemIpInfo.setCreateTime(createTime);
				systemIpInfo.setUpdateUser(user.getUserId());
				systemIpInfo.setUpdateTime(sdf.format(new Date()));
				systemIpInfo.setSystemIpID(systemIpID);
				systemIpInfoService.updateSystemIp(systemIpInfo);
				logger.info("******服务IP地址修改结束******");
			} catch (Exception e) {
				logger.error(">>>服务IP地址修改发生异常:" + e.getMessage());
				logger.error("******服务IP地址修改异常结束******");
				e.printStackTrace();
				return "修改数据失败";
			}
		}
		return null;
	}
	
	@RequestMapping("/systemIp_delete")
	@ResponseBody
	@SysLog(operate="删除",module="服务系统IP管理")
    public Object systemIpDelete(HttpServletRequest request, String systemIpID){
			Integer result = systemIpInfoService.deleteIpBySystemId(systemIpID);
			if(result > 0){
				return JSONObject.fromObject("{\"success\":true}");
			}
			return JSONObject.fromObject("{\"success\":true,\"msg\":\"IP不存在\"}");
    }

}
