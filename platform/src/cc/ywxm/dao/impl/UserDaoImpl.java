package cc.ywxm.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cc.ywxm.dao.UserDao;
import cc.ywxm.model.User;
import cc.ywxm.utils.DateFormat;
import cc.ywxm.utils.RSMapper;

@Repository
public class UserDaoImpl implements UserDao
{
	@Resource
	private JdbcTemplate jdbcTemplate;

	public List<User> find(String username, String passwd)
	{
		String sql = "SELECT * FROM users WHERE username = ? AND passwd = ?";
		List<User> users = null;
		RSMapper.queryList(jdbcTemplate, sql, User.class, new Object[]
		{ username, passwd });
		return users;
	}

	public User findById(Integer userId)
	{
		String sql = "SELECT t.userId,t.username,t.passwd FROM users t WHERE t.userId = ?";
		sql = "select * from (" + sql + ")a";
		return RSMapper.query(jdbcTemplate, sql, User.class, new Object[]
		{ userId });
	}

	public void update(User user)
	{
		String sql = "UPDATE users SET passwd = ? WHERE userId = ?";
		jdbcTemplate.update(sql, new Object[]
		{ user.getPassword(), user.getUserId() });
	}

	public void save(User user)
	{
		String sql = "INSERT INTO users(username, passwd) VALUES (?, ?)";
		jdbcTemplate.update(sql, new Object[]
		{ user.getUsername(), user.getPassword() });
	}

	public List<User> find(User condition)
	{
		String hql = "from User o";
		if (StringUtils.isNotEmpty(condition.getUsername()))
		{
			hql += " and o.username=?";
		}
		return null;
	}

	public User findByUsername(String username)
	{
		String sql = "SELECT t.userId,t.username,t.passwd FROM users t WHERE t.username = ?";
		sql = "select * from (" + sql + ")a";
		return RSMapper.query(jdbcTemplate, sql, User.class, new Object[]
		{ username });
	}

	public void batchDelete(final Integer[] user_ids)
	{
		jdbcTemplate.batchUpdate("UPDATE users SET  = 1 WHERE userId = ?",
				new BatchPreparedStatementSetter()
				{

					public void setValues(PreparedStatement ps, int i)
							throws SQLException
					{
						ps.setInt(1, user_ids[i]);

					}

					public int getBatchSize()
					{
						return user_ids.length;
					}
				});
	}

	public void delele(User user)
	{

		jdbcTemplate.update("UPDATE users SET status_ = 1 WHERE userId = ?",
				new Object[]
				{ user.getUserId() });

	}

	public List<String> findList(final String sql, final Integer userId)
	{
		// return (List<String>) hibernateTemplate.execute(new
		// HibernateCallback()
		// {
		//
		// public Object doInHibernate(Session session)
		// throws HibernateException, SQLException
		// {
		// return session.createSQLQuery(sql).setInteger(0, userId).list();
		// }
		// });
		return null;
	}

	public void grant(Integer userId, Integer roleId)
	{
		String deleteSQL = "delete from user_role where userId = ?";
		String insertSQL = "insert into user_role(userId, role_id) values(?, ?)";
		jdbcTemplate.update(deleteSQL, new Object[]
		{ userId });
		// 如果是0，则是默认用户
		if (roleId.intValue() != 0)
		{
			jdbcTemplate.update(insertSQL, new Object[]
			{ userId, roleId });
		}

	}

	public Short findRoleIdByUserId(final Integer userId)
	{

		final String sql = "SELECT t.role_id FROM user_role t WHERE t.userId = ?";
		final String sql1 = "SELECT count(1) FROM user_role t WHERE t.userId = ?";
		int i = jdbcTemplate.queryForInt(sql1, new Object[]
		{ userId });
		if (i == 0)
		{
			return 0;
		}
		return (Short) jdbcTemplate.queryForObject(sql, new Object[]
		{ userId }, Short.class);
		// return hibernateTemplate.execute(new HibernateCallback<Short>() {
		// public Short doInHibernate(Session session)
		// throws HibernateException, SQLException {
		// return ((Byte) session.createSQLQuery(sql)
		// .setInteger(0, userId).uniqueResult()).shortValue();
		// }
		// });
	}

	public User findByEmail(String email)
	{
		// List<User> users = hibernateTemplate.find(
		// "from User o where o.email = ?", email);
		// if (users == null || users.size() == 0)
		// return null;
		// return users.get(0);
		return null;
	}

	public int findAgegroupCount(int startAge, int endAge)
	{
		String sql = "SELECT COUNT(*) FROM (SELECT userId, (YEAR(CURDATE())-YEAR(STR_TO_DATE(birthday,'%Y-%m-%d'))) - (RIGHT(CURDATE(),5)<RIGHT(STR_TO_DATE(birthday,'%Y-%m-%d'),5)) AS age FROM users) t WHERE t.age >= ? AND t.age<= ?";
		return jdbcTemplate.queryForInt(sql, new Object[]
		{ startAge, endAge });
	}

	public int findOtherAgegroupCount()
	{
		String sql = "SELECT COUNT(*) FROM (SELECT userId, (YEAR(CURDATE())-YEAR(STR_TO_DATE(birthday,'%Y-%m-%d'))) - (RIGHT(CURDATE(),5)<RIGHT(STR_TO_DATE(birthday,'%Y-%m-%d'),5)) AS age FROM users) t WHERE t.age IS NULL";
		return jdbcTemplate.queryForInt(sql);
	}

	@SuppressWarnings("unchecked")
	public List<String> findUsersByUsername(String str)
	{
		String sql = "SELECT username FROM USER WHERE lower(username) LIKE ?";
		return jdbcTemplate.queryForList(sql, new Object[]
		{ "%" + str + "%" }, String.class);
	}

	@SuppressWarnings("unchecked")
	public List<String> findAllUsername()
	{
		String sql = "SELECT username FROM USER";
		return jdbcTemplate.queryForList(sql, String.class);
	}

	public int findRegisterTotalCount(Date date)
	{
		String sql = "SELECT COUNT(1) FROM users t WHERE t.rtime < ?";
		date.setTime(date.getTime() + 1000 * 60 * 60 * 24l);
		String time = DateFormat.format(date, DateFormat.DATE_PATTERN_2);
		return jdbcTemplate.queryForInt(sql, new Object[]
		{ time });
	}

	public int findSexCount(Integer sexflag)
	{
		String sql = "SELECT COUNT(1) FROM users WHERE sex = ?";
		return jdbcTemplate.queryForInt(sql, new Object[]
		{ sexflag });
	}

	public int findOtherSexCount()
	{
		String sql = "SELECT COUNT(1) FROM users WHERE sex is null";
		return jdbcTemplate.queryForInt(sql);
	}

	public Integer findRegisterUsersPerday(String dstring)
	{
		String sql = "SELECT COUNT(1) FROM users t WHERE LEFT(t.rtime, 10) = ?";
		return jdbcTemplate.queryForInt(sql, new Object[]
		{ dstring });
	}

	public Integer findRegisterUsers(String dstring)
	{
		String sql = "SELECT COUNT(1) FROM users t WHERE t.rtime < ?";
		Date d = DateFormat.parse(dstring, DateFormat.DATE_PATTERN_2);
		d.setTime(d.getTime() + 1000 * 60 * 60 * 24l);
		String time = DateFormat.format(d, DateFormat.DATE_PATTERN_2);
		return jdbcTemplate.queryForInt(sql, new Object[]
		{ time });
	}

	public void updateSecondaryPassword(Integer userId, String spasswd)
	{
		String sql = "UPDATE user SET spasswd = ? WHERE userId = ?";
		jdbcTemplate.update(sql, new Object[]
		{ spasswd, userId });
	}

	public String findSecondaryPassword(int userId)
	{
		String sql = "SELECT spasswd FROM users WHERE userId = ?";
		return (String) jdbcTemplate.queryForObject(sql, new Object[]
		{ userId }, String.class);
	}

	public String findEmail(String username)
	{
		String sql = "SELECT email FROM users WHERE username = ?";
		return (String) jdbcTemplate.queryForObject(sql, new Object[]
		{ username }, String.class);
	}

	public String findPhone(String username)
	{
		String sql = "SELECT phone FROM users WHERE username = ?";
		return (String) jdbcTemplate.queryForObject(sql, new Object[]
		{ username }, String.class);
	}

	public void resetPassword(String username, String passwd)
	{
		String sql = "UPDATE user SET passwd = ? WHERE username = ?";
		jdbcTemplate.update(sql, new Object[]
		{ passwd, username });
	}

	public String findPhone(int userId)
	{
		String sql = "SELECT phone FROM users WHERE userId = ?";
		return (String) jdbcTemplate.queryForObject(sql, new Object[]
		{ userId }, String.class);
	}

	public void resetPassword(int userId, String passwd)
	{
		String sql = "UPDATE user SET passwd = ? WHERE userId = ?";
		jdbcTemplate.update(sql, new Object[]
		{ passwd, userId });

	}

	public List<User> findByExample(User example)
	{
		// return hibernateTemplate.findByExample(example);
		return null;
	}

	public List<User> find(int userId, String passwd)
	{
		return null;
	}

	public Integer findStatusCode(String username)
	{
		String sql = "SELECT status_ FROM users WHERE username = ?";
		return (Integer) jdbcTemplate.queryForObject(sql, new Object[]
		{ username }, Integer.class);
	}

	public Integer findStatusCode(int userId)
	{
		String sql = "SELECT status_ FROM users WHERE userId = ?";
		return (Integer) jdbcTemplate.queryForObject(sql, new Object[]
		{ userId }, Integer.class);
	}

	public void updateStatusCode(int userId, int statusCode)
	{
		String sql = "UPDATE user SET status_ = ? WHERE userId = ?";
		jdbcTemplate.update(sql, new Object[]
		{ statusCode, userId });
	}

	public void close(Integer userId, Short closeType, String closeReason,
			String closeEndtime)
	{
		String sql = "UPDATE user SET status_ = 0 WHERE userId = ?";
		jdbcTemplate.update(sql, new Object[]
		{ closeReason, closeType, closeEndtime, userId });

	}

	public void recover(int userId)
	{
		String sql = "UPDATE user SET status_ = 1 WHERE userId = ?";
		jdbcTemplate.update(sql, new Object[]
		{ userId });
	}

	public User findByPhone(String phone)
	{
		// List<User> users = hibernateTemplate.find(
		// "from User o where o.phone = ?", phone);
		// if (users == null || users.size() == 0)
		// return null;
		// return users.get(0);
		return null;
	}

	public String findCardId(int userId)
	{
		String sql = "SELECT cid FROM users WHERE userId = ?";
		return (String) jdbcTemplate.queryForObject(sql, new Object[]
		{ userId }, String.class);
	}

	public int count(String username, String passwd)
	{
		String sql = "select count(*) from users where username = ? and passwd = ?";
		return jdbcTemplate.queryForInt(sql, new Object[]
		{ username, passwd });
	}
}
