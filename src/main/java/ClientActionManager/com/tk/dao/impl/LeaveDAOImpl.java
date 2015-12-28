package com.tk.dao.impl;

import com.tk.dao.LeaveDAO;
import com.tk.dao.hbm.Leave;

public class LeaveDAOImpl extends BaseDaoImpl implements LeaveDAO {

	@Override
	public void save(Leave leave) {
		try{
			getHibernateTemplate().save(leave);
		}catch(Exception e){
			System.out.println("Leave -> save exception: " + e);
		}
	}

	@Override
	public void delete(Leave leave) {
		try{
			getHibernateTemplate().delete(leave);
		}catch(Exception e){
			System.out.println("Leave -> delete exception: " + e);
		}
	}

	@Override
	public void update(Leave leave) {
		try{
			getHibernateTemplate().update(leave);
		}catch(Exception e){
			System.out.println("Leave -> update exception: " + e);
		}
	}

}
