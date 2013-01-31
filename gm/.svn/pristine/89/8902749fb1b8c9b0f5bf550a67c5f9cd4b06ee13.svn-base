package cc.ywxm.action.game;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.json.JSONException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cc.ywxm.action.BaseAction;
import cc.ywxm.model.game.Prop_;
import cc.ywxm.service.game.PropInfoService;
import cc.ywxm.utils.JSONtool;

/**
 * 玩家道具查询action
 * 
 * @author hdc
 * 
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class PropInfoAction extends BaseAction
{
	private Integer player;
	private Integer id;
	private Short location;
	private Short area;
	private Short amount;
	private Short kind;
	private String nickname;
	private int type = 0;

	@Resource
	private PropInfoService propInfoService;

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
		List<Prop_> list = null;
		switch (type)
		{
		case 1:
			list = propInfoService.gets(player);
			break;
		case 2:
			list = propInfoService.gets(nickname);
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

	public String edit() throws IOException, JSONException
	{
		int code = 0;
		code = propInfoService.edit(nickname, id, location, area, amount, kind);
		switch (code)
		{
		case 0:
			message = "未做修改";
			break;
		case 1:
			message = "修改成功";
			break;
		case 2:
			message = "昵称为空";
			break;
		case 3:
			message = "道具ID为空";
			break;
		case 4:
			message = "区域中的位置为空";
			break;
		case 5:
			message = "区域为空";
			break;
		case 6:
			message = "玩家无此道具";
			break;
		default:
			message = "修改失败,错误码"+code;
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

	public Short getAmount()
	{
		return amount;
	}

	public void setAmount(Short amount)
	{
		this.amount = amount;
	}

	public Short getKind()
	{
		return kind;
	}

	public void setKind(Short kind)
	{
		this.kind = kind;
	}

	public Short getLocation()
	{
		return location;
	}

	public void setLocation(Short location)
	{
		this.location = location;
	}

	public Short getArea()
	{
		return area;
	}

	public void setArea(Short area)
	{
		this.area = area;
	}

}
