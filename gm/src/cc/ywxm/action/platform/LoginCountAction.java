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
import cc.ywxm.model.platform.LoginCount;
import cc.ywxm.service.platform.LoginCountService;
import cc.ywxm.utils.DateFormat;
import cc.ywxm.utils.JSONtool;

/**
 * 每日登录统计
 * 
 * @author HuangDeCai
 * @since 2012-12-18 13:20:59
 * 
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class LoginCountAction extends PageableAction
{
	private String maxDate;
	private String minDate;

	@Resource
	private LoginCountService loginCountService;

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
		response.setContentType("text/xml;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		String jsonString = JSONtool.serialize(loginCountService.gets(minDate,
				maxDate));
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
		String result = loginCountService.XMLData(minDate, maxDate);
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
		List<LoginCount> list = loginCountService.gets(minDate, maxDate);
		ExportExcel<LoginCount> exporter = new ExportExcel<LoginCount>();
		OutputStream out = null;
		response.setContentType("octets/stream");
		response.addHeader("Content-Disposition", "attachment;filename="
				+ DateFormat.currentDateFormat("yyyyMMdd") + ".xls");
		out = response.getOutputStream();
		exporter.exportExcel("每日登录统计", new String[]
		{ "日期", "总数", "登录一次", "登录两次", "登录三次", "登录四次及以上" }, list, out,
				"yyyy-MM-dd");
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
