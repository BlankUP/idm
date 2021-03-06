package com.idm.app.idpconfig.flowInfo.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.idm.app.idpconfig.flowInfo.service.FlowInfoService;
import com.idm.app.idpconfig.proModelParaConfig.model.ProModelBaseInfo;
import com.idm.app.idpconfig.proModelParaConfig.model.ProductBaseInfo;
import com.idm.app.idpconfig.eventconfig.service.EventConfigService;
import com.idm.app.idpconfig.flowInfo.model.FlowInfo;
import com.idm.app.system.login.model.IDMUser;
import com.idm.app.system.loginfo.model.SysLog;
import com.idm.common.util.ExcelExport;
import com.idm.common.util.ResByPageVo;

import net.sf.json.JSONObject;


/**
 * 
 *<p>Title: FlowInfoController</p>  
 * @Description: 
 * @author 黄百超
 * @date 2019年6月25日
 * @version  1.0
 *
 */
@Controller
public class FlowInfoController {
	
    private Logger logger = Logger.getLogger(FlowInfoController.class);
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Autowired
    private  FlowInfoService flowInfoService;
    
    @Autowired
    private  EventConfigService eventConfigService;
    
	@Value("${flowExcelFilepath}")
	private String filepath;     //导入流程信息Excel文件路径
	
	@Value("${flowMBName}")
	private String flowMBName;     //导入流程信息Excel模板文件路径
	
	@Value("${excelFlowName}")
	private String excelFlowName;     //导入流程信息Excel模板文件路径
	
    
    
    @RequestMapping("/flow_info")
    public String FlowInfo(Model model)
    {
        return "idpconfig/flowInfo/flowInfo";
    }

    /**
     * 
     * @Description: 查询决策请求信息方法
     * @param request
     * @return
     */
    @RequestMapping("/flow_query")
    @ResponseBody
    @SysLog(operate="查询流程信息",module="流程配置")
    public Object flowQuery(HttpServletRequest request)
    {
    	logger.info("******流程查询开始******");
        String flowCode = request.getParameter("flowCode");		//流程编码
        String flowName = request.getParameter("flowName");		//流程名称
        String status = request.getParameter("status");					
    	int page =Integer.parseInt(request.getParameter("page"));
		int size = Integer.parseInt(request.getParameter("rows"));
        
        ResByPageVo resByPageVo = null;
		try {

			if (flowName != null && flowName != "") {
				flowName = java.net.URLDecoder.decode(flowName, "UTF-8");
			}
			logger.info("flowCode:["+flowCode+"]");
	        logger.info("flowName:["+flowName+"]");
	        FlowInfo flowInfo = new FlowInfo();
	        flowInfo.setFlowCode(flowCode);
	        flowInfo.setFlowName(flowName);
	        flowInfo.setStatus(status);
	        flowInfo.setPage(page);
	        flowInfo.setSize(size);
	        List<FlowInfo> list = flowInfoService.queryFlowInfo(flowInfo);
			resByPageVo = new ResByPageVo(size, page,flowInfoService.selectCountByAll(flowInfo));
			resByPageVo.setRows(list);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        logger.info("******流程查询结束******");
        return JSONObject.fromObject(resByPageVo);
    }
    
    /**
          * 事件入口配置新增保存方法
          * 黄百超
     * 2019-02-23
     * @param request
     * @return
     */
    @RequestMapping("/flow_save")
    @ResponseBody
    @SysLog(operate="新增或修改",module="流程配置")
    public synchronized String addOrUpdateFlowInfo(HttpServletRequest request)
    {
    	logger.info("******流程配置新增/修改开始******");
    	String option  = request.getParameter("option");					//方法类型
        String flowCode = request.getParameter("flowCode");		//流程编码
        String flowName = request.getParameter("flowName");		//流程名称
        String flowId = request.getParameter("flowId");						//流程编码
        String key = request.getParameter("key");							//比对字段
        String value = request.getParameter("value");						//比对值
        String startModel = request.getParameter("startModel");				//当前节点
        String nextModel = request.getParameter("nextModel");				//下一节点
        String status  =request.getParameter("status");						//状态位

        logger.info("option:["+option+"]");
        logger.info("flowCode:["+flowCode+"]");
        logger.info("flowName:["+flowName+"]");
        logger.info("flowId:["+flowId+"]");
        logger.info("key:["+key+"]");
        logger.info("value:["+value+"]");
        logger.info("startModel:["+startModel+"]");
        logger.info("nextModel:["+nextModel+"]");
        logger.info("status:["+status+"]");
        
        IDMUser user = (IDMUser)request.getSession().getAttribute("user");
        FlowInfo flowInfo = new FlowInfo();
        flowInfo.setFlowId(flowId);
        flowInfo.setKey(key);
        flowInfo.setValue(value);
        flowInfo.setFlowCode(flowCode);
        flowInfo.setFlowName(flowName);
        flowInfo.setStartModel(startModel);
        flowInfo.setNextModel(nextModel);
        flowInfo.setCreateTime(sdf.format(new Date()));
        flowInfo.setCreateUser(user.getUserId());
        flowInfo.setUpdateTime(sdf.format(new Date()));
        flowInfo.setUpdateUser(user.getUserId());
        flowInfo.setStatus(status);
        //新增与更新分别处理
        if("add".equals(option))
        {
            try {
            	flowInfoService.addFlowInfo(flowInfo);
            } catch (Exception e) {
                logger.error(e.getMessage());
                logger.info("******流程配置新增/修改结束******");
                return "添加数据失败";
            }
        }
        if("update".equals(option))
        {
        	try {
				flowInfoService.updateFlowInfo(flowInfo);
			} catch (Exception e) {
				 logger.error(e.getMessage());
				 logger.info("******流程配置新增/修改结束******");
	             return "更新数据失败";
			}
        }
        logger.info("******流程配置新增/修改结束******");
        return null;
    }
    
    
    /**
	 * Description 实现excel文件导入
	 * @param fileUpload
	 * @param request
	 * @return
	 */
	@SysLog(operate="导入流程信息Excel",module="流程配置")
	@RequestMapping(value="/flow_excel",method=RequestMethod.POST)
	@ResponseBody
    public synchronized Object importExcelFlowData(@RequestParam("file") MultipartFile fileUpload,HttpServletRequest request){
		
		logger.info("******导入字段信息Excel功能importExcelFlowData方法开始******");
		JSONObject jsonO = new JSONObject();
		String message = "";
		String fieldExist = "";
		//获取产品信息、模型信息
	    ProModelBaseInfo proModelBaseInfo = new ProModelBaseInfo();
	    List<ProModelBaseInfo>  PMList = eventConfigService.queryModelInfo(proModelBaseInfo);
	    
	    Map<String, String> PMmap = new HashMap<>();
		    for(ProModelBaseInfo pMList:PMList) {
		    	PMmap.put(pMList.getModelname(), pMList.getModelcode());
		    }
		logger.info("PMmap:"+PMmap);
		
		
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
        File excelFile = new File(fileMuLu+"\\"+fileName+"."+subffix);
        try {
			fileUpload.transferTo(excelFile);
		} catch (IllegalStateException e) {
			logger.error("类FlowInfoController中方法importExcelFlowData出现IllegalStateException异常：", e);
		} catch (IOException e) {
			logger.error("类FlowInfoController中方法importExcelFlowData出现IOException异常：", e);
		}
        
        //3、获取Excel文件内容
        Workbook workbook=null;
        try {
			workbook = WorkbookFactory.create(excelFile);
		} catch (EncryptedDocumentException e) {
			logger.error("类FlowInfoController中方法importExcelFlowData出现EncryptedDocumentException异常：", e);
		} catch (InvalidFormatException e) {
			logger.error("类FlowInfoController中方法importExcelFlowData出现InvalidFormatException异常：", e);
		} catch (IOException e) {
			logger.error("类FlowInfoController中方法importExcelFlowData出现IOException异常：", e);
		}
        
        Sheet sheet =  workbook.getSheetAt(0);                   //读取默认第一个工作表sheet
        int beginRowNum = 1;                                     //字段excel工作表第二行开始                         
        String[][] datas =  ExcelExport.getDataFromExcel(sheet,beginRowNum);
        List<FlowInfo> FIList = new ArrayList();
        
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
			logger.info(" datas["+i+"]:" +datas[i].toString());
			String flowName = data[0];    		//获取产品名称
			String flowCode = data[1];     		//获取产品编码
			String startModelName = data[2];      	//获取开始节点名称
			String startModel = data[3];      		//获取开始节点编码
			String nextModelName = data[4];      	//获取下一节点名称
			String nextModel = data[5];      		//获取下一节点编码
			String key = data[6];      				//获取比较字段
			String value = data[7];      			//获取比较值
			int n = i; 
			
			if(flowName == null && flowCode == null&&startModelName==null && startModel == null && nextModelName==null && nextModel == null) { 
				//去除空数据
				continue;
			}
			if("".equals(flowName)&& "".equals(startModelName)&&"".equals(nextModelName)&&"".equals(flowCode)&& "".equals(startModel)&&"".equals(nextModel)) {
				//去除空数据
				continue;
			}
			logger.info("flowName:"+flowName);
			logger.info("flowCode:"+flowCode);
			logger.info("startModelName:"+startModelName);
			logger.info("startModel:"+startModel);
			logger.info("nextModelName:"+nextModelName);
			logger.info("nextModel:"+nextModel);
			logger.info("key:"+key);
			logger.info("value:"+value);
			if((flowName == null && flowCode == null)||(startModelName==null && startModel == null)||(nextModelName==null && nextModel == null)) {   //对于信息为空
				message = "批量导入失败！请仔细查看excel中第"+n+"行数据是否都填写。";
				jsonO.put("result", "false");
				jsonO.put("message", message);
				logger.info("流程批量导入结果："+jsonO.toString());
				return jsonO;
			}


			if (PMmap.containsKey(startModelName)) { 
				startModel =  PMmap.get(startModelName)+"";
			}
			if (PMmap.containsKey(nextModelName)) { 
				nextModel =  PMmap.get(nextModelName)+"";
			}
			if("开始节点".equals(startModelName)) {
				startModel="start";
			}
			if("结束节点".equals(nextModelName)) {
				nextModel="end";
			}
			
			if(flowCode == null||startModel == null||  nextModel == null|| "".equals(flowCode)|| "".equals(startModel)|| "".equals(nextModel) ) {   //对于信息为空
				message = "批量导入失败！请核查第"+n+"行数据是否正确。";
				jsonO.put("result", "false");
				jsonO.put("message", message);
				logger.info("流程批量导入结果："+jsonO.toString());
				return jsonO;
			}
			if(nextModel.equals(startModel)) {
				message = "批量导入失败！请核查第"+n+"行数据是否正确。";
				jsonO.put("result", "false");
				jsonO.put("message", message);
				logger.info("流程批量导入结果："+jsonO.toString());
				return jsonO;
			}
			
			FlowInfo flowInfo = new FlowInfo();
	        flowInfo.setKey(key);
	        flowInfo.setValue(value);
	        flowInfo.setFlowCode(flowCode);
	        flowInfo.setFlowName(flowName);
	        flowInfo.setStartModel(startModel);
	        flowInfo.setNextModel(nextModel);
	        flowInfo.setCreateTime(sdf.format(new Date()));
	        flowInfo.setCreateUser(user.getUserId());
	        flowInfo.setStatus("0");
	        logger.info("flowInfo:"+flowInfo);
	        FIList.add(flowInfo);

		}
		
		//5、插入数据
		int number = 0;
		if(FIList.size()>0){
			try {
				number = flowInfoService.addFlowInfoList(FIList);
			} catch (Exception e) {
				logger.error("流程批量导入异常：", e);
				message = "批量导入失败！";
				jsonO.put("result", "fail");
				logger.info("批量导入结果："+jsonO.toString());
		        return jsonO;
			}
		}
        message = "批量导入成功；本次导入excel文件中，"+"字段数据行数："+FIList.size()+"；插入有效数据条数："+number;
        message = message+"。";
        jsonO.put("result", "success");
        jsonO.put("message", message);
        jsonO.put("fieldExist", fieldExist);
        logger.info("批量导入结果："+jsonO.toString());
        logger.info("******导入流程信息Excel功能方法结束******");
        return jsonO;
    }
	
	/**
	 * Description 参数字段Excel模板导出
	 * @param response
	 * @return
	 * @throws IOException
	 */
    @RequestMapping(value = "/flow_excel_export")
	@ResponseBody
	@SysLog(operate="导出Excel模板",module="流程配置")
    public String downLoadExcelZipFile(HttpServletResponse response) throws IOException{
    	
    	logger.info("******Excel模板导出downLoadExcelZipFile方法开始******");
    	response.setContentType("text/html;charset=UTF-8");
        try {  
            File file = new File(flowMBName); 
            if(!file.exists()){
            	logger.error("类FlowInfoController中方法downLoadZipFile中文件"+flowMBName+"不存在");
            	return "Excel模板文件不存在！";
            }
            response.setCharacterEncoding("UTF-8");  
            response.setHeader("Content-Disposition",  
                    "attachment; filename="+java.net.URLEncoder.encode(excelFlowName, "UTF-8"));  
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
        	logger.error("类FlowInfoController中方法downLoadExcelZipFile出现Exception异常：", e);
        	return "文件"+flowMBName+"下载失败！";
        }
        logger.info("******Excel模板导出downLoadExcelZipFile方法结束******");
        return null;  
    }
}
