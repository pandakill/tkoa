package com.tk.service;

import java.util.List;

import com.tk.dao.EducationBackgroundDAO;
import com.tk.dao.hbm.EducationBackground;

public interface IEducationBackgroundManager {
	
	public abstract void setEducationBackgroundDAO(EducationBackgroundDAO educationBackgroundDAO);
	
	public abstract EducationBackgroundDAO getEducationBackgroundDAO();
	
	public abstract EducationBackground getEducationBackgroundByID(int id);
	
	public abstract List<EducationBackground> getEducationBackgrounds();
}
