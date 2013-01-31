package cc.ywxm.dao.impl.game;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cc.ywxm.dao.game.BusinessBuildingDao;
import cc.ywxm.model.game.BusinessBuilding;
import cc.ywxm.utils.RSMapper;

@Repository
public class BusinessBuildingDaoImpl implements BusinessBuildingDao
{
	@Resource
	private JdbcTemplate jdbcTemplate;

	public void delete(BusinessBuilding bb)
	{

	}

	public BusinessBuilding findById(Integer player)
	{
		return null;
	}

	public List<BusinessBuilding> list(Integer player)
	{
		String sql = "SELECT t.id, t.kind, t.x, t.y, t.aspect, t.warehoused, t.progress, t.last_reap AS lastReap FROM business_building t WHERE t.player = ?";
		sql = "select * from (" + sql + ")a";
		return RSMapper.queryList(jdbcTemplate, sql, BusinessBuilding.class, player);
	}

	public void save(BusinessBuilding bb)
	{

	}

	public void update(BusinessBuilding bb)
	{

	}

}
