package com.tk.dao.hbm;

import java.io.Serializable;

/**
 * @方法说明 协作人表的实体类
 * @创建者 panda
 * @创建日期 2015年7月15日 下午7:56:33
 * @修改者 
 * @修改时间 
 */
public class CooperaticePerson implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private Plan plan;
	private Employee employee;
	
	public CooperaticePerson(){
		
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setPlan(Plan plan) {
		this.plan = plan;
	}
	
	public Plan getPlan() {
		return plan;
	}
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public Employee getEmployee() {
		return employee;
	}

}