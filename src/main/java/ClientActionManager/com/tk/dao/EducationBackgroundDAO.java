package com.tk.dao;

import java.util.List;

import com.tk.dao.hbm.EducationBackground;

/**
 * @类说明 EducationBackground接口类
 * @创建者 panda
 * @创建日期 2015年7月9日 上午2:18:34
 * @修改者 
 * @修改时间 
 */
public interface EducationBackgroundDAO {
	
	public abstract EducationBackground findEducationBackgroundByID(int id);
	
	/**
	 * @方法说明  查找EducationBackground表中的所有数据
	 * @创建者 panda
	 * @创建日期 2015年7月9日 上午2:19:44
	 * @修改者 
	 * @修改时间 
	 * @return
	 * @return List<EducationBackground>
	 */
	public abstract List<EducationBackground> findAll();
}
