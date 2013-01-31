package cc.ywxm.action.game;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cc.ywxm.action.PageableAction;
import cc.ywxm.service.game.BattleRecordService;

/**
 * 战报查询
 * 
 * @author hdc
 * 
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class BattleRecordAction extends PageableAction
{
	private Integer id;

	@Resource
	private BattleRecordService battleRecordService;

	/**
	 * 获取战报
	 * 
	 * @return
	 */
	public String get() throws IOException
	{
		if (id == null)
		{
			message = "id is null";
			response.setContentType("text/html;charset=utf-8");
			response.setHeader("Cache-Control", "no-cache");
			PrintWriter out = response.getWriter();
			out.append(message);
			out.close();
		} else
		{
			byte[] record = battleRecordService.get(id);
			OutputStream out = null;
			response.setContentType("octets/stream");
			response.addHeader("Content-Disposition",
					"attachment;filename=record");
			out = response.getOutputStream();
			out.write(record);
			out.close();
		}
		return NONE;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

}
