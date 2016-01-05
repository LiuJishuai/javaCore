package com.utils;



import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 *
 * @Message:  created by Liujishuai on 2016年1月5日
 * 
 * @Description: 时间处理工具类
 */
public class DateUtils {

	    public static final DateTimeFormatter STANDARD = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
	    public static final DateTimeFormatter STANDARD_MINUTE = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm");
	    public static final DateTimeFormatter yyyymmddhhmmss = DateTimeFormat.forPattern("yyyyMMddHHmmss");
	    public static final DateTimeFormatter yyyyMMdd = DateTimeFormat.forPattern("yyyyMMdd");
	    public static final DateTimeFormatter yyyyMM = DateTimeFormat.forPattern("yyyyMM");
	    public static final DateTimeFormatter date_sdf_wz = DateTimeFormat.forPattern("yyyy年MM月dd日");
	    public static final DateTimeFormatter date_sdf_wz_e = DateTimeFormat.forPattern("yyyy年MM月dd日 EE");
	    public static final DateTimeFormatter date_sdf_wz_hhmmss_e = DateTimeFormat.forPattern("yyyy年MM月dd日  HH:mm:ss EE");
	    
	   
	    
	  
	/**
	 * 获取当前时间时间戳
	 */
	public static Long getCurrentUnixTimeStamp(){
		return new DateTime().getMillis()/1000;
	}
	/**
	 * 获取指定时间的时间戳
	 */
	public static Long  getUnixTimeStamp(Date date){
		return new DateTime(date).getMillis()/1000;
	}
	/**
	 * 获取今天零点时间戳
	 * @return
	 */
	public static Long getTodayZeroStamp(){
		return new DateTime().withTimeAtStartOfDay().getMillis()/1000;
	}
	/**
	 * 获取本月1号零点时间戳
	 */
	public static Long getCurrentMonthZeroTimeStamp(){
		DateTime dateTime=new DateTime();
		dateTime=dateTime.withDayOfMonth(1).withTimeAtStartOfDay();
		return dateTime.getMillis()/1000;
	}
	/**
	 * 获取本月最后一天24点，也就是下个月零点时间戳
	 */
	public static Long getNextMonthZeroStamp(){
		DateTime dateTime=new DateTime();
		dateTime=dateTime.plusMonths(1).withDayOfMonth(1).withTimeAtStartOfDay();
		return dateTime.getMillis()/1000;
	}
}

