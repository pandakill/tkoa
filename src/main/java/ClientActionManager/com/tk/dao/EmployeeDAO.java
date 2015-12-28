package com.tk.dao;

import java.util.List;

import com.tk.dao.hbm.Employee;

/**
 * @类说明 Employee的接口类
 * @创建者 panda
 * @创建时间 2015年7月5日
 * @修改者 
 * @修改时间 
 */
public interface EmployeeDAO {
	
	/**
	 * @方法说明 插入单条数据到employee表中
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午12:56:19
	 * @修改者 
	 * @修改时间 
	 * @param employee
	 * @return void
	 */
	public abstract void save(Employee employee);
	
	/**
	 * @方法说明 更新employee表中指定的单条数据
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午12:56:49
	 * @修改者 
	 * @修改时间 
	 * @param employee
	 * @return void
	 */
	public abstract void update(Employee employee);
	
	/**
	 * @方法说明 删除employee表中指定的单条数据
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午12:57:54
	 * @修改者 
	 * @修改时间 
	 * @param employee
	 * @return void
	 */
	public abstract void delete(Employee employee);
	
	/**
	 * @方法说明 根据id在employee表中查找指定的单条数据
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午12:58:14
	 * @修改者 
	 * @修改时间 
	 * @param id
	 * @return Employee
	 */
	public abstract Employee findByID(String id);
	
	/**
	 * @方法说明 根据departmentID查找属于某个部门的员工们
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午12:58:37
	 * @修改者 
	 * @修改时间 
	 * @param department_id
	 * @return List<Employee>
	 */
	public abstract List<Employee> findByDepartmentID(String departmentID);
	
	/**
	 * @方法说明 根据postID查找数据该岗位的员工们
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午12:59:16
	 * @修改者 
	 * @修改时间 
	 * @param postID
	 * @return
	 * @return List<Employee>
	 */
	public abstract List<Employee> findByPostID(int postID);
	
	/**
	 * @方法说明 根据tel手机号码查找指定的单个员工
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午1:00:12
	 * @修改者 
	 * @修改时间 
	 * @param String
	 * @return Employee
	 */
	public abstract Employee findByTel(String tel);
	
	/**
	 * @方法说明 在employee表中查找所有的数据
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午1:00:41
	 * @修改者 
	 * @修改时间 
	 * @return List<Employee>
	 */
	public abstract List<Employee> findAll();
}
