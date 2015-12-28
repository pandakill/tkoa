package com.tk.service.impl;

import java.util.List;

import com.tk.dao.EducationBackgroundDAO;
import com.tk.dao.hbm.EducationBackground;
import com.tk.service.IEducationBackgroundManager;

public class EducationBackgroundManager implements IEducationBackgroundManager {

	private EducationBackgroundDAO educationBackgroundDAO;
	
	@Override
	public void setEducationBackgroundDAO(EducationBackgroundDAO educationBackgroundDAO) {
		this.educationBackgroundDAO = educationBackgroundDAO;
		System.out.println("EducationBackgroundManager -> setEducationBackground:" + this.educationBackgroundDAO);
	}

	@Override
	public EducationBackgroundDAO getEducationBackgroundDAO() {
		return this.educationBackgroundDAO;
	}

	@Override
	public List<EducationBackground> getEducationBackgrounds() {
		List<EducationBackground> list = educationBackgroundDAO.findAll();
		return list;
	}

	@Override
	public EducationBackground getEducationBackgroundByID(int id) {
		EducationBackground educationBackground = educationBackgroundDAO.findEducationBackgroundByID(id);
		return educationBackground;
	}

}
