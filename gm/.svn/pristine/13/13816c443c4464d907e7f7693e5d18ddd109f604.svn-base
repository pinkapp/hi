package cc.ywxm.action.game;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cc.ywxm.action.PageableAction;
import cc.ywxm.constant.Const;
import cc.ywxm.service.game.BaseInfoService;
import cc.ywxm.service.game.ServerTimeService;

/**
 * 修改服务器时间
 * 
 * @author hdc
 * 
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class ServerTimeEditAction extends PageableAction
{
	private String time;

	@Resource
	private ServerTimeService serverTimeService;

	/**
	 * 修改服务器时间
	 * 
	 * @return
	 * @throws IOException
	 */
	public String edit() throws IOException
	{
		int code = 0;
		code = serverTimeService.edit(time);
		switch (code)
		{
		case BaseInfoService.CODE_SUCCESS:
			message = "操作成功";
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

	public String getTime()
	{
		return time;
	}

	public void setTime(String time)
	{
		this.time = time;
	}

	@Override
	public String execute() throws Exception
	{
		SimpleDateFormat sdf = new SimpleDateFormat(Const.DATE_TIME_PATTERN);
		time = sdf.format(new Date());
		return super.execute();
	}

}
