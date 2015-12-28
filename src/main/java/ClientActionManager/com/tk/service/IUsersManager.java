package com.tk.service;

import javax.servlet.http.HttpServletRequest;

import com.tk.security.SecuritySessionInfo;
import com.tk.dao.UsersDAO;
import com.tk.dao.hbm.Users;

public interface IUsersManager {
	
	public abstract void setusersDAO(UsersDAO usersDAO);
	
	public abstract UsersDAO getusersDAO();
	
	public abstract void setSecuritySessionInfo(SecuritySessionInfo securitySessionInfo);

	public abstract SecuritySessionInfo getSecuritySessionInfo();
	
	public Users getUserByUsername(HttpServletRequest request);
	
	public boolean isAuthorities(HttpServletRequest request, String authorities);
	
	public abstract String addUsers(Users users);
	
	public abstract String updateUsers(Users users);
	
	public abstract Users getUsersByTel(String username);
	
}
