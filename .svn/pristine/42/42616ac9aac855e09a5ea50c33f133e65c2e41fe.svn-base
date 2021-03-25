package com.idm.app.idpconfig.eventconfig.controller;

import java.io.UnsupportedEncodingException;
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

import com.idm.app.idpconfig.eventconfig.model.EventConfig;
import com.idm.app.idpconfig.eventconfig.model.InterfaceInfo;
import com.idm.app.idpconfig.eventconfig.service.EventConfigService;
import com.idm.app.idpconfig.proModelParaConfig.model.ParaBaseInfo;
import com.idm.app.idpconfig.proModelParaConfig.model.ProModelBaseInfo;
import com.idm.app.idpconfig.proModelParaConfig.model.ProductBaseInfo;
import com.idm.app.system.auth.model.Organization;
import com.idm.app.system.login.model.IDMUser;
import com.idm.app.system.loginfo.model.SysLog;
import com.idm.common.util.ResByPageVo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


/**
 * 
 *<p>Title: EventConfigController</p>  
 * @Description: 
 * @author 黄百超
 * @date 2019年2月25日
 * @version  1.0
 *
 */
@Controller
public class EventConfigController {
	
    private Logger logger = Logger.getLogger(EventConfigController.class);
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Autowired
    private  EventConfigService eventConfigService;
    
    @RequestMapping("/event_config")
    public String eventConfig(Model model)
    {
        return "idpconfig/eventConfig/eventConfig";
    }

    /**
     * 
     * @Description: 查询决策请求信息方法
     * @param request
     * @return
     */
    @RequestMapping("/event_query")
    @ResponseBody
    @SysLog(operate="查询决策请求信息",module="决策请求")
    public Object eventQuery(HttpServletRequest request)
    {
    	logger.info("******决策请求查询开始******");
        String eventName = request.getParameter("eventName");		//事件名称
        String modelName = request.getParameter("modelName");	//产品名称
        String productName = request.getParameter("productName");	//产品名称
    	int page =Integer.parseInt(request.getParameter("page"));
		int size = Integer.parseInt(request.getParameter("rows"));
        
        ResByPageVo resByPageVo = null;
		try {
			if (eventName != null && eventName != "") {
				eventName = java.net.URLDecoder.decode(eventName, "UTF-8");
			}
			if (productName != null && productName != "") {
				productName = java.net.URLDecoder.decode(productName, "UTF-8");
			}
			if (modelName != null && modelName != "") {
				modelName = java.net.URLDecoder.decode(modelName, "UTF-8");
			}
			logger.info("eventName:["+eventName+"]");
	        logger.info("productName:["+productName+"]");
	        logger.info("modelName:["+modelName+"]");
	        
	        EventConfig eventConfig = new EventConfig();
	        eventConfig.setEventName(eventName);
	        eventConfig.setProductName(productName);
	        eventConfig.setModelName(modelName);
	        eventConfig.setPage(page);
	        eventConfig.setSize(size);
			resByPageVo = new ResByPageVo(size, page,eventConfigService.selectCountByAll(eventConfig));
			resByPageVo.setRows(eventConfigService.queryEventConfig(eventConfig));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        
        logger.info("******决策请求查询结束******");
        return JSONObject.fromObject(resByPageVo);
    }
    
    /**
          * 事件入口配置新增保存方法
          * 黄百超
     * 2019-02-23
     * @param request
     * @return
     */
    @RequestMapping("/event_save")
    @ResponseBody
    @SysLog(operate="新增或修改",module="决策请求")
    public synchronized String addOrUpdateEventConfig(HttpServletRequest request)
    {
    	logger.info("******事件新增/修改开始******");
    	String option  = request.getParameter("option");					//方法类型
    	String eventId  = request.getParameter("eventId");						//id
        String eventName  = request.getParameter("eventName");				//事件名称
        String respSystemCode = request.getParameter("respSystemCode");		//子系统编码
        String respSystemName = request.getParameter("respSystemName");		//子系统名称
        String orgNo= request.getParameter("orgNo");						//法人编码
        String orgName= request.getParameter("orgName");					//法人行
        String productId =request.getParameter("productId");				//产品ID
        String productName= request.getParameter("productName");			//产品名称
        String modelId = request.getParameter("modelId");					//模型ID
        String modelName = request.getParameter("modelName");				//模型名称
        String interfaceCode  =request.getParameter("interfaceCode");		//数据源
        String status  =request.getParameter("status");						//状态位

        logger.info("eventId:["+eventId+"]");
        logger.info("option:["+option+"]");
        logger.info("eventName:["+eventName+"]");
        logger.info("respSystemCode:["+respSystemCode+"]");
        logger.info("orgNo:["+orgNo+"]");
        logger.info("productId:["+productId+"]");
        logger.info("modelId:["+modelId+"]");
        logger.info("interfaceCode:["+interfaceCode+"]");
        
        IDMUser user = (IDMUser)request.getSession().getAttribute("user");
        EventConfig eventConfig = new EventConfig();
        eventConfig.setEventId(eventId);;
        eventConfig.setEventName(eventName);
        eventConfig.setRespSystemCode(respSystemCode);
        eventConfig.setRespSystemName(respSystemName);
        eventConfig.setOrgNo(orgNo);
        eventConfig.setOrgName(orgName);
        eventConfig.setProductId(productId);
        eventConfig.setModelId(modelId);
        eventConfig.setInterfaceCode(interfaceCode);
        eventConfig.setCreateTime(sdf.format(new Date()));
        eventConfig.setCreateUser(user.getUserId());
        eventConfig.setUpdateTime(sdf.format(new Date()));
        eventConfig.setUpdateUser(user.getUserId());
        eventConfig.setStatus(status);
        //新增与更新分别处理
        if("add".equals(option))
        {
            try {
            	eventConfigService.addEventConfig(eventConfig);
            } catch (Exception e) {
                logger.error(e.getMessage());
                logger.info("******事件新增/修改结束******");
                return "添加数据失败";
            }
        }
        if("update".equals(option))
        {
        	try {
				eventConfigService.updateEventConfig(eventConfig);
			} catch (Exception e) {
				 logger.error(e.getMessage());
				 logger.info("******事件新增/修改结束******");
	             return "更新数据失败";
			}
        }
        logger.info("******事件新增/修改结束******");
        return null;
    }
    /**
     * 
     * @Description: 获取产品信息
     * @param request
     * @return
     */
    @RequestMapping("/query_event_product")
    @ResponseBody
    public Object queryProductInfo(HttpServletRequest request)
    {
    List<ProductBaseInfo>  PBList = eventConfigService.queryProductInfo();
    JSONArray json = JSONArray.fromObject(PBList);
	return json;
    }
    /**
     * 
     * @Description: 根据产品编码获取模型信息
     * @param request
     * @return
     */
    @RequestMapping("/query_event_model")
    @ResponseBody
    public Object queryModelInfo(HttpServletRequest request)
    {
    String respSystemCode  = request.getParameter("respSystemCode");	//系统编号
    logger.info("respSystemCode:["+respSystemCode+"]");
    ProModelBaseInfo proModelBaseInfo = new ProModelBaseInfo();
    proModelBaseInfo.setRespSystemCode(respSystemCode);
    List<ProModelBaseInfo>  PMList = eventConfigService.queryModelInfo(proModelBaseInfo);
    JSONArray json = JSONArray.fromObject(PMList);
	return json;
    }
    
    /**
     * 
     * @Description: 获取数据源信息
     * @param request
     * @return
     */
    @RequestMapping("/query_event_interface")
    @ResponseBody
    public Object queryInterfaceInfo(HttpServletRequest request)
    {
    List<InterfaceInfo>  IIist = eventConfigService.queryInterfaceInfo();
    JSONArray json = JSONArray.fromObject(IIist);
	return json;
    }
    
    /**
     * 
     * @Description: 名称查重
     * @param request
     * @return
     */
    @RequestMapping("/repeat_event_name")
    @ResponseBody
    public Object repeatEventName(HttpServletRequest request)
    {
	    String eventName  = request.getParameter("eventName");				//决策点名称
	    logger.info("eventName:["+eventName+"]");
	    EventConfig eventConfig = new EventConfig();
	    eventConfig.setEventName(eventName);
	    long num = eventConfigService.repeatEventName(eventConfig);
	    logger.info("num:["+num+"]");
	    if(num>0) {
	    	return JSONObject.fromObject("{\"success\":true}");
	    }
		return JSONObject.fromObject("{\"success\":false}");
    }
    
    /**
     * 
     * @Description: 模型查重
     * @param request
     * @return
     */
    @RequestMapping("/repeat_model")
    @ResponseBody
    public Object repeatModel(HttpServletRequest request)
    {
	    String modelId  = request.getParameter("modelId");				//模型ID
	    logger.info("modelId:["+modelId+"]");
	    EventConfig eventConfig = new EventConfig();
	    eventConfig.setModelId(modelId);;
	    long num = eventConfigService.repeatModel(eventConfig);
	    logger.info("num:["+num+"]");
	    if(num>0) {
	    	return JSONObject.fromObject("{\"success\":true}");
	    }
		return JSONObject.fromObject("{\"success\":false}");
    }
    /**
     * 
     * @Description: 获取机构（法人行）信息
     * @param request
     * @return
     */
    @RequestMapping("/query_event_org")
    @ResponseBody
    public Object queryOrgInfo(HttpServletRequest request)
    {
    List<Organization>  PBList = eventConfigService.queryOrgInfo();
    JSONArray json = JSONArray.fromObject(PBList);
	return json;
    }
}
