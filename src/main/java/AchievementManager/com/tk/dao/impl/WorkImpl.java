package com.tk.dao.impl;

import java.util.List;

import com.tk.dao.WorkDAO;
import com.tk.dao.hbm.Work;

public class WorkImpl extends BaseDaoImpl implements WorkDAO {

	@Override
	public void save(Work work) {
		try {
			getHibernateTemplate().save(work);
		} catch (Exception e) {
			System.out.println("WorkImpl -> save exception:" + e);
		}
	}

	@Override
	public void update(Work work) {
		try {
			getHibernateTemplate().update(work);
		} catch (Exception e) {
			System.out.println("WorkImpl -> update exception:" + e);
		}
	}

	@Override
	public void delete(Work work) {
		try {
			getHibernateTemplate().delete(work);
		} catch (Exception e) {
			System.out.println("WorkImpl -> delete exception:" + e);
		}
	}

	@Override
	public Work findByID(int id) {
		try {
			Work work = new Work();
			work = (Work) getHibernateTemplate().get("com.tk.dao.hbm.Work", id);
			return work;
		} catch (Exception e) {
			System.out.println("WorkImpl -> findByID exception:" + e);
			return null;
		}
	}

	@Override
	public List<Work> findByEmployeeID(String employeeID) {
		try {
			List<Work> list = getHibernateTemplate()
					.find("from com.tk.dao.hbm.Work w where w.employee_id = '" + employeeID +"'");
			return list;
		} catch (Exception e) {
			System.out.println("WorkImpl -> findByEmployeeID exception:" + e);
			return null;
		}
	}

	@Override
	public List<Work> findAll() {
		try {
			List<Work> list = getHibernateTemplate().find("from com.tk.dao.hbm.Work");
			return list;
		} catch (Exception e) {
			System.out.println("WorkImpl -> findAll exception:" + e);
			return null;
		}
	}

}
