package com.idm.common.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

/**
 * <p>Title:SaveJsonDataByJDBC</p>
 * @Description：通过jdbc保存JSON格式数据
 * @author：jiamh
 * @createTime：2019年3月4日
 * @version 1.0
 */
public class SaveJsonDataByJDBC {

	static Logger logger = Logger.getLogger(SaveJsonDataByJDBC.class);
	
	
	
	/**
	 * @Description：通过jdbc执行sql语句
	 * @param className
	 * @param object
	 * @param sql
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public int saveJsonDataByJDBC(String sql,String jdbc_driver,String jdbc_url,String jdbc_username,String jdbc_password) throws SQLException, IOException{
		PreparedStatement pstmt = null;
		int i = 0;
		GetConnection getConnection = new GetConnection();
		Connection conn = getConnection.getConnection(jdbc_driver,jdbc_url,jdbc_username,jdbc_password);        					//获取连接
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			logger.error("类SaveJsonDataByJDBC中方法saveJsonDataByJDBC保存数据时出现SQLException异常：", e);
			throw e;
		} finally { //释放数据库资源
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					logger.error("类SaveJsonDataByJDBC中方法saveJsonDataByJDBC保存数据时出现SQLException异常：", e);
					throw e;
				}
			}
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					logger.error("类SaveJsonDataByJDBC中方法saveJsonDataByJDBC保存数据时出现SQLException异常：", e);
					throw e;
				}
		}
		return i;
	}
	
}
