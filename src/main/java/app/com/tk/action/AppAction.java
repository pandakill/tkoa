package com.tk.action;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionSupport;
import com.tk.dao.ExpatriateLaborDAO;
import com.tk.dao.NoticeDAO;
import com.tk.dao.hbm.Employee;
import com.tk.dao.hbm.ExpatriateLabor;
import com.tk.dao.hbm.Notice;
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

/**
 * @类说明 
 * @创建者 panda
 * @创建日期 2015年7月10日 下午3:45:44
 * @修改者 
 * @修改时间 
 */
public class AppAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private static final int LESSWORK = 3;  //外派任务期限小于等于三天的工作量
	private static final int MUCHWORK = 2;  //外派任务期限大于3三的工作量倍数
	private static IClockingInManager iClockingInManager;
	private static IUsersManager iUsersManager;
	private static IEmployeeManager iEmployeeManager;
	private static IDepartmentManager iDepartmentManager;
	private static IEducationBackgroundManager iEducationBackgroundManager;
	private static IAuthoritiesManager iAuthoritiesManager;
	private static ISalaryManager iSalaryManager;
	private static ExpatriateLaborDAO expatriateLaborDAO;
	private static NoticeDAO noticeDAO;
	
	private String username;
	private String password;
	private int exID;
	private String date;
	private String employeeID;
	
	//manager的setter和getter
	public static void setiUsersManager(IUsersManager iUsersManager) {
		AppAction.iUsersManager = iUsersManager;
		System.out.println("AppAction -> setiUsersManager:"+AppAction.iUsersManager);
	}
	
	public static IUsersManager getiUsersManager() {
		return iUsersManager;
	}
	
	public static void setiEmployeeManager(IEmployeeManager iEmployeeManager) {
		AppAction.iEmployeeManager = iEmployeeManager;
		System.out.println("AppAction -> setiEmployeeManager:"+AppAction.iEmployeeManager);
	}
	
	public static IEmployeeManager getiEmployeeManager() {
		return iEmployeeManager;
	}
	
	public static IClockingInManager getiClockingInManager() {
		return iClockingInManager;
	}

	public static void setiClockingInManager(IClockingInManager iClockingInManager) {
		AppAction.iClockingInManager = iClockingInManager;
		System.out.println("AppAction -> setiClockingInManager:"+AppAction.iClockingInManager);
	}

	public static IEducationBackgroundManager getiEducationBackgroundManager() {
		return iEducationBackgroundManager;
	}

	public static void setiEducationBackgroundManager(
			IEducationBackgroundManager iEducationBackgroundManager) {
		AppAction.iEducationBackgroundManager = iEducationBackgroundManager;
		System.out.println("AppAction -> setiEducationBackgroundManager:"+AppAction.iEducationBackgroundManager);
	}

	public static IDepartmentManager getiDepartmentManager() {
		return iDepartmentManager;
	}

	public static void setiDepartmentManager(IDepartmentManager iDepartmentManager) {
		AppAction.iDepartmentManager = iDepartmentManager;
		System.out.println("AppAction -> setiDepartmentManager:"+AppAction.iDepartmentManager);
	}

	public static IAuthoritiesManager getiAuthoritiesManager() {
		return iAuthoritiesManager;
	}

	public static void setiAuthoritiesManager(IAuthoritiesManager iAuthoritiesManager) {
		AppAction.iAuthoritiesManager = iAuthoritiesManager;
		System.out.println("AppAction -> setiAuthoritiesManager:"+AppAction.iAuthoritiesManager);
	}
	
	public static void setiSalaryManager(ISalaryManager iSalaryManager) {
		AppAction.iSalaryManager = iSalaryManager;
	}
	
	public static ISalaryManager getiSalaryManager() {
		return iSalaryManager;
	}
	
	public static void setExpatriateLaborDAO(
			ExpatriateLaborDAO expatriateLaborDAO) {
		AppAction.expatriateLaborDAO = expatriateLaborDAO;
		System.out.println("AppAction -> setExpatriateLaborDAO:"+AppAction.expatriateLaborDAO);
	}
	
	public static ExpatriateLaborDAO getExpatriateLaborDAO() {
		return expatriateLaborDAO;
	}
	
	public static void setNoticeDAO(NoticeDAO noticeDAO) {
		AppAction.noticeDAO = noticeDAO;
		System.out.println("AppAction -> setNoticeDAO:"+AppAction.noticeDAO);
	}
	
	public static NoticeDAO getNoticeDAO() {
		return noticeDAO;
	}

	//参数的setter和getter
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setPassword(String password) {
		this.password = MD5.md5(password);
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setExID(int exID) {
		this.exID = exID;
	}
	
	public int getExID() {
		return exID;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}
	
	public String getEmployeeID() {
		return employeeID;
	}
	
	/**
	 * @方法说明 Android登录
	 * @创建者 panda
	 * @创建日期 2015年7月10日 下午2:11:56
	 * @修改者 
	 * @修改时间 
	 * @return true\false
	 */
	public void Applogin(){
		System.out.println("username="+username + "  password=" + password);
		Users users = iUsersManager.getUsersByTel(username);
		boolean flag = false;
		if( null != users ){
			if( users.getPassword().equals(password) ){
				flag = true;
			}else{
				flag = false;
			}
		}
		System.out.println("AppAction -> login username=" + username + "  result:"+flag);
		SomeTool.out_print(String.valueOf(flag));
	}
	
	/**
	 * @方法说明 Android返回未激活的名字
	 * @创建者 panda
	 * @创建日期 2015年7月10日 下午2:12:36
	 * @修改者 
	 * @修改时间 
	 * @return null:空
	 * 		   json
	 */
	public void AppgetNames(){
		String flag = null;
		System.out.println();
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
		SomeTool.out_print(String.valueOf(flag));
	}
	
	/**
	 * @方法说明 Android获取个人信息
	 * @创建者 panda
	 * @创建日期 2015年7月10日 下午3:25:59
	 * @修改者 
	 * @修改时间 
	 * @return json
	 */
	public void AppgetInfors(){
		System.out.println("AppAction -> AppgetInfos username=" + username);
		Employee employee = iEmployeeManager.getEmployeeByTel(username);
		JSONObject json = new JSONObject();
		json.put("id", employee.getId());
		json.put("name", employee.getName());
		json.put("tel", employee.getUsers().getUsername());
		json.put("department", employee.getDepartment().getName());
		json.put("post", employee.getPost().getPostName());
		json.put("extension", employee.getExtension());
		json.put("duty", employee.getDuty());
		json.put("sex", employee.getSex());
		json.put("nativePlace", employee.getNativePlace());
		json.put("education", employee.getEducationBackground().getName());
		json.put("birthday", employee.getBirthday());
		json.put("major", employee.getMajor());
		
		SomeTool.out_print(String.valueOf(json));
	}
	
	/**
	 * @方法说明 Android请求获取所有的外勤任务内容
	 * @创建者 panda
	 * @创建日期 2015年7月10日 下午3:46:18
	 * @修改者 
	 * @修改时间 
	 * @return void
	 */
	public void AppgetExpatriates(){
		String flag = null;
		System.out.println("AppAction -> AppgetExpatriates username=" + username);
		Employee employee = iEmployeeManager.getEmployeeByTel(username);
		List<ExpatriateLabor> list = expatriateLaborDAO.findByEmployeeID(employee.getId());
		List<ExpatriateLabor> lt = null;
 		JSONArray jsonArray = new JSONArray();
		for (int i = 0; i < list.size(); i++) {
			JSONObject json = new JSONObject();
			int id = list.get(i).getId();
			int deadline = list.get(i).getDeadline();
			String customerName = list.get(i).getCustomerName();
			String customerAddress = list.get(i).getCustomerAddress();
			String attackTime = list.get(i).getAttackTime();
			String longitudeE = list.get(i).getLongitudeE();
			String latitudeE = list.get(i).getLatitudeE();
			String detail = list.get(i).getProjectDetails();
			int status = list.get(i).getStatus();
//			ExpatriateLabor expatriateLabor = null;
//			expatriateLabor = new ExpatriateLabor(id,deadline,customerName,customerAddress,attackTime,longitudeE,latitudeE);
			json.put("id",id);
			json.put("deadline",deadline);
			json.put("customerName",customerName);
			json.put("customerAddress",customerAddress);
			json.put("attackTime",attackTime);
			json.put("longitudeE",longitudeE);
			json.put("latitudeE",latitudeE);
			json.put("status",status);
			json.put("detail", detail);
			jsonArray.add(json);
		}
		System.out.println("AppAction -> AppgetExpatriates json=" + jsonArray);
		SomeTool.out_print(jsonArray.toString());
	}
	
	/**
	 * @方法说明 Android请求任务签到,签到成功,返回true,否则false
	 * @创建者 panda
	 * @创建日期 2015年7月10日 下午5:06:35
	 * @修改者 
	 * @修改时间 
	 * @return String：
	 * 			<br/>NOT_FOUNT -- "没有找到该项目";
	 * 			<br/>ALREADY_CLOCKIN -- "该项目已完成或已签到";
	 * 			<br/>NOT_HIS_EXP --"项目不是由该用户负责";
	 * 			<br/>SUCCESS --"签到成功";
	 * 			<br/>FALSE --"签到失败";
	 */
	public void Appclockin(){
		String flag = "FALSE";
		System.out.println("AppAction -> AppclockingIn username=" +username + "  exID="+exID+"  date="+date);
		ExpatriateLabor expatriateLabor = expatriateLaborDAO.findByID(exID);
		Employee employee = iEmployeeManager.getEmployeeByTel(username);
		if( null != expatriateLabor ){
			if( employee.getUsers().getUsername().equals(expatriateLabor.getEmployee().getUsers().getUsername()) ){
				if( expatriateLabor.getStatus() != 0){
					flag = "ALREADY_CLOCKIN";
				}else{
					//将任务修改为完成状态
					expatriateLabor.setStatus(1);
					//更新任务状态
					expatriateLaborDAO.update(expatriateLabor);
					
					//修改salary表中的工作量
					int[] date = SomeTool.spiltDate(expatriateLabor.getAttackTime(), "-");
					Salary salary = iSalaryManager.getSalariesByYearMonth(employee.getId(), date[0], date[1]);
					if( expatriateLabor.getDeadline()>0 && 4<expatriateLabor.getDeadline()  ){
						salary.setWorkload(salary.getWorkload()+LESSWORK);
					}else if( expatriateLabor.getDeadline() > 3 ){
						salary.setWorkload(salary.getWorkload()*MUCHWORK);
					}
					iSalaryManager.updateSalary(salary);
					flag = "SUCCESS";
				}
			}else{
				flag = "NOT_HIS_EXP";
			}
		}else{
			flag = "NOT_FOUND";
		}
		SomeTool.out_print(String.valueOf(flag));
	}
	
	/**
	 * @方法说明 获取工资列表
	 * @创建者 panda
	 * @创建日期 2015年7月10日 下午6:58:29
	 * @修改者 
	 * @修改时间 
	 * @return void
	 */
	public void AppgetSalary(){
		System.out.println("AppAction -> AppgetSalary username="+username);
		Employee employee = iEmployeeManager.getEmployeeByTel(username);
		List<Salary> listSalary = iSalaryManager.getSalariesByEmployeeID(employee.getId());
		JSONArray jsonArray = new JSONArray();
		if( null != listSalary ){
			for (int i = 0; i < listSalary.size(); i++) {
				JSONObject json = new JSONObject();
				json.put("month", listSalary.get(i).getYear()+"年"+listSalary.get(i).getMonth()+"月");
				json.put("salary", listSalary.get(i).getTotalSalary());
				jsonArray.add(json);
			}
		}
		System.out.println("AppAction -> AppgetSalary jsonArray="+jsonArray.toJSONString());
		SomeTool.out_print(jsonArray.toJSONString());
	}
	
	/**
	 * @方法说明 通过用户id查找部门相关公告
	 * @创建者 panda
	 * @创建日期 2015年7月10日 下午8:41:22
	 * @修改者 
	 * @修改时间 
	 * @return jsonArray
	 */
	public void AppgetNotices(){
		System.out.println("AppAction -> AppgetNotices username="+username);
		Employee employee = iEmployeeManager.getEmployeeByTel(username);
		List<Notice> listNotices = noticeDAO.findNoticesByDepartmentID(employee.getDepartment().getId());
		JSONArray jsonArray = new JSONArray();
		if( null != listNotices ){
			for (int i = 0; i < listNotices.size(); i++) {
				JSONObject json = new JSONObject();
				json.put("id", listNotices.get(i).getId());
				json.put("title", listNotices.get(i).getTitle());
				json.put("details", listNotices.get(i).getDetails());
				json.put("department", listNotices.get(i).getDepartment().getName());
				json.put("author", listNotices.get(i).getPromulgator());
				json.put("date",listNotices.get(0).getPubdate());
				jsonArray.add(json);
			}
		}
		System.out.println("AppAction -> AppgetNotices jsonArray="+jsonArray.toJSONString());
		SomeTool.out_print(jsonArray.toJSONString());
	}
	
	/**
	 * @方法说明 Android请求注册激活用户操作,Android传入employeeID、username、password
	 * @创建者 panda
	 * @创建日期 2015年7月11日 上午1:26:59
	 * @修改者 
	 * @修改时间 
	 * @return void
	 */
	public void Appregister(){
		String status = "FALSE";
		Employee employee = iEmployeeManager.getEmployeeByID(employeeID);
		if( null != employee ){
			if( employee.getUsers().getEnabled() == 0 ){
				if( username.equals(employee.getUsers().getUsername()) ){
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
		}
	}
	
	/**
	 * @方法说明 Android请求获取考勤信息汇总,Android传入参数username
	 * @创建者 panda
	 * @创建日期 2015年7月11日 上午11:19:33
	 * @修改者 
	 * @修改时间 
	 * @return void
	 */
	public void AppgetClockin() {
		
	}
	
	public void autoGet(){
		iSalaryManager.autoGetSalary();
	}
}
