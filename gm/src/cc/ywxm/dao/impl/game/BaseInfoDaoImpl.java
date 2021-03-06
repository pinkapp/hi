package cc.ywxm.dao.impl.game;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import cc.ywxm.dao.game.BaseInfoDao;
import cc.ywxm.model.game.BaseInfo;
import cc.ywxm.utils.RSMapper;

@Repository
public class BaseInfoDaoImpl implements BaseInfoDao
{
	// @Resource
	// private HibernateTemplate hibernateTemplate;
	@Resource
	private JdbcTemplate jdbcTemplate;

	public int count(String nickname)
	{
		String sql = "select count(1) from base_info where 1 = 1";
		List<Object> args = new ArrayList<Object>();
		if (nickname != null)
		{
			sql = sql + " and nickname like ?";
			args.add("%" + nickname + "%");
		}
		return jdbcTemplate.queryForInt(sql, args.toArray());
	}

	public BaseInfo get(Integer player)
	{
		String sql = "SELECT player, nickname, sex, country, gold, silver, exp, energy, feat, prestige,"
				+ "mobility, level, progress, array, recharged_gold AS rechargedGold FROM base_info t WHERE player = ?";
		sql = "SELECT * FROM (" + sql + ")a";
		return RSMapper.query(jdbcTemplate, sql, BaseInfo.class, new Object[]
		{ player });
	}

	public List<BaseInfo> list(Integer rows, Integer page, String nickname)
	{
		String sql = "SELECT t.player,t.nickname,t.sex,t.country,t.gold,t.silver,t.exp,t.energy,t.feat,t.prestige,t.mobility,t.level,t.progress,t.array,t.recharged_gold AS rechargedGold,t1.name AS guildId FROM base_info t LEFT JOIN guild t1 ON t.guild_id = t1.guild_id WHERE 1 = 1";
		List<Object> args = new ArrayList<Object>();
		if (nickname != null)
		{
			sql = sql + " and t.nickname like ?";
			args.add("%" + nickname + "%");
		}
		sql = "select * from (" + sql + ") a";
		return RSMapper.queryPage(jdbcTemplate, sql, rows, page,
				BaseInfo.class, args.toArray());
	}

	public void update(BaseInfo baseInfo)
	{

	}

	public List<BaseInfo> list(Integer rows, Integer page, String sort,
			String order, String nickname)
	{
		String sql = "SELECT t.player,t.nickname,t.sex,t.country,t.gold,t.silver,t.exp,t.energy,t.feat,t.prestige,t.mobility,t.level,t.progress,t.array,t.recharged_gold AS rechargedGold,t1.name AS guildId FROM base_info t LEFT JOIN guild t1 ON t.guild_id = t1.guild_id WHERE 1 = 1";
		List<Object> args = new ArrayList<Object>();
		if (nickname != null)
		{
			sql = sql + " and t.nickname like ?";
			args.add("%" + nickname + "%");
		}
		if (sort != null && order != null)
		{
			sql = sql + " order by " + sort + " " + order;
			// args.add(sort);
			// args.add(order);
		}
		sql = "select * from (" + sql + ") a";
		return RSMapper.queryPage(jdbcTemplate, sql, rows, page,
				BaseInfo.class, args.toArray());
	}

	public void save(final BaseInfo baseInfo)
	{
		String sql = "call create_player(?, ?, ?)";
		jdbcTemplate.execute(sql, new PreparedStatementCallback()
		{

			public Object doInPreparedStatement(PreparedStatement ps)
					throws SQLException, DataAccessException
			{
				ps.setInt(1, baseInfo.getPlayer());
				ps.setString(2, baseInfo.getNickname());
				ps.setString(3, baseInfo.getSex());
				ps.execute();
				return null;
			}
		});
	}

	public int maxId()
	{
		String sql = "select max(player) from base_info";
		return jdbcTemplate.queryForInt(sql);
	}

	public boolean nicknameExist(String nickname)
	{
		String sql = "select count(1) from base_info where nickname = ?";
		int n = jdbcTemplate.queryForInt(sql, new Object[]
		{ nickname });
		if (n > 0)
		{
			return true;
		}
		return false;
	}

	public Integer findPlayerByNickname(String nickname)
	{
		String sql = "select player from base_info where nickname = ?";
		return jdbcTemplate.queryForInt(sql, new Object[]
		{ nickname });
	}

	public void update(final Integer player, final Integer gold,
			final Double silver, final Integer exp, final Short energy,
			final Integer feat, final Integer prestige, final Short mobility,
			final Short level, final Short progress)
	{
		String sql = "UPDATE base_info SET gold = gold + ?, silver = silver + ?, exp = exp + ?, energy = energy + ?, feat = feat + ?, prestige = prestige + ?, mobility = mobility + ?, level = level + ?, progress = progress + ?"
				+ " WHERE player = ?";
		try
		{
			jdbcTemplate.update(sql, new Object[]
			{ gold, silver, exp, energy, feat, prestige, mobility, level,
					progress, player });
		} catch (DataAccessException e)
		{
			e.printStackTrace();
		}
	}

	public void updateGold(Integer player, Integer value)
	{
		String sql = "UPDATE base_info SET gold = gold + ?  WHERE player = ?";
		jdbcTemplate.update(sql, new Object[]
		{ value, player });
	}

	public void updateSilver(Integer player, Integer value)
	{
		String sql = "UPDATE base_info SET silver = silver + ?  WHERE player = ?";
		jdbcTemplate.update(sql, new Object[]
		{ value, player });

	}

	public void updateEnergy(Integer player, Integer value)
	{
		String sql = "UPDATE base_info SET energy = energy + ?  WHERE player = ?";
		jdbcTemplate.update(sql, new Object[]
		{ value, player });

	}

	public void updateMobility(Integer player, Integer value)
	{
		String sql = "UPDATE base_info SET mobility = mobility + ?  WHERE player = ?";
		jdbcTemplate.update(sql, new Object[]
		{ value, player });

	}

	public void updateProgress(Integer player, Integer value)
	{
		String sql = "UPDATE base_info SET progress = ?  WHERE player = ?";
		jdbcTemplate.update(sql, new Object[]
		{ value, player });
	}

	public void updateRechargedGold(Integer player, Integer value)
	{
		String sql = "UPDATE base_info SET recharged_gold = recharged_gold + ?, gold = gold + ?  WHERE player = ?";
		jdbcTemplate.update(sql, new Object[]
		{ value, value, player });
	}

	public void updateFeat(Integer player, Integer value)
	{
		String sql = "UPDATE base_info SET feat = feat + ?  WHERE player = ?";
		jdbcTemplate.update(sql, new Object[]
		{ value, player });
	}

	public void updatePrestige(Integer player, Integer value)
	{
		String sql = "UPDATE base_info SET prestige = prestige + ?  WHERE player = ?";
		jdbcTemplate.update(sql, new Object[]
		{ value, player });
	}

}
