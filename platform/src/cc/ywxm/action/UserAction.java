package cc.ywxm.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cc.ywxm.action.base.PageableAction;
import cc.ywxm.constant.Const;
import cc.ywxm.service.UserService;
import cc.ywxm.utils.RandomUtils;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class UserAction extends PageableAction
{
	
	private Integer userId;
	private String username;
	private String password;
	private String email;
	private String phone;
	private String spasswd;

	private boolean exist = false;
	private String rand = "";
	private String term;

	@Resource
	private UserService userService;

	/**
	 * 检查账号名是否存在
	 * 
	 * @return
	 */
	public String checkUsername()
	{
		exist = userService.checkUsername(username);
		return SUCCESS;
	}

	/**
	 * 搜索用户名
	 * 
	 * @return
	 */
	public String searchUsername()
	{
		if (term == null)
			return null;
		term = term.trim().toLowerCase();
		List<String> usernames = userService.findUsersByUsername(term);
		String jsonString = "";
		try
		{
			jsonString = JSONUtil.serialize(usernames);
			//System.out.println("ssss" + jsonString);
		} catch (JSONException e1)
		{
			e1.printStackTrace();
		}
		response.setCharacterEncoding("utf-8");
		try
		{
			PrintWriter out = response.getWriter();
			out.append(jsonString);
			out.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 检查电子邮件是否存在
	 * 
	 * @return
	 */
	public String checkEmail()
	{
		exist = userService.checkEmail(email);
		return SUCCESS;

	}

	/**
	 * 手机验证发送手机验证码
	 * 
	 * @return
	 */
	public String sendMobileVerifyCode()
	{
		String vc = RandomUtils.randString(6);
		String[] strs = new String[2];
		strs[1] = vc;
		userService.sendVerifyCodeByPhone(phone, strs);
		System.out.println("已通过手机" + phone + "发送验证码：" + vc);
		session.put(Const.MOBILE_VERIFY_CODE, vc);
		return null;
	}

	public Integer getUserId()
	{
		return userId;
	}

	public void setUserId(Integer userId)
	{
		this.userId = userId;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getSpasswd()
	{
		return spasswd;
	}

	public void setSpasswd(String spasswd)
	{
		this.spasswd = spasswd;
	}

	public boolean isExist()
	{
		return exist;
	}

	public void setExist(boolean exist)
	{
		this.exist = exist;
	}

	public String getRand()
	{
		return rand;
	}

	public void setRand(String rand)
	{
		this.rand = rand;
	}

	public String getTerm()
	{
		return term;
	}

	public void setTerm(String term)
	{
		this.term = term;
	}

	public String getEmail()
	{
		return email;
	}


	public void setEmail(String email)
	{
		this.email = email;
	}


	public String getPhone()
	{
		return phone;
	}


	public void setPhone(String phone)
	{
		this.phone = phone;
	}

}
