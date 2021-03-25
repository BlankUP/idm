package com.idm.app.ruleengine.exceptioninfo.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.idm.app.ruleengine.exceptioninfo.model.IdpAsyStoredExceptionInfo;
import com.idm.app.ruleengine.exceptioninfo.service.IdpAsyStoredInfoService;
import com.idm.app.system.login.model.IDMUser;
import com.idm.app.system.loginfo.model.SysLog;
import com.idm.common.jdbc.SaveJsonDataByJDBC;
import com.idm.common.util.ResByPageVo;
import com.idm.config.resubmit.repeat_form_validator.SameUrlData;

/**
 * <p>Title:IdpAsyStorageExceptionMngController</p>
 * @Description：idp系统异步存储异常操作控制层
 * @author：jiamh
 * @createTime：2019年3月15日
 * @version 1.0
 */
@Controller
public class IdpAsyStorageExceptionMngController {

	private Logger logger = Logger.getLogger(IdpAsyStorageExceptionMngController.class);
	
	@Resource
	private IdpAsyStoredInfoService idpAsyStoredInfoService;
	
	@Value("${jdbc_driver}")
	private String jdbc_driver;
	
	@Value("${jdbc_url}")
	private String jdbc_url;
	
	@Value("${jdbc_username}")
	private String jdbc_username;
	
	@Value("${jdbc_password}")
	private String jdbc_password;
	
	@RequestMapping("/idp_asyStorageException_page")
	public String IdpAsyStorageException(){
		return "exceptionManage/idp_asyStorageException_page";
	}
	
	/**
	 * @Description：对idp系统异步存储异常表进行查找
	 * @param request
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/idp_asyStorageException_info")
	@ResponseBody
	@SysLog(operate="异步存储异常信息查询",module="异步存储异常信息")
	public Object query(HttpServletRequest request, String page, String rows){
		
		logger.info("******异步存储异常信息查询开始******");
		int pageNum =Integer.parseInt(StringUtils.isNotBlank(page) ? page : "1");     //页号
	    int pageSize = Integer.parseInt(StringUtils.isNotBlank(rows) ? rows : "10");  //每页大小
	    String businessNo = request.getParameter("businessNo");						  //业务流水号
	    String createTime = request.getParameter("createTime");                       //创建时间
		try {
			if(businessNo!=null && !"".equals(businessNo)){
				businessNo =  java.net.URLDecoder.decode(businessNo,"UTF-8");
				businessNo = businessNo.trim();
				businessNo = "%"+businessNo+"%";
			}
			if(createTime!=null && !"".equals(createTime)){
				createTime = java.net.URLDecoder.decode(createTime,"UTF-8");
				createTime = "%"+createTime+"%";
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			logger.error("类IdpAsyStorageExceptionMngController中方法query出现UnsupportedEncodingException异常：", e);
		}           
        //System.out.println("businessNo="+businessNo+";createTime="+createTime);
	    
	    IdpAsyStoredExceptionInfo idpAsyStoredExceptionInfo = new IdpAsyStoredExceptionInfo();
	    idpAsyStoredExceptionInfo.setBusinessNo(businessNo);
	    idpAsyStoredExceptionInfo.setCreateTime(createTime);
	    idpAsyStoredExceptionInfo.setPage(pageNum);
	    idpAsyStoredExceptionInfo.setSize(pageSize);
	    int count = idpAsyStoredInfoService.selectCountByAll(idpAsyStoredExceptionInfo);
		List<IdpAsyStoredExceptionInfo> list = idpAsyStoredInfoService.queryIdpAsyStoredExceptionInfo(idpAsyStoredExceptionInfo);
		ResByPageVo resByPageVo = new ResByPageVo(pageSize, pageNum, count);
		if (list != null && list.size() > 0) {
			resByPageVo.setRows(list);
		} else if (list != null && list.size() == 0) {
			resByPageVo.setRows(list);
		} else {
			resByPageVo.setRows(list);
		}
		logger.info("******异步存储异常信息查询结束******");
		return resByPageVo;
	}
	
	/**
	 * @Description：对idp系统异步存储异常表中的sql进行执行，并修改异常表中数据状态
	 * @param request
	 * @param page
	 * @param rows
	 * @return
	 */
	@SameUrlData
	@RequestMapping("/idp_asyStorageException_reinsert")
	@ResponseBody
	@SysLog(operate="异步存储异常信息重新插入",module="异步存储异常信息")
	public Object reinsert(HttpServletRequest request){
		
		logger.info("******异步存储异常信息重新插入开始******");
		boolean isPass = false;
		String status = "0";
		String operateStatus = "0";
		String asyStoredId=request.getParameter("asyStoredId");    //异步存储数据异常表唯一id
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String userId = null;
		String operateTime = null;
		try {
			//获取当前用户id
			IDMUser user = (IDMUser)request.getSession().getAttribute("user");
			userId = user.getUserId();
			//1、根据asyStoredId查找executeSql
			String executeSql = idpAsyStoredInfoService.queryExecuteSqlByAsyStoredId(asyStoredId);
			if(executeSql==null||"".equals(executeSql)){
				logger.error("类IdpAsyStorageExceptionMngController中表idp_asystored_excption_info中asyStoredId="+asyStoredId+"的executeSql值异常！");
				isPass = false;
				return JSONObject.parse("{\'isPass\':"+isPass+"}");
			}
			
			//2、通过jdbc方式把数据插入到表里
			SaveJsonDataByJDBC saveJsonDataByJDBC = new SaveJsonDataByJDBC();
			System.out.println("executeSql="+executeSql);
			int num = saveJsonDataByJDBC.saveJsonDataByJDBC(executeSql,jdbc_driver,jdbc_url,jdbc_username,jdbc_password);
			status = "1";
			operateStatus = "1";
			isPass = true;
			logger.info("重新插入了"+num+"条数据！");
		} catch (SQLException e) {
			isPass = false;
			status = "1";
			operateStatus = "2";
			logger.error("类IdpAsyStorageExceptionMngController中方法update出现SQLException异常：", e);
		} catch (IOException e) {
			isPass = false;
			status = "1";
			operateStatus = "2";
			logger.error("类IdpAsyStorageExceptionMngController中方法update出现IOException异常：", e);
		} catch (Exception e) {
			isPass = false;
			status = "1";
			operateStatus = "2";
			logger.error("类IdpAsyStorageExceptionMngController中方法update出现Exception异常：", e);
		}
		
		try{
			operateTime = sdf.format(new Date());
		//3、通过mybatics修改数据状态
			idpAsyStoredInfoService.updateIdpAsyStoredExceptionInfo(asyStoredId, operateStatus, status,operateTime,userId);
		} catch (Exception e) {
			isPass = false;
			status = "1";
			operateStatus = "2";
			logger.error("类IdpAsyStorageExceptionMngController中方法update出现Exception异常：", e);
		}
		logger.info("******异步存储异常信息重新插入结束******");
		return JSONObject.parse("{\'isPass\':"+isPass+"}");
	}
}
