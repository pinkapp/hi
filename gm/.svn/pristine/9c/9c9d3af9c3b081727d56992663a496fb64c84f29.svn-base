package cc.ywxm.dao.impl.game;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cc.ywxm.dao.game.EnergyLogDao;
import cc.ywxm.model.game.EnergyLog;
import cc.ywxm.utils.RSMapper;

/**
 * 活力使用日志数据访问层接口实现（JDBC）
 * 
 * @author HuangDecai
 * @since 2012-12-30 13:00:35
 * 
 */
@Repository
public class EnergyLogDaoImpl implements EnergyLogDao
{
	@Resource
	private JdbcTemplate jdbcTemplate;

	public int count(Integer player)
	{
		String sql = "SELECT count(1) FROM energy_log WHERE player = ?";
		return jdbcTemplate.queryForInt(sql, new Object[]
		{ player });
	}

	public int count(Integer player, String startTime, String endTime)
	{
		String sql = "SELECT count(1) FROM energy_log WHERE player = ? AND logTime >= ? AND logTime <= ?";
		return jdbcTemplate.queryForInt(sql, new Object[]
		{ player, startTime, endTime });
	}

	public List<EnergyLog> list(Integer rows, Integer page, String sort,
			String order, Integer player)
	{
		String sql = "SELECT * FROM energy_log t WHERE t.player = ?";
		sql = sql + " order by t." + sort + " " + order;
		sql = "SELECT * FROM (" + sql + ") a";
		return RSMapper.queryPage(jdbcTemplate, sql, rows, page,
				EnergyLog.class, new Object[]
				{ player });
	}

	public List<EnergyLog> list(Integer rows, Integer page, String sort,
			String order, Integer player, String startTime, String endTime)
	{
		String sql = "SELECT * FROM energy_log t WHERE t.player = ? AND t.logTime >= ? AND t.logTime <= ?";
		sql = sql + " order by t." + sort + " " + order;
		sql = "SELECT * FROM (" + sql + ") a";
		return RSMapper.queryPage(jdbcTemplate, sql, rows, page,
				EnergyLog.class, new Object[]
				{ player, startTime, endTime });
	}

	public List<EnergyLog> list(Integer player)
	{
		String sql = "SELECT * FROM energy_log t WHERE t.player = ?";
		sql = "SELECT * FROM (" + sql + ") a";
		return RSMapper.queryList(jdbcTemplate, sql, EnergyLog.class,
				new Object[]
				{ player });
	}

	public List<EnergyLog> list(Integer player, String startTime,
			String endTime)
	{
		String sql = "SELECT * FROM energy_log t WHERE t.player = ? AND t.logTime >= ? AND t.logTime <= ?";
		sql = "SELECT * FROM (" + sql + ") a";
		return RSMapper.queryList(jdbcTemplate, sql, EnergyLog.class,
				new Object[]
				{ player, startTime, endTime });
	}

}
