package com.taiji.eap.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateUtils {

	public static String getNowTimeOfFormat(String format) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String time = sdf.format(date);
		return time;
	}
	/**
	 * 日期类型转字符串
	 * @param date
	 * @param format
	 * @return
	 */
	public static String dateToString(Date date,String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String time = sdf.format(date);
		return time;
	}
	/**
	 * 字符串转日期
	 * @param time
	 * @return
	 */
	public static Date stringToDate(String time){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = format.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 字符串转日期
	 * @param time
	 * @return
	 */
	public static Date stringToDate(String time,String formatStr){
		SimpleDateFormat format = new SimpleDateFormat(formatStr);
		Date date = null;
		try {
			date = format.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static String getNowTimeStr() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(date);
		return time;
	}

	public static long getNowTimeStamp() {
		long timeInMillis = Calendar.getInstance().getTimeInMillis();
		return timeInMillis;
	}
	/**
	 * 某年某月的起始时间
	 * @param year
	 * @param month
	 * @return
	 */
	public static Date getBeginTime(String year,String month){
		YearMonth yearMonth = YearMonth.of(Integer.valueOf(year), Integer.valueOf(month));
		LocalDate localDate = yearMonth.atDay(1);  
		LocalDateTime startOfDay = localDate.atStartOfDay();  
		ZonedDateTime zonedDateTime = startOfDay.atZone(ZoneId.of("Asia/Shanghai"));  
		return Date.from(zonedDateTime.toInstant());  
	}
	/**
	 * 获取某年某月的结束时间
	 * @param year
	 * @param month
	 * @return
	 */
	public static Date getEndTime(String year,String month){
		YearMonth yearMonth = YearMonth.of(Integer.valueOf(year), Integer.valueOf(month));  
		LocalDate endOfMonth = yearMonth.atEndOfMonth();  
		LocalDateTime localDateTime = endOfMonth.atTime(23, 59, 59, 999);  
		ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of("Asia/Shanghai"));  
		return Date.from(zonedDateTime.toInstant());  
	}
	/**
	 * 获取指定日期的起始时间
	 * @param date
	 * @return
	 */
	public static Date getStartTime(Date date){
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR,0);
		calendar.set(Calendar.MINUTE,0);
		calendar.set(Calendar.SECOND,0);
		calendar.set(Calendar.MILLISECOND,0);
		return calendar.getTime();
	}
	/**
	 * 获取指定日期的结束时间
	 * @param date
	 * @return
	 */
	public static Date getEndTime(Date date){
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR,23);
		calendar.set(Calendar.MINUTE,59);
		calendar.set(Calendar.SECOND,59);
		calendar.set(Calendar.MILLISECOND,999);
		return calendar.getTime();
	}
	/**
	 * 获取当前时间所在年的周数
	 * @param date
	 * @return
	 */
	public static int getWeekOfYear(Date date) {
		Calendar c = new GregorianCalendar();
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.setMinimalDaysInFirstWeek(7);
		c.setTime(date);
		return c.get(Calendar.WEEK_OF_YEAR);
	}

	/**
	 * 获取当前时间所在年的最大周数
	 * @param year
	 * @return
	 */
	public static int getMaxWeekNumOfYear(int year) {
		Calendar calendar = Calendar.getInstance();  
		Calendar c = new GregorianCalendar();
		c.set(calendar.getWeekYear(), Calendar.DECEMBER, 31, 23, 59, 59);
		return getWeekOfYear(c.getTime());
	}

	/**
	 * 获取某年的第几周的开始日期
	 * @param year
	 * @param week
	 * @return
	 */
	public static Date getFirstDayOfWeek(int week) {
		Calendar calendar = Calendar.getInstance();  
		Calendar c = new GregorianCalendar();
		c.set(Calendar.YEAR, calendar.getWeekYear());
		c.set(Calendar.MONTH, Calendar.JANUARY);
		c.set(Calendar.DATE, 1);

		Calendar cal = (GregorianCalendar) c.clone();
		cal.add(Calendar.DATE, week * 7);

		return getFirstDayOfWeek(cal.getTime());
	}

	/**
	 * 获取某年的第几周的结束日期
	 * @param year
	 * @param week
	 * @return
	 */
	public static Date getLastDayOfWeek(int week) {
		Calendar calendar = Calendar.getInstance();  
		Calendar c = new GregorianCalendar();
		c.set(Calendar.YEAR, calendar.getWeekYear());
		c.set(Calendar.MONTH, Calendar.JANUARY);
		c.set(Calendar.DATE, 1);

		Calendar cal = (GregorianCalendar) c.clone();
		cal.add(Calendar.DATE, week * 7);

		return getLastDayOfWeek(cal.getTime());
	}

	/**
	 * 获取当前时间所在周的开始日期
	 * @param date
	 * @return
	 */
	public static Date getFirstDayOfWeek(Date date) {
		Calendar c = new GregorianCalendar();
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()); // Monday
		return c.getTime();
	}

	/**
	 * 获取当前时间所在周的结束日期
	 * @param date
	 * @return
	 */
	public static Date getLastDayOfWeek(Date date) {
		Calendar c = new GregorianCalendar();
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6); // Sunday
		return c.getTime();
	}

	/**
	 * 获取当前日期是星期几<br>
	 * @param dt
	 * @return 当前日期是星期几
	 */
	public static String getWeekOfDate(Date dt) {
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE",Locale.CHINESE);  
		String week = sdf.format(dt);  
		return week;  
	}

	/** 
	 * 获取未来 第 past 天的日期 
	 * @param past 
	 * @return 
	 */  
	public static Date getFetureDate(int past) {  
		Calendar calendar = Calendar.getInstance();  
		calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + past);  
		Date date = calendar.getTime();  
		return date;  
	}  
	/**
	 * 修改时间天数
	 * @param past
	 * @return
	 */
	public static Date addDate(Date date,long day){
		long time = date.getTime(); // 得到指定日期的毫秒数
		day = day*24*60*60*1000; // 要加上的天数转换成毫秒数
		time+=day; // 相加得到新的毫秒数
		return new Date(time); // 将毫秒数转换成日期
	}

	//获取本年的开始时间
	public static Date getBeginDayOfYear() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, getNowYear());
		// cal.set
		cal.set(Calendar.MONTH, Calendar.JANUARY);
		cal.set(Calendar.DATE, 1);

		return getStartTime(cal.getTime());
	}

	//获取本年的结束时间
	public static Date getEndDayOfYear() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, getNowYear());
		cal.set(Calendar.MONTH, Calendar.DECEMBER);
		cal.set(Calendar.DATE, 31);
		return getEndTime(cal.getTime());
	}

	//获取今年是哪一年
	public static Integer getNowYear() {
		Date date = new Date();
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		return Integer.valueOf(gc.get(1));
	}

}
