package com.tk.dao.hbm;

import java.io.Serializable;

/**
 * @方法说明 项目参与人表的实体类
 * @创建者 panda
 * @创建日期 2015年7月15日 下午7:57:13
 * @修改者 
 * @修改时间 
 */
public class Participants implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private Project project;
	private Employee employee;
	
	public Participants(){
		
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setProject(Project project) {
		this.project = project;
	}
	
	public Project getProject() {
		return project;
	}
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public Employee getEmployee() {
		return employee;
	}

}