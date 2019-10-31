package com.xr.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataUtil {
	/**
	 * 获取本月第一天
	 * 
	 * @return
	 */
	public static Date getmindate() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));

		return calendar.getTime();
	}

	/**
	 * 获取本月最后一天
	 * 
	 * @return
	 */
	public static Date getmaxdate() {
		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(new Date());
		calendar2.set(Calendar.DAY_OF_MONTH, calendar2.getActualMaximum(Calendar.DAY_OF_MONTH));
		return calendar2.getTime();
	}

	/**
	 * 转换格式为"yyyy-MM-dd"
	 * 
	 * @param data
	 *            传入时间参数
	 * @return
	 */
	public static String formatData(Date data) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(data);
	}
	/**
	 * String转date
	 * @param str
	 * @return
	 */
	public static Date formatString(String str){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return format.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	* 获取当月的 天数
	*/
	public static int getCurrentMonthDay() {
	 	Calendar a = Calendar.getInstance();
	 	a.set(Calendar.DATE,1);
	 	a.roll(Calendar.DATE,-1);
	 	int maxDate = a.get(Calendar.DATE);
	 	return maxDate;
	}
	/**
	 * 获取一个时间中得年
	 * @param date
	 * @return
	 */
	public static String getDataYear(Date date){
		 String year=String.format("%tY", date);
		 return year;
	}
	/**
	 * 获取时间中得月
	 * @param date
	 * @return
	 */
	public static String getDataMonth(Date date){
		String month=String .format("%tm", date);
		 return month;
	}
	/**
	 * 获取时间中得日
	 * @param date
	 * @return
	 */
	public static String getDataDay(Date date){
		String day=String .format("%td", date);
		 return day;
	}
}
