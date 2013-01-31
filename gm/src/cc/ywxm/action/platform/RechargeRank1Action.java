package cc.ywxm.action.platform;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cc.ywxm.action.PageableAction;
import cc.ywxm.excel.ExportExcel;
import cc.ywxm.model.platform.RechargeRank;
import cc.ywxm.service.platform.RechargeRankService;
import cc.ywxm.utils.DateFormat;
import cc.ywxm.utils.JSONtool;

/**
 * 玩家月充值排行
 * 
 * @author HuangDeCai
 * @since 2012-12-17 13:23:28
 * 
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class RechargeRank1Action extends PageableAction
{
	private Map<Integer, Integer> years = new LinkedHashMap<Integer, Integer>();
	private Map<Integer, Integer> months = new HashMap<Integer, Integer>();
	private int year = 0;
	private int month = 0;

	@Resource
	private RechargeRankService rechargeRankService;

	@Override
	public String execute() throws Exception
	{

		Calendar calendar = Calendar.getInstance();
		year = calendar.get(Calendar.YEAR);
		month = calendar.get(Calendar.MONTH);
		if (month == 0)
		{
			year--;
		}
		for (int i = 0; i <= 5; i++)
		{
			int y = year - i;
			years.put(y, y);
		}
		for (int i = 1; i <= 12; i++)
		{
			months.put(i, i);
		}
		return super.execute();
	}

	/**
	 * 查询
	 * 
	 * @return
	 * @throws IOException
	 */
	public String gets() throws IOException
	{
		String result = JSONtool.serialize(rechargeRankService
				.gets(year, month));
		log.debug(result);
		response.setContentType("text/xml;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		out.append(result);
		out.close();

		return NONE;
	}

	/**
	 * 图表
	 * 
	 * @return
	 * @throws IOException
	 */
	public String chart() throws IOException
	{
		String result = rechargeRankService.XMLData(year, month);
		response.setContentType("text/xml;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		out.append(JSONtool.serialize(result));
		out.close();
		return NONE;
	}

	/**
	 * 导出
	 * 
	 * @return
	 * @throws IOException
	 */
	public String export() throws IOException
	{
		List<RechargeRank> list = rechargeRankService.gets(year, month);
		ExportExcel<RechargeRank> exporter = new ExportExcel<RechargeRank>();
		OutputStream out = null;
		response.setContentType("octets/stream");
		response.addHeader("Content-Disposition", "attachment;filename="
				+ DateFormat.currentDateFormat("yyyyMMdd") + ".xls");
		out = response.getOutputStream();
		exporter.exportExcel("玩家充值排行", new String[]
		{ "玩家昵称", "总金额", "排名" }, list, out, "yyyy-MM-dd");
		out.close();
		return NONE;

	}

	public Map<Integer, Integer> getYears()
	{
		return years;
	}

	public void setYears(Map<Integer, Integer> years)
	{
		this.years = years;
	}

	public Map<Integer, Integer> getMonths()
	{
		return months;
	}

	public void setMonths(Map<Integer, Integer> months)
	{
		this.months = months;
	}

	public int getYear()
	{
		return year;
	}

	public void setYear(int year)
	{
		this.year = year;
	}

	public int getMonth()
	{
		return month;
	}

	public void setMonth(int month)
	{
		this.month = month;
	}

	public RechargeRankService getRechargeRankService()
	{
		return rechargeRankService;
	}

	public void setRechargeRankService(RechargeRankService rechargeRankService)
	{
		this.rechargeRankService = rechargeRankService;
	}

}
