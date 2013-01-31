package cc.ywxm.service.impl.game;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cc.ywxm.dao.game.BaseInfoDao;
import cc.ywxm.dao.game.LoginLogDao;
import cc.ywxm.model.game.BaseInfo;
import cc.ywxm.model.game.SameIP;
import cc.ywxm.service.game.SameIPService;

/**
 * 
 * @author HuangDeCai
 * @since 2012-12-6 16:46:52
 */
@Transactional
@Service
public class SameIPServiceImpl implements SameIPService
{
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Resource
	private LoginLogDao loginDao;
	@Resource
	private BaseInfoDao baseInfoDao;

	public List<SameIP> gets(String IP)
	{
		List<SameIP> result = new ArrayList<SameIP>();
		if (IP == null)
		{
			return result;
		}
		IP = IP.trim();
		List<Integer> players = null;
		try
		{
			players = loginDao.listByIP(IP);
		} catch (Exception e)
		{
			log.error(e.getMessage());
		}
		if (players != null)
		{
			BaseInfo baseInfo = null;
			for (Integer player : players)
			{
				try
				{
					baseInfo = baseInfoDao.get(player);
					SameIP sameIP = new SameIP();
					sameIP.setPlayer(player);
					sameIP.setGold(baseInfo.getGold());
					sameIP.setLevel(baseInfo.getLevel());
					sameIP.setNickname(baseInfo.getNickname());
					result.add(sameIP);

				} catch (Exception e)
				{
					log.error(e.getMessage());
					continue;
				}
			}

		}
		return result;
	}

	public List<SameIP> gets(String startIP, String endIP)
	{
		List<SameIP> result = new ArrayList<SameIP>();
		if (startIP == null || endIP == null)
		{
			return result;
		} else
		{
			startIP = startIP.trim();
			endIP = endIP.trim();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date sdate = null;
		Date edate = null;
		try
		{
			sdate = sdf.parse(startIP);
			edate = sdf.parse(endIP);
		} catch (ParseException e)
		{
			e.printStackTrace();
			return null;
		} catch (Exception e)
		{
			log.error(e.getMessage());
			return null;
		}

		try
		{
			if (sdate.compareTo(edate) <= 0)
			{
				while (sdate.compareTo(edate) <= 0)
				{
					// String date = null;// 当天
					// int count = 0;// 登录总数
					// date = sdf.format(sdate);
					// count = loginDao.count(date);
					SameIP loginInfo = new SameIP();
					// loginInfo.setDate(date);
					// System.out.println(count);
					// loginInfo.setCount(count);
					result.add(loginInfo);
					sdate.setTime(sdate.getTime() + 1000 * 60 * 60 * 24l);
				}
			}
		} catch (Exception e)
		{
			log.error(e.getMessage());
		}
		return result;
	}

}
