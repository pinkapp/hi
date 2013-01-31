package cc.ywxm.action.game;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cc.ywxm.action.PageableAction;
import cc.ywxm.constant.Const;
import cc.ywxm.service.game.PlayerService;

/**
 * 战报查询
 * 
 * @author hdc
 * 
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class PlayerAction extends PageableAction
{
	private Integer player;

	@Resource
	private PlayerService playerService;

	/**
	 * 玩家登录
	 * 
	 * @return
	 */
	public String login() throws IOException
	{
		int code = playerService.login(player);
		if (code == PlayerService.CODE_SUCCESS)
		{
			session.put(Const.SESSION_PLAYER, code);
		}
		message = code + "";
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		out.append(message);
		out.close();
		return NONE;
	}

}
