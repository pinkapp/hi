package cc.ywxm.action.platform;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cc.ywxm.action.PageableAction;
import cc.ywxm.excel.ExportExcel;
import cc.ywxm.model.platform.RechargeRank;
import cc.ywxm.service.platform.RechargeRankService;
import cc.ywxm.utils.DateFormat;
import cc.ywxm.utils.JSONtool;

/**
 * 玩家充值排行
 * 
 * @author HuangDeCai
 * @since 2012-12-17 13:23:28
 * 
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class RechargeRankAction extends PageableAction
{

	@Resource
	private RechargeRankService rechargeRankService;

	/**
	 * 查询
	 * 
	 * @return
	 * @throws IOException
	 */
	public String gets() throws IOException
	{
		response.setContentType("text/xml;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		String jsonString = JSONtool.serialize(rechargeRankService.gets());
		out.append(jsonString);
		out.close();

		return NONE;
	}

	/**
	 * 图表
	 * 
	 * @return
	 * @throws IOException
	 */
	public String chart() throws IOException
	{
		String result = rechargeRankService.XMLData();
		log.debug(result);
		response.setContentType("text/xml;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		out.append(JSONtool.serialize(result));
		out.close();
		return NONE;
	}

	/**
	 * 导出
	 * 
	 * @return
	 * @throws IOException
	 */
	public String export() throws IOException
	{
		List<RechargeRank> list = rechargeRankService.gets();
		ExportExcel<RechargeRank> exporter = new ExportExcel<RechargeRank>();
		OutputStream out = null;
		response.setContentType("octets/stream");
		response.addHeader("Content-Disposition", "attachment;filename="
				+ DateFormat.currentDateFormat("yyyyMMdd") + ".xls");
		out = response.getOutputStream();
		exporter.exportExcel("玩家充值排行", new String[]
		{ "玩家昵称", "总金额", "排名" }, list, out, "yyyy-MM-dd");
		out.close();
		return NONE;

	}

}
