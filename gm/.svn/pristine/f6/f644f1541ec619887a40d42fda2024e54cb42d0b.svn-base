package cc.ywxm.service.game;

import java.util.List;

import cc.ywxm.model.game.Prop_;

/**
 * 玩家道具service
 * 
 * @author HuangDeCai
 * @since 2012-12-10 13:32:07
 * 
 */
public interface PropInfoService
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
	 * @param nickname
	 * @return
	 */
	public List<Prop_> gets(String nickname);

	/**
	 * 
	 * @param player
	 * @return
	 */
	public List<Prop_> gets(Integer player);

	/**
	 * 
	 * @param nickname
	 * @param id
	 * @param location
	 * @param area
	 * @param amount
	 * @param kind
	 * @return
	 */
	public int edit(String nickname, Integer id, Short location, Short area,
			Short amount, Short kind);

	/**
	 * 
	 * @param player
	 * @param id
	 * @param location
	 * @param area
	 * @param amount
	 * @param kind
	 * @return
	 */
	public int edit(Integer player, Integer id, Short location, Short area,
			Short amount, Short kind);

	/**
	 * 
	 * @param player
	 *            玩家ID/玩家昵称
	 * @param sid
	 *            道具sid
	 * @param amount
	 *            数量
	 * @return
	 */
	public int add(String player, Integer sid, Integer amount);

}
