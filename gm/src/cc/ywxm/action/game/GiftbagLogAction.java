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
import cc.ywxm.model.game.GiftbagLog;
import cc.ywxm.service.game.GiftbagLogService;
import cc.ywxm.utils.DateFormat;

/**
 * 礼包使用记录
 * 
 * @author HuangDecai
 * @since 2012-12-29 10:38:57
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class GiftbagLogAction extends PageableAction
{
	private String player;
	private String minTime;
	private String maxTime;
	private int type = 0;

	@Resource
	private GiftbagLogService giftbagLogService;

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
			result = giftbagLogService.JSONData(rows, page, sort, order,
					player_, minTime, maxTime);
			break;
		case 2:
			result = giftbagLogService.JSONData(rows, page, sort, order,
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
		List<GiftbagLog> list = new ArrayList<GiftbagLog>();
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
			list = giftbagLogService.gets(player_, minTime, maxTime);
			break;
		case 2:
			String nickname = player;
			list = giftbagLogService.gets(nickname, minTime, maxTime);
			break;
		default:
			break;
		}
		ExportExcel<GiftbagLog> exporter = new ExportExcel<GiftbagLog>();
		OutputStream out = null;
		response.setContentType("octets/stream");
		response.addHeader("Content-Disposition", "attachment;filename="
				+ DateFormat.currentDateFormat("yyyyMMdd") + ".xls");
		out = response.getOutputStream();
		try
		{
			exporter.exportExcel("礼包使用记录", new String[]
			{ "记录ID", "礼包类型", "礼品", "时间" }, list, new String[]
			{ "logId", "giftbagType", "gifts", "logTime" }, out, "yyyy-MM-dd");
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
