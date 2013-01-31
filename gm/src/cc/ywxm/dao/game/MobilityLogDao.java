package cc.ywxm.dao.game;

import java.util.List;

import cc.ywxm.model.game.MobilityLog;

/**
 * 行动力使用日志数据访问层接口
 * 
 * @author HuangDecai
 * @since 2012-12-30 9:25:25
 * 
 */
public interface MobilityLogDao
{

	int count(Integer player);

	int count(Integer player, String startTime, String endTime);

	List<MobilityLog> list(Integer rows, Integer page, String sort, String order,
			Integer player);

	List<MobilityLog> list(Integer rows, Integer page, String sort, String order,
			Integer player, String startTime, String endTime);

	List<MobilityLog> list(Integer player);

	List<MobilityLog> list(Integer player, String startTime, String endTime);

}
