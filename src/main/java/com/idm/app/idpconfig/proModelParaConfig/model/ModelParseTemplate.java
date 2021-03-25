/**
 * 
 */
package com.idm.app.idpconfig.proModelParaConfig.model;

/**    
 * <p>产品模型解析模板实体类</p>
 * @author caiwenjian  
 * @date 2019年3月20日  
 * @version 1.0  
 */
public class ModelParseTemplate {
	private String templatecode;  //解析模板编码
    private String templatename;  //解析模板名称

	public String getTemplatecode() {
		return templatecode;
	}

	public void setTemplatecode(String templatecode) {
		this.templatecode = templatecode;
	}

	public String getTemplatename() {
		return templatename;
	}

	public void setTemplatename(String templatename) {
		this.templatename = templatename;
	}
}
