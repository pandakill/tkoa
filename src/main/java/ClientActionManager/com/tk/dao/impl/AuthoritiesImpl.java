package com.tk.dao.impl;

import java.util.List;

import com.tk.dao.AuthoritiesDAO;
import com.tk.dao.hbm.Authorities;


public class AuthoritiesImpl extends BaseDaoImpl implements AuthoritiesDAO {

	@Override
	public void save(Authorities authorities) {
		try{
			getHibernateTemplate().save(authorities);
		}catch(Exception e){
			System.out.println("Authorities -> save exception: " + e);
		}
	}

	@Override
	public void update(Authorities authorities) {
		try{
			getHibernateTemplate().update(authorities);
		}catch(Exception e){
			System.out.println("Authorities -> update exception: " + e);
		}
	}

	@Override
	public void delete(Authorities authorities) {
		try{
			getHibernateTemplate().delete(authorities);
		}catch(Exception e){
			System.out.println("Authorities -> delete exception: " + e);
		}
	}

	@Override
	public Authorities findByUsername(String username) {
		try{
			Authorities authorities = new Authorities();
			authorities = (Authorities) getHibernateTemplate().get("com.tk.dao.hbm.Authorities", username);
			return authorities;
		}catch(Exception e){
			System.out.println("Authorities -> findByUsername exception: " + e);
			return null;
		}
	}

	@Override
	public List<Authorities> findAll() {
		List<Authorities> list = getHibernateTemplate().find("from com.tk.dao.hbm.Authorities");
		return list;
	}

	

}
