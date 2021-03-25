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

import com.idm.app.system.control.mapper.ImplTransferMapper;
import com.idm.app.system.control.model.InterfaceInvok;
import com.idm.common.util.DownloadUtil;

@Service
public class ImplTransferService {
	
	@Value("${implExcelPath}")
	private String implExcelPath;		//excel生成路径
	
	@Resource
	private ImplTransferMapper implTransferMapper;

	public List<InterfaceInvok> selectByAll(InterfaceInvok vok) {
		// TODO Auto-generated method stub
		return implTransferMapper.selectByAll(vok);
	}

	public int selectCountByAll(InterfaceInvok vok) {
		// TODO Auto-generated method stub
		return implTransferMapper.selectCountByAll(vok);
	}

	public List<InterfaceInvok> selectImplInfo(InterfaceInvok vok) {
		// TODO Auto-generated method stub
		return implTransferMapper.selectImplInfo(vok);
	}

	public int selectCountImplInfo(InterfaceInvok vok) {
		// TODO Auto-generated method stub
		return implTransferMapper.selectCountImplInfo(vok);
	}

	public List<InterfaceInvok> selectForExcel(InterfaceInvok vok) {
		// TODO Auto-generated method stub
		return implTransferMapper.selectForExcel(vok);
	}
	
	public String createExcel(List<InterfaceInvok> implList, HttpServletResponse response) {//创建Excel表格
		// TODO Auto-generated method stub
		Map<String,String> titleMap = new LinkedHashMap<String,String>();
        titleMap.put("implID", "序号");
        titleMap.put("implTime", "业务发生时间");
        titleMap.put("implName", "数据源接口名称");
        titleMap.put("allUse", "调用笔数");
        titleMap.put("sucUse", "调用成功笔数");
        titleMap.put("sucRate", "调用成功率");
        titleMap.put("maxTime", "最大调用时间");
        titleMap.put("avgTime", "平均调用时间");
        String sheetName = "接口监控清单";
        try {
			ExportExcel.excelExport(implList, titleMap, sheetName, implExcelPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ExcelCreateError";
		}
        
        if(DownloadUtil.downloadLocal(implExcelPath+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+".xls", 
        		new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+".xls", response)){
			System.out.println("下载跳转成功");
		}else{
			return "ExcelDownloadError";
		}

		return "pass";
	}
}
