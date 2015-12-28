package com.tk.dao.hbm;

import java.io.Serializable;

/**
 * 
 * @类说明 公告实体类
 * @创建者 湛耀
 * @创建时间 2015年7月9日
 * @修改者 
 * @修改时间
 */
public class Notice implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String title;
	private String details;
	private String promulgator;
	private String pubdate;
	private Department department;
	
	public Notice() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getPromulgator() {
		return promulgator;
	}

	public void setPromulgator(String promulgator) {
		this.promulgator = promulgator;
	}

	public String getPubdate() {
		return pubdate;
	}

	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

}
