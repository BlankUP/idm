package com.idm.app.idpconfig.mqiCountAnalysis.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idm.app.idpconfig.mqiCountAnalysis.model.MqiScoreRuleInfo;
import com.idm.app.idpconfig.mqiCountAnalysis.model.MqiScoreRuleTotalScoreInfo;
import com.idm.app.idpconfig.mqiCountAnalysis.service.MqiScoreRuleInfoService;
import com.idm.app.idpconfig.mqiModeRule.model.MqiModelRuleInfo;
import com.idm.app.idpconfig.mqiModeRule.service.MqiModelRuleService;
import com.idm.app.system.loginfo.model.SysLog;
import com.idm.common.util.ResByPageVo;
import com.idm.config.resubmit.repeat_form_validator.SameUrlData;

import net.sf.json.JSONObject;

/**
 * <p>Description:评分规则模型控制层 </p>  ：
 * @author：jiamh
 * @createTime：2019年8月22日
 * @version 1.0
 */
@Controller
public class MqiScorcRuleInfoController {

	private Logger logger = Logger.getLogger(MqiScorcRuleInfoController.class);

	@Autowired
	private MqiModelRuleService mqiModelRuleService;
	
	@Autowired
	MqiScoreRuleInfoService mqiScoreRuleInfoService;
	
	@RequestMapping("/mqi_score_rule_model")
	public String scoreRuleInfo() {
		return "idpconfig/mqiCountAnalysis/mqiScoreRuleInfo";
	}
	
	@RequestMapping("/mqi_scoreRule_TotalScore_Info_query")
	@ResponseBody
	@SameUrlData
	@SysLog(module="模型质检评分规则信息",operate="评分规则总分查询")
	public Object queyTotalScore(HttpServletRequest request) {
		logger.info("***********评分规则总分信息查询开始***************");
		String modelCode = request.getParameter("modelCode");     //获取模型编码
		String jnlNo = request.getParameter("jnlNo");       //贷款号
		String businessNo = request.getParameter("businessNo");   //获取业务流水号
		String cifName = request.getParameter("cifName");   //获取姓名
		String idNo = request.getParameter("idNo");   //获取证件号码
		int page = Integer.parseInt(request.getParameter("page"));
		int size = Integer.parseInt(request.getParameter("rows"));
		ResByPageVo resByPageVo = null;
		List<MqiScoreRuleTotalScoreInfo> list = new ArrayList<MqiScoreRuleTotalScoreInfo>();
		try{
			MqiScoreRuleTotalScoreInfo mqiScoreRuleTotalScoreInfo = new MqiScoreRuleTotalScoreInfo();
			mqiScoreRuleTotalScoreInfo.setModelCode(modelCode);
			mqiScoreRuleTotalScoreInfo.setJnlNo(jnlNo);
			mqiScoreRuleTotalScoreInfo.setBusinessNo(businessNo);
			mqiScoreRuleTotalScoreInfo.setCifName(cifName);
			mqiScoreRuleTotalScoreInfo.setIdNo(idNo);
			mqiScoreRuleTotalScoreInfo.setPage(page);
			mqiScoreRuleTotalScoreInfo.setSize(size);
			int count = mqiScoreRuleInfoService.selectCountByAll(mqiScoreRuleTotalScoreInfo);
			list = mqiScoreRuleInfoService.getScoreRuleTotalScoreInfo(mqiScoreRuleTotalScoreInfo);
			resByPageVo = new ResByPageVo(size, page, count);
			if (list != null && list.size() > 0) {
				logger.info("查询评分规则总分信息成功，总记录[" + count + "]");
				resByPageVo.setRows(list);
			} else if (list != null && list.size() == 0) {
				logger.info(">>评分规则总分无记录");
				resByPageVo = new ResByPageVo(size, page, 0);
			} else {
				logger.info(">>评分规则总分数据库错误");
				resByPageVo = new ResByPageVo(size, page, 0);
			}
		}catch(Exception e){
			logger.error("类ScorcRuleModelInfoController中方法queyTotalScore出现Exception异常：", e);
		}
        logger.info("******评分规则总分查询结束******");
        return JSONObject.fromObject(resByPageVo);
	}
	
	@RequestMapping("/mqi_scoreRule_detail_Info_query")
	@ResponseBody
	@SameUrlData
	@SysLog(module="模型质检评分规则信息",operate="评分规则明细查询")
	public Object queyScoreRuleInfos(HttpServletRequest request) {
		logger.info("***********查询评分规则明细信息方法开始***************");
		String modelCode = request.getParameter("modelCode");   //获取模型编码
		String businessNo = request.getParameter("businessNo");   //获取业务流水号
		String cifName = request.getParameter("cifName");   //获取姓名
		String idNo = request.getParameter("idNo");   //获取证件号码
		int page = Integer.parseInt(request.getParameter("page"));
		int size = Integer.parseInt(request.getParameter("rows"));
		ResByPageVo resByPageVo = null;
		String ruleType = "2";
		List<MqiScoreRuleInfo> list = new ArrayList<MqiScoreRuleInfo>();
		try{
			List<MqiModelRuleInfo> mqiModelRuleInfolist = mqiModelRuleService.queryMqiModelRuleInfosByModelCode(modelCode,ruleType); 
			MqiScoreRuleInfo mqiScoreRuleInfo = new MqiScoreRuleInfo();
			mqiScoreRuleInfo.setModelCode(modelCode);
			mqiScoreRuleInfo.setBusinessNo(businessNo);
			mqiScoreRuleInfo.setCifName(cifName);
			mqiScoreRuleInfo.setIdNo(idNo);
			List<MqiScoreRuleInfo> mqiScoreRuleInfoList = mqiScoreRuleInfoService.getScoreRuleInfos(mqiScoreRuleInfo);
			if(mqiModelRuleInfolist==null || mqiModelRuleInfolist.size()==0){ //说明该产品未初始化到表idm_modeltorule_info里
				list.addAll(mqiScoreRuleInfoList);
			}else if(mqiModelRuleInfolist.size()>0 &&(mqiModelRuleInfolist!=null && mqiModelRuleInfolist.size()>0)){ //说明该产品初始化到表idm_modeltorule_info里
				for(int i=0;i<mqiModelRuleInfolist.size();i++){ //获取已经执行的规则
					MqiModelRuleInfo mqiModelRuleInfo = mqiModelRuleInfolist.get(i);
					String ruleCode = mqiModelRuleInfo.getRulecode(); //规则编码
					for(int j=0;j<mqiScoreRuleInfoList.size();j++){
						MqiScoreRuleInfo mqiScoreRuleInfo1 = mqiScoreRuleInfoList.get(j);
						String ruleCode1 = mqiScoreRuleInfo1.getRuleCode(); //规则编码
						if(ruleCode.equals(ruleCode1)){
							list.add(mqiScoreRuleInfo1);
							break;
						}
					}
				}
			}
			
		}catch(Exception e){
			logger.error("类ScorcRuleModelInfoController中方法queyScoreRuleInfos出现Exception异常：", e);
		}
		int count = list.size();
		resByPageVo = new ResByPageVo(size, page, count);
		if (list != null && list.size() > 0) {
			logger.info("查询评分规则明细信息成功，总记录[" + count + "]");
			resByPageVo.setRows(list);
		} else if (list != null && list.size() == 0) {
			logger.info(">>评分规则明细无记录");
			resByPageVo = new ResByPageVo(size, page, 0);
		} else {
			logger.info(">>评分规则明细数据库错误");
			resByPageVo = new ResByPageVo(size, page, 0);
		}
        logger.info("******评分规则明细信息查询结束******");
        return JSONObject.fromObject(resByPageVo);
	}
}
