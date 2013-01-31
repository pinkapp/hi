package cc.ywxm.action.game;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cc.ywxm.action.BaseAction;

/**
 * session功能
 * 
 * @author hdc
 * 
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class SessionAction extends BaseAction
{

	private String dbsrv;

	/**
	 * 切换服务器
	 * 
	 * @return
	 */
	public String chdbsrv()
	{
		// Map<String, Server> map = new HashMap<String, Server>();
		// List<Server> servers = ShareData.getServers();
		// for (Server server : servers)
		// {
		// map.put(server.getId(), server);
		// }
		// session.put(Const.SESSION_DBSRV, map.get(dbsrv));
		return NONE;
	}

	public String getDbsrv()
	{
		return dbsrv;
	}

	public void setDbsrv(String dbsrv)
	{
		this.dbsrv = dbsrv;
	}
}
