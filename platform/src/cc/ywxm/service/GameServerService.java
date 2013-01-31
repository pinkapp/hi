package cc.ywxm.service;

import java.util.List;

import cc.ywxm.model.GameServer;

/**
 * 游戏服务器业务逻辑层
 * 
 * @author huangdc
 * 
 */
public interface GameServerService
{

	public GameServer get(Integer serverId);

	public int edit(GameServer gameServer);

	public int add(GameServer gameServer);

	public int delete(Integer serverId);

	public List<GameServer> gets();

}
