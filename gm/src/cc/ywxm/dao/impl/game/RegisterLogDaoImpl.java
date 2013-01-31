package cc.ywxm.dao.impl.game;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cc.ywxm.dao.game.RegisterLogDao;

@Repository
public class RegisterLogDaoImpl implements RegisterLogDao
{
	@Resource
	private JdbcTemplate jdbcTemplate;

	public int count(String date)
	{
		String sql = "SELECT COUNT(1) FROM register_log WHERE DATE(logTime) = ?";
		return jdbcTemplate.queryForInt(sql, new Object[]
		{ date });
	}
}
