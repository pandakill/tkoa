package com.tk.dao;

import java.util.List;

import com.tk.dao.hbm.ExpatriateLabor;


/**
 * @类说明 ExpartriateLabor的接口类
 * @创建者 panda
 * @创建时间 2015年7月5日
 * @修改者 
 * @修改时间 
 */
public interface ExpatriateLaborDAO {
	
	/**
	 * @方法说明 插入单条数据到expartriate_labor表中
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午1:01:42
	 * @修改者 
	 * @修改时间 
	 * @param expatriateLabor
	 * @return void
	 */
	public abstract void save(ExpatriateLabor expatriateLabor);
	
	/**
	 * @方法说明 更新expartriate_labor表中指定的单条数据
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午1:02:16
	 * @修改者 
	 * @修改时间 
	 * @param expatriateLabor
	 * @return void
	 */
	public abstract void update(ExpatriateLabor expatriateLabor);
	
	/**
	 * @方法说明 删除expartriate_labor表中指定的单条数据
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午1:02:46
	 * @修改者 
	 * @修改时间 
	 * @param expatriateLabor
	 * @return void
	 */
	public abstract void delete(ExpatriateLabor expatriateLabor);
	
	/**
	 * @方法说明 根据ID在expartriate_labor表中查找指定的单条数据
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午1:03:10
	 * @修改者 
	 * @修改时间 
	 * @param id
	 * @return ExpatriateLabor
	 */
	public abstract ExpatriateLabor findByID(int id);
	
	/**
	 * @方法说明 根据departementID在expartiate_labor表中查找属于某个部门的所有外勤任务
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午1:03:41
	 * @修改者 
	 * @修改时间 
	 * @param department_id
	 * @return List<ExpatriateLabor>
	 */
	public abstract List<ExpatriateLabor> findByDepartmentID(String departmentID);
	
	/**
	 * @方法说明 根据employeeID在expartiate_labor表中查找属于某个员工的所有外勤任务
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午1:04:33
	 * @修改者 
	 * @修改时间 
	 * @param employeeID
	 * @return List<ExpatriateLabor>
	 */
	public abstract List<ExpatriateLabor> findByEmployeeID(String employeeID);
	
	/**
	 * @方法说明 在expatriate_labor表中查找所有数据
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午1:05:48
	 * @修改者 
	 * @修改时间 
	 * @return
	 * @return List<ExpatriateLabor>
	 */
	public abstract List<ExpatriateLabor> findAll();
}
