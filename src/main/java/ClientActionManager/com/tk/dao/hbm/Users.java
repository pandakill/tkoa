package com.tk.dao.hbm;

import java.io.Serializable;

/**
 * 
 * @类说明 员工帐号管理体类 
 * @创建者 湛耀
 * @创建时间 2015年7月7日
 * @修改者 
 * @修改时间
 */
public class Users implements Serializable {

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private short enabled;
	private Authorities authorities;
	private Employee employee;

	public Users() {
	}

	public Users(String username, short enabled) {
		this.username = username;
		this.enabled = enabled;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public short getEnabled() {
		return this.enabled;
	}

	public void setEnabled(short enabled) {
		this.enabled = enabled;
	}

	public Authorities getAuthorities() {
		return this.authorities;
	}

	public void setAuthorities(Authorities authorities) {
		this.authorities = authorities;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	

}
