package com.tk.dao.impl;

import java.util.Iterator;
import java.util.List;

import com.tk.dao.EmployeeDAO;
import com.tk.dao.hbm.Employee;

public class EmployeeImpl extends BaseDaoImpl implements EmployeeDAO {

	@Override
	public void save(Employee employee) {
		try {
			getHibernateTemplate().save(employee);
		} catch (Exception e) {
			System.out.println("EmployeeImpl -> save exception:" + e);
		}
	}

	@Override
	public void update(Employee employee) {
		try {
			getHibernateTemplate().update(employee);
		} catch (Exception e) {
			System.out.println("EmployeeImpl -> update exception:" + e);
		}
	}

	@Override
	public void delete(Employee employee) {
		try {
			getHibernateTemplate().delete(employee);
		} catch (Exception e) {
			System.out.println("EmployeeImpl -> delete exception:" + e);
		}
	}

	@Override
	public Employee findByID(String id) {
		try {
			Employee employee = new Employee();
			employee = (Employee) getHibernateTemplate().get("com.tk.dao.hbm.Employee", id);
			return employee;
		} catch (Exception e) {
			System.out.println("EmployeeImpl -> findByID exception:" + e);
			return null;
		}
	}

	@Override
	public List<Employee> findByDepartmentID(String departmentID) {
		List<Employee> list = null;
		try {
			list = getHibernateTemplate().find("from Employee e where e.department.id = '" + departmentID + "'");
		} catch (Exception e) {
			System.out.println("EmployeeImpl -> findByDepartmentID exception:" + e);
		}
		return list;
	}

	@Override
	public List<Employee> findByPostID(int postID) {
		try {
			List<Employee> list = getHibernateTemplate()
					.find("from com.tk.dao.hbm.Employee e where e.post_id = '" + postID + "'");
			return list;
		} catch (Exception e) {
			System.out.println("EmployeeImpl -> findByPostID exception:" + e);
			return null;
		}
	}

	@Override
	public Employee findByTel(String tel) {
		Employee employee = null;
		try {
			List<Employee> list =  getHibernateTemplate()
					.find("from com.tk.dao.hbm.Employee e where e.users.username = '" + tel + "'");
			Iterator<Employee> iterator = list.iterator();
			while (iterator.hasNext()) {
				employee = iterator.next();
			}
			
		} catch (Exception e) {
			System.out.println("EmployeeImpl -> findByTel exception:" + e);
		}
		return employee;
	}

	@Override
	public List<Employee> findAll() {
		List<Employee> list = null;
		try {
			list =  getHibernateTemplate().find("from Employee");
		} catch (Exception e) {
			System.out.println("EmployeeImpl -> findAll exception:" + e);
		}
		return list;
	}

}
