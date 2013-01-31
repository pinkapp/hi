package cc.ywxm.dao.impl.game;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cc.ywxm.dao.game.PropDao;
import cc.ywxm.model.game.Prop_;
import cc.ywxm.utils.RSMapper;

@Repository
public class PropDaoImpl implements PropDao
{
	// @Resource
	// private HibernateTemplate hibernateTemplate;
	@Resource
	private JdbcTemplate jdbcTemplate;

	public void delete(Integer player, Integer sid, Integer area)
	{
	}

	public Prop_ get(Integer player, Integer sid, Integer area)
	{
		String sql = "SELECT * FROM prop WHERE  player = ? AND kind = ? AND area = ?";
		return RSMapper.query(jdbcTemplate, sql, Prop_.class, new Object[]
		{ player, sid, area });
	}

	public List<Prop_> list(Integer player)
	{
		String sql = "SELECT t.player,t.id,t.kind,CASE t.area WHEN 1 THEN '背包' WHEN 2 THEN '仓库' WHEN 3 THEN '英雄' ELSE '未定义' END area,t.location,t.amount FROM prop t WHERE t.player = ?";
		sql = "select * from (" + sql + ")a";
		return RSMapper.queryList(jdbcTemplate, sql, Prop_.class, player);
	}

	public void save(Integer player, Integer sid, Integer amount)
	{
	}

}
