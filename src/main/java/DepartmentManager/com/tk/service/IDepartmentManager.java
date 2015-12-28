package com.tk.service;

import java.util.List;

import com.tk.dao.DepartmentDAO;
import com.tk.dao.hbm.Business;
import com.tk.dao.hbm.Department;
import com.tk.dao.hbm.Post;

/**
 * @类说明 DepartmentManager接口
 * @创建者 panda
 * @创建时间 2015年7月7日
 * @修改者 
 * @修改时间 
 */
public interface IDepartmentManager {
	
	/**
	 * @方法说明 设置departmentDAO
	 * @创建者 panda
	 * @创建日期 2015年7月7日 下午4:34:43
	 * @修改者 
	 * @修改时间 
	 * @param departmentDAO
	 * @return void
	 */
	public abstract void setdepartmentDAO(DepartmentDAO departmentDAO);
	
	/**
	 * @方法说明 获取departmentDAO
	 * @创建者 panda
	 * @创建日期 2015年7月7日 下午4:35:16
	 * @修改者 
	 * @修改时间 
	 * @return
	 * @return DepartmentDAO
	 */
	public abstract DepartmentDAO getdepartmentDAO();
	
	/**
	 * @方法说明 添加业务方向,添加业务时,同时会添加岗位,且业务和岗位不能重名
	 * @创建者 panda
	 * @创建日期 2015年7月7日 下午4:35:43
	 * @修改者 padna -- 修改返回类型,将boolean值修改
	 * @修改时间 2015-7-8 15:13
	 * @return 返回ajax字段：
	 * 				     <br/>HAVED_OTHER_BUSINESS--存在同名部门;
	 * 				     <br/>FALSE--其他错误;
	 * 				     <br/>SUCCESS--删除成功
	 */
	public abstract String addBusiness(Business business);
	
	/**
	 * @方法说明 查找所有business业务类型,返回list
	 * @创建者 panda
	 * @创建日期 2015年7月7日 下午5:58:30
	 * @修改者 
	 * @修改时间 
	 * @return List<Business>
	 */
	public abstract List<Business> getBusinesses();
	
	/**
	 * @方法说明 查找所有department部门,返回list
	 * @创建者 panda
	 * @创建日期 2015年7月7日 下午6:20:13
	 * @修改者 
	 * @修改时间 
	 * @return List<Department>
	 */
	public abstract List<Department> getDepartments();
	
	/**
	 * @方法说明 查找所有的post岗位,返回list
	 * @创建者 panda
	 * @创建日期 2015年7月7日 下午6:21:13
	 * @修改者 
	 * @修改时间 
	 * @return List<Post>
	 */
	public abstract List<Post> getPosts();
	
	public abstract boolean addDepartment(String name, int businessID);
	
	public abstract boolean addDepartment2(Department department);
		
	/**
	 * @方法说明 通过id查找business表中的单个业务
	 * @创建者 panda
	 * @创建日期 2015年7月8日 上午9:40:06
	 * @修改者 
	 * @修改时间 
	 * @param id
	 * @return Business
	 */
	public abstract Business getBusinessByID(int id);
	
	/**
	 * @方法说明 通过id查找department表中的单个部门信息
	 * @创建者 panda
	 * @创建日期 2015年7月8日 上午9:40:37
	 * @修改者 
	 * @修改时间 
	 * @param id
	 * @return Department
	 */
	public abstract Department getDepartmentByID(String id);
	
	/**
	 * @方法说明 更新单条业务的内容,返回boolean值
	 * @创建者 panda
	 * @创建日期 2015年7月8日 下午1:44:05
	 * @修改者 
	 * @修改时间 
	 * @param business
	 * @return boolean
	 */
	public abstract String updateBusiness(Business business);
	
	/**
	 * @方法说明 删除业务,删除业务之前,要先将部门和岗位的关联业务取消,再进行删除
	 * @创建者 panda
	 * @创建日期 2015年7月8日 下午1:48:34
	 * @修改者 
	 * @修改时间 
	 * @param business
	 * @return String
	 */
	public abstract String deleteBusiness(Business business);
	
	/**
	 * @方法说明 通过name查找部门信息
	 * @创建者 panda
	 * @创建日期 2015年7月8日 下午2:51:08
	 * @修改者 
	 * @修改时间 
	 * @param name
	 * @return Department
	 */
	public abstract Department getDepartmentByName(String name);
	
	/**
	 * @方法说明 添加部门,不允许重名,且业务必须存在
	 * @创建者 panda
	 * @创建日期 2015年7月8日 下午3:16:01
	 * @修改者 
	 * @修改时间 
	 * @param department businessID
	 * @return String:
	 * 			<br/>SUCCESS -- 添加成功;
	 * 			<br/>HAVED_OTHER_DEPARMENT -- 存在重名;
	 * 			<br/>BUSINESS_NOT_FOUND -- 负责的业务不存在;
	 * 			<br/>FALSE -- 其他错误;
	 * 			<br/>OVERFLOW -- id溢出,部门数量超过999人;
	 */
	public abstract String addDepartment(Department department, int businessID);
	
	/**
	 * @方法说明 修改部门信息,不允许重名,且业务必须存在
	 * @创建者 panda
	 * @创建日期 2015年7月8日 下午4:48:08
	 * @修改者 
	 * @修改时间 
	 * @param department
	 * @return String:
	 * 			<br/>SUCCESS -- 添加成功;
	 * 			<br/>HAVED_OTHER_DEPARMENT -- 存在重名;
	 * 			<br/>BUSINESS_NOT_FOUND -- 负责的业务不存在;
	 * 			<br/>FALSE -- 其他错误;
	 */
	public abstract String updateDepartment(Department department);
	
	/**
	 * @方法说明 删除部门操作,删除部门时,要确保部门没有员工关联,否则删除失败
	 * @创建者 panda
	 * @创建日期 2015年7月8日 下午7:18:14
	 * @修改者 
	 * @修改时间 
	 * @param department
	 * @return String:
	 * 			<br/>SUCCESS -- 删除成功;
	 * 			<br/>HAVE_EMPLOYEES -- 该部门与员工存在关联;
	 * 			<br/>HAVE_EXPATRIATELABORS -- 该部门与日程任务存在关联;
	 * 			<br/>FALSE -- 其他错误;
	 * 			<br/>NOT_FOUND -- 没有找到该部门;
	 */
	public abstract String deleteDepartment(Department department);
	
	/**
	 * @方法说明 添加岗位,同个业务范围的岗位不允许重名
	 * @创建者 panda
	 * @创建日期 2015年7月8日 下午11:08:45
	 * @修改者 
	 * @修改时间 
	 * @param post
	 * @param businessID
	 * @return String:
	 * 			<br/>SUCCESS -- 添加成功;
	 * 			<br/>BUSINESS_HAVED -- 关联的业务存在同名的岗位;
	 * 			<br/>BUSINESS_NOT_FOUND -- 找不到关联的业务;
	 * 			<br/>FALSE -- 其他错误;
	 */
	public abstract String addPost(Post post, int businessID);
	
	/**
	 * @方法说明 修改岗位信息
	 * @创建者 panda
	 * @创建日期 2015年7月8日 下午11:29:58
	 * @修改者 
	 * @修改时间 
	 * @param post
	 * @return
	 * @return String:
	 * 			<br/>SUCCESS -- 修改成功;
	 * 			<br/>BUSINESS_HAVED -- 关联的业务存在同名的岗位;
	 * 			<br/>BUSINESS_NOT_FOUND -- 找不到关联的业务;
	 * 			<br/>FALSE -- 其他错误;
	 */
	public abstract String updatePost(Post post);
	
	/**
	 * @方法说明 删除岗位信息
	 * @创建者 panda
	 * @创建日期 2015年7月8日 下午11:30:08
	 * @修改者 
	 * @修改时间 
	 * @param post
	 * @return String:
	 * 			<br/>SUCCESS -- 删除成功;
	 * 			<br/>FALSE -- 删除失败,其他错误;
	 */
	public abstract String deletePost(Post post);
	
	/**
	 * @方法说明 通过id查找post
	 * @创建者 panda
	 * @创建日期 2015年7月8日 下午11:50:20
	 * @修改者 
	 * @修改时间 
	 * @param id
	 * @return Post
	 */
	public abstract Post getPostByID(int id);
	
	/**
	 * @方法说明 通过businessID查找业务对应的岗位列表
	 * @创建者 panda
	 * @创建日期 2015年7月10日 上午3:09:24
	 * @修改者 
	 * @修改时间 
	 * @param businessID
	 * @return List<Post>
	 */
	public abstract List<Post> getPostsByBusinessID(int businessID);

}
