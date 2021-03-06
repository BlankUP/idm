package com.idm.app.system.csvprocess.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.idm.app.idpconfig.mqiAdbRuleHotDeploy.model.MqiServerInfo;
import com.idm.app.system.auth.model.Organization;
import com.idm.app.system.auth.service.OrganizationService;
import com.idm.app.system.csvprocess.util.SFTPUtil;
import com.idm.app.system.serverconfig.model.ServerInfo;
import com.idm.app.system.serverconfig.service.ServerConfigService;
import com.idm.common.http.HttpClient;
import com.idm.common.util.DateUtil;
import com.idm.common.util.HttpTool;
import com.idm.common.util.UuidUtils;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;

import oracle.net.aso.a;

/**
 *解析CSV文件,定时存入数据库
 *<P>Title:</P>
 *@Description:
 *@author panling
 *@date 2019年7月9日
 *@version
 */
@Controller
public class CSVController {

	private static final Logger logger = LoggerFactory.getLogger(CSVController.class);
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	@Value("${FTP_ADDRESS}")
	private String server;
    @Value("${FTP_PORT}")
    private int port;
    @Value("${FTP_USERNAME}")
    private String username;
    @Value("${FTP_PASSWORD}")
    private String password;
	@Value("${FTPPATH}")
	private String ftppath;
	@Value("${FILENAME}")
	private String filename;
	@Value("${ORG_URL}")
	private String orgUrl;
	@Value("${MQI_ORG_URL}")
	private String mqiOrgUrl;
	
	@Value("${IDP_TIMEOUT}")
	private Integer TimeOut;
	
	@Autowired
	private OrganizationService organizationService;
	
	@Autowired
	private ServerConfigService serverConfigService;
	@Scheduled(cron="0 0 8 ? * ? ")
	public void csv() throws JSchException, SftpException {
		
		String date = sdf.format(new Date());
		SFTPUtil sftpUtil = new SFTPUtil(username,password,server,port);
		ChannelSftp sftp = sftpUtil.login();
		//先将数据库中机构状态更改
		List<Organization> orgList = organizationService.selectAllByStruts();
		if (orgList.size() != 0) {	
			for (Organization organization : orgList) {
				organization.setSTRUTS("1");
				organizationService.updateOrgInfo(organization);	
			}	
		}
		logger.info("*****文件存在机构状态修改成功*****");
		String src = ftppath+File.separator+date+File.separator+filename;
		Organization org = null;
		BufferedReader br = null;
		String str ="";                        
		try {
			br = new BufferedReader(new InputStreamReader(sftp.get(src),"utf-8"));
			while ((str = br.readLine())!=null) {
				String[] str1 = str.split("\\|");
				if ("".equals(str1[0]) || str1[0] == null) {
					break;
				}
					org = new Organization();
					org.setDeptId(str1[0].trim());
					org.setDeptName(str1[1].trim());
					org.setBRANCH_SHORT(str1[2].trim());
					org.setCHEQUE_ISSUING_BRANCH(str1[3].trim());
					org.setINTERNAL_CLIENT(str1[4].trim());
					org.setCOMPANY(str1[5].trim());
					org.setCOUNTRY(str1[6].trim());
					org.setSTATE(str1[7].trim());
					org.setBASE_CCY(str1[8].trim());
					org.setLOCAL_CCY(str1[9].trim());
					org.setPROFIT_SEGMENT(str1[10].trim());
					org.setHIERARCHY_CODE(str1[11].trim());
					org.setATTACHED_TO(str1[12].trim());
					org.setTRAN_BR_IND(str1[13].trim());
					org.setSUB_BRANCH_CODE(str1[14].trim());
					org.setCNY_BUSINESS_UNIT(str1[15].trim());
					org.setHKD_BUSINESS_UNIT(str1[16].trim());
					org.setFX_ORGAN_CODE(str1[17].trim());
					org.setIS_CHK_SEAL(str1[18].trim());
					org.setSETTLE_LEVEL(str1[19].trim());
					org.setSETTLE_BRANCH(str1[20].trim());
					org.setPAYMENT_BRANCH_FLAG(str1[21].trim());
					org.setPAYMENT_BRANCH(str1[22].trim());
					org.setSETTLE_GL_CODE(str1[23].trim());
					org.setSETTLE_GL_SEQ(str1[24].trim());
					org.setSETTLE_GL_CODE_UP(str1[25].trim());
					org.setSETTLE_GL_SEQ_UP(str1[26].trim());
					org.setPAYMENT_ACCT_GL_CODE(str1[27].trim());
					org.setPAYMENT_ACCT_GL_SEQ(str1[28].trim());
					org.setSETTLE_ACCT_OPEN_FALG(str1[29].trim());
					org.setSETTLE_ACCT_CHECK_FUND(str1[30].trim());
					org.setPAYMENT_ACCT_OPEN_FLAG(str1[31].trim());
					org.setPBOC_FUND_CHECK_FALG(str1[32].trim());
					org.setVB(str1[33].trim());
					org.setVB_LEVEL(str1[34].trim());
					org.setVB_CASH_SAVE(str1[35].trim());
					org.setOPEN_MORE_FLAG(str1[36].trim());
					org.setIS_FINANCIAL_ACCT(str1[37].trim());
					org.setFINANCIAL_ACCT_CONTROL(str1[38].trim());
					org.setCB_AUTH_AMT(str1[39].trim());
					org.setAREA_AUTH_AMT(str1[40].trim());
					org.setIS_USE_PAY_PWD(str1[41].trim());
					org.setIS_CHK_SEAL_NEW(str1[42].trim());
					org.setCHECK_SEAL_SWITCH(str1[43].trim());
					org.setBRANCH_LEVEL(str1[44].trim());
					org.setSTRUTS("0");
					org.setCREATETIME(DateUtil.getNowDatetime());
					org.setDEPTNO(UuidUtils.getRequestNo());
				organizationService.saveOrgInfo(org);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SftpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
		
				//机构缓存信息同步
				String res = "flase";
				String prams = "{}";
				List<Organization> orgList1 = null;
				List<ServerInfo> serverList = null;
			try {
					orgList1 = organizationService.selectAllByStruts();
					if (orgList1.size() > 0) {
						 serverList = serverConfigService.queryServers();
						 for (ServerInfo serverInfo : serverList) {
							 logger.info("***系统ip***"+serverInfo);
							 if ("1".equals(serverInfo.getType())) {
								 logger.info("http://"+serverInfo.getIp()+":"+serverInfo.getPort()+"/"+orgUrl);
								 res = HttpClient.sendPost("http://"+serverInfo.getIp()+":"+serverInfo.getPort()+"/"+orgUrl, prams);
							}else if ("2".equals(serverInfo.getType())) {
								 res = HttpClient.sendPost("http://"+serverInfo.getIp()+":"+serverInfo.getPort()+"/"+mqiOrgUrl, prams);
								 logger.info("http://"+serverInfo.getIp()+":"+serverInfo.getPort()+"/"+mqiOrgUrl);

							}
							 if (res =="true") {
								 logger.info("~~~~~~机构信息"+serverInfo.getIp()+"缓存加载成功~~~~~~");
							 }
						}
					}
				} catch (Exception e) {
					logger.info("~~~~~~机构信息缓存加载失败~~~~~~");					
				}			
		
	}
				
}
