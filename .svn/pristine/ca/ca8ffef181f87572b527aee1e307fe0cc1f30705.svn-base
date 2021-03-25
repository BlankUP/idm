package com.idm.app.idpconfig.pmmlConfig.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.idm.app.idpconfig.pmmlConfig.model.PmmlConfig;
import com.idm.app.idpconfig.pmmlConfig.model.PmmlFile;
import com.idm.app.idpconfig.pmmlConfig.service.PmmlConfigService;
import com.idm.app.idpconfig.pmmlConfig.service.PmmlFileService;
import com.idm.app.idpconfig.sharefile.model.ShareFile;
import com.idm.app.idpconfig.sharefile.service.ShareFileService;
import com.idm.app.system.login.model.IDMUser;
import com.idm.app.system.loginfo.model.SysLog;
import com.idm.common.util.ResByPageVo;
import com.idm.common.util.getVsesion;

import net.sf.json.JSONObject;

import java.util.List;

/**
 * 
 *<p>Title: PmmlFileController</p>  
 * @Description: PMML文件管理
 * @author 黄百超
 * @date 2019年3月8日
 * @version  1.0
 *
 */
@Controller
public class PmmlFileController {
	
    private Logger logger = Logger.getLogger(PmmlConfigController.class);
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    static SimpleDateFormat sdfYmd = new SimpleDateFormat("yyyyMMdd");
    
    
    @Autowired
    private  PmmlConfigService pmmlConfigService;
    
    @Autowired
    private  PmmlFileService pmmlFileService;
    
    
    @Autowired
    private  ShareFileService shareFileService;
    
    
	@Value("${PMML_FILE}")
	private String PMML_FILE;
	/**
	 * 
	 * @Description: 上传
	 * @param fileUpload
	 */
	@RequestMapping(value="/pmml_upload",method=RequestMethod.POST)
	@ResponseBody
	@SysLog(operate="上传",module="PMML模型文件信息")
    public Object upload(@RequestParam("file") MultipartFile fileUpload,String versionDesc,String pmmlId,HttpServletRequest request){
		logger.info("******pmmlId:"+pmmlId);  
		logger.info("******versionDesc:"+versionDesc);  
        if(fileUpload.isEmpty()) {
        	logger.info("******文件内容为空******");  
        }		
		//获取文件名
        String fileName = fileUpload.getOriginalFilename();
        
        //获取文件后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        logger.info("******fileUpload.getSize()"+fileUpload.getSize());
        if(fileUpload.getSize()==0) {
        	 logger.info(">>>>>>>空文件!>>>>>>>>");
             return JSONObject.fromObject("{\"success\":false,\"status\":0}");
        }
			
        
        String versionNo = "";
        String oldVersionNo = "";
        String dateStr = "";
        Date nowDate = new Date();
        String date = sdf.format(nowDate);
        int num = (int) ((Math.random()*9+1)*1000);
        String  id = String.valueOf(nowDate.getTime()) + String.valueOf(num);
        
        //重新生成文件名
        List<String> oldVersionlist = pmmlFileService.selectMaxVersionNo(pmmlId);
        if(oldVersionlist.isEmpty() || oldVersionlist.get(0) ==null) {
        	logger.info("******无历史版本******");  
			versionNo = getVsesion.newVersio(0);
		}else {
		   oldVersionNo = oldVersionlist.get(0);
		   dateStr = oldVersionNo.substring(5, oldVersionNo.length()-4);
		   logger.info("******oldVersionNo："+oldVersionNo);  
		   logger.info("******dateStr："+dateStr);  
		   if(dateStr.equals(sdfYmd.format(nowDate))) {
			   logger.info("******上一版本为："+dateStr);  
			   versionNo = getVsesion.newVersio(Integer.valueOf(oldVersionNo.substring(13, oldVersionNo.length())) + 1);
		   }else {
			   logger.info("******今日无历史版本******");  
			   versionNo = getVsesion.newVersio(0);
		   }
		}
        versionNo = "pmml_"+versionNo;
        String newFileName = versionNo + suffixName;
        String filePath = PMML_FILE+File.separator  +pmmlId;
        File file=new File(filePath);
    	if(!file.exists()){//如果文件夹不存在
			file.mkdir();//创建文件夹
		}
        String path = filePath+File.separator+newFileName;
        
    	IDMUser user = (IDMUser)request.getSession().getAttribute("user");

        ShareFile shareFile = new ShareFile();
        shareFile.setFileId(id);
        System.out.println(id);
        shareFile.setCreateTime(date);
        shareFile.setCreateUser(user.getUserId());
        shareFile.setFileName(newFileName);
        shareFile.setFilePath(path);
        shareFile.setFormat("pmml");
        shareFile.setName(fileName);
        shareFile.setVersion(versionNo);
        
        PmmlFile pmmlFile = new PmmlFile();
        pmmlFile.setCreateTime(date);
        pmmlFile.setCreateUser(user.getUserId());
        pmmlFile.setFileId(id);
        pmmlFile.setVersion(versionNo);
        pmmlFile.setStatus("0");
        pmmlFile.setVersionDesc(versionDesc);
        pmmlFile.setPmmlId(pmmlId);
        
        File  newPath = new File(filePath+File.separator+newFileName);
        //检测文件夹是否存在
        if(!newPath.getParentFile().exists()) {
        	newPath.getParentFile().mkdirs();   //新建文件夹
        }
        try {
            //将文件保存到adbFile文件夹里
            fileUpload.transferTo(newPath);
            
            //保存相关数据
            pmmlFileService.addPmmlFile(pmmlFile);
            shareFileService.addShareFile(shareFile);
            logger.info(">>>>>>>文件上传成功！>>>>>>>>");
            return JSONObject.fromObject("{\"success\":true}");
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(">>>>>>>文件上传失败！>>>>>>>>");
            return JSONObject.fromObject("{\"success\":false,\"status\":1}");
        } 
    }
	
	 /**
     * 
     * @Description: 查询pmml模型文件信息方法
     * @param request
     * @return
     */
    @RequestMapping("/pmml_file_query")
    @ResponseBody
    @SysLog(operate="查询",module="PMML模型文件信息")
    public Object pmmlFileQuery(HttpServletRequest request)
    {
		logger.info("******pmml模型文件信息查询开始******");
		String pmmlId = request.getParameter("pmmlId"); // pmml编码
		int page = Integer.parseInt(request.getParameter("page"));
		int size = Integer.parseInt(request.getParameter("rows"));

		ResByPageVo resByPageVo = null;
		logger.info("pmmlCode:[" + pmmlId + "]");
		PmmlFile pmmlFile = new PmmlFile();
		pmmlFile.setPmmlId(pmmlId);
		List<PmmlFile> ECList = pmmlFileService.queryPmmlFile(pmmlFile);
		resByPageVo = new ResByPageVo(size, page, ECList.size());
		resByPageVo.setRows(ECList);

        logger.info("******pmml模型文件信息查询结束******");
        return JSONObject.fromObject(resByPageVo);
    }	
    

	 /**
    * 
    * @Description: 查询pmml模型文件信息方法
    * @param request
    * @return
    */
   @RequestMapping("/pmml_file_update")
   @ResponseBody
   @SysLog(operate="发布",module="PMML模型文件信息")
   public Object pmmlFileUpdate(HttpServletRequest request)
   {
		logger.info("******pmml模型文件发布开始******");
		String pmmlFileId = request.getParameter("pmmlFileId"); // pmml编码

		logger.info("pmmlFileId:[" + pmmlFileId + "]");
		
    	IDMUser user = (IDMUser)request.getSession().getAttribute("user");
    	String date = sdf.format(new Date());
		PmmlFile pmmlFile = new PmmlFile();
		pmmlFile.setPmmlFileId(pmmlFileId);
		pmmlFile.setUpdateUser(user.getUserId());
		pmmlFile.setUpdateTime(date);
		pmmlFile.setStatus("1");
		 try {
			pmmlFileService.updateAllFile();
			pmmlFileService.updateOneFile(pmmlFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("******发布失败！******");
			return JSONObject.fromObject("{\"success\":false}");
		}

       logger.info("******pmml模型文件发布结束******");
       return JSONObject.fromObject("{\"success\":true}");
   }	
}
