package com.idm.app.idpconfig.proModelParaConfig.model;

import java.io.Serializable;

public class ProductBaseInfo  implements Serializable {
	private static final long serialVersionUID = 2004524436543811433L;
	private String productid;	 //产品ID
	private String orgno;        //机构代码
	private String orgname;      //机构名称
	private String productcode;	 //产品编码
    private String productname;	 //产品名称	
    private String productdes;
    private String createuser;   
    private String updateuser;
    private String createtime;
    private String updatetime;
    private String status;
    private String sort;	 		//排序 	
    private int page;			 //第几页
	private int size;		     //每页条数
	private int rnm;
    public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
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
	public String getProductdes() {
		return productdes;
	}
	public void setProductdes(String productdes) {
		this.productdes = productdes;
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
	
	
	
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	
	
	@Override
	public String toString() {
		return "ProductBaseInfo [productid=" + productid + ", orgno=" + orgno + ", orgname=" + orgname
				+ ", productcode=" + productcode + ", productname=" + productname + ", productdes=" + productdes
				+ ", createuser=" + createuser + ", updateuser=" + updateuser + ", createtime=" + createtime
				+ ", updatetime=" + updatetime + ", status=" + status + ", sort=" + sort + ", page=" + page + ", size="
				+ size + ", rnm=" + rnm + "]";
	}

}
