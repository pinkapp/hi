package cc.ywxm.service.game;

import java.io.File;

/**
 * @version v0.1
 * @author HuangDeCai
 * @since 2012-12-14 10:39:51
 * 
 */
public interface SendGoldService
{
	/**
	 * 
	 * @param receiver
	 * @param gold
	 * @return
	 */
	int send(String receiver, int gold);

	/**
	 * 
	 * @param receiver
	 * @param contentType
	 * @param gold
	 * @return
	 */
	int send(File receiver, String contentType, int gold);

}
