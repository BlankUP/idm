package com.idm.app.idpconfig.countAnalysis.utils;

/**
 * @author: pl
 * @desc: Excel的常量数据
 * @date: 2020/9/24
 */
public class ExcelConstant {
    /**
     * 每个sheet存储的记录数 100W
     */
    public static final Integer PER_SHEET_ROW_COUNT = 100;

    /**
     * 每次向EXCEL写入的记录数(查询每页数据大小) 20W
     */
    public static final Integer PER_WRITE_ROW_COUNT = 20;

}
