package com.tk.dao.hbm;

import java.io.Serializable;

/**
 * 
 * @类说明	请假信息实体类 
 * @创建者 湛耀
 * @创建时间 2015年7月9日
 * @修改者 
 * @修改时间
 */
public class Leave implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String timeOfApplication;
	private String reason;
	private String start;
	private String end;
	private String persist;
	private String approver;
	private String appTime;
	private String postil;
	private LeaveState leaveState;
	private Employee employee;
	
	public Leave() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTimeOfApplication() {
		return timeOfApplication;
	}

	public void setTimeOfApplication(String timeOfApplication) {
		this.timeOfApplication = timeOfApplication;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getPersist() {
		return persist;
	}

	public void setPersist(String persist) {
		this.persist = persist;
	}

	public String getApprover() {
		return approver;
	}

	public void setApprover(String approver) {
		this.approver = approver;
	}

	public String getAppTime() {
		return appTime;
	}

	public void setAppTime(String appTime) {
		this.appTime = appTime;
	}

	public String getPostil() {
		return postil;
	}

	public void setPostil(String postil) {
		this.postil = postil;
	}

	public LeaveState getLeaveState() {
		return leaveState;
	}

	public void setLeaveState(LeaveState leaveState) {
		this.leaveState = leaveState;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
