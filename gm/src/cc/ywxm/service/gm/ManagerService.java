package cc.ywxm.service.gm;

import java.util.Map;

import cc.ywxm.model.gm.Manager;

public interface ManagerService
{
	/**
	 * 
	 * @param userName
	 *            用户名
	 * @param password
	 *            密码
	 * @return 登录状态码
	 */
	int login(String userName, String password);

	/**
	 * 添加系统用户
	 * 
	 * @param userName
	 * @param password
	 * @param userType
	 * @param valid
	 * @param note
	 */
	int add(String userName, String password, Short userType, Boolean valid,
			String note);

	/**
	 * 删除系统用户
	 * 
	 * @param userId
	 *            用户ID
	 */
	int remove(Integer userId);

	/**
	 * 编辑系统用户
	 * 
	 * @param userId
	 * @param userName
	 * @param userType
	 * @param valid
	 * @param note
	 */
	int edit(Integer userId, String userName, Short userType, Boolean valid,
			String note);

	/**
	 * 查询用户
	 * 
	 * @param userId
	 *            用户ID
	 * @return
	 */
	Manager get(Integer userId);

	Manager findByUserName(String userName);

	Map<String, Object> gets(Integer rows, Integer page, String userName,
			Short userType, Boolean valid);

	/**
	 * 检查用户名
	 * 
	 * @param userName
	 * @return
	 */
	int checkUserName(String userName);

	/**
	 * 修改密码
	 * 
	 * @param userName
	 * @param pwd
	 * @param password
	 * @return
	 */

	int password_edit(String userName, String pwd, String password);

	/**
	 * 修改密码
	 * 
	 * @param userId
	 * @param password
	 * @return
	 */
	int editPassword(Integer userId, String password);

	/**
	 * 
	 * @param userId
	 * @return
	 */
	Manager get_(Integer userId);

}
