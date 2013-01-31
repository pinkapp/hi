package cc.ywxm.service.impl.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cc.ywxm.dao.game.BaseInfoDao;
import cc.ywxm.dao.game.EnergyLogDao;
import cc.ywxm.model.game.EnergyLog;
import cc.ywxm.service.game.EnergyLogService;

/**
 * 活力使用记录业务层接口实现
 * 
 * @author HuangDeCai
 * @since 2012-12-30 13:03:49
 */
@Transactional
@Service
public class EnergyLogServiceImpl implements EnergyLogService
{
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Resource
	private EnergyLogDao energyLogDao;
	@Resource
	private BaseInfoDao baseInfoDao;

	public Map<String, Object> gets(Integer rows, Integer page, String sort,
			String order, Integer player, String startTime, String endTime)
	{
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("rows", new ArrayList<EnergyLog>());
		result.put("total", 0);
		if (sort == null || "".equals(sort.trim()))
		{
			sort = "logId";
		}
		if (order == null || "".equals(order.trim()))
		{
			order = "DESC";
		}
		try
		{
			int total = 0;
			Object list = null;
			if (startTime != null && endTime != null && !"".equals(startTime)
					&& !"".equals(endTime))
			{
				total = energyLogDao.count(player, startTime, endTime);
				list = energyLogDao.list(rows, page, sort, order, player,
						startTime, endTime);

			} else
			{
				total = energyLogDao.count(player);
				list = energyLogDao.list(rows, page, sort, order, player);
			}
			result.put("rows", list);
			result.put("total", total);
		} catch (Exception e)
		{
			log.error(e.getMessage());
		}
		return result;
	}

	public Map<String, Object> gets(Integer rows, Integer page, String sort,
			String order, String nickname, String startTime, String endTime)
	{
		Integer player = null;
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("rows", new ArrayList<EnergyLog>());
		result.put("total", 0);
		if (nickname != null)
		{
			nickname = nickname.trim();
		}
		if (nickname == null || "".equals(nickname))
		{

			return result;
		} else
		{
			try
			{
				player = baseInfoDao.findPlayerByNickname(nickname);
			} catch (EmptyResultDataAccessException e)
			{
				log.debug(e.getMessage());
				return result;
			} catch (Exception e)
			{
				log.error(e.getMessage());
			}
		}
		return this.gets(rows, page, sort, order, player, startTime, endTime);
	}

	public String JSONData(Integer rows, Integer page, String sort,
			String order, Integer player, String startTime, String endTime)
	{
		Map<String, Object> map = this.gets(rows, page, sort, order, player,
				startTime, endTime);
		return new JSONObject(map).toString();
	}

	public String JSONData(Integer rows, Integer page, String sort,
			String order, String nickname, String startTime, String endTime)
	{
		Map<String, Object> map = this.gets(rows, page, sort, order, nickname,
				startTime, endTime);
		return new JSONObject(map).toString();
	}

	public List<EnergyLog> gets(String nickname, String startTime,
			String endTime)
	{
		List<EnergyLog> result = new ArrayList<EnergyLog>();
		Integer player = null;
		if (nickname != null)
		{
			nickname = nickname.trim();
		}
		if (nickname == null || "".equals(nickname))
		{

			return result;
		} else
		{
			try
			{
				player = baseInfoDao.findPlayerByNickname(nickname);
			} catch (EmptyResultDataAccessException e)
			{
				return result;
			} catch (Exception e)
			{
				log.error(e.getMessage());
			}
		}
		return this.gets(player, startTime, endTime);
	}

	public List<EnergyLog> gets(Integer player, String startTime,
			String endTime)
	{
		List<EnergyLog> result = new ArrayList<EnergyLog>();
		try
		{
			if (startTime != null && endTime != null && !"".equals(startTime)
					&& !"".equals(endTime))
			{
				result = energyLogDao.list(player, startTime, endTime);
			} else
			{
				result = energyLogDao.list(player);
			}
		} catch (Exception e)
		{
			log.error(e.getMessage());
		}
		return result;
	}

}
