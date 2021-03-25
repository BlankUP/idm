package com.idm.app.idpconfig.countAnalysis.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idm.app.idpconfig.countAnalysis.model.IdpRuleResult;
import com.idm.app.idpconfig.countAnalysis.service.RejectRuleModelService;
import com.idm.app.system.loginfo.model.SysLog;
import com.idm.common.util.ResByPageVo;
import com.idm.config.resubmit.repeat_form_validator.SameUrlData;

import net.sf.json.JSONObject;


@Controller
public class RejectRuleModelController {
	
	private Logger logger = Logger.getLogger(RejectRuleModelController.class);
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@RequestMapping("/reject_rule_model")
	public String exceptionBase() {
		return "idpconfig/countAnalysis/idpRejectRuleModel";
	}
	@Autowired
	RejectRuleModelService rejectrulemodelservice;
	
	
	@RequestMapping("/reject_rule_Info_query")
	@ResponseBody
	@SameUrlData
	@SysLog(module="拒绝规则模型",operate="首页查询")
	public Object queyRejectRuleModelInfo(HttpServletRequest request) {
		logger.info("***********查询IDP请求数据源信息方法开始***************");
		String serialNo = request.getParameter("serialNo"); 
		String srcDate = request.getParameter("srcDate"); 
		String modelName = request.getParameter("modelName"); 
		String cifName = request.getParameter("cifName"); 
		int page = Integer.parseInt(request.getParameter("page"));
		int size = Integer.parseInt(request.getParameter("rows"));

		System.out.println("page:"+page);
		System.out.println("size:"+size);
		ResByPageVo resByPageVo = null;

		IdpRuleResult idpruleresult = new IdpRuleResult(); 
		idpruleresult.setSerialNo(serialNo);
		idpruleresult.setSrcDate(srcDate);
		idpruleresult.setModelName(modelName);
		idpruleresult.setCifName(cifName);
		idpruleresult.setPage(page);
		idpruleresult.setSize(size);
		int selectCountByAll = rejectrulemodelservice.selectCountByAll(idpruleresult);   //总条数
		List<IdpRuleResult> idpruleresult1 = rejectrulemodelservice.queyRejectRuleModel(idpruleresult); 
		//拒绝规则list集合
		resByPageVo = new ResByPageVo(size, page,selectCountByAll);
		resByPageVo.setRows(idpruleresult1);


        return JSONObject.fromObject(resByPageVo);
	}
	
	@RequestMapping("/ruleResultSerch")
	@ResponseBody
	@SameUrlData
	public Object ruleResultSerch(HttpServletRequest request) {
		logger.info("***********查询规则结果方法开始***************");
		String businessNo = request.getParameter("businessNo");
		int page = Integer.parseInt(request.getParameter("page"));
		int size = Integer.parseInt(request.getParameter("rows"));

		System.out.println("page:"+page);
		System.out.println("size:"+size);
		ResByPageVo resByPageVo = null;

		IdpRuleResult idpruleresult = new IdpRuleResult(); 
		idpruleresult.setBusinessNo(businessNo);

		idpruleresult.setPage(page);
		idpruleresult.setSize(size);
		int selectCountByAll = rejectrulemodelservice.selectRuleResultCountByAll(idpruleresult);   //总条数
		List<IdpRuleResult> queryIdpRequestInfo = rejectrulemodelservice.queyRuleResult(idpruleresult); 
		System.err.println(queryIdpRequestInfo);
		//拒绝规则list集合
		resByPageVo = new ResByPageVo(size, page,selectCountByAll);
		resByPageVo.setRows(queryIdpRequestInfo);


        return JSONObject.fromObject(resByPageVo);
	}
	
	@RequestMapping("/doRuleResult_query")
	@ResponseBody
	@SameUrlData
	public IdpRuleResult doRuleResultquery(HttpServletRequest request) {
		logger.info("***********查询规则结果方法开始***************");
		String businessNo = request.getParameter("businessNo");


		System.out.println("businessNo:"+businessNo);



		IdpRuleResult idpruleresult = new IdpRuleResult(); 
		idpruleresult.setBusinessNo(businessNo);

		IdpRuleResult idprule= rejectrulemodelservice.doRuleResultquery(idpruleresult); 
		System.err.println(idpruleresult);

        return idprule;
	}
}
