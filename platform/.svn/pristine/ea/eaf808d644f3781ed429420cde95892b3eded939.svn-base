package cc.ywxm.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cc.ywxm.action.base.BaseAction;
import cc.ywxm.model.Game;
import cc.ywxm.model.GameServer;
import cc.ywxm.service.GameServerService;
import cc.ywxm.service.GameService;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class LinkGameAction extends BaseAction
{
	private Integer serverId;
	private String src;

	@Resource
	private GameServerService gameServerService;
	@Resource
	private GameService gameService;

	@Override
	public String execute()
	{
		Game game = null;
		try
		{
			GameServer server = gameServerService.get(serverId);
			Integer gameId = server.getGameId();
			game = gameService.get(gameId);
			response.sendRedirect(game.getGameUrl() + "?src=" + src + "&serverId="
					+ serverId);
		} catch (Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
		return NONE;
	}

	public String getSrc()
	{
		return src;
	}

	public void setSrc(String src)
	{
		this.src = src;
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
