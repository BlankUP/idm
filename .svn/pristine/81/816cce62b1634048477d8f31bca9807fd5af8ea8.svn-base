package com.idm.common.util;

import org.apache.log4j.Logger;


/**
 * @Author wengjiawei 
 * @Description: 模糊查询字符处理
 * @Create: 2019-03-28
 * @Version: 1.0
 */
public class QueryStringUtil {

    private static Logger logger = Logger.getLogger(QueryStringUtil.class);

    public static String queryString(String param){
    	StringBuffer newParam = new StringBuffer();
    	if(param != null && !"".equals(param)) {
        	Integer index1 = param.indexOf("\\");
        	newParam.append(param);
        	if(index1 != -1) {
        		while(index1 != -1) {
            		newParam.insert(index1, "\\");
            		index1 = newParam.toString().indexOf("\\", index1+2);
            	}
        		Integer index2 = newParam.toString().indexOf("'");
        		if(index2 != -1) {
        			while(index2 != -1) {
                		newParam.insert(index2, "'");
                		index2 = newParam.toString().indexOf("'", index2+2); 
                	}
        			Integer index3 = newParam.toString().indexOf("%");
            		if(index3 != -1) {
            			while(index3 != -1) {
                    		newParam.insert(index3, "\\");
                    		index3 = newParam.toString().indexOf("%", index3+2); 
                    	}
            			Integer index4 = newParam.toString().indexOf("_");
                		if(index4 != -1) {
                			while(index4 != -1) {
                        		newParam.insert(index4, "\\");
                        		index4 = newParam.toString().indexOf("_", index4+2); 
                        	}            		
                		}
            		}
            		logger.info("newParam1-------" + newParam);
        		}else {
        			Integer index3 = newParam.toString().indexOf("%");
        			if(index3 != -1) {
            			while(index3 != -1) {
                    		newParam.insert(index3, "\\");
                    		index3 = newParam.toString().indexOf("%", index3+2); 
                    	}
            			Integer index4 = newParam.toString().indexOf("_");
                		if(index4 != -1) {
                			while(index4 != -1) {
                        		newParam.insert(index4, "\\");
                        		index4 = newParam.toString().indexOf("_", index4+2); 
                        	}            		
                		}
                		logger.info("newParam2-------" + newParam);
            		}else {
            			Integer index4 = newParam.toString().indexOf("_");
                		if(index4 != -1) {
                			while(index4 != -1) {
                        		newParam.insert(index4, "\\");
                        		index4 = newParam.toString().indexOf("_", index4+2); 
                        	}            		
                		}
                		logger.info("newParam4-------" + newParam);
            		}
        		}        		
        	}else {
        		Integer index2 = newParam.toString().indexOf("'");
        		if(index2 != -1) {
        			while(index2 != -1) {
                		newParam.insert(index2, "'");
                		index2 = newParam.toString().indexOf("'", index2+2); 
                	}
        			Integer index3 = newParam.toString().indexOf("%");
            		if(index3 != -1) {
            			while(index3 != -1) {
                    		newParam.insert(index3, "\\");
                    		index3 = newParam.toString().indexOf("%", index3+2); 
                    	}
            			Integer index4 = newParam.toString().indexOf("_");
                		if(index4 != -1) {
                			while(index4 != -1) {
                        		newParam.insert(index4, "\\");
                        		index4 = newParam.toString().indexOf("_", index4+2); 
                        	}            		
                		}
                		logger.info("newParam5-------" + newParam);
            		}else {
            			Integer index4 = newParam.toString().indexOf("_");
                		if(index4 != -1) {
                			while(index4 != -1) {
                        		newParam.insert(index4, "\\");
                        		index4 = newParam.toString().indexOf("_", index4+2); 
                        	}            		
                		}
                		logger.info("newParam6-------" + newParam);
            		}            		       			
        		}else {
        			Integer index3 = newParam.toString().indexOf("%");
            		if(index3 != -1) {
            			while(index3 != -1) {
                    		newParam.insert(index3, "\\");
                    		index3 = newParam.toString().indexOf("%", index3+2); 
                    	}
            			Integer index4 = newParam.toString().indexOf("_");
                		if(index4 != -1) {
                			while(index4 != -1) {
                        		newParam.insert(index4, "\\");
                        		index4 = newParam.toString().indexOf("_", index4+2); 
                        	}            		
                		}
                		logger.info("newParam7-------" + newParam);
            		}else {
            			Integer index4 = newParam.toString().indexOf("_");
                		if(index4 != -1) {
                			while(index4 != -1) {
                        		newParam.insert(index4, "\\");
                        		index4 = newParam.toString().indexOf("_", index4+2); 
                        	}            		
                		}
                		logger.info("newParam8-------" + newParam);
            		}        			
        		}
        	}
        }
    	logger.info("newParam_final-------" + newParam);
    	return newParam.toString();
    }

    
}
