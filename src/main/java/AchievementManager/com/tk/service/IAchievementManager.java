package com.tk.service;

import java.util.List;

import com.tk.dao.EmployeeDAO;
import com.tk.dao.ExpatriateLaborDAO;
import com.tk.dao.WorkDAO;
import com.tk.dao.hbm.ExpatriateLabor;

public interface IAchievementManager {

	public abstract ExpatriateLaborDAO getExpatriateLaborDAO();
	public abstract void setExpatriateLaborDAO(ExpatriateLaborDAO expatriateLaborDAO);
	public abstract WorkDAO getWorkDAO();
	public abstract void setWorkDAO(WorkDAO workDAO);
	public abstract EmployeeDAO getEmployeeDAO();
	public abstract void setEmployeeDAO(EmployeeDAO employeeDAO);
	
	public abstract List<ExpatriateLabor> getExpatriateLaborsByDepartmentID(String departmentId);
	/**
	 * 
	 * @方法说明 保存新的外勤任务
	 * @创建者 湛耀
	 * @创建日期 2015年7月10日 上午12:01:33
	 * @修改者 
	 * @修改时间 
	 * @param name
	 * @param employeeID
	 * @param details
	 * @param address
	 * @param longitude
	 * @param latitude
	 * @param begindate
	 * @param deadline
	 * @return boolean
	 */
	public abstract boolean saveExpatriate(String name, String employeeID,
			String details, String address, String longitude, String latitude,
			String begindate, int deadline);
	
	
}
