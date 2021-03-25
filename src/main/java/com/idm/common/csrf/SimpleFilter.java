package com.idm.common.csrf;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleFilter extends HttpServlet implements Filter{
	private static final long serialVersionUID = 1L;
	private FilterConfig filterConfig;
	public void destroy() {
		this.filterConfig = null;
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.filterConfig = config;
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		// 禁止缓存
		response.setHeader("Cache-Control", "no-store");
		response.setHeader("Pragrma", "no-cache");
		response.setDateHeader("Expires", 0);
		// 链接来源地址
		String referer = request.getHeader("referer");
		System.out.println("refer is"+referer);
		System.out.println("serverName is"+request.getServerName());
		if (referer != null && !referer.contains(request.getServerName())) {
		/**
		* 如果 链接地址来自其他网站，则返回错误图片
		*/
		request.getRequestDispatcher("/login.jsp").forward(request, response);
		} else {
		/**
		* 图片正常显示
		*/
		chain.doFilter(request, response);
		}
		
	}

}
