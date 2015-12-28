package com.tk.dao.hbm;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @类说明 岗位实体类 
 * @创建者 湛耀
 * @创建时间 2015年7月7日
 * @修改者 panda
 * @修改时间 2015-7-8 23:21
 * @修改内容 增加Post(String postName)构造方法
 */
public class Post implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String postName;
	private Business business;
	private Set<Employee> employees = new HashSet<Employee>();

	public Post() {
	}
	
	public Post(int id,String postName){
		this.id = id;
		this.postName = postName;
	}
	
	public Post(String postName){
		this.postName = postName;
	}

	public Post(int id, Business business, String postName) {
		this.id = id;
		this.business = business;
		this.postName = postName;
	}

	public Post(int id, Business business, String postName, Set<Employee> employees) {
		this.id = id;
		this.business = business;
		this.postName = postName;
		this.employees = employees;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Business getBusiness() {
		return this.business;
	}

	public void setBusiness(Business business) {
		this.business = business;
	}

	public String getPostName() {
		return this.postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public Set<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

}
