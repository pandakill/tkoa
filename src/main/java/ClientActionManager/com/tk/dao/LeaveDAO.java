package com.tk.dao;

import com.tk.dao.hbm.Leave;

public interface LeaveDAO {

	public abstract void save(Leave leave);
	
	public abstract void delete(Leave leave);

	public abstract void update(Leave leave);
}
