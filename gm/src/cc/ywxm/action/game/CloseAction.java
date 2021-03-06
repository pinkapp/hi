package cc.ywxm.action.game;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cc.ywxm.action.BaseAction;
import cc.ywxm.service.game.CloseService;

/**
 * 封账号
 * 
 * @author HuangDecai
 * 
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class CloseAction extends BaseAction
{
	private int type = 0;
	private String player;
	private String reason;
	private String enddate;

	@Resource
	private CloseService closeService;

	/**
	 * ajax 封账号
	 * 
	 * @return
	 * @throws IOException
	 */
	public String close() throws IOException
	{
		int code = 0;
		switch (type)
		{
		case 1:
			code = closeService.close(player, reason, null);
			break;
		case 2:
			code = closeService.close(player, reason, enddate);
			break;
		default:
			return NONE;
		}
		switch (code)
		{

		case CloseService.CODE_SUCCESS:
			message = "操作成功";
			break;
		case CloseService.CODE_ZMQ_NORESPONSE:
			message = "服务器无响应，稍后再试";
			break;
		case CloseService.CODE_FAIL:
			message = "操作失败";
			break;
		default:
			message = "操作失败，错误码：" + code;
			break;
		}
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		out.append(message);
		out.close();

		return NONE;
	}

	/**
	 * 记录查询
	 * 
	 * @return
	 * @throws IOException
	 */
	public String gets() throws IOException
	{
		JSONArray jsonArray = closeService.gets(player);
		response.setContentType("text/xml;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		out.append(jsonArray.toString());
		out.close();
		return NONE;
	}

	public int getType()
	{
		return type;
	}

	public void setType(int type)
	{
		this.type = type;
	}

	public String getPlayer()
	{
		return player;
	}

	public void setPlayer(String player)
	{
		this.player = player;
	}

	public String getReason()
	{
		return reason;
	}

	public void setReason(String reason)
	{
		this.reason = reason;
	}

	public String getEnddate()
	{
		return enddate;
	}

	public void setEnddate(String enddate)
	{
		this.enddate = enddate;
	}

}
