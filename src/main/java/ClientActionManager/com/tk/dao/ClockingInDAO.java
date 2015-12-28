package com.tk.dao;

import java.util.List;

import com.tk.dao.hbm.ClockingIn;
import com.tk.dao.hbm.Employee;


/**
 * @类说明 ClockingIn的接口类
 * @创建者 panda
 * @创建时间 2015年7月5日
 * @修改者 
 * @修改时间 
 */
public interface ClockingInDAO {
	
	/**
	 * @方法说明 插入单条数据到users表中
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午12:48:37
	 * @修改者 
	 * @修改时间 
	 * @param clockingIn
	 * @return void
	 */
	public abstract void save(ClockingIn clockingIn);
	
	/**
	 * @方法说明 更新clocking_in中指定的某条数据
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午12:49:18
	 * @修改者 
	 * @修改时间 
	 * @param clockingIn
	 * @return void
	 */
	public abstract void update(ClockingIn clockingIn);
	
	/**
	 * @方法说明 从clocking_in表中删除指定的user
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午12:49:45
	 * @修改者 
	 * @修改时间 
	 * @param clockingIn
	 * @return void
	 */
	public abstract void delete(ClockingIn clockingIn);
	
	/**
	 * @方法说明 通过id查找clocking_in表中指定的单条数据
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午12:50:23
	 * @修改者 
	 * @修改时间 
	 * @param id
	 * @return ClockingIn
	 */
	public abstract ClockingIn findByID(int id);
	
	/**
	 * @方法说明 通过employeeID查找clocking_in表中指定的单条数据,返回单条的list,list.get(0)
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午12:51:10
	 * @修改者 
	 * @修改时间 
	 * @param employeeID
	 * @return List<ClockingIn>
	 */
	public abstract List<ClockingIn> findByEmployeeID(String employeeID);
	
	/**
	 * @方法说明 查找clocking_in表中的所有数据
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午12:51:42
	 * @修改者 
	 * @修改时间 
	 * @return
	 * @return List<ClockingIn>
	 */
	public abstract List<ClockingIn> findAll();

	public abstract ClockingIn findClockingInByEmployeeAnd(Employee employee,
			int year, int month, int day);

	public abstract List<ClockingIn> findMyselfThisMonthClockIn(
			Employee employee, int year, int month);

	public abstract List<ClockingIn> findTodayAllClockingIn(int year,
			int month, int day);

	public abstract List<ClockingIn> findTodayDepartmentClockingIn(
			Employee employee, int year, int month, int day);

	public abstract ClockingIn findYesterdayClockingIn(Employee employee, int year, int month, int day);

	
}
