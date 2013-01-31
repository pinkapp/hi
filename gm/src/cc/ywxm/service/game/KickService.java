package cc.ywxm.service.game;

import java.io.File;

/**
 * 
 * @author HuangDeCai
 * @since 2012-12-14 11:26:07
 * 
 */
public interface KickService
{
	public static final int CODE_PLAYER_NULL = 1000;

	public static final int CODE_PLAYER_NOT_EXIST = 1001;
	public static final int CODE_ZMQ_TIMEOUT = 2000;
	public static final int CODE_JSON_ERROR = 3000;
	public static final int CODE_SUCCESS = 1;
	public static final int CODE_FAIL = 0;
	public static final int CODE_FILE_NULL = 4000;
	public static final int CODE_FILEEXT_NOT_SUPPORT = 4001;

	/**
	 * 
	 * @param file
	 * @param extension
	 *            扩展名
	 * @return
	 */
	int kick(File file, String extension);

	/**
	 * @param player
	 *            玩家ID或昵称
	 * 
	 * @return 代码
	 */
	int kick(String player);

	/**
	 * 全服T
	 * 
	 * @return 代码
	 */
	int kick();

}
