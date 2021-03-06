package com.idm.app.system.csvprocess.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.tomcat.jni.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FTPUtils {

	 /** 日志对象 **/
    private static final Logger LOGGER = LoggerFactory.getLogger(FTPUtils.class);
 
    /** 本地字符编码  **/
    private static String localCharset = "GBK";
    
    /** FTP协议里面，规定文件名编码为iso-8859-1 **/
    private static String serverCharset = "ISO-8859-1";
    
    /** UTF-8字符编码 **/
    private static final String CHARSET_UTF8 = "UTF-8";
    
    /** OPTS UTF8字符串常量 **/
    private static final String OPTS_UTF8 = "OPTS UTF8";
    
    /** 设置缓冲区大小4M **/
    private static final int BUFFER_SIZE = 1024 * 1024 * 4;
    
    /** FTPClient对象 **/
    private static FTPClient ftpClient = null;

    
    /**
     * 根据名称获取文件，以输入流返回
     * 
     * @param ftpPath FTP服务器上文件相对路径，例如：test/123
     * @param fileName 文件名，例如：test.txt
     * @return InputStream 输入流对象
     */
    public InputStream getInputStreamByName(String server,int port,String username,String password,String ftpPath, String fileName) {
    	// 登录
    	login(server, port, username, password);
        InputStream input = null;
        if (ftpClient != null) {
            try {
  //              String path = changeEncoding(ftpPath);
                // 判断是否存在该目录
               if (!ftpClient.changeWorkingDirectory(ftpPath)) {
                    LOGGER.error(ftpPath + "该目录不存在");
                    return input;
                }
                ftpClient.enterLocalPassiveMode();  // 设置被动模式，开通一个端口来传输数据
                String[] fs = ftpClient.listNames();
                // 判断该目录下是否有文件
                if (fs == null || fs.length == 0) {
                    LOGGER.error(ftpPath + "该目录下没有文件");
                    return input;
                }
                for (String ff : fs) {
                    String ftpName = new String(ff.getBytes(serverCharset), localCharset);
                    if (ftpName.equals(fileName)) {
                        input = ftpClient.retrieveFileStream(ff);
                        break;
                    }
                }
            } catch (IOException e) {
                LOGGER.error("获取文件失败", e);
            } finally {
                closeConnect();
            }
        }
        return input;
    }
    /**
     * 连接FTP服务器
     * 
     * @param address  地址，如：127.0.0.1
     * @param port     端口，如：21
     * @param username 用户名，如：root
     * @param password 密码，如：root
     */
    private void login(String address, int port, String username, String password) {
        ftpClient = new FTPClient();
        try {
            ftpClient.connect(address, port);
            ftpClient.login(username, password);
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            int reply = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                closeConnect();
                LOGGER.error("FTP服务器连接失败");
            }
        } catch (Exception e) {
            LOGGER.error("FTP登录失败", e);
        }
    }
 
    /**
     * 关闭FTP连接
     * 
     */
    private void closeConnect() {
        if (ftpClient != null && ftpClient.isConnected()) {
            try {
                ftpClient.logout();
                ftpClient.disconnect();
            } catch (IOException e) {
                LOGGER.error("关闭FTP连接失败", e);
            }
        }
    }
 
    /**
     * FTP服务器路径编码转换
     * 
     * @param ftpPath FTP服务器路径  
     * @return String
     */
    private static String changeEncoding(String ftpPath) {
        String directory = null;
        try {
            if (FTPReply.isPositiveCompletion(ftpClient.sendCommand(OPTS_UTF8, "ON"))) {
                localCharset = CHARSET_UTF8;
            }
            directory = new String(ftpPath.getBytes(localCharset), serverCharset);
        } catch (Exception e) {
            LOGGER.error("路径编码转换失败", e);
        }
        return directory;
    }
    
    /**
     * 将一个InputStream流转换成字符串
     * 
     * @param is
     * @return
     */
    public static String toConvertString(InputStream is) {
        StringBuffer res = new StringBuffer();
        // 把字节流转化为字符流
        InputStreamReader isr = new InputStreamReader(is);
        // 普通的Reader读取输入内容时依然不太方便，可以将普通的
        // Reader再次包装成BufferedReader,利用BufferReader的readLine()
        // 方法可以一次读取一行内容
        BufferedReader read = new BufferedReader(isr);
        try {
            String line;
            line = read.readLine();
            while (line != null) {
                res.append(line + "<br>");
                line = read.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != isr) {
                    isr.close();
                    isr.close();
                }
                if (null != read) {
                    read.close();
                    read = null;
                }
                if (null != is) {
                    is.close();
                    is = null;
                }
            } catch (IOException e) {
            }
        }
        return res.toString();
    }
}
