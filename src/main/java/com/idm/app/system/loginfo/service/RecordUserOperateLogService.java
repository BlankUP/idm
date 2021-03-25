package com.idm.app.system.loginfo.service;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.idm.app.system.loginfo.model.RecordUserOperateLog;
import com.idm.app.system.loginfo.mapper.RecordUserOperateLogMapper;

/**
 * @service 用户操作日志保存服务
 * @author 翁嘉薇
 * @date 2019年2月25日
 */
@Service
public class RecordUserOperateLogService {
	static Logger logger = Logger.getLogger(RecordUserOperateLogService.class);
	
	@Resource
	RecordUserOperateLogMapper recordUserOperateLogMapper;
	
	public Integer saveSysLogInfo(RecordUserOperateLog recordUserOperateLog) {
		return  recordUserOperateLogMapper.saveSysLogInfo(recordUserOperateLog);
	}
}
