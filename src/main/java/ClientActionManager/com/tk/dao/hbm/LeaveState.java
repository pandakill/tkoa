package com.tk.dao.hbm;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @类说明 请假状态实体类 
 * @创建者 湛耀
 * @创建时间 2015年7月9日
 * @修改者 
 * @修改时间
 */
public class LeaveState implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private Set<Leave> leaves = new HashSet<Leave>();
	
	public LeaveState() {
		super();
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

	public Set<Leave> getLeaves() {
		return leaves;
	}

	public void setLeaves(Set<Leave> leaves) {
		this.leaves = leaves;
	}

}
