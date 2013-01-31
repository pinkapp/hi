package cc.ywxm.action.game;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.annotation.Resource;

import org.apache.commons.io.FilenameUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cc.ywxm.action.PageableAction;
import cc.ywxm.service.game.KeywordsSettingService;

/**
 * 关键字设置
 * 
 * @author HuangDecai
 * @since 2013-1-12 10:13:15
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class KeywordsSettingAction extends PageableAction
{
	private int type = 0;
	private String keywords;
	private File data;
	private String dataContentType;
	private String dataFileName;
	private int option;

	@Resource
	private KeywordsSettingService keywordsSettingService;

	public String get() throws IOException
	{
		byte[] data = keywordsSettingService.get();
		response.setContentType("octets/stream");
		response.addHeader("Content-Disposition",
				"attachment;filename=keywords.csv");
		OutputStream out = response.getOutputStream();
		out.write(data);
		out.close();
		return NONE;
	}

	/**
	 * 关键字设置
	 * 
	 * @return
	 */
	public String setting() throws IOException
	{
		int code = 0;
		if (type == 1)
		{
			code = keywordsSettingService.setting(keywords);
		} else if (type == 2)
		{
			code = keywordsSettingService.setting(data, FilenameUtils
					.getExtension(dataFileName), option);

		} else
		{
		}
		switch (code)
		{
		case KeywordsSettingService.CODE_FILE_NULL:
			message = "未选择文件";
			break;
		case KeywordsSettingService.CODE_FILEEXT_NOT_SUPPORT:
			message = "不支持的文件扩展名";
			break;
		case KeywordsSettingService.CODE_SUCCESS:
			message = "操作成功";
			break;
		case KeywordsSettingService.CODE_ZMQ_TIMEOUT:
			message = "与服务器连接超时";
			break;
		case KeywordsSettingService.CODE_FAIL:
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

	public String getKeywords()
	{
		return keywords;
	}

	public void setKeywords(String keywords)
	{
		this.keywords = keywords;
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

	public int getOption()
	{
		return option;
	}

	public void setOption(int option)
	{
		this.option = option;
	}

	public int getType()
	{
		return type;
	}

	public void setType(int type)
	{
		this.type = type;
	}

}
