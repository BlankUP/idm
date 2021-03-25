package com.idm.common.util;
/**   
 * @Description:Json工具
 * @author: sjf
 * @date:   2019年3月13日
 * @Copyright: 2019 www.sunline.cn All rights reserved. 
 * 
 */
public class JsonTool {
	
	/**
	 * 
	 * @Description: 格式化JSON字符串
	 * @param 未格式化的JSON字符串    
	 * @return: String-格式化后的JSON报文
	 * @author sjf
	 */
	public static String JsonFormart(String s) {
        int level = 0;
        StringBuffer jsonForMatStr = new StringBuffer();
        for(int index=0;index<s.length();index++)//将字符串中的字符逐个按行输出
        {

            char c = s.charAt(index);             
            /**
             * level大于0并且jsonForMatStr中的最后一个字符为\n,jsonForMatStr加入\t
             */
            if (level > 0 && '\n' == jsonForMatStr.charAt(jsonForMatStr.length() - 1)) {
                jsonForMatStr.append(getLevelStr(level));

            }
           
            switch (c) {
            case '{':
            case '[':
                jsonForMatStr.append(c + "\n");
                level++;
                break;
            case ',':
                jsonForMatStr.append(c + "\n");            
                break;
            case '}':
            case ']':
                jsonForMatStr.append("\n");
                level--;
                jsonForMatStr.append(getLevelStr(level));
                jsonForMatStr.append(c);
                break;
            default:
                jsonForMatStr.append(c);
                break;
            }
        }
        return jsonForMatStr.toString();
    }

	private static String getLevelStr(int level) {
		StringBuffer levelStr = new StringBuffer();
		for (int levelI = 0; levelI < level; levelI++) {
			levelStr.append("\t");
		}
		return levelStr.toString();
	}
}
