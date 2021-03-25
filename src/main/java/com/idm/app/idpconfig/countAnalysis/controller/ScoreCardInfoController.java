package com.idm.app.idpconfig.countAnalysis.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.idm.app.idpconfig.countAnalysis.model.ScoreCardInfo;
import com.idm.app.idpconfig.countAnalysis.model.ScoreCardTotalScoreInfo;
import com.idm.app.idpconfig.countAnalysis.service.ScoreCardInfoService;
import com.idm.app.idpconfig.modelRule.model.ModelRuleInfo;
import com.idm.app.system.control.model.InterfaceInvok;
import com.idm.app.system.loginfo.model.SysLog;
import com.idm.common.util.ResByPageVo;
import com.idm.config.resubmit.repeat_form_validator.SameUrlData;

import net.sf.json.JSONObject;

/**
 * <p>Description:评分卡控制层 </p>  ：
 * @author：pl
 * @createTime：2020.03.02
 * @version 1.0
 */
@Controller
public class ScoreCardInfoController {

	private Logger logger = Logger.getLogger(ScoreCardInfoController.class);

	@Autowired
	ScoreCardInfoService scoreCardInfoService;
	
	@RequestMapping("/score_card_model")
	public String scoreRuleInfo() {
		return "idpconfig/countAnalysis/scoreCardInfo";
	}
	
	@RequestMapping("/scoreCard_TotalScore_Info_query")
	@ResponseBody
	@SameUrlData
	@SysLog(module="评分卡信息",operate="评分卡总分查询")
	public Object queyTotalScore(HttpServletRequest request) {
		logger.info("***********评分卡总分信息查询开始***************");
		String serialNo = request.getParameter("serialNo");   //获取交易节点流水号
		String cifName = request.getParameter("cifName");   //获取姓名  modelCode
		String modelCode = request.getParameter("modelCode"); 
		String startDate = request.getParameter("startDate"); //开始时间
		String endDate = request.getParameter("endDate");   //结束时间
		int page = Integer.parseInt(request.getParameter("page"));
		int size = Integer.parseInt(request.getParameter("rows"));
		ResByPageVo resByPageVo = null;
		try{
			if (serialNo != null && serialNo != "")
				serialNo = java.net.URLDecoder.decode(serialNo, "UTF-8");
			if (modelCode != null && modelCode != "")
				modelCode = java.net.URLDecoder.decode(modelCode, "UTF-8");
			if (cifName != null && cifName != "") 
				cifName = java.net.URLDecoder.decode(cifName, "UTF-8");
			if (startDate != null && startDate != "") 
				startDate = startDate.replaceAll("-", "");
			logger.info("************"+startDate);
			if (endDate != null && endDate != "")
				endDate = endDate.replaceAll("-", "");
			logger.info("************"+endDate);
			ScoreCardTotalScoreInfo scoreCardTotalScoreInfo = new ScoreCardTotalScoreInfo();
			scoreCardTotalScoreInfo.setSerialNo(serialNo);
			scoreCardTotalScoreInfo.setCifName(cifName);
			scoreCardTotalScoreInfo.setModelCode(modelCode);
			scoreCardTotalScoreInfo.setPage(page);
			scoreCardTotalScoreInfo.setSize(size);
			int count = scoreCardInfoService.selectTotalScoreCountByAll(scoreCardTotalScoreInfo,startDate,endDate);
			List<ScoreCardTotalScoreInfo> list = scoreCardInfoService.getScoreRuleTotalScoreInfo(scoreCardTotalScoreInfo,startDate,endDate);
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
	
	@RequestMapping("/scoreCard_detail_Info_query")
	@ResponseBody
	@SameUrlData
	@SysLog(module="评分卡信息",operate="评分明细查询")
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
			ScoreCardInfo scoreCardInfo = new ScoreCardInfo();
			scoreCardInfo.setModelCode(modelCode);
			scoreCardInfo.setBusinessNo(businessNo);
			scoreCardInfo.setCifName(cifName);
			scoreCardInfo.setIdNo(idNo);
			scoreCardInfo.setPage(page);
			scoreCardInfo.setSize(size);
			int count = scoreCardInfoService.selectCountByAll(scoreCardInfo);
			List<ScoreCardInfo> list = scoreCardInfoService.getScoreCardInfo(scoreCardInfo);
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
	
	@RequestMapping("/scoreCardExcel")
	@ResponseBody
	@SysLog(operate="导出Excel表格",module="评分卡详情")
	public String exportExcel(HttpServletRequest request, HttpServletResponse response) {
		logger.info("******导出Excel表格开始******");
		String modelCode = request.getParameter("modelCode");     //获取模型编码
		String serialNo = request.getParameter("serialNo");				//流水号
		String cifName = request.getParameter("cifName");		//客户名
		String startDate = request.getParameter("startDate");			//开始日期
		String endDate = request.getParameter("endDate");				//结束日期
		logger.info("serialNo:["+serialNo+"]");
		logger.info("cifName:["+cifName+"]");
		logger.info("startDate:["+startDate+"]");
		logger.info("endDate:["+endDate+"]");
		String msg = null;
		if (serialNo != null && serialNo != "")
			try {
				serialNo = java.net.URLDecoder.decode(serialNo, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if (cifName != null && cifName != "")
			try {
				cifName = java.net.URLDecoder.decode(cifName, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if (modelCode != null && modelCode != "")
			try {
				modelCode = java.net.URLDecoder.decode(modelCode, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if (startDate != null && startDate != "") 
			startDate = startDate.replaceAll("-", "");
		if (endDate != null && endDate != "")
			endDate = endDate.replaceAll("-", "");
		logger.info("******Excel模板导出downLoadExcelFile方法开始******");
		response.setContentType("text/html;charset=UTF-8");
		List<ScoreCardTotalScoreInfo> yList = scoreCardInfoService.getScoreRuleInfo(startDate,endDate);
		logger.info("&&"+yList);
		if (yList.size() > 0) {
			XSSFWorkbook workbook = new XSSFWorkbook();
		         try {
		 			Sheet sheet = workbook.createSheet("rulemodel");
		 			Row row = sheet.createRow(0);
		 			CellStyle createCellStyle = workbook.createCellStyle();
		     			row.createCell(0).setCellValue("交易流水号");
						row.createCell(1).setCellValue("客户名称");
						row.createCell(2).setCellValue("身份证号");
						row.createCell(3).setCellValue("机构编码");
						row.createCell(4).setCellValue("机构名称");
						row.createCell(5).setCellValue("产品编码");
						row.createCell(6).setCellValue("产品名称");
						row.createCell(7).setCellValue("模型编码");
						row.createCell(8).setCellValue("模型名称");
						row.createCell(9).setCellValue("总分");
						row.createCell(10).setCellValue("接受请求日期");
						row.createCell(11).setCellValue("接受请求时间");
		 			//导入
		 			for (int i = 0; i < yList.size(); i++) {
						row = sheet.createRow(i+1);
						ScoreCardTotalScoreInfo mInfo = yList.get(i);
						row.createCell(0).setCellValue(mInfo.getSerialNo());
						row.createCell(1).setCellValue(mInfo.getCifName());
						row.createCell(2).setCellValue(mInfo.getIdNo());
						row.createCell(3).setCellValue(mInfo.getDeptId());
						row.createCell(4).setCellValue(mInfo.getDeptName());
						row.createCell(5).setCellValue(mInfo.getProductId());
						row.createCell(6).setCellValue(mInfo.getProductName());
						row.createCell(7).setCellValue(mInfo.getModelCode());
						row.createCell(8).setCellValue(mInfo.getModelName());
						row.createCell(9).setCellValue(mInfo.getScore());
						row.createCell(10).setCellValue(mInfo.getRkDate());
						row.createCell(11).setCellValue(mInfo.getRkTime());
					}
		 		FileOutputStream fileOut=new FileOutputStream("D:/scoreCard.xlsx");
		 		 workbook.write(fileOut);
		 			logger.info("~~~~~~~~~~~"+row+"表格导出完成");
		 			File file = new File("D:/scoreCard.xlsx");
		        response.setCharacterEncoding("UTF-8");  
		        response.setHeader("Content-Disposition",  
		                "attachment; filename="+java.net.URLEncoder.encode("scoreCard.xlsx", "UTF-8"));  
		        response.setContentLength((int) file.length());  
		        response.setContentType("application/ms-excel");// 定义输出类型  
		        FileInputStream fis = new FileInputStream(file);  
		        BufferedInputStream buff = new BufferedInputStream(fis);  
		        byte[] b = new byte[1024];// 相当于我们的缓存  
		        long k = 0;// 该值用于计算当前实际下载了多少字节  
		        OutputStream myout = response.getOutputStream();// 从response对象中得到输出流,准备下载  
		        // 开始循环下载  
		        while (k < file.length()) {  
		            int j = buff.read(b, 0, 1024);  
		            k += j;  
		            myout.write(b, 0, j);  
		        }  
		        myout.flush();  
		        buff.close();
		        fileOut.close();
		         } catch (EncryptedDocumentException e) {
		  			logger.error("类ParaFieldsConfigController中方法importExcelFieldData出现EncryptedDocumentException异常：", e);
		  		}catch (IOException e) {
		  			logger.error("类ParaFieldsConfigController中方法importExcelFieldData出现IOException异常：", e);
		  		} catch (Exception e) {  
		    	logger.error("类ParaFieldsConfigController中方法downLoadZipFile出现Exception异常：", e);
		    	return " 文件评分卡详情数据下载成功！ ";
		    }
		    logger.info("******Excel模板导出downLoadExcelZipFile方法结束******");
		}
		
		return null;
	}
	}
