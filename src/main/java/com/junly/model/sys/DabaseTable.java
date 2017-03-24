package com.junly.model.sys;

import java.io.Serializable;

public class DabaseTable implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID =5248107162637601542L;
	private String tableName; 
	
	private String createTime;
	private String tableComment;
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getTableComment() {
		return tableComment;
	}
	public void setTableComment(String tableComment) {
		this.tableComment = tableComment;
	}
	
	
}
