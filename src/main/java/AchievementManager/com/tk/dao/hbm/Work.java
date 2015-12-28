package com.tk.dao.hbm;

import java.io.Serializable;

/**
 * 
 * @类说明 工作实体类 
 * @创建者 湛耀
 * @创建时间 2015年7月7日
 * @修改者 
 * @修改时间
 */
public class Work implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private int year;
	private int month;
	private int day;
	private Employee employee;

	public Work() {
	}

	public Work(Employee employee, int year, int month, int day) {
		this.employee = employee;
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public int getYear() {
		return this.year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return this.month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return this.day;
	}

	public void setDay(int day) {
		this.day = day;
	}

}
