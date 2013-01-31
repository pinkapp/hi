package cc.ywxm.dao.impl.game;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cc.ywxm.dao.game.HeroDao;
import cc.ywxm.model.game.Hero;
import cc.ywxm.utils.RSMapper;

@Repository
public class HeroDaoImpl implements HeroDao
{
	@Resource
	private JdbcTemplate jdbcTemplate;

	public void delete(Hero hero)
	{

	}

	public Hero findById(Integer player)
	{
		return null;
	}

	public List<Hero> list(Integer player)
	{
		String sql = "SELECT t.id, t.level, t.status, t.exp, t.bringup_bin AS bringupBin FROM hero t WHERE t.player = ?";
		sql = "select * from (" + sql + ")a";
		return RSMapper.queryList(jdbcTemplate, sql, Hero.class, player);
	}

	public void save(Hero hero)
	{

	}

	public void update(Hero hero)
	{

	}

}
