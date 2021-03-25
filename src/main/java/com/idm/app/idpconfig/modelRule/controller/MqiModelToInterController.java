package com.idm.app.idpconfig.modelRule.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.idm.app.idpconfig.modelRule.model.InterfaceInvokInfo;
import com.idm.app.idpconfig.modelRule.model.MqiModelToInterInfo;
import com.idm.app.idpconfig.modelRule.service.InterfaceInvokService;
import com.idm.app.idpconfig.modelRule.service.MqiModelToInterService;
import com.idm.common.util.UuidUtils;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**    
 * <p>Description:模型调用接口控制层 </p>  
 * <p>Company: </p>  
 * @author pl
 * @date 2019年8月17日  
 * @version 1.0  
 */
@Controller
public class MqiModelToInterController {
	
	private Logger logger = Logger.getLogger(MqiModelToInterController.class);
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Autowired
	private MqiModelToInterService mqiModelToInterService;
	@Autowired
	private InterfaceInvokService interfaceInvokService;

	/**
	 * 
	 *@Description:拆分接口响应数据
	 *@param json
	 *@return
	 */
	@RequestMapping("/mqi_modelToInter")
	@ResponseBody
	public Object getInterfaceResp(){
		System.out.println("454fdfssdfdsffs");
		logger.info("come to &&&&&&&&&&&");
		List<InterfaceInvokInfo> mqiModelToInterInfo = interfaceInvokService.findModelToInter();
		for (InterfaceInvokInfo interfaceInvokInfo : mqiModelToInterInfo) {
			String responseContext = interfaceInvokInfo.getResponseContext();
//			String responseContext = "{\"status\":\"RDIP-000000\",\"message\":null,\"requestJson\":null,\"responseTime\":\"2019-10-10 18:29:21.219\",\"requestTime_mine\":\"2019-10-10 18:29:21.053\",\"requestGap\":166,\"data\":{\"phoneNetRiskScore\":\"-999\",\"idNumberNetRiskScore\":\"-999\"}}";
			JSONObject jsonO = (JSONObject)JSON.parseObject(responseContext);
			String interfaceCode = interfaceInvokInfo.getInterfaceCode();
			String interfaceName = interfaceInvokInfo.getInterfaceName();
			String businessNo = interfaceInvokInfo.getBusinessNo();
			
			String data = jsonO.get("data").toString();
	        //第一种方式  
	        Map maps = (Map)JSON.parse(data);  
	        for (Object map : maps.entrySet()){ 
	        	MqiModelToInterInfo resp = new MqiModelToInterInfo();
	            System.out.println(((Map.Entry)map).getKey()+"     " + ((Map.Entry)map).getValue());  
	            resp.setInterField((String)((Map.Entry)map).getKey());
	            resp.setInterValue((String)((Map.Entry)map).getValue()); 
	            resp.setBusinessNo(businessNo);
	            resp.setInterfaceCode(interfaceCode);
	            resp.setInterfaceName(interfaceName);
	            resp.setReId(UuidUtils.getRequestNo());
	            mqiModelToInterService.saveModToInter(resp);
	        }  
		}
		return "true";
	
	
	} 
	
	public static void main(String[] args) {
		MqiModelToInterService vv = new MqiModelToInterService();
		InterfaceInvokService mqiModelToInterService = new InterfaceInvokService();
		List<InterfaceInvokInfo> mqiModelToInterInfo = mqiModelToInterService.findModelToInter();
		for (InterfaceInvokInfo interfaceInvokInfo : mqiModelToInterInfo) {
			String responseContext = interfaceInvokInfo.getResponseContext();
//			String responseContext = "{\"status\":\"RDIP-000000\",\"message\":null,\"requestJson\":null,\"responseTime\":\"2019-10-10 18:29:21.219\",\"requestTime_mine\":\"2019-10-10 18:29:21.053\",\"requestGap\":166,\"data\":{\"phoneNetRiskScore\":\"-999\",\"idNumberNetRiskScore\":\"-999\"}}";
			JSONObject jsonO = (JSONObject)JSON.parseObject(responseContext);
			String interfaceCode = interfaceInvokInfo.getInterfaceCode();
			String interfaceName = interfaceInvokInfo.getInterfaceName();
			String businessNo = interfaceInvokInfo.getBusinessNo();
			
			String data = jsonO.get("data").toString();
	        //第一种方式  
	        Map maps = (Map)JSON.parse(data);  
	        for (Object map : maps.entrySet()){ 
	        	MqiModelToInterInfo resp = new MqiModelToInterInfo();
	            System.out.println(((Map.Entry)map).getKey()+"     " + ((Map.Entry)map).getValue());  
	            resp.setInterField((String)((Map.Entry)map).getKey());
	            resp.setInterValue((String)((Map.Entry)map).getValue()); 
	            resp.setBusinessNo(businessNo);
	            resp.setInterfaceCode(interfaceCode);
	            resp.setInterfaceName(interfaceName);
	            vv.saveModToInter(resp);
	        }  
		}
	}
	
   
}
