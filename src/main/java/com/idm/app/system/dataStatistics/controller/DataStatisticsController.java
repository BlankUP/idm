package com.idm.app.system.dataStatistics.controller;

import com.alibaba.fastjson.JSONObject;
import com.idm.common.util.DateUtil;
import com.idm.common.util.DownloadUtil;
import com.idm.config.context.SpringContextHolder;
import jxl.Workbook;
import jxl.write.*;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

/**
 * @Author lifadeng
 * @Description: 数据统计
 * @Create: 2018/11/13 15:38
 * @Version: 1.0
 */
@Controller
public class DataStatisticsController {


    private Logger logger = Logger.getLogger(DataStatisticsController.class);

    @RequestMapping("/export_sql")
    public String cpu_memory(Model model){

        return "dataStatistics/exportSQLResultList";
    }

    @RequestMapping("/exportSQLResultList")
    @ResponseBody
    public Object login(String querysql, String execsql, String dmptable, String dmpfilename, String op, HttpServletRequest request, HttpServletResponse response){
        JSONObject result = new JSONObject();
        boolean null_param = false;
        if ( StringUtils.isBlank(querysql) && StringUtils.isBlank(execsql) && StringUtils.isBlank(dmptable)) {
            null_param = true;
        }
        Connection connection = null;
        try {
            connection = getConnection();
            if (null_param && StringUtils.isBlank(op)) {
                result.put("msg","无效操作！");
                return result;
            }

            String sql = "";
            if ("query".equals(op)) {
                sql = querysql;
                if (null_param && StringUtils.isBlank(sql)) {
                    return "Operation failed ! Illegal parameter. Please try again !";
                }
                long start = System.currentTimeMillis();
                File file = this.query(connection, sql);
                long end = System.currentTimeMillis();
                DownloadUtil.download(file,request,response);
                file.deleteOnExit();
                return null;
            } else if ("exec".equals(op)) {
                sql = execsql;
                if (sql == null || "".equals(sql)) {
                    result.put("msg","SQL语句无效！");
                    return result;
                }
                int val = exeSql(connection, sql, null, null);
                result.put("value", val);
                result.put("msg", "执行成功，"+val+"行记录受影响");
                return result;
            } else if ("dmp".equals(op)) {
                sql = dmptable;
                String filename = dmpfilename;
                if (sql == null || "".equals(sql) || filename == null
                        || "".equals(filename)) {
                    return "Operation failed ! Illegal parameter. Please try again !";
                }
                boolean b = this.exp(sql, filename);
                // 导出
                if (b) {
                    File file = new File(filename);
                    DownloadUtil.download(file,request,response);
                    file.deleteOnExit();
                    return null;
                }
            }

        }catch (Exception e) {
            logger.error(e);
            result.put("msg", e.getMessage());
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try{
                    connection.close();
                }catch (Exception e2){
                    logger.error(e2);
                }

            }
        }
        return result;
    }

    /**
     * 获取数据库连接
     * @return
     */
    private Connection getConnection() throws Exception{
        DataSource dataSource = SpringContextHolder.getBean("primaryDatasource");
        Connection connection = dataSource.getConnection();
        return connection;
    }

    /**
     * 执行查询并导出文本
     * @param con 数据库连接
     * @param sql sql语句
     * @return 导出文件
     * @throws Exception Exception
     */
    private File query(Connection con, String sql) throws Exception {
        File file = null;
        Statement stmt = null;
        ResultSet rs = null;
        sql = "select * from ( " + sql + ") where rownum <= 10000";
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("select count(*) from (" + sql + ")");
            int rows = 0;
            if (rs.next()) {
                rows = rs.getInt(1);
            }
            if (rows > 10000) {
                file = this.createFile(".csv");
                FileOutputStream fi = new FileOutputStream(file, true);
                OutputStreamWriter osw = new OutputStreamWriter(fi, "GB2312");
                BufferedWriter bw = new BufferedWriter(osw);
                StringBuffer sb = new StringBuffer();
                String comma = ",";
                String lineFeed = "\n";

                int rowId = 0;
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    if (rowId == 0) {
                        for (int ii = 1; ii <= rs.getMetaData()
                                .getColumnCount(); ii++) {
                            String colName = rs.getMetaData().getColumnName(ii)
                                    .toLowerCase();
                            if (ii != rs.getMetaData().getColumnCount()) {
                                sb.append(colName + comma);
                            } else {
                                sb.append(colName + lineFeed);
                            }
                        }
                        rowId++;
                        bw.write(sb.toString());
                        bw.flush();
                        sb.delete(0, sb.length() + 1);
                    }
                    for (int ii = 1; ii <= rs.getMetaData().getColumnCount(); ii++) {
                        String value = "";
                        int colType = rs.getMetaData().getColumnType(ii);

                        if (colType == java.sql.Types.TIME
                                || colType == java.sql.Types.DATE
                                || colType == java.sql.Types.TIMESTAMP) {
                            java.sql.Timestamp dd = rs.getTimestamp(ii);
                            long values = 0;
                            if (dd != null) {
                                values = dd.getTime();
                                java.util.Date d = new java.util.Date();
                                d.setTime(values);
                                value = dateToString(d);
                            }
                        } else {
                            value = rs.getString(ii);
                        }
                        if (ii != rs.getMetaData().getColumnCount()) {
                            // 不是最后一次添加“，”
                            sb.append(value + comma);
                        } else {
                            // 最后一次
                            sb.append(value + lineFeed);
                        }
                    }
                    rowId++;
                    bw.write(sb.toString());
                    bw.flush();
                    sb.delete(0, sb.length() + 1);
                }
                bw.close();
                osw.close();
                fi.close();
            } else {
                file = this.createFile(".xls");
                // 生成可写的Workbook
                WritableWorkbook book = Workbook.createWorkbook(file);
                WritableSheet sheet = book.createSheet("SQL查询", 0);

                WritableFont BoldFont = new WritableFont(WritableFont.ARIAL,
                        12, WritableFont.BOLD);
                WritableCellFormat wcf_title = new WritableCellFormat(BoldFont);
                wcf_title.setBorder(jxl.format.Border.NONE,
                        jxl.format.BorderLineStyle.THIN); // 线条
                wcf_title
                        .setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE); // 垂直对齐
                wcf_title.setAlignment(jxl.format.Alignment.CENTRE); // 水平对齐
                wcf_title.setWrap(false); // 是否换行

                WritableCellFormat defaultFormat = new WritableCellFormat();
                defaultFormat.setAlignment(jxl.format.Alignment.CENTRE);
                defaultFormat
                        .setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
                defaultFormat.setWrap(true);
                defaultFormat.setBorder(jxl.format.Border.ALL,
                        jxl.format.BorderLineStyle.THIN);

                // 填写数据
                int rowId = 0;
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    if (rowId == 0) {
                        for (int ii = 1; ii <= rs.getMetaData()
                                .getColumnCount(); ii++) {
                            String colName = rs.getMetaData().getColumnName(ii)
                                    .toLowerCase();
                            sheet.addCell(new Label(ii - 1, rowId, colName,
                                    wcf_title));
                        }
                        rowId++;
                    }
                    for (int ii = 1; ii <= rs.getMetaData().getColumnCount(); ii++) {
                        String value = "";
                        int colType = rs.getMetaData().getColumnType(ii);

                        if (colType == java.sql.Types.TIME
                                || colType == java.sql.Types.DATE
                                || colType == java.sql.Types.TIMESTAMP) {
                            java.sql.Timestamp dd = rs.getTimestamp(ii);
                            long values = 0;
                            if (dd != null) {
                                values = dd.getTime();
                                java.util.Date d = new java.util.Date();
                                d.setTime(values);
                                value = dateToString(d);
                            }
                        } else {
                            value = rs.getString(ii);
                        }
                        sheet.addCell(new Label(ii - 1, rowId, value,
                                defaultFormat));
                    }
                    rowId++;
                }
                book.write();
                book.close();
            }
        } catch (Exception e) {
            logger.error("", e);
            throw e;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                    rs = null;
                }
                if (stmt != null) {
                    stmt.close();
                    stmt = null;
                }
            } catch (SQLException e) {
            }
        }
        return file;
    }

    /**
     * 创建导出文件
     * @param filetype 文件类型
     * @return 导出文件
     * @throws IOException IO异常
     */
    private File createFile(String filetype) throws IOException {
        File file = new File("SQL查询" + filetype);
        if (file.exists()) {
            String tmpPath = file.getPath();
            int xls = tmpPath.indexOf(filetype);
            int n = 1;
            File f = null;
            do {
                // 查找不存在的文件，防止多个用户同时建立文件，或者同个用户同时建立多个文件
                f = new File(tmpPath.substring(0, xls) + String.valueOf(n)
                        + filetype);
                n++;
            } while (f.exists() && f.length() > 0);
            file = f;
        }
        file.createNewFile();
        return file;
    }

    /**
     * 执行EXP命令
     * @param sql 命令语句
     * @param filename 导出文件名
     * @return 执行结果
     */
    private boolean exp(String sql, String filename) {
        boolean bool = false;
        try {
            logger.info("exp命令：" + sql + " file=" + filename);
            Process p = Runtime.getRuntime().exec(sql + " file=" + filename);
            InputStreamReader isr = new InputStreamReader(p.getErrorStream());
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            while ((line = br.readLine()) != null) {
                if (line.indexOf("错误") != -1) {
                    break;
                }
            }
            p.destroy();
            p.waitFor();
            bool = true;
        } catch (Exception e) {
            logger.error("导出文件失败", e);
        }
        return bool;
    }

    /**
     * 日期文本转换
     * @param date 日期
     * @return 日期字符串
     */
    public String dateToString(Date date) {
        if (date == null) {
            return "";
        }
        return DateUtil.yyyy_MM_dd_HH_mm_ss().format(date);
    }

    /**
     * * 执行一条带条件的SQL语句
     *
     * @param conn
     *            Connection
     * @param sql
     *            String
     * @param list
     *            ArrayList
     * @param typeList
     *            ArrayList
     * @throws SQLException 数据库异常
     * @return int 执行结果
     */
    private int exeSql(Connection conn, String sql, ArrayList list,
                              ArrayList typeList) throws SQLException {
        if (sql == null) {
            return 0;
        }
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            if (list != null && list.size() > 0) {
                boolean flag = false;
                if (typeList != null && typeList.size() == list.size()) {
                    flag = true;
                }
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j) != null || !flag) {
                        pstmt.setObject(j + 1, (Object) list.get(j));
                    } else {
                        pstmt.setNull(j + 1,
                                ((Integer) typeList.get(j)).intValue());
                    }
                }
            }

            return pstmt.executeUpdate();

        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                logger.error("", ex);
            }
            logger.error("", e);
            throw e;
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                logger.error("", e);
            }
        }
    }

}
