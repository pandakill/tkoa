package com.tk.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.tk.dao.hbm.Business;
import com.tk.dao.hbm.Department;
import com.tk.dao.hbm.Post;
import com.tk.dao.hbm.Users;
import com.tk.service.IDepartmentManager;
import com.tk.service.IUsersManager;
import com.tk.util.SomeTool;

public class DepartmentAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private static IDepartmentManager iDepartmentManager;
	private static IUsersManager iUsersManager;
	
	private String smallTitle = "--部门管理";
	private String superAdmin = "ROLE_SUPER";  //超级管理员
	private String admin = "ROLE_ADMIN";  //普通管理员（经理）
	private String ordinary = "ROLE_EMPLOYEE";  //普通员工
	private String pageString;  //要跳转的页面
	private String activeSidebar;  //要设置为active的判断表示符号
	private String jsonString; //从service传回的数据封装成jsonString
	
	private String postID;
	private String postName;
	private String businessID;
	private String businessName;
	private String departmentID;
	private String departmentName;
	
	public void setPostID(String postID) {
		this.postID = postID;
	}
	
	public String getPostID() {
		return postID;
	}
	
	public void setPostName(String postName) {
		this.postName = postName;
	}
	
	public String getPostName() {
		return postName;
	}
	
	public void setBusinessID(String businessID) {
		this.businessID = businessID;
	}
	
	public String getBusinessID() {
		return businessID;
	}
	
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	
	public String getBusinessName() {
		return businessName;
	}
	
	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}
	
	public String getDepartmentID() {
		return departmentID;
	}
	
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	public String getDepartmentName() {
		return departmentName;
	}
			
	public static void setIDepartmentManager(IDepartmentManager iDepartmentManager) {
		DepartmentAction.iDepartmentManager = iDepartmentManager;
		System.out.println("DepartmentAction -> setiDepartmentManager" + DepartmentAction.iDepartmentManager);
	}
	
	public static IDepartmentManager getIDepartmentManager() {
		return iDepartmentManager;
	}
	
	public static void setiUsersManager(IUsersManager iUsersManager) {
		DepartmentAction.iUsersManager = iUsersManager;
	}
	
	public static IUsersManager getiUsersManager() {
		return iUsersManager;
	}
	
	/**
	 * @方法说明 打开部门管理页面,将获得的数据封装成jsonString提供Android使用
	 * @创建者 panda
	 * @创建日期 2015年7月7日 下午8:46:29
	 * @修改者 
	 * @修改时间 
	 * @return String:返回打开的页面result
	 */
	public String departmentManage(){
		HttpServletRequest request = ServletActionContext.getRequest();
		//如果不是超级管理员,拒绝访问
		if( iUsersManager.isAuthorities(request, superAdmin) ){
			activeSidebar = "dm";
			List<Department> list = iDepartmentManager.getDepartments();
			List<Business> listBusiness = iDepartmentManager.getBusinesses();
			request.setAttribute("listDepartment", list);
			request.setAttribute("listBusiness", listBusiness);
			request.setAttribute("smallTitle", smallTitle);
			request.setAttribute("activeSidebar", activeSidebar);
			pageString = "departmentManage";
		}else{
			//权限不足
			pageString = "insufficientAuthority";
		}
		
		return pageString;
	}
	
	/**
	 * @方法说明 打开业务管理页面,将获得的数据封装成jsonString提供Android使用
	 * @创建者 panda
	 * @创建日期 2015年7月7日 下午8:55:50
	 * @修改者 
	 * @修改时间 
	 * @return String:返回的页面result
	 */
	public String businessManage(){
		pageString = "businessManage";
		activeSidebar = "bm";
		List<Business> list = iDepartmentManager.getBusinesses();
		jsonString = JSON.toJSONString(list);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("jsonString", jsonString);
		request.setAttribute("listBusiness", list);
		request.setAttribute("smallTitle", smallTitle);
		request.setAttribute("activeSidebar", activeSidebar);
		
		return pageString;
	}
	
	/**
	 * @方法说明 打开岗位管理页面,将获得的数据封装成jsonString提供Android使用
	 * @创建者 panda
	 * @创建日期 2015年7月7日 下午8:56:31
	 * @修改者 
	 * @修改时间 
	 * @return String:返回的页面result
	 */
	public String postManage(){
		pageString = "postManage";
		activeSidebar = "pm";
		List<Post> list = iDepartmentManager.getPosts();
		List<Business> listBusiness = iDepartmentManager.getBusinesses();
		jsonString = JSON.toJSONString(list);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("jsonString", jsonString);
		request.setAttribute("listPost", list);
		request.setAttribute("listBusiness", listBusiness);
		request.setAttribute("smallTitle", smallTitle);
		request.setAttribute("activeSidebar", activeSidebar);
		
		return pageString;
	}
	
	/**
	 * @方法说明 通过ajax添加业务,添加结果返回boolean类型到ajax
	 * @创建者 panda
	 * @创建日期 2015年7月8日 下午12:58:39
	 * @修改者 
	 * @修改时间 
=	 * @return 返回ajax boolean值
	 */
	public void addBusiness(){
		Business business = new Business(businessName);
		String status = iDepartmentManager.addBusiness(business);
		SomeTool.out_print(String.valueOf(status));
	}
	
	/**
	 * @方法说明 通过ajax提交,修改业务信息
	 * @创建者 panda
	 * @创建日期 2015年7月8日 下午12:54:23
	 * @修改者 
	 * @修改时间 
	 * @return 返回ajax boolean值
	 */
	public void updateBusiness(){
		int id = Integer.parseInt(businessID);
		Business business = iDepartmentManager.getBusinessByID(id);
		business.setName(businessName);
		String status = iDepartmentManager.updateBusiness(business);
		SomeTool.out_print(String.valueOf(status));
	}
	
	/**
	 * @方法说明  删除业务操作,删除的业务不能有其他部门或者岗位相关联,否则不给予删除
	 * @创建者 panda
	 * @创建日期 2015年7月8日 下午2:42:04
	 * @修改者 
	 * @修改时间 
	 * @return 返回ajax字段：
	 * 				     <br/>NOT_FOUND--不存在该业务;
	 * 				     <br/>HAVE_DEPARTMENTS--与其他部门绑定;
	 * 				     <br/>HAVE_POSTS--与其他岗位绑定;
	 * 				     <br/>SUCCESS--删除成功
	 */
	public void deleteBusiness(){
		String status;
		int id = Integer.parseInt(businessID);
		Business business = iDepartmentManager.getBusinessByID(id);
		if( null == business ){
			status = "NOT_FOUND";
		}else{
			status = iDepartmentManager.deleteBusiness(business);
		}
		SomeTool.out_print(status);
	}

	/**
	 * @方法说明 通过ajax添加部门操作
	 * @创建者 panda
	 * @创建日期 2015年7月8日 下午2:48:52
	 * @修改者 
	 * @修改时间 
	 * @return String:
	 * 			<br/>SUCCESS -- 添加成功;
	 * 			<br/>HAVED_OTHER_DEPARMENT -- 存在重名;
	 * 			<br/>FALSE -- 其他错误;
	 * 			<br/>OVERFLOW -- id溢出,部门数量超过999;
	 */
	public void addDepartment(){
		Department department = new Department(departmentName);
		int businessID = Integer.parseInt(this.businessID);
		String status = iDepartmentManager.addDepartment(department, businessID);
		SomeTool.out_print(String.valueOf(status));
	}
	
	/**
	 * @方法说明 修改部门操作,通过ajax返回String结果
	 * @创建者 panda
	 * @创建日期 2015年7月8日 下午7:49:24
	 * @修改者 
	 * @修改时间 
	 * @return String:
	 * 			<br/>SUCCESS -- 添加成功;
	 * 			<br/>HAVED_OTHER_DEPARMENT -- 存在重名;
	 * 			<br/>BUSINESS_NOT_FOUND -- 负责的业务不存在;
	 * 			<br/>FALSE -- 其他错误;
	 */
	public void updateDepartment(){
		int businessID = Integer.parseInt(this.businessID);
		Department department = iDepartmentManager.getDepartmentByID(departmentID);
		department.setName(departmentName);
		department.setBusiness(iDepartmentManager.getBusinessByID(businessID));
		String status = iDepartmentManager.updateDepartment(department);
		SomeTool.out_print(String.valueOf(status));
	}
	
	/**
	 * @方法说明 删除部门操作,ajax返回String结果
	 * @创建者 panda
	 * @创建日期 2015年7月8日 下午8:00:42
	 * @修改者 
	 * @修改时间 
	 * @return String:
	 * 			<br/>SUCCESS -- 删除成功;
	 * 			<br/>HAVE_EMPLOYEES -- 该部门与员工存在关联;
	 * 			<br/>HAVE_EXPATRIATELABORS -- 该部门与日程任务存在关联;
	 * 			<br/>FALSE -- 其他错误;
	 * 			<br/>NOT_FOUND -- 没有找到该部门;
	 */
	public void deleteDepartment(){
		Department department = iDepartmentManager.getDepartmentByID(departmentID);
		System.out.println("DepartmentAction -> deleteDepartment departmentID="+departmentID);
		String status = iDepartmentManager.deleteDepartment(department);
		SomeTool.out_print(status);
	}
	
	/**
	 * @方法说明 ajax请求添加岗位信息,返回Strin结果
	 * @创建者 panda
	 * @创建日期 2015年7月8日 下午11:34:57
	 * @修改者 
	 * @修改时间 
	 * @return String:
	 * 			<br/>SUCCESS -- 添加成功;
	 * 			<br/>BUSINESS_HAVED -- 关联的业务存在同名的岗位;
	 * 			<br/>BUSINESS_NOT_FOUND -- 找不到关联的业务;
	 * 			<br/>FALSE -- 其他错误;
	 */
	public void addPost(){
		Post post = new Post(postName);
		int id = Integer.parseInt(businessID);
		String status = iDepartmentManager.addPost(post, id);
		SomeTool.out_print(String.valueOf(status));
	}
	
	/**
	 * @方法说明 ajax请求修改岗位信息,返回String结果
	 * @创建者 panda
	 * @创建日期 2015年7月8日 下午11:36:12
	 * @修改者 
	 * @修改时间 
	 * @return :
	 * 			<br/>SUCCESS -- 修改成功;
	 * 			<br/>BUSINESS_HAVED -- 关联的业务存在同名的岗位;
	 * 			<br/>BUSINESS_NOT_FOUND -- 找不到关联的业务;
	 * 			<br/>FALSE -- 其他错误;
	 */
	public void updatePost(){
		int pid = Integer.parseInt(postID);
		Post post = iDepartmentManager.getPostByID(pid);
		String status = iDepartmentManager.updatePost(post);
		SomeTool.out_print(String.valueOf(status));
	}
	
	/**
	 * @方法说明 删除岗位信息,返回String结果
	 * @创建者 panda
	 * @创建日期 2015年7月8日 下午11:54:20
	 * @修改者 
	 * @修改时间 
	 * @return String:
	 * 			<br/>SUCCESS -- 删除成功;
	 * 			<br/>FALSE -- 删除失败,其他错误;
	 */
	public void deletePost(){
		int pid = Integer.parseInt(postID);
		Post post = iDepartmentManager.getPostByID(pid);
		String status = iDepartmentManager.deletePost(post);
		SomeTool.out_print(String.valueOf(status));
	}
}
