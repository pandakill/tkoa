package com.tk.dao;

import java.util.List;

import com.tk.dao.hbm.Department;

/**
 * @类说明 Department的接口类
 * @创建者 panda
 * @创建时间 2015年7月5日
 * @修改者 
 * @修改时间 
 */
public interface DepartmentDAO {
	
	/**
	 * @方法说明 插入单条数据到department表中
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午12:52:29
	 * @修改者 
	 * @修改时间 
	 * @param department
	 * @return void
	 */
	public abstract void save(Department department);
	
	/**
	 * @方法说明 更新department中指定的某条数据
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午12:52:44
	 * @修改者 
	 * @修改时间 
	 * @param department
	 * @return void
	 */
	public abstract void update(Department department);
	
	/**
	 * @方法说明 从department表中删除指定的单条数据
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午12:53:10
	 * @修改者 
	 * @修改时间 
	 * @param department
	 * @return void
	 */
	public abstract void delete(Department department);
	
	/**
	 * @方法说明 根据id查找指定的单条department数据
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午12:53:35
	 * @修改者 
	 * @修改时间 
	 * @param id
	 * @return Department
	 */
	public abstract Department findByID(String id);
	
	/**
	 * @方法说明 根据departmentName查找指定的单条department数据，单条list结构
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午12:54:09
	 * @修改者 panda
	 * @修改时间 2015-7-8 14:59
	 * @修改内容 将返回类型改为department
	 * @param departmentName
	 * @return Department
	 */
	public abstract Department findByDepartmentName(String departmentName);
		
	/**
	 * @方法说明 根据businessID查找指定的单条department数据,单条的list结构
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午12:54:37
	 * @修改者 
	 * @修改时间 
	 * @param businessID
	 * @return List<Department>
	 */
	public abstract List<Department> findByBusinessID(int businessID);
		
	/**
	 * @方法说明 查找department表中的所有数据
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午12:55:45
	 * @修改者 
	 * @修改时间 
	 * @return
	 * @return List<Department>
	 */
	public abstract List<Department> findAll();
}
