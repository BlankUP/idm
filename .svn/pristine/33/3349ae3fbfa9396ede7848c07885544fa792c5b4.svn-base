package com.idm.common.exception;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.idm.app.system.exception.model.ErrorInfo;
import com.idm.app.system.exception.service.ErrorInfoService;

/**
 * @class 异常信息工具类
 * @author liushudong
 * @date 2019年2月26日
 *
 */
@Component
public class BusinessExceptionUtil {
	static Logger logger =Logger.getLogger(BusinessException.class);
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Autowired
	private ErrorInfoService errorInfoService;
	private static BusinessExceptionUtil businessExceptionUtil; 
	
	@PostConstruct  
	public void init() {       
		businessExceptionUtil = this; 
		businessExceptionUtil.errorInfoService = this.errorInfoService; 
	} 

	/**
	 * 获取数据库错误信息
	 * 
	 * @return list
	 */
	public static List<Map<String, Object>> getErrorInfo() {
		return null;
	}
	
	/**
	 * 错误信息持久化
	 * 
	 * @return
	 */
	public static void saveErrorInfo(BusinessException e) {
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorCode(e.getErrorCode());
		errorInfo.setErrorMsg(e.getErrorMsg());
		errorInfo.setErrorType(e.getErrorType());
		errorInfo.setCreateTime(sdf.format(new Date()));
		errorInfo.setOperator("");
		businessExceptionUtil.errorInfoService.saveErrorInfo(errorInfo);
	}
	
}
