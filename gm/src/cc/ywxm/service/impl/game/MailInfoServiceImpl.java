package cc.ywxm.service.impl.game;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cc.ywxm.dao.game.BaseInfoDao;
import cc.ywxm.dao.game.MailDao;
import cc.ywxm.service.game.MailInfoService;

@Transactional
@Service
public class MailInfoServiceImpl implements MailInfoService
{
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Resource
	private BaseInfoDao baseInfoDao;
	@Resource
	private MailDao mailDao;

	public Map<String, Object> gets(Integer rows, Integer page, Integer player)
	{
		Map<String, Object> result = new HashMap<String, Object>();
		return result;
	}

	public Map<String, Object> gets(Integer rows, Integer page, String nickname)
	{
		Map<String, Object> result = new HashMap<String, Object>();
		return result;
	}

	public Map<String, Object> gets(Integer rows, Integer page, String sort,
			String order, Integer player)
	{
		Map<String, Object> result = new HashMap<String, Object>();

		if (sort == null || "".equals(sort.trim()))
		{
			sort = "time";
		}
		if (order == null || "".equals(order.trim()))
		{
			order = "desc";
		}
		try
		{
			int total = mailDao.count(player);
			Object r = mailDao.list(rows, page, sort, order, player);
			result.put("rows", r);
			result.put("total", total);
		} catch (Exception e)
		{
			log.error(e.getMessage());
		}
		return result;
	}

	public Map<String, Object> gets(Integer rows, Integer page, String sort,
			String order, String nickname)
	{
		Integer player = null;
		Map<String, Object> result = new HashMap<String, Object>();
		if (nickname != null)
		{
			nickname = nickname.trim();
		}
		if (nickname == null || "".equals(nickname))
		{
			return result;
		} else if ("system".equals(nickname))
		{
			player = 0;
		} else
		{
			player = baseInfoDao.findPlayerByNickname(nickname);
		}
		return this.gets(rows, page, sort, order, player);
	}

}
