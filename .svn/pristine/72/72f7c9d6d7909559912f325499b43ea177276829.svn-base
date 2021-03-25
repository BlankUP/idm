package com.idm.app.system.login.controller;

import com.alibaba.fastjson.JSONObject;
import com.idm.app.system.login.model.IDMUser;
import com.idm.app.system.login.service.LoginService;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 系统注销
 */
@Controller
public class LogoutController {

    private Logger logger = Logger.getLogger(LogoutController.class);

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return "login";
    }

}
