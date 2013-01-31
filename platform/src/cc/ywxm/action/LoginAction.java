package cc.ywxm.action;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cc.ywxm.action.base.PageableAction;
import cc.ywxm.constant.Const;
import cc.ywxm.service.OperateLogService;
import cc.ywxm.service.UserService;
import cc.ywxm.utils.WebUtils;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class LoginAction extends PageableAction
{

	private String username;
	private String password;
	private String rand = "";

	@Resource
	private UserService userService;
	@Resource
	private OperateLogService operateLogService;

	/**
	 * 账号登录
	 * 
	 * @return
	 * @throws IOException
	 */
	public String login() throws IOException
	{
		// org.springframework.web.util.WebUtils.getCookie(request, "");
		// if (session.get(Const.AUTH_CODE) == null)
		// {
		// return INPUT;
		// }
		// if (!session.get(Const.AUTH_CODE).equals(rand))
		// {
		// message = "验证码错误,登录失败";
		// return INPUT;
		// }
		// int code = userService.login(username, password);
		// String loginIp = WebUtils.getIpAddr(request);
		operateLogService.add("玩家登录", username, WebUtils.getIpAddr(request));
		int code = userService.login(username, password, null);
		switch (code)
		{
		case 1:
			message = "登录成功";
			break;
		default:
			message = "登录失败，错误代码：" + code;
			break;
		}
		if (code != 1)
		{
			return INPUT;
		}
		Integer userId = userService.findByUsername(username).getUserId();
		// 把参数放到session中
		session.put(Const.SESSION_USERID, userId);
		session.put(Const.SESSION_USERNAME, username);
		Cookie cookie = new Cookie(Const.COOKIE_NAME_LOGINUSER, userId + "");
		cookie.setPath("/");
		response.addCookie(cookie);
		// response.sendRedirect("/");
		// 论坛同步
		// /ucsyn = userService.uc_user_synlogin(username, password);
		// System.out.println("discuz：" + ucsyn);
		// 游戏客户端同步
		// syncString = userService.server_user_synlogin(username, password);

		// System.out.println(syncString);
		return SUCCESS;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getRand()
	{
		return rand;
	}

	public void setRand(String rand)
	{
		this.rand = rand;
	}

}
