package com.idm.app.idpconfig.mqiCountAnalysis.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idm.app.idpconfig.mqiCountAnalysis.model.MqiResponseInfo;
import com.idm.app.idpconfig.mqiCountAnalysis.model.MqiResponseReport;
import com.idm.app.idpconfig.mqiCountAnalysis.service.MqiIdpResponseService;
import com.idm.app.system.loginfo.model.SysLog;
import com.idm.common.util.ResByPageVo;
import com.idm.config.resubmit.repeat_form_validator.SameUrlData;

import net.sf.json.JSONObject;


@Controller
public class MqiIdpResponseController {
	
	private Logger logger = Logger.getLogger(MqiIdpResponseController.class);

	
	@RequestMapping("/mqi_cust_requestResult_info")
	public String idpRequestInfo() {
		return "idpconfig/mqiCountAnalysis/mqiIdpResponse";
		
		
	}
	@Autowired
	private MqiIdpResponseService mqiIdpresponseservice;
	
	@RequestMapping("/mqi_Idp_Response_Info_query")
	@ResponseBody
	@SameUrlData
	@SysLog(module="客户请求结果信息",operate="首页查询")
	public Object queyRequestInfo(HttpServletRequest request) {
		logger.info("***********查询IDP请求数据源信息方法开始***************");
		String jnlNo = request.getParameter("jnlNo"); 
		String serialNo = request.getParameter("serialNo"); 
		String modelCode = request.getParameter("modelCode"); 
		String productId = request.getParameter("productId"); 
		
		int page = Integer.parseInt(request.getParameter("page"));
		int size = Integer.parseInt(request.getParameter("rows"));

		System.out.println("modelCode"+modelCode);
		System.out.println("productId"+productId);
		System.out.println("page:"+page);
		System.out.println("size:"+size);
		ResByPageVo resByPageVo = null;

		MqiResponseReport mqiResponseinfo = new MqiResponseReport();
		
		mqiResponseinfo.setJnlNo(jnlNo);
		mqiResponseinfo.setSerialNo(serialNo);
		mqiResponseinfo.setProductId(productId);
		mqiResponseinfo.setModelCode(modelCode);
		
		mqiResponseinfo.setPage(page);
		mqiResponseinfo.setSize(size);
		int selectCountByAll = mqiIdpresponseservice.selectCountByAll(mqiResponseinfo);
		List<MqiResponseReport> responseinfo1 = mqiIdpresponseservice.queryIdpResponseInfo(mqiResponseinfo);

		resByPageVo = new ResByPageVo(size, page,selectCountByAll);
		
		resByPageVo.setRows(responseinfo1);
		JSONObject fromObject = JSONObject.fromObject(resByPageVo);
		System.err.println(fromObject);
        logger.info("******请求数据信息查询结束******");
        return JSONObject.fromObject(resByPageVo);
		


		
	}
	
}
