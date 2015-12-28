package com.tk.service.impl;

import java.util.List;
import java.util.Set;

import com.tk.dao.BusinessDAO;
import com.tk.dao.DepartmentDAO;
import com.tk.dao.PostDAO;
import com.tk.dao.hbm.Business;
import com.tk.dao.hbm.Department;
import com.tk.dao.hbm.Employee;
import com.tk.dao.hbm.ExpatriateLabor;
import com.tk.dao.hbm.Post;
import com.tk.dao.impl.BusinessImpl;
import com.tk.service.IDepartmentManager;

public class DepartmentManager implements IDepartmentManager {

	private DepartmentDAO departmentDAO;
	private BusinessDAO businessDAO;
	private PostDAO postDAO;
	
	@Override
	public void setdepartmentDAO(DepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
		System.out.println("DepartmentManager -> setdepartmentManager:" + this.departmentDAO);
	}

	@Override
	public DepartmentDAO getdepartmentDAO() {
		return this.departmentDAO;
	}
	
	public void setBusinessDAO(BusinessDAO businessDAO) {
		this.businessDAO = businessDAO;
		System.out.println("DepartmentManager -> setBusinessDAO:" + this.businessDAO);
	}
	
	public BusinessDAO getBusinessDAO() {
		return businessDAO;
	}
	
	public void setPostDAO(PostDAO postDAO) {
		this.postDAO = postDAO;
		System.out.println("DepartmentManager -> setPostDAO:" + this.postDAO);
	}
	
	public DepartmentDAO getDepartmentDAO() {
		return departmentDAO;
	}

	@Override
	public String addBusiness(Business business) {
		String flag = "FALSE";
		Business b = businessDAO.findByName(business.getName());
		if( null == b ){
			businessDAO.save(business);
			flag = "SUCCESS";
		}else if( null != b ){
			flag = "HAVED_OTHER_BUSINESS";
		}
		return flag;
	}

	@Override
	public List<Business> getBusinesses() {
		List<Business> list = businessDAO.findAll();
		return list;
	}

	@Override
	public List<Department> getDepartments() {
		List<Department> list = departmentDAO.findAll();
		return list;
	}

	@Override
	public List<Post> getPosts() {
		List<Post> list = postDAO.findAll();
		return list;
	}

	@Override
	public boolean addDepartment(String name, int businessID) {
		
		boolean flag = false;
		Business business = businessDAO.findByID(businessID);
		List<Department> list = departmentDAO.findAll();
		int count = list.size();
		String id = null;
		if( -1 < count && count < 10 ){
			id = "00"+(count+1);
		}else if( 9 < count && count < 100){
			id = "0"+(count+1);
		}else if( 99 < count && count < 1000 ){
			id = ""+(count+1);
		}
		Department department = new Department();
		if( business != null && null == departmentDAO.findByDepartmentName(name) ){
			department.setId(id);
			department.setBusiness(business);
			department.setHeadcount(0);
			department.setHighgradeHeadcount(0);
			departmentDAO.save(department);
			flag = true;
		}
		return flag;
	}
	
	@Override
	public boolean addDepartment2(Department department) {
		
		boolean flag = false;
		List<Department> list = departmentDAO.findAll();
		int count = list.size();
		String id = null;
		if( -1 < count && count < 10 ){
			id = "00"+(count+1);
		}else if( 9 < count && count < 100){
			id = "0"+(count+1);
		}else if( 99 < count && count < 1000 ){
			id = ""+(count+1);
		}
		if( department.getBusiness() != null && null == departmentDAO.findByDepartmentName(department.getName()) ){
			department.setId(id);
			department.setHeadcount(0);
			department.setHighgradeHeadcount(0);
			department.setEmployees(null);
			department.setExpatriateLabors(null);
			departmentDAO.save(department);
			flag = true;
		}
		return flag;
	}

	@Override
	public Business getBusinessByID(int id) {
		Business business = businessDAO.findByID(id);
		return business;
	}

	@Override
	public Department getDepartmentByID(String id) {
		Department department = departmentDAO.findByID(id);
		return department;
	}

	@Override
	public String updateBusiness(Business business) {
		
		String flag = "SUCCESS";
		List<Business> list = businessDAO.findAll();
		//判断修改的业务名称是否在数据库中存在,若存在,则flag==HAVED_OTHER_BUSINESS,不能修改
		for (int i = 0; i < list.size(); i++) {
			if( (list.get(i)).getName().equals(business.getName()) && (list.get(i).getId() != business.getId()) ){
				flag = "HAVED_OTHER_BUSINESS";
				break;
			}
		}
		if( "SUCCESS".equals(flag) ){
			businessDAO.update(business);
		}else{
			flag = "FALSE";
		}
		
		return flag;
	}

	@Override
	public String deleteBusiness(Business business) {
		
		String flag = "ELSE_ERROR";
		//删除之前判断该业务是否含有其他部门和岗位
		Business b = businessDAO.findByID(business.getId());
		Set<Department> listDepartments = b.getDepartments();
		Set<Post> listPosts = b.getPosts();
		if( null != b ){
			if( listDepartments.size() != 0){
				flag = "HAVE_DEPARTMENTS";
			}else if( listPosts.size() != 0 ){
				flag = "HAVE_POSTS";
			}else{
				businessDAO.delete(business);
				flag = "SUCCESS";
			}
		} else if( null == b){
			flag = "NOT_FOUND";
		}
		return flag;
	}

	@Override
	public Department getDepartmentByName(String name) {
		Department department = departmentDAO.findByDepartmentName(name);
		return department;
	}

	@Override
	public String addDepartment(Department department, int businessID) {
		String flag = "FALSE";
		Department de = departmentDAO.findByDepartmentName(department.getName());
		if( null != de ){
			flag = "HAVED_OTHER_DEPARTMENT";
		}else if( null == de ){
			//id为三位数,不足三位数则在前面补0
			String id = "";
			List<Department> listDepartments = departmentDAO.findAll();
			int count = listDepartments.size();
			if( -1 < count && count < 9 ){
				id = "00"+ (count+1);
			}else if( 8 < count && count < 99 ){
				id = "0"+(count+1);
			}else if( 98 < count && count < 999 ){
				id = String.valueOf(count+1);
			}else{
				flag = "OVERFLOW";
			}
			
			//判断是否存在业务,若该业务不存在,则部门不允许添加
			Business business = businessDAO.findByID(businessID);
			if( null == business ){
				flag = "BUSINESS_NOT_FOUND";
			}
			
			if( ! "OVERFLOW".equals(flag) && ! "BUSINESS_NOT_FOUND".equals(flag)){
				department.setId(id);
				department.setHeadcount(0);
				department.setHighgradeHeadcount(0);
				department.setBusiness(business);
				departmentDAO.save(department);
				flag = "SUCCESS";
			}
		}
		return flag;
	}

	@Override
	public String updateDepartment(Department department) {
		String flag = "FALSE";
		Department de = departmentDAO.findByDepartmentName(department.getName());
		Business business = businessDAO.findByID( department.getBusiness().getId() );
		if( null != de && ! department.getId().equals(de.getId()) ){
			flag = "HAVED_OTHER_DEPARTMENT";
		}
		if( null == business ){
			flag = "BUSINESS_NOT_FOUND";
		}
		
		if( "FALSE".equals(flag) ){
			departmentDAO.update(department);
			flag = "SUCCESS";
		}
		return flag;
	}

	@Override
	public String deleteDepartment(Department department) {
		String flag = "FALSE";
		Department d = departmentDAO.findByID(department.getId());
		Set<Employee> listEmployees = d.getEmployees();
		Set<ExpatriateLabor> listExpatriateLabors = d.getExpatriateLabors();
		if( null != d ){
			if( listEmployees.size() != 0){
				flag = "HAVE_EMPLOYEES";
			}else if( listExpatriateLabors.size() != 0 ){
				flag = "HAVE_EXPATRIATELABORS";
			}else{
				departmentDAO.delete(department);
				flag = "SUCCESS";
			}
		} else if( null == d){
			flag = "NOT_FOUND";
		}
		return flag;
	}

	@Override
	public String addPost(Post post, int businessID) {
		String flag = "FALSE";
		//判断业务是否存在
		Business business = businessDAO.findByID(businessID);
		if( null != business ){
			//判断同个业务范围是否存在同名的岗位,存在相同则不允许添加新的岗位
			Set<Post> listPosts = business.getPosts();
			if( listPosts.contains(post.getPostName()) ){
				flag = "BUSINESS_HAVED";
			}else{
				post.setBusiness(business);
				postDAO.save(post);;
				flag = "SUCCESS";
			}
		}else{
			flag = "BUSINESS_NOT_FOUND";
		}
		return flag;
	}

	@Override
	public String updatePost(Post post) {
		String flag = "FALSE";
		//判断业务是否存在
		Business business = businessDAO.findByID(post.getBusiness().getId());
		if( null != business ){
			//判断同个业务范围是否存在同名的岗位,存在相同则不允许添加新的岗位
			Set<Post> listPosts = business.getPosts();
			if( listPosts.contains(post.getPostName()) ){
				flag = "BUSINESS_HAVED";
			}else{
				postDAO.update(post);;
				flag = "SUCCESS";
			}
		}else{
			flag = "BUSINESS_NOT_FOUND";
		}
		return flag;
	}

	@Override
	public String deletePost(Post post) {
		String flag = "FALSE";
		Post p = postDAO.findByID(post.getId());
		if( null != p ){
			postDAO.delete(p);
			flag = "SUCCESS";
		}
		return flag;
	}

	@Override
	public Post getPostByID(int id) {
		Post post = postDAO.findByID(id);
		return post;
	}

	@Override
	public List<Post> getPostsByBusinessID(int businessID) {
		List<Post> listPosts = postDAO.findAll();
		for (int i = 0; i < listPosts.size(); i++) {
			if( listPosts.get(i).getBusiness().getId() != businessID ){
				listPosts.remove(i--);
			}
		}
		return listPosts;
	}

}
