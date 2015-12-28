package com.tk.service;

import com.tk.dao.AuthoritiesDAO;
import com.tk.dao.hbm.Authorities;

public interface IAuthoritiesManager {
	
	public abstract void setauthoritiesDAO(AuthoritiesDAO authoritiesDAO);
	
	public abstract AuthoritiesDAO getauthoritiesDAO();
	
	public abstract String addAuthorities(Authorities authorities);
}
