package com.tk.dao.impl;

import java.util.List;

import com.tk.dao.SalaryDAO;
import com.tk.dao.hbm.Salary;

public class SalaryImpl extends BaseDaoImpl implements SalaryDAO {

	@Override
	public void save(Salary salary) {
		try {
			getHibernateTemplate().save(salary);
		} catch (Exception e) {
			System.out.println("SalaryImpl -> save exception:" + e);
		}
	}

	@Override
	public void update(Salary salary) {
		try {
			getHibernateTemplate().update(salary);
		} catch (Exception e) {
			System.out.println("SalaryImpl -> update exception:" + e);
		}
	}

	@Override
	public void delete(Salary salary) {
		try {
			getHibernateTemplate().delete(salary);
		} catch (Exception e) {
			System.out.println("SalaryImpl -> delete exception:" + e);
		}
	}

	@Override
	public Salary findByID(int id) {
		try {
			Salary salary = new Salary();
			salary = (Salary) getHibernateTemplate().get("com.tk.dao.hbm.Salary", id);
			return salary;
		} catch (Exception e) {
			System.out.println("SalaryImpl -> findByID exception:" + e);
			return null;
		}
	}

	@Override
	public List<Salary> findByEmployeeID(String employeeID) {
		try {
			List<Salary> list = getHibernateTemplate()
					.find("from com.tk.dao.hbm.Salary s where s.employee.id = '" + employeeID + "'");
			return list;
		} catch (Exception e) {
			System.out.println("SalaryImpl -> findByEmployeeID exception:" + e);
			return null;
		}
	}

	@Override
	public List<Salary> findAll() {
		try {
			List<Salary> list = getHibernateTemplate().find("from com.tk.dao.hbm.Salary");
			return list;
		} catch (Exception e) {
			System.out.println("SalaryImpl -> findAll exception:" + e);
			return null;
		}
	}

}
