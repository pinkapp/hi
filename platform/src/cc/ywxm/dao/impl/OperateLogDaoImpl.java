package cc.ywxm.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cc.ywxm.dao.OperateLogDao;
import cc.ywxm.model.OperateLog;
import cc.ywxm.utils.RSMapper;

@Repository
public class OperateLogDaoImpl implements OperateLogDao
{
	@Resource
	private JdbcTemplate jdbcTemplate;

	public void save(String info, String operator, String ipAddress)
	{
		String sql = "INSERT INTO operate_log(info, operator, ipAddress, logTime) VALUE (?,?,?,NOW())";
		jdbcTemplate.update(sql, new Object[]
		{ info, operator, ipAddress });
	}

	public void save(String info, String operator, String ipAddress,
			String logTime)
	{
		String sql = "INSERT INTO operate_log(info, operator, ipAddress, logTime) VALUE (?,?,?,?)";
		jdbcTemplate.update(sql, new Object[]
		{ info, operator, ipAddress, logTime });
	}

	public int count(String username)
	{
		String sql = "select count(1) from operate_log where operator = ?";
		return jdbcTemplate.queryForInt(sql, new Object[]
		{ username });
	}

	public int count(String username, String startTime, String endTime)
	{
		String sql = "select count(1) from operate_log where operator = ? and logTime >= ? and logTime <= ?";
		return jdbcTemplate.queryForInt(sql, new Object[]
		{ username, startTime, endTime });
	}

	public List<OperateLog> list(Integer rows, Integer page, String sort,
			String order, String username)
	{
		// String sql = "SELECT * FROM operate_log t where t.operator = ?";
		// sql = sql + " order by t." + sort + " " + order;
		// sql = "select * from (" + sql + ") a";
		// return RSMapper.queryPage(jdbcTemplate, sql, rows, page,
		// OperateLog.class, new Object[]
		// { username });
		return null;
	}

	public List<OperateLog> list(Integer rows, Integer page, String sort,
			String order, String username, String startTime, String endTime)
	{
		// String sql =
		// "SELECT * FROM operate_log t where t.operator = ? and t.logTime >= ? and t.logTime <= ?";
		// sql = sql + " order by t." + sort + " " + order;
		// sql = "select * from (" + sql + ") a";
		// return RSMapper.queryPage(jdbcTemplate, sql, rows, page,
		// OperateLog.class, new Object[]
		// { username, startTime, endTime });
		return null;
	}

	public List<OperateLog> list(String username)
	{
		String sql = "SELECT * FROM operate_log t where t.operator = ?";
		sql = "select * from (" + sql + ") a";
		return RSMapper.queryList(jdbcTemplate, sql, OperateLog.class,
				new Object[]
				{ username });
	}

	public List<OperateLog> list(String username, String startTime,
			String endTime)
	{
		String sql = "SELECT * FROM operate_log t where t.operator = ? and t.logTime >= ? and t.logTime <= ?";
		sql = "select * from (" + sql + ") a";
		return RSMapper.queryList(jdbcTemplate, sql, OperateLog.class,
				new Object[]
				{ username, startTime, endTime });
	}

}
