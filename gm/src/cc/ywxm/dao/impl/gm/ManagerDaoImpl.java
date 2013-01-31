package cc.ywxm.dao.impl.gm;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cc.ywxm.dao.gm.ManagerDao;
import cc.ywxm.model.gm.Manager;
import cc.ywxm.utils.RSMapper;

@Repository
public class ManagerDaoImpl implements ManagerDao
{
	@Resource
	private HibernateTemplate hibernateTemplate;
	@Resource
	private JdbcTemplate jdbcTemplate;

	public void update(Manager manager)
	{
		hibernateTemplate.update(manager);
	}

	public Manager findById(Integer userId)
	{
		return (Manager) hibernateTemplate.get(Manager.class, userId);
	}

	public void save(Manager manager)
	{
		hibernateTemplate.save(manager);
	}

	public void delete(Manager manager)
	{
		hibernateTemplate.delete(manager);
	}

	public int count(String userName, Short userType, Boolean valid)
	{
		String sql = "select count(1) from managers where 1 = 1";
		List<Object> list = new ArrayList<Object>();
		if (userName != null)
		{
			sql = sql + " and userName = ?";
			list.add(userName);
		}
		if (userType != null)
		{
			sql = sql + " and userType = ?";
			list.add(userType);
		}
		if (valid != null)
		{
			sql = sql + " and valid = ?";
			list.add(valid);
		}
		return jdbcTemplate.queryForInt(sql, list.toArray());
	}

	public List<Manager> list(Integer rows, Integer page, String userName,
			Short userType, Boolean valid)
	{

		String sql = "SELECT t.userId, t.userName,t1.typeName AS userType,t.note FROM managers t LEFT JOIN manager_type t1 ON t.userType = t1.typeId where 1 = 1";
		List<Object> list = new ArrayList<Object>();
		if (userName != null)
		{
			sql = sql + " and t.userName like ?";
			list.add("%" + userName + "%");
		}
		if (userType != null)
		{
			sql = sql + " and t.userType = ?";
			list.add(userType);
		}
		if (valid != null)
		{
			sql = sql + " and t.valid = ?";
			list.add(valid);
		}
		sql = "select * from (" + sql + ")a";
		return RSMapper.queryPage(jdbcTemplate, sql, rows, page, Manager.class,
				list.toArray());

	}

	public boolean exist(String userName, String password)
	{
		int count = jdbcTemplate
				.queryForInt(
						"select count(1) from managers where userName = ? and password = ?",
						new Object[]
						{ userName, password });
		if (count == 1)
		{
			return true;
		} else
		{
			return false;
		}
	}

	public Manager findByUserName(String userName)
	{
		String sql = "select * from managers where userName = ?";
		return RSMapper.query(jdbcTemplate, sql, Manager.class, userName);
	}

	public boolean exist(String userName)
	{
		int count = jdbcTemplate.queryForInt(
				"select count(1) from managers where userName = ?", new Object[]
				{ userName });
		if (count == 1)
		{
			return true;
		} else
		{
			return false;
		}
	}

	public Manager findById_(Integer userId)
	{
		String sql = "SELECT t.userId, t.userName,t1.typeName AS userType, t.note FROM managers t LEFT JOIN manager_type t1 ON t.userType = t1.typeId where t.userId = ?";
		sql = "select * from (" + sql + ")a";
		return RSMapper.query(jdbcTemplate, sql, Manager.class, userId);
	}

}
