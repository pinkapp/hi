package cc.ywxm.service.impl.game;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cc.ywxm.constant.Const;
import cc.ywxm.dao.game.BaseInfoDao;
import cc.ywxm.service.game.CloseService;
import cc.ywxm.utils.ZMQutils;

@Transactional
@Service
public class CloseServiceImpl implements CloseService
{
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Resource
	private BaseInfoDao baseInfoDao;

	public JSONArray gets(String player)
	{
		JSONArray result = new JSONArray();
		return result;
	}

	public int close(String player, String reason, String endDate)
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
		JSONObject jsonObject = new JSONObject();
		try
		{
			jsonObject.put("reason", reason);
			jsonObject.put("endDate", endDate);
		} catch (JSONException e)
		{
			log.error(e.getMessage());
			return CODE_JSON_ERROR;
		}
		try
		{
			String data = ZMQutils.call(player_, Const.GM_CLOSE, 0, jsonObject
					.toString());
			if (data == null)
			{
				return CODE_ZMQ_NORESPONSE;
			}
			jsonObject = new JSONObject(data);
			int result = jsonObject.getInt("result");
			if (log.isDebugEnabled())
			{
				Map<Integer, String> map = new HashMap<Integer, String>();
				map.put(0, "成功");
				map.put(1, "没有提供这个方法");
				map.put(2, "JSON解析失败");
				map.put(3, "参数无效");
				map.put(4, "资源不足");
				log.debug("服务器返回结果：" + map.get(result));
			}
			if (result != 0)
			{
				return CODE_FAIL;
			}
			return CODE_SUCCESS;
		} catch (Exception e)
		{
			log.error(e.getMessage());
			return CODE_FAIL;
		}
	}

}
