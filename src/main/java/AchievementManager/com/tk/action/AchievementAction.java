package com.tk.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.ActionSupport;
import com.tk.dao.hbm.Employee;
import com.tk.dao.hbm.ExpatriateLabor;
import com.tk.dao.hbm.Users;
import com.tk.service.IAchievementManager;
import com.tk.service.IDepartmentManager;
import com.tk.service.IEmployeeManager;
import com.tk.service.IUsersManager;

@Scope("prototype")
public class AchievementAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private static final String EXPATRIATE_TITLE = "--外勤管理"; 
	private static final String EXPATRIATE_ACTIVE_SIDEBAR_FLAG = "em"; 
	private static IDepartmentManager iDepartmentManager;
	private static IEmployeeManager iEmployeeManager;
	private static IUsersManager iUsersManager;
	private static IAchievementManager iAchievementManager;
	private String pageString;	//返回的页面
	private String smallTitle;	//保存窗口子标题
	private String activeSidebar;  //要设置为active的判断表示符号
	private String jsonString; //存储json
	private boolean flag; //操作正确与否的标志
	//外勤任务信息
	private String name;	//客户名称
	private String employeeID;	//负责外勤员工ID
	private String details;	//项目详情
	private String address;	//地址
	private String longitude;	//经度
	private String latitude;	//纬度
	private String begindate;	//开始日期
	private int deadline;	//期限
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getBegindate() {
		return begindate;
	}

	public void setBegindate(String begindate) {
		this.begindate = begindate;
	}

	public int getDeadline() {
		return deadline;
	}

	public void setDeadline(int deadline) {
		this.deadline = deadline;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getPageString() {
		return pageString;
	}

	public void setPageString(String pageString) {
		this.pageString = pageString;
	}

	public String getSmallTitle() {
		return smallTitle;
	}

	public void setSmallTitle(String smallTitle) {
		this.smallTitle = smallTitle;
	}

	public String getActiveSidebar() {
		return activeSidebar;
	}

	public void setActiveSidebar(String activeSidebar) {
		this.activeSidebar = activeSidebar;
	}

	public String getJsonString() {
		return jsonString;
	}

	public void setJsonString(String jsonString) {
		this.jsonString = jsonString;
	}

	public IDepartmentManager getiDepartmentManager() {
		return iDepartmentManager;
	}

	public void setiDepartmentManager(IDepartmentManager iDepartmentManager) {
		AchievementAction.iDepartmentManager = iDepartmentManager;
		System.out.println("AchievementAction -> setiDepartmentManager"
				+ AchievementAction.iDepartmentManager);
	}

	public IEmployeeManager getiEmployeeManager() {
		return iEmployeeManager;
	}

	public void setiEmployeeManager(IEmployeeManager iEmployeeManager) {
		AchievementAction.iEmployeeManager = iEmployeeManager;
		System.out.println("AchievementAction -> setiEmployeeManager"
				+ AchievementAction.iEmployeeManager);
	}
	
	public IUsersManager getiUsersManager() {
		return iUsersManager;
	}

	public void setiUsersManager(IUsersManager iUsersManager) {
		AchievementAction.iUsersManager = iUsersManager;
		System.out.println("AchievementAction -> setiUsersManager"
				+ AchievementAction.iUsersManager);
	}
	
	public IAchievementManager getiAchievementManager() {
		return iAchievementManager;
	}

	public void setiAchievementManager(IAchievementManager iAchievementManager) {
		AchievementAction.iAchievementManager = iAchievementManager;
		System.out.println("AchievementAction -> setiAchievementManager"
				+ AchievementAction.iAchievementManager);
	}
	
	public String redirectExpatriate() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Users users = new Users();
		List<Employee> employees = null;
		List<ExpatriateLabor> expatriateLabors = null;
		setActiveSidebar(EXPATRIATE_ACTIVE_SIDEBAR_FLAG);
		setSmallTitle(EXPATRIATE_TITLE);
		request.setAttribute("smallTitle", smallTitle);
		request.setAttribute("activeSidebar", activeSidebar);
		try {
			//返回本部门所有的员工
			users = iUsersManager.getUserByUsername(request);
			request.setAttribute("name", users.getEmployee().getName());
			String departmentId = users.getEmployee().getDepartment().getId();
			employees = iEmployeeManager.getEmployeesByDepartmentID(departmentId);
			request.setAttribute("employees", employees);
			//返回所有本部门外勤任务的信息
			expatriateLabors = iAchievementManager.getExpatriateLaborsByDepartmentID(departmentId);
			request.setAttribute("expatriateLabors", expatriateLabors);
		} catch (Exception e) {
			System.out.println("AchievementAction -> redirectExpatriate" + e);
		}
		setPageString("expatriate");
		return pageString;
	}
	

	@JSON(name="addExpatriate")
	public String addExpatriate() {
		employeeID = String.format("%05d",  Integer.parseInt(employeeID));	//将获取到的员工ID转换为5位的字符串 
		flag = iAchievementManager.saveExpatriate(name, employeeID, details, address, longitude, latitude, begindate, deadline);
		return "flag";
	}

}
