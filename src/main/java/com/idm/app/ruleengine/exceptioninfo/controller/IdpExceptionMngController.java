package com.idm.app.ruleengine.exceptioninfo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.idm.app.ruleengine.exceptioninfo.mapper.IdpExceptionInfoMapper;
import com.idm.app.ruleengine.exceptioninfo.model.DataInterfaceInvokInfo;
import com.idm.app.ruleengine.exceptioninfo.model.IdpExceptionInfo;
import com.idm.app.system.login.model.IDMUser;
import com.idm.app.system.loginfo.model.SysLog;
import com.idm.common.constant.Constant;
import com.idm.common.page.PageVo;
import com.idm.common.util.DateTools;
import com.idm.common.util.DateUtil;
import com.idm.common.util.HttpTool;
import com.idm.common.util.JsonTool;
import com.idm.common.util.ResByPageVo;
/**
 * 
 * @Description: 
 * @author: sjf
 * @date:   2019年3月4日 下午6:06:18   
 * @Copyright: 2019 www.sunline.cn All rights reserved. 
 *
 */
@Controller
public class IdpExceptionMngController {
	
	private Logger logger = Logger.getLogger(IdpExceptionMngController.class);
	
	@Resource
	private IdpExceptionInfoMapper idpExceptionInfoMapper;
	
	@Value("${IDP_URL}")
	private String IDP_URL;
	
	@Value("${IDP_TIMEOUT}")
	private Integer TimeOut;
	
	@RequestMapping("/idp_exception_page")
	public String IdpExceptionPage(){
		return "exceptionManage/idp_exception_page";
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping("/idp_exception_info")
	@ResponseBody
	@SysLog(operate="异常信息查询",module="决策服务系统异常信息")
	public Object idp_exception_info(HttpServletRequest request, String page, String rows) throws Exception {
		int pageNum =Integer.parseInt(StringUtils.isNotBlank(page) ? page : "1");
		/* 每页大小 */
	    int pageSize = Integer.parseInt(StringUtils.isNotBlank(rows) ? rows : "10");
	    /* 业务请求日期 */
	    String srcDate=request.getParameter("srcDate");
	    /* 业务请求流水号 */
	    String querySeqNo=request.getParameter("querySeqNo");
	    if(srcDate!=null && srcDate.length()==10) {
	    	srcDate = DateUtil.formate(srcDate, DateUtil.getFormat("yyyy-MM-dd"), DateUtil.getFormat("yyyyMMdd"));
	    }
	    logger.info("*****业务请求日期srcDate:"+srcDate+"******");
	    logger.info("*****请求流水号querySeqNo:"+querySeqNo+"******");
	    ResByPageVo resByPageVo=null;
	    IdpExceptionInfo idpExceptionInfo = new IdpExceptionInfo();
		idpExceptionInfo.setSrcDate(srcDate);
		idpExceptionInfo.setQuerySeqNo(querySeqNo);
		idpExceptionInfo.setPage(pageNum);
		idpExceptionInfo.setSize(pageSize);
   
		List<IdpExceptionInfo> exceptionList = idpExceptionInfoMapper.queryIdpExceptionInfo(idpExceptionInfo);
		logger.info("******IDP异常信息查询成功，总记录为["+ idpExceptionInfoMapper.selectCountByAll(idpExceptionInfo)+"******");
		resByPageVo = new ResByPageVo(pageSize, pageNum,idpExceptionInfoMapper.selectCountByAll(idpExceptionInfo));
		resByPageVo.setRows(exceptionList);
		return JSONObject.toJSON(resByPageVo);
	}
	/**
	 * @Description: 格式化异常信息中的请求报文
	 * @param exceptionList   
	 * @return: List<IdpExceptionInfo>      
	 * @throws 
	 * @author sjf
	 */
	public List<IdpExceptionInfo> formatRequestPkg( List<IdpExceptionInfo> exceptionList){
		
		List<IdpExceptionInfo> list= new ArrayList<IdpExceptionInfo>();
		for(IdpExceptionInfo idpExceptionInfo :exceptionList) {
			String requestPkg  = JsonTool.JsonFormart(idpExceptionInfo.getRequestPkg());
			idpExceptionInfo.setRequestPkg(requestPkg);
			list.add(idpExceptionInfo);
		}
		return list;
	}
	
	/**
	 * 
	 * @Description: 查询调用决策请求的入参
	 * @param request    
	 * @return: Object      
	 * @author sjf
	 */
	@RequestMapping("/invokeblazedata")
	@ResponseBody
	public Object queyInvokeBlazeData(HttpServletRequest request){
		String businessNo=request.getParameter("businessNo");
		JSONObject result = new JSONObject();
		logger.info("******业务流水号businessNo:"+businessNo+"*****");
		String invokeBlazeData = idpExceptionInfoMapper.queryReqBlazeData(businessNo);
		//根据查询条件组装返回前端的报文，retCode为0表示查询成功，1表示失败
		if(invokeBlazeData!=null && invokeBlazeData.length()>0) {
			//查询成功
			result.put("retCode", Constant.SUCCESS_CODE);
			result.put("retMsg",invokeBlazeData );
			return result;
		}
		//查询失败
		result.put("retCode", Constant.FAIL_CODE);
		result.put("retMsg", "无满足条件的记录");
		return result;
	}
	
	/**    
	 * @Description: 修改请求智能决策系统报文或者修改数据接口服务系统相应报文
	 * @param request     
	 * @return: Object      
	 * @author sjf 
	 */
	@RequestMapping("/updateblazedata")
	@ResponseBody
	public Object updateBlazeData(HttpServletRequest request){
		
		String businessNo=request.getParameter("businessNo");
		String invokeBlazeData=request.getParameter("invokeBlazeData");
		logger.info("******业务流水号businessNo:"+businessNo+"*****");
		logger.info("******调用决策引擎请求报文invokeBlazeData:"+invokeBlazeData+"*******");
		
		JSONObject result = new JSONObject();
		try {
			idpExceptionInfoMapper.updateBlazeData(businessNo,invokeBlazeData);
			result.put("retCode", Constant.SUCCESS_CODE);
		}catch(Exception e)
		{
			result.put("retCode", Constant.FAIL_CODE);
			result.put("retMsg", e.getMessage());
			logger.error("******数据修改异常："+e.getMessage()+"******");
		}
		
		return result;
	}
	
	/**
	 * @Description: 异常业务重跑
	 * @return: Object      
	 * @author sjf
	 */
	@RequestMapping("/redobusiness")
	@ResponseBody
	@SysLog(operate="异常业务重跑",module="决策服务系统异常信息")
	public JSONObject redoBusiness(HttpServletRequest request) {
		
		logger.info("******执行异常业务重跑******");
		JSONObject result = new JSONObject();
		//管理平台登录用户
		IDMUser user = (IDMUser) request.getSession().getAttribute("user");
		
		//原业务发起日期
		String srcDate = request.getParameter("srcDate");
		
		//原发起流水号
		String querySeqNo = request.getParameter("querySeqNo");
		
		//原业务流水号
		String businessNo = request.getParameter("businessNo");
		
		
		IdpExceptionInfo idpExceptionInfo =  idpExceptionInfoMapper.queryIdpExceptionInfoBySeqno(businessNo);
		if(idpExceptionInfo==null) {
			result.put("retCode", Constant.FAIL_CODE);
			result.put("retMsg", "查询原交易记录失败");
			return result;
		}
		
		//检查重跑结果，如果重跑结果是“0-进行中”或者“1-成功”，则拒绝重跑
		String reBusinessResult=idpExceptionInfo.getReBusinessResult();
		System.out.println("+++++++++++"+reBusinessResult);
		if("0".equals(reBusinessResult) || "1".equals(reBusinessResult)) {
			result.put("retCode", Constant.FAIL_CODE);
			result.put("retMsg", "业务重跑正在进行中或者以成功完成");
			return result;
		}
		//错误代码
		String errorCode =idpExceptionInfo.getErrorCode(); 
		
		//错误信息
		String errorMsg = idpExceptionInfo.getErrorMsg();
	
		logger.info("******usrId:"+user.getUserId()+"******");
		logger.info("******srcDate:"+srcDate+"******");
		logger.info("******querySeqNo:"+querySeqNo+"******");
		logger.info("******businessNo:"+businessNo+"******");
		logger.info("******errorCode:"+errorCode+"******");
		logger.info("******errorMsg:"+errorMsg+"******");
		
		//原业务请求报文
		String message = idpExceptionInfo.getRequestPkg();
		
		JSONObject reqJson = JSONObject.parseObject(message);
		
		//"2"-标识该笔业务为重跑业务
		JSONObject reqJsondata=reqJson.getJSONObject("data");
		reqJsondata.remove("rerunFlag");
		reqJsondata.put("rerunFlag", "2");
		reqJsondata.remove("requestType");
		reqJsondata.put("requestType", "2");
		//原发起日期
		reqJson.put("OrgSrcDate", srcDate);
		//原查询流水
		reqJson.put("OrgQuerySeqNo", querySeqNo);
		
		//原业务流水
		reqJson.put("orgBusinessNo", businessNo);
		 
		logger.info("******发送决策服务系统IDP的报文："+reqJson.toJSONString()+"******");
		String resp="";
		try {
			resp  = HttpTool.sendIDP(IDP_URL, reqJson.toJSONString(), TimeOut);
			logger.info("******重跑发送决策服务系统IDP的返回报文："+resp+"******");
			JSONObject resoJson = JSONObject.parseObject(resp);
			if("IDP_SY_1001".equals(resoJson.getString("errorCode"))) {
				result.put("retCode", Constant.SUCCESS_CODE);
				//更新异常信息表   0-重跑过程执行中
				updateIdpExceptionInfo(businessNo,user.getUserId(),"1");
			}
		}catch(HttpHostConnectException e) {
			result.put("retCode", Constant.FAIL_CODE);
			result.put("retMsg", "连接决策服务系统被拒绝");
			updateIdpExceptionInfo(businessNo,user.getUserId(),"2");
			e.printStackTrace();
			
			return result;
		}catch(ConnectTimeoutException e) {
			result.put("retCode", Constant.FAIL_CODE);
			result.put("retMsg", "连接决策服务系统超时");
			updateIdpExceptionInfo(businessNo,user.getUserId(),"2");
			e.printStackTrace();
		} catch (Exception e) {
			updateIdpExceptionInfo(businessNo, user.getUserId(),"2");
			e.printStackTrace();
			result.put("retCode", Constant.FAIL_CODE);
			result.put("retMsg", "调用决策服务系统异常");
			return result;
		}
		
		return result;
	}
	/**
	 * 
	 * @Description: 更新决策服务平台异常信息表中的重跑操作员、重跑日期、重跑时间
	 * @param userId 操作用户  
	 * @return: void      
	 * @author sjf
	 */
	public void updateIdpExceptionInfo(String businessNo,String userId, String reBusinessResult) {
		String dateStr=DateTools.getDate();
		String timeStr=DateTools.getTime();
		idpExceptionInfoMapper.updateIdpExceptionInfo(businessNo, userId, dateStr, timeStr, reBusinessResult);
	}
	@RequestMapping("/batchredo")
	@ResponseBody
	public void batchred(){
		List<IdpExceptionInfo> list=idpExceptionInfoMapper.queryIdpExceptionInfoList();
		if(list!=null){
			for (IdpExceptionInfo idpExceptionInfo : list) {
				JSONObject reqJson = JSONObject.parseObject(idpExceptionInfo.getRequestPkg());
				String businessNo=idpExceptionInfo.getBusinessNo();
				//"2"-标识该笔业务为重跑业务
				JSONObject reqJsondata=reqJson.getJSONObject("data");
				reqJsondata.put("rerunFlag", "2");
				reqJsondata.remove("requestType");
				reqJsondata.put("requestType", "2");
				//原发起日期
				reqJson.put("OrgSrcDate", idpExceptionInfo.getSrcDate());
				//原查询流水
				reqJson.put("OrgQuerySeqNo", idpExceptionInfo.getQuerySeqNo());				
				//原业务流水
				reqJson.put("orgBusinessNo", businessNo);
				 
				logger.info("******发送决策服务系统IDP的报文："+reqJson.toJSONString()+"******");
				String resp="";
				try {
					resp  = HttpTool.sendIDP(IDP_URL, reqJson.toJSONString(), TimeOut);
					logger.info("******重跑发送决策服务系统IDP的返回报文："+resp+"******");
					JSONObject resoJson = JSONObject.parseObject(resp);
					if("IDP_SY_1001".equals(resoJson.getString("errorCode"))) {
						//更新异常信息表   0-重跑过程执行中
						updateIdpExceptionInfo(businessNo,"root","1");
					}
				}catch(HttpHostConnectException e) {
					updateIdpExceptionInfo(businessNo,"root","2");
					e.printStackTrace();
				}catch(ConnectTimeoutException e) {
					updateIdpExceptionInfo(businessNo,"root","2");
					e.printStackTrace();
				} catch (Exception e) {
					updateIdpExceptionInfo(businessNo,"root","2");
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
}
