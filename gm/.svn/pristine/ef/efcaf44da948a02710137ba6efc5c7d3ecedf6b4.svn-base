package cc.ywxm.dao.impl.game;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cc.ywxm.dao.game.ArenaInfoDao;
import cc.ywxm.model.game.ArenaInfo;
import cc.ywxm.utils.RSMapper;

@Repository
public class ArenaInfoDaoImpl implements ArenaInfoDao
{
	// @Resource
	// private HibernateTemplate hibernateTemplate;
	@Resource
	private JdbcTemplate jdbcTemplate;

	public void delete(ArenaInfo arenaInfo)
	{
	}

	public ArenaInfo findById(Integer player)
	{
		String sql = "SELECT t.player,t1.nickname,t.rank,t.time,t.count,t.buy_count AS buyCount,t.win_count winCount,t.lose_count loseCount FROM arena_info t LEFT JOIN base_info t1 ON t.player=t1.player WHERE t.player = ?";
		sql = "select * from (" + sql + ")a";
		return RSMapper.query(jdbcTemplate, sql, ArenaInfo.class, new Object[]
		{ player });
	}

	public List<ArenaInfo> listOrderByRank()
	{
		String sql = "SELECT t.player,t1.nickname,t.rank,t.reward,t.time,t.count,t.buy_count AS buyCount,t.win_count winCount,t.lose_count loseCount FROM arena_info t LEFT JOIN base_info t1 ON t.player=t1.player ORDER BY t.rank";
		sql = "select * from (" + sql + ")a";
		return RSMapper.queryList(jdbcTemplate, sql, ArenaInfo.class);
	}

	public void save(ArenaInfo arenaInfo)
	{
	}

	public void update(ArenaInfo arenaInfo)
	{
	}

}
