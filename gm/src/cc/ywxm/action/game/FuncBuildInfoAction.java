package cc.ywxm.action.game;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cc.ywxm.action.BaseAction;
import cc.ywxm.service.game.BuildInfoService;

/**
 * 玩家建筑信息
 * 
 * @author HuangDecai
 * @since 2012-12-10 14:18:59
 * 
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class FuncBuildInfoAction extends BaseAction
{
	private Integer player;
	private String nickname;
	private Integer id;
	private Short kind;
	private Short x;
	private Short y;
	private Short aspect;
	private Short level;
	private Short progress;
	private String lastReap;
	private int type = 0;

	@Resource
	private BuildInfoService buildInfoService;

	/**
	 * ajax gets
	 * 
	 * @return
	 * @throws IOException
	 */
	public String gets() throws IOException
	{
		String jsonString = "";
		response.setContentType("text/xml;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		out.append(jsonString);
		out.close();

		return NONE;
	}

	public String edit() throws IOException
	{
		int code = buildInfoService.edit(nickname, id, kind, x, y, aspect,
				level, progress, lastReap);
		switch (code)
		{
		case 0:
			message = "未做修改";
			break;
		case 1:
			message = "修改成功";
			break;
		case 2:
			message = "玩家昵称为空";
			break;
		case 3:
			message = "建筑ID为空";
			break;
		case 4:
			message = "不存在的玩家昵称";
			break;
		case 5:
			message = "玩家无此建筑";
			break;
		case 6:
			message = "最后一次收获时间格式错误";
			break;
		default:
			message = "修改失败，错误码：" + code;
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

	public int getType()
	{
		return type;
	}

	public void setType(int type)
	{
		this.type = type;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Short getKind()
	{
		return kind;
	}

	public void setKind(Short kind)
	{
		this.kind = kind;
	}

	public Short getX()
	{
		return x;
	}

	public void setX(Short x)
	{
		this.x = x;
	}

	public Short getY()
	{
		return y;
	}

	public void setY(Short y)
	{
		this.y = y;
	}

	public Short getAspect()
	{
		return aspect;
	}

	public void setAspect(Short aspect)
	{
		this.aspect = aspect;
	}

	public Short getLevel()
	{
		return level;
	}

	public void setLevel(Short level)
	{
		this.level = level;
	}

	public Short getProgress()
	{
		return progress;
	}

	public void setProgress(Short progress)
	{
		this.progress = progress;
	}

	public String getLastReap()
	{
		return lastReap;
	}

	public void setLastReap(String lastReap)
	{
		this.lastReap = lastReap;
	}

}
