package com.idm.common.util;

import java.io.Serializable;
import java.util.List;

public class ResByPageVo implements Serializable{
	private static final long serialVersionUID = 6611467252246356583L;
	private int page;
	private int total;
	private int records;
	private List<?> rows;
	private int pageSize = 10;
	
	public int getPage() {
	  return this.page;
	}
	public void setPage(int page) {
	  this.page = page;
	}
	public int getTotal() {
	  return this.total;
	}
	public void setTotal(int total) {
	  this.total = total;
	}
	public int getRecords() {
	  return this.records;
	}
	public void setRecords(int records) {
	  this.records = records;
	}
	public List<?> getRows() {
	  return this.rows;
	}
	public void setRows(List<?> rows) {
	  this.rows = rows;
	}
	public int getPageSize() {
	  return this.pageSize;
	}
	public void setPageSize(int pageSize) {
	  this.pageSize = pageSize;
	}
	
	public ResByPageVo(int pageSize, int page, int records)
	{
	  this.pageSize = pageSize;
	  this.page = page;
	  this.records = records;
	
	  if (records % pageSize == 0)
	    this.total = (records / pageSize);
	  else {
	    this.total = (records / pageSize + 1);
	  }
	  if (page >= this.total) {
	    page = this.total;
	  }
	  if (page <= 1)
	    page = 1;
	}
}
