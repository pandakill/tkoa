package com.tk.dao;

import java.util.List;

import com.tk.dao.hbm.Business;


/**
 * @类说明 business的接口类
 * @创建者 panda
 * @创建时间 2015年7月5日
 * @修改者 
 * @修改时间 
 */
public interface BusinessDAO {
	
	/**
	 * @方法说明 插入单条数据到users表中
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午12:46:02
	 * @修改者 
	 * @修改时间 
	 * @param business
	 * @return void
	 */
	public abstract void save(Business business);
	
	/**
	 * @方法说明 更新business中指定的某条数据
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午12:46:31
	 * @修改者 
	 * @修改时间 
	 * @param business
	 * @return void
	 */
	public abstract void update(Business business);
	
	/**
	 * @方法说明 从business表中删除指定的user
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午12:46:42
	 * @修改者 
	 * @修改时间 
	 * @param business
	 * @return void
	 */
	public abstract void delete(Business business);
	
	/**
	 * @方法说明 根据id在business表中查找指定的单条数据
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午12:46:54
	 * @修改者 
	 * @修改时间 
	 * @param id
	 * @return
	 * @return Business
	 */
	public abstract Business findByID(int id);
		
	/**
	 * @方法说明 查找business表中的所有数据
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午12:47:37
	 * @修改者 
	 * @修改时间 
	 * @return
	 * @return List<Business>
	 */
	public abstract List<Business> findAll();
	
	/**
	 * @方法说明 通过name查找business表,主要用于判断是否存在同名的情况
	 * @创建者 panda
	 * @创建日期 2015年7月8日 下午1:08:05
	 * @修改者 
	 * @修改时间 
	 * @param name
	 * @return Business
	 */
	public abstract Business findByName(String name);
}
