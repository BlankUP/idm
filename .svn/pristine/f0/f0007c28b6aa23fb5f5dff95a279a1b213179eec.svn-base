package com.idm.app.idpconfig.mqiCountAnalysis.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idm.app.idpconfig.mqiCountAnalysis.model.MqiScoreCardInfo;
import com.idm.app.idpconfig.mqiCountAnalysis.model.MqiScoreCardTotalScoreInfo;
import com.idm.app.idpconfig.mqiCountAnalysis.service.MqiScoreCardInfoService;
import com.idm.app.system.loginfo.model.SysLog;
import com.idm.common.util.ResByPageVo;
import com.idm.config.resubmit.repeat_form_validator.SameUrlData;

import net.sf.json.JSONObject;

/**
 * <p>Description:评分卡控制层 </p>  ：
 * @author：jiamh
 * @createTime：2019年8月23日
 * @version 1.0
 */
@Controller
public class MqiScoreCardInfoController {

	private Logger logger = Logger.getLogger(MqiScoreCardInfoController.class);

	@Autowired
	MqiScoreCardInfoService mqiScoreCardInfoService;
	
	@RequestMapping("/mqi_score_card_model")
	public String scoreRuleInfo() {
		return "idpconfig/mqiCountAnalysis/mqiScoreCardInfo";
	}
	
	@RequestMapping("/mqi_scoreCard_TotalScore_Info_query")
	@ResponseBody
	@SameUrlData
	@SysLog(module="模型质检评分卡信息",operate="评分卡总分查询")
	public Object queyTotalScore(HttpServletRequest request) {
		logger.info("***********评分卡总分信息查询开始***************");
		String modelCode = request.getParameter("modelCode");     //获取模型编码
		String jnlNo = request.getParameter("jnlNo");       //获取交易节点流水号
		String businessNo = request.getParameter("businessNo");   //获取业务流水号
		String cifName = request.getParameter("cifName");   //获取姓名
		String idNo = request.getParameter("idNo");   //获取证件号码
		int page = Integer.parseInt(request.getParameter("page"));
		int size = Integer.parseInt(request.getParameter("rows"));
		ResByPageVo resByPageVo = null;
		try{
			MqiScoreCardTotalScoreInfo mqiScoreCardTotalScoreInfo = new MqiScoreCardTotalScoreInfo();
			mqiScoreCardTotalScoreInfo.setModelCode(modelCode);
			mqiScoreCardTotalScoreInfo.setJnlNo(jnlNo);
			mqiScoreCardTotalScoreInfo.setBusinessNo(businessNo);
			mqiScoreCardTotalScoreInfo.setCifName(cifName);
			mqiScoreCardTotalScoreInfo.setIdNo(idNo);
			mqiScoreCardTotalScoreInfo.setPage(page);
			mqiScoreCardTotalScoreInfo.setSize(size);
			int count = mqiScoreCardInfoService.selectTotalScoreCountByAll(mqiScoreCardTotalScoreInfo);
			List<MqiScoreCardTotalScoreInfo> list = mqiScoreCardInfoService.getScoreRuleTotalScoreInfo(mqiScoreCardTotalScoreInfo);
			resByPageVo = new ResByPageVo(size, page, count);
			if (list != null && list.size() > 0) {
				logger.info("评分卡总分查询成功，总记录[" + count + "]");
				resByPageVo.setRows(list);
			} else if (list != null && list.size() == 0) {
				logger.info(">>评分卡总分无记录");
				resByPageVo = new ResByPageVo(size, page, 0);
			} else {
				logger.info(">>评分卡总分数据库错误");
				resByPageVo = new ResByPageVo(size, page, 0);
			}
		}catch(Exception e){
			logger.error("类ScorcCardInfoController中方法queyTotalScore出现Exception异常：", e);
		}
        logger.info("******评分卡总分查询结束******");
        return JSONObject.fromObject(resByPageVo);
	}
	
	@RequestMapping("/mqi_scoreCard_detail_Info_query")
	@ResponseBody
	@SameUrlData
	@SysLog(module="模型质检评分卡信息",operate="评分明细查询")
	public Object queyScoreCardInfos(HttpServletRequest request) {
		logger.info("***********查询评分明细信息方法开始***************");
		String modelCode = request.getParameter("modelCode");     //获取模型编码
		String businessNo = request.getParameter("businessNo");   //获取业务流水号
		String cifName = request.getParameter("cifName");   //获取姓名
		String idNo = request.getParameter("idNo");   //获取证件号码
		int page = Integer.parseInt(request.getParameter("page"));
		int size = Integer.parseInt(request.getParameter("rows"));
		ResByPageVo resByPageVo = null;
		try{
			MqiScoreCardInfo mqiScoreCardInfo = new MqiScoreCardInfo();
			mqiScoreCardInfo.setModelCode(modelCode);
			mqiScoreCardInfo.setBusinessNo(businessNo);
			mqiScoreCardInfo.setCifName(cifName);
			mqiScoreCardInfo.setIdNo(idNo);
			mqiScoreCardInfo.setPage(page);
			mqiScoreCardInfo.setSize(size);
			int count = mqiScoreCardInfoService.selectCountByAll(mqiScoreCardInfo);
			List<MqiScoreCardInfo> list = mqiScoreCardInfoService.getScoreCardInfo(mqiScoreCardInfo);
			resByPageVo = new ResByPageVo(size, page, count);
			if (list != null && list.size() > 0) {
				logger.info("查询评分明细信息成功，总记录[" + count + "]");
				resByPageVo.setRows(list);
			} else if (list != null && list.size() == 0) {
				logger.info(">>评分明细无记录");
				resByPageVo = new ResByPageVo(size, page, 0);
			} else {
				logger.info(">>评分明细数据库错误");
				resByPageVo = new ResByPageVo(size, page, 0);
			}
			logger.info("******评分明细信息查询结束******");
		}catch(Exception e){
			logger.error("类ScorcCardInfoController中方法queyScoreCardInfos出现Exception异常：", e);
		}
        return JSONObject.fromObject(resByPageVo);
	}
}
