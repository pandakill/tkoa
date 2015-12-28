package com.tk.dao;

import java.util.List;

import com.tk.dao.hbm.Salary;


/**
 * @类说明 Salary的接口类
 * @创建者 panda
 * @创建时间 2015年7月5日
 * @修改者 
 * @修改时间 
 */
public interface SalaryDAO {
	
	/**
	 * @方法说明 插入单条数据到salary表中
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午1:20:01
	 * @修改者 
	 * @修改时间 
	 * @param salary
	 * @return void
	 */
	public abstract void save(Salary salary);
	
	/**
	 * @方法说明 更新salary表中的指定单条数据
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午1:20:59
	 * @修改者 
	 * @修改时间 
	 * @param salary
	 * @return void
	 */
	public abstract void update(Salary salary);
	
	/**
	 * @方法说明 删除salary表中的指定单条数据
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午1:21:39
	 * @修改者 
	 * @修改时间 
	 * @param salary
	 * @return void
	 */
	public abstract void delete(Salary salary);
	
	/**
	 * @方法说明 根据id查找salary表中指定的数据
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午1:21:57
	 * @修改者 
	 * @修改时间 
	 * @param id
	 * @return
	 * @return Salary
	 */
	public abstract Salary findByID(int id);
	
	/**
	 * @方法说明 根据employeeID在salary查找属于某个员工的所有工资详细
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午1:22:18
	 * @修改者 
	 * @修改时间 
	 * @param employeeID
	 * @return
	 * @return List<Salary>
	 */
	public abstract List<Salary> findByEmployeeID(String employeeID);
	
	/**
	 * @方法说明 查找salary表中所有的数据
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午1:23:10
	 * @修改者 
	 * @修改时间 
	 * @return
	 * @return List<Salary>
	 */
	public abstract List<Salary> findAll();
	
}
