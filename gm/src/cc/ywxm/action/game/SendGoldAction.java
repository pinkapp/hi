package cc.ywxm.action.game;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.json.JSONException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cc.ywxm.action.BaseAction;
import cc.ywxm.model.game.Closed;
import cc.ywxm.service.game.SendGoldService;
import cc.ywxm.utils.JSONtool;

/**
 * 发金币模块
 * 
 * @author hdc
 * 
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class SendGoldAction extends BaseAction
{
	private int type = 0;
	private String receiver1;
	private File receiver2;
	private String receiver2ContentType;
	private String receiver2FileName;
	private int gold;

	@Resource
	private SendGoldService sendGoldService;

	/**
	 * ajax 发信
	 * 
	 * @return
	 * @throws IOException
	 * @throws JSONException
	 */
	public String send() throws IOException
	{
		int code = 0;
		switch (type)
		{
		case 0:
			message = "此功能暂未实现";
			break;
		case 1:
			code = sendGoldService.send(receiver1, gold);
			switch (code)
			{
			case 1:
				message = "操作成功";
				break;
			case 2:
				message = "未输入玩家ID，操作失败";
				break;
			default:
				message = "未知错误，操作失败";
				break;
			}
			break;
		case 2:
			code = sendGoldService.send(receiver2, receiver2ContentType, gold);
			switch (code)
			{
			case 1:
				message = "操作成功";
				break;
			case 2:
				message = "数据文件存在无效玩家ID，操作失败";
				break;
			default:
				message = "未知错误，操作失败";
				break;
			}
			break;
		default:
			return NONE;
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
		String jsonString = "";
		List<Closed> list = null;
		switch (type)
		{
		case 1:
			// list = closeService.gets(player);
			break;
		case 2:
			// list = closeService.gets(nickname);
			break;
		default:
			return NONE;
		}
		jsonString = JSONtool.serialize(list);
		response.setContentType("text/xml;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		out.append(jsonString);
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

	public String getReceiver1()
	{
		return receiver1;
	}

	public void setReceiver1(String receiver1)
	{
		this.receiver1 = receiver1;
	}

	public File getReceiver2()
	{
		return receiver2;
	}

	public void setReceiver2(File receiver2)
	{
		this.receiver2 = receiver2;
	}

	public String getReceiver2ContentType()
	{
		return receiver2ContentType;
	}

	public void setReceiver2ContentType(String receiver2ContentType)
	{
		this.receiver2ContentType = receiver2ContentType;
	}

	public String getReceiver2FileName()
	{
		return receiver2FileName;
	}

	public void setReceiver2FileName(String receiver2FileName)
	{
		this.receiver2FileName = receiver2FileName;
	}

	public int getGold()
	{
		return gold;
	}

	public void setGold(int gold)
	{
		this.gold = gold;
	}


}
