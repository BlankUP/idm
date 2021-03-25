package com.idm.filter;

import com.idm.app.system.auth.service.Auth;
import com.idm.app.system.auth.service.AuthManager;
import com.idm.app.system.login.model.IDMUser;
import com.idm.config.context.SpringContextHolder;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@Component
@ServletComponentScan
@WebFilter(urlPatterns = "/*",filterName = "loginFilter")
public class LoginFilter implements Filter {

    private Logger logger = Logger.getLogger(LoginFilter.class);
    //private final String[] exinclude = {"login"};
    //@Resource
    Environment env;
    
    @Autowired
    private AuthManager amanager;

    public void init(FilterConfigs filterConfig) throws ServletException {
        /*if(env==null){
            env = SpringContextHolder.getBean(Environment.class);
            logger.info("LoginFilter init successful.");
        }*/
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        String realPath = WebUtils.getPathWithinApplication(WebUtils.toHttp(servletRequest));

        if(!isValidate(realPath)){
            Object tmp = request.getSession().getAttribute("user");
            if(tmp!=null){
                IDMUser user = (IDMUser)tmp;
                if(Auth.getUser() == null || "".equals(Auth.getUser())) {
                		amanager.initUserAuthorization(user.getUserId()); //如果缓存中权限信息清空了，重新获取权限 
                }
                if(StringUtils.isNoneBlank(user.getUserId())){
                    logger.debug(realPath+" pathMatcher correct, go next filter.");
                    filterChain.doFilter(servletRequest,servletResponse);
                    return;
                }
            }
            logger.debug(realPath+" pathMatcher incorrect, go login page.");
            response.sendRedirect(request.getContextPath()+"/login");
            return;
        }
        logger.debug(realPath+" pathMatcher correct, go next filter.");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    public boolean isValidate(String realPath){
        if(env==null){
            env = SpringContextHolder.getBean(Environment.class);
            logger.info("Environment is null init successful.");
        }
        String exincludeString = env.getProperty("filter.exinclude");
        //logger.info(env.getProperty("logging.config"));
        String[] exinclude = exincludeString!=null?exincludeString.split(","):null;
        AntPathMatcher pathMatcher = new AntPathMatcher();
        boolean flag = false;
        for(int i=0;i<exinclude.length;i++){
            if(pathMatcher.match(exinclude[i],realPath)){
                flag = true;
                break;
            }
        }
        return flag;
    }

    @Override
    public void destroy() {

    }

	@Override
	public void init(javax.servlet.FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
