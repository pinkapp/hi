package cc.ywxm.action.game;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;

import org.apache.struts2.json.JSONException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cc.ywxm.action.BaseAction;
import cc.ywxm.constant.Const;
import cc.ywxm.service.game.BaseInfoService;
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
public class PlayerRechargeAction extends BaseAction
{
	private String player;
	private Integer value;

	@Resource
	private BaseInfoService baseInfoService;
	@Resource
	private OperateLogService operateLogService;

	public String recharge() throws IOException, JSONException
	{
		String operator = (String) session.get(Const.SESSION_USERNAME);
		operateLogService.add("玩家充值", operator, WebUtils.getIpAddr(request));
		int code = 0;
		code = baseInfoService.edit(player, "recharged", value);
		switch (code)
		{
		case BaseInfoService.CODE_FAIL:
			message = "充值失败";
			break;
		case BaseInfoService.CODE_SUCCESS:
			message = "充值成功";
			break;
		case BaseInfoService.CODE_ZMQ_NORESPONSE:
			message = "服务器无响应，稍后再试";
			break;
		case PropInfoService.CODE_PLAYER_NOT_EXIST:
			message = "充值失败，玩家不存在";
			break;
		default:
			message = "充值失败,错误码" + code;
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

	public Integer getValue()
	{
		return value;
	}

	public void setValue(Integer value)
	{
		this.value = value;
	}

	public OperateLogService getOperateLogService()
	{
		return operateLogService;
	}

	public void setOperateLogService(OperateLogService operateLogService)
	{
		this.operateLogService = operateLogService;
	}

}
