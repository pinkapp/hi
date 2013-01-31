package cc.ywxm.service.impl.game;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cc.ywxm.dao.game.BattleRecordDao;
import cc.ywxm.service.game.BattleRecordService;

@Transactional
@Service
public class BattleRecordServiceImpl implements BattleRecordService
{
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Resource
	private BattleRecordDao battleRecordDao;

	public byte[] get(Integer id)
	{
		if (id != null)
		{
			try
			{
				return battleRecordDao.get(id).getRecord();

			} catch (Exception e)
			{
				log.error(e.getMessage());
			}
		}
		return null;
	}

}
