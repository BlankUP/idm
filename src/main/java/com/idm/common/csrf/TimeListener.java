package com.idm.common.csrf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class TimeListener implements ServletContextListener{

	/**
	 * 校验跨域的问题
	 */
	public static Map<String,Long> checkMap = Collections.synchronizedMap(new HashMap());
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// 服务启动、初始化时执行
				int minutes = 5; //执行 间隔
				int second = 60;
				int timeDistance = 1000;
				// 使用定时类，每隔一段时间执行
				java.util.Timer timer = new java.util.Timer();
				timer.schedule(new MyRandomMap(), new Date(), minutes * second * timeDistance);
	}
	
	private class MyRandomMap extends java.util.TimerTask {// 实现了TimerTask的类
		public void run() {
			clearRandomMap();// 每隔一段时间执行
		}
	}

	public void clearRandomMap(){
		
		  // 清除map过期的key
		  List<String> list = new ArrayList<String>();
		  Long now = System.currentTimeMillis();
		  Iterator iter = checkMap.keySet().iterator(); 
		  while (iter.hasNext()){ 
		  String key = iter.next().toString(); 
		  Long val = checkMap.get(key);
		// 设计很巧妙：使用时间（毫秒）作为value，好处在于可以与当前时间（毫秒）比较大小，从达到过时 30分钟
			  if(now-val>20* 60 * 1000){
			  	list.add(key); 
			  }
		  } 
		  for (int i = 0; i < list.size(); i++){
		  	checkMap.remove(list.get(i));
		  }
		
	}

}
