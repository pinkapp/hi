package cc.ywxm.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cc.ywxm.action.base.PageableAction;
import cc.ywxm.model.GameServer;
import cc.ywxm.service.GameServerService;
import cc.ywxm.service.OperateLogService;
import cc.ywxm.utils.WebUtils;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class GameServerAction extends PageableAction
{

	private Integer serverId;
	@Resource
	private GameServerService gameServerService;
	@Resource
	private OperateLogService operateLogService;

	/**
	 * 账号注册
	 * 
	 * @return
	 * @throws IOException 
	 */
	public String get() throws IOException
	{
		String result = "";
		operateLogService.add("获取服务器信息", "匿名", WebUtils.getIpAddr(request));
		try
		{
			GameServer server = gameServerService.get(serverId);
			JSONObject jsonObject = new JSONObject(server);
			result = jsonObject.toString();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		response.setContentType("text/xml;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		out.append(result);
		out.close();
		return NONE;
	}

	public Integer getServerId()
	{
		return serverId;
	}

	public void setServerId(Integer serverId)
	{
		this.serverId = serverId;
	}

}
