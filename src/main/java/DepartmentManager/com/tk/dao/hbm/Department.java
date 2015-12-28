package com.tk.dao.hbm;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @类说明 部门实体类
 * @创建者 湛耀
 * @创建时间 2015年7月7日
 * @修改者 panda
 * @修改时间 2015-7-9 15:29
 * @修改内容 增加Department(String name)构造方法;
 */
public class Department implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private int headcount;
	private int highgradeHeadcount;
	private Business business;
	private Set<Employee> employees = new HashSet<Employee>();
	private Set<ExpatriateLabor> expatriateLabors = new HashSet<ExpatriateLabor>();
	private Set<Notice> notices = new HashSet<Notice>();

	public Department() {
	}
	
	public Department(String name){
		this.name = name;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Business getBusiness() {
		return this.business;
	}

	public void setBusiness(Business business) {
		this.business = business;
	}

	public int getHeadcount() {
		return this.headcount;
	}

	public void setHeadcount(int headcount) {
		this.headcount = headcount;
	}

	public int getHighgradeHeadcount() {
		return this.highgradeHeadcount;
	}

	public void setHighgradeHeadcount(int highgradeHeadcount) {
		this.highgradeHeadcount = highgradeHeadcount;
	}

	public Set<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Set<ExpatriateLabor> getExpatriateLabors() {
		return this.expatriateLabors;
	}

	public void setExpatriateLabors(Set<ExpatriateLabor> expatriateLabors) {
		this.expatriateLabors = expatriateLabors;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Notice> getNotices() {
		return notices;
	}

	public void setNotices(Set<Notice> notices) {
		this.notices = notices;
	}

}
