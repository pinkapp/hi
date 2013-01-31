package cc.ywxm.action.game;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cc.ywxm.action.PageableAction;
import cc.ywxm.constant.Const;
import cc.ywxm.service.game.BaseInfoService;
import cc.ywxm.service.gm.OperateLogService;
import cc.ywxm.utils.WebUtils;

/**
 * 玩家基本信息
 * 
 * @author hdc
 * 
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class BaseInfoEditAction extends PageableAction
{
	private String player;
	private String prop;
	private int operate = 1;
	private int value;

	@Resource
	private BaseInfoService baseInfoService;
	@Resource
	private OperateLogService operateLogService;

	/**
	 * 修改玩家基本信息
	 * 
	 * @return
	 * @throws IOException
	 */
	public String edit() throws IOException
	{
		String operator = (String) session.get(Const.SESSION_USERNAME);
		if ("gold".equals(prop))
		{
			operateLogService.add("修改玩家金币", operator, WebUtils
					.getIpAddr(request));
		} else if ("silver".equals(prop))
		{
			operateLogService.add("修改玩家银币", operator, WebUtils
					.getIpAddr(request));
		} else if ("energy".equals(prop))
		{
			operateLogService.add("修改玩家能量", operator, WebUtils
					.getIpAddr(request));
		} else if ("mobility".equals(prop))
		{
			operateLogService.add("修改玩家行动力", operator, WebUtils
					.getIpAddr(request));
		} else if ("progress".equals(prop))
		{
			operateLogService.add("修改玩家主线进度", operator, WebUtils
					.getIpAddr(request));
		} else if ("feat".equals(prop))
		{
			operateLogService.add("修改玩家功绩", operator, WebUtils
					.getIpAddr(request));
		} else if ("prestige".equals(prop))
		{
			operateLogService.add("修改玩家威望", operator, WebUtils
					.getIpAddr(request));
		} else
		{
			operateLogService.add("修改玩家" + prop, operator, WebUtils
					.getIpAddr(request));
		}
		int code = 0;
		code = baseInfoService.edit(player, prop, value);
		switch (code)
		{
		case BaseInfoService.CODE_SUCCESS:
			message = "操作成功";
			break;
		case BaseInfoService.CODE_ZMQ_NORESPONSE:
			message = "服务器无响应，稍后再试";
			break;
		case BaseInfoService.CODE_PLAYER_NOT_EXIST:
			message = "玩家不存在";
			break;
		case BaseInfoService.CODE_FAIL:
			message = "操作失败";
			break;
		default:
			message = "操作失败，错误码：" + code;
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

	public int getOperate()
	{
		return operate;
	}

	public void setOperate(int operate)
	{
		this.operate = operate;
	}

	public int getValue()
	{
		return value;
	}

	public void setValue(int value)
	{
		this.value = value;
	}

	public BaseInfoService getBaseInfoService()
	{
		return baseInfoService;
	}

	public void setBaseInfoService(BaseInfoService baseInfoService)
	{
		this.baseInfoService = baseInfoService;
	}

	public String getProp()
	{
		return prop;
	}

	public void setProp(String prop)
	{
		this.prop = prop;
	}

}
