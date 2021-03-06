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
import cc.ywxm.dao.game.PropDao;
import cc.ywxm.model.game.Prop;
import cc.ywxm.model.game.PropId;
import cc.ywxm.model.game.Prop_;
import cc.ywxm.service.game.KickService;
import cc.ywxm.service.game.PropInfoService;

/**
 * 
 * @author HuangDeCai
 * @since 2012-12-10 13:34:37
 */
@Transactional
@Service
public class PropInfoServiceImpl implements PropInfoService
{
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Resource
	private PropDao propDao;
	@Resource
	private BaseInfoDao baseInfoDao;

	@Resource
	private KickService kickService;

	public List<Prop_> gets(String nickname)
	{
		if (nickname == null || "".trim().equals(nickname))
		{
			return new ArrayList<Prop_>();
		}
		nickname = nickname.trim();
		try
		{
			Integer player = baseInfoDao.findPlayerByNickname(nickname);
			return propDao.list(player);
		} catch (EmptyResultDataAccessException e)
		{
			log.error(e.getMessage());
			return new ArrayList<Prop_>();
		} catch (Exception e)
		{
			log.error(e.getMessage());
			return new ArrayList<Prop_>();
		}
	}

	public List<Prop_> gets(Integer player)
	{
		if (player == null)
		{
			return new ArrayList<Prop_>();
		}
		try
		{
			return propDao.list(player);
		} catch (Exception e)
		{
			log.error(e.getMessage());
			return new ArrayList<Prop_>();
		}
	}

	public int edit(Integer player, Integer id, Short location, Short area,
			Short amount, Short kind)
	{
		if (player == null)
		{
			return 2;
		}
		if (id == null)
		{
			return 3;
		}

		if (location == null)
		{
			return 4;
		}
		if (area == null)
		{
			return 5;
		}
		//PropId propId = new PropId(player, id, location, area);
		Prop prop = null;

		try
		{
			//prop = propDao.get(propId);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		if (prop == null)
		{
			return 6;
		}
		Prop clone = (Prop) prop.clone();
		if (amount != null)
		{
			prop.setAmount(amount);
		}
		if (kind != null)
		{
			prop.setKind(kind);
		}

		if (clone.equals(prop))
		{
			return 0;
		}
		//propDao.update(prop);
		return 1;
	}

	public int edit(String nickname, Integer id, Short location, Short area,
			Short amount, Short kind)
	{
		Integer player = null;
		try
		{
			player = baseInfoDao.findPlayerByNickname(nickname);
		} catch (Exception e)
		{
			log.error(e.getMessage());
		}
		if (player == null)
		{
			return 2;
		}
		return this.edit(player, id, location, area, amount, kind);
	}

	public int add(String player, Integer sid, Integer amount)
	{
		if (player == null || player.trim().equals(""))
		{
			return CODE_PLAYER_NULL;
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
				return CODE_PLAYER_NOT_EXIST;
			}
		}
		// 修改前，把玩家踢下线
		int code = kickService.kick(player);
		if (code == 1)
		{
			try
			{
				propDao.save(player_, sid, amount);
				return CODE_SUCCESS;
			} catch (Exception e)
			{
				log.error(e.getMessage());
			}
			return CODE_FAIL;

		} else
		{
			return CODE_FAIL;
		}
	}

}
