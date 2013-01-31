package cc.ywxm.dao.impl.game;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cc.ywxm.dao.game.MailDao;
import cc.ywxm.model.game.Mail;
import cc.ywxm.utils.RSMapper;

@Repository
public class MailInfoDaoImpl implements MailDao
{
	@Resource
	private JdbcTemplate jdbcTemplate;

	public int count(Integer player)
	{
		String sql = "select count(1) from mail where uid = ?";
		return jdbcTemplate.queryForInt(sql, new Object[]
		{ player });
	}

	public int count(String nickname)
	{
		return 0;
	}

	public void delete(Mail mail)
	{
	}

	public Mail findByPlayer(Integer player)
	{
		return null;
	}

	public List<Mail> list(Integer rows, Integer page, Integer player)
	{
		return null;
	}

	public List<Mail> list(Integer rows, Integer page, String sort,
			String order, Integer player)
	{
		String sql = "SELECT t.player,t.mail_id AS mailId,CASE t.read WHEN 1 THEN '已读' WHEN 0 THEN '未读' END AS read_,t.type,CASE t.has_attach WHEN 1 THEN '有附件' WHEN 0 THEN '无附件' END AS hasAttach,FROM_UNIXTIME(t.time) AS time,t.nickname,t.subject,t.content,t1.nickname AS nickname1 FROM mail t LEFT JOIN base_info t1 ON t.player= t1.player WHERE t.uid = ?";
		sql = sql + " order by t." + sort + " " + order;
		sql = "select * from (" + sql + ") a";
		return RSMapper.queryPage(jdbcTemplate, sql, rows, page, Mail.class,
				new Object[]
				{ player });
	}

	public List<Mail> list(Integer rows, Integer page, String nickname)
	{
		return null;
	}

	public List<Mail> list(Integer rows, Integer page, String sort,
			String order, String nickname)
	{
		return null;
	}

	public void save(Mail mail)
	{

	}

	public void update(Mail mail)
	{

	}

}
