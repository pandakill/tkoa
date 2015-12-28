package com.tk.service.impl;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.tk.dao.AuthoritiesDAO;
import com.tk.dao.UsersDAO;
import com.tk.dao.hbm.Users;
import com.tk.security.SecuritySessionInfo;
import com.tk.service.IUsersManager;

public class UsersManager implements IUsersManager {

	private SecuritySessionInfo securitySessionInfo;
	private UsersDAO usersDAO;
	private AuthoritiesDAO authoritiesDAO;
	private String username = "";
	
	@Override
	public void setusersDAO(UsersDAO usersDAO) {
		this.usersDAO = usersDAO;
		System.out.println("UsersManager -> setusersDAO" + this.usersDAO);
	}

	@Override
	public UsersDAO getusersDAO() {
		return this.usersDAO;
	}
	
	public void setAuthoritiesDAO(AuthoritiesDAO authoritiesDAO) {
		this.authoritiesDAO = authoritiesDAO;
	}
	
	public AuthoritiesDAO getAuthoritiesDAO() {
		return authoritiesDAO;
	}
	
	@Override
	public void setSecuritySessionInfo(SecuritySessionInfo securitySessionInfo) {
		this.securitySessionInfo = securitySessionInfo;
		System.out.println("UsersManager -> setSecuritySessionInfo" + this.securitySessionInfo);
	}

	@Override
	public SecuritySessionInfo getSecuritySessionInfo() {
		return this.securitySessionInfo;
	}
	
	/**
	 * 
	 * @方法说明	根据用户名获取当前的用户
	 * @创建者 湛耀
	 * @创建日期 2015年7月8日 下午12:35:06
	 * @修改者 
	 * @修改时间 
	 * @return
	 * @return Users
	 */
	@Override
	public Users getUserByUsername(HttpServletRequest request) {
		Users users = new Users();
		try {
			username = securitySessionInfo.getUsername(request);
			users = usersDAO.findByUserName(username);
		} catch (Exception e) {
			System.out.println("UsersManage -> getUserByUsername :" + e);
		}
		return users;
	}
	
	/**
	 * 
	 * @方法说明
	 * @创建者 湛耀
	 * @创建日期 2015年7月8日 下午9:48:44
	 * @修改者 
	 * @修改时间 
	 * @param request
	 * @param authorities
	 * @return
	 * @return boolean
	 */
	@Override
	public boolean isAuthorities(HttpServletRequest request, String authorities) {
		boolean flag = false;
		Set<String> roles = securitySessionInfo.getAuthorities(request);
		try {
			if (roles.contains(authorities)) {
				flag = true;
			}
		} catch (Exception e) {
			System.out.println("UsersManage -> isAuthorities :" + e);
		}
		return flag;
	}

	@Override
	public String addUsers(Users users) {
		String flag = "FALSE";
		Users u = usersDAO.findByUserName(users.getUsername());
		if( null == u ){
			//保存用户的同时要添加用户权限
			usersDAO.save(users);
			flag = "SUCCESS";
		}else{
			flag = "HAVED_USERS";
		}
		return flag;
	}

	@Override
	public String updateUsers(Users users){
		String flag = "FALSE";
		Users users2 = usersDAO.findByUserName(users.getUsername());
		if( null != users2 ){
			usersDAO.update(users);
			flag = "SUCCESS";
		}else{
			flag = "NOT_FOUND_USERS";
		}
		return flag;
	}

	@Override
	public Users getUsersByTel(String username) {
		Users users = usersDAO.findByUserName(username);
		System.out.println("UsersMananger -> getUsersByTel users="+users);
		if( users != null ){
			return users;
		}else{
			return null;
		}
	}

}
