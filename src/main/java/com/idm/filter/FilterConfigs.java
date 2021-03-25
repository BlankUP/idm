package com.idm.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Configuration;

import com.idm.common.csrf.CSRFFilter;
import com.idm.common.xss.XssFilter;
/**
 * 
 *<P>Title:</P>
 *@Description:使用注册Bean的方式，可以指定过滤器的过滤地址，
 *还可通过Order指定过滤顺序。setOrder()的值越小优先级越高
 *@author panling
 *@date 2021年3月17日
 *@version
 */
@Configuration
public class FilterConfigs {

//	@Bean
//	public FilterRegistrationBean registrationLoginFilter() {
//		FilterRegistrationBean filterR = new FilterRegistrationBean();
//		filterR.setFilter(new LoginFilter());
//		filterR.addUrlPatterns("/*");
//		filterR.setOrder(1);
//		return filterR; 
//	}
//	
//	@Bean
//	public FilterRegistrationBean registrationXssFilter() {
//		FilterRegistrationBean filterR = new FilterRegistrationBean();
//		filterR.setFilter(new XssFilter());
//		filterR.addUrlPatterns("/*");
//		filterR.setOrder(2);
//		return filterR; 
//	}
//
	
	
//	@Bean
//	public FilterRegistrationBean registrationXssFilter() {
//		FilterRegistrationBean filterR = new FilterRegistrationBean();
//		filterR.setFilter(new CSRFFilter());
//		filterR.addUrlPatterns("/*");
//		filterR.setOrder(1);
//		return filterR; 
//	}
//	
}
