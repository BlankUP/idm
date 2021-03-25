package com.idm.app.idpconfig.adbVersionManage.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idm.app.idpconfig.adbVersionManage.service.ApproveRecordService;
import com.idm.app.system.loginfo.model.SysLog;
import com.idm.common.util.QueryStringUtil;
import com.idm.common.util.ResByPageVo;

import net.sf.json.JSONObject;

/**
 * @Controller adb文件审批记录
 * @author wengjiawei
 * @Date 2019-03-18
 */
@Controller
public class ApproveRecordController {
	static final Logger logger = Logger.getLogger(ApproveRecordController.class);
	
	@Autowired
	ApproveRecordService approveRecordService;
	
	@RequestMapping("/adb_approve_record")
    public String adbVersionManage(){
        return "idpconfig/adbVersionManage/adbApproveRecord";
    }
	
	/**
	 * @Describe adb审批记录信息查询
	 * @param request
	 * @return
	 */	
	@SysLog(operate = "首页查询",module= "审批记录查询")
	@RequestMapping("/approveRecord_search")
	@ResponseBody
    public Object adbApproveShow(HttpServletRequest request){
		String versionNo = request.getParameter("versionNo");
		String newVersionNo = QueryStringUtil.queryString(versionNo);
		ResByPageVo resByPageVo = null;
		try {
			int page =Integer.parseInt(request.getParameter("page"));
			int size = Integer.parseInt(request.getParameter("rows"));
			resByPageVo = new ResByPageVo(size, page,approveRecordService.selectCountAll(newVersionNo));
			resByPageVo.setRows(approveRecordService.selectByAll(size, page, newVersionNo));
		} catch (Exception e) {
			logger.error("RoleController:组装返回数据失败！", e);
		}
		return JSONObject.fromObject(resByPageVo);
    }	
}
