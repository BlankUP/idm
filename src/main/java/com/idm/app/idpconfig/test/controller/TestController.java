package com.idm.app.idpconfig.test.controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;


/**
 * 
 *<p>Title: EventConfigController</p>  
 * @Description: 
 * @author 黄百超
 * @date 2019年2月25日
 * @version  1.0
 *
 */
@Controller
public class TestController {
	
    private Logger logger = Logger.getLogger(TestController.class);
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Value("${TEST_URL}")
	private String TEST_URL;
    
    @RequestMapping("/decision_test")
    public Object decisionTest(HttpServletRequest request) {

    	return "test1";
    }
    
    @RequestMapping("/test_json")
    @ResponseBody
    public Object decisionTestJson(HttpServletRequest request)
    {
    	
    	String text = request.getParameter("text");
    	try {
			text = java.net.URLDecoder.decode(text,"UTF-8");
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		} 
    	System.out.println(text);
		JSONObject json = new JSONObject();
		json = JSONObject.parseObject(text);
		System.out.println(json);
		
		
//		String result = HttpClient.sendPost(TEST_URL,json.toJSONString() );
//		System.out.println("返回的数据:"+result);
		
        return null;
    }
   
}
