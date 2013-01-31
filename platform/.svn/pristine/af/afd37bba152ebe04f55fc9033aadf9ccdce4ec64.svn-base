package cc.ywxm.action;

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
public class RegAction extends PageableAction
{

	private String username;
	private String password;
	@Resource
	private UserService userService;
	@Resource
	private OperateLogService operateLogService;

	/**
	 * 账号注册
	 * 
	 * @return
	 */
	public String reg()
	{
		operateLogService.add("玩家注册", username, WebUtils.getIpAddr(request));
		int code = 0;
		code = userService.reg(username, password);
		switch (code)
		{
		case 1:
			message = "注册成功";
			Integer userId = userService.findByUsername(username).getUserId();
			session.put(Const.SESSION_USERID, userId);
			Cookie cookie = new Cookie(Const.COOKIE_NAME_LOGINUSER, userId + "");
			cookie.setPath("/");
			response.addCookie(cookie);
			return SUCCESS;
		default:
			message = "注册失败，错误码" + code;
			return INPUT;
		}
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

}
