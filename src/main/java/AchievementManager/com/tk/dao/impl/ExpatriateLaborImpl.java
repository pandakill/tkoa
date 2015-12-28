package com.tk.dao.impl;

import java.util.List;

import com.tk.dao.ExpatriateLaborDAO;
import com.tk.dao.hbm.ExpatriateLabor;

public class ExpatriateLaborImpl extends BaseDaoImpl implements ExpatriateLaborDAO {

	@Override
	public void save(ExpatriateLabor expatriateLabor) {
		try {
			getHibernateTemplate().save(expatriateLabor);
		} catch (Exception e) {
			System.out.println("ExpartriateLaborImpl -> save exception:" + e);
		}
	}

	@Override
	public void update(ExpatriateLabor expatriateLabor) {
		try {
			getHibernateTemplate().update(expatriateLabor);
		} catch (Exception e) {
			System.out.println("ExpartriateLaborImpl -> update exception:" + e);
		}
		
	}

	@Override
	public void delete(ExpatriateLabor expatriateLabor) {
		try {
			getHibernateTemplate().delete(expatriateLabor);
		} catch (Exception e) {
			System.out.println("ExpartriateLaborImpl -> delete exception:" + e);
		}
		
	}

	@Override
	public ExpatriateLabor findByID(int id) {
		try {
			ExpatriateLabor expatriateLabor = new ExpatriateLabor();
			expatriateLabor = (ExpatriateLabor) getHibernateTemplate().get("com.tk.dao.hbm.ExpatriateLabor", id);
			return expatriateLabor;
		} catch (Exception e) {
			System.out.println("ExpartriateLaborImpl -> findByID exception:" + e);
			return null;
		}
	}

	@Override
	public List<ExpatriateLabor> findByDepartmentID(String departmentID) {
		List<ExpatriateLabor> list = null;
		System.out.println("11111111111");
		try {
			list = getHibernateTemplate()
					.find("from ExpatriateLabor e where e.department.id ='" + departmentID + "'");
		} catch (Exception e) {
			System.out.println("ExpartriateLaborImpl -> findByDepartmentID exception:" + e);
		}
		return list;
	}

	@Override
	public List<ExpatriateLabor> findByEmployeeID(String employeeID) {
		try {
			List<ExpatriateLabor> list = getHibernateTemplate()
					.find("from com.tk.dao.hbm.ExpatriateLabor e where e.employee.id ='" + employeeID + "'");
			return list;
		} catch (Exception e) {
			System.out.println("ExpartriateLaborImpl -> findByEmployeeID exception:" + e);
			return null;
		}
	}

	@Override
	public List<ExpatriateLabor> findAll() {
		try {
			List<ExpatriateLabor> list = getHibernateTemplate()
					.find("from com.tk.dao.hbm.ExpatriateLabor");
			return list;
		} catch (Exception e) {
			System.out.println("ExpartriateLaborImpl -> findAll exception:" + e);
			return null;
		}
	}

}
