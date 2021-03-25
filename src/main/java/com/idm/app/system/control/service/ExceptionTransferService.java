package com.idm.app.system.control.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.idm.app.system.control.mapper.ExceptionTransferMapper;
import com.idm.app.system.control.model.ExceptionInvok;
import com.idm.common.util.DownloadUtil;

@Service
public class ExceptionTransferService {
	
	@Value("${exceptionExcelPath}")
	private String exceptionExcelPath;		//excel生成路径
	
	@Resource
	private ExceptionTransferMapper exceptionTransferMapper;

	public List<ExceptionInvok> selectByAll(ExceptionInvok vok) {
		// TODO Auto-generated method stub
		return exceptionTransferMapper.selectByAll(vok);
	}

	public int selectCountByAll(ExceptionInvok vok) {
		// TODO Auto-generated method stub
		return exceptionTransferMapper.selectCountByAll(vok);
	}

	public List<ExceptionInvok> selectExceptionInfo(ExceptionInvok vok) {
		// TODO Auto-generated method stub
		return exceptionTransferMapper.selectExceptionInfo(vok);
	}

	public int selectCountExceptionInfo(ExceptionInvok vok) {
		// TODO Auto-generated method stub
		return exceptionTransferMapper.selectCountExceptionInfo(vok);
	}

	public List<ExceptionInvok> selectForExcel(ExceptionInvok vok) {
		// TODO Auto-generated method stub
		return exceptionTransferMapper.selectForExcel(vok);
	}

	public String createExcel(List<ExceptionInvok> list, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Map<String,String> titleMap = new LinkedHashMap<String,String>();
        titleMap.put("exceptionID", "序号");
        titleMap.put("exceptionTime", "异常发生时间");
        titleMap.put("productName", "产品名称");
        titleMap.put("implName", "数据源接口名称");
        titleMap.put("exceptionCount", "异常数量");
        String sheetName = "异常监控清单";
        try {
			ExportExcel.excelExport(list, titleMap, sheetName, exceptionExcelPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ExcelCreateError";
		}
        
        if(DownloadUtil.downloadLocal(exceptionExcelPath+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+".xls", 
        		new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+".xls", response)){
			System.out.println("下载跳转成功");
		}else{
			return "ExcelDownloadError";
		}

		return "pass";
	}

}
