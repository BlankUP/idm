package com.idm.config.resubmit.submit;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.idm.config.resubmit.repeat_form_validator.SameUrlData;


/**
 * @author BaiY
 *
 */
public class SameUrlDataInterceptor  extends HandlerInterceptorAdapter{

	
	
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            SameUrlData annotation = method.getAnnotation(SameUrlData.class);
            if (annotation != null) {
            	if(repeatDataValidator(request))//如果重复相同数据
            		return false;
            	else 
            		return true;
            }
            return true;
        } else {
            return super.preHandle(request, response, handler);
        }
    }
/**
 * 验证同一个url数据是否相同提交  ,相同返回true
 * @param httpServletRequest
 * @return
 * @throws JsonProcessingException 
 */
public boolean repeatDataValidator(HttpServletRequest httpServletRequest) throws JsonProcessingException
{   String params = new ObjectMapper().writeValueAsString(httpServletRequest.getParameterMap()); 
	//String params=JsonMapper.toJsonString(httpServletRequest.getParameterMap());
	String url=httpServletRequest.getRequestURI();
	Map<String,String> map=new HashMap<String,String>();
	map.put(url, params);
	String nowUrlParams=map.toString();//
	
	Object preUrlParams=httpServletRequest.getSession().getAttribute("repeatData");
	if(preUrlParams==null)//如果上一个数据为null,表示还没有访问页面
	{
		httpServletRequest.getSession().setAttribute("repeatData", nowUrlParams);
		return false;
	}
	else//否则，已经访问过页面
	{
		if(preUrlParams.toString().equals(nowUrlParams))//如果上次url+数据和本次url+数据相同，则表示城府添加数据
		{
			
			return true;
		}
		else//如果上次 url+数据 和本次url加数据不同，则不是重复提交
		{
			httpServletRequest.getSession().setAttribute("repeatData", nowUrlParams);
			return false;
		}
		
	}
}

}
