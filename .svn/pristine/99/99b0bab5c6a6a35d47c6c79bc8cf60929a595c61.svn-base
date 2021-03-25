package com.idm.common.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;


/**
 * <p>Title:GetConnection</p>
 * @Description：与数据库建立连接
 * @author：jiamh
 * @createTime：2019年3月4日
 * @version 1.0
 */
@Component
public class GetConnection {

	static Logger logger = Logger.getLogger(GetConnection.class);
	
	
	/**
	 * @Description：与数据库建立连接
	 * @return
	 * @throws IOException 
	 */
	public Connection getConnection(String jdbc_driver,String jdbc_url,String jdbc_username,String jdbc_password) throws IOException{
		Connection conn = null;
		try {
			//加载驱动
			Class.forName(jdbc_driver);
			//连接数据库
			conn = DriverManager.getConnection(jdbc_url, jdbc_username,jdbc_password);
		} catch (ClassNotFoundException e) {
			logger.error("类GetConnection的方法getConnection加载驱动异常：",e);
		} catch (SQLException e) {
			logger.error("类GetConnection的方法getConnection连接数据库异常：",e);
		}
		return conn;
	}
	
	
}
