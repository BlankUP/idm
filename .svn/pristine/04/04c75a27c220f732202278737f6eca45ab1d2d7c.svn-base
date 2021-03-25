package com.idm.app.system.control.controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idm.app.system.control.model.ExceptionInvok;
import com.idm.app.system.control.service.ExceptionTransferService;
import com.idm.app.system.loginfo.model.SysLog;
import com.idm.common.util.ResByPageVo;

import net.sf.json.JSONObject;

/**
 * <p>ImplControlController</p>
 * @Description：异常信息监控控制层
 * @author：houxt
 * @createTime：2019年5月10日
 * @version 1.0
 */
@Controller
public class ExceptionTransferController {

	static Logger logger = Logger.getLogger(ImplTransferController.class);
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

	@RequestMapping("/exceptionTransfer")
	public String exceptionTransfer(){

		return "control/exceptionTransfer";
	}

	@Autowired
	private ExceptionTransferService exceptionTransferService;

	@RequestMapping("/exceptionTransfer_service")
	@ResponseBody
	@SysLog(operate="首页展示",module="异常信息监控")
	public Object exceptionTransferInfoView(HttpServletRequest request){
		logger.info("******异常信息监控开始******");
		int page =Integer.parseInt(request.getParameter("page"));
		int size = Integer.parseInt(request.getParameter("rows"));
		String productName = request.getParameter("productName");		//产品名称
		String implName = request.getParameter("implName");				//接口名称
		String searchStatus = request.getParameter("searchStatus");		//统计周期
		String startDate = request.getParameter("startDate");			//开始日期
		String endDate = request.getParameter("endDate");				//结束日期
		logger.info("productName:["+productName+"]");
		logger.info("implName:["+implName+"]");
		logger.info("searchStatus:["+searchStatus+"]");
		logger.info("startDate:["+startDate+"]");
		logger.info("endDate:["+endDate+"]");
		logger.info("size:["+size+"]");
		logger.info("page:["+page+"]");
		ResByPageVo resByPageVo = null;
		try {
			if (productName != null && productName != "") 
				productName = java.net.URLDecoder.decode(productName, "UTF-8");
			if (implName != null && implName != "") 
				implName = java.net.URLDecoder.decode(implName, "UTF-8");
			if (searchStatus != null && searchStatus != "") 
				searchStatus = java.net.URLDecoder.decode(searchStatus, "UTF-8");
			if (startDate != null && startDate != "") 
				startDate = startDate.replaceAll("-", "");
			if (endDate != null && endDate != "")
				endDate = endDate.replaceAll("-", "");
			ExceptionInvok vok = new ExceptionInvok();
			vok.setProductName(productName);
			vok.setImplName(implName);
			vok.setSearchStatus(searchStatus);
			vok.setStartDate(startDate);
			vok.setEndDate(endDate);
			vok.setPage(page);
			vok.setSize(size);
			List<ExceptionInvok> list = exceptionTransferService.selectByAll(vok);
			resByPageVo = new ResByPageVo(size, page, exceptionTransferService.selectCountByAll(vok));
			resByPageVo.setRows(list);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			logger.error("ExceptionTransferController:组装返回数据失败！", e);
		}
		logger.info("******异常信息监控结束******");
		return JSONObject.fromObject(resByPageVo);
	}

	@RequestMapping("/exceptionTransfer_info_service")
	@ResponseBody
	@SysLog(operate="异常信息显示",module="异常信息监控")
	public Object exceptionInfoView(HttpServletRequest request){
		logger.info("******异常信息查询开始******");
		int page =Integer.parseInt(request.getParameter("page"));
		int size = Integer.parseInt(request.getParameter("rows"));
		String implName = request.getParameter("implName");				//接口名称
		String productName = request.getParameter("productName");		//产品名称
		String exceptionTime = request.getParameter("exceptionTime");	//异常时间
		logger.info("implName:["+implName+"]");
		logger.info("productName:["+productName+"]");
		logger.info("exceptionTime:["+exceptionTime+"]");
		ResByPageVo resByPageVo = null;
		ExceptionInvok vok = new ExceptionInvok();
		vok.setImplName(implName);
		vok.setProductName(productName);
		vok.setExceptionTime(exceptionTime);
		vok.setPage(page);
		vok.setSize(size);
		List <ExceptionInvok> implList = exceptionTransferService.selectExceptionInfo(vok);
		resByPageVo = new ResByPageVo(size, page, exceptionTransferService.selectCountExceptionInfo(vok));
		resByPageVo.setRows(implList);
		logger.info("******异常信息查询结束******");
		return JSONObject.fromObject(resByPageVo);
	}

	@RequestMapping("/exceptionTransferExcel")
	@ResponseBody
	@SysLog(operate="导出Excel表格",module="异常信息监控")
	public String exportExcel(HttpServletRequest request, HttpServletResponse response) {
		logger.info("******导出Excel表格开始******");
		String productName = request.getParameter("productName");		//产品名称
		String implName = request.getParameter("implName");				//接口名称
		String searchStatus = request.getParameter("searchStatus");		//统计周期
		String startDate = request.getParameter("startDate");			//开始日期
		String endDate = request.getParameter("endDate");				//结束日期
		logger.info("productName:["+productName+"]");
		logger.info("implName:["+implName+"]");
		logger.info("searchStatus:["+searchStatus+"]");
		logger.info("startDate:["+startDate+"]");
		logger.info("endDate:["+endDate+"]");
		String msg = null;
		try {
			if (productName != null && productName != "")
				productName = java.net.URLDecoder.decode(productName, "UTF-8");
			if (implName != null && implName != "") 
				implName = java.net.URLDecoder.decode(implName, "UTF-8");
			if (searchStatus != null && searchStatus != "") 
				searchStatus = java.net.URLDecoder.decode(searchStatus, "UTF-8");
			if (startDate != null && startDate != "") 
				startDate = startDate.replaceAll("-", "");
			if (endDate != null && endDate != "")
				endDate = endDate.replaceAll("-", "");
			ExceptionInvok vok = new ExceptionInvok();
			vok.setProductName(productName);
			vok.setImplName(implName);
			vok.setSearchStatus(searchStatus);
			vok.setStartDate(startDate);
			vok.setEndDate(endDate);
			List<ExceptionInvok> list = exceptionTransferService.selectForExcel(vok);
			msg = exceptionTransferService.createExcel(list, response);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("******导出Excel表格结束******");
		return msg;
	}
}
