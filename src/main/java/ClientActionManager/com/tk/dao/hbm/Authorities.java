package com.tk.dao.hbm;

import java.io.Serializable;

/**
 * 
 * @类说明 权限实体类 
 * @创建者 湛耀
 * @创建时间 2015年7月7日
 * @修改者 
 * @修改时间
 */
public class Authorities implements Serializable {

	private static final long serialVersionUID = 1L;
	private String username;
	private String authority;
	private Users users;

	public Authorities() {
	}

	public Authorities(Users users, String authority) {
		this.users = users;
		this.authority = authority;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getAuthority() {
		return this.authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
