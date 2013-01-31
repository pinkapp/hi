package cc.ywxm.service.game;

import java.util.List;
import java.util.Map;

import cc.ywxm.model.game.FeatLog;

/**
 * 功绩使用记录业务层接口
 * 
 * @author HuangDeCai
 * @since 2012-12-31 11:11:41
 * 
 */
public interface FeatLogService
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
	List<FeatLog> gets(String nickname, String startTime, String endTime);

	/**
	 * 
	 * @param player
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	List<FeatLog> gets(Integer player, String startTime, String endTime);

}
