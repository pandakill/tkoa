package com.tk.autorun;

import com.tk.service.IClockingInManager;
import com.tk.service.ISalaryManager;
import com.tk.util.SystemTime;

public class SalaryTimerTask {
	
	private static ISalaryManager iSalaryManager;
	
	public static void setiSalaryManager(ISalaryManager iSalaryManager) {
		SalaryTimerTask.iSalaryManager = iSalaryManager;
	}
	
	public static ISalaryManager getiSalaryManager() {
		return iSalaryManager;
	}
	
	protected void autoAdd() {
		System.out.println(SystemTime.getDateEN()+"  时间到了,自动生成工资列表");
		boolean flag =  iSalaryManager.addSalary();
		if (flag) {
			System.out.println("新的一月,自动生成工资列表成功");
		} else {
			System.out.println("工资列表生成失败");
		}
	}
	
	protected void autoGet() {
		System.out.println(SystemTime.getDateEN()+"  时间到了,自动结算工资");
	}

}
