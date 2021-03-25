package com.idm.common.xss;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class XssShellInterceptor  extends HttpServletRequestWrapper{

	public XssShellInterceptor(HttpServletRequest request) {
		super(request);
	}
	
	public String[] getParameterValues(String parameter) {
	      String[] values = super.getParameterValues(parameter);
	      if (values==null)  {
	                  return null;
	          }
	      int count = values.length;
	      String[] encodedValues = new String[count];
	      for (int i = 0; i < count; i++) {
	                 encodedValues[i] = cleanXSS(values[i]);
	       }
	      return encodedValues;
	    }
	    public String getParameter(String parameter) {
	          String value = super.getParameter(parameter);
	          if (value == null) {
	                 return null;
	                  }
	          return cleanXSS(value);
	    }
	    public String getHeader(String name) {
	        String value = super.getHeader(name);
	        if (value == null)
	            return null;
	        return cleanXSS(value);
	    }
	    
	    //过滤规则 目前我只配了过滤 script 
	    private String cleanXSS(String value) {
	    	value = value.replaceAll("<", "<").replaceAll(">", ">");
	         value = value.replaceAll("\\(", "(").replaceAll("\\)", ")");
	        //value = value.replaceAll("<", "& lt;").replaceAll(">", "& gt;");
	        //value = value.replaceAll("\\(", "& #40;").replaceAll("\\)", "& #41;");
	        //value = value.replaceAll("'", "& #39;");
	        //value = value.replaceAll("eval\\((.*)\\)", "");
	        value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
	        value = value.replaceAll("script", "");
	        value = value.replaceAll("'", "");
	        value = value.replaceAll(";", "");
	        value = value.replaceAll("--+", "");
	        return value;
	    }

}
