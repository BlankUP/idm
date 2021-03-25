package com.idm.common.util;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
* <p>Title: IPUtil</p>  
* @Description: 获取服务器IP
* @author wangke  
* @date 2019年2月28日
* @version  1.0
 */
public class IPUtil {

	
	public static String getServerIp(){
		try {
			Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
			while(allNetInterfaces.hasMoreElements()){
				NetworkInterface netInterface =(NetworkInterface)allNetInterfaces.nextElement();
				Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
				while(addresses.hasMoreElements()){
					InetAddress ip =(InetAddress)addresses.nextElement();
					if(ip!=null && ip instanceof Inet4Address && !ip.isLoopbackAddress() && ip.getHostAddress().indexOf(":")==-1){
						return ip.getHostAddress();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println("IP:"+getServerIp());
	}
	
}
