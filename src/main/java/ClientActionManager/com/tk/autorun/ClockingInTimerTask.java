package com.tk.autorun;

import com.tk.service.IClockingInManager;
import com.tk.util.SystemTime;

public class ClockingInTimerTask {

	private static IClockingInManager iClockingInManager;
	
	public static IClockingInManager getIClockingInManager() {
		return iClockingInManager;
	}

	public static void setIClockingInManager(IClockingInManager iClockingInManager) {
		ClockingInTimerTask.iClockingInManager = iClockingInManager;
		System.out.println("ClockingInTimerTask -> setIClockingInManager" + iClockingInManager);
	}
	
	protected void execute() {
		System.out.println(SystemTime.getDateEN());
		boolean flag =  iClockingInManager.addNewDayClockingIns();
		if (flag) {
			System.out.println("新的一天，新的考勤信息生成成功");
		} else {
			System.out.println("考勤信息生成失败");
		}
	}

}
