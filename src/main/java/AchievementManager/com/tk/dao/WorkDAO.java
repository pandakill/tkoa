package com.tk.dao;

import java.util.List;

import com.tk.dao.hbm.Work;


/**
 * @类说明 Work的接口类
 * @创建者 panda
 * @创建时间 2015年7月5日
 * @修改者 
 * @修改时间 
 */
public interface WorkDAO {
	
	/**
	 * @方法说明 插入单条数据到work表中
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午1:23:48
	 * @修改者 
	 * @修改时间 
	 * @param work
	 * @return void
	 */
	public abstract void save(Work work);
	
	/**
	 * @方法说明 更新work表中的指定单条数据
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午1:24:02
	 * @修改者 
	 * @修改时间 
	 * @param work
	 * @return void
	 */
	public abstract void update(Work work);
	
	/**
	 * @方法说明 删除work表中的指定单条数据
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午1:24:16
	 * @修改者 
	 * @修改时间 
	 * @param work
	 * @return void
	 */
	public abstract void delete(Work work);
	
	/**
	 * @方法说明 根据id查找work表中的指定单条数据
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午1:24:34
	 * @修改者 
	 * @修改时间 
	 * @param id
	 * @return Work
	 */
	public abstract Work findByID(int id);
	
	/**
	 * @方法说明 根据employeeID查找work表中指定员工的所有工作量详细
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午1:24:52
	 * @修改者 
	 * @修改时间 
	 * @param employeeID
	 * @return List<Work>
	 */
	public abstract List<Work> findByEmployeeID(String employeeID);
	
	/**
	 * @方法说明 在work表中查找所有数据
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午1:25:47
	 * @修改者 
	 * @修改时间 
	 * @return List<Work>
	 */
	public abstract List<Work> findAll();
}
