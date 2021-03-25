package com.idm.app.idpconfig.countAnalysis.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.Table;
import com.alibaba.excel.support.ExcelTypeEnum;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idm.app.idpconfig.countAnalysis.model.IdpRequestInfo;
import com.idm.app.idpconfig.countAnalysis.service.IdpRequestInfoService;
import com.idm.app.system.loginfo.model.SysLog;
import com.idm.common.util.ResByPageVo;
import com.idm.config.resubmit.repeat_form_validator.SameUrlData;

import net.sf.json.JSONObject;


@Controller
public class IdpRequestInfoController {

	private Logger logger = Logger.getLogger(IdpRequestInfoController.class);


	@RequestMapping("/cust_request_info")
	public String idpRequestInfo() {
		return "idpconfig/countAnalysis/idpRequestInfo";
	}
	@Autowired
	private IdpRequestInfoService idprequestinfoservice;

	@RequestMapping("/Idp_Request_Info_query")
	@ResponseBody
	@SameUrlData
	@SysLog(module="客户申请信息",operate="首页查询")
	public Object queyRequestInfo(HttpServletRequest request) {
		logger.info("***********查询IDP请求数据源信息方法开始***************");
		String serialNo = request.getParameter("serialNo");
		String srcDate = request.getParameter("srcDate");
		String cifName = request.getParameter("cifName");
		String querySystemCode = request.getParameter("systemName"); //请求系统编码
		int page = Integer.parseInt(request.getParameter("page"));
		int size = Integer.parseInt(request.getParameter("rows"));

		System.out.println("systemName"+querySystemCode);
		System.out.println("page:"+page);
		System.out.println("size:"+size);
		ResByPageVo resByPageVo = null;

		IdpRequestInfo idprequestinfo = new IdpRequestInfo();
		idprequestinfo.setCifName(cifName);
		idprequestinfo.setQuerySystemCode(querySystemCode);
		idprequestinfo.setSerialNo(serialNo);
		idprequestinfo.setSrcDate(srcDate);
		idprequestinfo.setPage(page);
		idprequestinfo.setSize(size);
		int selectCountByAll = idprequestinfoservice.selectCountByAll(idprequestinfo);
		List<IdpRequestInfo> queryIdpRequestInfo = idprequestinfoservice.queryIdpRequestInfo(idprequestinfo);
		resByPageVo = new ResByPageVo(size, page,selectCountByAll);

		resByPageVo.setRows(queryIdpRequestInfo);

        logger.info("******请求数据信息查询结束******");
        return JSONObject.fromObject(resByPageVo);




	}
	@RequestMapping("/idp_requestExcel")
	@ResponseBody
	@SysLog(operate = "导出表格",module = "贷款申请流水")
	public String export(IdpRequestInfo idprequestinfo, HttpServletResponse response) throws Exception {

		ServletOutputStream out = null;
		try {
			out = response.getOutputStream();
			ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);

			//
			int count = idprequestinfoservice.selectCountByAll(idprequestinfo);

			// 设置EXCEL名称
			String fileName = new String(("SystemExcel").getBytes(), "UTF-8");

			// 设置SHEET名称
			Sheet sheet = new Sheet(1, 0);
			sheet.setSheetName("系统列表sheet1");

			// 设置标题
			Table table = new Table(1);
			List<List<String>> titles = new ArrayList<List<String>>();
			titles.add(Arrays.asList("业务流水号"));
			titles.add(Arrays.asList("业务请求日期"));
			titles.add(Arrays.asList("业务请求时间"));
			titles.add(Arrays.asList("请求信息"));
			table.setHead(titles);

			// 查数据写EXCEL
			List<List<String>> dataList = new ArrayList<>();
			List<IdpRequestInfo> queryIdpRequestInfo = idprequestinfoservice.queryIdpRequestInfoExcel(idprequestinfo);
			if (!CollectionUtils.isEmpty(queryIdpRequestInfo)) {
				queryIdpRequestInfo.forEach(eachSysSystemVO -> {
					dataList.add(Arrays.asList(
							eachSysSystemVO.getSerialNo(),
							eachSysSystemVO.getSrcDate(),
							eachSysSystemVO.getSrcTime(),
							eachSysSystemVO.getMessAge()
					));
				});
			}
			writer.write0(dataList, sheet, table);

			// 下载EXCEL
				response.setHeader("Content-Disposition", "attachment;filename=" + new String((fileName).getBytes("gb2312"), "ISO-8859-1") + ".xls");
			response.setContentType("multipart/form-data");
			response.setCharacterEncoding("utf-8");
			writer.finish();
			out.flush();

		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		return  null;
	}

	
}
