package com.idm.config.resubmit.submit;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author BaiY
 *
 */
@Configuration
public class StartupConfig extends WebMvcConfigurerAdapter {
	   static final Logger logger = Logger.getLogger(StartupConfig.class);

	@Override
    public void addInterceptors(InterceptorRegistry registry) {
		logger.info("~~~~~~~进入拦截器第一步~~~~~~~~");
        registry.addInterceptor(new SameUrlDataInterceptor()).addPathPatterns("/*.do");
    }

}
