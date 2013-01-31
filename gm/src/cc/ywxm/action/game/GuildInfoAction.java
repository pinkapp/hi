package cc.ywxm.action.game;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.json.JSONException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cc.ywxm.action.BaseAction;
import cc.ywxm.model.game.Guild;
import cc.ywxm.service.game.GuildInfoService;
import cc.ywxm.utils.JSONtool;

/**
 * 玩家公会信息
 * 
 * @author hdc
 * 
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class GuildInfoAction extends BaseAction
{
	private String name;

	@Resource
	private GuildInfoService guildInfoService;

	/**
	 * ajax gets
	 * 
	 * @return
	 * @throws IOException
	 * @throws JSONException
	 */
	public String gets() throws IOException
	{
		String jsonString = "";
		List<Guild> list = null;
		list = guildInfoService.gets(name);
		jsonString = JSONtool.serialize(list);
		//System.out.println(jsonString);
		response.setContentType("text/xml;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		out.append(jsonString);
		out.close();

		return NONE;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	
}
