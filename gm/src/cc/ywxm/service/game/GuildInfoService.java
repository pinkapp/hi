package cc.ywxm.service.game;

import java.util.List;

import cc.ywxm.model.game.Guild;

/**
 * @version v0.1
 * @author HuangDeCai
 * @since 2012-12-1 9:29:00
 * 
 */
public interface GuildInfoService
{
	/**
	 * 
	 * @param name
	 * @return
	 */
	public List<Guild> gets(String name);


}
