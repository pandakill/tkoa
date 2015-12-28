package com.tk.service;

import java.util.List;

import com.tk.dao.EmployeeDAO;
import com.tk.dao.hbm.Employee;

public interface IEmployeeManager {
	
	public abstract void setemployeeDAO(EmployeeDAO employeeDAO);
	
	public abstract EmployeeDAO getemployeeDAO();
	
	/**
	 * 
	 * @方法说明 根据用户名（即手机号）获取员工
	 * @创建者 湛耀
	 * @创建日期 2015年7月8日 下午8:42:27
	 * @修改者 
	 * @修改时间 
	 * @param tel
	 * @return
	 * @return Employee
	 */
	public Employee getEmployeeByTel(String tel);
	
	/**
	 * 
	 * @方法说明 获取所有人的信息
	 * @创建者 湛耀
	 * @创建日期 2015年7月8日 下午8:48:51
	 * @修改者 
	 * @修改时间 
	 * @return
	 * @return List<Employee>
	 */
	public List<Employee> getAllEmployees();
	
	/**
	 * 
	 * @方法说明	根据部门ID获取该部门所有员工
	 * @创建者 湛耀
	 * @创建日期 2015年7月9日 上午12:00:50
	 * @修改者 
	 * @修改时间 
	 * @param departmentID
	 * @return
	 * @return List<Employee>
	 */
	public List<Employee> getEmployeesByDepartmentID(String departmentID);
	
	public abstract String addEmployee(Employee employee);
	
	public abstract String updateEmployee(Employee employee);
	
	public abstract String deleteEmployee(Employee employee);
	
	public abstract Employee getEmployeeByID(String id);
	
}
