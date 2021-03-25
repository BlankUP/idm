package com.idm.app.idpconfig.pmmlConfig.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idm.app.idpconfig.pmmlConfig.service.PmmlConfigService;
import com.alibaba.druid.sql.visitor.functions.Isnull;
import com.idm.app.idpconfig.eventconfig.model.EventConfig;
import com.idm.app.idpconfig.pmmlConfig.model.PmmlConfig;
import com.idm.app.system.login.model.IDMUser;
import com.idm.app.system.loginfo.model.SysLog;
import com.idm.common.util.ResByPageVo;

import net.sf.json.JSONObject;


/**
 * 
 *<p>Title: PmmlConfigController</p>  
 * @Description: pmml模型
 * @author 黄百超
 * @date 2019年3月7日
 * @version  1.0
 *
 */
@Controller
public class PmmlConfigController {
	
    private Logger logger = Logger.getLogger(PmmlConfigController.class);
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Autowired
    private  PmmlConfigService pmmlConfigService;
    
    @RequestMapping("/pmml_config")
    public String PmmlConfig(Model model)
    {
        return "idpconfig/pmml/pmmlConfig";
    }

    /**
     * 
     * @Description: 查询pmml模型信息方法
     * @param request
     * @return
     */
    @RequestMapping("/pmml_query")
    @ResponseBody
    @SysLog(operate="PMML模型信息查询",module="PMML模型信息")
    public Object pmmlQuery(HttpServletRequest request)
    {
		logger.info("******pmml模型信息查询开始******");
		String pmmlCode = request.getParameter("pmmlCode"); // pmml编码
		String pmmlName = request.getParameter("pmmlName"); // pmml模型名称
		int page = Integer.parseInt(request.getParameter("page"));
		int size = Integer.parseInt(request.getParameter("rows"));

		System.out.println("page:"+page);
		System.out.println("size:"+size);
		ResByPageVo resByPageVo = null;
		logger.info("pmmlCode:[" + pmmlCode + "]");
		logger.info("pmmlName:[" + pmmlName + "]");
		PmmlConfig pmmlConfig = new PmmlConfig();
		pmmlConfig.setPmmlCode(pmmlCode);
		pmmlConfig.setPmmlName(pmmlName);
		pmmlConfig.setPage(page);
		pmmlConfig.setSize(size);
		resByPageVo = new ResByPageVo(size, page,pmmlConfigService.selectCountByAll(pmmlConfig));
		resByPageVo.setRows(pmmlConfigService.queryPmmlConfig(pmmlConfig));

        logger.info("******pmml模型信息查询结束******");
        return JSONObject.fromObject(resByPageVo);
    }
    
   /**
    * 
    * @Description: 新增、修改
    * @param request
    * @return
    */
    @RequestMapping("/pmml_save")
    @ResponseBody
    @SysLog(operate="新增或修改",module="PMML模型信息")
    public synchronized String addOrUpdatePmmlConfig(HttpServletRequest request)
    {
    	logger.info("******pmml模型新增/修改开始******");
    	String option  = request.getParameter("option");							//方法类型
    	String pmmlId  = request.getParameter("pmmlId");							//id
    	String pmmlCode  = request.getParameter("pmmlCode");						//模型编码
    	String pmmlName  = request.getParameter("pmmlName");						//模型名称
    	String pmmlDesc  = request.getParameter("pmmlDesc");						//模型描述
    	String status  = request.getParameter("status");							//状态位
    	String interfaceCode  = request.getParameter("interfaceCode");				//接口


        logger.info("pmmlId:["+pmmlId+"]");
        logger.info("option:["+option+"]");
        logger.info("pmmlCode:["+pmmlCode+"]");
        logger.info("pmmlName:["+pmmlName+"]");
        logger.info("pmmlDesc:["+pmmlDesc+"]");
        logger.info("status:["+status+"]");
        logger.info("interfaceCode:["+interfaceCode+"]");
        
        String date = sdf.format(new Date());
        IDMUser user = (IDMUser)request.getSession().getAttribute("user");
        PmmlConfig pmmlConfig = new PmmlConfig();
        pmmlConfig.setPmmlId(pmmlId);
        pmmlConfig.setPmmlCode(pmmlCode);
        pmmlConfig.setPmmlDesc(pmmlDesc);
        pmmlConfig.setPmmlName(pmmlName);
        pmmlConfig.setCreateTime(date);
        pmmlConfig.setCreateUser(user.getUserId());
        pmmlConfig.setUpdateTime(date);
        pmmlConfig.setUpdateUser(user.getUserId());
        pmmlConfig.setStatus(status);
        pmmlConfig.setInterfaceCode(interfaceCode);

        //新增与更新分别处理
        if("add".equals(option))
        {
        	 PmmlConfig pmmlConfig1 = new PmmlConfig();
     	    pmmlConfig1.setPmmlCode(pmmlCode);
     	    long num = pmmlConfigService.repeatPmmlCode(pmmlConfig1);
     	    logger.info("num:["+num+"]");
     	    if(num>0) {
     	    	return "添加失败";
     	    }
     	   PmmlConfig pmmlConfig2 = new PmmlConfig();
	   	    pmmlConfig2.setPmmlName(pmmlName);;
	   	    long num1 = pmmlConfigService.repeatPmmlName(pmmlConfig2);
	   	    logger.info("num1:["+num1+"]");
	   	    if(num1>0) {
	   	    	return "添加失败";
	   	    }
     	    
            try {
            	pmmlConfigService.addPmmlConfig(pmmlConfig);
            } catch (Exception e) {
                logger.error(e.getMessage());
                logger.info("******pmml模型新增结束******");
                return "添加数据失败";
            }
        }
        if("update".equals(option))
        {
        	try {
        		pmmlConfigService.updatePmmlConfig(pmmlConfig);
			} catch (Exception e) {
				 logger.error(e.getMessage());
				 logger.info("******pmml模型修改结束******");
	             return "更新数据失败";
			}
        }
        logger.info("******pmml新增/修改结束******");
        return null;
    }
    
    /**
     * 
     * @Description: PMML编码查重
     * @param request
     * @return
     */
    @RequestMapping("/repeat_pmml_code")
    @ResponseBody
    public Object repeatPmmlCode(HttpServletRequest request)
    {
	    String pmmlCode  = request.getParameter("pmmlCode");				//PMML编码
	    logger.info("pmmlCode:["+pmmlCode+"]");
	    PmmlConfig pmmlConfig = new PmmlConfig();
	    pmmlConfig.setPmmlCode(pmmlCode);
	    long num = pmmlConfigService.repeatPmmlCode(pmmlConfig);
	    logger.info("num:["+num+"]");
	    if(num>0) {
	    	return JSONObject.fromObject("{\"success\":true}");
	    }
		return JSONObject.fromObject("{\"success\":false}");
    }
    
    /**
     * 
     * @Description: PMML名称查重
     * @param request
     * @return
     */
    @RequestMapping("/repeat_pmml_name")
    @ResponseBody
    public Object repeatPmmlName(HttpServletRequest request)
    {
	    String pmmlName  = request.getParameter("pmmlName");				//PMML名称
	    logger.info("pmmlName:["+pmmlName+"]");
	    PmmlConfig pmmlConfig = new PmmlConfig();
	    pmmlConfig.setPmmlName(pmmlName);;
	    long num = pmmlConfigService.repeatPmmlName(pmmlConfig);
	    logger.info("num:["+num+"]");
	    if(num>0) {
	    	return JSONObject.fromObject("{\"success\":true}");
	    }
		return JSONObject.fromObject("{\"success\":false}");
    }
    
    
}
