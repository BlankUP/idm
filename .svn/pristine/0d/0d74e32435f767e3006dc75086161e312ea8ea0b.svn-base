package com.idm.common.util;

import oracle.sql.CLOB;

import java.io.BufferedReader;
import java.io.Reader;
import java.sql.Clob;

/**
 * @Author lifadeng
 * @Description: mybatis工具类
 * @Create: 2018/11/9 14:18
 * @Version: 1.0
 */
public class MybatisUtil {

    /**
     * oracle.sql.Clob类型 转String
     */
    public static String CLOBToString(Object object) throws Exception {
        oracle.sql.CLOB clob = null;
        if(object != null && object instanceof oracle.sql.CLOB){
            clob = (oracle.sql.CLOB)object;
        }else {
            return null;
        }
        String ret = "";
        Reader read= clob.getCharacterStream();
        BufferedReader br = new BufferedReader(read);
        String s = br.readLine();
        StringBuffer sb = new StringBuffer();
        while (s != null) {
            sb.append(s);
            s = br.readLine();
        }
        ret = sb.toString();
        if(br != null){
            br.close();
        }
        if(read != null){
            read.close();
        }
        return ret;
    }

    /**
     * java.sql.Clob类型 转String
     */
    public static String ClobToString(Object object) throws Exception {
        Clob clob = null;
        if(object != null && object instanceof Clob){
            clob = (Clob)object;
        }else {
            return null;
        }
        String ret = "";
        Reader read= clob.getCharacterStream();
        BufferedReader br = new BufferedReader(read);
        String s = br.readLine();
        StringBuffer sb = new StringBuffer();
        while (s != null) {
            sb.append(s);
            s = br.readLine();
        }
        ret = sb.toString();
        if(br != null){
            br.close();
        }
        if(read != null){
            read.close();
        }
        return ret;
    }

}
