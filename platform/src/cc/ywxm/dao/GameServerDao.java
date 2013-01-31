package cc.ywxm.dao;

import java.util.List;

import cc.ywxm.model.GameServer;

/**
 * 数据访问层
 * 
 * @author hdc
 * 
 * 
 */
public interface GameServerDao
{

	public void save(GameServer gameServer);

	public void delete(GameServer gameServer);

	public void update(GameServer gameServer);

	public GameServer get(Integer serverId);

	/**
	 * 最新的开放的服务器，前十
	 * 
	 * @return
	 */
	public List<GameServer> findNewest();
}
