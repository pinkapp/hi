package cc.ywxm.service.game;

import java.util.List;

import cc.ywxm.model.game.BusinessBuilding;
import cc.ywxm.model.game.FunctionBuilding_;

/**
 * @version v0.1
 * @author HuangDeCai
 * @since 2012-11-30 14:03:32
 * 
 */
public interface BuildInfoService
{
	/**
	 * 
	 * @param nickname
	 * @return
	 */
	public List<BusinessBuilding> gets(String nickname);

	/**
	 * 
	 * @param player
	 * @return
	 */
	public List<BusinessBuilding> gets(Integer player);

	/**
	 * 
	 * @param player
	 * @return
	 */
	public List<FunctionBuilding_> gets2(Integer player);

	/**
	 * 
	 * @param nickname
	 * @return
	 */
	public List<FunctionBuilding_> gets2(String nickname);

	/**
	 * 
	 * @param nickname
	 * @param id
	 * @param kind
	 * @param x
	 * @param y
	 * @param aspect
	 * @param level
	 * @param progress
	 * @param lastReap
	 * @return
	 */
	public int edit(String nickname, Integer id, Short kind, Short x, Short y,
			Short aspect, Short level, Short progress, String lastReap);

}
