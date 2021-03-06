package com.idm.app.idpconfig.modelRule.model;

import java.io.Serializable;

/**
* <p>Description:模型规则实体类 </p>  
* <p>Company: </p>  
* @author pl  
* @date 2019年8月17日  
* @version 1.0
 */
public class ModelRuleInfo  implements Serializable {
	private static final long serialVersionUID = -5488180638027458188L;
	private String mtrid;	       //参数ID
	private int seqno;             //序号
    private String modelcode;	   //参数字段英文
    private String modelname;	   //参数字段中文名
    private String rulecode;	   //参数类型
    private String rulename;       //创建人
    private String ruletype;	   //修改人
    private String createtime;	   //创建日期
    private String createuser;	   //修改日期
    private String status;         //状态 （0-有效； 1-无效）
    private int version;           //版本号
    private int page;			   //第几页
	private int size;			   //每页条数
	private int rnm;				 
   
	public String getMtrid() {
		return mtrid;
	}
	public void setMtrid(String mtrid) {
		this.mtrid = mtrid;
	}
	public int getSeqno() {
		return seqno;
	}
	public void setSeqno(int seqno) {
		this.seqno = seqno;
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
	public String getRulecode() {
		return rulecode;
	}
	public void setRulecode(String rulecode) {
		this.rulecode = rulecode;
	}
	public String getRulename() {
		return rulename;
	}
	public void setRulename(String rulename) {
		this.rulename = rulename;
	}
	public String getRuletype() {
		return ruletype;
	}
	public void setRuletype(String ruletype) {
		this.ruletype = ruletype;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getCreateuser() {
		return createuser;
	}
	public void setCreateuser(String createuser) {
		this.createuser = createuser;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
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
	@Override
	public String toString() {
		return "ModelRuleInfo [mtrid=" + mtrid + ", seqno=" + seqno + ", modelcode=" + modelcode + ", modelname="
				+ modelname + ", rulecode=" + rulecode + ", rulename=" + rulename + ", ruletype=" + ruletype
				+ ", createtime=" + createtime + ", createuser=" + createuser + ", status=" + status + ", page=" + page
				+ ", size=" + size + ", rnm=" + rnm + "]";
	}
	
}
