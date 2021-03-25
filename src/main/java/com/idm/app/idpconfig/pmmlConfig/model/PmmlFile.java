package com.idm.app.idpconfig.pmmlConfig.model;

/**
 * 
 *<p>Title: PmmlFile</p>  
 * @Description: PMML文件上传实体类
 * @author 黄百超
 * @date 2019年3月8日
 * @version  1.0
 *
 */
public class PmmlFile {
	
	private String pmmlFileId;
	private String pmmlId;			//PMML表ID
	private String fileId;			//文件表ID
	private String version;			//版本号
	private String versionDesc;		//版本描述
	private String createUser;		//创建人
	private String createTime;		//创建时间
	private String updateUser;		//修改人
	private String updateTime;		//修改时间
	private String status;			//版本状态（0：无效版本，1：当前版本）
	
	

	public String getPmmlFileId() {
		return pmmlFileId;
	}
	public void setPmmlFileId(String pmmlFileId) {
		this.pmmlFileId = pmmlFileId;
	}
	public String getPmmlId() {
		return pmmlId;
	}
	public void setPmmlId(String pmmlId) {
		this.pmmlId = pmmlId;
	}
	public String getFileId() {
		return fileId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getVersionDesc() {
		return versionDesc;
	}
	public void setVersionDesc(String versionDesc) {
		this.versionDesc = versionDesc;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
