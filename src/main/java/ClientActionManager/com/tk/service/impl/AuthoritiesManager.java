package com.tk.service.impl;

import com.tk.dao.AuthoritiesDAO;
import com.tk.dao.hbm.Authorities;
import com.tk.dao.hbm.Users;
import com.tk.service.IAuthoritiesManager;


public class AuthoritiesManager implements IAuthoritiesManager {

	private AuthoritiesDAO authoritiesDAO;
	
	@Override
	public void setauthoritiesDAO(AuthoritiesDAO authoritiesDAO) {
		this.authoritiesDAO = authoritiesDAO;
		System.out.println("AuthoritiesManager -> setauthoritiesDao" + this.authoritiesDAO);
	}

	@Override
	public AuthoritiesDAO getauthoritiesDAO() {
		return this.authoritiesDAO;
	}

	@Override
	public String addAuthorities(Authorities authorities) {
		String flag = "FALSE";
		Authorities authorities2 = authoritiesDAO.findByUsername(authorities.getUsers().getUsername());
		if( null == authorities2){
			//保存用户的同时要添加用户权限
			authoritiesDAO.save(authorities);
			flag = "SUCCESS";
		}else{
			flag = "HAVED_USERS";
		}
		return flag;
	}

}
