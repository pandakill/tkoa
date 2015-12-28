package com.tk.dao.hbm;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


/**
 * @方法说明 计划表的实体类
 * @创建者 panda
 * @创建日期 2015年7月15日 下午7:57:26
 * @修改者 
 * @修改时间 
 */
public class Plan implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String createDate;
	private String completeDate;
	private String description;
	private int status;
	private Employee leader;
	private Set<Mission> missions = new HashSet<Mission>();
	private Set<CooperaticePerson> cooperaticePersons = new HashSet<CooperaticePerson>();
	private Project project;
	
	public Plan(){
	}
	
	public Plan(String name){
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
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
	
	public void setLeader(Employee leader) {
		this.leader = leader;
	}
	
	public Employee getLeader() {
		return leader;
	}
	
	public void setMissions(Set<Mission> missions) {
		this.missions = missions;
	}
	
	public Set<Mission> getMissions() {
		return missions;
	}
	
	public void setProject(Project project) {
		this.project = project;
	}
	
	public Project getProject() {
		return project;
	}
	
	public void setCooperaticePersons(Set<CooperaticePerson> cooperaticePersons) {
		this.cooperaticePersons = cooperaticePersons;
	}
	
	public Set<CooperaticePerson> getCooperaticePersons() {
		return cooperaticePersons;
	}
}
