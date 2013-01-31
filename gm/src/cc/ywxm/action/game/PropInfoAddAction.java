package cc.ywxm.action.game;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;

import org.apache.struts2.json.JSONException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cc.ywxm.action.BaseAction;
import cc.ywxm.constant.Const;
import cc.ywxm.service.game.PropInfoService;
import cc.ywxm.service.gm.OperateLogService;
import cc.ywxm.utils.WebUtils;

/**
 * 玩家道具查询action
 * 
 * @author hdc
 * 
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class PropInfoAddAction extends BaseAction
{
	private String player;
	private Integer sid;
	private Integer amount;

	@Resource
	private PropInfoService propInfoService;
	@Resource
	private OperateLogService operateLogService;

	public String add() throws IOException, JSONException
	{
		String operator = (String) session.get(Const.SESSION_USERNAME);
		operateLogService.add("添加玩家道具", operator, WebUtils.getIpAddr(request));
		int code = 0;
		code = propInfoService.add(player, sid, amount);
		switch (code)
		{
		case PropInfoService.CODE_FAIL:
			message = "修改失败";
			break;
		case PropInfoService.CODE_SUCCESS:
			message = "修改成功";
			break;
		case PropInfoService.CODE_PLAYER_NOT_EXIST:
			message = "修改失败，玩家不存在";
			break;
		default:
			message = "修改失败,错误码" + code;
			break;
		}
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		out.append(message);
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

	public Integer getSid()
	{
		return sid;
	}

	public void setSid(Integer sid)
	{
		this.sid = sid;
	}

	public Integer getAmount()
	{
		return amount;
	}

	public void setAmount(Integer amount)
	{
		this.amount = amount;
	}

}
