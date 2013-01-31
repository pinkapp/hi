package cc.ywxm.service.impl.game;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cc.ywxm.dao.game.GuildDao;
import cc.ywxm.model.game.Guild;
import cc.ywxm.service.game.GuildInfoService;

/**
 * 
 * @author HuangDeCai
 * @since 2012-12-1 9:34:24
 */
@Transactional
@Service
public class GuildInfoServiceImpl implements GuildInfoService
{
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Resource
	private GuildDao guildDao;

	public List<Guild> gets(String name)
	{
		if (name == null)
		{
			name = "";
		}
		name = name.trim();
		try
		{
			return guildDao.list(name);
		} catch (EmptyResultDataAccessException e)
		{
			log.error(e.getMessage());
			return new ArrayList<Guild>();
		} catch (Exception e)
		{
			log.error(e.getMessage());
			return new ArrayList<Guild>();
		}
	}

}
