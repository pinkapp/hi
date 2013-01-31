package cc.ywxm.action.platform;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cc.ywxm.action.BaseAction;
import cc.ywxm.constant.Const;
import cc.ywxm.excel.ExportExcel;
import cc.ywxm.model.game.RetentionRate;
import cc.ywxm.service.platform.RetentionRateService;
import cc.ywxm.utils.DateFormat;
import cc.ywxm.utils.JSONtool;

/**
 * 玩家留存率
 * 
 * @author hdc
 * 
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class RetentionRateAction extends BaseAction
{
	private String maxDate;
	private String minDate;

	@Resource
	private RetentionRateService retentionRateService;

	@Override
	public String execute() throws Exception
	{
		SimpleDateFormat sdf = new SimpleDateFormat(Const.DATE_DATE_PATTERN);
		Date d = new Date();
		long l = d.getTime();
		d.setTime(l - 1000 * 60 * 60 * 24);
		maxDate = sdf.format(d);
		d.setTime(l - 1000 * 60 * 60 * 24 * 31l);
		minDate = sdf.format(d);
		return super.execute();
	}

	/**
	 * ajax gets
	 * 
	 * @return
	 * @throws IOException
	 */
	public String gets() throws IOException
	{
		String jsonString = "";
		List<RetentionRate> list = null;
		list = retentionRateService.gets(minDate, maxDate);
		jsonString = JSONtool.serialize(list);
		response.setContentType("text/xml;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		out.append(jsonString);
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
		String result = retentionRateService.XMLData(minDate, maxDate);
		//System.out.println(result);
		response.setContentType("text/xml;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		out.append(result);
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
		List<RetentionRate> list = retentionRateService.gets(minDate, maxDate);
		ExportExcel<RetentionRate> exporter = new ExportExcel<RetentionRate>();
		OutputStream out = null;
		response.setContentType("octets/stream");
		response.addHeader("Content-Disposition", "attachment;filename="
				+ DateFormat.currentDateFormat("yyyyMMdd") + ".xls");
		out = response.getOutputStream();
		try
		{
			exporter.exportExcel("玩家留存率", new String[]
			{ "日期", "注册总数", "次日留存率", "三日留存率", "七日留存率" }, list, new String[]
			{ "date", "count", "rate1", "rate3", "rate7" }, out, "yyyy-MM-dd");
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		out.close();
		return NONE;

	}

	public String getMaxDate()
	{
		return maxDate;
	}

	public void setMaxDate(String maxDate)
	{
		this.maxDate = maxDate;
	}

	public String getMinDate()
	{
		return minDate;
	}

	public void setMinDate(String minDate)
	{
		this.minDate = minDate;
	}

}
