package com.tk.service.impl;

import java.util.List;

import com.tk.dao.EmployeeDAO;
import com.tk.dao.ExpatriateLaborDAO;
import com.tk.dao.WorkDAO;
import com.tk.dao.hbm.Department;
import com.tk.dao.hbm.Employee;
import com.tk.dao.hbm.ExpatriateLabor;
import com.tk.service.IAchievementManager;

public class AchievementManager implements IAchievementManager {

	private ExpatriateLaborDAO expatriateLaborDAO;
	private EmployeeDAO employeeDAO;
	private WorkDAO workDAO;
	
	@Override
	public EmployeeDAO getEmployeeDAO() {
		return employeeDAO;
	}

	@Override
	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
		System.out.println("AchievementManager -> setEmployeeDAO:" + this.employeeDAO);
	}

	@Override
	public ExpatriateLaborDAO getExpatriateLaborDAO() {
		return expatriateLaborDAO;
	}

	@Override
	public void setExpatriateLaborDAO(
			ExpatriateLaborDAO expatriateLaborDAO) {
		this.expatriateLaborDAO = expatriateLaborDAO;
		System.out.println("AchievementManager -> setExpatriateLaborDAO:" + this.expatriateLaborDAO);
	}

	@Override
	public WorkDAO getWorkDAO() {
		return workDAO;
	}

	@Override
	public void setWorkDAO(WorkDAO workDAO) {
		this.workDAO = workDAO;
		System.out.println("AchievementManager -> setWorkDAO:" + this.workDAO);
	}
	
	@Override
	public List<ExpatriateLabor> getExpatriateLaborsByDepartmentID(String departmentId) {
		List<ExpatriateLabor> expatriateLabors = null;
		expatriateLabors = expatriateLaborDAO.findByDepartmentID(departmentId);
		return expatriateLabors;
	}

	@Override
	public boolean saveExpatriate(String name, String employeeID, String details,
			String address, String longitude, String latitude,
			String begindate, int deadline) {
		boolean flag = false;
		try {
			Employee employee = employeeDAO.findByID(employeeID);
			Department department = employee.getDepartment();
			ExpatriateLabor expatriateLabor = new ExpatriateLabor();
			expatriateLabor.setCustomerName(name);
			expatriateLabor.setDepartment(department);
			expatriateLabor.setEmployee(employee);
			expatriateLabor.setProjectDetails(details);
			expatriateLabor.setCustomerAddress(address);
			expatriateLabor.setLongitudeE(longitude);
			expatriateLabor.setLatitudeE(latitude);
			expatriateLabor.setAttackTime(begindate);
			expatriateLabor.setDeadline(deadline);
			expatriateLaborDAO.save(expatriateLabor);
			flag = true;
		} catch (Exception e) {
			System.out.println("AchievementManager -> saveExpatriate:" + e);
		}
		return flag;
	}

}
