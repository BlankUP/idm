package com.idm.app.system.threadMonitor.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSONObject;
import com.idm.app.system.loginfo.model.SysLog;
import com.idm.app.system.threadMonitor.model.ServerInfo;
import com.idm.app.system.threadMonitor.service.ServerService;
import com.idm.common.http.HttpClient;




/** 
* @author: BaiY
* @version 创建时间：2019年4月30日 下午2:17:59 
* 类说明 ：监控 跃线程数量、线程池任务数量
*/

@Controller
@Component

public class ThreadMonitorController {
	
	 @Value("${THREADMONITOR_PROJECT_URL}")
	 private String THREADMONITOR_PROJECT_URL;
	 @Value("${THREADMONITOR_REQUESTMAP_URL}")
	 private String THREADMONITOR_REQUESTMAP_URL;
	
	 private Logger logger=Logger.getLogger(ThreadMonitorController.class);
	 @Autowired
	 private ServerService serverService;
	
	  @SysLog(operate="服务器查询",module="线程监控")
		@RequestMapping("/threadMonitor")
	    public String getServer( Model model){
			
			
			List<ServerInfo> servers = serverService.queryServer();
	        model.addAttribute("servers",servers);
			return "threadMonitor/threadMonitor";
	    }
		
	
	
	 
	 @RequestMapping("/thread")
	 @ResponseBody
	 @SysLog(operate="线程查询",module="线程监控")
	 public Object threadInfoQuery(HttpServletRequest request) {
		 logger.info("******监控 跃线程数量、线程池任务数量信息查询开始******");
		 String id = request.getParameter("id");
		 
		 ServerInfo sl = serverService.queryServerById(id);
		 System.out.println(sl+"===========================");
		 String url="";
		 url = "http://"+sl.getIp()+":"+sl.getPort()+"/"+THREADMONITOR_PROJECT_URL+"/"+THREADMONITOR_REQUESTMAP_URL;
		 JSONObject json = new JSONObject();
		 String str = HttpClient.sendPost(url, json.toString());

		 JSONObject jsStr = JSONObject.parseObject(str);

		 List<Object> list=new ArrayList<Object>();

		 for (Object map : jsStr.entrySet()){  
			 list.add(((Map.Entry)map).getValue());
     
	     }   
		 
		 for (Object object : list) {
			System.out.println(object+"================");
		}

		 List<Object> QueueSize = new ArrayList<>();
		 List<Object> ActiveCount = new ArrayList<>();
		 QueueSize.add(list.get(0));
		 ActiveCount.add(list.get(1));
		 
		 Map<String,Object> map= new HashMap<String,Object>();
		 SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		 map.put("ActiveCount", ActiveCount);
		 map.put("QueueSize", QueueSize);
		 map.put("cputime",sdf.format(new Date()));
		
		 JSONObject jsonObject = new JSONObject(map);
		 
		return jsonObject;
		 
		 
		

	 }
	 
	

}
