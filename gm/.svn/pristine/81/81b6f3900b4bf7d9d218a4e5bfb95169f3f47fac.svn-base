package cc.ywxm.service.gm;

import java.util.List;
import java.util.Map;

import cc.ywxm.model.gm.OperateLog;

public interface OperateLogService
{

	/**
	 * 添加用户操作日志
	 * 
	 * @param info
	 *            信息
	 * @param operator
	 *            操作者
	 * @param ipAddress
	 *            IP地址
	 * @return 代码
	 */
	int add(String info, String operator, String ipAddress);

	/**
	 * 
	 * @param rows
	 * @param page
	 * @param sort
	 * @param order
	 * @param username
	 *            用户名
	 * @param startTime
	 *            开始时间
	 * @param endTime
	 *            结束时间
	 * @return
	 */
	Map<String, Object> gets(Integer rows, Integer page, String sort,
			String order, String username, String startTime, String endTime);

	/**
	 * 
	 * @param rows
	 * @param page
	 * @param sort
	 * @param order
	 * @param username
	 *            用户名
	 * @param startTime
	 *            开始时间
	 * @param endTime
	 *            结束时间
	 * @return
	 */
	String JSONData(Integer rows, Integer page, String sort, String order,
			String username, String startTime, String endTime);

	/**
	 * 
	 * @param username
	 *            用户名
	 * @param startTime
	 *            开始时间
	 * @param endTime
	 *            结束时间
	 * @return
	 */
	List<OperateLog> gets(String username, String startTime, String endTime);

}
