package cc.ywxm.dao.impl.game;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cc.ywxm.dao.game.ConsumeLogDao;
import cc.ywxm.model.game.ConsumeLog;
import cc.ywxm.utils.RSMapper;

@Repository
public class ConsumeLogDaoImpl implements ConsumeLogDao
{
	@Resource
	private HibernateTemplate hibernateTemplate;
	@Resource
	private JdbcTemplate jdbcTemplate;

	public void delete(ConsumeLog log)
	{
		hibernateTemplate.delete(log);
	}

	public ConsumeLog get(Long logId)
	{
		return (ConsumeLog) hibernateTemplate.get(ConsumeLog.class, logId);
	}

	public ConsumeLog load(Long logId)
	{
		return (ConsumeLog) hibernateTemplate.load(ConsumeLog.class, logId);
	}

	public void save(ConsumeLog log)
	{
		hibernateTemplate.save(log);
	}

	public void update(ConsumeLog log)
	{
		hibernateTemplate.update(log);
	}

	public int count(Integer player)
	{
		String sql = "select count(1) from consume_log where player = ?";
		return jdbcTemplate.queryForInt(sql, new Object[]
		{ player });
	}

	public int count(Integer player, String startTime, String endTime)
	{
		String sql = "select count(1) from consume_log where player = ? and logTime >= ? and logTime <= ?";
		return jdbcTemplate.queryForInt(sql, new Object[]
		{ player, startTime, endTime });
	}
	
	public List<ConsumeLog> list(Integer rows, Integer page, String sort,
			String order, Integer player)
	{
		String sql = "SELECT * FROM consume_log t where t.player = ?";
		sql = sql + " order by t." + sort + " " + order;
		sql = "select * from (" + sql + ") a";
		return RSMapper.queryPage(jdbcTemplate, sql, rows, page,
				ConsumeLog.class, new Object[]
				{ player });
	}

	public List<ConsumeLog> list(Integer rows, Integer page, String sort,
			String order, Integer player, String startTime, String endTime)
	{
		String sql = "SELECT * FROM consume_log t where t.player = ? and t.logTime >= ? and t.logTime <= ?";
		sql = sql + " order by t." + sort + " " + order;
		sql = "select * from (" + sql + ") a";
		return RSMapper.queryPage(jdbcTemplate, sql, rows, page,
				ConsumeLog.class, new Object[]
				{ player, startTime, endTime });
	}

	

	public List<ConsumeLog> list(Integer player)
	{
		String sql = "SELECT * FROM consume_log t where t.player = ?";
		sql = "select * from (" + sql + ") a";
		return RSMapper.queryList(jdbcTemplate, sql, ConsumeLog.class,
				new Object[]
				{ player });
	}

	public List<ConsumeLog> list(Integer player, String startTime,
			String endTime)
	{
		String sql = "SELECT * FROM consume_log t where t.player = ? and t.logTime >= ? and t.logTime <= ?";
		sql = "select * from (" + sql + ") a";
		return RSMapper.queryList(jdbcTemplate, sql, ConsumeLog.class,
				new Object[]
				{ player, startTime, endTime });
	}

}
