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
import cc.ywxm.model.platform.RechargeCount1;
import cc.ywxm.service.platform.RechargeCountService;
import cc.ywxm.utils.DateFormat;
import cc.ywxm.utils.JSONtool;

/**
 * 充值玩家统计
 * 
 * @author HuangDeCai
 * @since 2012-12-21 10:54:01
 * 
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class RechargeCount1Action extends PageableAction
{

	@Resource
	private RechargeCountService rechargeCountService;

	@Override
	public String execute() throws Exception
	{
		return super.execute();
	}

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
		String jsonString = JSONtool.serialize(rechargeCountService.gets1());
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
		String result = rechargeCountService.XMLData1();
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
		List<RechargeCount1> list = rechargeCountService.gets1();
		ExportExcel<RechargeCount1> exporter = new ExportExcel<RechargeCount1>();
		OutputStream out = null;
		response.setContentType("octets/stream");
		response.addHeader("Content-Disposition", "attachment;filename="
				+ DateFormat.currentDateFormat("yyyyMMdd") + ".xls");
		out = response.getOutputStream();
		exporter.exportExcel("充值玩家统计", new String[]
		{ "金额范围", "人数" }, list, out, "yyyy-MM-dd");
		out.close();
		return NONE;

	}

}
