package com.idm.app.idpconfig.proModelParaConfig.model;

import java.io.Serializable;

/**
* <p>Description:产品模型表实体类 </p>  
* <p>Company: </p>  
* @author caiwenjian  
* @date 2019年2月25日  
* @version 1.0
 */
public class ProModelParaBaseInfo  implements Serializable {
	private static final long serialVersionUID = 8468426474015786959L;
	private String modelid;	 		 //模型表ID
    private String fieldid;	 		 //字段ID
    private String orgno;            //机构代码
   	private String orgname;          //机构名称
    private String productid;		 //产品ID
    private String productcode;  	 //产品编码	
    private String productname; 	 //产品名称
    private String modelcode;    	 //模型编码
    private String modelname;    	 //模型名称
    private String parameterfields;  //参数英文
    private String parameternamech;	 //参数名中文
    private String parametertype;	 //参数类型
	private String createuser;       //创建人
    private String updateuser;       //修改人
    private String createtime;	     //创建时间
    private String updatetime;	     //修改时间
    private String status;	         //状态：0-有效，1-无效
    private String id;	             //业务标识
    private String ischeckout;	     //是否校验:0-是,1-否
    private String checkoutway;	     //校验方法描述:checkoutIsEmpty （非空校验），checkoutIdNumber（身份校验），checkoutTelNumber（手机号码校验），checkoutDate（日期校验）
    private String checkoutmothed;   //校验方式
    private int page;			 	 //第几页
	private int size;		         //每页条数
	private int rnm;
	public String getModelid() {
		return modelid;
	}
	public void setModelid(String modelid) {
		this.modelid = modelid;
	}
	public String getFieldid() {
		return fieldid;
	}
	public void setFieldid(String fieldid) {
		this.fieldid = fieldid;
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
	public String getParameterfields() {
		return parameterfields;
	}
	public void setParameterfields(String parameterfields) {
		this.parameterfields = parameterfields;
	}
	public String getParameternamech() {
		return parameternamech;
	}
	public void setParameternamech(String parameternamech) {
		this.parameternamech = parameternamech;
	}
	public String getParametertype() {
		return parametertype;
	}
	public void setParametertype(String parametertype) {
		this.parametertype = parametertype;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIscheckout() {
		return ischeckout;
	}
	public void setIscheckout(String ischeckout) {
		this.ischeckout = ischeckout;
	}
	public String getCheckoutway() {
		return checkoutway;
	}
	public void setCheckoutway(String checkoutway) {
		this.checkoutway = checkoutway;
	}
	public String getCheckoutmothed() {
		return checkoutmothed;
	}
	public void setCheckoutmothed(String checkoutmothed) {
		this.checkoutmothed = checkoutmothed;
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
