package com.idm.app.ruleengine.exceptioninfo.timetask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;


public class LyzListener implements ServletContextListener{
	private Logger logger = Logger.getLogger(LyzListener.class);
	@Override
	public void contextInitialized(ServletContextEvent sce) {
        new TimerManager();
        logger.error("批量重跑任务已启动");
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

}
