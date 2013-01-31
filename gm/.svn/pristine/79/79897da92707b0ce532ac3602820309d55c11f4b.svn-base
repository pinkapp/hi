package cc.ywxm.dao.impl.game;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cc.ywxm.dao.game.GuildDao;
import cc.ywxm.model.game.Guild;
import cc.ywxm.utils.RSMapper;

@Repository
public class GuildDaoImpl implements GuildDao
{
	@Resource
	private JdbcTemplate jdbcTemplate;

	public void delete(Guild hero)
	{

	}

	public Guild findById(Integer guildId)
	{
		return null;
	}

	public List<Guild> list(String name)
	{
		String sql = "SELECT t.guild_id AS guildId, t.name, t.level, t.leader, t.icon, t.icon_frame AS iconFrame, t.exp, t.activity_exp activityExp, t.call_board AS callBoard ,t1.members FROM guild t"
				+ " LEFT JOIN (SELECT guild_id, COUNT(guild_id) AS members FROM guild_member_info GROUP BY guild_id) t1 ON t.guild_id = t1.guild_id WHERE t.name like ?";
		sql = "select * from (" + sql + ")a";
		return RSMapper.queryList(jdbcTemplate, sql, Guild.class, "%" + name
				+ "%");
	}

	public void save(Guild hero)
	{

	}

	public void update(Guild hero)
	{

	}

}
