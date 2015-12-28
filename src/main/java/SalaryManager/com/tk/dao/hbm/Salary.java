package com.tk.dao.hbm;

import java.io.Serializable;

/**
 * 
 * @类说明 工资实体类 
 * @创建者 湛耀
 * @创建时间 2015年7月7日
 * @修改者 
 * @修改时间
 */
public class Salary implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private int year;
	private int month;
	private int workload;
	private int totalSalary;
	private Employee employee;

	public Salary() {
	}

	public Salary(Employee employee, int year, int month, int workload) {
		this.employee = employee;
		this.year = year;
		this.month = month;
		this.workload = workload;
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

	public int getWorkload() {
		return this.workload;
	}

	public void setWorkload(int workload) {
		this.workload = workload;
	}
	
	public void setTotalSalary(int totalSalary) {
		this.totalSalary = totalSalary;
	}
	
	public int getTotalSalary() {
		return totalSalary;
	}

}
