package com.idm.app.system.login.enums;
/**
 * 账户枚举
 *<P>Title:</P>
 *@Description:
 *@author panling
 *@date 2021年3月16日
 *@version
 */
public enum FreezeEnum {
	 	DELETE("1","冻结"),
	    UNDELETE("0","正常");
	    private String code;
	    private  String message;
	    FreezeEnum(String code, String message){
	        this.code=code;
	        this.message=message;
	    }
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
	    
}
