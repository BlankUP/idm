package com.idm.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * <p> Title: DateUtil </p>
 * <p> Description: 时间工具类</p>
 * <p> Company:SunLine </p>
 * @author ex_kjkfb_chensongw
 * @version 2.0 - 20150802
 * @复核人 王仲武
 * @复核时间 2015年9月7日
 */
public class DateUtil {
	public static SimpleDateFormat yyyyMMddHHmmssSSS(){
		return getFormat("yyyyMMddHHmmssSSS");
	}
	
	public static SimpleDateFormat yyyyMMddHHmmss(){
		return getFormat("yyyyMMddHHmmss");
	}
	
	public static SimpleDateFormat HHmmssSSS(){
		return getFormat("HHmmssSSS");
	}
	
	public static SimpleDateFormat yyyyDDD(){
		return getFormat("yyyyDDD");
	}
	
	public static SimpleDateFormat yyyyMMdd(){
		return getFormat("yyyyMMdd");
	}
	
	public static SimpleDateFormat yyyy_MM_dd(){
		return getFormat("yyyy-MM-dd");
	}
	
	public static SimpleDateFormat yyyyCMMCdd(){
		return getFormat("yyyy年MM月dd");
	}
	
	public static SimpleDateFormat yyyyDDDHHmmss(){
		return getFormat("yyyyDDDHHmmss");
	}
	
	public static SimpleDateFormat yyyy_MM_dd_HH_mm_ss(){
		return getFormat("yyyy-MM-dd HH:mm:ss");
	}
	
	public static SimpleDateFormat getFormat(String pattern){
		return new SimpleDateFormat(pattern);
	}
	
	public static String getNowBefore(int days){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, -days);
		return yyyyMMddHHmmss().format(cal.getTime());
	}
	public static String formate(String data, SimpleDateFormat src, SimpleDateFormat dest) throws ParseException{
		return dest.format(src.parse(data));
	}

	/**当前时间yyyyMMddHHmmss**/
	public static String getNowDatetime()
	{
		Calendar cal = Calendar.getInstance();
		return yyyyMMddHHmmss().format(cal.getTime());
	}

}
