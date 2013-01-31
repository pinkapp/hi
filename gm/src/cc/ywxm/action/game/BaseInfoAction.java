package cc.ywxm.action.game;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;

import org.apache.struts2.json.JSONException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cc.ywxm.action.PageableAction;
import cc.ywxm.service.game.BaseInfoService;
import cc.ywxm.utils.JSONtool;

/**
 * 玩家基本信息
 * 
 * @author hdc
 * 
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class BaseInfoAction extends PageableAction
{
	private Integer player;
	private String nickname;

	@Resource
	private BaseInfoService baseInfoService;

	/**
	 * ajax 玩家基本信息查询
	 * 
	 * @return
	 * @throws IOException
	 * @throws JSONException
	 */
	public String gets() throws IOException, JSONException
	{
		response.setContentType("text/xml;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		String jsonString = JSONtool.serialize(baseInfoService.gets(rows, page,
				sort, order, nickname));
		out.append(jsonString);
		out.close();

		return NONE;
	}

	public Integer getPlayer()
	{
		return player;
	}

	public void setPlayer(Integer player)
	{
		this.player = player;
	}

	public String getNickname()
	{
		return nickname;
	}

	public void setNickname(String nickname)
	{
		this.nickname = nickname;
	}

}
