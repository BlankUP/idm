package com.idm.common.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by dong on 2018/3/31.
 */
public class ExcelExport {
    /**
     * 导出单个sheet
     * @param book 写入的主要句柄，为多sheet页写入而准备
     * @param sheetName sheet页名
     * @param fields 需要导出的字段列表
     * @param titles 中文标题列表，与字段fields一一对应
     * @param objList 需要导出的对象list
     * @return 返回写入句柄，如需返回，需要写入到byte数组中
     * @throws Exception
     */
    public static <T> XSSFWorkbook exportSingleSheet(XSSFWorkbook book, String sheetName, String[] fields, String[] titles, List<T> objList) throws Exception {

        //行索引
        int rowIndex = 0;
        XSSFSheet sheet = book.createSheet(sheetName);
        XSSFRow header = sheet.createRow(rowIndex);

        //产生标题行
        for (int i = 0; i < titles.length; i++) {
            header.createCell(i).setCellValue(titles[i]);
        }

        //从第一行开始填充数据
        rowIndex = 1;
        for (int i = 0; i < objList.size(); i++) {
            //创建行
            XSSFRow row = sheet.createRow(rowIndex++);
            Object obj = objList.get(i);

            //使用反射的方法获取其中字段的值
            List<String> values = ObjectUtils.getFeildValues(obj, fields);

            //遍历添加到excel中
            //行索引id
            int colIndex = 0;
            for (String value: values) {
                row.createCell(colIndex++).setCellValue(value);
            }
        }
        return book;
    }

    /**
     * 导出单个sheet
     * @param sheetName sheet页名
     * @param fields 需要导出的字段列表
     * @param titles 中文标题列表，与字段fields一一对应
     * @param objList 需要导出的对象list
     * @return 已经封装成byte数组，直接使用即可
     * @throws Exception
     */
    public static <T> byte[] exportSingleSheet(String sheetName, String[] fields, String[] titles, List<T> objList) throws Exception {
        XSSFWorkbook book = new XSSFWorkbook();

        book = ExcelExport.exportSingleSheet(book, sheetName, fields, titles, objList);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        book.write(output);

        byte[] b = output.toByteArray();
        return b;

    }

    /**
     * 写入多个sheet页的方法
     * @param book
     * @param sheetNames
     * @param fieldsList
     * @param titlesList
     * @param objLists
     * @param <T>
     * @return 返回未封装的句柄，方便后续写入
     * @throws Exception
     */
    public static <T> XSSFWorkbook exportMultiSheet(XSSFWorkbook book, List<String> sheetNames,
                                                    List<String[]> fieldsList, List<String[]> titlesList, List<List<T>> objLists) throws Exception {

        byte[] res = new byte[1024];
        try {
            for (int i = 0; i < sheetNames.size(); i++) {
                book = ExcelExport.exportSingleSheet(book, sheetNames.get(i), fieldsList.get(i), titlesList.get(i), objLists.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return book;
    }



    /**
     * 写入多个sheet页的方法
     * @param sheetNames
     * @param fieldsList
     * @param titlesList
     * @param objLists
     * @param <T>
     * @return 已经封装成byte数组，直接使用即可
     * @throws Exception
     */
    public static <T> byte[] exportMultiSheet(List<String> sheetNames,
                                              List<String[]> fieldsList, List<String[]> titlesList, List<List<T>> objLists) throws Exception {

        XSSFWorkbook book = new XSSFWorkbook();

        book = ExcelExport.exportMultiSheet(book, sheetNames, fieldsList, titlesList, objLists);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        book.write(output);

        byte[] b = output.toByteArray();
        return b;
    }

    /**
     * Description:获取excel里一个工作表的内容
     * @param sheet
     * @param beginRowNum
     * @return
     */
    public static synchronized String[][] getDataFromExcel(Sheet sheet,int beginRowNum){
    	
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    	
		int RowNum = sheet.getPhysicalNumberOfRows();            //获取sheet中行数
		int LineNum = sheet.getRow(0).getPhysicalNumberOfCells();//获取sheet中列数
		String[][] dataOne = new String[RowNum][LineNum];
      
		//把Excel数据写入到数组中
		for(int i=beginRowNum;i<RowNum;i++){    //从第二行开始读取数据（第一行是表头，为无效数据）
			Row row = sheet.getRow(i);//先获取行元素
			if(row==null){            //行为空跳过
				continue;
			}
			for(int j=0;j<LineNum;j++){
				String cellValue = "";
				Cell cell = row.getCell(j);//确定到某个单元格
				if(cell==null)
					continue;
				switch(cell.getCellType()){
					case Cell.CELL_TYPE_STRING://字符型
						cellValue = cell.getStringCellValue();
						cellValue = cellValue.trim().replaceAll("\n", "");
						break;
					case Cell.CELL_TYPE_BOOLEAN: // Boolean
						cellValue = cell.getBooleanCellValue() + "";
						break;
					case Cell.CELL_TYPE_FORMULA://公式
						try {
							cellValue = String.valueOf(cell.getNumericCellValue());
						} catch (IllegalStateException e) {
							cellValue = String.valueOf(cell.getRichStringCellValue());
						}
						break;
					case Cell.CELL_TYPE_NUMERIC://数值型
		                cell.setCellType(Cell.CELL_TYPE_STRING);
						cellValue = String.valueOf(cell.getRichStringCellValue().getString());
						break;
					case Cell.CELL_TYPE_BLANK: //空值
						cellValue = "";
						break;
				}
				dataOne[i][j] = cellValue;
			}
		}
		return dataOne;
    }
    

}
