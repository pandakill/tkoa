package com.tk.service;

import com.tk.dao.PlanDAO;
import com.tk.dao.hbm.Plan;

public interface IPlanManager {
	
	public abstract void setplanDAO(PlanDAO planDAO);
	
	public abstract PlanDAO getplanDAO();
	
	public abstract String addPlan(Plan plan);
	
	public abstract Plan getPlanByID(int id);
	
}
