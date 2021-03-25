package com.idm.common.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.idm.common.exception.BusinessException;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.URL;

public class HttpTool {
    private static final Logger logger = Logger.getLogger(HttpTool.class);
    //**************************************************************************
    /**
     * TODO 方法sendRequestData的简要说明 <br><pre>
     * 往urlStr中发送requestData数据，超时时间为timeOut(毫秒)
     * 返回该url的返回数据
     * 方法sendRequestData的详细说明 <br>
     * @param 参数类型 参数名 说明
     * @return String 说明
     * @throws IOException 
     * @throws 异常类型 说明
     */
    //**************************************************************************
    public static String sendRequestData(String requestData, String urlStr, Long timeOut) throws Exception {
        URL url = null;
        HttpURLConnection conn = null;
        ByteArrayOutputStream byteOut = null;
        BufferedReader readInfo = null;
        String returnXml = "";
        OutputStream out = null;
        try {
            logger.info("发送服务请求数据：\n" + new String(requestData.getBytes(), "UTF-8"));
            url = new URL(urlStr);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Accept", "text/html, application/xhtml+xml, */*");            
            conn.setRequestProperty("content-type", "text/xml");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0)");
            conn.setRequestProperty("Accept-Encoding", "gzip, deflate");
            conn.setRequestProperty("Cache-Control", "no-cache");
            conn.setUseCaches(false); //忽略缓存
            conn.setDoOutput(true); //使用 URL 连接进行输入
            conn.setDoInput(true); //使用 URL 连接进行输入
            
            conn.setConnectTimeout(timeOut.intValue());
            conn.setReadTimeout(timeOut.intValue());
            byteOut = new ByteArrayOutputStream();
            byteOut.write(requestData.getBytes("UTF-8"));
            byte[] buf = byteOut.toByteArray();
            out = conn.getOutputStream();
            out.write(buf);
            out.flush();
            out.close();
            if (HttpURLConnection.HTTP_OK == conn.getResponseCode()) {//正确返回 
                readInfo = new BufferedReader(new java.io.InputStreamReader(conn.getInputStream(),"UTF-8"));
                String line = null;
                while ((line = readInfo.readLine()) != null) {
                    returnXml = returnXml + line;
                }
            } else {//没有正确返回
                logger.info("没有正确连接行业接口平台或者行业平台服务返回有误,返回编码：" + conn.getResponseCode());
                returnXml = "行业接口服务出现问题,返回编码：" + conn.getResponseCode();
            }
            logger.info("服务返回数据：\n" + returnXml);
        } catch (SocketException ex) {
            logger.error("socket通讯异常，通讯地址："+urlStr);
            throw  ex;
        } catch (IOException ex) {
            logger.error("io通讯异常，通讯地址："+urlStr);
            throw ex;
        } finally {
            try{
                if (readInfo != null) {
                    readInfo.close();
                }
                if (byteOut != null) {
                    byteOut.close();
                }
                if (out != null) {
                    out.close();
                }
                if (conn != null) {
                    conn.disconnect();
                }
            }catch(Exception e){
                logger.warn("关闭平台链接出错!");
                e.printStackTrace();
            }
            
        }
        return returnXml;
    }
   
    /**
     * 
     * @Description: HTTP调用决策服务平台
     * @param url
     * @param jsonStr
     * @param TimeOut
     * @throws Exception      
     * @return: String      
     * @author sjf
     */
	public static String sendIDP(String url,String jsonStr, Integer TimeOut) throws Exception{
		
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader(new BasicHeader("Content-Type", "application/json;charset=UTF-8"));
		httpPost.setEntity(new StringEntity(jsonStr,"UTF-8"));
		CloseableHttpClient client = HttpClients.createDefault();
		String respContent = null;

		RequestConfig requestConfig = RequestConfig.custom()
				.setConnectTimeout(TimeOut.intValue())
				.setConnectionRequestTimeout(1000)
				.setSocketTimeout(TimeOut.intValue()).build();

		httpPost.setConfig(requestConfig);
		CloseableHttpResponse resp = null;
		try {
			resp = client.execute(httpPost);
			if (resp.getStatusLine().getStatusCode() == 200) {
				HttpEntity httpEntity = resp.getEntity();
				respContent = EntityUtils.toString(httpEntity,"UTF-8");
			}
		}catch (IOException e) {
			throw e;
		}finally {
			if(resp!=null) {
				try {
					resp.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			try {
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return respContent;
	}
   
}