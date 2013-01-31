package cc.ywxm.service.impl.game;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cc.ywxm.dao.game.BaseInfoDao;
import cc.ywxm.dao.game.HeroDao;
import cc.ywxm.model.game.Hero;
import cc.ywxm.service.game.HeroInfoService;

/**
 * 
 * @author HuangDeCai
 * @since 2012-11-30 9:21:34
 */
@Transactional
@Service
public class HeroInfoServiceImpl implements HeroInfoService
{
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Resource
	private HeroDao heroDao;
	@Resource
	private BaseInfoDao baseInfoDao;

	public List<Hero> gets(String player)
	{
		if (player == null || "".trim().equals(player))
		{
			return new ArrayList<Hero>();
		}
		Integer player_;
		String nickname = "";
		try
		{
			player_ = Integer.parseInt(player);
		} catch (NumberFormatException e)
		{
			nickname = player;
			player_ = baseInfoDao.findPlayerByNickname(nickname);
			log.error(e.getMessage());
		}
		try
		{
			return heroDao.list(player_);
		} catch (EmptyResultDataAccessException e)
		{
			log.error(e.getMessage());
			return new ArrayList<Hero>();
		} catch (Exception e)
		{
			log.error(e.getMessage());
			return new ArrayList<Hero>();
		}
	}

}
