package com.idm.app.idpconfig.countAnalysis.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idm.app.idpconfig.countAnalysis.model.ScoreRuleInfo;
import com.idm.app.idpconfig.countAnalysis.model.ScoreRuleTotalScoreInfo;
import com.idm.app.idpconfig.countAnalysis.service.ScoreRuleInfoService;
import com.idm.app.idpconfig.modelRule.model.ModelRuleInfo;
import com.idm.app.idpconfig.modelRule.service.ModelRuleService;
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
public class ScoreRuleInfoController {

	private Logger logger = Logger.getLogger(ScoreRuleInfoController.class);

	@Autowired
	private ModelRuleService modelRuleService;
	
	@Autowired
	ScoreRuleInfoService scoreRuleInfoService;
	
	@RequestMapping("/score_rule_model")
	public String scoreRuleInfo() {
		return "idpconfig/countAnalysis/scoreRuleInfo";
	}
	
	@RequestMapping("/scoreRule_TotalScore_Info_query")
	@ResponseBody
	@SameUrlData
	@SysLog(module="评分规则信息",operate="评分规则总分查询")
	public Object queyTotalScore(HttpServletRequest request) {
		logger.info("***********评分规则总分信息查询开始***************");
		String modelCode = request.getParameter("modelCode");     //获取模型编码
		String serialNo = request.getParameter("serialNo");   //获取交易节点流水号
		String businessNo = request.getParameter("businessNo");   //获取业务流水号
		String cifName = request.getParameter("cifName");   //获取姓名
		String idNo = request.getParameter("idNo");   //获取证件号码
		int page = Integer.parseInt(request.getParameter("page"));
		System.out.println("~~~~你的~~~~~"+page+"~~~~~~~~");
		int size = Integer.parseInt(request.getParameter("rows"));
		ResByPageVo resByPageVo = null;
		List<ScoreRuleTotalScoreInfo> list = new ArrayList<ScoreRuleTotalScoreInfo>();
		try{
			ScoreRuleTotalScoreInfo scoreRuleTotalScoreInfo = new ScoreRuleTotalScoreInfo();
			scoreRuleTotalScoreInfo.setModelCode(modelCode);
			scoreRuleTotalScoreInfo.setSerialNo(serialNo);
			scoreRuleTotalScoreInfo.setBusinessNo(businessNo);
			scoreRuleTotalScoreInfo.setCifName(cifName);
			scoreRuleTotalScoreInfo.setIdNo(idNo);
			scoreRuleTotalScoreInfo.setPage(page);
			scoreRuleTotalScoreInfo.setSize(size);
			int count = scoreRuleInfoService.selectCountByAll(scoreRuleTotalScoreInfo);
			list = scoreRuleInfoService.getScoreRuleTotalScoreInfo(scoreRuleTotalScoreInfo);
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
	
	@RequestMapping("/scoreRule_detail_Info_query")
	@ResponseBody
	@SameUrlData
	@SysLog(module="评分规则信息",operate="评分规则明细查询")
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
		List<ScoreRuleInfo> list = new ArrayList<ScoreRuleInfo>();
		try{
			List<ModelRuleInfo> modelRuleInfolist = modelRuleService.queryModelRuleInfosByModelCode(modelCode,ruleType); 
			ScoreRuleInfo scoreRuleInfo = new ScoreRuleInfo();
			scoreRuleInfo.setModelCode(modelCode);
			scoreRuleInfo.setBusinessNo(businessNo);
			scoreRuleInfo.setCifName(cifName);
			scoreRuleInfo.setIdNo(idNo);
			List<ScoreRuleInfo> scoreRuleInfoList = scoreRuleInfoService.getScoreRuleInfos(scoreRuleInfo);
			if(modelRuleInfolist==null || modelRuleInfolist.size()==0){ //说明该产品未初始化到表idm_modeltorule_info里
				list.addAll(scoreRuleInfoList);
			}else if(modelRuleInfolist.size()>0 &&(scoreRuleInfoList!=null && scoreRuleInfoList.size()>0)){ //说明该产品初始化到表idm_modeltorule_info里
				for(int i=0;i<modelRuleInfolist.size();i++){ //获取已经执行的规则
					ModelRuleInfo modelRuleInfo = modelRuleInfolist.get(i);
					String ruleCode = modelRuleInfo.getRulecode(); //规则编码
					for(int j=0;j<scoreRuleInfoList.size();j++){
						ScoreRuleInfo scoreRuleInfo1 = scoreRuleInfoList.get(j);
						String ruleCode1 = scoreRuleInfo1.getRuleCode(); //规则编码
						if(ruleCode.equals(ruleCode1)){
							list.add(scoreRuleInfo1);
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
