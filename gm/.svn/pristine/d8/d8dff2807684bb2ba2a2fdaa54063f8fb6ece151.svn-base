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

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cc.ywxm.action.PageableAction;
import cc.ywxm.constant.Const;
import cc.ywxm.excel.ExportExcel;
import cc.ywxm.model.game.EnergyLog;
import cc.ywxm.service.game.EnergyLogService;
import cc.ywxm.utils.DateFormat;

/**
 * 活力使用记录
 * 
 * @author HuangDecai
 * @since 2012-12-30 13:12:10
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class EnergyLogAction extends PageableAction
{
	private String player;
	private String minTime;
	private String maxTime;
	private int type = 0;

	@Resource
	private EnergyLogService energyLogService;

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
	 * ajax gets
	 * 
	 * @return
	 * @throws IOException
	 */
	public String gets() throws IOException
	{
		String result = "";
		switch (type)
		{
		case 1:
			Integer player_ = null;
			try
			{
				player_ = Integer.parseInt(player);
			} catch (NumberFormatException e)
			{
				log.error(e.getMessage());
			}
			result = energyLogService.JSONData(rows, page, sort, order,
					player_, minTime, maxTime);
			break;
		case 2:
			result = energyLogService.JSONData(rows, page, sort, order,
					player, minTime, maxTime);
			break;
		default:
			break;
		}
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
		List<EnergyLog> list = new ArrayList<EnergyLog>();
		player = URLDecoder.decode(player, "utf-8");
		minTime = URLDecoder.decode(minTime, "utf-8");
		maxTime = URLDecoder.decode(maxTime, "utf-8");
		switch (type)
		{
		case 1:
			Integer player_ = null;
			try
			{
				player_ = Integer.parseInt(player);
			} catch (NumberFormatException e)
			{
				log.error(e.getMessage());
			}
			list = energyLogService.gets(player_, minTime, maxTime);
			break;
		case 2:
			String nickname = player;
			list = energyLogService.gets(nickname, minTime, maxTime);
			break;
		default:
			break;
		}
		ExportExcel<EnergyLog> exporter = new ExportExcel<EnergyLog>();
		OutputStream out = null;
		response.setContentType("octets/stream");
		response.addHeader("Content-Disposition", "attachment;filename="
				+ DateFormat.currentDateFormat("yyyyMMdd") + ".xls");
		out = response.getOutputStream();
		try
		{
			exporter.exportExcel("活力使用记录", new String[]
			{ "记录ID", "减少值", "剩余值", "时间" }, list, new String[]
			{ "logId", "reduce", "surplus", "logTime" }, out, "yyyy-MM-dd");
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		out.close();
		return NONE;

	}

	public String getPlayer()
	{
		return player;
	}

	public void setPlayer(String player)
	{
		this.player = player;
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

	public int getType()
	{
		return type;
	}

	public void setType(int type)
	{
		this.type = type;
	}

}
