package com.idm.common.util;

import org.apache.log4j.Logger;
import sun.misc.BASE64Encoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author lifadeng
 * @Description: 下载常用方法工具类
 * @Create: 2018/11/20 10:36
 * @Version: 1.0
 */
public class DownloadUtil {

    private static Logger logger = Logger.getLogger(DownloadUtil.class);

    public static void download(File file, HttpServletRequest request, HttpServletResponse response){
        String filename = file.getName();
        //获得请求头中的User-Agent
        String agent = request.getHeader("User-Agent");
        //根据不同浏览器进行不同的编码
        String filenameEncoder = "";
        try{
            if (agent.contains("MSIE")) {
                // IE浏览器
                filenameEncoder = URLEncoder.encode(filename, "utf-8");
                filenameEncoder = filenameEncoder.replace("+", " ");
            } else if (agent.contains("Firefox")) {
                // 火狐浏览器
                BASE64Encoder base64Encoder = new BASE64Encoder();
                filenameEncoder = "=?utf-8?B?"
                        + base64Encoder.encode(filename.getBytes("utf-8")) + "?=";
            } else {
                // 其它浏览器
                filenameEncoder = URLEncoder.encode(filename, "utf-8");
            }
        }catch (Exception e){
            logger.error(e);
        }

        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
        response.setContentType("multipart/form-data");
        //2.设置文件头：最后一个参数是设置下载文件名
        response.setHeader("Content-Disposition", "attachment;fileName="+filenameEncoder);
        ServletOutputStream out;
        try {
            FileInputStream inputStream = new FileInputStream(file);
            //3.通过response获取ServletOutputStream对象(out)
            out = response.getOutputStream();
            int b = 0;
            byte[] buffer = new byte[1024];
            while ((b = inputStream.read(buffer, 0, 1024)) != -1){
                //4.写到输出流(out)中
                out.write(buffer,0,b);
            }
            inputStream.close();
            out.close();
            out.flush();
        } catch (IOException e) {
            logger.error(e);
            //e.printStackTrace();
        }
    }

    public static void downloadExcel(byte[] data, String filename, HttpServletRequest request, HttpServletResponse response){
        //获得请求头中的User-Agent
        String agent = request.getHeader("User-Agent");
        //根据不同浏览器进行不同的编码
        String filenameEncoder = "";
        try{
            if (agent.contains("MSIE")) {
                // IE浏览器
                filenameEncoder = URLEncoder.encode(filename, "utf-8");
                filenameEncoder = filenameEncoder.replace("+", " ");
            } else if (agent.contains("Firefox")) {
                // 火狐浏览器
                BASE64Encoder base64Encoder = new BASE64Encoder();
                filenameEncoder = "=?utf-8?B?"
                        + base64Encoder.encode(filename.getBytes("utf-8")) + "?=";
            } else {
                // 其它浏览器
                filenameEncoder = URLEncoder.encode(filename, "utf-8");
            }
        }catch (Exception e){
            logger.error(e);
        }
        File file = null;
        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
        response.setContentType("multipart/form-data");
        //2.设置文件头：最后一个参数是设置下载文件名
        response.setHeader("Content-Disposition", "attachment;fileName="+filenameEncoder+".xlsx");
        ServletOutputStream out;
        try {
            file = File.createTempFile("temp","xlsx");
            out = response.getOutputStream();
            out.write(data);
            out.close();
            out.flush();
        } catch (IOException e) {
            logger.error(e);
        }finally {
            if(file!=null && file.exists()){
                file.deleteOnExit();
            }
        }
    }
    

	public static boolean downloadLocal(String path, String fileName, HttpServletResponse response) {
		// TODO Auto-generated method stub
	    // 读到流中
		boolean retrn=true;
		try {
			// TODO Auto-generated method stub
		    // 读到流中
	        InputStream inStream = new FileInputStream(path);// 文件的存放路径
	        logger.info("文件已读取");
	        // 设置输出的格式
	        response.reset();
	        response.setContentType("multipart/form-data");
	        System.out.println("fileName:"+fileName);
	        response.addHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
	        // 循环取出流中的数据
	        byte[] b = new byte[1024];
	        ServletOutputStream out;
	        int len=0;
	        try {
	        	
	            //3.通过response获取ServletOutputStream对象(out)
	            out = response.getOutputStream();
	            byte[] buffer = new byte[1024];
	            while ((len = inStream.read(buffer, 0, 1024)) != -1){
	                //4.写到输出流(out)中
	                out.write(buffer,0,len);
	            }
	            inStream.close();
	            out.close();
	            out.flush();
	        } catch (IOException e) {
	            e.printStackTrace();
	            retrn=false;
	        }
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			retrn=false;
			e1.printStackTrace();
		}// 文件的存放路径
		return retrn;
	}


}
