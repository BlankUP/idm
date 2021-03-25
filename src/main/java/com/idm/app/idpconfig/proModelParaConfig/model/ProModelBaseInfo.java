package com.idm.app.idpconfig.proModelParaConfig.model;

import java.io.Serializable;

/**
* <p>Description:产品模型表实体类 </p>  
* <p>Company: </p>  
* @author caiwenjian  
* @date 2019年2月25日  
* @version 1.0
 */
public class ProModelBaseInfo  implements Serializable {
	private static final long serialVersionUID = -3537568435590316241L;
	private Integer countId ;	 //数据量
    private String modelid;	     //模型id
    private String orgno;        //机构代码
	private String orgname;      //机构名称
    private String productid;	 //产品id
    private String productcode;  //产品编码	
    private String productname;  //产品名称
    private String modelcode;    //模型编码
    private String modelname;    //模型名称
    /*private String templatecode;  //解析模板编码
    private String templatename;  //解析模板名称
*/  private String modeltype;	//模型类型,1:决策模型;2:PMML模型
    private String pmmlcode;	//PMML编码
    private String pmmlname;    //PMML名称
    private String createuser;  //创建人
    private String updateuser;  //修改人
    private String createtime;	//创建时间
    private String updatetime;	//修改时间
    private String status;	    //状态：有效与无效
    private int page;			 //第几页
	private int size;		     //每页条数
	private int rnm;
    private String respSystemCode;    	//系统编码
	private String respSystemName;		//系统名称


	
	
	public String getRespSystemName() {
		return respSystemName;
	}
	public void setRespSystemName(String respSystemName) {
		this.respSystemName = respSystemName;
	}
	public String getRespSystemCode() {
		return respSystemCode;
	}
	public void setRespSystemCode(String respSystemCode) {
		this.respSystemCode = respSystemCode;
	}
	public String getOrgno() {
		return orgno;
	}
	public void setOrgno(String orgno) {
		this.orgno = orgno;
	}
	public String getOrgname() {
		return orgname;
	}
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getProductcode() {
		return productcode;
	}
	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getCreateuser() {
		return createuser;
	}
	public void setCreateuser(String createuser) {
		this.createuser = createuser;
	}
	public String getUpdateuser() {
		return updateuser;
	}
	public void setUpdateuser(String updateuser) {
		this.updateuser = updateuser;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getModelcode() {
		return modelcode;
	}

	public void setModelcode(String modelcode) {
		this.modelcode = modelcode;
	}

	public String getModelname() {
		return modelname;
	}

	public void setModelname(String modelname) {
		this.modelname = modelname;
	}

	/*public String getTemplatecode() {
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
	}*/
	
	public String getModelid() {
		return modelid;
	}

	public void setModelid(String modelid) {
		this.modelid = modelid;
	}

	public Integer getCountId() {
		return countId;
	}

	public void setCountId(Integer countId) {
		this.countId = countId;
	}

	public String getModeltype() {
		return modeltype;
	}

	public void setModeltype(String modeltype) {
		this.modeltype = modeltype;
	}

	public String getPmmlcode() {
		return pmmlcode;
	}

	public void setPmmlcode(String pmmlcode) {
		this.pmmlcode = pmmlcode;
	}

	public String getPmmlname() {
		return pmmlname;
	}

	public void setPmmlname(String pmmlname) {
		this.pmmlname = pmmlname;
	}
	
	public int getPage() {
		return page;
	}
	
	public void setPage(int page) {
		this.page = page;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public int getRnm() {
		return rnm;
	}
	
	public void setRnm(int rnm) {
		this.rnm = rnm;
	}
}
