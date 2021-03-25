package com.idm.app.idpconfig.adbVersionManage.controller;

import java.io.File;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.idm.app.idpconfig.adbVersionManage.service.AdbVerManageService;
import com.idm.common.exception.BusinessException;
import com.idm.common.exception.BusinessExceptionUtil;

import net.sf.json.JSONObject;


/**
 * @Controller adb文件上传方法
 * @author wengjiawei
 * @Date 2019-03-06
 */

@Controller
public class AdbFileUploadController {
	static final Logger logger = Logger.getLogger(AdbFileUploadController.class);
	static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
	
	@Autowired
	AdbVerManageService adbVerManageService;
	
	/**
	 * @Describe 上传adb规则文件至指定目录
	 * @param fileUpload
	 * @return
	 * @throws BusinessException 
	 */
	@RequestMapping(value="/upload_adb",method=RequestMethod.POST)
	@ResponseBody
    public Object upload(@RequestParam("adb_file") MultipartFile fileUpload,HttpServletRequest request) throws BusinessException{
       if(fileUpload.isEmpty()) {
        	logger.info("******文件为空！******"); 
        	BusinessException exception = new BusinessException("00000","adb文件为空");
	    	BusinessExceptionUtil.saveErrorInfo(exception);
	    	return JSONObject.fromObject("{\"success\":false}");
        }		
		/*//获取文件名
        String fileName = fileUpload.getOriginalFilename();        
        //获取文件后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));*/
        
        Boolean saveFlag = false;
        long beginTime = System.currentTimeMillis();   //循环开始时间
        long overTime = 10 * 1000;   //循环时间20s
        logger.info("******文件保存循环开始******");
        logger.info("开始时间：" + beginTime);      
        
        //循环检查文件信息是否已入库，完成入库则开始文件保存，否则提示文件保存失败
        do {
        	//重新生成文件名
            String dbFileName = adbVerManageService.selectFileName().get(0);
            logger.info("查询到的文件名称：" + dbFileName);
            
            String filePath = "/src/main/resources/adbFile/";
            String projectPath = System.getProperty("user.dir");
            logger.info("项目路径" + projectPath);
            
            File  dbFilePath = new File(projectPath + filePath + dbFileName);
            logger.info("dbFilePath文件存储路径" + dbFilePath);
            //检测文件夹是否存在
            if(!dbFilePath.getParentFile().exists()) {
            	dbFilePath.getParentFile().mkdirs();   //新建文件夹            	
            }
            //检测文件是否存在
        	if(!dbFilePath.exists()) {
        		logger.info("******文件不存在！******");
        		try {
                    //将文件保存到adbFile文件夹里
                    fileUpload.transferTo(dbFilePath);
                    //将该文件状态更新为有效
                    adbVerManageService.setAdbVerStatus(dbFileName);
                    logger.info("******文件上传成功！******");
                    saveFlag = true;
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    BusinessException exception = new BusinessException("00000","adb文件上传失败");
       	    	    BusinessExceptionUtil.saveErrorInfo(exception);
                    logger.info("******文件上传失败！******");
                    saveFlag = false;
                }
        	}
        }while(((System.currentTimeMillis() - beginTime) < overTime) && saveFlag == false );        
        logger.info("结束时间：" + System.currentTimeMillis());
        logger.info("******文件保存循环结束******");
        
        if(saveFlag) {
        	return JSONObject.fromObject("{\"success\":true}");
        }else {
        	return JSONObject.fromObject("{\"success\":false}");
        }
        
    }
}
