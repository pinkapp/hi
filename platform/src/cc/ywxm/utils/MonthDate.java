package cc.ywxm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MonthDate
{
	private String source;
	private String pattern;

	public MonthDate(String source, String pattern)
	{
		super();
		this.source = source;
		this.pattern = pattern;
	}

	public Date getLastDayOfMonth()
	{
		Calendar cDay1 = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try
		{
			cDay1.setTime(sdf.parse(source));
		} catch (ParseException e)
		{
			e.printStackTrace();
		}
		final int lastDay = cDay1.getActualMaximum(Calendar.DAY_OF_MONTH);
		cDay1.set(Calendar.DAY_OF_MONTH, lastDay);
		return cDay1.getTime();

	}

	public Date getfirstDayOfMonth()
	{
		Calendar cDay1 = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try
		{
			cDay1.setTime(sdf.parse(source));
		} catch (ParseException e)
		{
			e.printStackTrace();
		}
		final int fistDay = cDay1.getActualMinimum(Calendar.DAY_OF_MONTH);
		cDay1.set(Calendar.DAY_OF_MONTH, fistDay);
		return cDay1.getTime();
	}

	public String getSource()
	{
		return source;
	}

	public void setSource(String source)
	{
		this.source = source;
	}

	public String getPattern()
	{
		return pattern;
	}

	public void setPattern(String pattern)
	{
		this.pattern = pattern;
	}
}
