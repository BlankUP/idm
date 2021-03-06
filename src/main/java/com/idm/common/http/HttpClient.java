package com.idm.common.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

/**
 * http服务端
 * @author wangke
 *
 */
public class HttpClient {     
	

	/**
	 * 发送POST请求
	 * @param url
	 * @param parameters
	 * @return
	 */
	public static String sendPost(String url, String parameters) {        
		String result = "";// ‘
		BufferedReader in = null;// 读取响应输入流      
		OutputStream os=null;
		StringBuffer sb = new StringBuffer();// 处理请求参数  
		HttpURLConnection connection =null;
		try {              
					java.net.URL connURL = new java.net.URL(url);       
					connection = (HttpURLConnection) connURL.openConnection();
					// 设置通用属性 
	            connection.setDoInput(true);//设置是否向httpUrlConnection输出，因为这个是post请求，参数要放在http正文内，因此需要设为true, 默认是false
	            connection.setDoOutput(true);//设置是否从httpUrlConnection读入，默认情况下是true;
	            connection.setRequestMethod("POST");
	            connection.setUseCaches(false);
	            connection.setInstanceFollowRedirects(true);               
	            connection.setRequestProperty("Content-Type", "application/json;charset=utf-8"); // 设置发送数据的格式
	            connection.connect();
	            //发送请求数据
	            os = connection.getOutputStream() ;
	            os.write(parameters.getBytes("UTF-8"));
	            //获取返回数据
	            int resultCode=connection.getResponseCode();
	            String lines;
	            if(HttpURLConnection.HTTP_OK==resultCode){
	            		try (BufferedReader reader = new BufferedReader( new InputStreamReader(connection.getInputStream(),"UTF-8"))) {
			                      StringBuffer sbf = new StringBuffer();
			                      while ((lines = reader.readLine()) != null) {
			                          lines = new String(lines.getBytes());
			                          sbf.append(lines);
			                      }
                      result = sbf.toString();    
                  }
                  connection.disconnect();
            }
           
			} catch (Exception e) {            
				e.printStackTrace();        
				} finally {           				     
						try {
							if (os != null) {                    
								os.close();                
								}               
							if (in != null) {                   
								in.close();               
								}   
							if(connection != null) {
								connection.disconnect();
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
				}
		return result;   
		}
	
	
		}
	


