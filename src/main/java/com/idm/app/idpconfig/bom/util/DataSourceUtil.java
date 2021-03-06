package com.idm.app.idpconfig.bom.util;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.idm.app.idpconfig.bom.model.Field;
import com.idm.app.idpconfig.bom.service.BomInfoService;
import com.idm.app.idpconfig.eventconfig.model.InterfaceInfo;
import com.idm.common.http.HttpClient;
import com.idm.common.util.DateTools;
import com.idm.common.util.IPUtil;

/**
 * 
 *<P>Title:DataSourceUtil</P>
 *@Description:获取接口平台数据源接口信息和字段层级结构工具类
 *@author wangchunzhi
 *@date 2019年5月15日
 *@version 1.0
 */
@Controller
public class DataSourceUtil {
	static Logger logger =Logger.getLogger(DataSourceUtil.class);
	/**
	 * 
	 *@Description:组装获取接口平台数据源接口和字段的接口参数
	 *@param jSONObject
	 *@param interfaceInfo
	 *@param callNo
	 *@return
	 */
	public static String getInterfaceJson(String loginName){
		logger.info("***********组装数据源信息同步报文开始***********");
		 Object json =JSON.parse("{}");
		 JSONObject requestJson = (JSONObject)json;
		 try {
			 requestJson.put("requestId",SeriesNumberHelper.getRequestId());
			 requestJson.put("loginName", loginName);
			 requestJson.put("dataflowCode", "");
			 requestJson.put("sysCode", "IDP");
			 requestJson.put("sysName", "智能决策平台");
			 requestJson.put("IP",IPUtil.getServerIp());
			 requestJson.put("requestTime",DateTools.getSysDateTime());
		} catch (Exception e) {
			logger.error("组装接口平台接口请求报文错误"+e);
		}
		 logger.info("***********组装数据源信息同步报文结束***********");
		return requestJson.toString();
	}
	/**
	 * 
	 *@Description:调用接口平台的方法
	 *@return
	 */
	
	public boolean sendToInterfaceP(String url,BomInfoService bomInfoService,String loginName){
		logger.info("***********调用接口平台数据源信息同步接口开始***********");	
		String req=getInterfaceJson(loginName);
		String response=null;
		logger.info("***********调用接口平台数据源信息同步接口请求报文为***********"+req);
		try {
			response=HttpClient.sendPost(url,req);
			logger.info("***********调用接口平台数据源信息同步接口返回报文为***********"+response);
			if(response!=null&&!"".equals(response)){
				//根据接口平台的返回报文再做处理
				JSONObject respJson=JSON.parseObject(response);
				String errorCode=respJson.getString("status");
				String errorMsg=respJson.getString("message");
				if("RDIP-000000".equals(errorCode)){
					logger.info("***********调用接口平台数据源信息同步接口成功***********");
					analysisData(response,bomInfoService);
					return true;
				}else{
					logger.error("接口平台内部错误");
				}
			}else{
				logger.error("接口平台返回报文为空");
			}
		} catch (UnknownHostException e){
			e.printStackTrace();
			logger.error("未知的接口平台地址");
		}catch (ConnectException e){
			e.printStackTrace();
			logger.error("调用接口平台连接超时");
		}catch (SocketTimeoutException e){
			e.printStackTrace();
			logger.error("调用接口平台时接收数据超时");
		}catch (JSONException e) {
			e.printStackTrace();
			logger.error("调用接口平台返回报文格式错误");
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("调用接口平台同步数据失败");
		}
		logger.info("***********调用接口平台数据源信息同步接口结束***********");
		return false;
	}
	/**
	 * 
	 *@Description:解析接口平台返回的数据源接口和字段信息
	 *@param response
	 */
	public  void analysisData(String response,BomInfoService bomInfoService) throws Exception{
		List<Field> fields=new ArrayList<Field>();
		List<InterfaceInfo> interList=new ArrayList<InterfaceInfo>();
		Object json = JSON.parse(JSON.parseObject(response).getString("data"));
		if(json instanceof JSONArray){
			JSONArray array=(JSONArray)json;
			for (int i = 0; i < array.size(); i++) {
				JSONObject jsonObject=(JSONObject)array.get(i);
				InterfaceInfo interfaceInfo=new InterfaceInfo();
				interfaceInfo.setInterfaceId(UUIDHelper.getUUID());
				interfaceInfo.setSysId("RDIP");
				interfaceInfo.setCreateTime(DateTools.getSysDate());
				interfaceInfo.setStatus("0");
				//获取接口编码
				interfaceInfo.setInterfaceCode(jsonObject.getString("dataflowCode"));
				//获取接口中文
				interfaceInfo.setInterfaceName(jsonObject.getString("dataflowText"));
				//获取接口参数
				String  parameters=getParameters(jsonObject.get("inputParams"));
				interfaceInfo.setParameters(parameters);
				//获取接口返回字段
				interList.add(interfaceInfo);
				fields.addAll(getFields(jsonObject.get("outputParams"),jsonObject.getString("dataflowCode")));
			}
		}else if(json instanceof JSONObject){
			JSONObject jsonObject=(JSONObject)json;
			InterfaceInfo interfaceInfo=new InterfaceInfo();
			interfaceInfo.setInterfaceId(UUIDHelper.getUUID());
			interfaceInfo.setSysId("RDIP");
			interfaceInfo.setCreateTime(DateTools.getSysDate());
			interfaceInfo.setStatus("0");
			//获取接口编码
			interfaceInfo.setInterfaceCode(jsonObject.getString("dataflowCode"));
			//获取接口中文
			interfaceInfo.setInterfaceName("接口中文名");
			//获取接口参数
			String  parameters=getParameters(jsonObject.get("inputParams"));
			interfaceInfo.setParameters(parameters);
			//获取接口返回字段
			interList.add(interfaceInfo);
			fields.addAll(getFields(jsonObject.get("outputParams"),jsonObject.getString("dataflowCode")));
			
		}else{
			logger.info("***********调用接口平台数据源信息同步接口返回报文格式错误***********");
		}
		bomInfoService.updateFieldStatus();
		for (Field field : fields) {
			if(field.getFieldType()==null){
				logger.info("未配置字段类型#####"+field.getFatherNode());
				logger.info("未配置字段类型#####"+field.getFieldName());
			}
			bomInfoService.addField(field);
		}
		logger.info("***********存储字段信息完成***********");
		for (InterfaceInfo interfaceInfo : interList) {
			if(interfaceInfo.getParameters()!=null&&!"".equals(interfaceInfo.getParameters())){
				logger.info("配置完成#####"+interfaceInfo.getInterfaceCode());
			}else{
				interfaceInfo.setParameters("NA");
			}
		}
		bomInfoService.updateInterfaceInfoStatus();
		for (InterfaceInfo interfaceInfo : interList) {
			bomInfoService.addInterfaceInfo(interfaceInfo);
		}
		logger.info("***********存储接口信息完成***********");
		
	}
	/**
	 * 
	 *@Description:获取数据源接口的入参字段方法
	 *@param ob
	 *@return
	 */
	public static String getParameters(Object ob) throws Exception{
		String str="";
			if(ob instanceof JSONArray){
				JSONArray paarray=(JSONArray)ob;
				for (int i = 0; i < paarray.size(); i++) {
					JSONObject pa=(JSONObject)paarray.get(i);
					if(i<paarray.size()-1){
						str+=pa.getString("code")+":"+pa.getString("fieldType")+",";	
					}else{
						str+=pa.getString("code")+":"+pa.getString("fieldType");
					}
				}
			}else if(ob instanceof JSONObject){
				JSONObject pa=(JSONObject)ob;
				pa.getString("code");
				str=pa.getString("code")+":"+pa.getString("fieldType");
			}
		return str;
	}
	/**
	 * 
	 *@Description:解析每个接口的返回字段明细
	 *@param object
	 *@param dataflowCode
	 *@return
	 *@throws Exception
	 */
	public static List<Field> getFields(Object object,String dataflowCode) throws Exception{
		List<Field> fieldlist=new ArrayList<Field>();
		if(object!=null){
			JSONArray outarray=(JSONArray)object;
			logger.info("需要解析返回字段明细的接口名："+dataflowCode);
			JSONObject outobj=(JSONObject)outarray.get(0);
			Object ob=outobj.get("children");
			if(ob instanceof JSONArray){
				JSONArray paarray=(JSONArray)ob;
				for (int i = 0; i < paarray.size(); i++) {
					JSONObject pa=(JSONObject)paarray.get(i);
					Field field=new Field();
					field.setFieldId(UUIDHelper.getUUID());
					field.setFatherNode(dataflowCode);
					field.setStatus("0");
					field.setFieldName(pa.getString("code"));
					field.setFieldType(pa.getString("fieldType"));
					field.setInterfaceCode(dataflowCode);
					field.setFieldText(pa.getString("text"));
					field.setIsChildNode("N");
					field.setCreateTime(DateTools.getSysDate());
					fieldlist.add(field);
				}
				
			}else if(ob instanceof JSONObject){
				JSONObject pa=(JSONObject)ob;
				Field field=new Field();
				field.setFieldId(UUIDHelper.getUUID());
				field.setFatherNode(dataflowCode);
				field.setStatus("0");
				field.setFieldName(pa.getString("code"));
				field.setFieldType(pa.getString("fieldType"));
				field.setInterfaceCode(dataflowCode);
				field.setFieldText(pa.getString("text"));
				field.setIsChildNode("N");
				fieldlist.add(field);
			}
		}
		return fieldlist;
		
	}
}
