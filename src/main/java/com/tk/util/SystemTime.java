package com.tk.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SystemTime {

	private static Calendar calendar = Calendar.getInstance();	//可以对每个时间域单独修改
	private static int year;
	private static int month;
	private static int day;

	public static int getYear() {
		return calendar.get(Calendar.YEAR);
	}
	
	public static int getMonth() {
		return calendar.get(Calendar.MONTH) + 1;
	}

	public static int getDay() {
		return calendar.get(Calendar.DATE);
	}
	
	public static int getHour() {
		return calendar.get(Calendar.HOUR_OF_DAY);
	}
	
	public static int getMinute() {
		return calendar.get(Calendar.MINUTE);
	}
	
	public static int getSecond() {
		return calendar.get(Calendar.SECOND);
	}
	
	public static String getTimeHMS() {
		SimpleDateFormat format1 = new SimpleDateFormat("HH:mm:ss");
		String date1 = format1.format(new Date(System.currentTimeMillis()));
		return date1;
	}
	
	/**
	 * 获取系统时间
	 * 
	 * @return 2015-03-20 00:00:00
	 */
	public static String getDateEN()
	{
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1 = format1.format(new Date(System.currentTimeMillis()));
		return date1;
	}
	
}
