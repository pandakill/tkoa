package com.tk.dao.impl;

import java.util.Iterator;
import java.util.List;

import com.tk.dao.ClockingInDAO;
import com.tk.dao.hbm.ClockingIn;
import com.tk.dao.hbm.Employee;

public class ClockingInImpl extends BaseDaoImpl implements ClockingInDAO {

	@Override
	public void save(ClockingIn clockingIn) {
		try {
			getHibernateTemplate().save(clockingIn);
		} catch (Exception e) {
			System.out.println("ClockingInImpl -> save exception:" + e);
		}
	}

	@Override
	public void update(ClockingIn clockingIn) {
		try {
			getHibernateTemplate().update(clockingIn);
		} catch (Exception e) {
			System.out.println("ClockingInImpl -> update exception:" + e);
		}
	}

	@Override
	public void delete(ClockingIn clockingIn) {
		try {
			getHibernateTemplate().delete(clockingIn);
		} catch (Exception e) {
			System.out.println("ClockingInImpl -> delete exception:" + e);
		}
	}

	@Override
	public ClockingIn findByID(int id) {
		try {
			ClockingIn clockingIn = new ClockingIn();
			clockingIn = (ClockingIn) getHibernateTemplate().get("com.tk.dao.hbm.ClockingIn", id);
			return clockingIn;
		} catch (Exception e) {
			System.out.println("ClockingInImpl -> findByID exception:" + e);
			return null;
		}
	}

	@Override
	public List<ClockingIn> findByEmployeeID(String employeeID) {
		try {
			List<ClockingIn> list = getHibernateTemplate()
					.find("from com.tk.dao.hbm.ClockingIn c where c.employee.id = '" + employeeID + "'");
			return list;
		} catch (Exception e) {
			System.out.println("ClockingInImpl -> findByEmloyeeID exception:" + e);
			return null;
		}
	}

	@Override
	public List<ClockingIn> findAll() {
		try {
			List<ClockingIn> list = getHibernateTemplate().find("from ClockingIn");
			return list;
		} catch (Exception e) {
			System.out.println("ClockingInImpl -> findAll exception:" + e);
			return null;
		}
	}

	@Override
	public ClockingIn findClockingInByEmployeeAnd(Employee employee, int year,
			int month, int day) {
		ClockingIn clockingIn = new ClockingIn();
		try {
			List<ClockingIn> list = getHibernateTemplate()
					.find("from ClockingIn ci where ci.employee.id='" + employee.getId() 
							+ "' and ci.year='" + year + "' and ci.month='" + month 
							+ "' and ci.day='" +day + "'");
			Iterator<ClockingIn> iterator = list.iterator();
			while (iterator.hasNext()) {
				clockingIn = iterator.next();
			}
		} catch (Exception e) {
			System.out.println("ClockingInImpl -> findClockingInByEmployeeAnd exception:" + e);
		}
		return clockingIn;
	}

	@Override
	public List<ClockingIn> findMyselfThisMonthClockIn(Employee employee,
			int year, int month) {
		List<ClockingIn> list = null;
		try {
			list = getHibernateTemplate().find("from ClockingIn ci where ci.employee.id='" + employee.getId() 
					+ "' and ci.year='" + year + "' and ci.month='" + month + "'");
		} catch (Exception e) {
			System.out.println("ClockingInImpl -> findMyselfThisMonthClockIn exception:" + e);
		}
		return list;
	}

	@Override
	public List<ClockingIn> findTodayAllClockingIn(int year, int month, int day) {
		List<ClockingIn> list = null;
		try {
			list = getHibernateTemplate().find("from ClockingIn ci where ci.year='" + year
					+ "' and ci.month='" + month + "' and ci.day='" + day + "'");
			System.out.println("list:" + list);
		} catch (Exception e) {
			System.out.println("ClockingInImpl -> findTodayAllClockingIn exception:" + e);
		}
		return list;
	}

	@Override
	public List<ClockingIn> findTodayDepartmentClockingIn(Employee employee,
			int year, int month, int day) {
		List<ClockingIn> list = null;
		try {
			list = getHibernateTemplate().find("from ClockingIn ci where ci.employee.department.id='" + employee.getDepartment().getId() 
					+ "' and ci.year='" + year + "' and ci.month='" + month + "' and ci.day='" + day + "'");
		} catch (Exception e) {
			System.out.println("ClockingInImpl -> findTodayDepartmentClockingIn exception:" + e);
		}
		return list;
	}

	@Override
	public ClockingIn findYesterdayClockingIn(Employee employee, int year, int month, int day) {
		ClockingIn clockingIn = new ClockingIn();
		
		return clockingIn;
	}
}
