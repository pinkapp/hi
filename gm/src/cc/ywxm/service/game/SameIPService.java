package cc.ywxm.service.game;

import java.util.List;

import cc.ywxm.model.game.SameIP;

/**
 * @version v0.1
 * @author HuangDeCai
 * @since 2012-12-6 16:35:50
 * 
 */
public interface SameIPService
{
	/**
	 * 
	 * @param startIP
	 * @param endIP
	 * @return
	 */
	public List<SameIP> gets(String startIP, String endIP);

	/**
	 * 
	 * @param IP
	 * @return
	 */
	public List<SameIP> gets(String IP);

}
