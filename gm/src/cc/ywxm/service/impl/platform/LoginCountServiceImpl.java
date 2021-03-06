package cc.ywxm.service.impl.platform;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cc.ywxm.constant.Const;
import cc.ywxm.dao.game.LoginLogDao;
import cc.ywxm.model.platform.LoginCount;
import cc.ywxm.service.platform.LoginCountService;

@Transactional
@Service
public class LoginCountServiceImpl implements LoginCountService
{

	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Resource
	private LoginLogDao loginLogDao;

	public List<LoginCount> gets(String startDate, String endDate)
	{
		List<LoginCount> result = new ArrayList<LoginCount>();

		SimpleDateFormat sdf = new SimpleDateFormat(Const.DATE_DATE_PATTERN);
		Date start = null;
		Date end = null;
		try
		{
			start = sdf.parse(startDate);
			end = sdf.parse(endDate);
		} catch (ParseException e)
		{
			e.printStackTrace();
			return result;
		}
		Date date1 = new Date();
		date1.setTime(start.getTime());
		try
		{
			while (date1.compareTo(end) <= 0)
			{
				String date = "";
				int total = 0;
				int total1 = 0;
				int total2 = 0;
				int total3 = 0;
				int total4More = 0;
				date = sdf.format(date1);
				total = loginLogDao.countByDate(date);
				total1 = loginLogDao.countByDate(date, 1);
				total2 = loginLogDao.countByDate(date, 2);
				total3 = loginLogDao.countByDate(date, 3);
				total4More = loginLogDao.countByDateMore(date, 4);
				
				LoginCount loginCount = new LoginCount();
				loginCount.setDate(date);
				loginCount.setTotal(total);
				loginCount.setTotal1(total1);
				loginCount.setTotal2(total2);
				loginCount.setTotal3(total3);
				loginCount.setTotal4More(total4More);
				result.add(loginCount);
				date1.setTime(date1.getTime() + 1000 * 60 * 60 * 24l);
			}
		} catch (Exception e)
		{
			log.error(e.getMessage());
		}

		return result;
	}

	public String XMLData(String startDate, String endDate)
	{
		String result = "";
		StringBuffer stringBuffer = new StringBuffer();
		String subCaption = startDate + "至" + endDate;
		List<LoginCount> list = this.gets(startDate, endDate);
		stringBuffer
				.append("<chart canvasPadding='10' caption='登录统计' subCaption='(");
		stringBuffer.append(subCaption);
		stringBuffer
				.append(")' yAxisName='人数' baseFont='宋体' baseFontSize='12' bgColor='F7F7F7, E9E9E9'");
		stringBuffer
				.append(" numVDivLines='10' divLineAlpha='30' labelPadding ='10' yAxisValuesPadding ='10' showValues='0' rotateValues='1'");
		stringBuffer
				.append(" labelDisplay='Rotate' slantLabels='1' valuePosition='auto'>");

		stringBuffer.append("<categories>");
		for (LoginCount loginCount : list)
		{
			stringBuffer.append("<category label='" + loginCount.getDate()
					+ "' />");
		}
		stringBuffer.append("</categories>");

		stringBuffer.append("<dataset seriesName='总数' color='1D8BD1' >");
		for (LoginCount loginCount : list)
		{
			stringBuffer
					.append("<set value='" + loginCount.getTotal() + "' />");
		}
		stringBuffer.append("</dataset>");

		stringBuffer.append("<dataset seriesName='登录一次' color='F1683C' >");
		for (LoginCount loginCount : list)
		{
			stringBuffer.append("<set value='" + loginCount.getTotal1()
					+ "' />");
		}
		stringBuffer.append("</dataset>");

		stringBuffer.append("<dataset seriesName='登录两次' color='DBDC25' >");
		for (LoginCount loginCount : list)
		{
			stringBuffer.append("<set value='" + loginCount.getTotal2()
					+ "' />");
		}
		stringBuffer.append("</dataset>");

		stringBuffer.append("<dataset seriesName='登录三次' color='2AD62A' >");
		for (LoginCount loginCount : list)
		{
			stringBuffer.append("<set value='" + loginCount.getTotal3()
					+ "' />");
		}
		stringBuffer.append("</dataset>");

		stringBuffer.append("<dataset seriesName='登录四次及以上' color='4249AD' >");
		for (LoginCount loginCount : list)
		{
			stringBuffer.append("<set value='" + loginCount.getTotal4More()
					+ "' />");
		}
		stringBuffer.append("</dataset>");

		stringBuffer.append("</chart>");
		result = stringBuffer.toString();
		return result;
	}

}
