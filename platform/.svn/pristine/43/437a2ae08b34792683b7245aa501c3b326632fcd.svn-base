package cc.ywxm.service;

import java.util.List;
import java.util.Map;

import cc.ywxm.model.User;

/**
 * 用户业务层接口
 * 
 * @author huangdc
 * 
 */
public interface UserService
{

	public int reg(String username, String password);

	/**
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public int login(String username, String password);

	/**
	 * 查询指定用户名的用户状态码
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public Integer statusCode(String username);

	/**
	 * 查询指定UID的用户状态码
	 * 
	 * @param userId
	 * @param password
	 * @return
	 */
	public Integer statusCode(int userId);

	/**
	 * 检查用户身份
	 * 
	 * @param userId
	 *            UID
	 * @param password
	 *            密码（明文）
	 * @return 登录成功后的用户
	 */
	public User login(int userId, String password);

	/**
	 * 
	 * @param uid
	 *            UID
	 * 
	 * @return 指定UID的用户
	 */
	public User get(Integer userId);

	/**
	 * 修改用户基本属性，不能修改密码
	 * 
	 * @param user
	 *            用户
	 */
	public void edit(User user);

	/**
	 * 
	 * @param username
	 * @param password
	 * @param realname
	 * @param cardId
	 * @param email
	 * @param regAddress
	 * @return
	 */
	public int add(String username, String password, String realname,
			String cardId, String email, String regAddress);

	/**
	 * 通过用户名查询用户
	 * 
	 * @param username
	 *            用户名
	 * @return 用户
	 */
	public User findByUsername(String username);

	/**
	 * 检查用户名是否存在
	 * 
	 * @param username
	 *            用户名
	 * @return 是否存在
	 */
	public boolean checkUsername(String username);

	/**
	 * @param userIds
	 *            UIDs
	 */
	public void batchDelete(String userIds);

	/**
	 * 通过用户ID查询角色
	 * 
	 * @param userId
	 *            UID
	 * @return 角色列表
	 */
	public List<String> getRolenamesByUserId(Integer userId);

	/**
	 * 封闭账号
	 * 
	 * @param userId
	 */
	public void delete(Integer userId);

	/**
	 * 解封账号
	 * 
	 * @param userId
	 *            UID
	 */
	public void recover(int userId);

	/**
	 * 根据用户ID查询有权限的URL
	 * 
	 * @param userId
	 *            UID
	 * @return URLs
	 */
	public List<String> getFunctionURLsByUserId(Integer userId);

	/**
	 * 添加和修改用户角色
	 * 
	 * @param userId
	 * @param roleId
	 * @return
	 */
	public void grant(Integer userId, Integer roleId);

	/**
	 * 通过UID查询角色ID
	 * 
	 * @param userId
	 *            UID
	 * @return 角色ID
	 */
	public Short findRoleIdByUserId(Integer userId);

	/**
	 * 检查邮箱是否存在
	 * 
	 * @param email
	 *            邮箱
	 * @return 是否存在
	 */
	public boolean checkEmail(String email);

	/**
	 * 模糊查询用户名
	 * 
	 * @param str
	 *            匹配的字符串
	 * @return 用户名列表
	 */
	public List<String> findUsersByUsername(String str);

	/**
	 * 设置二级密码
	 * 
	 * @param userId
	 *            UID
	 * @param spasswd
	 *            二级密码（明文）
	 */
	public void setSecondaryPassword(Integer userId, String spasswd);

	/**
	 * 二级密码是否已经设置过
	 * 
	 * @param userId
	 *            UID
	 * @return 标记(0:没设置,1:已设置)
	 */
	public int yetSecondaryPassword(int userId);

	/**
	 * 检查用户名是否存在
	 * 
	 * @param username
	 * @return 标记(0:不存在,1:存在)
	 */
	public int yetUsername(String username);

	/**
	 * 查询用户的邮箱返回
	 * 
	 * @param username
	 *            用户名
	 * @return 邮箱
	 */
	public String findEmail(String username);

	/**
	 * 查询用户的手机号码
	 * 
	 * @param userId
	 *            用户名
	 * @return 手机号码
	 */
	public String findPhone(String username);

	/**
	 * 重置用户密码
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            密码（明文）
	 */
	public void resetPassword(String username, String password);

	/**
	 * 重置用户密码
	 * 
	 * @param userId
	 *            UID
	 * @param password
	 *            密码（明文）
	 */
	public void resetPassword(int userId, String password);

	/**
	 * 发送验证码到邮箱(未实现)
	 * 
	 * @param email
	 *            邮件地址
	 * @param strs
	 *            用户名，验证码等
	 */
	public void sendVerifyCodeByEmail(String email, String[] strs);

	/**
	 * 发送验证码到手机(未实现)
	 * 
	 * @param phone
	 *            手机号码
	 * @param strs
	 *            用户名，验证码等
	 */
	public void sendVerifyCodeByPhone(String phone, String[] strs);

	/**
	 * 检查手机号码是否已经绑定
	 * 
	 * @param userId
	 *            UID
	 * @return 标记(0:没绑定,1:已绑定)
	 */
	public int yetPhone(int userId);

	/**
	 * 指定UID查询手机号码
	 * 
	 * @param userId
	 *            UID
	 * @return 手机号码
	 */
	public String findPhone(int userId);

	/**
	 * 更新用户状态码
	 * 
	 * @param userId
	 *            UID
	 * @param statusCode
	 *            状态码
	 */
	public void updateStatusCode(int userId, int statusCode);

	/**
	 * 检查手机号码是否已经被绑定过
	 * 
	 * @param phone
	 *            手机号码
	 * @return 绑定与否
	 */
	public boolean checkPhone(String phone);

	/**
	 * 指定UID查询身份证号码
	 * 
	 * @param userId
	 *            UID
	 * @return 身份证号码
	 */
	public String findCardId(int userId);

	/**
	 * 检查身份证号码是否已经绑定
	 * 
	 * @param userId
	 *            UID
	 * @return 绑定与否
	 */
	public int yetCardId(Integer userId);

	/**
	 * 用户登录
	 * 
	 * @param username
	 * @param password
	 * @param loginIp
	 * @return
	 */
	public int login(String username, String password, String loginIp);

	/**
	 * 加密
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public String encrypt(String username, String password);

	/**
	 * 解密
	 * 
	 * @param encryptString
	 * @return
	 */
	public Map<String, Object> decrypt(String encryptString);

}
