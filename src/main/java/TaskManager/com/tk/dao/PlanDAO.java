package com.tk.dao;

import com.tk.dao.hbm.Plan;

public interface PlanDAO  {
	
	public abstract void save(Plan plan);
	
	public abstract Plan findByID(int id);
	
}
