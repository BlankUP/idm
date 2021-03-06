package com.idm.app.system.fd.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idm.app.idpconfig.eventconfig.model.EventConfig;
import com.idm.app.system.fd.model.FdParamsConfigInfo;
import com.idm.app.system.fd.service.FdParamsConfigInfoService;
import com.idm.app.system.login.model.IDMUser;
import com.idm.common.util.ResByPageVo;

import net.sf.json.JSONObject;

/**
 * @controller 批量调度参数配置页面方法
 * @author liushudong
 * @date 2019年2月21日
 */
@Controller
public class FdParamsConfigInfoController {

    private Logger logger=Logger.getLogger(FdParamsConfigInfoController.class);
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Autowired
    private FdParamsConfigInfoService fdParamsConfigInfoService;

/*    @RequestMapping("/fd_params_config_info")
    public String serverInfo()
    {
        return "fd/paramsConfigInfo";
    }*/

    /**
     * @Describe 批量参数配置信息查询
     * @param request
     * @return
     */
    @RequestMapping("/fd_params_config_info_service")
	@ResponseBody
    public Object fdConfigInfoView(HttpServletRequest request){
		ResByPageVo resByPageVo = null;
		String paramCode = request.getParameter("paramCode");
		String paramName = request.getParameter("paramName");
		String paramType = request.getParameter("paramType");
		String status = request.getParameter("status");
		try {
			int page =Integer.parseInt(request.getParameter("page"));
			int size = Integer.parseInt(request.getParameter("rows"));
			resByPageVo = new ResByPageVo(size, page,fdParamsConfigInfoService.selectCountByAll(paramCode,paramName,paramType,status));
			resByPageVo.setRows(fdParamsConfigInfoService.selectByAll(size, page, paramCode,paramName,paramType,status));
		} catch (Exception e) {
			logger.error("RoleController:组装返回数据失败！", e);
		}
		return JSONObject.fromObject(resByPageVo);
    }
    
    /**
     * @Describe 批量参数配置信息保存
     * @param request
     * @return
     */
    @RequestMapping("/fd_params_config_info_save")
    @ResponseBody
    public String addOrUpdateBasicData(HttpServletRequest request)
    {

        String option  = request.getParameter("option");
        String paramCode = request.getParameter("paramCode");
        String paramName = request.getParameter("paramName");
        String paramType= request.getParameter("paramType");
        String paramValue =request.getParameter("paramValue");
        String paramDesc = request.getParameter("paramDesc");
        String status  =request.getParameter("status");

        FdParamsConfigInfo fdParamsConfigInfo  = new FdParamsConfigInfo();
        fdParamsConfigInfo.setParamCode(paramCode);
        fdParamsConfigInfo.setParamName(paramName);
        fdParamsConfigInfo.setParamType(paramType);
        fdParamsConfigInfo.setParamValue(paramValue);
        fdParamsConfigInfo.setParamDesc(paramDesc);
        fdParamsConfigInfo.setStatus(status);
        
        IDMUser user = (IDMUser) request.getSession().getAttribute("user");
        if("add".equals(option)){
        		fdParamsConfigInfo.setCreateUser(user.getUserId());
        		fdParamsConfigInfo.setCreateTime(sdf.format(new Date()));
            try {
            		fdParamsConfigInfoService.addFdParamConfigInfo(fdParamsConfigInfo);
            } catch (Exception e) {
                logger.error(e.getMessage());
                return "添加数据失败";
            }
        }
        
        if("modify".equals(option)){
        		fdParamsConfigInfo.setUpdateUser(user.getUserId());
        		fdParamsConfigInfo.setUpdateTime(sdf.format(new Date()));
        		fdParamsConfigInfoService.updateFdParamConfigInfo(fdParamsConfigInfo);
        }
        return null;
    }
    
    /**
     * @Describe 批量参数配置信息删除
     * @param request
     * @return
     */
    @RequestMapping("/fd_params_config_info_delete")
	@ResponseBody
    public Object userServiceDeleteUser(HttpServletRequest request){
    	String paramCode = request.getParameter("paramCode");
    	String paramType= request.getParameter("paramType");
    	if(paramType.equals("1")) {
    		return JSONObject.fromObject("{\"success\":false,\"msg\":\"内置参数不允许删除！\"}");
    	}else {
    		long result = fdParamsConfigInfoService.deleteFdParamConfigInfoByParamCode(paramCode);
			if(result > 0){
				return JSONObject.fromObject("{\"success\":true}");
			}
			return JSONObject.fromObject("{\"success\":true,\"msg\":\"数据不存在\"}");
    	}			
    }
    
    /**
     * 
     * @Description: 校验参数编码是否重复
     * @param request
     * @return
     */
    @RequestMapping("/checkParamCode")
    @ResponseBody
    public Object checkParamCode(HttpServletRequest request)
    {
	    String paramCode  = request.getParameter("paramCode");				//参数编码
	    logger.info("paramCode:["+paramCode+"]");
	    FdParamsConfigInfo fdParamsConfigInfo = new FdParamsConfigInfo();
	    fdParamsConfigInfo.setParamCode(paramCode);
	    long num = fdParamsConfigInfoService.checkParamCode(fdParamsConfigInfo);
	    logger.info("num:["+num+"]");
	    if(num>0) {
	    	return JSONObject.fromObject("{\"success\":true}");
	    }
		return JSONObject.fromObject("{\"success\":false}");
    }
    
    /**
     * 
     * @Description: 校验参数名称是否重复
     * @param request
     * @return
     */
    @RequestMapping("/checkParamName")
    @ResponseBody
    public Object checkParamName(HttpServletRequest request)
    {
	    String paramName  = request.getParameter("paramName");				//参数编码
	    logger.info("paramName:["+paramName+"]");
	    FdParamsConfigInfo fdParamsConfigInfo = new FdParamsConfigInfo();
	    fdParamsConfigInfo.setParamName(paramName);
	    long num = fdParamsConfigInfoService.checkParamName(fdParamsConfigInfo);
	    logger.info("num:["+num+"]");
	    if(num>0) {
	    	return JSONObject.fromObject("{\"success\":true}");
	    }
		return JSONObject.fromObject("{\"success\":false}");
    }
}
