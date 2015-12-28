package com.tk.dao;

import com.tk.dao.hbm.LeaveState;

public interface LeaveStateDAO {
	
	public abstract void save(LeaveState leaveState);
	
	public abstract void delete(LeaveState leaveState);

	public abstract void update(LeaveState leaveState);
}
