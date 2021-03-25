package com.idm.test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Transfer {

	//将字符串转为输入流
		public static InputStream StringToInputStream(String content) {
			
			if(content != null && !content.trim().equals("")) {
				ByteArrayInputStream bi = new ByteArrayInputStream(content.getBytes());
				return bi;
			}
			
			return null;
		}
		
		//将输入流转为字符串
		public static String InputStreamToString(InputStream is) {
			
			InputStreamReader isReader = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isReader);
			
			String line = null;
			StringBuffer sb = new StringBuffer();
			
			if(is != null) {
				try {
					while((line = br.readLine())!= null) {
						sb.append(line);
					}
					isReader.close();
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				return sb.toString();
			}
			
			return null;
			
		}

}
