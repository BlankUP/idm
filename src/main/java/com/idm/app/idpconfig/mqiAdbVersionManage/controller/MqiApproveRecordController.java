package com.idm.app.idpconfig.mqiAdbVersionManage.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idm.app.idpconfig.mqiAdbVersionManage.service.MqiApproveRecordService;
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
public class MqiApproveRecordController {
	static final Logger logger = Logger.getLogger(MqiApproveRecordController.class);
	
	@Autowired
	MqiApproveRecordService mqiapproverecordservice;
	
	@RequestMapping("/mqi_adb_approve_record")
    public String adbVersionManageMqi(){
        return "idpconfig/mqiAdbVersionManage/MqiAdbApproveRecord";
    }
	
	/**
	 * @Describe adb审批记录信息查询
	 * @param request
	 * @return
	 */	
	@RequestMapping("/mqi_approveRecord_search")
	@ResponseBody
	@SysLog(operate = "首页查询",module= "模型质检adb审批记录查询")
    public Object adbApproveShowMqi(HttpServletRequest request){
		String versionNo = request.getParameter("versionNo");
		String newVersionNo = QueryStringUtil.queryString(versionNo);
		ResByPageVo resByPageVo = null;
		try {
			int page =Integer.parseInt(request.getParameter("page"));
			int size = Integer.parseInt(request.getParameter("rows"));
			resByPageVo = new ResByPageVo(size, page,mqiapproverecordservice.selectCountAll(newVersionNo));
			resByPageVo.setRows(mqiapproverecordservice.selectByAll(size, page, newVersionNo));
		} catch (Exception e) {
			logger.error("RoleController:组装返回数据失败！", e);
		}
		return JSONObject.fromObject(resByPageVo);
    }	
}
