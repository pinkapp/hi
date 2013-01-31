package cc.ywxm.service.impl.game;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cc.ywxm.dao.game.ArenaInfoDao;
import cc.ywxm.dao.game.BaseInfoDao;
import cc.ywxm.model.game.ArenaInfo;
import cc.ywxm.service.game.ArenaInfoService;

/**
 * 
 * @author HuangDeCai
 * @since 2012-12-6 16:46:52
 */
@Transactional
@Service
public class ArenaInfoServiceImpl implements ArenaInfoService
{
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Resource
	private ArenaInfoDao arenaInfoDao;
	@Resource
	private BaseInfoDao baseInfoDao;

	public List<ArenaInfo> gets(String nickname)
	{
		List<ArenaInfo> result = new ArrayList<ArenaInfo>();
		if (nickname == null || nickname.trim().equals(""))
		{
			try
			{
				result = arenaInfoDao.listOrderByRank();
			} catch (Exception e)
			{
				log.error(e.getMessage());
			}
		} else
		{
			Integer player = null;
			nickname = nickname.trim();
			try
			{
				player = baseInfoDao.findPlayerByNickname(nickname);

			} catch (Exception e)
			{
				log.error(e.getMessage());
			}
			if (player != null)
			{
				ArenaInfo arenaInfo = arenaInfoDao.findById(player);
				if (arenaInfo.getPlayer() != null)
				{
					result.add(arenaInfo);
				}
			}
		}
		return result;
	}
}
