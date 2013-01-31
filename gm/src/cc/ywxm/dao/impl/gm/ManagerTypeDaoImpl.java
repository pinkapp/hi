package cc.ywxm.dao.impl.gm;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cc.ywxm.dao.gm.ManagerTypeDao;
import cc.ywxm.model.gm.ManagerType;
import cc.ywxm.utils.RSMapper;

@Repository
public class ManagerTypeDaoImpl implements ManagerTypeDao
{
	@Resource
	private HibernateTemplate hibernateTemplate;
	@Resource
	private JdbcTemplate jdbcTemplate;

	public void update(ManagerType managerType)
	{
		hibernateTemplate.update(managerType);
	}

	public ManagerType findById(Short typeId)
	{
		return (ManagerType)hibernateTemplate.get(ManagerType.class, typeId);
	}

	public void save(ManagerType managerType)
	{
		hibernateTemplate.save(managerType);
	}

	public void delete(ManagerType managerType)
	{
		hibernateTemplate.delete(managerType);
	}

	public int count(Object... args)
	{
		String sql = "select count(1) from manager_type";
		return jdbcTemplate.queryForInt(sql, args);
	}

	public List<ManagerType> list()
	{
		
		String sql = "select * from manager_type";
		return RSMapper.queryList(jdbcTemplate, sql, ManagerType.class);

	}

}
