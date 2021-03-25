package com.idm.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

/**
 * 
 *@Description:日期工具
 *@author sjf
 *@date 2019年3月11日
 *@version 1.0
 */
public class DateTools {
	static Logger logger = Logger.getLogger(DateTools.class);
	/**
	 * 
	 *@Description:获取系统日期时间
	 *@return 当前系统日期时间
	 *@author sjf
	 */
	public static String getSysDate(){
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return df.format(new Date());
	}
	/**
	 * 
	 *@Description:计算两个时间的毫秒数
	 *@param start
	 *@param end
	 *@return 两个时间的毫秒数
	 *@author sjf
	 */
	public static String getMS(String start,String end){
		long time=0;
		try {
			Date date1 = new SimpleDateFormat("yyyyMMddHHmmssSSS").parse(start);
			Date date2 = new SimpleDateFormat("yyyyMMddHHmmssSSS").parse(end);
			time=date2.getTime()-date1.getTime();
		} catch (ParseException e) {
			logger.error("日期格式转换错误");
		}
		return String.valueOf(time);
	}
	
	/**    
	* @Description:  获取系统日期
	* @return 当前系统日期
	* @author sjf
	*/ 
	public static String getDate() {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		return df.format(new Date());
	}
	
	
	/**    
	* @Description:  获取系统时间
	* @return 当前系统时间
	* @author sjf
	*/ 

	public static String getTime() {
		SimpleDateFormat df = new SimpleDateFormat("HHmmssSSS");
	return df.format(new Date());
	}
	/**
	 * 
	 *@Description：获取系统时间yyyy-MM-dd HH:mm:ss.SSS
	 *@return
	 */
	public static String getSysDateTime(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		return df.format(new Date());
	}
	public static void main(String[] args) {
		System.out.println(getTime());
	}
}