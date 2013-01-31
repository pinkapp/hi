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

import cc.ywxm.action.PageableAction;
import cc.ywxm.constant.Const;
import cc.ywxm.excel.ExportExcel;
import cc.ywxm.model.platform.RegCount;
import cc.ywxm.service.platform.RegCountService;
import cc.ywxm.utils.DateFormat;
import cc.ywxm.utils.JSONtool;

/**
 * 每日注册统计
 * 
 * @author HuangDeCai
 * @since 2012-12-15 10:55:27
 * 
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class RegCountAction extends PageableAction
{
	private String maxDate;
	private String minDate;

	@Resource
	private RegCountService regCountService;

	@Override
	public String execute() throws Exception
	{
		SimpleDateFormat sdf = new SimpleDateFormat(Const.DATE_DATE_PATTERN);
		Date date = new Date();
		date.setTime(date.getTime() - 1000 * 60 * 60 * 24l);
		maxDate = sdf.format(date);
		date.setTime(date.getTime() - 1000 * 60 * 60 * 24 * 30l);
		minDate = sdf.format(date);
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
		String result = "";
		response.setContentType("text/xml;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		result = JSONtool.serialize(regCountService.gets(minDate, maxDate));
		log.debug(result);
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
		String result = regCountService.XMLData(minDate, maxDate);
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
		List<RegCount> list = regCountService.gets(minDate, maxDate);
		ExportExcel<RegCount> exporter = new ExportExcel<RegCount>();
		OutputStream out = null;
		response.setContentType("octets/stream");
		response.addHeader("Content-Disposition", "attachment;filename="
				+ DateFormat.currentDateFormat("yyyyMMdd") + ".xls");
		out = response.getOutputStream();
		exporter.exportExcel("每日注册统计", new String[]
		{ "日期", "总数" }, list, out, "yyyy-MM-dd");
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
