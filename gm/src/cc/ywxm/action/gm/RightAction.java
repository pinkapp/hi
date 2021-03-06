package cc.ywxm.action.gm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cc.ywxm.action.BaseAction;
import cc.ywxm.model.gm.Right;
import cc.ywxm.service.gm.RightService;

/**
 * 权限功能
 * 
 * @author hdc
 * 
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class RightAction extends BaseAction
{
	private Integer rightId;
	private String rightName;
	private String iconCls;
	private String rlink;
	private String rdesc;
	private Integer parentId;
	private Integer rseq;
	private Boolean valid;
	private Right right;
	@Resource
	private RightService rightService;

	/**
	 * 权限管理页面
	 * 
	 * @return
	 */
	public String right()
	{
		return SUCCESS;
	}

	/**
	 * 权限添加页面
	 * 
	 * @return
	 */
	public String add()
	{
		return SUCCESS;
	}

	/**
	 * 添加
	 * 
	 * @return
	 * @throws IOException
	 */
	public String doAdd()
	{
		int code = 0;
		code = rightService.add(rightName, iconCls, rlink, rdesc, parentId,
				rseq);
		switch (code)
		{
		case -1:
			message = "上级未设置，添加失败";
			break;
		case 1:
			message = "添加成功";
			break;
		case 2:
			message = "上级不存在，添加失败";
			break;
		case 3:
			message = "名称为空，添加失败";
			break;
		default:
			message = "未知错误，添加失败";
			break;
		}

		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out;
		try
		{
			out = response.getWriter();
			out.append(message);
			out.close();
		} catch (IOException e)
		{
			log.error(e.getMessage());
		}
		return NONE;
	}

	/**
	 * 权限修改页面
	 * 
	 * @return
	 */
	public String edit()
	{
		right = rightService.get(rightId);
		return SUCCESS;
	}

	public String doEdit()
	{
		int code = 0;
		code = rightService.edit(rightId, rightName, iconCls, rlink, rdesc,
				parentId, rseq, valid);
		switch (code)
		{
		case 1:
			message = "修改成功";
			break;
		case 2:
			message = "名称未空，修改失败";
			break;
		case 3:
			message = "ID无效";
			break;
		case 4:
			message = "权限不存在";
			break;
		default:
			message = "未知错误，修改失败";
			break;
		}
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out;
		try
		{
			out = response.getWriter();
			out.append(message);
			out.close();
		} catch (IOException e)
		{
			log.error(e.getMessage());
		}
		return NONE;
	}

	public String remove()
	{
		int code = 0;
		code = rightService.remove(rightId);
		switch (code)
		{
		case -1:
			message = "ID无效";
			break;
		case 1:
			message = "删除成功";
			break;
		case 2:
			message = "权限不存在";
			break;
		case 3:
			message = "ID 1-5被保护不能删除";
			break;
		case 4:
			message = "包含子权限，删除失败";
			break;
		default:
			message = "未知错误，删除失败";
			break;
		}
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out;
		try
		{
			out = response.getWriter();
			out.append(message);
			out.close();
		} catch (IOException e)
		{
			log.error(e.getMessage());
		}
		return NONE;
	}

	/**
	 * 权限列表（AJAX）
	 * 
	 * @return
	 */
	public String gets()
	{
		String result = "";
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		result = rightService.gets();
		if (log.isDebugEnabled())
			log.debug(result);
		PrintWriter out;
		try
		{
			out = response.getWriter();
			out.append(result);
			out.close();
		} catch (IOException e)
		{
			log.error(e.getMessage());
		}
		return NONE;
	}

	public String gets_()
	{
		String result = "";
		result = rightService.gets_();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out;
		try
		{
			out = response.getWriter();
			out.append(result);
			out.close();
		} catch (IOException e)
		{
			log.error(e.getMessage());
		}
		return NONE;
	}

	public Integer getRightId()
	{
		return rightId;
	}

	public void setRightId(Integer rightId)
	{
		this.rightId = rightId;
	}

	public String getRightName()
	{
		return rightName;
	}

	public void setRightName(String rightName)
	{
		this.rightName = rightName;
	}

	public String getIconCls()
	{
		return iconCls;
	}

	public void setIconCls(String iconCls)
	{
		this.iconCls = iconCls;
	}

	public String getRlink()
	{
		return rlink;
	}

	public void setRlink(String rlink)
	{
		this.rlink = rlink;
	}

	public String getRdesc()
	{
		return rdesc;
	}

	public void setRdesc(String rdesc)
	{
		this.rdesc = rdesc;
	}

	public Integer getParentId()
	{
		return parentId;
	}

	public void setParentId(Integer parentId)
	{
		this.parentId = parentId;
	}

	public Integer getRseq()
	{
		return rseq;
	}

	public void setRseq(Integer rseq)
	{
		this.rseq = rseq;
	}

	public Boolean getValid()
	{
		return valid;
	}

	public void setValid(Boolean valid)
	{
		this.valid = valid;
	}

	public Right getRight()
	{
		return right;
	}

	public void setRight(Right right)
	{
		this.right = right;
	}

}
