package cc.ywxm.service.impl.platform;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cc.ywxm.dao.game.RechargeLogDao;
import cc.ywxm.model.platform.PaywayCount;
import cc.ywxm.service.platform.PaywayCountService;

@Transactional
@Service
public class PaywayCountServiceImpl implements PaywayCountService
{
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Resource
	private RechargeLogDao rechargeLogDao;

	public List<PaywayCount> gets()
	{
		List<PaywayCount> result = new ArrayList<PaywayCount>();
		try
		{
			result = rechargeLogDao.countByPlatform();
		} catch (Exception e)
		{
			log.error(e.getMessage());
		}
		return result;
	}

	public String XMLData()
	{
		Map<Integer, String> colors = new HashMap<Integer, String>();
		colors.put(1, "429EAD");
		colors.put(2, "4249AD");
		colors.put(3, "AD42A2");
		colors.put(4, "D4AC31");
		colors.put(5, "00247C");
		colors.put(6, "008900");
		colors.put(7, "E95D0F");
		colors.put(8, "BF0000");
		colors.put(9, "F2AC0C");
		colors.put(10, "1160B8");
		
		String result = "";
		StringBuffer stringBuffer = new StringBuffer();
		List<PaywayCount> list = this.gets();
		stringBuffer
				.append("<chart caption='按第三方支付平台统计' baseFont='宋体' baseFontSize='12' showPercentageInLabel='1'");
		stringBuffer
				.append(" showValues='1' showLabels='0' showLegend='1' legendPosition='RIGHT' showPercentValues='1'");
		stringBuffer
				.append(" bgcolor='ECF5FF' bgalpha='70' bordercolor='C6D2DF' showpercentvalues='1'");
		stringBuffer.append(" bgratio='0' startingangle='200' animation='1'>");
		for (PaywayCount paywayCount : list)
		{
			int index = list.indexOf(paywayCount);
			stringBuffer.append("<set value='" + paywayCount.getTotal()
					+ "' label='" + paywayCount.getPayway() + "' color='"
					+ colors.get(index + 1) + "'/>");
			if (index > 9)
			{
				break;
			}
		}
		stringBuffer.append("</chart>");
		result = stringBuffer.toString();
		return result;
	}

	public List<PaywayCount> gets1()
	{
		List<PaywayCount> result = new ArrayList<PaywayCount>();
		try
		{
			result = rechargeLogDao.countByBank();
		} catch (Exception e)
		{
			log.error(e.getMessage());
		}
		return result;
	}

	public String XMLData1()
	{
		Map<Integer, String> colors = new HashMap<Integer, String>();
		colors.put(1, "429EAD");
		colors.put(2, "4249AD");
		colors.put(3, "AD42A2");
		colors.put(4, "D4AC31");
		colors.put(5, "00247C");
		colors.put(6, "008900");
		colors.put(7, "E95D0F");
		colors.put(8, "BF0000");
		colors.put(9, "F2AC0C");
		colors.put(10, "1160B8");
		String result = "";
		StringBuffer stringBuffer = new StringBuffer();
		List<PaywayCount> list = this.gets1();
		stringBuffer
				.append("<chart caption='按支付银行统计' baseFont='宋体' baseFontSize='12' showPercentageInLabel='1'");
		stringBuffer
				.append(" showValues='1' showLabels='0' showLegend='1' legendPosition='RIGHT' showPercentValues='1'");
		stringBuffer
				.append(" bgcolor='ECF5FF' bgalpha='70' bordercolor='C6D2DF' showpercentvalues='1'");
		stringBuffer.append(" bgratio='0' startingangle='200' animation='1'>");
		for (PaywayCount paywayCount : list)
		{
			int index = list.indexOf(paywayCount);
			stringBuffer.append("<set value='" + paywayCount.getTotal()
					+ "' label='" + paywayCount.getPayway() + "' color='"
					+ colors.get(index + 1) + "'/>");
			if (index > 9)
			{
				break;
			}
		}
		stringBuffer.append("</chart>");
		result = stringBuffer.toString();
		return result;
	}

}
