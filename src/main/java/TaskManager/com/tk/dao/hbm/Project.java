package com.tk.dao.hbm;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @方法说明 项目表的实体类
 * @创建者 panda
 * @创建日期 2015年7月15日 下午7:57:36
 * @修改者 
 * @修改时间 
 */
public class Project implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private String createDate;
	private String completeDate;
	private Employee leader;
	private Employee auditor;
	private String description;
	private int authority;
	private int status;
	private Set<Plan> plans = new HashSet<Plan>();
	private Set<Participants> participants = new HashSet<Participants>();
	
	public Project(){
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
	
	public void setLeader(Employee leader) {
		this.leader = leader;
	}
	
	public Employee getLeader() {
		return leader;
	}
	
	public void setAuditor(Employee auditor) {
		this.auditor = auditor;
	}
	
	public Employee getAuditor() {
		return auditor;
	}
	
	public void setAuthority(int authority) {
		this.authority = authority;
	}
	
	public int getAuthority() {
		return authority;
	}
	
	public Set<Plan> getPlans() {
		return plans;
	}
	
	public void setPlans(Set<Plan> plans) {
		this.plans = plans;
	}
	
	public void setParticipants(Set<Participants> participants) {
		this.participants = participants;
	}
	
	public Set<Participants> getParticipants() {
		return participants;
	}

}