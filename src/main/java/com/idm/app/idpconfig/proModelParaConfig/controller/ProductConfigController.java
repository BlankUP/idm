package com.idm.app.idpconfig.proModelParaConfig.controller;

import com.idm.app.idpconfig.proModelParaConfig.model.ProToOrgInfo;
import com.idm.app.idpconfig.proModelParaConfig.model.ProductBaseInfo;
import com.idm.app.idpconfig.proModelParaConfig.service.ProductConfigService;
import com.idm.app.system.auth.model.Organization;
import com.idm.app.system.login.model.IDMUser;
import com.idm.app.system.loginfo.model.SysLog;
import com.idm.common.util.ResByPageVo;
import com.idm.config.resubmit.repeat_form_validator.SameUrlData;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**    
 * <p>Description:上游系统产品可配置界面 </p>  
 * <p>Company: </p>  
 * @author caiwenjian  
 * @date 2019年2月21日  
 * @version 1.0  
 */
@Controller
public class ProductConfigController {
	private Logger logger = Logger.getLogger(ProductConfigController.class);
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static final AtomicInteger at = new AtomicInteger(0);
	@Autowired
	private ProductConfigService productConfigService;
	
	/**
	 * 组装成产品编码
	 * @return
	 */
	public static synchronized String getProductCodeNo() {
		at.compareAndSet(99999, 0);
		String businessNo = String.format("%05d", at.incrementAndGet());
		return businessNo;
				
	 }
	
	/**
	 *@Description:请求跳转到界面 
	 *@return
	 */
	
	@RequestMapping("/product_Config")
	
	public String exceptionBase() {
		return "idpconfig/proModelParaConfig/productConfig";
	}
	
	/**
	 * @Description:获取orgno='0'的所有机构
	 * @return
	 */
	@SysLog(operate = "查询机构信息",module= "产品信息管理")
	@RequestMapping(value="/query_allorganization",method=RequestMethod.POST)
	@ResponseBody
	public Object getOrganizations(){
		logger.info("******获取机构信息开始******");
		List<Organization> list = productConfigService.getAllOrganization();
		JSONArray json = JSONArray.fromObject(list);
		logger.info("******获取机构信息结束******");
		return json;
	}
	
	@RequestMapping(value="/query_organization",method=RequestMethod.POST)
	@ResponseBody
	public Object getCorporsteInfo(HttpServletRequest request){
		logger.info("******获取机构信息开始******");
		String productCode = request.getParameter("productCode");
		logger.info(">>>productCode[" + productCode + "]");
		ProToOrgInfo ProToOrgInfo = new ProToOrgInfo();
		ProToOrgInfo.setProductCode(productCode);
		List<Organization> list = productConfigService.getOrganization(ProToOrgInfo);
		JSONArray json = JSONArray.fromObject(list);
		logger.info("******获取机构信息结束******");
		return json;
	}
	
	/**
	 * @Description:自动生成产品编码方法 
	 * @param request
	 * @param response
	 * @return
	 */
	@SysLog(operate = "自动生成产品编码",module= "产品信息管理")
	@RequestMapping(value="/make_productCode",method=RequestMethod.POST)
	@ResponseBody
	public synchronized Object makeProductCode(HttpServletRequest request,HttpServletResponse response){
		logger.info("******自动生成产品编码开始******");
		JSONObject jsonO = new JSONObject();
		String productCode = "";
		String result ="success";
		try{
			boolean isPass = false;
			while(!isPass){
				productCode = "product_"+getProductCodeNo();
				isPass = productConfigService.checkByCodeName(productCode,null);
			}
		}catch(Exception e){
			result = "error";
			logger.error("类ProductConfigController方法makeProductCode发生Exception异常:" + e.getMessage());
		}finally{
			jsonO.put("result", result);
			jsonO.put("productCode", productCode);
		}
		logger.info("******自动生成产品编码结束******");
		return jsonO;
	}
	
	/**
	 * @Description:产品可配置界面查询方法
	 * @param request
	 * @param page
	 * @param rows
	 * @return
	 */
	@SysLog(operate = "查询产品",module= "产品信息管理")
	@RequestMapping("/product_Config_query")
	@ResponseBody
	public Object queyProdcutInfoConfig(HttpServletRequest request, String page, String rows) {
		logger.info("******产品模型界面产品信息查询开始******");
		int pageNum = Integer.parseInt(StringUtils.isNotBlank(page) ? page: "1");
		int pageSize = Integer.parseInt(StringUtils.isNotBlank(rows) ? rows: "10");	
		String productcode = request.getParameter("productCode");
		String productname = request.getParameter("productName");
		String orgNo = request.getParameter("orgNo");
		String orgName = request.getParameter("orgName");
		logger.info(">>>errCode[" + productcode + "]");
		logger.info(">>>errMsg[" + productname + "]");
		ProductBaseInfo prodcutBaseInfo = new ProductBaseInfo();
		prodcutBaseInfo.setOrgno(orgNo);
		prodcutBaseInfo.setOrgname(orgName);
		prodcutBaseInfo.setProductcode(productcode);
		prodcutBaseInfo.setProductname(productname);
		prodcutBaseInfo.setPage(pageNum);
		prodcutBaseInfo.setSize(pageSize);
		int count = productConfigService.selectCountByAll(prodcutBaseInfo);
		
		List<ProductBaseInfo> productList = productConfigService
				.queryAllProdcutInfo(prodcutBaseInfo);
		ResByPageVo resByPageVo = new ResByPageVo(pageSize, pageNum, count);
		if (productList != null && productList.size() > 0) {
			logger.info("查询product产品信息成功，总记录[" + count + "]");
			resByPageVo.setRows(productList);
		} else if (productList != null && productList.size() == 0) {
			logger.info(">>product产品信息查询无记录");
			resByPageVo = new ResByPageVo(pageSize, pageNum, 0);
		} else {
			logger.info(">>product产品信息数据库错误");
			resByPageVo = new ResByPageVo(pageSize, pageNum, 0);
			logger.info(">>product数据库错误");
		}
		logger.info("******产品模型界面产品信息查询结束******");
		return JSONObject.fromObject(resByPageVo);
	}
	
	/**
	 * @Description:产品信息-新增和修改方法
	 * @param request
	 * @return
	 */
	@SameUrlData
	@SysLog(operate = "新增或修改产品信息",module= "产品信息管理")
	@RequestMapping("/product_Config_save")
	@ResponseBody	
	public String addOrUpdateModelInfoConfig(HttpServletRequest request) {
		logger.info("******产品信息-新增和修改方法开始******");
		IDMUser user = (IDMUser)request.getSession().getAttribute("user");
		String option = request.getParameter("option");
		String status = request.getParameter("status");
		String orgno = request.getParameter("orgno");               //机构编码
		String productcode = request.getParameter("productcode");	//产品编码
		String productname = request.getParameter("productname");	//产品名称
		String productdes = request.getParameter("productdes");	    //产品详细信息
		String productid = request.getParameter("productid");	    //产品表ID
		
		logger.info(">>>productid[" + productid + "]");
		logger.info(">>>orgno[" + orgno + "]");
		logger.info(">>>productname[" + productname + "]");
		logger.info(">>>productname[" + productname + "]");
		
		String[] orgArray = orgno.split(",");
		
		
	
			ProductBaseInfo prodcutBaseInfo = new ProductBaseInfo();
			prodcutBaseInfo.setProductcode(productcode);
			prodcutBaseInfo.setProductname(productname);
			prodcutBaseInfo.setProductdes(productdes);;
			prodcutBaseInfo.setStatus(status);
			prodcutBaseInfo.setUpdateuser(user.getUserId());
			prodcutBaseInfo.setUpdatetime(sdf.format(new Date()));
			//新增功能
			if ("add".equals(option)) {
				try {
					prodcutBaseInfo.setCreateuser(user.getUserId());
					prodcutBaseInfo.setCreatetime(sdf.format(new Date()));
					productConfigService.addProductInfo(prodcutBaseInfo);
					logger.info("******产品新增方法结束******");
				} catch (Exception e) {
					e.printStackTrace();
					logger.error(">>>新增product产品信息发生异常:" + e.getMessage());
					return "添加数据失败";
				}
			}
			//修改功能
			if ("update".equals(option)) {
				try {
//					if(productid!=null&&""!=productid){
//						prodcutBaseInfo.setProductid(productid);
//					}
//					prodcutBaseInfo.setUpdateuser(user.getUserId());
//					prodcutBaseInfo.setUpdatetime(sdf.format(new Date()));
//					productConfigService.updateProductInfo(prodcutBaseInfo);
					ProToOrgInfo ProToOrgInfo = new ProToOrgInfo();
					ProToOrgInfo.setProductCode(productcode);
					productConfigService.delProToCorInfo(ProToOrgInfo);
					for(int i = 0 ; i < orgArray.length ; i++) {
						ProToOrgInfo.setOrgNo(orgArray[i]);
						productConfigService.addProToCorInfo(ProToOrgInfo);
					}
				} catch (Exception e) {
					e.printStackTrace();
					logger.error(">>>修改product产品信息方法发生异常:" + e.getMessage());
					return "修改数据失败";
				}
			}
		
	
		logger.info("******产品信息-新增和修改方法结束******");
		return null;
	}
	
	/**
	 * @Description:校验产品名称和产品编码是否重复
	 * @param request
	 * @param response
	 * @return
	 * @throws FileNotFoundException
	 */
	@RequestMapping("/checkProduct_isExist")
	@ResponseBody
	public Object checkProductIsExist(HttpServletRequest request,HttpServletResponse response) throws FileNotFoundException {
		logger.info("******校验产品编码和名称方法开始******");
		String productcode = request.getParameter("productcode");
		String productname = request.getParameter("productname");
		boolean isPass = true;
		if(productcode!=null&&""!=productcode){
			isPass = productConfigService.checkByCodeName(productcode,null);
			logger.info(">>productcode校验-"+productcode+":"+isPass);
		}
		if(productname!=null&&""!=productname){
			isPass = productConfigService.checkByCodeName(null,productname);
			logger.info(">>productname校验-"+productname+":"+isPass);
		}
		
		logger.info("******校验产品编码和名称方法结束******");
		return JSONObject.fromObject("{\'isPass\':"+isPass+"}");
	}
	
}
