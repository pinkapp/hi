package cc.ywxm.service.game;


public interface PlayerService
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
	 * 玩家登录
	 * 
	 * @param player
	 *            玩家ID
	 * @return 代码
	 */
	int login(Integer player);

}
