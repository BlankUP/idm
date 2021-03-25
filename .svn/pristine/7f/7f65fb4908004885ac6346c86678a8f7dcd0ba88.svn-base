package com.idm.app.system.loginfo.controller;


import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idm.app.system.loginfo.service.LogInfoService;
import com.idm.common.util.QueryStringUtil;
import com.idm.common.util.ResByPageVo;

/**
 * @controller 日志信息查看
 * @author wengjiwei
 * @Date 2019年2月20日
 */
@Controller
public class LogInfoController {
    static Logger logger = Logger.getLogger(LogInfoController.class);
	
    @Autowired
	private LogInfoService logInfoService;
    
	@RequestMapping("/logInfo")
    public String logInfo(){

        return "log/logInfo";
    }
	
	/**
	 * @Describe 日志信息查询
	 * @param request
	 * @return
	 */
	@RequestMapping("/log_search")
	@ResponseBody
    public Object logInfoView(HttpServletRequest request){
		ResByPageVo resByPageVo = null;
		String userId = request.getParameter("userId");
		String operatTime = request.getParameter("operatTime");
		String operatType = request.getParameter("operatType");
		String newUserId = QueryStringUtil.queryString(userId);
		String newOperatTime = QueryStringUtil.queryString(operatTime);
		String newOperatType = QueryStringUtil.queryString(operatType);
		logger.info("newUserId" + newUserId);
		logger.info("newOperatTime" + newOperatTime);
		logger.info("newOperatType" + newOperatType);
		try {
			int page =Integer.parseInt(request.getParameter("page"));
			int size = Integer.parseInt(request.getParameter("rows"));
			resByPageVo = new ResByPageVo(size, page,logInfoService.selectCountByAll(newUserId,newOperatTime,newOperatType));
			resByPageVo.setRows(logInfoService.selectByAll(size, page, newUserId,newOperatTime,newOperatType));
		} catch (Exception e) {
			logger.error("RoleController:组装返回数据失败！", e);
		}
		return JSONObject.fromObject(resByPageVo);
    }
}
