package cc.ywxm.service.impl.platform;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cc.ywxm.dao.game.RechargeLogDao;
import cc.ywxm.model.platform.RechargeRank;
import cc.ywxm.service.platform.RechargeRankService;

/**
 * 玩家充值排行
 * 
 * @author HuangDeCai
 * @since 2012-12-17 13:24:39
 * 
 */
@Transactional
@Service
public class RechargeRankServiceImpl implements RechargeRankService
{
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Resource
	private RechargeLogDao rechargeLogDao;

	public List<RechargeRank> gets()
	{
		List<RechargeRank> result = new ArrayList<RechargeRank>();
		try
		{
			result = rechargeLogDao.rank();
		} catch (Exception e)
		{
			log.error(e.getMessage());
		}
		return result;
	}
	
	public List<RechargeRank> gets(int year, int month)
	{
		List<RechargeRank> result = new ArrayList<RechargeRank>();
		try
		{
			result = rechargeLogDao.rank(year, month);
		} catch (Exception e)
		{
			log.error(e.getMessage());
		}
		return result;
	}

	

	public List<RechargeRank> gets(String startDate, String endDate)
	{
		List<RechargeRank> result = new ArrayList<RechargeRank>();
		try
		{
			result = rechargeLogDao.rank(startDate, endDate);
		} catch (Exception e)
		{
			log.error(e.getMessage());
		}
		return result;
	}

	public String XMLData()
	{
		String result = "";
		StringBuffer stringBuffer = new StringBuffer();
		List<RechargeRank> list = this.gets();
		stringBuffer
				.append("<chart caption='玩家充值排行' baseFont='宋体' baseFontSize='12' yAxisName='充值总金额'");
		stringBuffer
				.append(" xAxisName='玩家昵称' bgColor='F1F1F1' showValues='1' canvasBorderThickness='1' canvasBorderColor='999999'");
		stringBuffer
				.append(" plotFillAngle='330' plotBorderColor='999999' showAlternateVGridColor='1' divLineAlpha='0'>");
		for (RechargeRank rechargeRank : list)
		{
			stringBuffer.append("<set value='" + rechargeRank.getTotal());
			stringBuffer.append("' label='" + rechargeRank.getNickname());
			stringBuffer.append("' toolText='第" + rechargeRank.getRank()
					+ "名'/>");
		}
		stringBuffer.append("</chart>");
		result = stringBuffer.toString();
		return result;
	}

	public String XMLData(int year, int month)
	{
		String result = "";
		StringBuffer stringBuffer = new StringBuffer();
		List<RechargeRank> list = this.gets(year, month);
		stringBuffer
				.append("<chart caption='玩家月充值排行' baseFont='宋体' baseFontSize='12' yAxisName='充值总金额'");
		stringBuffer
				.append(" xAxisName='玩家昵称' bgColor='F1F1F1' showValues='1' canvasBorderThickness='1' canvasBorderColor='999999'");
		stringBuffer
				.append(" plotFillAngle='330' plotBorderColor='999999' showAlternateVGridColor='1' divLineAlpha='0'>");
		for (RechargeRank rechargeRank : list)
		{
			stringBuffer.append("<set value='" + rechargeRank.getTotal());
			stringBuffer.append("' label='" + rechargeRank.getNickname());
			stringBuffer.append("' toolText='第" + rechargeRank.getRank()
					+ "名'/>");
		}
		stringBuffer.append("</chart>");
		result = stringBuffer.toString();
		return result;
	}
	
	public String XMLData(String startDate, String endDate)
	{
		String result = "";
		StringBuffer stringBuffer = new StringBuffer();
		List<RechargeRank> list = this.gets(startDate, endDate);
		stringBuffer
				.append("<chart caption='玩家日期段充值排行' baseFont='宋体' baseFontSize='12' yAxisName='充值总金额'");
		stringBuffer
				.append(" xAxisName='玩家昵称' bgColor='F1F1F1' showValues='1' canvasBorderThickness='1' canvasBorderColor='999999'");
		stringBuffer
				.append(" plotFillAngle='330' plotBorderColor='999999' showAlternateVGridColor='1' divLineAlpha='0'>");
		for (RechargeRank rechargeRank : list)
		{
			stringBuffer.append("<set value='" + rechargeRank.getTotal());
			stringBuffer.append("' label='" + rechargeRank.getNickname());
			stringBuffer.append("' toolText='第" + rechargeRank.getRank()
					+ "名'/>");
		}
		stringBuffer.append("</chart>");
		result = stringBuffer.toString();
		return result;
	}

	

}
