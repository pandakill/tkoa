package com.tk.service.impl;

import java.util.List;

import com.tk.dao.DepartmentDAO;
import com.tk.dao.EmployeeDAO;
import com.tk.dao.hbm.Department;
import com.tk.dao.hbm.Employee;
import com.tk.service.IEmployeeManager;


public class EmployeeManager implements IEmployeeManager {

	private EmployeeDAO employeeDAO;
	private DepartmentDAO departmentDAO;
	
	@Override
	public void setemployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
		System.out.println("EmployeeManager -> setemployeeDAO" + this.employeeDAO);
	}

	@Override
	public EmployeeDAO getemployeeDAO() {
		return this.employeeDAO;
	}
	
	public void setDepartmentDAO(DepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
	}
	
	public DepartmentDAO getDepartmentDAO() {
		return departmentDAO;
	}
	
	@Override
	public Employee getEmployeeByTel(String tel) {
		Employee employee = employeeDAO.findByTel(tel);
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = null;
		try {
			System.out.println("1:" + employeeDAO);
			employees = employeeDAO.findAll();
			System.out.println("2: " + employees);
		} catch (Exception e) {
			System.out.println("EmployeeManager -> getAllEmployees" + e);
		}
		
		//超级管理员不输出
		for (int i = 0; i < employees.size(); i++) {
			if( employees.get(i).getUsers().getAuthorities().getAuthority().equals("ROLE_SUPER") ){
				employees.remove(i--);
			}
		}
		return employees;
	}

	@Override
	public List<Employee> getEmployeesByDepartmentID(String departmentID) {
		List<Employee> employees = employeeDAO.findByDepartmentID(departmentID);
		return employees;
	}
	
	@Override
	public String addEmployee(Employee employee){
		String flag = "FALSE";
		Employee employee2 = employeeDAO.findByTel(employee.getUsers().getUsername());
		if( null == employee2 ){
			List<Employee> list = employeeDAO.findAll();
			int count = list.size();
			String id = "";
			if( -1 < count && count < 9 ){
				id = "0000"+(count);
			}else if( 8 < count && count < 99 ){
				id = "000"+(count);
			}else if( 98 < count && count < 999 ){
				id = "00"+(count);
			}else if( 998 < count && count < 9999 ){
				id = "0"+(count);
			}else if( 9998 < count && count < 10000 ){
				id = ""+(count);
			}
			employee.setId(id);
			employeeDAO.save(employee);
			
			//更新部门人数,以及高职称人数
			Department department = departmentDAO.findByID(employee.getDepartment().getId());
			int headcount = department.getHeadcount();
			int hgHeadcount = department.getHighgradeHeadcount();
			department.setHeadcount(headcount+1);
			//如果员工学历id大于5,即高职称员工
			if( employee.getEducationBackground().getId() > 5){
				department.setHighgradeHeadcount(hgHeadcount+1);
			}
			departmentDAO.update(department);
			flag = "SUCCESS";
		}else{
			flag = "HAVED_USERS";
		}
		return flag;
	}

	@Override
	public String updateEmployee(Employee employee) {
		String flag = "FALSE";
		Employee employee2 = employeeDAO.findByID(employee.getId());
		//新的部门
		Department department = employee.getDepartment();
		//原来的部门
		Department department2 = employee2.getDepartment();
		//更新员工信息操作
		employeeDAO.update(employee);
		//如果是同个部门,则修改同个部门当中的人数;否则同时修改两个部门人数
		if( department.equals(department2) ){
			//同个部门的,人数不变,判断高职称人数是否要变化
			int newEDID = employee.getEducationBackground().getId();
			int oldEDID = employee2.getEducationBackground().getId();			
			if( oldEDID < 6 && newEDID >5){
				department.setHighgradeHeadcount(department.getHighgradeHeadcount()+1);
			}else if( oldEDID > 5 && newEDID < 6 ){
				department.setHighgradeHeadcount(department.getHighgradeHeadcount()-1);
			}
			departmentDAO.update(department);
		}else{
			int newEDID = employee.getEducationBackground().getId();
			int oldEDID = employee2.getEducationBackground().getId();
			//新部门人数+1,原来的部门人数-1
			department.setHeadcount(department.getHeadcount()+1);
			department2.setHeadcount(department2.getHeadcount()-1);
			if( oldEDID > 5 ){
				department2.setHighgradeHeadcount(department2.getHighgradeHeadcount()-1);
			}
			if( newEDID > 5 ){
				department.setHighgradeHeadcount(department.getHighgradeHeadcount()+1);
			}
			departmentDAO.update(department);
			departmentDAO.update(department2);
		}
		flag = "SUCCESS";
		return flag;
	}

	@Override
	public String deleteEmployee(Employee employee) {
		Employee employee2 = employeeDAO.findByID(employee.getId());
		Department department = employee2.getDepartment();
		department.setHeadcount(department.getHeadcount()-1);
		if( department.getHighgradeHeadcount() > 5 ){
			department.setHighgradeHeadcount(department.getHighgradeHeadcount()-1);
		}
		departmentDAO.update(department);
		employeeDAO.delete(employee2);
		return "SUCCESS";
	}

	@Override
	public Employee getEmployeeByID(String id) {
		Employee employee = employeeDAO.findByID(id);
		return employee;
	}
	
}
