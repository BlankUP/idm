package com.idm.app.idpconfig.mqiCountAnalysis.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idm.app.idpconfig.mqiCountAnalysis.model.MqiIdpRuleResult;
import com.idm.app.idpconfig.mqiCountAnalysis.service.MqiRejectRuleModelService;
import com.idm.app.system.loginfo.model.SysLog;
import com.idm.common.util.ResByPageVo;
import com.idm.config.resubmit.repeat_form_validator.SameUrlData;

import net.sf.json.JSONObject;


@Controller
public class MqiRejectRuleModelController {
	
	private Logger logger = Logger.getLogger(MqiRejectRuleModelController.class);
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@RequestMapping("/mqi_reject_rule_model")
	public String exceptionBase() {
		return "idpconfig/mqiCountAnalysis/mqiIdpRejectRuleModel";
	}
	@Autowired
	MqiRejectRuleModelService mqiRejectrulemodelservice;
	
	
	@RequestMapping("/mqi_reject_rule_Info_query")
	@ResponseBody
	@SameUrlData
	@SysLog(module="拒绝规则模型",operate="首页查询")
	public Object queyRejectRuleModelInfo(HttpServletRequest request) {
		logger.info("***********查询IDP请求数据源信息方法开始***************");
		String jnlNo = request.getParameter("jnlNo"); 
		String businessNo = request.getParameter("businessNo"); 
		String modelCode = request.getParameter("modelCode"); 
		String cifName = request.getParameter("cifName"); 
		int page = Integer.parseInt(request.getParameter("page"));
		int size = Integer.parseInt(request.getParameter("rows"));

		System.out.println("page:"+page);
		System.out.println("size:"+size);
		ResByPageVo resByPageVo = null;

		MqiIdpRuleResult mqiIdpruleresult = new MqiIdpRuleResult(); 
		mqiIdpruleresult.setBusinessNo(businessNo);
		mqiIdpruleresult.setModelCode(modelCode);
		mqiIdpruleresult.setCifName(cifName);
		mqiIdpruleresult.setJnlNo(jnlNo);
		mqiIdpruleresult.setPage(page);
		mqiIdpruleresult.setSize(size);
		int selectCountByAll = mqiRejectrulemodelservice.selectCountByAll(mqiIdpruleresult);   //总条数
		List<MqiIdpRuleResult> idpruleresult1 = mqiRejectrulemodelservice.queyRejectRuleModel(mqiIdpruleresult); 
		System.err.println(idpruleresult1);
		//拒绝规则list集合
		resByPageVo = new ResByPageVo(size, page,selectCountByAll);
		resByPageVo.setRows(idpruleresult1);

		JSONObject fromObject = JSONObject.fromObject(resByPageVo);
		System.err.println(fromObject);
        return JSONObject.fromObject(resByPageVo);
	}
	
	@RequestMapping("/mqi_ruleResultSerch")
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

		MqiIdpRuleResult mqiIdpruleresult = new MqiIdpRuleResult(); 
		mqiIdpruleresult.setBusinessNo(businessNo);

		mqiIdpruleresult.setPage(page);
		mqiIdpruleresult.setSize(size);
		int selectCountByAll = mqiRejectrulemodelservice.selectRuleResultCountByAll(mqiIdpruleresult);   //总条数
		List<MqiIdpRuleResult> queryIdpRequestInfo = mqiRejectrulemodelservice.queyRuleResult(mqiIdpruleresult); 
		System.err.println(queryIdpRequestInfo);
		//拒绝规则list集合
		resByPageVo = new ResByPageVo(size, page,selectCountByAll);
		resByPageVo.setRows(queryIdpRequestInfo);


        return JSONObject.fromObject(resByPageVo);
	}
	
	@RequestMapping("/mqi_doRuleResult_query")
	@ResponseBody
	@SameUrlData
	public MqiIdpRuleResult doRuleResultquery(HttpServletRequest request) {
		logger.info("***********查询规则结果方法开始***************");
		String businessNo = request.getParameter("businessNo");


		System.out.println("businessNo:"+businessNo);



		MqiIdpRuleResult mqiIdpruleresult = new MqiIdpRuleResult(); 
		mqiIdpruleresult.setBusinessNo(businessNo);

		MqiIdpRuleResult idprule= mqiRejectrulemodelservice.doRuleResultquery(mqiIdpruleresult); 
		System.err.println(mqiIdpruleresult);

        return idprule;
	}
}
