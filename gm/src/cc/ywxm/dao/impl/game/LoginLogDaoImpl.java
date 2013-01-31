package cc.ywxm.dao.impl.game;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cc.ywxm.dao.game.LoginLogDao;
import cc.ywxm.model.game.LoginLog;
import cc.ywxm.utils.RSMapper;

@Repository
public class LoginLogDaoImpl implements LoginLogDao
{
	@Resource
	private JdbcTemplate jdbcTemplate;

	public int count(String date)
	{
		String sql = "SELECT * FROM login_log GROUP BY player, DATE(logTime) HAVING DATE(logTime) = ?";
		sql = "select count(1) from (" + sql + ")a";
		return jdbcTemplate.queryForInt(sql, new Object[]
		{ date });
	}

	@SuppressWarnings("unchecked")
	public List<Integer> listByDate(String date)
	{
		String sql = "SELECT player FROM login_log WHERE DATE(logTime) = ?";
		return jdbcTemplate.queryForList(sql, new Object[]
		{ date }, Integer.class);
	}

	@SuppressWarnings("unchecked")
	public List<Integer> listByIP(String ip)
	{
		String sql = "SELECT player FROM login_log WHERE ipAddress = ? GROUP BY player";
		return jdbcTemplate.queryForList(sql, new Object[]
		{ ip }, Integer.class);
	}

	public int count(String date, int n)
	{
		String sql = "SELECT * FROM login_log WHERE DATE(logTime) = DATE_ADD(?, INTERVAL ? DAY) AND player IN(SELECT player FROM register_log WHERE DATE(logTime) = ?)";
		sql = "select count(1) from (" + sql + ")a";
		return jdbcTemplate.queryForInt(sql, new Object[]
		{ date, n, date });
	}

	public int countByDate(String date)
	{
		String sql = "SELECT player FROM login_log WHERE DATE(logTime) = ? GROUP BY player";
		sql = "select count(1) from (" + sql + ")a";
		return jdbcTemplate.queryForInt(sql, new Object[]
		{ date });
	}

	public int countByDate(String date, int n)
	{
		String sql = "SELECT player FROM login_log WHERE DATE(logTime) = ? GROUP BY player HAVING COUNT(player) = ?";
		sql = "select count(1) from (" + sql + ")a";
		return jdbcTemplate.queryForInt(sql, new Object[]
		{ date,n});
	}

	public int countByDateMore(String date, int n)
	{
		String sql = "SELECT player FROM login_log WHERE DATE(logTime) = ? GROUP BY player HAVING COUNT(player) > ?";
		sql = "select count(1) from (" + sql + ")a";
		return jdbcTemplate.queryForInt(sql, new Object[]
		{ date,n});
	}

	public int count(Integer player)
	{
		String sql = "select count(1) from login_log where player = ?";
		return jdbcTemplate.queryForInt(sql, new Object[]
		{ player });
	}

	public int count(Integer player, String startTime, String endTime)
	{
		String sql = "select count(1) from login_log where player = ? and logTime >= ? and logTime <= ?";
		return jdbcTemplate.queryForInt(sql, new Object[]
		{ player, startTime, endTime });
	}
	
	public List<LoginLog> list(Integer rows, Integer page, String sort,
			String order, Integer player)
	{
		String sql = "SELECT * FROM login_log t where t.player = ?";
		sql = sql + " order by t." + sort + " " + order;
		sql = "select * from (" + sql + ") a";
		return RSMapper.queryPage(jdbcTemplate, sql, rows, page,
				LoginLog.class, new Object[]
				{ player });
	}

	public List<LoginLog> list(Integer rows, Integer page, String sort,
			String order, Integer player, String startTime, String endTime)
	{
		String sql = "SELECT * FROM login_log t where t.player = ? and t.logTime >= ? and t.logTime <= ?";
		sql = sql + " order by t." + sort + " " + order;
		sql = "select * from (" + sql + ") a";
		return RSMapper.queryPage(jdbcTemplate, sql, rows, page,
				LoginLog.class, new Object[]
				{ player, startTime, endTime });
	}

	

	public List<LoginLog> list(Integer player)
	{
		String sql = "SELECT * FROM login_log t where t.player = ?";
		sql = "select * from (" + sql + ") a";
		return RSMapper.queryList(jdbcTemplate, sql, LoginLog.class,
				new Object[]
				{ player });
	}

	public List<LoginLog> list(Integer player, String startTime,
			String endTime)
	{
		String sql = "SELECT * FROM login_log t WHERE t.player = ? AND t.logTime >= ? AND t.logTime <= ?";
		sql = "select * from (" + sql + ") a";
		return RSMapper.queryList(jdbcTemplate, sql, LoginLog.class,
				new Object[]
				{ player, startTime, endTime });
	}

}
