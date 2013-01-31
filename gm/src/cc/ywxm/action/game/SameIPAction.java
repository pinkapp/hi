package cc.ywxm.action.game;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cc.ywxm.action.BaseAction;
import cc.ywxm.model.game.SameIP;
import cc.ywxm.service.game.SameIPService;
import cc.ywxm.utils.JSONtool;

/**
 * 同IP查询
 * 
 * @author hdc
 * 
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class SameIPAction extends BaseAction
{
	private String qip1;
	private String qip2;
	private String qip;

	@Resource
	private SameIPService sameIPService;

	/**
	 * ajax gets
	 * 
	 * @return
	 * @throws IOException
	 */
	public String gets() throws IOException
	{
		String jsonString = "";
		List<SameIP> list = null;
		list = sameIPService.gets(qip);
		jsonString = JSONtool.serialize(list);
		response.setContentType("text/xml;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		out.append(jsonString);
		out.close();

		return NONE;
	}

	public String getQip1()
	{
		return qip1;
	}

	public void setQip1(String qip1)
	{
		this.qip1 = qip1;
	}

	public String getQip2()
	{
		return qip2;
	}

	public void setQip2(String qip2)
	{
		this.qip2 = qip2;
	}

	public String getQip()
	{
		return qip;
	}

	public void setQip(String qip)
	{
		this.qip = qip;
	}

}
