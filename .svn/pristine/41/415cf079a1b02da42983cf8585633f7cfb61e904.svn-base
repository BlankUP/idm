package com.idm.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;



public class UuidUtils {
	  private static SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMdd");
	
	  private final static String chars64 =
		      "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789.$";

		  /**
		   * Generates pseudo-random long from specific range. Generated number is
		   * great or equals to min parameter value and less then max parameter value.
		   *
		   * @param min    lower (inclusive) boundary
		   * @param max    higher (exclusive) boundary
		   *
		   * @return pseudo-random value
		   */

		  public static long randomLong(long min, long max) {
		    return min + (long) (Math.random() * (max - min));
		  }

		  /**
		   * Generates pseudo-random integer from specific range. Generated number is
		   * great or equals to min parameter value and less then max parameter value.
		   *
		   * @param min    lower (inclusive) boundary
		   * @param max    higher (exclusive) boundary
		   *
		   * @return pseudo-random value
		   */
		  public static int randomInt(int min, int max) {
		    return min + (int) (Math.random() * (max - min));
		  }
		  
		  public static String getDateUUid(){
			  SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			  return format.format(new Date());
		  }
		  
		  public static String getUUIDSeqNo(){
			  String systemCode = "DSNN";
			  StringBuffer sb = new StringBuffer(systemCode);
			  //系统编码7位
			  for(int i = 0 ; i < 7 - systemCode.length(); i++){
				  sb.append("0");
			  }
			  
			  //系统时间8位
			  Date now = new Date();
			  sb.append(format1.format(now));
			  //编码12位
			  String str = UUID.randomUUID().toString();
			  sb.append(str.substring(str.length()-12, str.length()));
			  return sb.toString();
		  }
		  
		  
		  /**    
		* @Description:  请求流水号
		* @return
		*/ 
		public synchronized static String getRequestNo() {
			 String systemCode = "IDPTEST";   //7位
			 StringBuffer sb = new StringBuffer(systemCode);
			 SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMddHHmmssSSS");   //17位
			 Date now = new Date();
			 sb.append(format1.format(now));  //
			 String str = UUID.randomUUID().toString();
			 sb.append(str.substring(0,8));
			 return sb.toString();
		  }
}
