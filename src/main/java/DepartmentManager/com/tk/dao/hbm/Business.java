package com.tk.dao.hbm;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @类说明 业务实体类 
 * @创建者 湛耀
 * @创建时间 2015年7月7日
 * @修改者 panda
 * @修改时间 2015-7-8
 * @修改内容 增加Business(String name);
 */
public class Business implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private Set<Post> posts = new HashSet<Post>();
	private Set<Department> departments = new HashSet<Department>();

	public Business() {
	}
	
	public Business(String name){
		this.name = name;
	}
	
	public Business(int id, String name){
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Post> getPosts() {
		return this.posts;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}

	public Set<Department> getDepartments() {
		return this.departments;
	}

	public void setDepartments(Set<Department> departments) {
		this.departments = departments;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

}
