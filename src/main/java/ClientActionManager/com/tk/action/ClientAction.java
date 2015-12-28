package com.tk.action;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionSupport;
import com.tk.dao.hbm.Authorities;
import com.tk.dao.hbm.Business;
import com.tk.dao.hbm.ClockingIn;
import com.tk.dao.hbm.Department;
import com.tk.dao.hbm.EducationBackground;
import com.tk.dao.hbm.Employee;
import com.tk.dao.hbm.Post;
import com.tk.dao.hbm.Salary;
import com.tk.dao.hbm.Users;
import com.tk.service.IAuthoritiesManager;
import com.tk.service.IClockingInManager;
import com.tk.service.IDepartmentManager;
import com.tk.service.IEducationBackgroundManager;
import com.tk.service.IEmployeeManager;
import com.tk.service.ISalaryManager;
import com.tk.service.IUsersManager;
import com.tk.util.MD5;
import com.tk.util.SomeTool;
import com.tk.util.SystemTime;

@Scope("prototype")
public class ClientAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	private static final String INDEX = "--首页"; 
	private static final String USER_MANAGE = "--用户管理"; 
	private static final String INDEX_ACTIVE_SIDEBAR_FLAG = "c";
	private static final String USER_MANAGE_ACTIVE_SIDEBAR_FLAG = "um";
	private static final String SUPER_AUTHORITIES = "ROLE_SUPER";
	private static final String ADMIN_AUTHORITIES = "ROLE_ADMIN";
	private static final String COMMON_AUTHORITIES = "ROLE_EMPLOYEE";
	private static final int NEW_CLOCKING_IN_ATTEND_TYPE = 0;
	private static final int COMMON_ATTEND_TYPE = 1;
	private static final int LATE_ATTEND_TYPE = 2;
	private static final int EARLY_ATTEND_TYPE = 3;
	private static final int OUTSIDE_ATTEND_TYPE = 4;
	private static final int ABSENTEEISM_ATTEND_TYPE = 5;
	private static final int LEAVE_ATTEND_TYPE = 6;
	private static IClockingInManager iClockingInManager;
	private static IUsersManager iUsersManager;
	private static IEmployeeManager iEmployeeManager;
	private static IDepartmentManager iDepartmentManager;
	private static IEducationBackgroundManager iEducationBackgroundManager;
	private static IAuthoritiesManager iAuthoritiesManager;
	private static ISalaryManager iSalaryManager;
	private String pageString;	//返回的页面
	private String smallTitle;	//保存窗口子标题
	private String activeSidebar;  //要设置为active的判断表示符号
	private String jsonString; //存储json
	
	private String employeeID;
	private String businessID;
	private String departmentID;
	private String name; //姓名
	private String tel; //手机号码
	private String postID;
	private String duty;
	private String hiredate;
	private String sex; //性别
	private String extension; //用户分机
	private String nativePlace; //籍贯
	private String salary;
	private String birthday;
	private String educationBackgroundID; //学历
	private String major; //专业
	private String seniority;
	private String athorities;
	private String password;

	public String getSmallTitle() {
		return smallTitle;
	}

	public void setSmallTitle(String smallTitle) {
		this.smallTitle = smallTitle;
	}
	
	public String getJsonString() {
		return jsonString;
	}

	public void setJsonString(String jsonString) {
		this.jsonString = jsonString;
	}
	
	public String getActiveSidebar() {
		return activeSidebar;
	}

	public void setActiveSidebar(String activeSidebar) {
		this.activeSidebar = activeSidebar;
	}
	
	public IClockingInManager getIClockingInManager()
	{
		return iClockingInManager;
	}

	public void setIClockingInManager(IClockingInManager iClockingInManager)
	{
		ClientAction.iClockingInManager = iClockingInManager;
		System.out.println("ClientAction -> setIClockingInManager"
				+ ClientAction.iClockingInManager);
	}
	
	public IUsersManager getIUsersManager()
	{
		return iUsersManager;
	}
	
	public void setIUsersManager(IUsersManager iUsersManager)
	{
		ClientAction.iUsersManager = iUsersManager;
		System.out.println("ClientAction -> setIUsersManager"
				+ ClientAction.iUsersManager);
	}
	
	public static IEmployeeManager getiEmployeeManager() {
		return iEmployeeManager;
	}

	public static void setiEmployeeManager(IEmployeeManager iEmployeeManager) {
		ClientAction.iEmployeeManager = iEmployeeManager;
	}
	
	public static void setiDepartmentManager(
			IDepartmentManager iDepartmentManager) {
		ClientAction.iDepartmentManager = iDepartmentManager;
	}
	
	public static IDepartmentManager getiDepartmentManager() {
		return iDepartmentManager;
	}
	
	public static void setiEducationBackgroundManager(
			IEducationBackgroundManager iEducationBackgroundManager) {
		ClientAction.iEducationBackgroundManager = iEducationBackgroundManager;
	}
	
	public static IEducationBackgroundManager getiEducationBackgroundManager() {
		return iEducationBackgroundManager;
	}
	
	public static void setiAuthoritiesManager(
			IAuthoritiesManager iAuthoritiesManager) {
		ClientAction.iAuthoritiesManager = iAuthoritiesManager;
	}
	
	public static IAuthoritiesManager getiAuthoritiesManager() {
		return iAuthoritiesManager;
	}
	
	public static ISalaryManager getiSalaryManager() {
		return iSalaryManager;
	}

	public static void setiSalaryManager(ISalaryManager iSalaryManager) {
		ClientAction.iSalaryManager = iSalaryManager;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}
	
	public String getEmployeeID() {
		return employeeID;
	}
	
	public void setBusinessID(String businessID) {
		this.businessID = businessID;
	}
	
	public String getBusinessID() {
		return businessID;
	}
	
	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}
	public String getDepartmentID() {
		return departmentID;
	}
	
	public String getPageString() {
		return pageString;
	}

	public void setPageString(String pageString) {
		this.pageString = pageString;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPostID() {
		return postID;
	}

	public void setPostID(String postID) {
		this.postID = postID;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getNativePlace() {
		return nativePlace;
	}

	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}
	
	public void setSalary(String salary) {
		this.salary = salary;
	}
	
	public String getSalary() {
		return salary;
	}
	
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public String getBirthday() {
		return birthday;
	}
	
	public void setEducationBackgroundID(String educationBackgroundID) {
		this.educationBackgroundID = educationBackgroundID;
	}
	
	public String getEducationBackgroundID() {
		return educationBackgroundID;
	}
	
	public void setMajor(String major) {
		this.major = major;
	}
	
	public String getMajor() {
		return major;
	}
	
	public void setSeniority(String seniority) {
		this.seniority = seniority;
	}
	
	public String getSeniority() {
		return seniority;
	}
	
	public void setAthorities(String athorities) {
		this.athorities = athorities;
	}
	
	public String getAthorities() {
		return athorities;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}

	/**
	 * 
	 * @方法说明 重定向到login.jsp页面
	 * @创建者 湛耀
	 * @创建日期 2015年7月6日 下午7:52:49
	 * @修改者 
	 * @修改时间 
	 * @return
	 * @return String
	 */
	public String redirectLogin(){
		pageString = "login";
		return pageString;
	}
	
	/**
	 * 
	 * @方法说明 重定向到index页面
	 * @创建者 湛耀
	 * @创建日期 2015年7月6日 下午7:55:45
	 * @修改者 
	 * @修改时间 
	 * @return
	 * @return String
	 */
	public String redirectAdminIndex(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Users users = new Users();
		Employee employee = new Employee();
		List<ClockingIn> clockingIns = null;
		List<ClockingIn> allclockingIns = null;
		List<ClockingIn> departmentClockingIns = null;
		int clockingInFlag = 0;
		int clockingOutFlag = 0;
		//页面导航信息补充
		setActiveSidebar(INDEX_ACTIVE_SIDEBAR_FLAG);
		setSmallTitle(INDEX);
		request.setAttribute("jsonString", jsonString);
		request.setAttribute("smallTitle", smallTitle);
		request.setAttribute("activeSidebar", activeSidebar);
		//获取当前用户的姓名返回到页面
		users = iUsersManager.getUserByUsername(request);
		employee = users.getEmployee();
		request.setAttribute("name", users.getEmployee().getName());
		try {
			//获取登录用户当天的考勤表
			clockingInFlag = iClockingInManager.getTodayClockingInAttendTypeID(employee);
			if (clockingInFlag == NEW_CLOCKING_IN_ATTEND_TYPE) {
				//未签到
			} else if ((clockingInFlag != NEW_CLOCKING_IN_ATTEND_TYPE 
					|| clockingInFlag != OUTSIDE_ATTEND_TYPE || clockingInFlag != LEAVE_ATTEND_TYPE) ) {
				clockingOutFlag = iClockingInManager.getTodayClockingOutAttendTypeID(employee);
				request.setAttribute("clockingOutFlag", clockingOutFlag);
			} 
			request.setAttribute("clockingInFlag", clockingInFlag);
		} catch (Exception e) {
			System.out.println("ClientAction -> redirectAdminIndex" + e);
		}
		//返回个人考勤信息列表
		clockingIns = iClockingInManager.findMyselfThisMonthClockingIn(employee);
		request.setAttribute("clockingIns", clockingIns);
		//返回所有人
		allclockingIns = iClockingInManager.findTodayAllClockingIn();
		request.setAttribute("allclockingIns", allclockingIns);
		//返回本部门
		departmentClockingIns = iClockingInManager.findTodayDepartmentClockingIn(employee);
		request.setAttribute("departmentClockingIns", departmentClockingIns);
		pageString = "index";
		return pageString;
	}
	
	public String redirectUserManage() {
		List<Employee> employees = null;
		HttpServletRequest request = ServletActionContext.getRequest();
		Users users = iUsersManager.getUserByUsername(request);	//获取当前的用户
		List<EducationBackground> listEducationBackgrounds = iEducationBackgroundManager.getEducationBackgrounds();
		Department department = users.getEmployee().getDepartment();
		Business business = null;
		List<Department> listDepartments = null;
		if( !department.getId().equals("000") ){
			listDepartments = iDepartmentManager.getDepartments();
			business = listDepartments.get(0).getBusiness();
		}else{
			listDepartments.add(department);
			business = department.getBusiness();
		}
		Set<Post> listPosts = business.getPosts();
		//设置header.jsp中的属性
		setActiveSidebar(USER_MANAGE_ACTIVE_SIDEBAR_FLAG);
		setSmallTitle(USER_MANAGE);
		//获取当前用户的姓名返回到页面
		try {
			users = iUsersManager.getUserByUsername(request);
			request.setAttribute("name", users.getEmployee().getName());
		} catch (Exception e) {
			System.out.println("ClientAction -> redirectAdminIndex" + e);
		}
		request.setAttribute("smallTitle", smallTitle);
		request.setAttribute("firstBusiness", business.getName());
		request.setAttribute("listPosts", listPosts);
		request.setAttribute("activeSidebar", activeSidebar);
		request.setAttribute("listDepartment", listDepartments);
		request.setAttribute("listEducationBackground", listEducationBackgrounds);
		System.out.println("用户权限 :" + users.getAuthorities().getAuthority());
		//雇员数据
		try {
			if (iUsersManager.isAuthorities(request, SUPER_AUTHORITIES)) {
				System.out.println("1:");
				//超级管理员返回所有人员对象
				employees = iEmployeeManager.getAllEmployees();
			} else if (iUsersManager.isAuthorities(request, ADMIN_AUTHORITIES)) {
				System.out.println("2:");
				//部门经理只返回本部门人员
				String departmentID = users.getEmployee().getDepartment().getId();
				employees = iEmployeeManager.getEmployeesByDepartmentID(departmentID);
			} 
			System.out.println("employees :" + employees);
			request.setAttribute("employees", employees);
		} catch (Exception e) {
			System.out.println("ClientAction -> redirectUserManage" + e);
		}
		pageString = "userManage";	//设置返回result
		return pageString;
	}
	
	/**
	 * @方法说明 通过business的id查找对应的post,通过http返回json字段
	 * @创建者 panda
	 * @创建日期 2015年7月9日 上午10:04:27
	 * @修改者 
	 * @修改时间 
	 * @return 业务列表的json格式
	 */
	public void getPosts(){
		int id = Integer.parseInt(businessID);
		Business business = iDepartmentManager.getBusinessByID(id);
		SomeTool.out_print(JSON.toJSONString(business));
	}
	
	/**
	 * @方法说明 根据部门id获取
	 * @创建者 panda
	 * @创建日期 2015年7月9日 上午10:12:14
	 * @修改者 
	 * @修改时间 
	 * @return business的json格式
	 */
	public void getBusiness(){
		Department department = iDepartmentManager.getDepartmentByID(departmentID);
		Business business = department.getBusiness();
		List<Post> listPosts = iDepartmentManager.getPostsByBusinessID(business.getId());
		JSONArray jsonArray = new JSONArray();
		for (int i = 0; i < listPosts.size(); i++) {
			int id = listPosts.get(i).getId();
			String nameString = listPosts.get(i).getPostName();
			Post post = new Post(id,nameString);
			jsonArray.add(i, post);
		}
		JSONObject json = new JSONObject();
		json.put("result", "SUCCESS");
		json.put("businessID", business.getId());
		json.put("businessName", business.getName());
		json.put("listPosts", jsonArray);
		SomeTool.out_print(String.valueOf(json));
	}
	
	/**
	 * @方法说明 添加员工,添加员工时同时更新部门的人数以及高职称人数,添加时先添加users,再添加authority,最后添加员工
	 * @创建者 panda
	 * @创建日期 2015年7月9日 下午2:03:30
	 * @修改者 
	 * @修改时间 
	 * @return String:
	 * 			<br/>SUCCESS --添加成功;
	 * 			<br/>FALSE -- 添加失败;
	 * 			<br/>HAVED_USERS -- 同手机用户已存在;
	 */
	public void addEmployee(){
		
		String status = "FALSE";
		
		Users users = new Users();
		Authorities authorities = new Authorities();
		Employee employee = new Employee();
		
		//添加用户
		users.setUsername(tel);
		status = iUsersManager.addUsers(users);
		//根据添加用户的状态添加其他关联情况
		if( "SUCCESS".equals(status) ){
			//添加用户权限
			authorities.setUsers(users);
			authorities.setAuthority(athorities);
			status = iAuthoritiesManager.addAuthorities(authorities);
			if( "SUCCESS".equals(status) ){
				//添加员工基本信息
				//获取岗位对象
				int postID = Integer.parseInt(this.postID);
				Post post = iDepartmentManager.getPostByID(postID);
				//获取学历对象
				int ebID = Integer.parseInt(educationBackgroundID);
				EducationBackground educationBackground = iEducationBackgroundManager.getEducationBackgroundByID(ebID);
				//获取user对象
				int sen = Integer.parseInt(this.seniority);
				int salary = Integer.parseInt(this.salary);
				Department department = iDepartmentManager.getDepartmentByID(departmentID);
				if("ROLE_SUPER".equals(athorities)){
					employee.setDuty("超级管理员");
				}else if("ROLE_ADMIN".equals(athorities)){
						employee.setDuty("部门经理");
				}else if("ROLE_EMPLOYEE".equals(athorities)){
					employee.setDuty("员工");
				}
				
				//计算年资
				int[] year = SomeTool.spiltDate(hiredate, "-");
				int year_now = SystemTime.getYear();
				int month_now = SystemTime.getMonth();
				//计算年资
				int x = 0;
				x = ((year_now-year[0])*12+(month_now-year[1]))%12;
				employee.setDepartment(department);
				employee.setPost(post);
				employee.setName(name);
				employee.setBirthday(birthday);
				employee.setExtension(extension);
				employee.setSex(sex);
				employee.setNativePlace(nativePlace);
				employee.setEducationBackground(educationBackground);
				employee.setMajor(major);
				employee.setBirthday(birthday);
				employee.setHiredate(hiredate);
				employee.setSeniority(x);
				//employee.setSeniority(sen);
				employee.setSalary(salary*100);
				//将users添加到employee当中
				employee.setUsers(users);
				status = iEmployeeManager.addEmployee(employee);
				System.out.println("ClientAction -> addEmployee -> employee.duty = " + employee.getDuty());
				System.out.println("ClientAction -> addEmployee -> employee = " + String.valueOf(employee));
			}
		}
		
		//添加结果通过http返回
		SomeTool.out_print(status);
	}
	
	public void updateEmployee(){
		
		String status = "FALSE";
		
		Employee employee = iEmployeeManager.getEmployeeByID(employeeID);
		
		//更新用户权限
		employee.getUsers().getAuthorities().setAuthority(athorities);
		//设置员工职务
		if( athorities.equals(SUPER_AUTHORITIES) ){
			employee.setDuty("超级管理员");
		}else if( athorities.equals(ADMIN_AUTHORITIES) ){
			employee.setDuty("部门经理");
		}else if( athorities.equals(COMMON_AUTHORITIES) ){
			employee.setDuty("员工");
		}
		
		int postID = Integer.parseInt(this.postID);
		Post post = iDepartmentManager.getPostByID(postID);
		//获取学历对象
		int ebID = Integer.parseInt(educationBackgroundID);
		EducationBackground educationBackground = iEducationBackgroundManager.getEducationBackgroundByID(ebID);
		int sen = Integer.parseInt(this.seniority);
		int salary = Integer.parseInt(this.salary);
		
		Department department = iDepartmentManager.getDepartmentByID(departmentID);
				
		employee.setDepartment(department);
		employee.setPost(post);
		employee.setName(name);
		employee.setBirthday(birthday);
		employee.setExtension(extension);
		employee.setSex(sex);
		employee.setNativePlace(nativePlace);
		employee.setEducationBackground(educationBackground);
		employee.setMajor(major);
		employee.setBirthday(birthday);
		employee.setHiredate(hiredate);
		employee.setSeniority(sen);
		employee.setSalary(salary*100);
		
		status = iEmployeeManager.updateEmployee(employee);
		
		//添加结果通过http返回
		SomeTool.out_print(status);
	}
	
	public void deleteEmployee(){
		Employee employee = iEmployeeManager.getEmployeeByID(employeeID);
		String flag = iEmployeeManager.deleteEmployee(employee);
		SomeTool.out_print(flag);
	}
	
	public void register(){
		String status = "FALSE";
		//通过employeeID查找员工
		Employee employee = iEmployeeManager.getEmployeeByID(employeeID);
		if( null != employee ){
			if( employee.getUsers().getEnabled() == 0 ){
				if( tel.equals(employee.getUsers().getUsername()) ){
					String md5PSW = MD5.md5(password);
					short enabled = 1;
					employee.getUsers().setPassword(md5PSW);
					employee.getUsers().setEnabled(enabled);
					//status = iEmployeeManager.updateEmployee(employee);
					status = iUsersManager.updateUsers(employee.getUsers());
				}else{
					status = "TEL_NOT_THE_SAME_NAME";
				}
			}else{
				status = "ALREADY_REGISTER";
			}
			
		}else{
			status = "NOT_FOUND_EMPLOYEE";
		}
		SomeTool.out_print(status);
		
	}
	
	public String personal(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int QUEQIN = 0; //缺勤天数
		int ZAOTUI = 0; //早退天数
		int CHIDAO = 0; //迟到天数
		int QINGJIA = 0; //请假天数
		int WAIQIN = 0; //外勤天数
		Users users = iUsersManager.getUserByUsername(request);
		Employee employee = users.getEmployee();
		//获取当前系统时间年月
		int year = SystemTime.getYear();
		int month = SystemTime.getMonth();
		//获取本月工资和工作量
		Salary salary = iSalaryManager.getSalariesByYearMonth(employee.getId(), year, month);
		//获取本人的所有考勤信息
		List<ClockingIn> listClockingIns = iClockingInManager.getclockingInDAO().findByEmployeeID(employee.getId());
		ClockingIn clockingIn = new ClockingIn();
		if( listClockingIns != null ){
			Iterator<ClockingIn> iterator = listClockingIns.iterator();
			while ( iterator.hasNext() ) {
				clockingIn = iterator.next();
				if ( clockingIn.getYear() == year && clockingIn.getMonth() == month ) {
					if( clockingIn.getAttendType().equals(5) ){
						QUEQIN ++;
					}else if( clockingIn.getAttendType().equals(2) ){
						CHIDAO ++;
						if( clockingIn.getClockingOut().getAttendType().equals(3) ){
							ZAOTUI ++;
						}
					}else if( clockingIn.getAttendType().equals(6) ){
						QINGJIA ++;
					}else if( clockingIn.getAttendType().equals(4)){
						WAIQIN ++;
					}
				}
			}
		}
		//获取职务
		request.setAttribute("basic_salary", users.getEmployee().getSalary());
		request.setAttribute("duty", users.getEmployee().getDuty());
		request.setAttribute("queqin", QUEQIN);
		request.setAttribute("chidao", CHIDAO);
		request.setAttribute("zaotui", ZAOTUI);
		request.setAttribute("waiqin", WAIQIN);
		request.setAttribute("qingjia", QINGJIA);
		request.setAttribute("queqin", QUEQIN);
		//request.setAttribute("salary", salary.getTotalSalary());
		//获取基本工资
		pageString = "getPersonal";
		return pageString;
	}
	

	/**
	 * @方法说明 登录框获取名字列表
	 * @创建者 panda
	 * @创建日期 2015年7月11日 上午9:34:27
	 * @修改者 
	 * @修改时间 
	 * @return void
	 */
	public void getNames(){
		String flag = null;
		System.out.println("ClientAction -> getNames");
		List<Employee> list = iEmployeeManager.getAllEmployees();
		for (int i = 0; i < list.size(); i++) {
			if( list.get(i).getUsers().getEnabled() != 0 ){
				list.remove(i--);
			}
		}
		if( list != null ){
			JSONArray jsonArray = new JSONArray();
			for (int i = 0; i < list.size(); i++) {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("employeeID", list.get(i).getId());
				jsonObject.put("name", list.get(i).getName());
				jsonArray.add(jsonObject);
			}
			flag = jsonArray.toJSONString();
		}else{
			flag = null;
		}
		System.out.println("ClientAction -> flag = " +flag);
		SomeTool.out_print(String.valueOf(flag));
	}
	
}
