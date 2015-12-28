package com.tk.dao.impl;

import com.tk.dao.LeaveStateDAO;
import com.tk.dao.hbm.LeaveState;

public class LeaveStateDAOImpl extends BaseDaoImpl implements LeaveStateDAO {

	@Override
	public void save(LeaveState leaveState) {
		try{
			getHibernateTemplate().save(leaveState);
		}catch(Exception e){
			System.out.println("LeaveState -> save exception: " + e);
		}
	}

	@Override
	public void delete(LeaveState leaveState) {
		try{
			getHibernateTemplate().delete(leaveState);
		}catch(Exception e){
			System.out.println("LeaveState -> delete exception: " + e);
		}
	}

	@Override
	public void update(LeaveState leaveState) {
		try{
			getHibernateTemplate().update(leaveState);
		}catch(Exception e){
			System.out.println("LeaveState -> update exception: " + e);
		}
	}

}
