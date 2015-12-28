package com.tk.dao.impl;

import com.tk.dao.PlanDAO;
import com.tk.dao.hbm.Plan;

public class PlanDAOImpl extends BaseDaoImpl implements PlanDAO {

	@Override
	public void save(Plan plan) {
		try {
			getHibernateTemplate().save(plan);
		} catch (Exception e) {
			System.out.println("PlanDAOImpl -> save: " + e);
		}
	}

	@Override
	public Plan findByID(int id) {
		try {
			Plan plan = (Plan) getHibernateTemplate().get("com.tk.dao.hbm.Plan", id);
			return plan;
		} catch (Exception e) {
			System.out.println("PlanDAOImpl -> findByID: " + e);
			return null;
		}
		
		
	}

}
