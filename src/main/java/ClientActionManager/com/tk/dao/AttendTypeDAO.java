package com.tk.dao;

import com.tk.dao.hbm.AttendType;

public interface AttendTypeDAO {
	
	public abstract void save(AttendType attendType);
	
	public abstract void delete(AttendType attendType);

	public abstract void update(AttendType attendType);
	
	public abstract AttendType getByID(int id);
}
