package cc.ywxm.service.game;

import java.util.List;
import java.util.Map;

import cc.ywxm.model.game.LoginLog;

/**
 * @version v0.1
 * @author HuangDeCai
 * @since 2012-12-6 11:26:07
 * 
 */
public interface LoginLogService
{
	/**
	 * 
	 * @param rows
	 * @param page
	 * @param sort
	 * @param order
	 * @param player
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	Map<String, Object> gets(Integer rows, Integer page, String sort,
			String order, Integer player, String startTime, String endTime);

	/**
	 * 
	 * @param rows
	 * @param page
	 * @param sort
	 * @param order
	 * @param nickname
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	Map<String, Object> gets(Integer rows, Integer page, String sort,
			String order, String nickname, String startTime, String endTime);

	/**
	 * 
	 * @param rows
	 * @param page
	 * @param sort
	 * @param order
	 * @param player
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	String JSONData(Integer rows, Integer page, String sort, String order,
			Integer player, String startTime, String endTime);

	/**
	 * 
	 * @param rows
	 * @param page
	 * @param sort
	 * @param order
	 * @param nickname
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	String JSONData(Integer rows, Integer page, String sort, String order,
			String nickname, String startTime, String endTime);

	/**
	 * 
	 * @param nickname
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	List<LoginLog> gets(String nickname, String startTime, String endTime);

	/**
	 * 
	 * @param player
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	List<LoginLog> gets(Integer player, String startTime, String endTime);


}
