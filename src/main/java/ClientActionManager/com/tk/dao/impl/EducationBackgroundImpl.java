package com.tk.dao.impl;

import java.util.List;

import com.tk.dao.EducationBackgroundDAO;
import com.tk.dao.hbm.EducationBackground;

public class EducationBackgroundImpl extends BaseDaoImpl implements EducationBackgroundDAO {

	@Override
	public List<EducationBackground> findAll() {
		List<EducationBackground> list = getHibernateTemplate().find("from com.tk.dao.hbm.EducationBackground");
		return list;
	}

	@Override
	public EducationBackground findEducationBackgroundByID(int id) {
		EducationBackground educationBackground = (EducationBackground) getHibernateTemplate().get("com.tk.dao.hbm.EducationBackground", id);
		return educationBackground;
	}

}
