package com.idm.app.system.loginfo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.idm.app.system.loginfo.mapper.LogInfoMapper;
import com.idm.app.system.loginfo.model.LogInfo;
import com.idm.app.system.loginfo.model.LogInfoExample;
import org.apache.log4j.Logger;

/**
 * @service 日志信息查询服务
 * @author 翁嘉薇
 * @date 2019年2月20日
 *
 */
@Service
public class LogInfoService {
	static Logger logger = Logger.getLogger(LogInfoService.class);
	
	@Resource
	private LogInfoMapper logInfoMapper;
	
	public Integer selectCountByAll(String userId,String operatTime,String operatType) {
		LogInfoExample example = new LogInfoExample();	
		if((userId!=null && !"".equals(userId) && !"null".equals(userId))&&(operatTime!=null && !"".equals(operatTime) && !"null".equals(operatTime))&&(operatType!=null && !"".equals(operatType) && !"null".equals(operatType)))
			example.createCriteria().anduserIdLike(userId).andOperatTimeLike(operatTime).andOperatTypeLike(operatType);
		if((userId!=null && !"".equals(userId) && !"null".equals(userId))&&(operatTime!=null && !"".equals(operatTime) && !"null".equals(operatTime))&&(operatType==null || "".equals(operatType)||"null".equals(operatType)))
			example.createCriteria().anduserIdLike(userId).andOperatTimeLike(operatTime);
		if((userId!=null && !"".equals(userId) && !"null".equals(userId))&&(operatTime==null || "".equals(operatTime) ||"null".equals(operatTime))&&(operatType!=null && !"".equals(operatType)&& !"null".equals(operatType)))
			example.createCriteria().anduserIdLike(userId).andOperatTypeLike(operatType);
		if((userId==null || "".equals(userId) || "null".equals(userId))&&(operatTime!=null && !"".equals(operatTime) && !"null".equals(operatTime))&&(operatType!=null && !"".equals(operatType)&& !"null".equals(operatType)))
			example.createCriteria().andOperatTimeLike(operatTime).andOperatTypeLike(operatType);		
		if((userId!=null && !"".equals(userId) && !"null".equals(userId))&&(operatTime==null || "".equals(operatTime)||"null".equals(operatTime))&&(operatType==null || "".equals(operatType)||"null".equals(operatType))) 
			example.createCriteria().anduserIdLike(userId);
		if((operatTime!=null && !"".equals(operatTime)&& !"null".equals(operatTime))&&(userId==null || "".equals(userId)|| "null".equals(userId))&&(operatType==null || "".equals(operatType)||"null".equals(operatType))) 
			example.createCriteria().andOperatTimeLike(operatTime);
		if((operatType!=null && !"".equals(operatType)&& !"null".equals(operatType))&&(userId==null || "".equals(userId) || "null".equals(userId))&&(operatTime==null || "".equals(operatTime)||"null".equals(operatTime))) 
			example.createCriteria().andOperatTypeLike(operatType);
		return logInfoMapper.selectCountByAll(example);
	}
	
	public List<LogInfo> selectByAll(int size, int page,  String userId,String operatTime,String operatType) {
		LogInfoExample example = new LogInfoExample();
		if((userId!=null && !"".equals(userId) && !"null".equals(userId))&&(operatTime!=null && !"".equals(operatTime) && !"null".equals(operatTime))&&(operatType!=null && !"".equals(operatType) && !"null".equals(operatType)))
			example.createCriteria().anduserIdLike(userId).andOperatTimeLike(operatTime).andOperatTypeLike(operatType);
		if((userId!=null && !"".equals(userId) && !"null".equals(userId))&&(operatTime!=null && !"".equals(operatTime) && !"null".equals(operatTime))&&(operatType==null || "".equals(operatType)||"null".equals(operatType)))
			example.createCriteria().anduserIdLike(userId).andOperatTimeLike(operatTime);
		if((userId!=null && !"".equals(userId) && !"null".equals(userId))&&(operatTime==null || "".equals(operatTime) ||"null".equals(operatTime))&&(operatType!=null && !"".equals(operatType)&& !"null".equals(operatType)))
			example.createCriteria().anduserIdLike(userId).andOperatTypeLike(operatType);
		if((userId==null || "".equals(userId) || "null".equals(userId))&&(operatTime!=null && !"".equals(operatTime) && !"null".equals(operatTime))&&(operatType!=null && !"".equals(operatType)&& !"null".equals(operatType)))
			example.createCriteria().andOperatTimeLike(operatTime).andOperatTypeLike(operatType);		
		if((userId!=null && !"".equals(userId) && !"null".equals(userId))&&(operatTime==null || "".equals(operatTime)||"null".equals(operatTime))&&(operatType==null || "".equals(operatType)||"null".equals(operatType))) 
			example.createCriteria().anduserIdLike(userId);
		if((operatTime!=null && !"".equals(operatTime)&& !"null".equals(operatTime))&&(userId==null || "".equals(userId)|| "null".equals(userId))&&(operatType==null || "".equals(operatType)||"null".equals(operatType))) 
			example.createCriteria().andOperatTimeLike(operatTime);
		if((operatType!=null && !"".equals(operatType)&& !"null".equals(operatType))&&(userId==null || "".equals(userId) || "null".equals(userId))&&(operatTime==null || "".equals(operatTime)||"null".equals(operatTime))) 
			example.createCriteria().andOperatTypeLike(operatType);
		
		/*if((userId!=null && !"".equals(userId))&&(operatTime!=null && !"".equals(operatTime))&&(operatType!=null && !"".equals(operatType)))
			example.createCriteria().anduserIdLike(userId).andOperatTimeLike(operatTime).andOperatTypeLike(operatType);
		if((userId!=null && !"".equals(userId))&&(operatTime!=null && !"".equals(operatTime))&&(operatType==null || "".equals(operatType)))
			example.createCriteria().anduserIdLike(userId).andOperatTimeLike(operatTime);
		if((userId!=null && !"".equals(userId))&&(operatTime==null || "".equals(operatTime))&&(operatType!=null && !"".equals(operatType)))
			example.createCriteria().anduserIdLike(userId).andOperatTypeLike(operatType);
		if((userId==null || "".equals(userId))&&(operatTime!=null && !"".equals(operatTime))&&(operatType!=null && !"".equals(operatType)))
			example.createCriteria().andOperatTimeLike(operatTime).andOperatTypeLike(operatType);		
		if((userId!=null && !"".equals(userId))&&(operatTime==null || "".equals(operatTime))&&(operatType==null || "".equals(operatType))) 
			example.createCriteria().anduserIdLike(userId);
		if(operatTime!=null && !"".equals(operatTime)&&(userId==null || "".equals(userId))&&(operatType==null || "".equals(operatType))) 
			example.createCriteria().andOperatTimeLike(operatTime);
		if(operatType!=null && !"".equals(operatType)&&(userId==null || "".equals(userId))&&(operatTime==null || "".equals(operatTime))) 
			example.createCriteria().andOperatTypeLike(operatType);*/
		example.setPage(page);
		example.setSize(size);
		example.setOrderByClause("operat_time desc");
		return logInfoMapper.selectByAll(example);
	}
}

