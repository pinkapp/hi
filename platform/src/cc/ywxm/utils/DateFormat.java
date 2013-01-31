package cc.ywxm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat
{
	// 定义标准时间格式
	public static String TIME_PATTERN = "HH:mm:ss";
	// 默认日期格式
	public static String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";
	// 定义标准日期格式1
	public static String DATE_PATTERN_1 = "yyyy/MM/dd";
	// 定义标准日期格式2
	public static String DATE_PATTERN_2 = "yyyy-MM-dd";
	// 定义标准日期格式3，带有时间
	public static String DATE_PATTERN_3 = "yyyy/MM/dd HH:mm:ss";//
	// 定义标准日期格式4，带有时间和星期
	public static String DATE_PATTERN_4 = "yyyy/MM/dd HH:mm:ss E";//
	// 定义标准日期格式5，带有时间和星期
	public static String DATE_PATTERN_5 = "yyyy年MM月dd日 HH:mm:ss E";//

	public static String format(Date date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_PATTERN);
		return sdf.format(date);
	}

	public static Date parse(String dateString)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_PATTERN);
		try
		{
			return sdf.parse(dateString);
		} catch (ParseException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public static Date parse(String dateString, String pattern)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try
		{
			return sdf.parse(dateString);
		} catch (ParseException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public static String format(Date date, String pattern)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

	public static String currentDateFormat(String pattern)
	{
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

	public static String currentDateFormat()
	{
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_PATTERN);
		return sdf.format(date);
	}
}
