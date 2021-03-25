package com.idm.common.exception;

import org.apache.log4j.Logger;

/**
 * @class 异常信息构造类
 * @author liushudong
 * @date 2019年2月26日
 *
 */
public class BusinessException extends Exception{

	private static final long serialVersionUID=1L;
	static Logger logger =Logger.getLogger(BusinessException.class);
	
	private String errorCode="";
	private String errorMsg="";
	private String errorType="N";

	public BusinessException(Throwable e){
		super(e);
	}
	
	/**
	 * 异常信息类构造方法
	 * 
	 * @param errorCode 错误码
	 * @author liushudong
	 */
	public BusinessException(String errorCode) throws BusinessException{
		this.errorCode=errorCode;
		String errorMsg = String.valueOf(ErrorCodeTemplate.getErrorCodeMap().get(errorCode));
		if(errorMsg!=null && !"".equals(errorMsg)) {
			this.errorMsg = errorMsg;
		}else {
			this.errorCode = "未知的错误码消息";
			logger.warn("BusinessException warning: 未找到对应的错误码信息");
		}
	}
	
	/**
	 * 异常信息类构造方法
	 * 
	 * @param errorCode 错误码
	 * @param errorType 错误类型
	 * @author liushudong
	 */
	public BusinessException(String errorCode,String errorType) throws BusinessException{
		this.errorCode=errorCode;
		this.errorType=errorType;
		String errorMsg = String.valueOf(ErrorCodeTemplate.getErrorCodeMap().get(errorCode));
		if(errorMsg!=null && !"".equals(errorMsg)) {
			this.errorMsg = errorMsg;
		}else {
			this.errorCode = "未知的错误码消息";
			logger.warn("BusinessException warning: 未找到对应的错误码信息");
		}
	}
	
	/**
	 * 异常信息类构造方法
	 * 
	 * @param errorCode 错误码
	 * @param errorType 错误类型
	 * @param e super异常信息
	 * @author liushudong
	 */
	public BusinessException(String errorCode,String errorType,Throwable e) throws BusinessException{
		super(errorCode,e);
		this.errorCode=errorCode;
		this.errorType=errorType;
		String errorMsg = String.valueOf(ErrorCodeTemplate.getErrorCodeMap().get(errorCode));
		if(errorMsg!=null && !"".equals(errorMsg)) {
			this.errorMsg = errorMsg;
		}else {
			this.errorCode = "未知的错误码消息";
			logger.warn("BusinessException warning: 未找到对应的错误码信息");
		}
	}
	
	/**
	 * 异常信息类构造方法
	 * 
	 * @param errorCode 错误码
	 * @param errorMsg 自定义错误信息
	 * @param errorType 错误类型
	 * @param e super异常信息
	 * @author liushudong
	 */
	public BusinessException(String errorCode, String errorMsg, String errorType) throws BusinessException{
		this.errorCode=errorCode;
		this.errorType=errorType;
		this.errorMsg = errorMsg;
	}
	
	/**
	 * 异常信息类构造方法
	 * 
	 * @param errorCode 错误码
	 * @param errorMsg 自定义错误信息
	 * @param errorType 错误类型
	 * @param e super异常信息
	 * @author liushudong
	 */
	public BusinessException(String errorCode, String errorMsg, String errorType, Throwable e) throws BusinessException{
		super(errorCode,e);
		this.errorCode=errorCode;
		this.errorType=errorType;
		this.errorMsg = errorMsg;
	}
	
	public String getErrorCode(){
		return errorCode;
	}
	
	
	public String getErrorMsg(){
		return errorMsg;
	}
	
	public String getErrorType(){
		return errorType;
	}
	
	/**
	 * 获取异常信息
	 * 
	 * @author liushudong
	 */
	public String getMessage(){
		return "IDM Message [errorCode: " + errorCode + "][errorMsg: " + errorMsg + "]";
	}
	
	public String getFullErrorCode(){
		return null;
	}
}