package com.tk.dao.hbm;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @方法说明 任务表的实体类
 * @创建者 panda
 * @创建日期 2015年7月15日 下午7:56:49
 * @修改者 
 * @修改时间 
 */
public class Mission implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private String createDate;
	private String completeDate;
	private String description;
	private int status;
	private Plan plan;
	private Employee employee;
	private Set<CheckItem> checkItems;
	
	public Mission(){
		
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
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	public int getStatus() {
		return status;
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
	
	public void setCheckItems(Set<CheckItem> checkItems) {
		this.checkItems = checkItems;
	}
	
	public Set<CheckItem> getCheckItems() {
		return checkItems;
	}
}
