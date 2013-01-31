package cc.ywxm.action.game;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.json.JSONException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cc.ywxm.action.PageableAction;
import cc.ywxm.constant.Const;
import cc.ywxm.excel.ExportExcel;
import cc.ywxm.model.game.ConsumeLog;
import cc.ywxm.service.game.ConsumeLogService;
import cc.ywxm.utils.DateFormat;

/**
 * 消费日志
 * 
 * @author HuangDecai
 * @since 2012-12-25 15:59:10
 * 
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class ConsumeLogAction extends PageableAction
{
	private String player;
	private String minTime;
	private String maxTime;

	@Resource
	private ConsumeLogService consumeLogService;

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
	public String gets() throws IOException, JSONException
	{
		String result = "";
		result = consumeLogService.JSONData(rows, page, sort, order,
				player, minTime, maxTime);
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
		List<ConsumeLog> list = new ArrayList<ConsumeLog>();
		player = URLDecoder.decode(player, "utf-8");
		minTime = URLDecoder.decode(minTime, "utf-8");
		maxTime = URLDecoder.decode(maxTime, "utf-8");
		list = consumeLogService.gets(player, minTime, maxTime);
		ExportExcel<ConsumeLog> exporter = new ExportExcel<ConsumeLog>();
		OutputStream out = null;
		response.setContentType("octets/stream");
		response.addHeader("Content-Disposition", "attachment;filename="
				+ DateFormat.currentDateFormat("yyyyMMdd") + ".xls");
		out = response.getOutputStream();
		try
		{
			exporter.exportExcel("玩家消费记录", new String[]
			{ "记录ID", "消费金额", "用途", "时间" }, list, new String[]
			{ "logId", "money", "useFor", "logTime" }, out, "yyyy-MM-dd");
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		out.close();
		return NONE;

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

	public String getPlayer()
	{
		return player;
	}

	public void setPlayer(String player)
	{
		this.player = player;
	}

}
