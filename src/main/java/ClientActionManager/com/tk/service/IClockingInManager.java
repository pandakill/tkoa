package com.tk.service;

import java.util.List;

import com.tk.dao.ClockingInDAO;
import com.tk.dao.EmployeeDAO;
import com.tk.dao.hbm.ClockingIn;
import com.tk.dao.hbm.Employee;

public interface IClockingInManager {
	
	public abstract void setclockingInDAO(ClockingInDAO clockingInDAO);
	
	public abstract ClockingInDAO getclockingInDAO();

	public abstract boolean addNewDayClockingIns();

	public abstract EmployeeDAO getEmployeeDAO();

	public abstract void setEmployeeDAO(EmployeeDAO employeeDAO);

	/**
	 * 
	 * @方法说明 获取当前打卡上班考勤的状态
	 * @创建者 湛耀
	 * @创建日期 2015年7月10日 下午4:52:50
	 * @修改者 
	 * @修改时间 
	 * @param employee
	 * @return
	 * @return int
	 */
	public abstract int getTodayClockingInAttendTypeID(Employee employee);

	public abstract void clocingkIn(Employee employee);

	public abstract int getTodayClockingOutAttendTypeID(Employee employee);

	public abstract void clocingkOut(Employee employee);

	public abstract List<ClockingIn> findMyselfThisMonthClockingIn(
			Employee employee);

	public abstract List<ClockingIn> findTodayAllClockingIn();

	public abstract List<ClockingIn> findTodayDepartmentClockingIn(
			Employee employee);
}
