package cc.ywxm.interceptor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import cc.ywxm.constant.Const;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

@Component
public class SafeInterceptor implements Interceptor
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6783914372473093519L;
	private List<String> servletPaths = new ArrayList<String>();
	private Logger log = LoggerFactory.getLogger(this.getClass());

	// private List<String> urls = new ArrayList<String>();// 白名单
	// @Resource
	// private UserService userService;

	public void destroy()
	{

	}

	public void init()
	{

	}

	/**
	 * 登录拦截器，权限拦截器（/admin）
	 */
	public String intercept(ActionInvocation actionInvocation) throws Exception
	{

		servletPaths.add("/login");// 登录
		servletPaths.add("/logout");
		servletPaths.add("/reg");// 注册
		servletPaths.add("/.action");// 首页
		servletPaths.add("/");// 首页
		servletPaths.add("/game");
		servletPaths.add("/service");
		servletPaths.add("/rand");// 生成验证码图片
		servletPaths.add("/resource_change");
		servletPaths.add("/get/gameServer");
		servletPaths.add("/ftpasswd");
		
		String servletPath = ServletActionContext.getRequest().getServletPath();
		log.info(servletPath);
		if (servletPaths.contains(servletPath))
		{
			return actionInvocation.invoke();
		}
		// 确认Session中是否存在LOGIN
		Map<String, Object> session = actionInvocation.getInvocationContext()
				.getSession();
		if (session.containsKey(Const.SESSION_USERID))
		{
			return actionInvocation.invoke();
		} else
		{
			return "login";
		}
	}

	/*
	 * private int autoLogin(HttpServletRequest request) { Map<String, Object>
	 * map = null; Cookie[] cookies = request.getCookies(); if (cookies != null)
	 * { for (Cookie cookie : cookies) { System.out.println("cookie: " +
	 * cookie.getName() + ":" + cookie.getValue()); if
	 * (Const.COOKIE_NAME_LOGINUSER.equals(cookie.getName())) { String value =
	 * cookie.getValue(); if (value != "") { map = userService.decrypt(value); }
	 * } } } if (map == null) { return 2; } String username = (String)
	 * map.get("username"); String password = (String) map.get("password");
	 * String loginIp = WebUtils.getIpAddr(request); int code =
	 * userService.login(username, password, loginIp); if (code != 1) { return
	 * 3; } Integer userId = userService.findByUsername(username).getUserId();
	 * HttpSession session = request.getSession();
	 * session.setAttribute(Const.SESSION_USERID, userId); return 1; }
	 */
}
