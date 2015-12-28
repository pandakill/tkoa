package com.tk.dao.hbm;

import java.io.Serializable;

/**
 * 
 * @类说明 外勤业务实体类 
 * @创建者 湛耀
 * @创建时间 2015年7月7日
 * @修改者 
 * @修改时间
 */
public class ExpatriateLabor implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private int deadline;
	private String customerName;
	private String projectDetails;
	private String customerAddress;
	private String attackTime;
	private String longitudeE;
	private String latitudeE;
	private int status;
	private Employee employee;
	private Department department;

	public ExpatriateLabor() {
	}
	
	public ExpatriateLabor(int id,int deadline,String customerName, String customerAddress,
			String attackTime,String longitudeE,String latitudeE){
		this.id = id;
		this.deadline = deadline;
		this.customerName =customerName;
		this.customerAddress = customerAddress;
		this.attackTime = attackTime;
		this.latitudeE = latitudeE;
		this.longitudeE = longitudeE;
	}

	public ExpatriateLabor(int id, Employee employee, Department department,
			String customerName, String projectDetails, String customerAddress,
			int deadline) {
		this.id = id;
		this.employee = employee;
		this.department = department;
		this.customerName = customerName;
		this.projectDetails = projectDetails;
		this.customerAddress = customerAddress;
		this.deadline = deadline;
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

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getProjectDetails() {
		return this.projectDetails;
	}

	public void setProjectDetails(String projectDetails) {
		this.projectDetails = projectDetails;
	}

	public String getCustomerAddress() {
		return this.customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public int getDeadline() {
		return this.deadline;
	}

	public void setDeadline(int deadline) {
		this.deadline = deadline;
	}

	public String getAttackTime() {
		return attackTime;
	}

	public void setAttackTime(String attackTime) {
		this.attackTime = attackTime;
	}

	public String getLongitudeE() {
		return longitudeE;
	}

	public void setLongitudeE(String longitudeE) {
		this.longitudeE = longitudeE;
	}

	public String getLatitudeE() {
		return latitudeE;
	}

	public void setLatitudeE(String latitudeE) {
		this.latitudeE = latitudeE;
	}
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ExpatriateLabor [id=" + id + ", deadline=" + deadline
				+ ", customerName=" + customerName + ", projectDetails="
				+ projectDetails + ", customerAddress=" + customerAddress
				+ ", attackTime=" + attackTime + ", longitudeE=" + longitudeE
				+ ", latitudeE=" + latitudeE + ", status=" + status
				+ ", employee=" + employee.getName() + ", department=" + department.getName() + "]";
	}
	

}
