package com.idm.app.idpconfig.proModelParaConfig.controller;

import com.idm.app.idpconfig.pmmlConfig.model.PmmlConfig;
import com.idm.app.idpconfig.proModelParaConfig.model.ProModelBaseInfo;
import com.idm.app.idpconfig.proModelParaConfig.model.ProductBaseInfo;
import com.idm.app.idpconfig.proModelParaConfig.service.ProModelConfigService;
import com.idm.app.system.login.model.IDMUser;
import com.idm.app.system.loginfo.model.SysLog;
import com.idm.common.constant.Constant;
import com.idm.common.http.HttpClient;
import com.idm.common.util.ResByPageVo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**    
 * <p>Description:产品上新增模型配置</p>  
 * <p>Company: </p>  
 * @author caiwenjian  
 * @date 2019年2月24日  
 * @version 1.0  
 */
@Controller
public class ProModelConfigController {
	
	private Logger logger = Logger.getLogger(ProductConfigController.class);
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	private static final AtomicInteger at = new AtomicInteger(0);
	
	@Value("${MODEL_URL}")
	private String MODEL_URL;
	
	/**
	 * 组装成模型编码
	 * @return
	 */
	public static synchronized String getModelCodeNo() {
		at.compareAndSet(99999, 0);
		String businessNo = String.format("%05d", at.incrementAndGet());
		return businessNo;
				
	 }
	
	@Autowired
	private ProModelConfigService proModelConfigService;
	
	/**
	 * @Description:产品模型界面请求跳转
	 * @return
	 */
	@RequestMapping("/proModel_Config")
	public String exceptionBase() {
		return "idpconfig/proModelParaConfig/proModelConfig";
	}
	
	/**
	 * @Description:自动生成模型编码，确保模型编码唯一性
	 * @param request
	 * @param response
	 * @return
	 */
	@SysLog(operate = "自动生成模型编码",module= "模型信息管理")
	@RequestMapping(value="/proModel_make_modelCode",method=RequestMethod.POST)
	@ResponseBody
	public Object makeModelCode(HttpServletRequest request,HttpServletResponse response){
		
		logger.info("******自动生成模型编码开始******");
		JSONObject jsonO = new JSONObject();
		String modelCode = "";
		String result ="success";
		try{
			boolean isPass = false;
			while(!isPass){
				modelCode = "model_"+getModelCodeNo();
				isPass = proModelConfigService.checkModelCode(modelCode);
			}
		}catch(Exception e){
			result = "error";
			logger.error("类ProModelConfigController方法makeModelCode发生Exception异常:" + e.getMessage());
		}finally{
			jsonO.put("result", result);
			jsonO.put("modelCode", modelCode);
		}
		System.out.println("jsonO="+jsonO.toString());
		logger.info("******自动生成模型编码结束******");
		return jsonO;
	}
	
	
	/**				  
	 *@Description:产品模型信息查询方法
	 *@param request
	 *@param page
	 *@param rows
	 *@return
	 */
	@SysLog(operate = "模型信息查询",module= "模型信息管理")
	@RequestMapping("/proModel_Config_query")
	@ResponseBody
	public Object queyProModelInfoConfig(HttpServletRequest request, String page,
			String rows) {
		int pageNum = Integer.parseInt(StringUtils.isNotBlank(page) ? page
				: "1");
		int pageSize = Integer.parseInt(StringUtils.isNotBlank(rows) ? rows
				: "10");
		ResByPageVo resByPageVo = null;
		try {
			request.setCharacterEncoding("utf-8");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		String orgNo = request.getParameter("orgNo");               //机构编码
		String orgName = request.getParameter("orgName");           //机构名称
		String productcode = request.getParameter("productCode");	//产品编码 
		String productname = request.getParameter("productName");	//产品名称
		String modelcode = request.getParameter("modelCode");	    //模型编码
		String modelname = request.getParameter("modelName");	    //模型名称

		logger.info(">>>productcode[" + productcode + "]");
		logger.info(">>>productname[" + productname + "]");
		logger.info(">>>modelcode[" + modelcode + "]");
		logger.info(">>>modelname[" + modelname + "]");		
		ProModelBaseInfo proModelBaseInfo = new ProModelBaseInfo();
		proModelBaseInfo.setOrgno(orgNo);
		proModelBaseInfo.setOrgname(orgName);
		proModelBaseInfo.setProductcode(productcode);
		proModelBaseInfo.setProductname(productname);
		proModelBaseInfo.setModelcode(modelcode);
		proModelBaseInfo.setModelname(modelname);
		proModelBaseInfo.setPage(pageNum);
		proModelBaseInfo.setSize(pageSize);
		int count = proModelConfigService.selectCountByAll(proModelBaseInfo);

		List<ProModelBaseInfo> proModelList = proModelConfigService
				.queryModelBaseInfo(proModelBaseInfo);
		if (proModelList != null && proModelList.size() > 0) {
			logger.info("查询成功，总记录[" + proModelList.size() + "]");
			resByPageVo = new ResByPageVo(pageSize,pageNum,count);
			resByPageVo.setRows(proModelList);
		} else if (proModelList != null && proModelList.size() == 0) {
			logger.info(">>proModel查询无记录");
			resByPageVo = new ResByPageVo(pageSize, pageNum, 0);
		} else {
			logger.info(">>proModel查询数据库错误");
			resByPageVo = new ResByPageVo(pageSize, pageNum, 0);
		}
		return JSONObject.fromObject(resByPageVo);
	}
	
	/**
	 *@Description:产品上配置新增模型，修改产品模型方法   
	 *@param request
	 *@return
	 */
	@SysLog(operate = "新增或修改模型",module= "模型信息管理")
	@RequestMapping("/proModel_Config_save")
	@ResponseBody
	public synchronized String addOrUpdateProModelInfoConfig(HttpServletRequest request) {
		logger.info("******模型信息新增或修改开始******");
		IDMUser user = (IDMUser)request.getSession().getAttribute("user");
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		String option = request.getParameter("option");
		String status = request.getParameter("status");
		String productcode = request.getParameter("productCode");	//产品编码
		String productname = request.getParameter("productName");	//产品名称
		String productid = request.getParameter("productid");	    //产品id
		String modelcode = request.getParameter("modelcode");	    //模型编码
		String modelname = request.getParameter("modelname");	    //模型名称
		/*String templatecode = request.getParameter("templateCode");	//解析模板编码
		String templatename = request.getParameter("templateName");	//解析模板名称*/
		String modeltype = request.getParameter("modelType");	    //模型类型(1-決策模型，2-pmml模型)
		String pmmlcode = request.getParameter("pmmlCode");	        //pmml编码
		String respSystemCode = request.getParameter("respSystemCode");//所属系统
		String respSystemName = request.getParameter("respSystemName");//所属系统名称

		logger.info(">>>option[" + option + "]");
		logger.info(">>>productcode[" + productcode + "]");
		logger.info(">>>productname[" + productname + "]");
		logger.info(">>>modeltype[" + modeltype + "]");
		logger.info(">>>pmmlcode[" + pmmlcode + "]");
		
		
		ProModelBaseInfo proModelBaseInfo = new ProModelBaseInfo();
		proModelBaseInfo.setProductid(productid);
		proModelBaseInfo.setProductcode(productcode);
		proModelBaseInfo.setProductname(productname);
		proModelBaseInfo.setModelcode(modelcode);
		proModelBaseInfo.setModelname(modelname);
		/*proModelBaseInfo.setTemplatecode(templatecode);
		proModelBaseInfo.setTemplatename(templatename);*/
		proModelBaseInfo.setModeltype(modeltype);
		proModelBaseInfo.setStatus(status);
		proModelBaseInfo.setUpdateuser(user.getUserId());
		proModelBaseInfo.setUpdatetime(sdf.format(new Date()));
		proModelBaseInfo.setRespSystemCode(respSystemCode);
		proModelBaseInfo.setRespSystemName(respSystemName);
		String stringModelid = request.getParameter("modelid");	//(产品)模型表ID
		//获取产品id
//		if(productcode!=null&&""!=productcode){
//			ProductBaseInfo productBaseInfo = proModelConfigService.getProductBaseInfo(productcode);
//			productid = productBaseInfo.getProductid();
//			if(productid!=null&&""!=productid){
//				 proModelBaseInfo.setProductid(productid);
//			}
//		}
		//新增模型信息功能
		if("add".equals(option)) {
			logger.info("******模型信息新增开始******");
			boolean isPass = true;
			if(modelcode!=null&&""!=modelcode){
				isPass = proModelConfigService.checkByCodeName("","",modelcode,"");
				logger.info(">>modelcode校验:"+isPass);
				if (isPass == false) {
					return "addFail";
				}
			}
			if(modelname!=null&&""!=modelname){
				isPass = proModelConfigService.checkByCodeName("","","",modelname);
				logger.info(">>modelname校验:"+isPass);
				if (isPass == false) {
					return "addFail";
				}
			}
						
			try {
				proModelBaseInfo.setCreateuser(user.getUserId());
				proModelBaseInfo.setCreatetime(sdf.format(new Date()));
				if(modeltype.equals(Constant.MODELTYPE_PMML)){	  //'2':pmml模型
					proModelBaseInfo.setPmmlcode(pmmlcode);
					proModelConfigService.addProModelInfo(proModelBaseInfo);
				}
				if(modeltype.equals(Constant.MODELTYPE_JC)){	  //'1':决策模型
					proModelBaseInfo.setPmmlcode(null);
					proModelConfigService.addProModelInfoJc(proModelBaseInfo);
				}
			} catch (IOException e) {
				logger.error(">>新增proModel发生IOException异常:" + e.getMessage());
				e.printStackTrace();
				return "addFail";
			} catch (Exception e) {
				logger.error(">>新增proModel发生Exception异常:" + e.getMessage());
				e.printStackTrace();
				return "addFail";
			}
			logger.info("******模型信息新增结束******");
		}
		//修改模型信息
		if ("update".equals(option)) {
			logger.info("******模型信息修改开始******");
			if(stringModelid!=null&&""!=stringModelid){
				proModelBaseInfo.setModelid(stringModelid);
			}
			proModelConfigService.updateProModelInfo(proModelBaseInfo);
			logger.info("******模型信息修改结束******");
		}
		
		new Thread() {
			public  void run() {
				
				JSONObject json = new JSONObject();
				JSONArray json1 = new JSONArray();
				 List<ProModelBaseInfo> pmList= proModelConfigService.queryAllModelInfo();
				 List<Map> maplist = new ArrayList();
				 for(ProModelBaseInfo pm :pmList) {
					 Map map = new HashMap();
					 map.put("modelKey", pm.getModelcode());
					 map.put("modelName", pm.getModelname());
					 maplist.add(map);
				 }
				 json1 = JSONArray.fromObject(maplist);
				 json.put("transCode", "OnlineLoans015");
				 json.put("channelNo", "001");
				 json.put("rows", json1);
				 logger.info("模型全量数据:"+json.toString());
				 String str = HttpClient.sendPost(MODEL_URL, json.toString());
				 logger.info("模型接口返回结果:"+str);
			}
		}.start();
		
		
		logger.info("******模型信息新增或修改结束******");
		return null;
	}
	
	/**
     * @Description: 根据机构代码加载产品信息
     * @param request
     * @return
     */
	@SysLog(operate = "查询产品信息",module= "模型信息管理")
    @RequestMapping("/promodel_query_product")
    @ResponseBody
    public Object queryProductInfo(HttpServletRequest request){
    	logger.info("******根据机构代码加载产品信息开始******");
    	String orgNo  = request.getParameter("orgNo");	//机构代码
	    List<ProductBaseInfo>  PBList = proModelConfigService.queryProductInfo(orgNo);
	    JSONArray json = JSONArray.fromObject(PBList);
	    logger.info("******根据机构代码加载产品信息结束******");
		return json;
    }
    
    /**
     * @Description: 根据产品编码和机构代码获取模型信息
     * @param request
     * @return
     */
	@SysLog(operate = "查询模型信息",module= "模型信息管理")
    @RequestMapping("/query_promodel_model")
    @ResponseBody
    public Object queryModelInfo(HttpServletRequest request){
		logger.info("******根据机构代码和产品编码加载模型信息开始******");
		String orgNo = request.getParameter("orgNo");               //机构编码
	    String productCode  = request.getParameter("productCode");	//产品编号
	    logger.info(">>productCode:["+productCode+"]");
	    ProModelBaseInfo proModelBaseInfo = new ProModelBaseInfo();
	    proModelBaseInfo.setOrgno(orgNo);
	    proModelBaseInfo.setProductcode(productCode);
	    List<ProModelBaseInfo>  PMList = proModelConfigService.queryModelInfo(proModelBaseInfo);
	    JSONArray json = JSONArray.fromObject(PMList);
	    logger.info("******根据机构代码和产品编码加载模型信息结束******");
		return json;
    }
    
    /**
	 * 校验模型编码和模型名称输入是否重复
	 */
	@RequestMapping("/checkModel_isExist")
	@ResponseBody
	public Object checkModelIsExist(HttpServletRequest request,HttpServletResponse response) throws FileNotFoundException {
		logger.info("******校验模型编码和名称方法开始******");
//		String orgno = request.getParameter("orgno");
//		String productcode = request.getParameter("productcode");
		String modelcode = request.getParameter("modelcode");
		String modelname = request.getParameter("modelname");

		boolean isPass = true;
//		if(productcode!=null&&""!=productcode&&modelcode!=null&&""!=modelcode){
//			isPass = proModelConfigService.checkByCodeName(orgno,productcode,modelcode,"");
//			logger.info(">>modelcode校验:"+isPass);
//		}
//		if(productcode!=null&&""!=productcode&&modelname!=null&&""!=modelname){
//			isPass = proModelConfigService.checkByCodeName(orgno,productcode,"",modelname);
//			logger.info(">>modelname校验:"+isPass);
//		}
		
		if(modelcode!=null&&""!=modelcode){
			isPass = proModelConfigService.checkByCodeName("","",modelcode,"");
			logger.info(">>modelcode校验:"+isPass);
		}
		if(modelname!=null&&""!=modelname){
			isPass = proModelConfigService.checkByCodeName("","","",modelname);
			logger.info(">>modelname校验:"+isPass);
		}
		
		logger.info("******校验模型编码和名称方法结束******");
		return JSONObject.fromObject("{\'isPass\':"+isPass+"}");
	}
	
	/**
     * @Description: 加载pmml模型编码和名称
     * @param request
     * @return
     */
    @RequestMapping("/query_pmml_model")
    @ResponseBody
    public Object queryPmmlModel(HttpServletRequest request)
    {
	    List<PmmlConfig>  TemplateList = proModelConfigService.queryPmmlModel();
	    JSONArray json = JSONArray.fromObject(TemplateList);
		return json;
    }
}
