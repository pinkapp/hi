package cc.ywxm.service.impl.game;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cc.ywxm.dao.game.BaseInfoDao;
import cc.ywxm.model.game.BaseInfo;
import cc.ywxm.service.game.PlayerService;

@Transactional
@Service
public class PlayerServiceImpl implements PlayerService
{
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Resource
	private BaseInfoDao baseInfoDao;

	public int login(Integer player)
	{
		if (player == null)
		{
			return CODE_PLAYER_NULL;
		}
		BaseInfo baseInfo = null;
		try
		{
			baseInfo = baseInfoDao.get(player);
		} catch (Exception e)
		{
			log.error(e.getMessage());
		}
		if (baseInfo == null)
		{
			return CODE_PLAYER_NOT_EXIST;
		}
		return CODE_SUCCESS;
	}

}
