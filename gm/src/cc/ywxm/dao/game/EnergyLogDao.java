package cc.ywxm.dao.game;

import java.util.List;

import cc.ywxm.model.game.EnergyLog;

/**
 * 活力使用日志数据访问层接口
 * 
 * @author HuangDecai
 * @since 2012-12-30 12:59:29
 * 
 */
public interface EnergyLogDao
{

	int count(Integer player);

	int count(Integer player, String startTime, String endTime);

	List<EnergyLog> list(Integer rows, Integer page, String sort,
			String order, Integer player);

	List<EnergyLog> list(Integer rows, Integer page, String sort,
			String order, Integer player, String startTime, String endTime);

	List<EnergyLog> list(Integer player);

	List<EnergyLog> list(Integer player, String startTime, String endTime);

}
