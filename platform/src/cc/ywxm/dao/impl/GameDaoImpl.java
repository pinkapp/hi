package cc.ywxm.dao.impl;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cc.ywxm.dao.GameDao;
import cc.ywxm.model.Game;
import cc.ywxm.utils.RSMapper;

@Repository
public class GameDaoImpl implements GameDao
{
	@Resource
	private JdbcTemplate jdbcTemplate;

	public void save(Game server)
	{
	}

	public void delete(Game server)
	{
	}

	public void update(Game server)
	{
	}

	public Game get(Integer gameId)
	{
		String sql = "SELECT * FROM game WHERE gameId = ?";
		return RSMapper.query(jdbcTemplate, sql, Game.class, new Object[]
		{ gameId });
	}

}
