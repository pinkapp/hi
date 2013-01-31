package cc.ywxm.service.impl.platform;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cc.ywxm.dao.game.LoginLogDao;
import cc.ywxm.dao.game.RegisterLogDao;
import cc.ywxm.model.game.RetentionRate;
import cc.ywxm.service.platform.RetentionRateService;
import cc.ywxm.utils.MathsUtils;

/**
 * 
 * @author HuangDeCai
 * @since 2012-12-4 14:49:57
 */
@Transactional
@Service
public class RetentionRateServiceImpl implements RetentionRateService
{
	@Resource
	private LoginLogDao loginLogDao;
	@Resource
	private RegisterLogDao registerLogDao;

	public RetentionRate get(String date)
	{
		return null;
	}

	public List<RetentionRate> gets(String startDate, String endDate)
	{
		List<RetentionRate> result = new ArrayList<RetentionRate>();
		if (startDate == null || endDate == null)
		{
			return result;
		} else
		{
			startDate = startDate.trim();
			endDate = endDate.trim();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date sdate = null;
		Date edate = null;
		try
		{
			sdate = sdf.parse(startDate);
			edate = sdf.parse(endDate);
		} catch (ParseException e)
		{
			e.printStackTrace();
			return null;
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}

		try
		{
			if (sdate.compareTo(edate) <= 0)
			{
				while (sdate.compareTo(edate) <= 0)
				{
					String date = null;
					// 注册玩家数
					int count = 100;
					// 次日登录玩家数
					int count1 = 90;
					// 3日登录玩家数
					int count3 = 88;
					// 7日登录玩家数
					int count7 = 58;
					// 次日留存率
					String rate1 = null;
					// 3日留存率
					String rate3 = null;
					// 7日留存率
					String rate7 = null;

					date = sdf.format(sdate);
					count = registerLogDao.count(date);
					count1 = loginLogDao.count(date, 1);
					count3 = loginLogDao.count(date, 3);
					count7 = loginLogDao.count(date, 7);
					double d = 0.00;
					if (count != 0)
					{
						d = MathsUtils.div(count1, count, 4);
						rate1 = new DecimalFormat("#.##%").format(d);
						d = MathsUtils.div(count3, count, 4);
						rate3 = new DecimalFormat("#.##%").format(d);
						d = MathsUtils.div(count7, count, 4);
						rate7 = new DecimalFormat("#.##%").format(d);
					}
					RetentionRate rate = new RetentionRate(date, count, count1,
							count3, count7, rate1, rate3, rate7);
					result.add(rate);
					sdate.setTime(sdate.getTime() + 1000 * 60 * 60 * 24l);
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}

	public String XMLData(String startDate, String endDate)
	{
		String result = "";
		List<RetentionRate> list = this.gets(startDate, endDate);
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer
				.append("<chart caption='玩家留存率' showLabels='1' showvalues='1' decimals='0'");
		stringBuffer.append(" baseFont='宋体' baseFontSize='12'");
		stringBuffer.append(" placeValuesInside='1' rotateValues='1'>");
		stringBuffer.append("<categories>");
		for (RetentionRate retentionRate : list)
		{
			stringBuffer.append("<category label='" + retentionRate.getDate()
					+ "'/>");
		}
		stringBuffer.append("</categories>");

		stringBuffer.append("<dataset seriesName='注册' color='1D8BD1' >");

		for (RetentionRate retentionRate : list)
		{
			stringBuffer.append("<set value='" + retentionRate.getCount()
					+ "' />");
		}
		stringBuffer.append("</dataset>");
		
		stringBuffer.append("<dataset seriesName='次日登录' color='F1683C' >");
		
		for (RetentionRate retentionRate : list)
		{
			stringBuffer.append("<set value='" + retentionRate.getCount1()
					+ "' />");
		}
		stringBuffer.append("</dataset>");
		
		stringBuffer.append("<dataset seriesName='3日登录' color='DBDC25' >");
		
		for (RetentionRate retentionRate : list)
		{
			stringBuffer.append("<set value='" + retentionRate.getCount3()
					+ "' />");
		}
		stringBuffer.append("</dataset>");
		
		stringBuffer.append("<dataset seriesName='7日登录' color='2AD62A' >");
		
		for (RetentionRate retentionRate : list)
		{
			stringBuffer.append("<set value='" + retentionRate.getCount7()
					+ "' />");
		}
		stringBuffer.append("</dataset>");
		
		stringBuffer.append("</chart>");
		result = stringBuffer.toString();
		return result;
	}

}
