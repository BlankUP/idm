package com.idm.app.idpconfig.adbVersionManage.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;


/**
 * @Util adb规则文件的上传和下载
 * @author wengjiawei
 * @Date 2019-03-13
 *
 */
@Service
public class AdbFileUtil {
	static final Logger logger = Logger.getLogger(AdbFileUtil.class);
	
	/**
	 * 	初始化FTP连接
	 * @param server 服务器IP地址
	 * @param port   端口号
	 * @param userName 用户名
	 * @param passWord 密码
	 */
	public FTPClient  initFtpClient(String server,int port,String userName,String passWord) {
		FTPClient ftpClient = new FTPClient();	
		logger.info("******开始连接FTP******");
		try {  
            ftpClient = new FTPClient();  
            ftpClient.connect(server, port);   //连接FTP服务器  
            ftpClient.login(userName, passWord);   // 登陆FTP服务器  
            if (!FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {  
                logger.info("connect failed...ftp服务器:"+ server +":"+ port);  
                ftpClient.disconnect();  
            } else {  
            	logger.info("connect successful...ftp服务器:"+ server +":"+ port);
            }  
        } catch (SocketException e) {  
            e.printStackTrace();  
            logger.error("FTP的IP地址可能错误，请正确配置！");  
        } catch (IOException e) {  
            e.printStackTrace();  
            logger.error("FTP的端口错误,请正确配置！");  
        }
		logger.info("******连接FTP结束******");
		return ftpClient;
	}

	 
	/**
	 * * 下载文件 *
	 * 
	 * @param pathname
	 *            FTP服务器文件目录 *
	 * @param filename
	 *            文件名称 *
	 * @param localpath
	 *            下载后的文件路径 *
	 * @return
	 */
/*	public boolean downloadFile(String pathname, String filename, String localpath) {
		boolean flag = false;
		OutputStream os = null;
		try {
			System.out.println("开始下载文件");
			initFtpClient();
			// 切换FTP目录
			boolean changeFlag = ftpClient.changeWorkingDirectory(pathname);
			System.err.println("changeFlag==" + changeFlag);
 
			ftpClient.enterLocalPassiveMode();
			ftpClient.setRemoteVerificationEnabled(false);
			// 查看有哪些文件夹 以确定切换的ftp路径正确
			String[] a = ftpClient.listNames();
			System.err.println(a[0]);
 
			FTPFile[] ftpFiles = ftpClient.listFiles();
			for (FTPFile file : ftpFiles) {
				if (filename.equalsIgnoreCase(file.getName())) {
					File localFile = new File(localpath + "/" + file.getName());
					os = new FileOutputStream(localFile);
					ftpClient.retrieveFile(file.getName(), os);
					os.close();
				}
			}
			ftpClient.logout();
			flag = true;
			System.out.println("下载文件成功");
		} catch (Exception e) {
			System.out.println("下载文件失败");
			e.printStackTrace();
		} finally {
			if (ftpClient.isConnected()) {
				try {
					ftpClient.disconnect();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != os) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return flag;
	}*/

	/**
	  *  从服务器中下载文件 
	 * @param server 服务器IP地址
	 * @param port   端口号
	 * @param userName 用户名
	 * @param passWord 密码
	 * @param ftpPath ftp地址
	 * @param localPath 下载到本地的路径
	 * @param fK_ADB_PATH 
	 * @param  
	 */
	public Boolean downLoadAdbFile(String server,int port,String userName,String passWord,String fileName,String localPath, String FK_ADB_PATH ) {
		FTPClient ftpClient = null;
		boolean flag = false;
		Map<Date,String> map = new HashMap<Date,String>();
		Date lastModifiedDate = null;   //ftp路径下文件的最后修改时间		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date fileDate = null;
		try {
			fileDate = sdf.parse("1999-12-31");   //最后需要下载的文件时间
		} catch (ParseException e1) {
			
			e1.printStackTrace();
		}   
		
		logger.info("******开始从FTP下载文件！******");
		try {  
			
			//初始化FTPClient
	        ftpClient = initFtpClient(server, port,userName, passWord);  
	        ftpClient.setControlEncoding("UTF-8");     //中文支持  
	        ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);  
	        ftpClient.enterLocalPassiveMode();  
	        ftpClient.setBufferSize(1024*1024);
	        //切换到服务器路径
	        
	        boolean changeWorkingDirectory2 = ftpClient.changeWorkingDirectory(FK_ADB_PATH);
	        if(changeWorkingDirectory2) {
	        FTPFile[] ftpFiles = ftpClient.listFiles(); 
            for(FTPFile file : ftpFiles){             	
            	logger.info("下载路径中的文件：" + file.getName());            	
            	//获取文件后缀名
                String suffixName = file.getName().substring(file.getName().lastIndexOf("."));
                logger.info("该文件的后缀为：" + suffixName);
                //fileName.equalsIgnoreCase(file.getName())
                if(".adb".equals(suffixName)){
                	logger.info(">>>>>>识别文件成功>>>>>>");
                	logger.info("可能需要下载的文件名：" + file.getName());
                	lastModifiedDate = file.getTimestamp().getTime();
                	logger.info("可能需要下载的文件名的最后修改时间为：" + sdf1.format(lastModifiedDate)); 
                	if(fileDate.compareTo(lastModifiedDate)<0) {
                		map.clear();    //清空map中的数据
                		map.put(lastModifiedDate,file.getName()); //将文件名称和修改时间放入map中               		
                		fileDate = lastModifiedDate;                		
                	}                	                   
                }                
            }
            logger.info("下载的文件名：" + map.get(fileDate));
            logger.info("下载的文件修改时间：" + sdf1.format(fileDate));
            //========================================================
            File localFile = new File(localPath + fileName); 
            logger.info("文件下载路径：" + localPath + fileName);
            OutputStream os = new FileOutputStream(localFile); 
            //复制文件流
            long startTime1 = System.currentTimeMillis();  //获取开始时间

            ftpClient.retrieveFile(map.get(fileDate), os); 
            long endTime1 = System.currentTimeMillis();   //获取结束时间
            System.out.println("代码运行时间：" + (endTime1 - startTime1) + "ms");   //输出程序运行时间
            os.close(); 
            ftpClient.logout();  
        	flag = true; 
        	logger.info("******文件下载成功 !******");
            
	        }else {
	        	logger.error("adb文件路径失败！");  
	        	 flag = false;
	        	 return flag;
			}
	    } catch (FileNotFoundException e) {  
	    	logger.error("没有找到" + FK_ADB_PATH + "文件"); 
	    	flag = false;
	        e.printStackTrace();  
	    } catch (SocketException e) {  
	        logger.error("连接FTP失败！");  
	        flag = false;
	        e.printStackTrace();  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	        logger.error("文件读取错误！");  
	        flag = false;
	        e.printStackTrace();  
	    }
		logger.info("******下载文件结束******");
        return flag;
	}
	
	/**
	 * 将文件上传至服务器中
	 * @param server 服务器IP地址
	 * @param port   端口号
	 * @param userName 用户名
	 * @param passWord 密码
	 * @param ftpPath  ftp路径
	 * @param fileName 上传至ftp的文件名
	 * @param localPath 上传文件的本地路径
	 * @return
	 */
	public Boolean uploadAdbFile(String server,int port,String userName,String passWord,
			String ftpPath,String fileName,String localPath) {
		InputStream inputStream = null;
		FTPClient ftpClient = null;
		boolean flag = false;
		logger.info("******开始上传文件******");
        try{
            inputStream = new FileInputStream(new File(localPath));
            logger.info("上传文件为：" + localPath);
            //初始化FTPClient
            ftpClient = initFtpClient(server, port,userName, passWord);
            //设置文件以二进制形式上传
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            //切换到服务器路径
            ftpClient.changeWorkingDirectory(ftpPath);
            logger.info("上传到服务器路径:" + ftpPath);
            logger.info("上传到服务器文件名为:" + fileName);
            //开始上传文件
            ftpClient.storeFile(fileName, inputStream);
            inputStream.close();
            ftpClient.logout();
            logger.info("上传文件成功！");
            flag = true;
        }catch (Exception e) {
        	logger.info("上传文件失败！");
        	 flag = false;
            e.printStackTrace();
        }finally{
            if(ftpClient.isConnected()){ 
                try{
                    ftpClient.disconnect();
                }catch(IOException e){
                    e.printStackTrace();
                }
            } 
            if(null != inputStream){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } 
            } 
        }
        logger.info("******上传文件结束！******");
        return flag;
	}	
}
