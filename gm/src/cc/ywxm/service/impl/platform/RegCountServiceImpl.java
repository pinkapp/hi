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
import cc.ywxm.dao.game.RegisterLogDao;
import cc.ywxm.model.platform.RegCount;
import cc.ywxm.service.platform.RegCountService;

@Transactional
@Service
public class RegCountServiceImpl implements RegCountService
{
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Resource
	private RegisterLogDao registerLogDao;

	public List<RegCount> gets(String startDate, String endDate)
	{
		List<RegCount> result = new ArrayList<RegCount>();

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
		try
		{
			while (date1.compareTo(end) <= 0)
			{
				String date = "";
				int total = 0;
				date = sdf.format(date1);
				total = registerLogDao.count(date);
				date1.setTime(date1.getTime() + 1000 * 60 * 60 * 24l);
				RegCount regCount = new RegCount();
				regCount.setDate(date);
				regCount.setTotal(total);
				result.add(regCount);
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
		List<RegCount> list = this.gets(startDate, endDate);
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("<chart caption='注册统计' subCaption='(");
		stringBuffer.append(startDate + "至" + endDate);
		stringBuffer
				.append(")' baseFont='宋体' baseFontSize='12' xAxisName='日期' yAxisName='总数' bgColor='F7F7F7, E9E9E9'");
		stringBuffer
				.append(" divLineColor='91AF46' divLineAlpha='30' alternateHGridAlpha='5'");
		stringBuffer
				.append(" lineColor='1D8BD1' numVDivlines='7' showAlternateVGridColor='1' anchorSides='3' anchorRadius='5'");
		stringBuffer
				.append(" labelDisplay='Rotate' slantLabels='1' showValues='0'>");
		for (RegCount regCount : list)
		{
			stringBuffer.append("<set label='" + regCount.getDate()
					+ "' value='" + regCount.getTotal() + "' />");
		}
		stringBuffer.append("<styles>");
		stringBuffer
				.append("<definition><style name='Anim1' type='animation' param='_alpha' start='0' duration='1' /></definition>");
		stringBuffer
				.append("<application><apply toObject='TRENDLINES' styles='Anim1' /></application>");
		stringBuffer.append("</styles>");
		stringBuffer.append("</chart>");
		result = stringBuffer.toString();
		return result;
	}

}
