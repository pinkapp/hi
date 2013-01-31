package cc.ywxm.service.game;

import java.util.List;
import java.util.Map;

import cc.ywxm.model.game.ConsumeLog;

public interface ConsumeLogService
{

	public static final int CODE_PLAYER_NULL = 1000;
	public static final int CODE_NICKNAME_NULL = 4000;
	public static final int CODE_PLAYER_NOT_EXIST = 1001;
	public static final int CODE_ZMQ_TIMEOUT = 2000;
	public static final int CODE_ZMQ_NORESPONSE = 8000;
	public static final int CODE_JSON_ERROR = 3000;
	public static final int CODE_SUCCESS = 1;
	public static final int CODE_FAIL = 0;

	/**
	 * 
	 * @param rows
	 * @param page
	 * @param sort
	 * @param order
	 * @param player 玩家ID/玩家昵称
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @return
	 */
	Map<String, Object> gets(Integer rows, Integer page, String sort,
			String order, String player, String startTime, String endTime);

	/**
	 * 
	 * @param rows
	 * @param page
	 * @param sort
	 * @param order
	 * @param player 玩家ID/玩家昵称
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @return
	 */
	String JSONData(Integer rows, Integer page, String sort, String order,
			String player, String startTime, String endTime);

	/**
	 * 
	 * @param player 玩家ID/玩家昵称
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @return
	 */
	List<ConsumeLog> gets(String player, String startTime, String endTime);

}
