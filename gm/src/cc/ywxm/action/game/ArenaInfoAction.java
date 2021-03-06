package cc.ywxm.action.game;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cc.ywxm.action.BaseAction;
import cc.ywxm.model.game.ArenaInfo;
import cc.ywxm.service.game.ArenaInfoService;
import cc.ywxm.utils.JSONtool;

/**
 * 竞技场查询
 * 
 * @author hdc
 * 
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class ArenaInfoAction extends BaseAction
{
	private String nickname;

	@Resource
	private ArenaInfoService arenaInfoService;

	/**
	 * ajax gets
	 * 
	 * @return
	 * @throws IOException
	 */
	public String gets() throws IOException
	{
		String jsonString = "";
		List<ArenaInfo> list = null;
		// System.out.println(qdate1);
		// System.out.println(qdate2);
		list = arenaInfoService.gets(nickname);
		jsonString = JSONtool.serialize(list);
		System.out.println(jsonString);
		response.setContentType("text/xml;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		out.append(jsonString);
		out.close();

		return NONE;
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
