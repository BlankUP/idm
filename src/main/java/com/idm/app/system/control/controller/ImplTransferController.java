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

import com.idm.app.idpconfig.eventconfig.model.InterfaceInfo;
import com.idm.app.system.control.model.InterfaceInvok;
import com.idm.app.system.control.service.ImplTransferService;
import com.idm.app.system.loginfo.model.SysLog;
import com.idm.common.util.ResByPageVo;

import net.sf.json.JSONObject;

/**
 * <p>ImplControlController</p>
 * @Description：接口调用管理控制层
 * @author：houxt
 * @createTime：2019年5月5日
 * @version 1.0
 */
@Controller
public class ImplTransferController {

	static Logger logger = Logger.getLogger(ImplTransferController.class);
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

	@Autowired
	private ImplTransferService implTransferService;

	@RequestMapping("/implTransfer")
	public String implTransfer(){

		return "control/implTransfer";
	}

	@RequestMapping("/implTransfer_service")
	@ResponseBody
	@SysLog(operate="首页展示",module="接口调用监控")
	public Object implTransferInfoView(HttpServletRequest request){
		logger.info("******接口调用监控开始******");
		int page =Integer.parseInt(request.getParameter("page"));
		int size = Integer.parseInt(request.getParameter("rows"));
		String implName = request.getParameter("implName");				//接口名称
		String searchStatus = request.getParameter("searchStatus");		//统计周期
		String startDate = request.getParameter("startDate");			//开始日期
		String endDate = request.getParameter("endDate");				//结束日期
		logger.info("implName:["+implName+"]");
		logger.info("searchStatus:["+searchStatus+"]");
		logger.info("startDate:["+startDate+"]");
		logger.info("endDate:["+endDate+"]");
		logger.info("size:["+size+"]");
		logger.info("page:["+page+"]");
		ResByPageVo resByPageVo = null;
		try {
			if (implName != null && implName != "") 
				implName = java.net.URLDecoder.decode(implName, "UTF-8");
			if (searchStatus != null && searchStatus != "") 
				searchStatus = java.net.URLDecoder.decode(searchStatus, "UTF-8");
			if (startDate != null && startDate != "") 
				startDate = startDate.replaceAll("-", "");
			if (endDate != null && endDate != "")
				endDate = endDate.replaceAll("-", "");
			InterfaceInvok vok = new InterfaceInvok();
			vok.setPage(page);
			vok.setSize(size);
			vok.setInterfaceName(implName);
			vok.setStartTime(startDate);
			vok.setEndTime(endDate);
			vok.setSearchStatus(searchStatus);
			List <InterfaceInvok> implList = implTransferService.selectByAll(vok);
			resByPageVo = new ResByPageVo(size, page, implTransferService.selectCountByAll(vok));
			resByPageVo.setRows(implList);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			logger.error("ImplTransferController:组装返回数据失败！", e);
		}
		logger.info("******接口调用监控结束******");
		return JSONObject.fromObject(resByPageVo);
	}

	@RequestMapping("/implTransfer_info_service")
	@ResponseBody
	@SysLog(operate="接口信息显示",module="接口调用监控")
	public Object implInfoView(HttpServletRequest request){
		logger.info("******接口信息查询开始******");
		int page =Integer.parseInt(request.getParameter("page"));
		int size = Integer.parseInt(request.getParameter("rows"));
		String implTime = request.getParameter("implTime");				//日期
		String implName = request.getParameter("implName");				//接口名称
		logger.info("implTime:["+implTime+"]");
		logger.info("implName:["+implName+"]");
		ResByPageVo resByPageVo = null;
		InterfaceInvok vok = new InterfaceInvok();
		vok.setImplTime(implTime);
		vok.setImplName(implName);
		vok.setPage(page);
		vok.setSize(size);
		List <InterfaceInvok> implList = implTransferService.selectImplInfo(vok);
		resByPageVo = new ResByPageVo(size, page, implTransferService.selectCountImplInfo(vok));
		resByPageVo.setRows(implList);
		logger.info("******接口信息查询结束******");
		return JSONObject.fromObject(resByPageVo);
	}

	@RequestMapping("/implTransferExcel")
	@ResponseBody
	@SysLog(operate="导出Excel表格",module="接口调用监控")
	public String exportExcel(HttpServletRequest request, HttpServletResponse response) {
		logger.info("******导出Excel表格开始******");
		String implName = request.getParameter("implName");				//接口名称
		String searchStatus = request.getParameter("searchStatus");		//统计周期
		String startDate = request.getParameter("startDate");			//开始日期
		String endDate = request.getParameter("endDate");				//结束日期
		logger.info("implName:["+implName+"]");
		logger.info("searchStatus:["+searchStatus+"]");
		logger.info("startDate:["+startDate+"]");
		logger.info("endDate:["+endDate+"]");
		String msg = null;
		try {
			if (implName != null && implName != "")
				implName = java.net.URLDecoder.decode(implName, "UTF-8");
			if (searchStatus != null && searchStatus != "") 
				searchStatus = java.net.URLDecoder.decode(searchStatus, "UTF-8");
			if (startDate != null && startDate != "") 
				startDate = startDate.replaceAll("-", "");
			if (endDate != null && endDate != "")
				endDate = endDate.replaceAll("-", "");
			InterfaceInvok vok = new InterfaceInvok();
			vok.setInterfaceName(implName);
			vok.setStartTime(startDate);
			vok.setEndTime(endDate);
			vok.setSearchStatus(searchStatus);
			List <InterfaceInvok> implList = implTransferService.selectForExcel(vok);
			msg = implTransferService.createExcel(implList, response);
			logger.info("******导出Excel表格结束******");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msg;
	}
}
