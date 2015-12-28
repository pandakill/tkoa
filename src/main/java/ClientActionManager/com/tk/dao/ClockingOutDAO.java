package com.tk.dao;

import com.tk.dao.hbm.ClockingOut;

public interface ClockingOutDAO {

	public abstract void save(ClockingOut clockingOut);
	
	public abstract void delete(ClockingOut clockingOut);

	public abstract void update(ClockingOut clockingOut);

}
