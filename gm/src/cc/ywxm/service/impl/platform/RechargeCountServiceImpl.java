package cc.ywxm.service.impl.platform;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cc.ywxm.constant.Const;
import cc.ywxm.dao.game.RechargeLogDao;
import cc.ywxm.model.platform.RechargeCount;
import cc.ywxm.model.platform.RechargeCount1;
import cc.ywxm.service.platform.RechargeCountService;

@Transactional
@Service
public class RechargeCountServiceImpl implements RechargeCountService
{
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Resource
	private RechargeLogDao rechargeLogDao;

	public List<RechargeCount> gets(String startDate, String endDate)
	{
		List<RechargeCount> result = new ArrayList<RechargeCount>();

		SimpleDateFormat sdf = new SimpleDateFormat(Const.DATE_DATE_PATTERN);
		Date start = null;
		Date end = null;
		try
		{
			start = sdf.parse(startDate);
			end = sdf.parse(endDate);
		} catch (ParseException e)
		{
			log.error(e.getMessage());
			return result;
		}
		Date date1 = new Date();
		date1.setTime(start.getTime());
		while (date1.compareTo(end) <= 0)
		{
			String date = "";
			double total = 0;
			int total1 = 0;
			date = sdf.format(date1);
			total = rechargeLogDao.count2(date);
			total1 = rechargeLogDao.count1(date);
			date1.setTime(date1.getTime() + 1000 * 60 * 60 * 24l);
			RechargeCount rechargeCount = new RechargeCount();
			rechargeCount.setDate(date);
			rechargeCount.setTotal(total);
			rechargeCount.setTotal1(total1);
			result.add(rechargeCount);
		}

		return result;
	}

	public String XMLData(String startDate, String endDate)
	{
		String result = "";
		StringBuffer stringBuffer = new StringBuffer();
		String subCaption = startDate + "至" + endDate;
		List<RechargeCount> list = this.gets(startDate, endDate);
		stringBuffer
				.append("<chart canvasPadding='10' caption='充值统计' subCaption='(");
		stringBuffer.append(subCaption);
		stringBuffer
				.append(")' yAxisName='总金额/总人数' baseFont='宋体' baseFontSize='12' bgColor='F7F7F7, E9E9E9'");
		stringBuffer
				.append(" numVDivLines='10' divLineAlpha='30' labelPadding ='10' yAxisValuesPadding ='10' showValues='0' rotateValues='1'");
		stringBuffer
				.append(" labelDisplay='Rotate' slantLabels='1' valuePosition='auto'>");

		stringBuffer.append("<categories>");
		for (RechargeCount rechargeCount : list)
		{
			stringBuffer.append("<category label='" + rechargeCount.getDate()
					+ "' />");
		}
		stringBuffer.append("</categories>");

		stringBuffer.append("<dataset seriesName='总金额' color='1D8BD1' >");
		for (RechargeCount rechargeCount : list)
		{
			stringBuffer.append("<set value='"
					+ new Double(rechargeCount.getTotal()).intValue() + "' />");
		}
		stringBuffer.append("</dataset>");

		stringBuffer.append("<dataset seriesName='总人数' color='F1683C' >");
		for (RechargeCount rechargeCount : list)
		{
			stringBuffer.append("<set value='" + rechargeCount.getTotal1()
					+ "' />");
		}
		stringBuffer.append("</dataset>");

		stringBuffer.append("</chart>");
		result = stringBuffer.toString();
		return result;
	}

	public String XMLData1()
	{
		Map<Integer, String> colors = new HashMap<Integer, String>();
		colors.put(1, "4249AD");
		colors.put(2, "AD42A2");
		colors.put(3, "D4AC31");
		colors.put(4, "BF0000");
		colors.put(5, "429EAD");
		String result = "";
		StringBuffer stringBuffer = new StringBuffer();
		List<RechargeCount1> list = this.gets1();
		stringBuffer
				.append("<chart caption='充值玩家统计' baseFont='宋体' baseFontSize='12' showPercentageInLabel='1'");
		stringBuffer
				.append(" showValues='1' showLabels='0' showLegend='1' legendPosition='RIGHT' showPercentValues='1'");
		stringBuffer
				.append(" bgcolor='ECF5FF' bgalpha='70' bordercolor='C6D2DF' showpercentvalues='1'");
		stringBuffer.append(" bgratio='0' startingangle='200' animation='1'>");
		for (RechargeCount1 rechargeCount1 : list)
		{
			stringBuffer.append("<set value='" + rechargeCount1.getTotal()
					+ "' label='" + rechargeCount1.getMoneyRange()
					+ "' color='"
					+ colors.get(list.indexOf(rechargeCount1) + 1) + "'/>");
		}
		stringBuffer.append("</chart>");
		result = stringBuffer.toString();
		return result;
	}

	public List<RechargeCount1> gets1()
	{
		List<RechargeCount1> result = new ArrayList<RechargeCount1>();
		int total = 0;
		RechargeCount1 rechargeCount1 = null;

		try
		{
			rechargeCount1 = new RechargeCount1();
			rechargeCount1.setMoneyRange("0-99");
			total = rechargeLogDao.count(0, 99);
			rechargeCount1.setTotal(total);
			result.add(rechargeCount1);

			rechargeCount1 = new RechargeCount1();
			rechargeCount1.setMoneyRange("100-199");
			total = rechargeLogDao.count(100, 199);
			rechargeCount1.setTotal(total);
			result.add(rechargeCount1);

			rechargeCount1 = new RechargeCount1();
			rechargeCount1.setMoneyRange("200-499");
			total = rechargeLogDao.count(200, 499);
			rechargeCount1.setTotal(total);
			result.add(rechargeCount1);

			rechargeCount1 = new RechargeCount1();
			rechargeCount1.setMoneyRange("500-999");
			total = rechargeLogDao.count(500, 999);
			rechargeCount1.setTotal(total);
			result.add(rechargeCount1);

			rechargeCount1 = new RechargeCount1();
			rechargeCount1.setMoneyRange("1000及以上");
			total = rechargeLogDao.count(1000, 1000000);
			rechargeCount1.setTotal(total);
			result.add(rechargeCount1);
		} catch (Exception e)
		{
			log.error(e.getMessage());
		}

		return result;
	}

}
