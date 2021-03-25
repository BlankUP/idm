package com.idm.app.system.index.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idm.app.idpconfig.eventconfig.model.EventConfig;

import net.sf.json.JSONObject;

/**
 * 首页
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(){

        return "index";
    }
    @RequestMapping("/home")
    public String home(){

        return "home";
    }
    @ResponseBody
    @RequestMapping("/test")
    public Object test(){

        return "success";
    }
    
    @RequestMapping("/system")
    @ResponseBody
    public Object systemChange(HttpServletRequest request)
    {
     	String system = request.getParameter("system");
    	request.getSession().setAttribute("system", system); 
		return JSONObject.fromObject("{\"success\":false}");
    }
}
