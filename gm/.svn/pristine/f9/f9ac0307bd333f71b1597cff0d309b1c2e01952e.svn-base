package cc.ywxm.service.game;

import java.util.List;
import java.util.Map;

import cc.ywxm.model.game.GiftbagLog;

/**
 * 礼包使用记录业务层接口
 * 
 * @author HuangDeCai
 * @since 2012-12-29 10:45:35
 * 
 */
public interface GiftbagLogService
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
	List<GiftbagLog> gets(String nickname, String startTime, String endTime);

	/**
	 * 
	 * @param player
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	List<GiftbagLog> gets(Integer player, String startTime, String endTime);

}
