package com.tk.service.impl;

import java.util.Iterator;
import java.util.List;

import com.tk.dao.hbm.AttendType;
import com.tk.dao.hbm.ClockingIn;
import com.tk.dao.hbm.ClockingOut;
import com.tk.dao.AttendTypeDAO;
import com.tk.dao.ClockingInDAO;
import com.tk.dao.ClockingOutDAO;
import com.tk.dao.EmployeeDAO;
import com.tk.dao.hbm.Employee;
import com.tk.service.IClockingInManager;
import com.tk.util.SystemTime;


public class ClockingInManager implements IClockingInManager {

	private static final String SUPER_ID = "00000";
	private static final int NEW_CLOCKING_IN_ATTEND_TYPE = 0;
	private static final int COMMON_ATTEND_TYPE = 1;
	private static final int LATE_ATTEND_TYPE = 2;
	private static final int EARLY_ATTEND_TYPE = 3;
	private static final int OUTSIDE_ATTEND_TYPE = 4;
	private static final int ABSENTEEISM_ATTEND_TYPE = 5;
	private static final int LEAVE_ATTEND_TYPE = 6;
	private static final int START_CLOCKING_IN_TIME = 9;	//上班时间(时)
	private static final int END_CLOCKING_IN_TIME = 18;	//上班时间(时)
	private ClockingInDAO clockingInDAO;
	private EmployeeDAO employeeDAO;
	private AttendTypeDAO attendTypeDAO;
	private ClockingOutDAO clockingOutDAO;
	
	@Override
	public void setclockingInDAO(ClockingInDAO clockingInDAO) {
		this.clockingInDAO = clockingInDAO;
		System.out.println("ClockingInManager -> setclockingInDAO" + this.clockingInDAO);
	}

	@Override
	public ClockingInDAO getclockingInDAO() {
		return this.clockingInDAO;
	}
	
	@Override
	public EmployeeDAO getEmployeeDAO() {
		return employeeDAO;
	}

	@Override
	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
		System.out.println("ClockingInManager -> setEmployeeDAO" + this.employeeDAO);
	}
	
	public AttendTypeDAO getAttendTypeDAO() {
		return attendTypeDAO;
	}

	public void setAttendTypeDAO(AttendTypeDAO attendTypeDAO) {
		this.attendTypeDAO = attendTypeDAO;
		System.out.println("ClockingInManager -> setAttendTypeDAO" + this.attendTypeDAO);
	}
	
	public ClockingOutDAO getClockingOutDAO() {
		return clockingOutDAO;
	}

	public void setClockingOutDAO(ClockingOutDAO clockingOutDAO) {
		this.clockingOutDAO = clockingOutDAO;
	}
	
	@Override
	public boolean addNewDayClockingIns() {
		boolean flag = false;
		Employee employee = new Employee();
		AttendType attendType = new AttendType();
		ClockingIn clockingInOld = new ClockingIn();
		ClockingIn clockingInNew = new ClockingIn();
		int year = SystemTime.getYear();
		int month = SystemTime.getMonth();
		int day = SystemTime.getDay();
		try {
			//把前一天缺勤为填的补全
			
			List<ClockingIn> clockingIns = clockingInDAO.findAll();
			Iterator<ClockingIn> cIterator = clockingIns.iterator();
			while (cIterator.hasNext()) {
				clockingInOld = cIterator.next();
				if (clockingInOld.getAttendType().getId() == NEW_CLOCKING_IN_ATTEND_TYPE) {
					//缺勤
					attendType = attendTypeDAO.getByID(ABSENTEEISM_ATTEND_TYPE);
					clockingInOld.setAttendType(attendType);
					clockingInDAO.update(clockingInOld);
				}
			}
			
			//新的一天的信息
			List<Employee> list = employeeDAO.findAll();
			Iterator<Employee> iterator = list.iterator();
			attendType = attendTypeDAO.getByID(NEW_CLOCKING_IN_ATTEND_TYPE);
			while (iterator.hasNext()) {
				employee = iterator.next();
				if (!employee.getId().equals(SUPER_ID)) {
					//添加新工资表信息
					clockingInNew.setEmployee(employee);
					clockingInNew.setYear(year);
					clockingInNew.setMonth(month);
					clockingInNew.setDay(day);
					clockingInNew.setAttendType(attendType);
					clockingInDAO.save(clockingInNew);
				}
			}
			flag = true;
		} catch (Exception e) {
			System.out.println("ClockingInManager -> addNewDayClockingIns" + e);
		}
		return flag;
	}
	
	@Override
	public int getTodayClockingInAttendTypeID(Employee employee) {
		ClockingIn clockingIn = new ClockingIn();
		clockingIn = clockingInDAO.findClockingInByEmployeeAnd(employee, SystemTime.getYear(), SystemTime.getMonth(), SystemTime.getDay());
		return clockingIn.getAttendType().getId();
		
	}
	
	@Override
	public int getTodayClockingOutAttendTypeID(Employee employee) {
		ClockingOut clockingOut = new ClockingOut();
		ClockingIn clockingIn = new ClockingIn();
		clockingIn = clockingInDAO.findClockingInByEmployeeAnd(employee, SystemTime.getYear(), SystemTime.getMonth(), SystemTime.getDay());
		clockingOut = clockingIn.getClockingOut(); 
		return clockingOut.getAttendType().getId();
	}

	@Override
	public void clocingkIn(Employee employee) {
		ClockingIn clockingIn = new ClockingIn();
		ClockingOut	clockingOut = new ClockingOut();
		AttendType attendType = new AttendType();
		int year = SystemTime.getYear();
		int month = SystemTime.getMonth();
		int day = SystemTime.getDay();
		int hour = SystemTime.getHour();
		int minute = SystemTime.getMinute();
		String time = SystemTime.getTimeHMS();
		try {
			clockingIn = clockingInDAO.findClockingInByEmployeeAnd(employee, year, month, day);
			if ( (hour < START_CLOCKING_IN_TIME 
					|| (hour == START_CLOCKING_IN_TIME && minute == 0)) 
					&& hour < END_CLOCKING_IN_TIME) {
				//正常
				attendType = attendTypeDAO.getByID(COMMON_ATTEND_TYPE);
			} else if ((hour > START_CLOCKING_IN_TIME 
					|| (hour == START_CLOCKING_IN_TIME && minute > 0)) 
					&& hour < END_CLOCKING_IN_TIME) {
				//迟到
				attendType = attendTypeDAO.getByID(LATE_ATTEND_TYPE);
			}
			clockingIn.setTime(time);
			clockingIn.setAttendType(attendType);
			clockingInDAO.update(clockingIn);
			//创建签退信息
			attendType = attendTypeDAO.getByID(NEW_CLOCKING_IN_ATTEND_TYPE);
			clockingOut.setClockingIn(clockingIn);
			clockingOut.setAttendType(attendType);
			clockingOutDAO.save(clockingOut);
		} catch (Exception e) {
			System.out.println("ClockingInManager -> clocingkIn exception:" + e);
		}
		
	}

	@Override
	public void clocingkOut(Employee employee) {
		ClockingIn clockingIn = new ClockingIn();
		ClockingOut	clockingOut = new ClockingOut();
		AttendType attendType = new AttendType();
		int year = SystemTime.getYear();
		int month = SystemTime.getMonth();
		int day = SystemTime.getDay();
		int hour = SystemTime.getHour();
		int minute = SystemTime.getMinute();
		String time = SystemTime.getTimeHMS();
		try {
			clockingIn = clockingInDAO.findClockingInByEmployeeAnd(employee, year, month, day);
			clockingOut = clockingIn.getClockingOut();
			if ( hour >= END_CLOCKING_IN_TIME ) {
				//正常
				attendType = attendTypeDAO.getByID(COMMON_ATTEND_TYPE);
			} else if ( hour < END_CLOCKING_IN_TIME ) {
				//早退
				attendType = attendTypeDAO.getByID(EARLY_ATTEND_TYPE);
			}
			clockingOut.setTime(time);
			clockingOut.setAttendType(attendType);
			clockingOutDAO.update(clockingOut);
		} catch (Exception e) {
			System.out.println("ClockingInManager -> clocingkIn exception:" + e);
		}
	}

	@Override
	public List<ClockingIn> findMyselfThisMonthClockingIn(Employee employee) {
		List<ClockingIn> clockingIns = null;
		int year = SystemTime.getYear();
		int month = SystemTime.getMonth();
		try {
			clockingIns = clockingInDAO.findMyselfThisMonthClockIn(employee, year, month);
		} catch (Exception e) {
			System.out.println("ClockingInManager -> findMyselfThisMonthClockingIn:" + e);
		}
		return clockingIns;
	}

	@Override
	public List<ClockingIn> findTodayAllClockingIn() {
		List<ClockingIn> clockingIns = null;
		int year = SystemTime.getYear();
		int month = SystemTime.getMonth();
		int day = SystemTime.getDay();
		try {
			clockingIns = clockingInDAO.findTodayAllClockingIn(year, month , day);
		} catch (Exception e) {
			System.out.println("ClockingInManager -> findTodayAllClockingIn:" + e);
		}
		return clockingIns;
	}

	@Override
	public List<ClockingIn> findTodayDepartmentClockingIn(Employee employee) {
		List<ClockingIn> clockingIns = null;
		int year = SystemTime.getYear();
		int month = SystemTime.getMonth();
		int day = SystemTime.getDay();
		try {
			clockingIns = clockingInDAO.findTodayDepartmentClockingIn(employee, year, month, day);
		} catch (Exception e) {
			System.out.println("ClockingInManager -> findTodayDepartmentClockingIn:" + e);
		}
		return clockingIns;
	}

}
