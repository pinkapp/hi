package cc.ywxm.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cc.ywxm.dao.GameServerDao;
import cc.ywxm.model.GameServer;
import cc.ywxm.utils.RSMapper;

@Repository
public class GameServerDaoImpl implements GameServerDao
{
	// @Resource
	// private HibernateTemplate hibernateTemplate;
	@Resource
	private JdbcTemplate jdbcTemplate;

	public void save(GameServer server)
	{
		// hibernateTemplate.save(server);
	}

	public void delete(GameServer server)
	{
		// hibernateTemplate.delete(server);
	}

	public void update(GameServer server)
	{
		// hibernateTemplate.update(server);
	}

	public GameServer get(Integer serverId)
	{
		String sql = "SELECT * FROM game_server WHERE serverId = ?";
		return RSMapper.query(jdbcTemplate, sql, GameServer.class, new Object[]
		{ serverId });
	}

	public List<GameServer> findNewest()
	{
		String sql = "SELECT t.serverId, t.serverName, t1.gameName, t.openDate, t.address FROM game_server t LEFT JOIN game t1 ON t.gameId = t1.gameId";
		return RSMapper.queryList(jdbcTemplate, sql, GameServer.class);
	}

}
