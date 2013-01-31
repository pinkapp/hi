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
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private static final long serialVersionUID = 6783914372473093519L;
	private List<String> actions = new ArrayList<String>();

	public void destroy()
	{

	}

	public void init()
	{
		actions.add("/do/login");
		actions.add("/get/battleRecord");
	}

	/**
	 * 安全拦截器，防止非法操作
	 */
	public String intercept(ActionInvocation actionInvocation) throws Exception
	{
		Map<String, Object> session = actionInvocation.getInvocationContext()
				.getSession();
		String servletPath = ServletActionContext.getRequest().getServletPath();
		if (actions.contains(servletPath))
		{
			logger.info("访问路径:" + servletPath + "通过，因为未拦截");
			return actionInvocation.invoke();
		}

		Object userId = session.get(Const.SESSION_USERID);
		if (userId != null)
		{
			logger.info("访问路径:" + servletPath + "通过，因为已经登录");
			return actionInvocation.invoke();
		} else
		{
			logger.info("访问路径:" + servletPath + "未通过，因为没有登录");
			return "login";
		}
	}
}
