package com.tk.dao.hbm;

import java.io.Serializable;


/**
 * @方法说明 检查项的实体类
 * @创建者 panda
 * @创建日期 2015年7月15日 下午7:38:13
 * @修改者 
 * @修改时间 
 */
public class CheckItem implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String createDate;
	private String completeDate;
	private int status;
	private Mission mission;
	private Employee employee;
	
	public CheckItem(){
		
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	public int getStatus() {
		return status;
	}
	
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	public String getCreateDate() {
		return createDate;
	}
	
	public void setCompleteDate(String completeDate) {
		this.completeDate = completeDate;
	}
	
	public String getCompleteDate() {
		return completeDate;
	}
	
	public void setMission(Mission mission) {
		this.mission = mission;
	}
	
	public Mission getMission() {
		return mission;
	}
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public Employee getEmployee() {
		return employee;
	}

}