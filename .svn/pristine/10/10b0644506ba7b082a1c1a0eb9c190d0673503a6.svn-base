package com.idm.app.system.mqibasicdataconfig.controller;

import net.sf.json.JSONObject;




import com.idm.app.system.login.model.IDMUser;
import com.idm.app.system.loginfo.model.SysLog;
import com.idm.app.system.mqibasicdataconfig.model.MqiParamsCfg;
import com.idm.app.system.mqibasicdataconfig.service.MqiBasicDataConfigService;

import org.apache.log4j.Logger;
import com.idm.common.util.ResByPageVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;

import java.text.SimpleDateFormat;
import java.util.Date;
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
public class MqiBasicDataConfigController {

    private Logger logger = Logger.getLogger(MqiBasicDataConfigController.class);
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private  MqiBasicDataConfigService mqibasicDataConfigService;

    @RequestMapping("/mqi_basic_data_config")
    public String basicDataConfig(Model model)
    {
        return "mqibasicDataConfig";
    }
    
    
    /**
     * 
     * @Description: 查询方法
     * @param request
     * @return
     */
    @RequestMapping("mqi_basic_data_query")
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
 

        MqiParamsCfg mqiParamsCfg = new MqiParamsCfg();
        mqiParamsCfg.setParamCode(paramCode);
        mqiParamsCfg.setParamName(paramName);
        mqiParamsCfg.setParamType(paramType);
        mqiParamsCfg.setStatus(paramStatus);
        mqiParamsCfg.setPage(page);
        mqiParamsCfg.setSize(size);
        
        int count = mqibasicDataConfigService.selectCountByAll(mqiParamsCfg);
		
		List<MqiParamsCfg> list = mqibasicDataConfigService.queryBasicDataConfig(mqiParamsCfg);
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
    @RequestMapping("/mqi_basic_data_save")
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
        MqiParamsCfg mqiParamsCfg  = new MqiParamsCfg();
        mqiParamsCfg.setParamCode(paramCode);
        mqiParamsCfg.setParamName(paramName);
        mqiParamsCfg.setParamValue(paramValue);
        mqiParamsCfg.setParamType(paramType);
        mqiParamsCfg.setParamDesc(paramDesc);
        mqiParamsCfg.setStatus(status);
        mqiParamsCfg.setCreateTime(sdf.format(new Date()));
        mqiParamsCfg.setCreateUser(user.getUserId());
        mqiParamsCfg.setUpdateTime(sdf.format(new Date()));
        mqiParamsCfg.setUpdateUser(user.getUserId());
        if("add".equals(option))
        {
            try {
            	mqibasicDataConfigService.addBasicData(mqiParamsCfg);
            } catch (Exception e) {
                logger.error(e.getMessage());
                return "添加数据失败";
            }
        }
        if("update".equals(option))
        {
        	mqibasicDataConfigService.updateBasicData(mqiParamsCfg);
        }
        logger.info("******线程数据配置新增或修改方法结束******");
        return null;
    }
    


}
