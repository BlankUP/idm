package com.idm.app.system.csvprocess.util;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

/**
 * 
 *<P>Title:工具类</P>
 *@Description:
 *@author panling
 *@date 2019年9月3日
 *@version
 */
public class SftpUtils {

	private static final Logger logger = LoggerFactory.getLogger(SftpUtils.class);
	
	@Value("${FTP_ADDRESS}")
	private String server;
    @Value("${FTP_PORT}")
    private int port;
    @Value("${FTP_USERNAME}")
    private String username;
    @Value("${FTP_PASSWORD}")
    private String password;
    
	 private static ChannelSftp sftp = null;
	 private static Session session = null;
		// 登录
	    public  ChannelSftp login() throws JSchException, SftpException {
	        JSch jSch = new JSch();
	        // 设置用户名和主机，端口号一般都是22
	        session = jSch.getSession(username, server, port);
	        // 设置密码
	        session.setPassword(password);
	        Properties config = new Properties();
	        config.put("StrictHostKeyChecking", "no");
	        session.setConfig(config);
	        session.connect();
	        Channel channel = session.openChannel("sftp");
	        channel.connect();

	        sftp = (ChannelSftp) channel;
	        logger.info("connect success....");
	        return sftp;
	    }
	// 退出登录
	    public  void logout() {
	        if (sftp != null) {
	            if (sftp.isConnected()) {
	                sftp.disconnect();
	            }
	        }
	        if (session != null) {
	            if (session.isConnected()) {
	                session.disconnect();
	            }
	        }
	    }
	
}
