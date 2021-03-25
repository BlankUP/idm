package com.idm.app.idpconfig.bom.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idm.app.idpconfig.bom.model.BomInfo;
import com.idm.app.idpconfig.bom.model.Field;
import com.idm.app.idpconfig.bom.service.BomInfoService;
import com.idm.app.idpconfig.bom.util.DataSourceUtil;
import com.idm.app.idpconfig.bom.util.XSDGenerate;
import com.idm.app.idpconfig.eventconfig.model.InterfaceInfo;
import com.idm.app.idpconfig.eventconfig.service.EventConfigService;
import com.idm.app.idpconfig.proModelParaConfig.model.ModelQParaField;
import com.idm.app.idpconfig.proModelParaConfig.model.ParaBaseInfo;
import com.idm.app.idpconfig.sharefile.model.ShareFile;
import com.idm.app.idpconfig.sharefile.service.ShareFileService;
import com.idm.app.system.login.model.IDMUser;
import com.idm.app.system.loginfo.model.SysLog;
import com.idm.common.util.DownloadUtil;
import com.idm.common.util.ResByPageVo;
import com.idm.common.util.getVsesion;

import net.sf.json.JSONObject;



/**
 * 
 *<P>Title:BomInfoController</P>
 *@Description:bom文件管理及自动生成控制类
 *@author wangchunzhi
 *@date 2019年2月26日
 *@version 1.0
 */
@Controller
public class BomInfoController {
	
    private Logger logger = Logger.getLogger(BomInfoController.class);
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    static SimpleDateFormat sdfYmd = new SimpleDateFormat("yyyyMMdd");

    @Autowired
    private   BomInfoService bomInfoService;
    
    @Autowired
    private  ShareFileService shareFileService;
    
    @Autowired
    private  EventConfigService eventConfigService;
    
    String format="xsd";		//下载格式
    String name="Application";	//下载名称
    
    @Value("${loginName}")
	private  String loginName;
	@Value("${BOM_FILE}")
	private String BOM_FILE;
	@Value("${RDIP_MetaData_URL}")
	private  String RDIP_MetaData_URL;
	@Value("${BOM_BASE_FILE}")
	private  String BOM_BASE_FILE;
    
    
    /**
     * 
     * @Description: BOM生成
     * @param request
     * @param bomInfo
     * @param roles
     * @return
     */
    @RequestMapping("/bom_create")
    @ResponseBody
    @SysLog(operate="BOM生成或修改BOM信息",module="BOM版本管理")
    public Object bomCreate(HttpServletRequest request,BomInfo bomInfo, String roles)
    
    {
    	logger.info("******生成BOM文件开始******");
    	System.out.println("传入的版本信息："+bomInfo.toString());
    	String bomId  = request.getParameter("bomId");						//编号
    	String versionDepiction = request.getParameter("versionDepiction");	//描述
    	String bomVersionName = request.getParameter("bomVersionName");	//描述
    	String option  = request.getParameter("option");					//方法类型
    	logger.info("版本描述:["+versionDepiction+"]");
    	logger.info("版本名称:["+bomVersionName+"]");
    	IDMUser user = (IDMUser)request.getSession().getAttribute("user");
    	String date = sdf.format(new Date());
    	if("add".equals(option)){
    		try {
				boolean getNew = SyndataSource();
				if (!getNew) {
					logger.error("******更新字段信息失败******");
					return JSONObject.fromObject("{\"success\":false}");
				}
    		List<InterfaceInfo> listI=eventConfigService.queryInterfaceInfo();
        	List<Field> listF=bomInfoService.queryFieldList();
        	List<ModelQParaField>  modelFieldlist=bomInfoService.queryModelQFieldList();
        	List<ParaBaseInfo> listPB=bomInfoService.getParaList();
        	
        	long dateTime= new Date().getTime();
        	int num = (int) ((Math.random()*9+1)*1000);
        	String  id = String.valueOf(dateTime) + String.valueOf(num);
        	long i =shareFileService.queryVersion();		//获取版本号
        	String  version = getVsesion.newVersio(i) ;		//增加时间生成新的版本号
        	String fileName = version+".xsd";
//        	String path = "D:"+File.separator+"BOM"+File.separator+sdfYmd.format(new Date());
        	String path = BOM_FILE+File.separator+sdfYmd.format(new Date());
        	File file=new File(path);
        	if(!file.exists()){//如果文件夹不存在
    			file.mkdir();//创建文件夹
    		}

        	path +=File.separator+fileName;
        	logger.info("******BOM文件信息生成完成******");
        	
        	//装载BOM表信息
        	bomInfo.setBomVersionNo(version);
        	bomInfo.setVersionDepiction(versionDepiction); 
        	bomInfo.setVersionName(bomVersionName);
        	bomInfo.setCreateTime(date);
        	bomInfo.setUpdateTime(date);
        	bomInfo.setStatus("2");
        	bomInfo.setCreateUser(user.getUserId());
        	bomInfo.setUpdateUser(user.getUserId());
        	bomInfo.setFileId(id);
        	//装载文件表信息
        	ShareFile shareFile = new ShareFile();
        	shareFile.setFileId(id);
        	shareFile.setName(name);
        	shareFile.setVersion(version);
        	shareFile.setFormat(format);
        	shareFile.setFilePath(path);
        	shareFile.setFileName(fileName);
        	shareFile.setCreateTime(date);
        	shareFile.setCreateUser(user.getUserId());
        	//更新字段信息

        	if(XSDGenerate.createBOM(path, listI, listF,listPB,modelFieldlist,BOM_BASE_FILE)){
            	
        		bomInfoService.addBomInfo(bomInfo);	//存储BOM基本信息
            	shareFileService.addShareFile(shareFile);
        		logger.info("******生成BOM文件完成******");
        	}else{
        		logger.error("******生成BOM文件错误******");
        		return JSONObject.fromObject("{\"success\":false}");
        	}
    		} catch (Exception e) {
				e.printStackTrace();
				logger.error("******生成BOM文件错误******");
        		return JSONObject.fromObject("{\"success\":false}");
			}
    		return JSONObject.fromObject("{\"success\":true}");
    	}else if("update".equals(option)){
    		//更新
            	try {
            		logger.info("******BOM修改开始******");
            		bomInfo.setBomId(bomId);
            		bomInfo.setVersionDepiction(versionDepiction); 
                	bomInfo.setUpdateTime(date);
                	bomInfo.setUpdateUser(user.getUserId());
                	bomInfoService.updateBomInfo(bomInfo);
    			} catch (Exception e) {
    				 logger.error(e.getMessage());
    				 logger.info("******BOM修改结束******");
    	             return "更新数据失败";
    			}
    		return JSONObject.fromObject("{\"success\":true}");
    	}
		
    	return JSONObject.fromObject("{\"success\":true}");
    }
    
    @RequestMapping("/bom_info")
    public String eventConfig(Model model)
    {
        return "idpconfig/bom/bomList";
    }

    /**
     * 
     * @Description: 查询
     * @param request
     * @return
     */
    @RequestMapping("/bominfo_query")
    @ResponseBody
    @SysLog(operate="BOM信息查询",module="BOM版本管理")
    public Object bominfoQuery(HttpServletRequest request)
    {
    	logger.info("******bom版本信息查询开始******");
        String bomVersionNo = request.getParameter("bomVersionNo");		//版本号
        logger.info("******bomVersionNo:["+bomVersionNo+"]");
		int page = Integer.parseInt(request.getParameter("page"));
		int size = Integer.parseInt(request.getParameter("rows"));
		logger.info("******page:["+page+"]");
		logger.info("******size:["+size+"]");
		ResByPageVo resByPageVo = null;
        BomInfo bomInfo = new BomInfo();
        bomInfo.setBomVersionNo(bomVersionNo);
        List<BomInfo>  bomInfolist = bomInfoService.queryBomInfo(bomInfo);
        bomInfo.setPage(page);
        bomInfo.setSize(size);
		resByPageVo = new ResByPageVo(size, page,bomInfoService.selectCountByAll(bomInfo));
		resByPageVo.setRows(bomInfoService.queryBomInfo(bomInfo));
        logger.info("******bom版本信息查询结束******");
        return JSONObject.fromObject(resByPageVo);
    }
    /**
     * 
     * @Description: 下载BOM文件
     * @param request
     * @return
     */
	@RequestMapping("/bom_download")
	@ResponseBody
	@SysLog(operate="BOM文件下载",module="BOM版本管理")
	public Object bomDownload(HttpServletRequest request,HttpServletResponse response) throws FileNotFoundException {
		logger.info("******下载BOM文件开始******");
		boolean json = true;
		String fileId = request.getParameter("fileId");
		String bomId = request.getParameter("bomId");
		
		logger.info("fileId："+fileId);
		logger.info("bomId："+bomId);
		
	 	IDMUser user = (IDMUser)request.getSession().getAttribute("user");
		ShareFile shareFile = new ShareFile();
		shareFile.setFileId(fileId);
		BomInfo bomInfo = new BomInfo();
		bomInfo.setBomId(bomId);
		bomInfo.setUpdateUser(user.getUserId());
		bomInfo.setUpdateTime(sdf.format(new Date()));
		bomInfo.setStatus("0");
		//查询文件下载信息
		List<ShareFile> shareFileList = shareFileService.queryShareFile(shareFile);
	    logger.info("******查询文件信息******");
		if (shareFileList.size() > 0) {
			shareFile = shareFileList.get(0);
			String path =shareFile.getFilePath();
			String fileName = shareFile.getName()+"."+shareFile.getFormat();
			logger.info("文件路径："+shareFile.getFilePath());
			//修改版本状态
			try {
				bomInfoService.updateAllBomInfoStatus();
				bomInfoService.updateBomInfoStatus(bomInfo);
			} catch (Exception e) {
				// TODO Auto-generated catch block
			    logger.error("******BOM数据存储异常******");
				e.printStackTrace();
			}
			File file = new File(path);
			if (!file.exists()) {
				logger.info("******BOM不存在******");
				logger.info("******下载BOM文件结束******");
				json = false;
				return json;
			}
			logger.info("******开始下载******");
			if(DownloadUtil.downloadLocal(path, fileName, response)){
				System.out.println("下载跳转成功");
			}else{
				json = false;
			}
		} else {
			json = false;
		}
		logger.info("******下载BOM文件结束******");
		logger.info("******json******"+json);
		return json;
	}
	/**
	 * 
	 *@Description:同步接口平台接口信息和字段信息的方法
	 *@param request
	 * @return 
	 *@return
	 */

	 public   boolean SyndataSource(){
		boolean result=true;
		DataSourceUtil dataSourceUtil=new DataSourceUtil();
		result = dataSourceUtil.sendToInterfaceP(RDIP_MetaData_URL,bomInfoService,loginName);
		return result;

	}
}
