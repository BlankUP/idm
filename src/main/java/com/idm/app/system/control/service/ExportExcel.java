package com.idm.app.system.control.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;

/**
 * <p>ExprotExcel</p>
 * @Description：生成Excel工具类
 * @author：houxt
 * @createTime：2019年5月5日
 * @version 1.0
 */
public class ExportExcel {
	private static HSSFWorkbook workbook;					//工作簿
	private static HSSFSheet sheet;							//sheet
	private static final int TITLE_START_POSITION = 0;		//标题行起始位置
	private static final int DATEHEAD_START_POSITION = 1;	//时间行起始位置
	private static final int HEAD_START_POSITION = 2;		//表头行起始位置
	private static final int CONTENT_START_POSITION = 3;	//文本行起始位置

	public static void excelExport(List<?> dataList, Map<String, String> titleMap, String sheetName, String path) throws IOException {
		// 初始化workbook
		initHSSFWorkbook(sheetName);
		// 标题行
		createTitleRow(titleMap, sheetName);
		// 时间行
		createDateHeadRow(titleMap);
		// 表头行
		createHeadRow(titleMap);
		// 文本行
		createContentRow(dataList, titleMap);
			//生成UUID文件名称
			//UUID是指在一台机器上生成的数字，它保证对在同一时空中的所有机器都是唯一的。
			//UUID uuid = UUID.randomUUID();
			//String filedisplay = uuid+".xls";
			//如果web项目，1、设置下载框的弹出（设置response相关参数)；2、通过httpservletresponse.getOutputStream()获取
		OutputStream out = new FileOutputStream(path + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+".xls");
		workbook.write(out);
		out.close();

	}
	private static void initHSSFWorkbook(String sheetName) {
		workbook = new HSSFWorkbook();
		sheet = workbook.createSheet(sheetName);
	}

	private static void createTitleRow(Map<String, String> titleMap, String sheetName) {
        CellRangeAddress titleRange = new CellRangeAddress(0, 0, 0, titleMap.size() - 1);
        sheet.addMergedRegion(titleRange);
        HSSFRow titleRow = sheet.createRow(TITLE_START_POSITION);
        HSSFCell titleCell = titleRow.createCell(0);
        titleCell.setCellValue(sheetName);
      }

	private static void createDateHeadRow(Map<String, String> titleMap) {
        CellRangeAddress dateRange = new CellRangeAddress(1, 1, 0, titleMap.size() - 1);
        sheet.addMergedRegion(dateRange);
        HSSFRow dateRow = sheet.createRow(DATEHEAD_START_POSITION);
        HSSFCell dateCell = dateRow.createCell(0);   
        dateCell.setCellValue(new SimpleDateFormat("yyyy年MM月dd日").format(new Date()));
      }

	private static void createHeadRow(Map<String, String> titleMap) {
        // 第1行创建
        HSSFRow headRow = sheet.createRow(HEAD_START_POSITION);
        int i = 0;
        for (String entry : titleMap.keySet()) {
          HSSFCell headCell = headRow.createCell(i);
          headCell.setCellValue(titleMap.get(entry));
          i++;
        }
      }

	private static void createContentRow(List<?> dataList, Map<String, String> titleMap) {
        try {
          int i=0;
          for (Object obj : dataList) {
            HSSFRow textRow = sheet.createRow(CONTENT_START_POSITION + i);
            int j = 0;
            for (String entry : titleMap.keySet()) {
              String method = "get" + entry.substring(0, 1).toUpperCase() + entry.substring(1);
              Method m = obj.getClass().getMethod(method, null);
              String value =   m.invoke(obj, null).toString();
              HSSFCell textcell = textRow.createCell(j);
              textcell.setCellValue(value);
              j++;
            }
            i++;
          }

        }
        catch (Exception e) {
          e.printStackTrace();
        }
      }


}



