package com.idm.app.system.serverconfig.controller;

import com.idm.app.idpconfig.proModelParaConfig.model.ParaBaseInfo;
import com.idm.app.system.login.model.IDMUser;
import com.idm.app.system.loginfo.model.SysLog;
import com.idm.app.system.serverconfig.model.ServerInfo;
import com.idm.app.system.serverconfig.service.ServerConfigService;
import com.idm.common.http.HttpClient;
import com.idm.common.util.ResByPageVo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 *<p>Title: ServerConfigController</p>  
 * @Description: 服务器信息
 * @author 黄百超
 * @date 2019年2月27日
 * @version  1.0
 *
 */
@Controller
public class ServerConfigController {
	
	

    private Logger logger=Logger.getLogger(ServerConfigController.class);
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private ServerConfigService serverConfigService;

    @Value("${DECISIONTESTJSON_PROJECT_URL}")
    private String DECISIONTESTJSON_PROJECT_URL;
    
    @Value("${CACHESYNCHRONIZE_REQUEST_URL}")
    private String CACHESYNCHRONIZE_REQUEST_URL;
    
    @RequestMapping("/server_info")
    public String serverInfo()
    {
        return "serverInfo";
    }
    /**
     * 
     * @Description: 查询基础方法
     * @param request
     * @return
     */
    @RequestMapping("/server_info_query")
    @ResponseBody
    @SysLog(operate="查询",module="服务器配置")
    public Object serverInfoQuery(HttpServletRequest request)
    {
        logger.info("******服务器信息查询开始******");      
        String ip = request.getParameter("serverIP");
        String name = request.getParameter("name");
    	int page =Integer.parseInt(request.getParameter("page"));
		int size = Integer.parseInt(request.getParameter("rows"));
		
	    ResByPageVo resByPageVo = null;
	      
		try {
			request.setCharacterEncoding("utf-8");
			if (name != null && name != "") {
				name = java.net.URLDecoder.decode(name, "UTF-8");
			}
	        logger.info("serverIP:["+ip+"]");
	        logger.info("name:["+name+"]");
	
	        ServerInfo serverInfo = new ServerInfo();
	        serverInfo.setIp(ip);
	        serverInfo.setName(name);
	        serverInfo.setPage(page);
	        serverInfo.setSize(size);
	        
	        int count = serverConfigService.selectCountByAll(serverInfo);
			//查询参数字段表信息
			List<ServerInfo> list = serverConfigService.queryServerInfo(serverInfo);
			resByPageVo = new ResByPageVo(size, page, count);
			if (list != null && list.size() > 0) {
				logger.info("查询parameterfields参数字段信息成功，总记录[" + count + "]");
				resByPageVo.setRows(list);
			} else if (list != null && list.size() == 0) {
				logger.info(">>parameterfields参数字段无记录");
				resByPageVo = new ResByPageVo(size, page, 0);
			} else {
				logger.info(">>parameterfields参数字段数据库错误");
				resByPageVo = new ResByPageVo(size, page, 0);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("类ServerConfigController中方法serverInfoQuery出现Exception异常:" + e.getMessage());
		}
		logger.info("******服务器信息查询结束******");
		
        return JSONObject.fromObject(resByPageVo);
    }
    
    /**
     * 
     * @Description: 增删改
     * @param request
     * @return
     */
    @RequestMapping("server_info_update")
    @ResponseBody
    @SysLog(operate="增删改",module="服务器配置")
    public String addOrUpdateServer(HttpServletRequest request)
    {
    	
    	logger.info("******服务器信息添加/修改/删除开始******");
        String option= request.getParameter("option");
        String serverId = request.getParameter("serverId");
        String name= request.getParameter("name");
        String ip=request.getParameter("ip");
        String port = request.getParameter("port");
        String type=request.getParameter("type");
        String f5Url = request.getParameter("f5Url");
        String serverUrl = request.getParameter("serverUrl");
        String remark = request.getParameter("remark");
        String status = request.getParameter("status");

        logger.info("option:["+option+"]");
        logger.info("serverId:["+serverId+"]");
        logger.info("name:["+name+"]");
        logger.info("ip:["+ip+"]");
        logger.info("port:["+port+"]");
        logger.info("type:["+type+"]");
        logger.info("f5Url:["+f5Url+"]");
        logger.info("serverUrl:["+serverUrl+"]");
        logger.info("remark:["+remark+"]");
        logger.info("status:["+status+"]");

        IDMUser user = (IDMUser)request.getSession().getAttribute("user");
        ServerInfo serverInfo = new ServerInfo();
        serverInfo.setServerId(serverId);
        serverInfo.setName(name);
        serverInfo.setIp(ip);
        serverInfo.setPort(port);
        serverInfo.setType(type);
        serverInfo.setF5Url(f5Url);
        serverInfo.setServerUrl(serverUrl);
        serverInfo.setRemark(remark);
        serverInfo.setStatus(status);
        serverInfo.setCreateTime(sdf.format(new Date()));
        serverInfo.setCreateUser(user.getUserId());
        serverInfo.setUpdateTime(sdf.format(new Date()));
        serverInfo.setUpdateUser(user.getUserId());
        if("add".equals(option))
        {
        	logger.info("******服务器信息添加******");
            try {
                serverConfigService.addServer(serverInfo);
            } catch (Exception e) {
                logger.error(e.getMessage());
                return "添加数据失败";
            }
        }
        if("update".equals(option))
        {
        	logger.info("******服务器信息修改******");
            try {
                serverConfigService.updateServer(serverInfo);
            } catch (Exception e) {
                logger.error(e.getMessage());
                return "更新数据失败";
            }
        }

        if("delete".equals(option))
        {
        	logger.info("******服务器信息删除******");
            String serverIds = request.getParameter("serverIds");
            logger.info("serverIds:["+serverIds+"]");
            String[] serverIdArray = serverIds.split("\\$\\$");
            List<String> serverIdList = new ArrayList<String>();
            for(String str:serverIdArray)
            {
                serverIdList.add(str);
            }
            try {
                serverConfigService.deleteServer(serverIdList);
            } catch (Exception e) {
                logger.error(e.getMessage());
                return "删除失败";
            }
        }
        logger.info("******服务器信息添加/修改/删除结束******");
        return null;
    }
    
    /**
     * 
     * @Description: 缓存同步
     * @param request
     * @return
     */
    @RequestMapping("/cache_synchronize")
    @ResponseBody
    @SysLog(operate="缓存同步",module="服务器配置")
    public Object decisionTestJson(HttpServletRequest request)
    {
    	logger.info("******同步缓存开始******");
    	 Boolean result = true;
    	 String msg = "";
    	try {
    	 	String type=request.getParameter("type");
			JSONObject json = new JSONObject();
	        ServerInfo serverInfo = new ServerInfo();
	        serverInfo.setType(type);
	        serverInfo.setStatus("0");
	        List<ServerInfo> serverList =  serverConfigService.queryServerConfig(serverInfo);
	        String url="";
	       
	        for(ServerInfo sl:serverList ) {
	        	url = "http://"+sl.getIp()+":"+sl.getPort()+"/"+sl.getServerUrl()+"/"+CACHESYNCHRONIZE_REQUEST_URL;
	        	logger.info("****待执行的服务器****:"+url);
	    		String str = HttpClient.sendPost(url,json.toString() );
	    		logger.info("****返回结果****:"+str);
	    		if(!Boolean.valueOf(str)) {
	    			result= false;
	    			msg+=sl.getName()+"同步失败 \\n";
	    		}else {
	    			msg+=sl.getName()+"同步成功 \\n";
	    		}
	    		
	        }
    	}catch (Exception e) {			e.printStackTrace();
			result= false;
		}
		logger.info("******同步缓存结束******");
        return JSONObject.fromObject("{\"success\":"+result+",\"rel\":\""+msg+"\"}");
    }
    
    
    @RequestMapping("/select_servername")
    @ResponseBody
    public Object selectServerName(HttpServletRequest request)
    {
    	
    	String type=request.getParameter("type");
    	ServerInfo serverInfo = new ServerInfo();
    	serverInfo.setType(type);
    	List<ServerInfo> serverList =  serverConfigService.selectServerName(serverInfo);
    	JSONArray json = JSONArray.fromObject(serverList);
    	logger.info("******获取机构信息结束******");
    	return json;
    }

    @RequestMapping("/repeatServerName")
    @ResponseBody
    public Object repeatServerName(HttpServletRequest request)
    {
    	
    	String serverName=request.getParameter("serverName");
    	ServerInfo serverInfo = new ServerInfo();
    	serverInfo.setName(serverName);
    	long num =  serverConfigService.repeatServerName(serverInfo);
    	if(num>0) {
	    	return JSONObject.fromObject("{\"success\":true}");
	    }
		return JSONObject.fromObject("{\"success\":false}");
    }
}
