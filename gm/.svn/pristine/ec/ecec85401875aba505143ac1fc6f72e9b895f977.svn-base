package cc.ywxm.service.game;

import java.util.List;
import java.util.Map;

import cc.ywxm.model.game.EnergyLog;

/**
 * 活力使用记录业务层接口
 * 
 * @author HuangDeCai
 * @since 2012-12-30 13:03:28
 * 
 */
public interface EnergyLogService
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
	List<EnergyLog> gets(String nickname, String startTime, String endTime);

	/**
	 * 
	 * @param player
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	List<EnergyLog> gets(Integer player, String startTime, String endTime);

}
