package com.tk.dao.hbm;

import java.io.Serializable;

/**
 * 
 * @类说明 上班打卡考勤实体类 
 * @创建者 湛耀
 * @创建时间 2015年7月7日
 * @修改者 
 * @修改时间
 */
public class ClockingIn implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private int year;
	private int month;
	private int day;
	private String time;
	private String remark;
	private Employee employee;
	private ClockingOut clockingOut;
	private AttendType attendType;

	public ClockingIn() {
	}

	public ClockingIn(int id, Employee employee) {
		this.id = id;
		this.employee = employee;
	}
	
	public ClockingIn(int year, int month, int day, Employee employee,
			AttendType attendType) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
		this.employee = employee;
		this.attendType = attendType;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Integer getYear() {
		return this.year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return this.month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getDay() {
		return this.day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public ClockingOut getClockingOut() {
		return clockingOut;
	}

	public void setClockingOut(ClockingOut clockingOut) {
		this.clockingOut = clockingOut;
	}

	public AttendType getAttendType() {
		return attendType;
	}

	public void setAttendType(AttendType attendType) {
		this.attendType = attendType;
	}

	
}
