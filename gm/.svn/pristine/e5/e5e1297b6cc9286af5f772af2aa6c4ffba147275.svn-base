package cc.ywxm.dao.impl.game;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cc.ywxm.dao.game.FunctionBuildingDao;
import cc.ywxm.model.game.FunctionBuilding;
import cc.ywxm.model.game.FunctionBuildingId;
import cc.ywxm.model.game.FunctionBuilding_;
import cc.ywxm.utils.RSMapper;

@Repository
public class FunctionBuildingDaoImpl implements FunctionBuildingDao
{
	@Resource
	private JdbcTemplate jdbcTemplate;
	@Resource
	private HibernateTemplate hibernateTemplate;

	public void delete(FunctionBuilding fb)
	{
		hibernateTemplate.delete(fb);
	}

	public FunctionBuilding findById(FunctionBuildingId id)
	{
		return (FunctionBuilding) hibernateTemplate.get(FunctionBuilding.class,
				id);
	}

	public void save(FunctionBuilding fb)
	{
		hibernateTemplate.save(fb);
	}

	public void update(FunctionBuilding fb)
	{
		hibernateTemplate.update(fb);
	}

	public List<FunctionBuilding_> list(Integer player)
	{
		String sql = "SELECT t.id, t.kind, t.x, t.y, t.aspect, t.level, t.progress, t.last_reap AS lastReap FROM function_building t WHERE t.player = ?";
		sql = "select * from (" + sql + ")a";
		return RSMapper.queryList(jdbcTemplate, sql, FunctionBuilding_.class,
				player);
	}
}
