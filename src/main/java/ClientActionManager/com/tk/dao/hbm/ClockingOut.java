package com.tk.dao.hbm;

import java.io.Serializable;

/**
 * 
 * @类说明 下班打卡实体类 
 * @创建者 湛耀
 * @创建时间 2015年7月7日
 * @修改者 
 * @修改时间
 */
public class ClockingOut implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String time;
	private String remark;
	private AttendType attendType;
	private ClockingIn clockingIn;
	
	public ClockingOut() {
		super();
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public AttendType getAttendType() {
		return attendType;
	}

	public void setAttendType(AttendType attendType) {
		this.attendType = attendType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ClockingIn getClockingIn() {
		return clockingIn;
	}

	public void setClockingIn(ClockingIn clockingIn) {
		this.clockingIn = clockingIn;
	}
	
}
