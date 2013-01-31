package cc.ywxm.action.gm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.json.JSONException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cc.ywxm.action.BaseAction;
import cc.ywxm.constant.Const;
import cc.ywxm.model.gm.Manager;
import cc.ywxm.model.gm.ManagerType;
import cc.ywxm.service.gm.ManagerService;
import cc.ywxm.service.gm.ManagerTypeService;
import cc.ywxm.utils.JSONtool;

/**
 * 用户类型（角色）功能
 * 
 * @author hdc
 * 
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class ManagerTypeAction extends BaseAction
{
	private Short typeId;
	private String typeName;
	private Boolean valid;
	private String note;
	private String rights;
	private ManagerType managerType;
	@Resource
	private ManagerTypeService managerTypeService;
	@Resource
	private ManagerService managerService;

	/**
	 * 获取用户权限（JSON字符串）
	 * 
	 * @return
	 * @throws IOException
	 * @throws JSONException
	 */
	public String right_gets() throws IOException, JSONException
	{
		Object userId = session.get(Const.SESSION_USERID);
		if (userId == null)
		{
			return LOGIN;
		} else
		{
			Manager user = managerService.get((Integer) userId);
			typeId = Short.parseShort(user.getUserType());

		}
		String result = managerTypeService.right_gets(typeId);
		if (log.isDebugEnabled())
			log.debug(result);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		out.append(result);
		out.close();
		return NONE;
	}

	/**
	 * 角色管理页面
	 * 
	 * @return
	 */
	public String managerType()
	{
		return SUCCESS;
	}

	/**
	 * 角色添加页面
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
		code = managerTypeService.add(typeName, note);
		switch (code)
		{
		case 1:
			message = "添加成功";
			break;
		case 2:
			message = "角色名未空，添加失败";
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
	 * 角色修改页面
	 * 
	 * @return
	 */
	public String edit()
	{
		managerType = managerTypeService.get(typeId);
		return SUCCESS;
	}

	public String doEdit()
	{
		int code = 0;
		code = managerTypeService.edit(typeId, typeName, note);
		switch (code)
		{
		case 1:
			message = "修改成功";
			break;
		case 2:
			message = "角色名未空，修改失败";
			break;
		case 3:
			message = "ID无效";
			break;
		case 4:
			message = "角色不存在";
			break;
		case 5:
			message = "超级管理员角色修改无效";
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
		int code = managerTypeService.remove(typeId);
		switch (code)
		{
		case -1:
			message = "ID无效";
			break;
		case 1:
			message = "删除成功";
			break;
		case 2:
			message = "角色不存在";
			break;
		case 3:
			message = "超级管理员角色删除无效";
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
	 * 系统角色列表（AJAX）
	 * 
	 * @return
	 */
	public String gets()
	{
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out;
		try
		{
			out = response.getWriter();
			List<ManagerType> userTypeTypeList = managerTypeService.gets();
			out.append(JSONtool.serialize(userTypeTypeList));
			out.close();
		} catch (IOException e)
		{
			log.error(e.getMessage());
		}
		return NONE;
	}

	/**
	 * 角色权限分派页面
	 * 
	 * @return
	 */
	public String assign()
	{
		managerType = managerTypeService.get(typeId);
		return SUCCESS;
	}

	/**
	 * 角色权限分派
	 * 
	 * @return
	 */
	public String doAssign()
	{
		int code = managerTypeService.assign(typeId, rights);
		switch (code)
		{
		case -1:
			message = "ID无效";
			break;
		case 1:
			message = "分派成功";
			break;
		case 2:
			message = "角色不存在";
			break;
		case 3:
			message = "超级管理员角色分派无效";
			break;
		default:
			message = "未知错误，分派失败";
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

	public Short getTypeId()
	{
		return typeId;
	}

	public void setTypeId(Short typeId)
	{
		this.typeId = typeId;
	}

	public String getTypeName()
	{
		return typeName;
	}

	public void setTypeName(String typeName)
	{
		this.typeName = typeName;
	}

	public Boolean getValid()
	{
		return valid;
	}

	public void setValid(Boolean valid)
	{
		this.valid = valid;
	}

	public String getNote()
	{
		return note;
	}

	public void setNote(String note)
	{
		this.note = note;
	}

	public ManagerType getUserType()
	{
		return managerType;
	}

	public void setUserType(ManagerType managerType)
	{
		this.managerType = managerType;
	}

	public String getRights()
	{
		return rights;
	}

	public void setRights(String rights)
	{
		this.rights = rights;
	}

}
