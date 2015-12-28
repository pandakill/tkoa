package com.tk.dao.impl;

import java.util.Iterator;
import java.util.List;

import com.tk.dao.ClockingOutDAO;
import com.tk.dao.hbm.ClockingIn;
import com.tk.dao.hbm.ClockingOut;
import com.tk.dao.hbm.Employee;

public class ClockingOutDAOImpl extends BaseDaoImpl implements ClockingOutDAO {

	@Override
	public void save(ClockingOut clockingOut) {
		try{
			getHibernateTemplate().save(clockingOut);
		}catch(Exception e){
			System.out.println("ClockingOut -> save exception: " + e);
		}
	}

	@Override
	public void delete(ClockingOut clockingOut) {
		try{
			getHibernateTemplate().delete(clockingOut);
		}catch(Exception e){
			System.out.println("ClockingOut -> delete exception: " + e);
		}
	}

	@Override
	public void update(ClockingOut clockingOut) {
		try{
			getHibernateTemplate().update(clockingOut);
		}catch(Exception e){
			System.out.println("ClockingOut -> update exception: " + e);
		}
	}

}
