package com.idm.app.ruleengine.exceptioninfo.timetask;

import java.util.TimerTask;

import org.apache.log4j.Logger;

import com.idm.app.ruleengine.exceptioninfo.controller.IdpExceptionMngController;

public class NFDFlightDataTimerTask extends TimerTask{

	private static Logger log = Logger.getLogger(NFDFlightDataTimerTask.class);
	   @Override
	     public void run() {
	        try {
            System.out.println("功能方法写在这里了...");
            IdpExceptionMngController idpExceptionMngController=new IdpExceptionMngController();
            idpExceptionMngController.batchred();
	       } catch (Exception e) {
	            log.info("-------------解析信息发生异常--------------");
	        }
	    }
}
