package com.idm.common.xss;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Component;

import com.idm.common.csrf.TimeListener;
/**
 * 
 *<P>Title:系统安全代码过滤器</P>
 *@Description:
 *@author panling
 *@date 2021年2月1日
 *@version
 */
public class XssFilter implements Filter{
	
	FilterConfig filterConfig = null;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		 this.filterConfig = filterConfig;

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		//xss
		chain.doFilter(new XssShellInterceptor( (HttpServletRequest) request), response);

	}

	@Override
	public void destroy() {
		this.filterConfig = null;
	}

}
