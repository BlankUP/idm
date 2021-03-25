package com.idm.app.ruleengine.exceptioninfo.model;

import java.io.Serializable;

/**
 * <p>Title:AsyStoredExceptionInfo</p>
 * @Description：异步存储信息异常表实体类
 * @author：jiamh
 * @createTime：2019年3月12日
 * @version 1.0
 */
public class IdpAsyStoredExceptionInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String asyStoredId;           //唯一标识
	private String businessNo;	          //业务流水号
	private String tableName;             //表名
	private String executeSql;            //执行sql
	private String data;		          //入库数据
	private String status;                //是否操作（0-未操作，1-已操作）
	private String operateStatus;         //操作状态（0:未操作;1:操作成功;2:操作失败）
	private String operateUser;           //操作人
	private String createTime;            //创建时间
	private String operateTime;           //修改时间
	private int page;
	private int size;
	private int rnm;
	
	public String getAsyStoredId() {
		return asyStoredId;
	}
	public void setAsyStoredId(String asyStoredId) {
		this.asyStoredId = asyStoredId;
	}
	public String getBusinessNo() {
		return businessNo;
	}
	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getExecuteSql() {
		return executeSql;
	}
	public void setExecuteSql(String executeSql) {
		this.executeSql = executeSql;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOperateStatus() {
		return operateStatus;
	}
	public void setOperateStatus(String operateStatus) {
		this.operateStatus = operateStatus;
	}
	public String getOperateUser() {
		return operateUser;
	}
	public void setOperateUser(String operateUser) {
		this.operateUser = operateUser;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getOperateTime() {
		return operateTime;
	}
	public void setOperateTime(String operateTime) {
		this.operateTime = operateTime;
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
