package cc.ywxm.service.game;

import java.util.List;

import cc.ywxm.model.game.Hero;

/**
 * @version v0.1
 * @author HuangDeCai
 * @since 2012-11-30 9:18:10
 * 
 */
public interface HeroInfoService
{
	/**
	 * 
	 * @param player
	 *            玩家ID/玩家昵称
	 * @return
	 */
	public List<Hero> gets(String player);

}
