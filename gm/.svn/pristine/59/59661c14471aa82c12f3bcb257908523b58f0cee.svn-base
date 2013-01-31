package cc.ywxm.action.game;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;

import org.apache.struts2.json.JSONException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cc.ywxm.action.PageableAction;
import cc.ywxm.service.game.BaseInfoService;

/**
 * 创建玩家
 * 
 * @author hdc
 * 
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class CreatePlayerAction extends PageableAction
{
	private Integer player;
	private String nickname;
	private Integer sex;

	@Resource
	private BaseInfoService baseInfoService;

	public String create() throws IOException, JSONException
	{
		int code = 0;
		code = baseInfoService.add(nickname, sex);
		switch (code)
		{
		case 1:
			message = "创建成功";
			break;
		case 2:
			message = "昵称为空，创建失败";
			break;
		case 3:
			message = "昵称重复，创建失败";
			break;

		default:
			message = "创建失败，错误码：" + code;
			break;
		}
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		out.append(message);
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

	public Integer getSex()
	{
		return sex;
	}

	public void setSex(Integer sex)
	{
		this.sex = sex;
	}

}
