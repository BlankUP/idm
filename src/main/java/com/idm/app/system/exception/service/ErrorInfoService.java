package com.idm.app.system.exception.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.idm.app.system.exception.mapper.ErrorInfoMapper;
import com.idm.app.system.exception.model.ErrorInfo;

/**
 * @Service 异常信息服务
 * @author liushudong
 * @date 2019年2月26日
 *
 */
@Service
public class ErrorInfoService {
	@Resource
    ErrorInfoMapper errorInfoMapper;
	
	public Integer saveErrorInfo(ErrorInfo errorInfo) {
		return errorInfoMapper.saveErrorInfo(errorInfo);
	}

}
