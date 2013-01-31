package cc.ywxm.action.game;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.annotation.Resource;

import org.apache.commons.io.FilenameUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cc.ywxm.action.BaseAction;
import cc.ywxm.service.game.KickService;

/**
 * 踢人
 * 
 * @author hdc
 * 
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class KickAction extends BaseAction
{
	private int type = 0;
	private String player;
	private File data;
	private String dataContentType;
	private String dataFileName;

	@Resource
	private KickService kickService;

	@Override
	public String execute() throws Exception
	{
		return super.execute();
	}

	/**
	 * ajax 踢人
	 * 
	 * @return
	 * @throws IOException
	 */
	public String kick() throws IOException
	{
		int code = 0;
		if (type == 1)
		{
			code = kickService.kick(player);
		} else if (type == 2)
		{
			log.debug(dataFileName);
			code = kickService.kick(data, FilenameUtils
					.getExtension(dataFileName));

		} else if (type == 3)
		{

			code = kickService.kick();
		} else
		{
		}
		switch (code)
		{
		case KickService.CODE_FILE_NULL:
			message = "未选择文件";
			break;
		case KickService.CODE_FILEEXT_NOT_SUPPORT:
			message = "不支持的文件扩展名";
			break;
		case KickService.CODE_SUCCESS:
			message = "操作成功";
			break;
		case KickService.CODE_ZMQ_TIMEOUT:
			message = "与服务器连接超时";
			break;
		case KickService.CODE_FAIL:
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

	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	public String template() throws IOException
	{
		String root = System.getProperty("gm.root");
		log.debug(root);
		File file = new File(root + "template/", "tplt001.csv");
		FileInputStream in = new FileInputStream(file);
		OutputStream out = null;
		response.setContentType("octets/stream");
		response.addHeader("Content-Disposition", "attachment;filename="
				+ "template001.csv");
		out = response.getOutputStream();
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = in.read(buffer)) != -1)
		{
			out.write(buffer, 0, len);
		}
		in.close();
		out.close();
		return NONE;
	}

	public int getType()
	{
		return type;
	}

	public void setType(int type)
	{
		this.type = type;
	}

	public File getData()
	{
		return data;
	}

	public void setData(File data)
	{
		this.data = data;
	}

	public String getDataContentType()
	{
		return dataContentType;
	}

	public void setDataContentType(String dataContentType)
	{
		this.dataContentType = dataContentType;
	}

	public String getDataFileName()
	{
		return dataFileName;
	}

	public void setDataFileName(String dataFileName)
	{
		this.dataFileName = dataFileName;
	}

	public String getPlayer()
	{
		return player;
	}

	public void setPlayer(String player)
	{
		this.player = player;
	}

}
