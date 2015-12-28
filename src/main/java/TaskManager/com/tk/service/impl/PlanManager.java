package com.tk.service.impl;

import com.tk.dao.PlanDAO;
import com.tk.dao.hbm.Plan;
import com.tk.service.IPlanManager;

public class PlanManager implements IPlanManager {
	
	private PlanDAO planDAO;

	@Override
	public void setplanDAO(PlanDAO planDAO) {
		this.planDAO = planDAO;
		System.out.println("PlanManager -> setplanDAO: " + this.planDAO);
	}

	@Override
	public PlanDAO getplanDAO() {
		return this.planDAO;
	}

	@Override
	public String addPlan(Plan plan) {
		String flag = "FALSE";
		try {
			planDAO.save(plan);
			flag = "SUCCESS";
		} catch (Exception e) {
			System.out.println("PlanManager -> addPlan: "+e);
			flag = "SUCCESS";
		}
		return flag;
	}

	@Override
	public Plan getPlanByID(int id) {
		Plan plan = planDAO.findByID(id);
		return plan;
	}

}
