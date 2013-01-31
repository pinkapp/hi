package cc.ywxm.dao.game;

import java.util.List;

import cc.ywxm.model.game.GiftbagLog;

/**
 * 礼包使用日志数据访问层接口
 * 
 * @author HuangDecai
 * @since 2012-12-4 13:20:30
 * 
 */
public interface GiftbagLogDao
{

	int count(Integer player);

	int count(Integer player, String startTime, String endTime);

	List<GiftbagLog> list(Integer rows, Integer page, String sort, String order,
			Integer player);

	List<GiftbagLog> list(Integer rows, Integer page, String sort, String order,
			Integer player, String startTime, String endTime);

	List<GiftbagLog> list(Integer player);

	List<GiftbagLog> list(Integer player, String startTime, String endTime);

}
