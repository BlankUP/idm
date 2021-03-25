package com.idm.app.system.basicdataconfig.controller;

import net.sf.json.JSONObject;
import com.github.pagehelper.PageHelper;
import com.idm.app.idpconfig.pmmlConfig.model.PmmlConfig;

import com.idm.app.system.auth.model.UserInfo;


import com.idm.app.idpconfig.proModelParaConfig.model.ParaBaseInfo;
import com.idm.app.idpconfig.proModelParaConfig.model.ProductBaseInfo;

import com.idm.app.system.basicdataconfig.model.IdmParamsCfg;
import com.idm.app.system.basicdataconfig.service.BasicDataConfigService;
import com.idm.app.system.login.model.IDMUser;
import com.idm.app.system.loginfo.model.SysLog;
import com.idm.app.system.serverconfig.model.ServerInfo;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import com.idm.common.util.HttpTool;
import com.idm.common.util.ResByPageVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
/**
 * 
 *<p>Title: BasicDataConfigController</p>  
 * @Description: 线程数据配置信息
 * @author HDQ
 * @date 2019年2月18日
 * @version  1.0
 *
 */
@Controller
public class BasicDataConfigController {

    private Logger logger = Logger.getLogger(BasicDataConfigController.class);
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private  BasicDataConfigService basicDataConfigService;

    @RequestMapping("/basic_data_config")
    public String basicDataConfig(Model model)
    {
        return "basicDataConfig";
    }
    
    
    /**
     * 
     * @Description: 查询方法
     * @param request
     * @return
     */
    @RequestMapping("basic_data_query")
    @ResponseBody
    @SysLog(operate="查询",module="线程数据配置")
    public Object basicDataQuery(HttpServletRequest request)
    {
    	logger.info("******线程数据配置开始进入查询******");
    	

        String paramCode = request.getParameter("dataCode");
        String paramName = request.getParameter("paramName");
        String paramType = request.getParameter("type");
        String paramStatus = request.getParameter("status");
        
        int page = Integer.parseInt(request.getParameter("page"));
		int size = Integer.parseInt(request.getParameter("rows"));
		logger.info(">>>paramCode["+paramCode+"]");
        logger.info(">>>paramName["+paramName+"]");
        logger.info(">>>paramType["+paramType+"]");
        logger.info(">>>paramStatus["+paramStatus+"]");
 

        IdmParamsCfg idmParamsCfg = new IdmParamsCfg();
        idmParamsCfg.setParamCode(paramCode);
        idmParamsCfg.setParamName(paramName);
        idmParamsCfg.setParamType(paramType);
        idmParamsCfg.setStatus(paramStatus);
        idmParamsCfg.setPage(page);
        idmParamsCfg.setSize(size);
        
        int count = basicDataConfigService.selectCountByAll(idmParamsCfg);
		
		List<IdmParamsCfg> list = basicDataConfigService.queryBasicDataConfig(idmParamsCfg);
		ResByPageVo resByPageVo = new ResByPageVo(size, page, count);
		if (list != null && list.size() > 0) {
			logger.info("查询线程数据信息，总记录[" + count + "]");
			resByPageVo.setRows(list);
		} else if (list != null && list.size() == 0) {
			logger.info(">>线程数据查询无记录");
			resByPageVo = new ResByPageVo(size, page, 0);
		} else {
			logger.info("线程数据查询数据库错误");
			resByPageVo = new ResByPageVo(size, page, 0);
		}
		
		 logger.info("******线程数据配置查询结束******");
	     return JSONObject.fromObject(resByPageVo);
    }


    /**
     * 
     * @Description: 增加和修改
     * @param request
     * @return
     */
    @RequestMapping("/basic_data_save")
    @ResponseBody
    @SysLog(operate="新增或修改",module="线程数据配置")
    public String addOrUpdateBasicData(HttpServletRequest reqeust)
    {
    	logger.info("******线程数据配置开始进入新增或修改方法******");
        String option  = reqeust.getParameter("option");
        String paramCode = reqeust.getParameter("base.paramCode");
        String paramName = reqeust.getParameter("paramName");
        String paramValue =reqeust.getParameter("base.paramValue");
        String paramType= reqeust.getParameter("base.type");
        String paramDesc = reqeust.getParameter("paramDesc");
        String status  =reqeust.getParameter("base.status");

        logger.info(">>option["+option+"]");
        logger.info(">> paramCode["+ paramCode+"]");
        logger.info(">>paramName["+paramName+"]");
        logger.info(">>paramValue["+paramValue+"]");
        logger.info(">>paramDesc["+paramDesc+"]");
        logger.info(">>status["+status+"]");
        
        IDMUser user = (IDMUser)reqeust.getSession().getAttribute("user");
        IdmParamsCfg idmParamsCfg  = new IdmParamsCfg();
        idmParamsCfg.setParamCode(paramCode);
        idmParamsCfg.setParamName(paramName);
        idmParamsCfg.setParamValue(paramValue);
        idmParamsCfg.setParamType(paramType);
        idmParamsCfg.setParamDesc(paramDesc);
        idmParamsCfg.setStatus(status);
        idmParamsCfg.setCreateTime(sdf.format(new Date()));
        idmParamsCfg.setCreateUser(user.getUserId());
        idmParamsCfg.setUpdateTime(sdf.format(new Date()));
        idmParamsCfg.setUpdateUser(user.getUserId());
        if("add".equals(option))
        {
            try {
                basicDataConfigService.addBasicData(idmParamsCfg);
            } catch (Exception e) {
                logger.error(e.getMessage());
                return "添加数据失败";
            }
        }
        if("update".equals(option))
        {
            basicDataConfigService.updateBasicData(idmParamsCfg);
        }
        logger.info("******线程数据配置新增或修改方法结束******");
        return null;
    }
    


}
