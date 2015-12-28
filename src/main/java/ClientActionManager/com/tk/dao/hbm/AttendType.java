package com.tk.dao.hbm;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @类说明 考勤状态实体类 
 * @创建者 湛耀
 * @创建时间 2015年7月7日
 * @修改者 
 * @修改时间
 */
public class AttendType implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private Set<ClockingIn> clockingIns = new HashSet<ClockingIn>();
	private Set<ClockingOut> clockingOuts = new HashSet<ClockingOut>();
	
	public AttendType() {
		super();
	}
	
	public AttendType(int id) {
		super();
		this.id = id;
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

	public Set<ClockingIn> getClockingIns() {
		return clockingIns;
	}

	public void setClockingIns(Set<ClockingIn> clockingIns) {
		this.clockingIns = clockingIns;
	}

	public Set<ClockingOut> getClockingOuts() {
		return clockingOuts;
	}

	public void setClockingOuts(Set<ClockingOut> clockingOuts) {
		this.clockingOuts = clockingOuts;
	}
	
}
