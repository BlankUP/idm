package com.idm.app.idpconfig.proModelParaConfig.controller;

import com.idm.app.idpconfig.proModelParaConfig.model.ParaBaseInfo;
import com.idm.app.idpconfig.proModelParaConfig.service.ParaInfoConfigService;
import com.idm.app.system.login.model.IDMUser;
import com.idm.app.system.loginfo.model.SysLog;
import com.idm.common.util.ExcelExport;
import com.idm.common.util.ResByPageVo;
import com.idm.config.resubmit.repeat_form_validator.SameUrlData;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
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
import java.io.FileNotFoundException;
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
 * <p>Description:参数字段信息配置类 </p>  
 * <p>Company: </p>  
 * @author caiwenjian
 * @date 2019年2月23日  
 * @version 1.0  
 */
@Controller
public class ParaFieldsConfigController {
	
	private Logger logger = Logger.getLogger(ParaFieldsConfigController.class);
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Autowired
	private ParaInfoConfigService paraInfoConfigService;

	@Value("${excelFilepath}")
	private String filepath;     //导入字段信息Excel文件路径
	
	@Value("${moBanName}")
	private String moBanName;     //字段信息Excel模板路径
	
	@Value("${excelFileName}")
	private String excelFileName; //字段信息Excel模板名称
	
	/**
	 * 参数字段配置界面请求跳转 
	 *@return
	 */
	@RequestMapping("/paraInfo_Config")
	public String exceptionBase() {
		return "idpconfig/proModelParaConfig/paraInfoConfig";
	}
	
	/**
	 * 查询参数字段信息
	 *@param request
	 *@param page
	 *@param rows
	 *@return
	 */
	@SysLog(operate = "查询参数字段",module= "上游参数管理")
	@RequestMapping("/paraInfo_Config_query")
	@ResponseBody
	public Object queyParaInfoConfig(HttpServletRequest request) {
		
		logger.info("***********查询参数字段信息方法开始***************");
		
		int page = Integer.parseInt(request.getParameter("page"));
		int size = Integer.parseInt(request.getParameter("rows"));
		String parameterfields = request.getParameter("paraEn");
		String parameternamech = request.getParameter("paraCh");
		logger.info(">>>parameterfields参数字段[" + parameterfields + "]");
		logger.info(">>>parameternamech参数字段中文[" + parameternamech + "]");
		
		ParaBaseInfo paraInfo = new ParaBaseInfo();
		paraInfo.setParameterfields(parameterfields);	//参数字段英文
		paraInfo.setParameternamech(parameternamech);	//参数字段中文
		paraInfo.setPage(page);
		paraInfo.setSize(size);
		int count = paraInfoConfigService.selectCountByAll(paraInfo);
		//查询参数字段表信息
		List<ParaBaseInfo> paraList = paraInfoConfigService
				.queryPatameteFieldsInfo(paraInfo);
		ResByPageVo resByPageVo = new ResByPageVo(size, page, count);
		if (paraList != null && paraList.size() > 0) {
			logger.info("查询parameterfields参数字段信息成功，总记录[" + count + "]");
			resByPageVo.setRows(paraList);
		} else if (paraList != null && paraList.size() == 0) {
			logger.info(">>parameterfields参数字段无记录");
			resByPageVo = new ResByPageVo(size, page, 0);
		} else {
			logger.info(">>parameterfields参数字段数据库错误");
			resByPageVo = new ResByPageVo(size, page, 0);
		}
		logger.info("**********查询参数字段信息方法结束***********");
		return JSONObject.fromObject(resByPageVo);
	}
	
	/**
	 * 新增或修改参数字段信息方法
	 *@param request
	 *@param page
	 *@param rows
	 *@return
	 */
	@SysLog(operate = "新增参数或修改",module= "上游参数管理")
	@RequestMapping("/paraInfo_Config_save")
	@ResponseBody
	@SameUrlData
	public synchronized String addOrUpdateParaInfoConfig(HttpServletRequest request) {
		logger.info("***********新增或修改参数字段信息方法开始***************");
		//获取当前用户
		IDMUser user = (IDMUser)request.getSession().getAttribute("user");
		String option = request.getParameter("option");
		String updateuser = request.getParameter("updateuser");
		String updatetime = request.getParameter("updatetime");
		String status = request.getParameter("status");	
		String parameternamech = request.getParameter("parameternamech");	//参数字段中文
		String parameterfields = request.getParameter("parameterfields");	//参数字段英文
		String parametertype = request.getParameter("parametertype");	//参数字段类型
		
		logger.info(">>>option[" + option + "]");
		logger.info(">>>parameterfields[" + parameterfields + "]");
		logger.info(">>>parameternamech[" + parameternamech + "]");
		logger.info(">>>updatetime[" + updatetime + "]");
		logger.info(">>>updateuser[" + updateuser + "]");
		
		ParaBaseInfo fieldsInfo = new ParaBaseInfo();
		fieldsInfo.setParameternamech(parameternamech);
		fieldsInfo.setParameterfields(parameterfields);
		fieldsInfo.setParametertype(parametertype);
		fieldsInfo.setStatus(status);
		String stringId = request.getParameter("fieldid");	//参数字段表ID
		//新增功能
		if ("add".equals(option)) {
			
			boolean isPass = true;
			if(parameterfields!=null&&""!=parameterfields){
				isPass = paraInfoConfigService.checkByName(parameterfields,null);
				logger.info(">>"+parameterfields+":"+isPass);
				if (isPass == false) {
					return "addFail";
				}
			}
			if(parameternamech!=null&&""!=parameternamech){
				isPass = paraInfoConfigService.checkByName(null,parameternamech);
				logger.info(">>"+parameternamech+":"+isPass);
				if (isPass == false) {
					return "addFail";
				}
			}
			
			logger.info("***********新增参数字段信息方法开始***************");
			fieldsInfo.setCreatetime(sdf.format(new Date()));
			fieldsInfo.setUpdatetime(sdf.format(new Date()));
			fieldsInfo.setCreateuser(user.getUserId());
			fieldsInfo.setUpdateuser(user.getUserId());
			try {
				paraInfoConfigService.addParameterFieldsInfo(fieldsInfo);
			} catch (Exception e) {
				logger.error("类ParaFieldsConfigController中方法addOrUpdateParaInfoConfig出现Exception异常:" + e.getMessage());
				e.printStackTrace();
				return "addFail";
			}
			logger.info("***********修改参数字段信息方法结束***************");
		}
		//修改功能
		if ("update".equals(option)) {
			logger.info("***********修改参数字段信息方法结开始***************");
			String username = user.getUserId();
			fieldsInfo.setUpdatetime(sdf.format(new Date()));
			if(username!=null){
				fieldsInfo.setUpdateuser(username);
			}
			if(stringId!=null&&""!=stringId){
				fieldsInfo.setFieldid(stringId.toString());
			}
			try {
				paraInfoConfigService.updateParameterFieldsInfo(fieldsInfo);
			} catch (Exception e) {
				logger.error("类ParaFieldsConfigController中方法addOrUpdateParaInfoConfig出现Exception异常:" + e.getMessage());
				e.printStackTrace();
				return "updtateFail";
			}
			logger.info("***********修改参数字段信息方法结束***************");
			
		}
		return null;
	}
	
	/**
	 * 校验参数名称是否重复
	 */
	@SysLog(operate = "校验参数名称是否重复",module= "上游参数管理")
	@RequestMapping("/checkParaName_isExist")
	@ResponseBody
	public Object checkIsExist(HttpServletRequest request,HttpServletResponse response) throws FileNotFoundException {
		logger.info("******校验参数名称checkIsExist方法开始******");
		String parameterfields = request.getParameter("parameterfields");
		String parameternamech = request.getParameter("parameternamech");
		boolean isPass = true;
		if(parameterfields!=null&&""!=parameterfields){
			isPass = paraInfoConfigService.checkByName(parameterfields,null);
			logger.info(">>"+parameterfields+":"+isPass);
		}
		if(parameternamech!=null&&""!=parameternamech){
			isPass = paraInfoConfigService.checkByName(null,parameternamech);
			logger.info(">>"+parameternamech+":"+isPass);
		}
		
		logger.info("******校验参数名称checkIsExist方法结束******");
		return JSONObject.fromObject("{\'isPass\':"+isPass+"}");
	}

	
	/**
	 * 修改为无效时校验是否有模型已配置该参数
	 * @param request
	 * @param response
	 * @return
	 * @throws FileNotFoundException
	 */
	@RequestMapping("/check_field_isUsed")
	@ResponseBody
	public Object checkIsUsed(HttpServletRequest request,HttpServletResponse response) throws FileNotFoundException {
		logger.info("******校验参数是否使用checkIsUsed方法开始******");
		String fieldid = request.getParameter("fieldid");
		String parameterfields = request.getParameter("parameterfields");
		boolean isPass = true;
		if(fieldid!=null&&""!=fieldid){
			isPass = paraInfoConfigService.checkIsUsed(fieldid);
			logger.info(">>"+parameterfields+"-isUsed:"+isPass);
		}
		logger.info("******校验参数是否使用checkIsUsed方法结束******");
		return JSONObject.fromObject("{\'isPass\':"+isPass+"}");
	}
	
	/**
	 * Description 实现excel文件导入
	 * @param fileUpload
	 * @param request
	 * @return
	 */
	@SysLog(operate="导入字段信息Excel",module="字段信息")
	@RequestMapping(value="/field_excel_import",method=RequestMethod.POST)
	@ResponseBody
    public Object importExcelFieldData(@RequestParam("file") MultipartFile fileUpload,HttpServletRequest request){
		
		logger.info("******导入字段信息Excel功能importExcelFieldData方法开始******");
		JSONObject jsonO = new JSONObject();
		String message = "";
		String fieldExist = "";
		
		//1、获取文件信息，并创建文件夹
		IDMUser user = (IDMUser)request.getSession().getAttribute("user");        //获取当前用户
		String name= fileUpload.getOriginalFilename();                            //获取文件名称
		String subffix = name.substring(name.lastIndexOf(".") + 1, name.length());//获取文件后缀
        String fileName = user.getUserId()+"_"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String filepath1 = filepath+"/"+new SimpleDateFormat("yyyyMMdd").format(new Date());
        File fileMuLu=new File(filepath1);
        if(!fileMuLu.exists()){//目录不存在就创建
        	fileMuLu.mkdirs();
        }
        
        //2、保存上传Excel文件到指定文件夹中
        File excelFile = new File(fileMuLu+File.separator+fileName+"."+subffix);
        try {
			fileUpload.transferTo(excelFile);
		} catch (IllegalStateException e) {
			logger.error("类ParaFieldsConfigController中方法importExcelFieldData出现IllegalStateException异常：", e);
		} catch (IOException e) {
			logger.error("类ParaFieldsConfigController中方法importExcelFieldData出现IOException异常：", e);
		}
        
        //3、获取Excel文件内容
        Workbook workbook=null;
        try {
			workbook = WorkbookFactory.create(excelFile);
		} catch (EncryptedDocumentException e) {
			logger.error("类ParaFieldsConfigController中方法importExcelFieldData出现EncryptedDocumentException异常：", e);
		} catch (InvalidFormatException e) {
			logger.error("类ParaFieldsConfigController中方法importExcelFieldData出现InvalidFormatException异常：", e);
		} catch (IOException e) {
			logger.error("类ParaFieldsConfigController中方法importExcelFieldData出现IOException异常：", e);
		}
        
        Sheet sheet =  workbook.getSheetAt(0);                   //读取默认第一个工作表sheet
        int beginRowNum = 1;                                     //字段excel工作表第二行开始                         
        String[][] datas =  ExcelExport.getDataFromExcel(sheet,beginRowNum);
        //int rowTotal = datas.length;                             //工作表sheet中总行数
        List<String> parameterfieldList = new ArrayList<String>();
        List<String> parameternamechList = new ArrayList<String>();
        if(datas == null || datas.length==0){
        	message = "批量导入失败！请仔细查看excel中是否存在数据。";
			jsonO.put("result", "false");
			jsonO.put("message", message);
			logger.info("批量导入结果："+jsonO.toString());
			return jsonO;
        }
		for(int i=beginRowNum;i<datas.length;i++){
			String[] data = datas[i];
			if(data==null)
				continue;
			String parameterfield = datas[i][1];     //获取参数字段
			String parameternamech = datas[i][2];    //获取参数名中文
			String parametertype = datas[i][3];      //获取参数类型
			if((parameterfield == null && parameternamech == null && parametertype == null) || ("".equals(parameterfield) 
					&& "".equals(parameternamech) && "".equals(parametertype)))   //对于整条数据为空，跳过
				continue;
			if(parameterfield == null || parameternamech == null || parametertype == null || "".equals(parameterfield) 
					|| "".equals(parameternamech) || "".equals(parametertype)){
				message = "批量导入失败！请仔细查看excel中数据是否都填写。";
				jsonO.put("result", "false");
				jsonO.put("message", message);
				logger.info("批量导入结果："+jsonO.toString());
				return jsonO;
			}
			//判断excel中是否有重复的数据
			if(parameterfieldList.size()==0&&parameternamechList.size()==0){
				parameterfieldList.add(parameterfield);
				parameternamechList.add(parameternamech);
			}else{
				if(parameterfieldList.contains(parameterfield)||parameternamechList.contains(parameternamech)){ //存在重复数据
					message = "批量导入失败！请仔细查看excel中重复数据，并请修改重复数据。";
					jsonO.put("result", "false");
					jsonO.put("message", message);
					logger.info("批量导入结果："+jsonO.toString());
					return jsonO;
				}else{
					parameterfieldList.add(parameterfield);
					parameternamechList.add(parameternamech);
				}
			}
		}
		if(parameterfieldList.size()==0 && parameternamechList.size()==0){
        	message = "批量导入失败！请仔细查看excel中是否存在数据。";
			jsonO.put("result", "false");
			jsonO.put("message", message);
			logger.info("批量导入结果："+jsonO.toString());
			return jsonO;
        }
		Map<String,List<String>> map = new HashMap<String,List<String>>();
		map.put("parameterfieldList", parameterfieldList);
		map.put("parameternamechList", parameternamechList);
		
		//4、从表（idm_field_info）中查出excel中数据在表中存在的数据
		Set<String> parameterfieldsIsExist = new HashSet<String>();
		Set<String> parameternamechsExist = new HashSet<String>();
		List<ParaBaseInfo> list = paraInfoConfigService.queryPatameterFieldsInfoByExcel(map);
        if(list != null&& list.size()>0){
        	for(int i=0;i<list.size();i++){
        		ParaBaseInfo paraBaseInfo = list.get(i);
        		parameterfieldsIsExist.add(paraBaseInfo.getParameterfields());
        		parameternamechsExist.add(paraBaseInfo.getParameternamech());
        	}
        }
		//循环数据，并找到excel数据哪些不在表中
        List<ParaBaseInfo> insetList = new ArrayList<ParaBaseInfo>();
        int dataTotalNum = datas.length;            //工作表中数据行数
        int isExitDataNum = 0;                      //工作表中数据在数据库已经存在的条数
		for(int i=0;i<datas.length;i++){
			String[] data = datas[i];
			if(data==null){
				dataTotalNum--;
				continue;
			}
			String xuhao = datas[i][0];              //获取序号
			String parameterfield = datas[i][1];     //获取参数字段
			String parameternamech = datas[i][2];    //获取参数名中文
			String parametertype = datas[i][3];      //获取参数类型
			
			if((parameterfield == null && parameternamech == null && parametertype == null) || ("".equals(parameterfield) 
					&& "".equals(parameternamech) && "".equals(parametertype))){  //对于整条数据为空，跳过
				dataTotalNum--;
				continue;
			}
			//判断是否包含包含
			if(parameterfieldsIsExist.contains(parameterfield)||parameternamechsExist.contains(parameternamech)){
				isExitDataNum ++;
				String fieldContent =xuhao+","+ parameterfield+","+parameternamech+","+parametertype;
				if("".equals(fieldExist))
					fieldExist = fieldExist +fieldContent;
				else
					fieldExist = fieldExist +";"+fieldContent;
				continue;
			}
			//对excel中有效数据进行封装
			String status = "0";
			ParaBaseInfo fieldsInfo = new ParaBaseInfo();
			fieldsInfo.setParameterfields(parameterfield);
			fieldsInfo.setParameternamech(parameternamech);
			fieldsInfo.setParametertype(parametertype);
			fieldsInfo.setStatus(status);
			fieldsInfo.setCreatetime(sdf.format(new Date()));
			fieldsInfo.setCreateuser(user.getUserId());
			insetList.add(fieldsInfo);
			fieldsInfo = null;
		}
		
		//5、插入数据
		int number = 0;
		if(insetList.size()>0){
			try {
				number = paraInfoConfigService.addParaBaseInfoList(insetList);
			} catch (Exception e) {
				logger.error("类ParaFieldsConfigController中方法importExcelFieldData出现Exception异常：", e);
				message = "批量导入失败！";
				jsonO.put("result", "fail");
				logger.info("批量导入结果："+jsonO.toString());
		        return jsonO;
			}
		}
        message = "批量导入成功；本次导入excel文件中，"+"字段数据行数："+dataTotalNum+"；插入有效数据条数："+number;
        if(isExitDataNum != 0)
        	message = message+"；工作表中数据在数据库已经存在的条数："+isExitDataNum;
        message = message+"。";
        jsonO.put("result", "success");
        jsonO.put("message", message);
        jsonO.put("fieldExist", fieldExist);
        logger.info("批量导入结果："+jsonO.toString());
        logger.info("******导入字段信息Excel功能importExcelFieldData方法结束******");
        return jsonO;
    }
	
	/**
	 * Description 参数字段Excel模板导出
	 * @param response
	 * @return
	 * @throws IOException
	 */
    @RequestMapping(value = "/field_excel_export")
	@ResponseBody
	@SysLog(operate="导出Excel模板",module="字段信息")
    public String downLoadExcelZipFile(HttpServletResponse response) throws IOException{
    	
    	logger.info("******Excel模板导出downLoadExcelZipFile方法开始******");
    	response.setContentType("text/html;charset=UTF-8");
        try {  
            File file = new File(moBanName); 
            if(!file.exists()){
            	logger.error("类ParaFieldsConfigController中方法downLoadZipFile中文件"+moBanName+"不存在");
            	return "Excel模板文件不存在！";
            }
            response.setCharacterEncoding("UTF-8");  
            response.setHeader("Content-Disposition",  
                    "attachment; filename="+java.net.URLEncoder.encode(excelFileName, "UTF-8"));  
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
        } catch (Exception e) {  
        	logger.error("类ParaFieldsConfigController中方法downLoadZipFile出现Exception异常：", e);
        	return "文件"+moBanName+"下载成功！";
        }
        logger.info("******Excel模板导出downLoadExcelZipFile方法结束******");
        return null;  
    }
	 
}
