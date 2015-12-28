package com.tk.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.ActionSupport;
import com.tk.dao.hbm.Employee;
import com.tk.dao.hbm.Users;
import com.tk.service.IAuthoritiesManager;
import com.tk.service.IClockingInManager;
import com.tk.service.IDepartmentManager;
import com.tk.service.IEducationBackgroundManager;
import com.tk.service.IEmployeeManager;
import com.tk.service.IUsersManager;


@Scope("prototype")
public class JsonAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private static IClockingInManager iClockingInManager;
	private static IUsersManager iUsersManager;
	private static IEmployeeManager iEmployeeManager;
	private static IDepartmentManager iDepartmentManager;
	private static IEducationBackgroundManager iEducationBackgroundManager;
	private static IAuthoritiesManager iAuthoritiesManager;
	private String leaveStrartTime;
	private String leaveEndTime;
	private String leaveReason;
	
	public IClockingInManager getIClockingInManager()
	{
		return iClockingInManager;
	}

	public void setIClockingInManager(IClockingInManager iClockingInManager)
	{
		JsonAction.iClockingInManager = iClockingInManager;
		System.out.println("JsonAction -> setIClockingInManager"
				+ JsonAction.iClockingInManager);
	}
	
	public IUsersManager getIUsersManager()
	{
		return iUsersManager;
	}
	
	public void setIUsersManager(IUsersManager iUsersManager)
	{
		JsonAction.iUsersManager = iUsersManager;
		System.out.println("JsonAction -> setIUsersManager"
				+ JsonAction.iUsersManager);
	}
	
	public static IEmployeeManager getiEmployeeManager() {
		return iEmployeeManager;
	}

	public static void setiEmployeeManager(IEmployeeManager iEmployeeManager) {
		JsonAction.iEmployeeManager = iEmployeeManager;
	}
	
	public static void setiDepartmentManager(
			IDepartmentManager iDepartmentManager) {
		JsonAction.iDepartmentManager = iDepartmentManager;
	}
	
	public static IDepartmentManager getiDepartmentManager() {
		return iDepartmentManager;
	}
	
	public static void setiEducationBackgroundManager(
			IEducationBackgroundManager iEducationBackgroundManager) {
		JsonAction.iEducationBackgroundManager = iEducationBackgroundManager;
	}
	
	public static IEducationBackgroundManager getiEducationBackgroundManager() {
		return iEducationBackgroundManager;
	}
	
	public static void setiAuthoritiesManager(
			IAuthoritiesManager iAuthoritiesManager) {
		JsonAction.iAuthoritiesManager = iAuthoritiesManager;
	}
	
	public static IAuthoritiesManager getiAuthoritiesManager() {
		return iAuthoritiesManager;
	}
	
	@JSON(name="clockingIn")
	public void clockingIn() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Users users = new Users();
		Employee employee = new Employee();
		try {
			users = iUsersManager.getUserByUsername(request);
			employee = users.getEmployee();
			iClockingInManager.clocingkIn(employee);
		} catch (Exception e) {
			System.out.println("JsonAction -> " + e);
		}
	}
	
	@JSON(name="clockingOut")
	public void clockingOut() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Users users = new Users();
		Employee employee = new Employee();
		try {
			users = iUsersManager.getUserByUsername(request);
			employee = users.getEmployee();
			iClockingInManager.clocingkOut(employee);
		} catch (Exception e) {
			System.out.println("JsonAction -> " + e);
		}
	}
	
	@JSON(name="askForLeave")
	public void askForLeave() {
		
	}
}
