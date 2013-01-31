package cc.ywxm.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtils
{
	public static Date getLastDayOfMonth(Date sDate1)
	{
		Calendar cDay1 = Calendar.getInstance();
		cDay1.setTime(sDate1);
		final int lastDay = cDay1.getActualMaximum(Calendar.DAY_OF_MONTH);
		cDay1.set(Calendar.DAY_OF_MONTH, lastDay);
		return cDay1.getTime();
	}

	public static Date getfirstDayOfMonth(Date sDate1)
	{
		Calendar cDay1 = Calendar.getInstance();
		cDay1.setTime(sDate1);
		final int lastDay = cDay1.getActualMinimum(Calendar.DAY_OF_MONTH);
		cDay1.set(Calendar.DAY_OF_MONTH, lastDay);
		return cDay1.getTime();
	}
}
