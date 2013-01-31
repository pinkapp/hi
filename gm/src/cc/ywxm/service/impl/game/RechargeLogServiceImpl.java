package cc.ywxm.service.impl.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cc.ywxm.dao.game.BaseInfoDao;
import cc.ywxm.dao.game.RechargeLogDao;
import cc.ywxm.model.game.RechargeLog;
import cc.ywxm.service.game.RechargeLogService;

/**
 * 充值业务层实现
 * 
 * @author HuangDecai
 * @since 2012-12-28 9:35:20
 * 
 */
@Transactional
@Service
public class RechargeLogServiceImpl implements RechargeLogService
{
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Resource
	private BaseInfoDao baseInfoDao;
	@Resource
	private RechargeLogDao rechargeLogDao;

	public Map<String, Object> gets(Integer rows, Integer page, String sort,
			String order, String player, String startTime, String endTime)
	{
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("rows", new ArrayList<RechargeLog>());
		result.put("total", 0);
		if (player == null || player.trim().equals(""))
		{
			return result;
		}
		int player_ = 0;
		try
		{
			player_ = Integer.parseInt(player);
		} catch (NumberFormatException e)
		{
			try
			{
				player_ = baseInfoDao.findPlayerByNickname(player);
			} catch (Exception exc)
			{
				log.error(exc.getMessage());
				return result;
			}
		}
		if (sort == null || "".equals(sort.trim()))
		{
			sort = "logId";
		}
		if (order == null || "".equals(order.trim()))
		{
			order = "desc";
		}
		try
		{
			int total = 0;
			Object list = null;
			if (startTime != null && endTime != null && !"".equals(startTime)
					&& !"".equals(endTime))
			{
				total = rechargeLogDao.count(player_, startTime, endTime);
				list = rechargeLogDao.list(rows, page, sort, order, player_,
						startTime, endTime);

			} else
			{
				total = rechargeLogDao.count(player_);
				list = rechargeLogDao.list(rows, page, sort, order, player_);
			}
			result.put("rows", list);
			result.put("total", total);
		} catch (Exception e)
		{
			log.error(e.getMessage());
		}
		return result;
	}

	public String JSONData(Integer rows, Integer page, String sort,
			String order, String player, String startTime, String endTime)
	{
		Map<String, Object> map = this.gets(rows, page, sort, order, player,
				startTime, endTime);
		return new JSONObject(map).toString();
	}

	public List<RechargeLog> gets(String player, String startTime,
			String endTime)
	{
		List<RechargeLog> result = new ArrayList<RechargeLog>();
		if (player == null || player.trim().equals(""))
		{
			return result;
		}
		int player_ = 0;
		try
		{
			player_ = Integer.parseInt(player);
		} catch (NumberFormatException e)
		{
			try
			{
				player_ = baseInfoDao.findPlayerByNickname(player);
			} catch (Exception exc)
			{
				log.error(exc.getMessage());
				return result;
			}
		}
		
		try
		{
			if (startTime != null && endTime != null && !"".equals(startTime)
					&& !"".equals(endTime))
			{
				result = rechargeLogDao.list(player_, startTime, endTime);
			} else
			{
				result = rechargeLogDao.list(player_);
			}
		} catch (Exception e)
		{
			log.error(e.getMessage());
		}
		return result;
		
	}

}
