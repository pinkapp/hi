package cc.ywxm.service.impl;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cc.ywxm.dao.GameServerDao;
import cc.ywxm.model.GameServer;
import cc.ywxm.service.GameServerService;
import cc.ywxm.share.ShareData;

@Service
@Transactional
public class GameServerServiceImpl implements GameServerService
{
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Resource
	private GameServerDao gameServerDao;

	public int add(GameServer gameServer)
	{
		return 0;
	}

	public int delete(Integer serverId)
	{
		return 0;
	}

	public int edit(GameServer gameServer)
	{
		return 0;
	}

	public GameServer get(Integer serverId)
	{
		GameServer result = null;
		try
		{
			result = gameServerDao.get(serverId);
		} catch (Exception e)
		{
			log.error(e.getMessage());
		}
		return result;
	}

	public List<GameServer> gets()
	{
		List<GameServer> result = new ArrayList<GameServer>();
		try
		{
			result = gameServerDao.findNewest();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}

}
