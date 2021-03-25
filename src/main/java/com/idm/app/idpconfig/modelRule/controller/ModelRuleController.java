package com.idm.app.idpconfig.modelRule.controller;

import com.idm.app.idpconfig.modelRule.model.ModelRuleInfo;
import com.idm.app.idpconfig.modelRule.service.InterfaceInvokService;
import com.idm.app.idpconfig.modelRule.service.ModelRuleService;
import com.idm.app.system.login.model.IDMUser;
import com.idm.app.system.loginfo.model.SysLog;
import com.idm.common.util.ExcelExport;
import com.idm.common.util.ResByPageVo;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**    
 * <p>Description:模型规则控制类 </p>  
 * <p>Company: </p>  
 * @author pl
 * @date 2019年8月17日  
 * @version 1.0  
 */
@Controller
public class ModelRuleController {
	
	private Logger logger = Logger.getLogger(ModelRuleController.class);
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Autowired
	private ModelRuleService modelRuleService;

	@Autowired
	private InterfaceInvokService interfaceInvokService;
	
	@Value("${ruleNamepath}")
	private String ruleNamepath;      //导入规则信息Excel文件路径
	
	@Value("${rulemoBanName}")
	private String rulemoBanName;     //规则信息Excel模板路径
	
	@Value("${modelRuleName}")
	private String modelRuleName;     //模型规则信息Excel模板名称
	
	
	/**
	 * 参数字段配置界面请求跳转 
	 *@return
	 */
	@RequestMapping("/modelrule")
	public String exceptionBase() {
		return "idpconfig/rule/rule";
	}
	
	/**
	 * 查询参数字段信息
	 *@param request
	 *@param page
	 *@param rows
	 *@return
	 */
	@SysLog(operate = "查询模型规则信息",module= "模型规则配置")
	@RequestMapping("/modelrule_query")
	@ResponseBody
	public Object queyParaInfoConfig(HttpServletRequest request) {
		
		logger.info("***********查询模型规则信息方法开始***************");
		
		int page = Integer.parseInt(request.getParameter("page"));
		int size = Integer.parseInt(request.getParameter("rows"));
		String modelcode = request.getParameter("modelcode");
		String modelname = request.getParameter("modelname");
		logger.info(">>>modelCode参数字段[" + modelcode + "]");
		logger.info(">>>modelName参数字段中文[" + modelname + "]");
		
		ModelRuleInfo mrInfo = new ModelRuleInfo();
		mrInfo.setModelcode(modelcode);	//模型编码
		mrInfo.setModelname(modelname);//模型名称
		mrInfo.setPage(page);
		mrInfo.setSize(size);
		int count = modelRuleService.selectCountByAll(mrInfo);
		//查询参数字段表信息
		List<ModelRuleInfo> paraList = modelRuleService.queryPatameteFieldsInfo(mrInfo);
		ResByPageVo resByPageVo = new ResByPageVo(size, page, count);
		if (paraList != null && paraList.size() > 0) {
			logger.info("查询modelRule参数字段信息成功，总记录[" + count + "]");
			resByPageVo.setRows(paraList);
		} else if (paraList != null && paraList.size() == 0) {
			logger.info(">>modelRule参数字段无记录");
			resByPageVo = new ResByPageVo(size, page, 0);
		} else {
			logger.info(">>modelRule参数字段数据库错误");
			resByPageVo = new ResByPageVo(size, page, 0);
		}
		logger.info("**********查询参数字段信息方法结束***********");
		return JSONObject.fromObject(resByPageVo);
	}
	

	/**
	 * Description 实现excel文件导入
	 * @param fileUpload
	 * @param request
	 * @return
	 */
	@SysLog(operate="导入模型规则信息Excel",module="模型规则配置")
	@RequestMapping(value="/modelrule_import",method=RequestMethod.POST)
	@ResponseBody
    public Object importExcelModelRuleData(@RequestParam("file") MultipartFile fileUpload,HttpServletRequest request){
		
		logger.info("******导入模型规则信息Excel功能importExcelModelRuleData方法开始******");
		JSONObject jsonO = new JSONObject();
		String message = "";
		
		IDMUser user = (IDMUser)request.getSession().getAttribute("user");        //获取当前用户
		File ruleName = null;
        try {
        	//1、获取文件信息，并创建文件夹
        	String name= fileUpload.getOriginalFilename();                            //获取文件名称
        	String subffix = name.substring(name.lastIndexOf(".") + 1, name.length());//获取文件后缀
        	String fileName = user.getUserId()+"_"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        	String filepath1 = ruleNamepath+"/"+new SimpleDateFormat("yyyyMMdd").format(new Date());
        	File fileMuLu=new File(filepath1);
        	if(!fileMuLu.exists()){//目录不存在就创建
        		fileMuLu.mkdirs();
        	}
        	
        	//2、保存上传Excel文件到指定文件夹中
        	ruleName = new File(fileMuLu+File.separator+fileName+"."+subffix);
			fileUpload.transferTo(ruleName);
		} catch (IllegalStateException e) {
			logger.error("类ParaFieldsConfigController中方法importExcelFieldData出现IllegalStateException异常：", e);
			message = "批量导入失败！";
			jsonO.put("result", "fail");
			jsonO.put("message", message);
			return jsonO;
		} catch (IOException e) {
			logger.error("类ParaFieldsConfigController中方法importExcelFieldData出现IOException异常：", e);
			message = "批量导入失败！";
			jsonO.put("result", "fail");
			jsonO.put("message", message);
			return jsonO;
		}
        
        //3、获取Excel文件内容
        Sheet sheet = null;
        List<ModelRuleInfo> MRList = new ArrayList<ModelRuleInfo>();
        int version = 0;    //获取status='0'的version的值
        try {
        	Workbook workbook = WorkbookFactory.create(ruleName);
			sheet =  workbook.getSheetAt(0);                   //读取默认第一个工作表sheet
			int beginRowNum = 1;                                     //字段excel工作表第二行开始                         
			String[][] datas =  ExcelExport.getDataFromExcel(sheet,beginRowNum);
			if(datas == null || datas.length==0){
				message = "批量导入失败！请仔细查看excel中是否存在数据。";
				jsonO.put("result", "false");
				jsonO.put("message", message);
				logger.info("批量导入结果："+jsonO.toString());
				return jsonO;
			}
	        Map<String,Integer> map = new HashMap<String,Integer>();
	        Set<String> set = new HashSet<String>();
	        Set<String> modelToRuleSet = new HashSet<String>();
	        String createTime = sdf.format(new Date());  //创建时间
			for(int i=beginRowNum;i<datas.length;i++){
				String[] data = datas[i];
				if(data==null)
					continue;
				String modelcode = data[0];     //获取模型编码
				String modelname = data[1];    	//获取模型名称
				String rulecode = data[2];      //获取规则编码
				String rulename = data[3];      //获取规则名称
				String ruletype = data[4];      //获取规则类型
				if((modelcode == null && modelname == null && rulecode == null&& rulename == null&& ruletype == null) || ("".equals(modelcode) 
						&& "".equals(modelname) && "".equals(rulecode)&& "".equals(rulename)&& "".equals(ruletype)))   //对于整条数据为空，跳过
					continue;
				if((modelcode == null || modelname == null || rulecode == null|| rulename == null|| ruletype == null) || ("".equals(modelcode) 
						|| "".equals(modelname) || "".equals(rulecode) || "".equals(rulename) || "".equals(ruletype))){
					message = "批量导入失败！请仔细查看excel中数据是否都填写。";
					jsonO.put("result", "false");
					jsonO.put("message", message);
					logger.info("批量导入结果："+jsonO.toString());
					return jsonO;
				}
				//把模型编码放入到map里
				if(map.size()==0 && set.size()==0){ //map无数据，则值为1
					map.put(modelcode, 1);
					set.add(modelcode);
				}else if(map.size()>0){  //map有数据
					if(!set.contains(modelcode)){  //map中无该模型数据，则值为1
						map.put(modelcode, 1);
						set.add(modelcode);
					}else if(set.contains(modelcode)){ //map中有该模型数据时，将值加1
						int flag = map.get(modelcode)+1;
						map.put(modelcode, flag);
					}
				}
				String modelCodeAndRuleCode = modelcode+";"+rulecode;
				if(modelToRuleSet.size() == 0){
					modelToRuleSet.add(modelCodeAndRuleCode);
				}else if(modelToRuleSet.size()>0){
					if(modelToRuleSet.contains(modelCodeAndRuleCode)){ //模型编码和规则编码在set表存在
						message = "批量导入失败！请仔细查看模型编码（"+modelcode+"）下的规则编码（"+rulecode+"）存在重复的，请核查内容！";
						jsonO.put("result", "false");
						jsonO.put("message", message);
						return jsonO;
					}
					if(!modelToRuleSet.contains(modelCodeAndRuleCode)){ //模型编码和规则编码在set表不存在
						modelToRuleSet.add(modelCodeAndRuleCode);
					}
				}
				//组装模型规则信息
				ModelRuleInfo modelRuleInfo = new ModelRuleInfo();
				modelRuleInfo.setSeqno(map.get(modelcode));
				modelRuleInfo.setModelcode(modelcode);
				modelRuleInfo.setModelname(modelname);
				modelRuleInfo.setRulecode(rulecode);
				modelRuleInfo.setRulename(rulename);
				modelRuleInfo.setRuletype(ruletype);
				modelRuleInfo.setCreatetime(createTime);
				modelRuleInfo.setCreateuser(user.getUserId());
				modelRuleInfo.setStatus("0");
				MRList.add(modelRuleInfo);
			}
			if(MRList.size()==0 ){
	        	message = "批量导入失败！请仔细查看excel中是否存在数据。";
				jsonO.put("result", "false");
				jsonO.put("message", message);
				logger.info("批量导入结果："+jsonO.toString());
				return jsonO;
	        }
			//4、查找表中idm_modeltorule_info中状态为‘0’的版本号
			String status="0";
			Integer statusVersion = modelRuleService.queryVersion(status);
			if(statusVersion == null){
				version = 0;
			}else if(statusVersion != null){
				version = statusVersion;
			}
        }catch(Exception e){
			logger.error("类ParaFieldsConfigController中方法importExcelFieldData出现Exception异常：", e);
			message = "批量导入失败！";
			jsonO.put("result", "fail");
			jsonO.put("message", message);
			return jsonO;
		}
		//5、对表idm_modeltorule_info中数据进行修改和新增
		if(version==0){ //表中idm_modeltorule_info状态为0的数据不存在
			try{
				int numberAdd = addModelRuleInfoList(MRList,version+1);
				logger.info("模型规则批量导新增了："+numberAdd+"条状态为“0”的数据！");
				message = "批量导入成功；本次导入excel文件中，"+"字段数据行数："+MRList.size()+"；插入有效数据条数："+numberAdd+"。";
		        jsonO.put("result", "success");
		        jsonO.put("message", message);
			} catch (Exception e) {
				logger.error("类ModelRuleController中方法importExcelModelRuleData出现Exception异常：", e);
				message = "批量导入失败！";
				jsonO.put("result", "fail");
				jsonO.put("message", message);
		        return jsonO;
			}
		}else if(version>0){//表中idm_modeltorule_info状态为0的数据存在
			try{
				String updateStatus = "1";
				updateStatus(updateStatus,version);
				int numberAdd = addModelRuleInfoList(MRList,version+1);
				logger.info("模型规则批量导新增了："+numberAdd+"条状态为“0”的数据！");
				message = "批量导入成功；本次导入excel文件中，"+"字段数据行数："+MRList.size()+"；插入有效数据条数："+numberAdd+"。";
		        jsonO.put("result", "success");
		        jsonO.put("message", message);
			} catch (Exception e) {
				logger.error("类ModelRuleController中方法importExcelModelRuleData出现Exception异常：", e);
				//对之前的数据进行回滚
				String updateStatus = "0";
				updateStatus(updateStatus,version);
				logger.info(message+"并将版本号为"+version+"的数据的状态改成“0”！");
				message = "批量导入失败！";
				jsonO.put("result", "fail");
				jsonO.put("message", message);
		        return jsonO;
			}
		}
        logger.info("批量导入结果："+jsonO.toString());
        logger.info("******导入模型规则信息Excel功能importExcelModelRuleData方法结束******");
        return jsonO;
    }
	
	/**
	 * Description:根据版本号和updatestatus修改状态
	 * @param updateStatus
	 * @param version
	 * @return
	 */
	public void updateStatus(String updateStatus,int version){
		modelRuleService.updateStatusByVersion(updateStatus,version);
	}
	
	/**
	 * Description:
	 * @param MRList
	 * @param version
	 * @return
	 */
	public int addModelRuleInfoList(List<ModelRuleInfo> MRList,int version) {
		List<ModelRuleInfo> list = new ArrayList<ModelRuleInfo>();
		for(int i=0;i<MRList.size();i++){
			ModelRuleInfo modelRuleInfo = MRList.get(i);
			modelRuleInfo.setVersion(version);
			list.add(modelRuleInfo);
		}
		int number = modelRuleService.addModelRuleInfoList(list);
		return number;
	}
	
	/**
	 * Description 模型规则Excel模板导出,及数据导出
	 * @param response
	 * @return
	 * @throws IOException
	 */
    @RequestMapping(value = "/modelrule_export")
	@ResponseBody
	@SysLog(operate="导出Excel模板",module="模型规则配置")
    public String downLoadExcelZipFile(HttpServletResponse response) throws IOException{
    	
    	logger.info("******Excel模板导出downLoadExcelZipFile方法开始******");
    	response.setContentType("text/html;charset=UTF-8");
    	List<ModelRuleInfo> yList = modelRuleService.queryPatameteFieldsInfoYR();
    	if (yList.size() > 0) {
    		XSSFWorkbook workbook = new XSSFWorkbook();
                 try {
         			Sheet sheet = workbook.createSheet("rulemodel");
         			Row row = sheet.createRow(0);
         			CellStyle createCellStyle = workbook.createCellStyle();
	         			row.createCell(0).setCellValue("模型编码");
						row.createCell(1).setCellValue("模型名称");
						row.createCell(2).setCellValue("规则编码");
						row.createCell(3).setCellValue("规则名称");
						row.createCell(4).setCellValue("规则类型");
         			//导入
         			for (int i = 0; i < yList.size(); i++) {
						row = sheet.createRow(i+1);
						ModelRuleInfo mInfo = yList.get(i);
						row.createCell(0).setCellValue(mInfo.getModelcode());
						row.createCell(1).setCellValue(mInfo.getModelname());
						row.createCell(2).setCellValue(mInfo.getRulecode());
						row.createCell(3).setCellValue(mInfo.getRulename());
						row.createCell(4).setCellValue(mInfo.getRuletype());
					}
         		FileOutputStream fileOut=new FileOutputStream(rulemoBanName);
         		 workbook.write(fileOut);
         			logger.info("~~~~~~~~~~~"+row+"表格导出完成");
         			File file = new File(rulemoBanName);
                response.setCharacterEncoding("UTF-8");  
 	            response.setHeader("Content-Disposition",  
 	                    "attachment; filename="+java.net.URLEncoder.encode(modelRuleName, "UTF-8"));  
 	            response.setContentLength((int) file.length());  
 	            response.setContentType("application/ms-excel");// 定义输出类型  
 	            FileInputStream fis = new FileInputStream(file);  
 	            BufferedInputStream buff = new BufferedInputStream(fis);  
 	            byte[] b = new byte[1024];// 相当于我们的缓存  
 	            long k = 0;// 该值用于计算当前实际下载了多少字节  
 	            OutputStream myout = response.getOutputStream();// 从response对象中得到输出流,准备下载  
 	            // 开始循环下载  
 	            while (k < file.length()) {  
 	                int j = buff.read(b, 0, 1024);  
 	                k += j;  
 	                myout.write(b, 0, j);  
 	            }  
 	            myout.flush();  
 	            buff.close();
 	            fileOut.close();
                 } catch (EncryptedDocumentException e) {
          			logger.error("类ParaFieldsConfigController中方法importExcelFieldData出现EncryptedDocumentException异常：", e);
          		}catch (IOException e) {
          			logger.error("类ParaFieldsConfigController中方法importExcelFieldData出现IOException异常：", e);
          		} catch (Exception e) {  
 	        	logger.error("类ParaFieldsConfigController中方法downLoadZipFile出现Exception异常：", e);
 	        	return "文件"+modelRuleName+"下载成功！";
 	        }
 	        logger.info("******Excel模板导出downLoadExcelZipFile方法结束******");
		}else {
			File file1 = new File(rulemoBanName);
	        try {  
	            if(!file1.exists()){
	            	logger.error("类ModelRuleController中方法downLoadZipFile中文件"+rulemoBanName+"不存在");
	            	return "Excel模板文件不存在！";
	            }
	            response.setCharacterEncoding("UTF-8");  
	            response.setHeader("Content-Disposition",  
	                    "attachment; filename="+java.net.URLEncoder.encode(modelRuleName, "UTF-8"));  
	            response.setContentLength((int) file1.length());  
	            response.setContentType("application/ms-excel");// 定义输出类型  
	            FileInputStream fis = new FileInputStream(file1);  
	            BufferedInputStream buff = new BufferedInputStream(fis);  
	            byte[] b = new byte[1024];// 相当于我们的缓存  
	            long k = 0;// 该值用于计算当前实际下载了多少字节  
	            OutputStream myout = response.getOutputStream();// 从response对象中得到输出流,准备下载  
	            // 开始循环下载  
	            while (k < file1.length()) {  
	                int j = buff.read(b, 0, 1024);  
	                k += j;  
	                myout.write(b, 0, j);  
	            }  
	            myout.flush();  
	            buff.close();  
	        } catch (Exception e) {  
	        	logger.error("类ParaFieldsConfigController中方法downLoadZipFile出现Exception异常：", e);
	        	return "文件"+modelRuleName+"下载成功！";
	        }
	        logger.info("******Excel模板导出downLoadExcelZipFile方法结束******");
		}
        return null;  
    }
   
}
