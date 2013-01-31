package cc.ywxm.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cc.ywxm.action.base.BaseAction;
import cc.ywxm.constant.Const;
import cc.ywxm.service.UserService;
import cc.ywxm.utils.RandomUtils;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class ForgotpassAction extends BaseAction
{
	@Resource
	private UserService userService;
	private int step = 1;
	private String username;
	private int findway = -1;
	private String email;
	private String phone;
	// 验证码
	private String verifyCode = "";
	private String password;

	// 发送验证码
	public String sendVerifyCode()
	{
		String vc = RandomUtils.randString(6);
		String[] strs = new String[2];
		strs[0] = username;
		strs[1] = vc;
		switch (findway)
		{
		case 0:
			userService.sendVerifyCodeByEmail(email, strs);
			System.out.println("已通过邮箱" + email + "发送验证码：" + vc);
			break;
		case 1:
			userService.sendVerifyCodeByPhone(phone, strs);
			System.out.println("已通过手机" + phone + "发送验证码：" + vc);
			break;
		default:
			break;
		}
		session.put(Const.VERIFY_CODE, vc);
		return null;
	}

	public int getStep()
	{
		return step;
	}

	public void setStep(int step)
	{
		this.step = step;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public int getFindway()
	{
		return findway;
	}

	public void setFindway(int findway)
	{
		this.findway = findway;
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

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getVerifyCode()
	{
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode)
	{
		this.verifyCode = verifyCode;
	}
}
