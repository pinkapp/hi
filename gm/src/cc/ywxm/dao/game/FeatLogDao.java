package cc.ywxm.dao.game;

import java.util.List;

import cc.ywxm.model.game.FeatLog;

/**
 * 功绩使用日志数据访问层接口
 * 
 * @author HuangDecai
 * @since 2012-12-31 9:22:19
 * 
 */
public interface FeatLogDao
{

	int count(Integer player);

	int count(Integer player, String startTime, String endTime);

	List<FeatLog> list(Integer rows, Integer page, String sort, String order,
			Integer player);

	List<FeatLog> list(Integer rows, Integer page, String sort, String order,
			Integer player, String startTime, String endTime);

	List<FeatLog> list(Integer player);

	List<FeatLog> list(Integer player, String startTime, String endTime);

}
