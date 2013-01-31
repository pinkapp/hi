package cc.ywxm.dao.game;

import java.util.List;

import cc.ywxm.model.game.ConsumeLog;

/**
 * 玩家消费日志DAO
 * 
 * @author HuangDecai
 * @since 2012-12-25 15:26:48
 * 
 */
public interface ConsumeLogDao
{

	void save(ConsumeLog log);

	void delete(ConsumeLog log);

	void update(ConsumeLog log);

	ConsumeLog get(Long logId);

	ConsumeLog load(Long logId);

	int count(Integer player);

	int count(Integer player, String startTime, String endTime);

	List<ConsumeLog> list(Integer rows, Integer page, String sort,
			String order, Integer player);

	List<ConsumeLog> list(Integer rows, Integer page, String sort,
			String order, Integer player, String startTime, String endTime);

	List<ConsumeLog> list(Integer player);

	List<ConsumeLog> list(Integer player, String startTime, String endTime);

}
