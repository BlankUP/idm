package com.idm.app.system.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author lifadeng
 * @Description: 建设中、404、403等提示页面
 * @Create: 2018/11/7 10:10
 * @Version: 1.0
 */
@RequestMapping("/error")
@Controller
public class ErrorController {

    @RequestMapping("/404")
    public String error404(){

        return "error/404";
    }

    @RequestMapping("/403")
    public String error403(){

        return "error/403";
    }

    @RequestMapping("/500")
    public String error500(){

        return "error/500";
    }

    @RequestMapping("/building")
    public Object building(){

        return "error/building";
    }

}
