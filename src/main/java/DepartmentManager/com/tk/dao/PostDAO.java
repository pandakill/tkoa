package com.tk.dao;

import java.util.List;

import com.tk.dao.hbm.Post;


/**
 * @类说明 Post的接口类
 * @创建者 panda
 * @创建时间 2015年7月5日
 * @修改者 
 * @修改时间 
 */
public interface PostDAO {
	
	/**
	 * @方法说明 插入单条数据到post表中
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午1:06:31
	 * @修改者 
	 * @修改时间 
	 * @param post
	 * @return void
	 */
	public abstract void save(Post post);
	
	/**
	 * @方法说明 更新post表中指定的单条数据
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午1:06:51
	 * @修改者 
	 * @修改时间 
	 * @param post
	 * @return void
	 */
	public abstract void update(Post post);
	
	/**
	 * @方法说明 删除post表中指定的单条数据
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午1:07:11
	 * @修改者 
	 * @修改时间 
	 * @param post
	 * @return void
	 */
	public abstract void delete(Post post);
	
	/**
	 * @方法说明 根据id查找指定的单条数据
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午1:07:24
	 * @修改者 
	 * @修改时间 
	 * @param id
	 * @return Post
	 */
	public abstract Post findByID(int id);
	
	/**
	 * @方法说明 查找post表中的所有数据
	 * @创建者 panda
	 * @创建日期 2015年7月5日 下午1:17:43
	 * @修改者 
	 * @修改时间 
	 * @return
	 * @return List<Post>
	 */
	public abstract List<Post> findAll();
}
