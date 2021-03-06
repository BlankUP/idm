package com.idm.app.idpconfig.mqiCountAnalysis.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idm.app.idpconfig.mqiCountAnalysis.model.MqiIdpRequestInfo;
import com.idm.app.idpconfig.mqiCountAnalysis.model.MqiRequestReportTest;
import com.idm.app.idpconfig.mqiCountAnalysis.service.MqiIdpRequestInfoService;
import com.idm.app.system.loginfo.model.SysLog;
import com.idm.common.util.ResByPageVo;
import com.idm.config.resubmit.repeat_form_validator.SameUrlData;

import net.sf.json.JSONObject;


@Controller
public class MqiIdpRequestInfoController {
	
	private Logger logger = Logger.getLogger(MqiIdpRequestInfoController.class);

	
	@RequestMapping("/mqi_cust_request_info")
	public String idpRequestInfo() {
		return "idpconfig/mqiCountAnalysis/mqiIdpRequestInfo";
	}
	@Autowired
	private MqiIdpRequestInfoService mqiidprequestinfoservice;
	
	@RequestMapping("/mqi_Idp_Request_Info_query")
	@ResponseBody
	@SameUrlData
	@SysLog(module="客户申请信息",operate="首页查询")
	public Object queyRequestInfo(HttpServletRequest request) {
		logger.info("***********查询IDP请求数据源信息方法开始***************");
		String JnlNo = request.getParameter("JnlNo"); 
		String businessNo = request.getParameter("businessNo");
		String srcDate = request.getParameter("srcDate"); 
		String cifName = request.getParameter("cifName"); 
		String idNo = request.getParameter("idNo"); 

		
		int page = Integer.parseInt(request.getParameter("page"));
		int size = Integer.parseInt(request.getParameter("rows"));

		System.out.println("page:"+page);
		System.out.println("size:"+size);
		ResByPageVo resByPageVo = null;

		MqiRequestReportTest mqiIdprequestinfo = new MqiRequestReportTest();
		mqiIdprequestinfo.setCifName(cifName);
		mqiIdprequestinfo.setBusinessNo(businessNo);
		mqiIdprequestinfo.setIdNo(idNo);
		mqiIdprequestinfo.setJnlNo(JnlNo);
		mqiIdprequestinfo.setRkDate(srcDate);
		mqiIdprequestinfo.setPage(page);
		mqiIdprequestinfo.setSize(size);
		int selectCountByAll = mqiidprequestinfoservice.selectCountByAll(mqiIdprequestinfo);
		List<MqiRequestReportTest> queryIdpRequestInfo = mqiidprequestinfoservice.queryIdpRequestInfo(mqiIdprequestinfo);
		resByPageVo = new ResByPageVo(size, page,selectCountByAll);
		
		resByPageVo.setRows(queryIdpRequestInfo);

        
        JSONObject fromObject = JSONObject.fromObject(resByPageVo);
        System.err.println(fromObject);
        logger.info("******请求数据信息查询结束******");
        return JSONObject.fromObject(resByPageVo);
		


		
	}
	
}
