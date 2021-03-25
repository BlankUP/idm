/**   
 * @Description:TODO   
 * @author: sjf
 * @date:   2019年3月5日 下午2:44:19   
 * @Copyright: 2019 www.sunline.cn All rights reserved. 
 * 
 */
package com.idm.app.ruleengine.exceptioninfo.model;

import java.io.Serializable;

/**   
 * @Description:智能决策数据接口调用信息
 * @author: sjf
 * @date:   2019年3月5日
 * @Copyright: 2019 www.sunline.cn All rights reserved. 
 * 
 */
public class DataInterfaceInvokInfo implements Serializable {

	/**   
	 * @Fields serialVersionUID : TODO
	 */ 
	private static final long serialVersionUID = 1L;
	
	/**   
	 * @Fields businessNo : 业务流水号（决策服务系统流水号）
	 */ 
	private String businessNo;
	
	/**   
	 * @Fields interfaceCode : 数据源接口代码
	 */ 
	private String interfaceCode;
	
	/**   
	 * @Fields interfaceName : 数据源接口名称
	 */ 
	private String interfaceName;
	
	/**   
	 * @Fields queryPkg : 请求报文
	 */ 
	private String  requestMsg;
	
	/**   
	 * @Fields responseMsg : 应答报文
	 */ 
	private String responseMsg;
	
	/**   
	 * @Fields isSuccess : 是否调用成功
	 */ 
	private String isSuccess;
	
	/**   
	 * @Fields errorCode :错误代码
	 */ 
	private String errorCode;
	
	/**   
	 * @Fields errorMsg : 错误消息
	 */ 
	private String errorMsg;

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

	public String getRequestMsg() {
		return requestMsg;
	}

	public void setRequestMsg(String requestMsg) {
		this.requestMsg = requestMsg;
	}

	public String getResponseMsg() {
		return responseMsg;
	}

	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}

	public String getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(String isSuccess) {
		this.isSuccess = isSuccess;
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

	
}
