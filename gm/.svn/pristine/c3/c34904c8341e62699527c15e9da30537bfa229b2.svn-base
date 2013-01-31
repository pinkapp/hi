package cc.ywxm.service.game;

import java.util.Map;

public interface BaseInfoService
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
	 * 修改玩家基本信息
	 * 
	 * @param player
	 *            玩家ID/玩家昵称
	 * @param prop
	 *            属性
	 * @param value
	 *            值，变动值 gold，silver，energy，mobility；绝对值 progress
	 * @return
	 */
	int edit(String player, String prop, int value);

	/**
	 * 创建玩家账号
	 * 
	 * @param nickname
	 * @param sex
	 * @return
	 */
	int add(String nickname, Integer sex);

	/**
	 * 
	 * @param rows
	 * @param page
	 * @param nickname
	 * @return
	 */
	Map<String, Object> gets(Integer rows, Integer page, String nickname);

	/**
	 * 
	 * @param rows
	 * @param page
	 * @param sort
	 * @param order
	 * @param nickname
	 * @return
	 */
	Map<String, Object> gets(Integer rows, Integer page, String sort,
			String order, String nickname);

}
