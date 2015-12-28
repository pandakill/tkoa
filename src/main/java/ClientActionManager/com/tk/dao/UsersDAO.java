package com.tk.dao;

import java.util.List;

import com.tk.dao.hbm.Users;

/**
 * @类说明 Users的接口类
 * @创建者 panda
 * @创建时间 2015年7月5日
 * @修改者 
 * @修改时间 
 */
public interface UsersDAO {
	
	/**
	 * @方法说明 插入单条数据到users表中
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午12:04:37
	 * @修改者 
	 * @修改时间 
	 * @param users
	 * @return void
	 */
	public abstract void save(Users users);
	
	/**
	 * @方法说明 更新users中指定的某条数据
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午12:05:46
	 * @修改者 
	 * @修改时间 
	 * @param users
	 * @return void
	 */
	public abstract void update(Users users);
	
	/**
	 * @方法说明 从users表中删除指定的user
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午12:06:21
	 * @修改者 
	 * @修改时间 
	 * @param users
	 * @return void
	 */
	public abstract void delete(Users users);
	
	/**
	 * @方法说明 根据username在users表中查找指定的单条数据
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午12:40:09
	 * @修改者 
	 * @修改时间 
	 * @param username
	 * @return Users
	 */
	public abstract Users findByUserName(String username);
	
	/**
	 * @方法说明 读取users表中的所有数据
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午12:40:53
	 * @修改者 
	 * @修改时间 
	 * @return List<Users>
	 */
	public abstract List<Users> findAll();
}
