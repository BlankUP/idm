package com.idm.app.idpconfig.bom.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;


/**  
* <p>Title: SeriesNumberHelper</p>  
* @Description: 生成32位业务流水号
* @author wangke  
* @date 2019年2月26日
* @version  1.0
*/ 
public class SeriesNumberHelper {

	   private static SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		public static final AtomicInteger at = new AtomicInteger(0);
		private static Object lock=new Object();
		 private static long golbal=0;
		
	  /**    
	   * @Description:  生成17位日期数据
	   * @return
	   */ 
		public static String getDate() {
			  Date now = new Date();
			  String str = format.format(now);//17位
			  return str;
		 }
		
		 /**    
		* @Description:  随机生成10位数字
		* @return
		*/ 
		public static String getNumber() {
			 Random rand = new Random();
			 StringBuffer sb=new StringBuffer();
			 for (int i=1;i<=7;i++){
			     int randNum = rand.nextInt(9)+1;
			     String num=randNum+"";
			     sb=sb.append(num);
			 }
		  return String.valueOf(sb.toString());
		 
	 }
		/**
		 * 
		 *@Description:对接接口平台唯一标识
		 *@return
		 */
		public  synchronized static String getRequestId() {
			
			 String str = getDate(); //17位
			 String str1 =getNumber(); //7位
			 at.compareAndSet(99999, 0);
				String businessNo = String.format("%s%s%05d", str,str1,at.incrementAndGet());
				return "IDP"+businessNo;
				
	 }
	 
	 
	 public static void main(String[] args) {
			 for(int i=0;i<=1000;i++) {
//				 String businessNo= getBusinessNo();
				System.out.println(getRequestId());
//				System.out.println(businessNo.length());
			 }
//		 System.out.println(Long.valueOf(getIP()));
//		 System.out.println(getBusinessNo());

	}

}
