package com.tk.service.impl;

import java.util.Iterator;
import java.util.List;

import com.tk.dao.ClockingInDAO;
import com.tk.dao.EmployeeDAO;
import com.tk.dao.SalaryDAO;
import com.tk.dao.hbm.ClockingIn;
import com.tk.dao.hbm.Employee;
import com.tk.dao.hbm.Salary;
import com.tk.service.ISalaryManager;
import com.tk.service.IUsersManager;
import com.tk.util.SystemTime;

public class SalaryManager implements ISalaryManager {

	private static final String SUPER_ID = "00000";
	private SalaryDAO salaryDAO;
	private EmployeeDAO employeeDAO;
	private ClockingInDAO clockingInDAO;
	
	@Override
	public void setsalaryDAO(SalaryDAO salaryDAO) {
		this.salaryDAO = salaryDAO;
		System.out.println("SalaryManager -> setSalaryDao:" + this.salaryDAO);
	}

	@Override
	public SalaryDAO getsalaryDAO() {
		return this.salaryDAO;
	}

	@Override
	public void setemployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
		System.out.println("SalaryManager -> setEmployeeDao:" + this.employeeDAO);
	}

	@Override
	public EmployeeDAO getemployeeDAO() {
		return this.employeeDAO;
	}
	
	public void setclockingInDAO(ClockingInDAO clockingInDAO) {
		this.clockingInDAO = clockingInDAO;
	}
	
	public ClockingInDAO getclockingInDAO() {
		return clockingInDAO;
	}

	@Override
	public boolean addSalary() {
		boolean flag = false;
		List<Employee> listEmployees = employeeDAO.findAll();
		Salary salary = new Salary();
		try {
			for (int i = 0; i < listEmployees.size(); i++) {
				//如果不是超级管理员,则添加员工工资表
				if( ! listEmployees.get(i).getId().equals(SUPER_ID) ){
					salary.setEmployee(listEmployees.get(i));
					salary.setYear(SystemTime.getYear());
					salary.setMonth(SystemTime.getMonth());
					salary.setWorkload(0);
					salary.setTotalSalary(0);
					salaryDAO.save(salary);
					flag = true;
				}
			}
		} catch (Exception e) {
			System.out.println("SalaryManager -> addSalary exception="+e);
		}
		return flag;
	}

	@Override
	public boolean updateSalary(Salary salary) {
		salaryDAO.update(salary);
		return true;
	}

	@Override
	public boolean deleteSalary(Salary salary) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Salary> getSalariesByEmployeeID(String employeeID) {
		List<Salary> list = salaryDAO.findByEmployeeID(employeeID);
		return list;
	}

	@Override
	public Salary getSalariesByYearMonth(String employeeID,int year, int month) {
		List<Salary> listSalarys = salaryDAO.findByEmployeeID(employeeID);
		Salary salary = null;
		if( null != listSalarys ){
			for( int i = 0; i < listSalarys.size(); i++ ){
				if( year == listSalarys.get(0).getYear() 
						&& month == listSalarys.get(0).getMonth() ){
					salary = listSalarys.get(i);
				}
			}
		}
		return salary;
	}

	@Override
	public String autoGetSalary() {
		
		String flag = "FALSE";
		
		//全勤奖金 100
		double QUANQIN = 100;
		//年资奖金 365元/年资
		double YEAR = 355;
		//迟到次数
		int CHIDAO = 0;
		//早退次数
		int ZAOTUI = 0;
		//缺勤次数
		int QUEQIN = 0;
		//工作量
		double BEISHU = 1.2;
		//底薪
		double DIXIN = 0;
		//基本工资
		double JIBEN = 0;
		//年资
		int SENIORITY = 0;
		//获取当前年份
		int YEAR_NOW = SystemTime.getYear();
		//获取当前月份
		int MONTH_NOW = SystemTime.getMonth();
		//请假天数
		int QINGJIA = 0;
		//工作量
		int WORKLOAD = 0;
		double TOTAL = 0;
		
		String employeeID = "";
		
		List<Employee> listEmployees = employeeDAO.findAll();
		System.out.println("SalaryManager -> autoGetSalary listEmployee = " + listEmployees);
		Salary salary = new Salary();
		ClockingIn clockingIn = new ClockingIn();
		for (int i = 0; i < listEmployees.size(); i++) {
			employeeID = listEmployees.get(i).getId();
			//获取本人基本工资
			JIBEN = (double)(listEmployees.get(i).getSalary())/100;
			//获取本人年资
			SENIORITY = listEmployees.get(i).getSeniority();
			
			List<Salary> listSalary = salaryDAO.findByEmployeeID(employeeID);
			for (int j = 0; j < listSalary.size(); j++) {
				//工资列表与当前年月匹配
				if( listSalary.get(j).getMonth() == MONTH_NOW 
						&& listSalary.get(j).getYear() == YEAR_NOW ){
					
					//设置slary
					salary = listSalary.get(j);
					
					System.out.println("SalaryManager -> autoGetSalary salary.year month = " + salary.getYear() + "--"+salary.getMonth());
					
					//获取本人的工作量
					WORKLOAD = salary.getWorkload();
					System.out.println("SalaryManager -> autoGetSalary wrokload = " + WORKLOAD);
					
					//读取考勤,计算当月的考勤情况
					List<ClockingIn> list = clockingInDAO.findByEmployeeID(employeeID);
					if( list != null ){
						Iterator<ClockingIn> iterator = list.iterator();
						while ( iterator.hasNext() ) {
							clockingIn = iterator.next();
							if ( clockingIn.getYear() == YEAR_NOW && clockingIn.getMonth() == MONTH_NOW ) {
								if( clockingIn.getAttendType().equals(5) ){
									QUEQIN ++;
								}else if( clockingIn.getAttendType().equals(2) ){
									CHIDAO ++;
									if( clockingIn.getClockingOut().getAttendType().equals(3) ){
										ZAOTUI ++;
									}
								}else if( clockingIn.getAttendType().equals(6) ){
									QINGJIA ++;
								}
							}
						}
						System.out.println("SalaryManager -> autoGetSalary 工龄（年资） = " + SENIORITY);
						System.out.println("SalaryManager -> autoGetSalary 基本工资 = " + JIBEN);
						System.out.println("SalaryManager -> autoGetSalary 缺勤天数： = " + QUEQIN);
						System.out.println("SalaryManager -> autoGetSalary 工作量 = " + WORKLOAD);
						System.out.println("SalaryManager -> autoGetSalary 迟到天数 = " + CHIDAO);
						System.out.println("SalaryManager -> autoGetSalary 早退天数 = " + ZAOTUI);
						System.out.println("SalaryManager -> autoGetSalary 请假天数 = " + QINGJIA);
						//开始计算总工资
						TOTAL = JIBEN + SENIORITY*YEAR + WORKLOAD * BEISHU;
						//考勤不正常的天数
						int KAOQIN = CHIDAO+ZAOTUI+QUEQIN+QINGJIA;
						
						//工作量工资计算
						
						//全勤奖励,考勤不正常3次扣完
						if( KAOQIN == 1 ){
							QUANQIN = 66.67;
						}else if( KAOQIN == 2 ){
							QUANQIN = 33.33;
						}else if( KAOQIN > 3 ){
							QUANQIN = 0;
						}
						TOTAL += QUANQIN;
						
						//请假1次扣除基本工资3%						
						if( QINGJIA > 0 ){
							TOTAL -= 0.03*JIBEN*QINGJIA;
						}
						
						//迟到早退超过3次,每次扣除基本工资7%
						if( CHIDAO+ZAOTUI > 3 ){
							TOTAL -= 0.07*JIBEN*(CHIDAO+ZAOTUI-3);
						}
						
						//缺勤一次扣除基本工资10%
						if( QUEQIN > 0 ){
							TOTAL -= 0.1*JIBEN*(QUEQIN);
						}
						
						salary.setTotalSalary((int)TOTAL*100);
						salaryDAO.update(salary);
						flag = "SUCCESS";
					}else{
						flag ="NONE_CLOCKIN_DATA";
					}
					
				}else{
					flag = "DANG_QIAN_NIAN_YUE_BU_PI_PEI";
				}
			}			
		}
		System.out.println("SalaryManager -> autoGetSalary flag="+flag);
		return flag;
	}

}
