package com.tk.dao.impl;

import java.util.List;

import com.tk.dao.DepartmentDAO;
import com.tk.dao.hbm.Department;

public class DepartmentImpl extends BaseDaoImpl implements DepartmentDAO {

	@Override
	public void save(Department department) {
		try {
			getHibernateTemplate().save(department);
		} catch (Exception e) {
			System.out.println("DepartmentImpl -> save exception:" + e);
		}
	}

	@Override
	public void update(Department department) {
		try {
			getHibernateTemplate().update(department);
		} catch (Exception e) {
			System.out.println("DepartmentImpl -> update exception:" + e);
		}
	}

	@Override
	public void delete(Department department) {
		try {
			getHibernateTemplate().delete(department);
		} catch (Exception e) {
			System.out.println("DepartmentImpl -> delete exception:" + e);
		}
	}

	@Override
	public Department findByID(String id) {
		try {
			Department department = new Department();
			department = (Department) getHibernateTemplate().get("com.tk.dao.hbm.Department", id);
			return department;
		} catch (Exception e) {
			System.out.println("DepartmentImpl -> findByID exception:" + e);
			return null;
		}
	}

	@Override
	public Department findByDepartmentName(String departmentName) {
		try {
			List<Department> list = getHibernateTemplate()
					.find("from com.tk.dao.hbm.Department d where d.name = '" + departmentName + "'");
			Department department = null;
			if( list != null ){
				department = list.get(0);
			}
			return department;
		} catch (Exception e) {
			System.out.println("DepartmentImpl -> findByDepartmentName exception:" + e);
			return null;
		}
	}

	@Override
	public List<Department> findByBusinessID(int businessID) {
		try {
			List<Department> list = getHibernateTemplate()
					.find("from com.tk.dao.hbm.Department d where d.business_id = '" + businessID + "'");
			return list;
		} catch (Exception e) {
			System.out.println("DepartmentImpl -> findByBusinessID exception:" + e);
			return null;
		}
	}

	@Override
	public List<Department> findAll() {
		try {
			List<Department> list = getHibernateTemplate()
					.find("from com.tk.dao.hbm.Department" );
			return list;
		} catch (Exception e) {
			System.out.println("DepartmentImpl -> findAll exception:" + e);
			return null;
		}
	}

	
}
