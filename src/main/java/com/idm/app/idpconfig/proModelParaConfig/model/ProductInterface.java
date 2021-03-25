package com.idm.app.idpconfig.proModelParaConfig.model;

import java.io.Serializable;

public class ProductInterface  implements Serializable {
	private static final long serialVersionUID = 2004524436543811433L;
	private String uuid;	 	//uuid
	private String data;        //原始报文
	private String createTime;
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "ProductInterface [uuid=" + uuid + ", data=" + data + ", createTime=" + createTime + "]";
	}
	
	

}
