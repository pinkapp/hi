package cc.ywxm.action.gm;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cc.ywxm.action.PageableAction;
import cc.ywxm.constant.Const;
import cc.ywxm.excel.ExportExcel;
import cc.ywxm.model.gm.OperateLog;
import cc.ywxm.service.gm.OperateLogService;
import cc.ywxm.utils.DateFormat;

/**
 * 操作日志
 * 
 * @author HuangDecai
 * @since 2012-12-28 9:05:01
 * 
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class OperateLogAction extends PageableAction
{
	private String username;
	private String minTime;
	private String maxTime;

	@Resource
	private OperateLogService operateLogService;

	@Override
	public String execute() throws Exception
	{
		Date d = new Date();
		long l = d.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat(Const.DATE_TIME_PATTERN);
		maxTime = sdf.format(d);
		d.setTime(l - 1000 * 60 * 60 * 24l);
		minTime = sdf.format(d);
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
		result = operateLogService.JSONData(rows, page, sort, order, username,
				minTime, maxTime);
		log.debug(result);
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
		List<OperateLog> list = new ArrayList<OperateLog>();
		username = URLDecoder.decode(username, "utf-8");
		minTime = URLDecoder.decode(minTime, "utf-8");
		maxTime = URLDecoder.decode(maxTime, "utf-8");
		list = operateLogService.gets(username, minTime, maxTime);
		ExportExcel<OperateLog> exporter = new ExportExcel<OperateLog>();
		OutputStream out = null;
		response.setContentType("octets/stream");
		response.addHeader("Content-Disposition", "attachment;filename="
				+ DateFormat.currentDateFormat("yyyyMMdd") + ".xls");
		out = response.getOutputStream();
		try
		{
			exporter.exportExcel("玩家操作记录", new String[]
			{ "记录ID", "操作者", "IP地址", "信息", "时间" }, list, new String[]
			{ "logId", "operator", "ipAddress", "info", "logTime" }, out,
					"yyyy-MM-dd");
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		out.close();
		return NONE;

	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getMinTime()
	{
		return minTime;
	}

	public void setMinTime(String minTime)
	{
		this.minTime = minTime;
	}

	public String getMaxTime()
	{
		return maxTime;
	}

	public void setMaxTime(String maxTime)
	{
		this.maxTime = maxTime;
	}

}
