package cc.ywxm.dao.impl.gm;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cc.ywxm.dao.gm.RightDao;
import cc.ywxm.model.gm.Right;
import cc.ywxm.utils.RSMapper;

@Repository
public class RightDaoImpl implements RightDao
{
	@Resource
	private HibernateTemplate hibernateTemplate;
	@Resource
	private JdbcTemplate jdbcTemplate;

	public RightDaoImpl()
	{
		super();
	}

	public void update(Right right)
	{
		hibernateTemplate.update(right);
	}

	public Right findById(Integer rightId)
	{
		return (Right) hibernateTemplate.get(Right.class, rightId);
	}

	public int count(Integer parentId)
	{
		String sql = "select count(1) from rights where parentId = ? and valid = 1";
		try
		{
			return jdbcTemplate.queryForInt(sql, new Object[]
			{ parentId });
		} catch (DataAccessException e)
		{
			e.printStackTrace();
			return 0;
		}
	}

	public List<Right> list(Integer parentId)
	{
		String sql = "select * from rights where parentId = ? and valid = 1 order by rseq";
		try
		{
			return RSMapper.queryList(jdbcTemplate, sql, Right.class,
					parentId);
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}

	}

	public int count(Integer parentId, String includeRightIds)
	{
		String sql = "select count(1) from rights where parentId = ? and valid = 1 and rightid in ("
				+ includeRightIds + ")";
		try
		{
			return jdbcTemplate.queryForInt(sql, new Object[]
			{ parentId });
		} catch (DataAccessException e)
		{
			e.printStackTrace();
			return 0;
		}
	}

	public List<Right> list(Integer parentId, String includeRightIds)
	{
		String sql = "select * from rights where parentId = ? and valid = 1 and rightId in ("
				+ includeRightIds + ") order by rseq";
		try
		{
			return RSMapper.queryList(jdbcTemplate, sql, Right.class,
					new Object[]
					{ parentId });
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public List<Right> list()
	{
		String sql = "select * from rights order by rightId";
		try
		{
			return RSMapper.queryList(jdbcTemplate, sql, Right.class);
		} catch (Exception e)
		{

			e.printStackTrace();
			return null;
		}
	}

	public void delete(Right right)
	{
		hibernateTemplate.delete(right);
	}

	public void save(Right right)
	{
		hibernateTemplate.save(right);
	}
}
