package com.idm.app.idpconfig.countAnalysis.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idm.app.idpconfig.countAnalysis.model.ResponseInfo;
import com.idm.app.idpconfig.countAnalysis.service.IdpResponseService;
import com.idm.app.system.loginfo.model.SysLog;
import com.idm.common.util.ResByPageVo;
import com.idm.config.resubmit.repeat_form_validator.SameUrlData;

import net.sf.json.JSONObject;


@Controller
public class IdpResponseController {
	
	private Logger logger = Logger.getLogger(IdpResponseController.class);

	
	@RequestMapping("/cust_requestResult_info")
	public String idpRequestInfo() {
		return "idpconfig/countAnalysis/idpResponse";
	}
	@Autowired
	private IdpResponseService idpresponseservice;
	
	@RequestMapping("/Idp_Response_Info_query")
	@ResponseBody
	@SameUrlData
	@SysLog(module="客户请求结果信息",operate="首页查询")
	public Object queyRequestInfo(HttpServletRequest request) {
		logger.info("***********查询IDP请求数据源信息方法开始***************");
		String serialNo = request.getParameter("serialNo"); 
		String srcDate = request.getParameter("srcDate"); 
		String cifName = request.getParameter("cifName"); 
		String querySystemCode = request.getParameter("systemName"); //请求系统编码 
		
		int page = Integer.parseInt(request.getParameter("page"));
		int size = Integer.parseInt(request.getParameter("rows"));

		System.out.println("page:"+page);
		System.out.println("size:"+size);
		ResByPageVo resByPageVo = null;

		ResponseInfo responseinfo = new ResponseInfo();
		responseinfo.setCifName(cifName);
		responseinfo.setQuerySystemCode(querySystemCode);
		responseinfo.setSerialNo(serialNo);
		responseinfo.setSrcDate(srcDate);
		responseinfo.setPage(page);
		responseinfo.setSize(size);
		int selectCountByAll = idpresponseservice.selectCountByAll(responseinfo);
		List<ResponseInfo> responseinfo1 = idpresponseservice.queryIdpResponseInfo(responseinfo);
		System.err.println(responseinfo1);
		resByPageVo = new ResByPageVo(size, page,selectCountByAll);
		
		resByPageVo.setRows(responseinfo1);

        logger.info("******请求数据信息查询结束******");
        return JSONObject.fromObject(resByPageVo);
		


		
	}
	
}
