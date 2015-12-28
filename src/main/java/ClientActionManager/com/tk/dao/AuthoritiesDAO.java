package com.tk.dao;

import java.util.List;

import com.tk.dao.hbm.Authorities;

/**
 * @类说明 Authorities的接口类
 * @创建者 panda
 * @创建时间 2015年7月5日
 * @修改者 
 * @修改时间 
 */
public interface AuthoritiesDAO {
	
	/**
	 * @方法说明 插入单条数据到authoriries表中
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午12:43:02
	 * @修改者 
	 * @修改时间 
	 * @param authorities
	 * @return void
	 */
	public abstract void save(Authorities authorities);
	
	/**
	 * @方法说明 更新authorities中指定的某条数据
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午12:43:28
	 * @修改者 
	 * @修改时间 
	 * @param authorities
	 * @return void
	 */
	public abstract void update(Authorities authorities);
	
	/**
	 * @方法说明 删除authorities表中指定的某条数据
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午12:43:53
	 * @修改者 
	 * @修改时间 
	 * @param authorities
	 * @return void
	 */
	public abstract void delete(Authorities authorities);
	
	/**
	 * @方法说明 根据usersname查找指定的单条数据
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午12:44:15
	 * @修改者 
	 * @修改时间 
	 * @param username
	 * @return Authorities
	 */
	public abstract Authorities findByUsername(String username);
	
	/**
	 * @方法说明 查找authorities表中的所有数据
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午12:44:54
	 * @修改者 
	 * @修改时间 
	 * @return
	 * @return List<Authorities>
	 */
	public abstract List<Authorities> findAll();
}
