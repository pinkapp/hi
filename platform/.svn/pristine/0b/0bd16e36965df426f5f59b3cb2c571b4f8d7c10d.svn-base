package cc.ywxm.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cc.ywxm.dao.GameDao;
import cc.ywxm.model.Game;
import cc.ywxm.service.GameService;

@Service
@Transactional
public class GameServiceImpl implements GameService
{
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Resource
	private GameDao gameDao;

	public int add(Game game)
	{
		return 0;
	}

	public int delete(Integer serverId)
	{
		return 0;
	}

	public int edit(Game game)
	{
		return 0;
	}

	public Game get(Integer serverId)
	{
		Game result = null;
		try
		{
			result = gameDao.get(serverId);
		} catch (Exception e)
		{
			log.error(e.getMessage());
		}
		return result;
	}

}
