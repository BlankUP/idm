package com.idm.common.exception;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ErrorCodeTemplate {
	private final static Logger logger = Logger.getLogger(ErrorCodeTemplate.class);
	
	private static Map<String, Object> errorCode = new HashMap<String, Object>();
	
	public static void setErrorCodeMap(Map<String,Object> errorCodeMap) {
		if(errorCodeMap != null) {
			ErrorCodeTemplate.errorCode = errorCodeMap;
		}
	}
	
	public static Map<String, Object> getErrorCodeMap() {
		return ErrorCodeTemplate.errorCode;
	}
	
	/**
	 * 从properties文件加载错误码信息
	 * 
	 * @return
	 */
	public static void initErrorCodeTemplate() {
		Properties properties = new Properties();
		InputStream is = ErrorCodeTemplate.class.getResourceAsStream("/errorCode.properties");
		try {
			properties.load(is);
			Map<String, Object> map = new HashMap<String, Object>((Map) properties);
			ErrorCodeTemplate.setErrorCodeMap(map);
		} catch (IOException e) {
			logger.error("ErrorCodeTemplate Error: 系统配置文件加载失败！");
		}
	}

}
