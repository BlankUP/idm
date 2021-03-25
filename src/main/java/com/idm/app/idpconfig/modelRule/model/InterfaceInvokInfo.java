package com.idm.app.idpconfig.modelRule.model;
/**
 *接口实体
 * @author cl_panling
 *
 */
public class InterfaceInvokInfo {

private static final long serialVersionUID = 1L;
	
	private String invokId;
	private String  businessNo;			//业务流水号
	private String interfaceCode;		//接口编码
	private String interfaceName;		//接口名称
	private String isSuccess; 			//是否成功
	private String startTime; 			//开始时间
	private String endTime; 			//结束时间
	private String elapsedTime; 		//接口耗时
	private String errorCode;  			//错误码
	private String errorMsg; 			//错误信息
	private String requestContext ;  	//请求报文
	private String responseContext ; 	//响应报文
	public String getInvokId() {
		return invokId;
	}
	public void setInvokId(String invokId) {
		this.invokId = invokId;
	}
	public String getBusinessNo() {
		return businessNo;
	}
	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}
	public String getInterfaceCode() {
		return interfaceCode;
	}
	public void setInterfaceCode(String interfaceCode) {
		this.interfaceCode = interfaceCode;
	}
	public String getInterfaceName() {
		return interfaceName;
	}
	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}
	public String getIsSuccess() {
		return isSuccess;
	}
	public void setIsSuccess(String isSuccess) {
		this.isSuccess = isSuccess;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getElapsedTime() {
		return elapsedTime;
	}
	public void setElapsedTime(String elapsedTime) {
		this.elapsedTime = elapsedTime;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public String getRequestContext() {
		return requestContext;
	}
	public void setRequestContext(String requestContext) {
		this.requestContext = requestContext;
	}
	public String getResponseContext() {
		return responseContext;
	}
	public void setResponseContext(String responseContext) {
		this.responseContext = responseContext;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "InterfaceInvokInfo [invokId=" + invokId + ", businessNo=" + businessNo + ", interfaceCode="
				+ interfaceCode + ", interfaceName=" + interfaceName + ", isSuccess=" + isSuccess + ", startTime="
				+ startTime + ", endTime=" + endTime + ", elapsedTime=" + elapsedTime + ", errorCode=" + errorCode
				+ ", errorMsg=" + errorMsg + ", requestContext=" + requestContext + ", responseContext="
				+ responseContext + "]";
	}
	
}
