package cc.ywxm.action.game;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.json.JSONException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cc.ywxm.action.BaseAction;
import cc.ywxm.model.game.Hero;
import cc.ywxm.service.game.HeroInfoService;
import cc.ywxm.utils.JSONtool;

/**
 * 玩家英雄信息
 * 
 * @author hdc
 * 
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class HeroInfoAction extends BaseAction
{
	private String player;

	@Resource
	private HeroInfoService heroInfoService;

	/**
	 * ajax gets
	 * 
	 * @return
	 * @throws IOException
	 */
	public String gets() throws IOException
	{
		String jsonString = "";
		List<Hero> heroList = null;
		heroList = heroInfoService.gets(player);
		jsonString = JSONtool.serialize(heroList);
		response.setContentType("text/xml;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		out.append(jsonString);
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

}
