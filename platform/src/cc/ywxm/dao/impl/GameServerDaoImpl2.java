package cc.ywxm.dao.impl;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import cc.ywxm.dao.GameServerDao;
import cc.ywxm.model.GameServer;
import cc.ywxm.share.ShareData;

public class GameServerDaoImpl2 implements GameServerDao
{

	public void save(GameServer server)
	{
	}

	public void delete(GameServer server)
	{
	}

	public void update(GameServer server)
	{
	}

	public GameServer get(Integer serverId)
	{
		return null;
	}

	public List<GameServer> findNewest()
	{
		List<GameServer> result = new ArrayList<GameServer>();
		String s = ShareData.getMap().get("yxly.client.servers.url");
		InputStream inStream = null;
		try
		{
			URL url = new URL(s);
			URLConnection connection = url.openConnection();
			inStream = connection.getInputStream();
			SAXReader saxReader = new SAXReader();
			Document document = saxReader.read(inStream);
			Element root = document.getRootElement();
			Iterator<?> iterator = root.elementIterator("server");
			while (iterator.hasNext())
			{
				Element elt = (Element) iterator.next();
				GameServer server = new GameServer();
				server.setServerId(elt.attributeValue("id"));
				server.setServerName(elt.attributeValue("name"));
				server.setOpenDate(elt.attributeValue("openDate"));
				server.setIp(elt.attributeValue("ip"));
				server.setGameName("英雄领域");
				result.add(server);
			}
			inStream.close();
			return result;
		} catch (Exception e)
		{
			return null;
		}
	}

}
