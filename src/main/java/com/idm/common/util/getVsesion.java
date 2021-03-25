package com.idm.common.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class getVsesion {

    static SimpleDateFormat sdfYmd = new SimpleDateFormat("yyyyMMdd");
    static DecimalFormat df=new DecimalFormat("0000");
    
	public static String newVersio(long i) {
		String result="";
		result = sdfYmd.format(new Date())+df.format(i);
		return result;
	}
}
