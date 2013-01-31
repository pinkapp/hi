package cc.ywxm.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cc.ywxm.dao.UserDao;
import cc.ywxm.model.User;
import cc.ywxm.secret.Auth;
import cc.ywxm.service.UserService;
import cc.ywxm.utils.PasswordUtils;
import cc.ywxm.utils.WebUtils;

import com.discuz.client.Client;
import com.discuz.util.XMLHelper;

@Service
@Transactional
public class UserServiceImpl implements UserService
{
	@Resource
	private UserDao userDao;

	// @Resource
	// private GameServerDao gameServerDao;

	public int reg(String username, String password)
	{
		if (username == null || "".equals(username))
		{
			return 2;// 用户名为空
		}
		if (password == null || "".equals(password))
		{
			return 3;// 密码为空
		}
		User user = null;
		try
		{
			user = userDao.findByUsername(username);
		} catch (Exception e)
		{
			e.printStackTrace();
			return 0;// 未知错误
		}
		if (user != null)
		{
			return 4;// 用户名重名
		}
		/*
		 * Client uc = new Client(); String result = null; try { result =
		 * uc.uc_user_register(username, password, email); } catch (Exception
		 * e1) { e1.printStackTrace(); } System.out.println("discuz:" + result);
		 */
		user = new User();
		user.setUsername(username);
		password = PasswordUtils.generatePassword(password);
		user.setPassword(password);

		try
		{
			userDao.save(user);
			return 1;// 保存成功
		} catch (Exception e)
		{
			e.printStackTrace();
			return 0;// 未知错误
		}

	}

	public int login(String username, String password)
	{
		if (username == null || "".equals(username))
		{
			return 2;// 用户名为空
		}
		User user = null;
		try
		{
			user = userDao.findByUsername(username);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		if (user == null)
		{
			return 3;// 用户不存在
		}
		if (password == null || "".equals(password))
		{
			return 4;// 密码为空
		}
		Client uc = new Client();
		String result = null;
		try
		{
			result = uc.uc_user_login(username, password);
		} catch (Exception e)
		{
			e.printStackTrace();
			// return 6;
		}
		System.out.println("discuz：" + result);
		password = PasswordUtils.generatePassword(password);
		int n = 0;
		try
		{
			n = userDao.count(username, password);
		} catch (Exception e)
		{
			e.printStackTrace();
			return 0;
		}
		if (n == 1)
		{
			return 1;// 登录成功
		} else
		{
			return 5;// 登录失败
		}

	}

	public User get(Integer userId)
	{
		try
		{
			return userDao.findById(userId);
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public void edit(User user)
	{
		User u = userDao.findById(user.getUserId());
		user.setPassword(null);
		try
		{
			WebUtils.setNotNull(user, u);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		userDao.update(u);

	}

	public User findByUsername(String username)
	{
		return userDao.findByUsername(username);
	}

	public boolean checkUsername(String username)
	{
		User user = userDao.findByUsername(username);
		if (user == null)
		{
			// 验证discuz里面用户名是否存在
			Client uc = new Client();
			String info = null;
			try
			{
				info = uc.uc_get_user(username, 0);
			} catch (Exception e)
			{
				e.printStackTrace();
				return true;// 存在
			}
			System.out.println("discuz:" + info);
			if ("0".equals(info))
			{
				return false;// 不存在
			} else
			{
				return true;
			}
		} else
		{
			return true;
		}
	}

	public boolean checkEmail(String email)
	{
		if (userDao.findByEmail(email) == null)
		{
			return false;
		} else
		{
			return true;
		}
	}

	public void batchDelete(String userIds)
	{
		if (userIds == null || userIds.length() == 0)
		{
			return;
		}
		String[] user_ids =
		{ "" };
		if (userIds.indexOf(",") == -1)
		{
			user_ids[0] = userIds;
		} else
		{
			user_ids = userIds.split(",");
		}
		Integer[] ids = new Integer[user_ids.length];
		for (int i = 0; i < user_ids.length; i++)
		{
			ids[i] = Integer.parseInt(user_ids[i]);

		}
		userDao.batchDelete(ids);
	}

	public List<String> getRolenamesByUserId(Integer userId)
	{
		String sql = "SELECT t.rolename FROM role t INNER JOIN user_role t1 ON t.role_id = t1.role_id WHERE t1.user_id = ?";
		return userDao.findList(sql, userId);
	}

	public void delete(Integer userId)
	{
		User user = userDao.findById(userId);
		userDao.delele(user);
	}

	public List<String> getFunctionURLsByUserId(Integer userId)
	{
		String sql = "SELECT t3.functionurl FROM user_role t LEFT JOIN role t1 ON t.role_id = t1.role_id LEFT JOIN role_function t2 ON t1.role_id = t2.role_id LEFT JOIN function t3 ON t2.function_id = t3.function_id WHERE t.user_id = ?";
		return userDao.findList(sql, userId);
	}

	public void grant(Integer userId, Integer roleId)
	{
		userDao.grant(userId, roleId);
	}

	public Short findRoleIdByUserId(Integer userId)
	{
		return userDao.findRoleIdByUserId(userId);
	}

	public void recover(int userId)
	{
		userDao.recover(userId);
	}

	public List<String> findUsersByUsername(String str)
	{
		return userDao.findUsersByUsername(str);
	}

	public void setSecondaryPassword(Integer userId, String spasswd)
	{
		if (StringUtils.isNotEmpty(spasswd))
		{
			spasswd = PasswordUtils.generatePassword(spasswd);
		}

		userDao.updateSecondaryPassword(userId, spasswd);

	}

	public int yetSecondaryPassword(int userId)
	{
		String spasswd = userDao.findSecondaryPassword(userId);
		if (spasswd == null || "".equals(spasswd))
		{
			return 0;
		} else
		{
			return 1;
		}
	}

	public int yetUsername(String username)
	{
		User u = userDao.findByUsername(username);
		if (u == null)
		{
			return 0;
		} else
		{
			return 1;
		}
	}

	public String findEmail(String username)
	{
		return userDao.findEmail(username);
	}

	public String findPhone(String username)
	{
		return userDao.findPhone(username);
	}

	public void resetPassword(String username, String password)
	{
		if (StringUtils.isNotEmpty(password))
		{
			password = PasswordUtils.generatePassword(password);
		}
		userDao.resetPassword(username, password);
	}

	public void sendVerifyCodeByEmail(String email, String[] strs)
	{

	}

	public void sendVerifyCodeByPhone(String phone, String[] strs)
	{

	}

	public int yetPhone(int userId)
	{
		String phone = userDao.findPhone(userId);
		if (phone == null || "".equals(phone))
		{
			return 0;
		} else
		{
			return 1;
		}
	}

	public String findPhone(int userId)
	{
		return userDao.findPhone(userId);
	}

	public void resetPassword(int userId, String password)
	{
		if (StringUtils.isNotEmpty(password))
		{
			password = PasswordUtils.generatePassword(password);
		}
		userDao.resetPassword(userId, password);
		// User u = userDao.findById(userId);
	}

	public User login(int userId, String password)
	{
		if (StringUtils.isNotEmpty(password))
		{
			password = PasswordUtils.generatePassword(password);
		}
		List<User> users = userDao.find(userId, password);
		if (users == null || users.size() == 0)
		{
			return null;
		}
		return users.get(0);
	}

	public Integer statusCode(String username)
	{
		User u = userDao.findByUsername(username);
		int statusCode = userDao.findStatusCode(username);
		if (u == null)
		{
			return -1;
		} else
		{
			return statusCode;
		}
	}

	public Integer statusCode(int userId)
	{
		User u = userDao.findById(userId);
		int statusCode = userDao.findStatusCode(userId);
		if (u == null)
		{
			return -1;
		} else
		{
			return statusCode;
		}
	}

	public void updateStatusCode(int userId, int statusCode)
	{
		userDao.updateStatusCode(userId, statusCode);

	}

	public boolean checkPhone(String phone)
	{
		User u = userDao.findByPhone(phone);
		if (u == null)
		{
			return false;
		} else
		{
			return true;
		}

	}

	public String findCardId(int userId)
	{
		return userDao.findCardId(userId);
	}

	public int yetCardId(Integer userId)
	{
		String cardId = userDao.findCardId(userId);
		if (cardId == null || "".equals(cardId))
		{
			return 0;
		} else
		{
			return 1;
		}
	}

	public int add(String username, String password, String realname,
			String cardId, String email, String regAddress)
	{
		if (username == null || "".equals(username))
		{
			return 2;// 用户名为空
		}
		if (password == null || "".equals(password))
		{
			return 3;// 密码为空
		}
		User user = null;
		try
		{
			user = userDao.findByUsername(username);
		} catch (Exception e)
		{
			e.printStackTrace();
			return 0;// 未知错误
		}
		if (user != null)
		{
			return 4;// 用户名重名
		}
		if (email == null || "".equals(email))
		{
			return 5;// 电邮为空
		}
		Client uc = new Client();
		String result = null;
		try
		{
			result = uc.uc_user_register(username, password, email);
		} catch (Exception e1)
		{
			e1.printStackTrace();
		}
		System.out.println("discuz:" + result);
		user = new User();
		user.setUsername(username);
		password = PasswordUtils.generatePassword(password);
		user.setPassword(password);

		try
		{
			userDao.save(user);
			return 1;// 保存成功
		} catch (Exception e)
		{
			e.printStackTrace();
			return 0;// 未知错误
		}

	}

	public String uc_user_synlogin(String username, String password)
	{
		Client uc = new Client();
		String result = null;
		try
		{
			result = uc.uc_user_login(username, password);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		// System.out.println("discuz：" + result);
		LinkedList<String> rs = XMLHelper.uc_unserialize(result);
		if (rs.size() > 0)
		{
			int $uid = Integer.parseInt(rs.get(0));
			// String $username = rs.get(1);
			// String $password = rs.get(2);
			// String $email = rs.get(3);
			if ($uid > 0)
			{
				String ucsynlogin = uc.uc_user_synlogin($uid);
				return ucsynlogin;
			} else if ($uid == -1)
			{
				return "无此用户，论坛登录失败";
			} else if ($uid == -2)
			{
				return "密码错误，论坛登录失败";
			} else
			{
				return "未知错误，论坛登录失败";
			}
		} else
		{
			return "论坛登录失败";
		}

	}

	public int login(String username, String password, String loginIp)
	{
		if (username == null || "".equals(username))
		{
			return 2;// 用户名为空
		}
		User user = null;
		try
		{
			user = userDao.findByUsername(username);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		if (user == null)
		{
			return 3;// 用户不存在
		}
		if (password == null || "".equals(password))
		{
			return 4;// 密码为空
		}
		password = PasswordUtils.generatePassword(password);
		int n = 0;
		try
		{
			n = userDao.count(username, password);
			//userDao.update(user);
		} catch (Exception e)
		{
			e.printStackTrace();
			return 0;
		}
		if (n == 1)
		{
			return 1;// 登录成功
		} else
		{
			return 5;// 登录失败
		}
	}

	/**
	 * 把map转换成字符串 map--json---auth加密---url转码
	 * 
	 * @param map
	 * @return
	 */
	public String shift(Map<String, Object> map)
	{
		String string = null;
		try
		{
			string = JSONUtil.serialize(map);
		} catch (JSONException e1)
		{
			e1.printStackTrace();
			return "-1";
		}
		Auth auth = new Auth();
		string = auth.authcode(string, Auth.ENCODE);
		try
		{
			string = URLEncoder.encode(string, "utf-8");
		} catch (UnsupportedEncodingException e1)
		{
			e1.printStackTrace();
			return "-2";
		}
		return string;
	}

	public String encrypt(String username, String password)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", username);
		map.put("password", password);
		String string = null;
		try
		{
			string = JSONUtil.serialize(map);
		} catch (JSONException e1)
		{
			e1.printStackTrace();
			return "-1";
		}
		Auth auth = new Auth();
		string = auth.authcode(string, Auth.ENCODE);
		try
		{
			string = URLEncoder.encode(string, "utf-8");
		} catch (UnsupportedEncodingException e1)
		{
			e1.printStackTrace();
			return "-2";
		}
		return string;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> decrypt(String encryptString)
	{
		String string = encryptString;
		try
		{
			string = URLDecoder.decode(string, "utf-8");
		} catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		Auth auth = new Auth();
		string = auth.authcode(string, Auth.DECODE);
		try
		{
			return (Map<String, Object>) JSONUtil.deserialize(string);
		} catch (JSONException e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
