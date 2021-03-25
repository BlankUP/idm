package com.idm.common.page;

import java.io.Serializable;
import java.util.List;

public class PageVo implements Serializable {
	private static final long serialVersionUID = 6611467252246356583L;
	private long page;
	private long total;
	private long records;
	private List<?> rows;
	private long pageSize = 10;
	private String error;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public long getPage() {
		return page;
	}

	public void setPage(long page) {
		this.page = page;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public long getRecords() {
		return records;
	}

	public void setRecords(long records) {
		this.records = records;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

	public long getPageSize() {
		return pageSize;
	}

	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public PageVo(long pageSize, long page, long records)
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
