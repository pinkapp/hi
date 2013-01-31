package cc.ywxm.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class BaseAction extends ActionSupport implements ServletRequestAware,
		ServletResponseAware, SessionAware
{
	protected Logger log = Logger.getLogger(this.getClass());
	protected String message = "";
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected Map<String, Object> session;
	protected String sort;
	protected String order;

	public String getSort()
	{
		return sort;
	}

	public void setSort(String sort)
	{
		this.sort = sort;
	}

	public String getOrder()
	{
		return order;
	}

	public void setOrder(String order)
	{
		this.order = order;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public void setServletRequest(HttpServletRequest request)
	{
		this.request = request;
	}

	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}

	public void setServletResponse(HttpServletResponse response)
	{
		this.response = response;
	}

}
