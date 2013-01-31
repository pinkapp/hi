package cc.ywxm.service.impl.game;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cc.ywxm.constant.Const;
import cc.ywxm.dao.game.BaseInfoDao;
import cc.ywxm.dao.game.RechargeLogDao;
import cc.ywxm.model.game.BaseInfo;
import cc.ywxm.service.game.BaseInfoService;
import cc.ywxm.utils.ZMQutils;

@Transactional
@Service
public class BaseInfoServiceImpl implements BaseInfoService
{
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Resource
	private BaseInfoDao baseInfoDao;
	@Resource
	private RechargeLogDao rechargeLogDao;

	public Map<String, Object> gets(Integer rows, Integer page, String nickname)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", baseInfoDao.list(rows, page, nickname));
		map.put("total", baseInfoDao.count(nickname));
		return map;
	}

	public Map<String, Object> gets(Integer rows, Integer page, String sort,
			String order, String nickname)
	{
		if (nickname == null)
		{
			nickname = "";
		} else
		{
			nickname = nickname.trim();
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", baseInfoDao.list(rows, page, sort, order, nickname));
		map.put("total", baseInfoDao.count(nickname));
		return map;
	}

	public int add(String nickname, Integer sex)
	{
		if (nickname == null || "".equals(nickname))
		{
			return 2;// 昵称为空
		}
		boolean b = true;
		try
		{
			b = baseInfoDao.nicknameExist(nickname);
		} catch (Exception e2)
		{
			e2.printStackTrace();
			return 0;// 未知错误
		}
		if (b)
		{
			return 3;// 昵称重复
		}
		int player = 0;
		try
		{
			player = baseInfoDao.maxId();
		} catch (Exception e1)
		{
			e1.printStackTrace();
			return 0;// 未知错误
		}
		BaseInfo baseInfo = new BaseInfo();
		baseInfo.setPlayer(++player);
		baseInfo.setNickname(nickname);
		baseInfo.setSex(sex + "");
		try
		{
			baseInfoDao.save(baseInfo);
			return 1;// 创建成功
		} catch (Exception e)
		{
			e.printStackTrace();
			return 0;// 未知错误
		}

	}

	public int edit(String player, String prop, int value)
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
		JSONObject o = new JSONObject();
		try
		{
			o.put("type", prop);
			o.put("value", value);
		} catch (JSONException e)
		{
			log.error(e.getMessage());
			return CODE_JSON_ERROR;
		}
		try
		{
			String data = ZMQutils.call(player_, Const.GM_BASEINFO_EDIT, 0, o
					.toString());
			if (data == null)
			{
				return CODE_ZMQ_NORESPONSE;
			}
			JSONObject jsonObject = new JSONObject(data);
			int result = jsonObject.getInt("result");
			if (log.isDebugEnabled())
			{
				Map<Integer, String> map = new HashMap<Integer, String>();
				map.put(0, "成功");
				map.put(1, "没有提供这个方法");
				map.put(2, "JSON解析失败");
				map.put(3, "参数无效");
				map.put(4, "资源不足");
				map.put(5, "玩家不在线");
				log.debug("服务器返回结果：" + map.get(result));
			}
			if (result == 0)
			{
				BaseInfo baseInfo = baseInfoDao.get(player_);
				try
				{
					rechargeLogDao.save(player_, Double.valueOf(value), Double
							.valueOf(baseInfo.getRechargedGold()), -1, -1);
				} catch (Exception e)
				{
					log.error(e.getMessage());
				}
				return CODE_SUCCESS;
			} else if (result == 5)
			{
				// 玩家不在线
			} else
			{
				return CODE_FAIL;
			}
			if ("gold".equals(prop))
			{
				baseInfoDao.updateGold(player_, value);
			} else if ("silver".equals(prop))
			{
				baseInfoDao.updateSilver(player_, value);
			} else if ("energy".equals(prop))
			{
				baseInfoDao.updateEnergy(player_, value);
			} else if ("mobility".equals(prop))
			{
				baseInfoDao.updateMobility(player_, value);
			} else if ("progress".equals(prop))
			{
				baseInfoDao.updateProgress(player_, value);
			} else if ("recharged".equals(prop))
			{
				log.info(prop + "," + value);
				if (value <= 0)
				{
					return CODE_FAIL;
				}
				baseInfoDao.updateRechargedGold(player_, value);
				BaseInfo baseInfo = baseInfoDao.get(player_);
				try
				{
					Integer rechargedGold = baseInfo.getRechargedGold();
					rechargedGold = rechargedGold == null ? 0 : rechargedGold;
					rechargeLogDao.save(player_, Double.valueOf(value), Double
							.valueOf(rechargedGold), -1, -1);
				} catch (Exception e)
				{
					// e.printStackTrace();
					log.error(e.getMessage());
				}
			} else if ("feat".equals(prop))
			{
				baseInfoDao.updateFeat(player_, value);
			} else if ("prestige".equals(prop))
			{
				baseInfoDao.updatePrestige(player_, value);
			}
			return CODE_SUCCESS;
		} catch (Exception e)
		{
			log.error(e.getMessage());
			return CODE_FAIL;
		}
	}

}
