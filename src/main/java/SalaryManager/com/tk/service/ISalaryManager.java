package com.tk.service;

import java.util.List;

import com.tk.dao.EmployeeDAO;
import com.tk.dao.SalaryDAO;
import com.tk.dao.hbm.Salary;

/**
 * @类说明 SalaryManager接口
 * @创建者 panda
 * @创建时间 2015年7月5日
 * @修改者 
 * @修改时间 
 */
public interface ISalaryManager {
	
	/**
	 * @方法说明 设置SalaryDao
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午7:31:18
	 * @修改者 
	 * @修改时间 
	 * @param salaryDAO
	 * @return void
	 */
	public abstract void setsalaryDAO(SalaryDAO salaryDAO);
	
	/**
	 * @方法说明 获取SalaryDao
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午7:31:59
	 * @修改者 
	 * @修改时间 
	 * @return SalaryDAO
	 */
	public abstract SalaryDAO getsalaryDAO();
	
	/**
	 * @方法说明 设置EmployeeDao
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午7:33:43
	 * @修改者 
	 * @修改时间 
	 * @param employeeDAO
	 * @return void
	 */
	public abstract void setemployeeDAO(EmployeeDAO employeeDAO);
	
	/**
	 * @方法说明 获取EmployeeDao
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午7:34:02
	 * @修改者 
	 * @修改时间 
	 * @return
	 * @return EmployeeDAO
	 */
	public abstract EmployeeDAO getemployeeDAO();
	
	/**
	 * @方法说明 往数据库中添加一个新的工资记录
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午7:35:20
	 * @修改者 
	 * @修改时间 
	 * @param salary
	 * @return
	 * @return boolean
	 */
	public abstract boolean addSalary();
	
	/**
	 * @方法说明 修改单条工资记录,传入一个工资对象
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午7:36:39
	 * @修改者 
	 * @修改时间 
	 * @param salary
	 * @return boolean
	 */
	public abstract boolean updateSalary(Salary salary);
	
	/**
	 * @方法说明 删除单条工资记录,传入一个工资对象
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午7:41:30
	 * @修改者 
	 * @修改时间 
	 * @return boolean
	 */
	public abstract boolean deleteSalary(Salary salary);
	
	/**
	 * @方法说明 通过员工id查找工资列表
	 * @创建者 panda
	 * @创建日期 2015年7月10日 下午7:01:14
	 * @修改者 
	 * @修改时间 
	 * @param employeeID
	 * @return List<Salary>
	 */
	public abstract List<Salary> getSalariesByEmployeeID(String employeeID);
	
	/**
	 * @方法说明 通过员工id、年份、月份查找工资和工作量
	 * @创建者 panda
	 * @创建日期 2015年7月11日 上午12:47:10
	 * @修改者 
	 * @修改时间 
	 * @param year
	 * @param month
	 * @return Salary
	 */
	public abstract Salary getSalariesByYearMonth(String employeeID,int year,int month);
	
	/**
	 * @方法说明 自动结算员工工资
	 * @创建者 panda
	 * @创建日期 2015年7月11日 上午2:25:36
	 * @修改者 
	 * @修改时间 
	 * @return
	 * @return Salary
	 */
	public abstract String autoGetSalary();
}
