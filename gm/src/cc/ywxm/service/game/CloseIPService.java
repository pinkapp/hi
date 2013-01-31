package cc.ywxm.service.game;

import org.json.JSONArray;
/**
 * 封IP
 * @author HuangDecai
 * @since  2013-1-10 15:42:58
 *
 */
public interface CloseIPService
{
	public static final int CODE_PLAYER_NULL = 1000;

	public static final int CODE_PLAYER_NOT_EXIST = 1001;
	public static final int CODE_ZMQ_TIMEOUT = 2000;
	public static final int CODE_ZMQ_NORESPONSE = 8000;
	public static final int CODE_JSON_ERROR = 3000;
	public static final int CODE_SUCCESS = 1;
	public static final int CODE_FAIL = 0;

	/**
	 * @param player
	 *            玩家ID或昵称
	 * @param reason
	 *            封IP原因
	 * @param endDate
	 *            截止日期，null代表永久封号
	 * @return 代码
	 */
	public int close(String player, String reason, String endDate);

	/**
	 * 
	 * @param player
	 *            玩家ID或昵称
	 * @return JSON数组
	 */
	public JSONArray gets(String player);

}
