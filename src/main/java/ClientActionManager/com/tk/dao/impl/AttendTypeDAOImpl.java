package com.tk.dao.impl;

import com.tk.dao.AttendTypeDAO;
import com.tk.dao.hbm.AttendType;

public class AttendTypeDAOImpl extends BaseDaoImpl implements AttendTypeDAO {

	@Override
	public void save(AttendType attendType) {
		try{
			getHibernateTemplate().save(attendType);
		}catch(Exception e){
			System.out.println("AttendType -> save exception: " + e);
		}
	}

	@Override
	public void delete(AttendType attendType) {
		try{
			getHibernateTemplate().delete(attendType);
		}catch(Exception e){
			System.out.println("AttendType -> delete exception: " + e);
		}
	}

	@Override
	public void update(AttendType attendType) {
		try{
			getHibernateTemplate().update(attendType);
		}catch(Exception e){
			System.out.println("AttendType -> update exception: " + e);
		}
	}

	@Override
	public AttendType getByID(int id) {
		AttendType attendType = new AttendType();
		try{
			attendType = getHibernateTemplate().get(AttendType.class, id);
		}catch(Exception e){
			System.out.println("AttendType -> getByID exception: " + e);
		}
		return attendType;
	}

}
