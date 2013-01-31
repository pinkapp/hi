package cc.ywxm.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cc.ywxm.action.base.BaseAction;
import cc.ywxm.constant.Const;
import cc.ywxm.model.GameServer;
import cc.ywxm.model.User;
import cc.ywxm.service.GameServerService;
import cc.ywxm.service.UserService;

@SuppressWarnings("serial")
@Controller
// 多例模式,默认单例
@Scope("prototype")
public class IndexAction extends BaseAction
{

	private Integer userId;
	private String username;
	private String realname;
	private String password;
	private String sex;
	private String birth;
	private String career;
	private String phone;
	private String email;
	private String cid;
	private String lip;
	private String lasttime;
	private String purl;
	private String province;
	private String city;
	private Integer money;
	private String rip;
	private String rtime;
	private String spasswd;
	private String status;
	private String source;

	private List<GameServer> gameServers;

	@Resource
	private UserService userService;
	@Resource
	private GameServerService gameServerService;

	/**
	 * 个人资料首页
	 * 
	 * @return
	 * @throws Exception
	 */
	public String user() throws Exception
	{
		userId = (Integer) session.get(Const.SESSION_USERID);
		User user = userService.get(userId);
		username = user.getUsername();
		return super.execute();
	}

	/**
	 * 我要充值
	 * 
	 * @return
	 * @throws Exception
	 */
	public String order() throws Exception
	{
		// games = gameService.findAll();
		return super.execute();
	}

	/**
	 * 游戏大厅
	 * 
	 * @return
	 * @throws Exception
	 */
	public String game() throws Exception
	{
		// games = gameService.findAll();
		return super.execute();
	}

	/**
	 * 客服中心
	 * 
	 * @return
	 * @throws Exception
	 */
	public String service() throws Exception
	{
		return super.execute();
	}

	/**
	 * 游戏论坛
	 * 
	 * @return
	 * @throws Exception
	 */
	public String bbs() throws Exception
	{
		return super.execute();
	}

	/**
	 * 首页
	 * 
	 * @return
	 * @throws Exception
	 */
	public String index() throws Exception
	{
		if (session.containsKey(Const.SESSION_USERID))
		{
			userId = (Integer) session.get(Const.SESSION_USERID);
			User user = userService.get(userId);
			username = user.getUsername();
		}
		// games = gameService.findAll();
		gameServers = gameServerService.gets();
		// gameOpens = gameService.findAllGameOpen();
		// friendlyLinks = friendlyLinkService.findAll();
		// newses = newsService.findAll();
		return SUCCESS;
	}

	/**
	 * 
	 * @return
	 */
	public String admin_main()
	{
		return SUCCESS;
	}

	/**
	 * 框架头
	 * 
	 * @return
	 */
	public String topframe()
	{
		// Integer userId = (Integer) session.get(Const.SESSION_USERID);
		// User user = userService.get(userId);
		// 根据用户ID查询用户的角色，目前一个用户只能是一个角色
		// rolenames = userService.getRolenamesByUserId(userId);
		return SUCCESS;
	}

	/**
	 * 我的礼券
	 * 
	 * @return
	 * @throws Exception
	 */
	public String giftcard() throws Exception
	{
		return "success";
	}

	/**
	 * 使用过的礼券
	 * 
	 * @return
	 * @throws Exception
	 */
	public String giftcard_history() throws Exception
	{
		return "success";
	}

	public Integer getUserId()
	{
		return userId;
	}

	public void setUserId(Integer userId)
	{
		this.userId = userId;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getRealname()
	{
		return realname;
	}

	public void setRealname(String realname)
	{
		this.realname = realname;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getSex()
	{
		return sex;
	}

	public void setSex(String sex)
	{
		this.sex = sex;
	}

	public String getBirth()
	{
		return birth;
	}

	public void setBirth(String birth)
	{
		this.birth = birth;
	}

	public String getCareer()
	{
		return career;
	}

	public void setCareer(String career)
	{
		this.career = career;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getCid()
	{
		return cid;
	}

	public void setCid(String cid)
	{
		this.cid = cid;
	}

	public String getLip()
	{
		return lip;
	}

	public void setLip(String lip)
	{
		this.lip = lip;
	}

	public String getLasttime()
	{
		return lasttime;
	}

	public void setLasttime(String lasttime)
	{
		this.lasttime = lasttime;
	}

	public String getPurl()
	{
		return purl;
	}

	public void setPurl(String purl)
	{
		this.purl = purl;
	}

	public String getProvince()
	{
		return province;
	}

	public void setProvince(String province)
	{
		this.province = province;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public Integer getMoney()
	{
		return money;
	}

	public void setMoney(Integer money)
	{
		this.money = money;
	}

	public String getRip()
	{
		return rip;
	}

	public void setRip(String rip)
	{
		this.rip = rip;
	}

	public String getRtime()
	{
		return rtime;
	}

	public void setRtime(String rtime)
	{
		this.rtime = rtime;
	}

	public String getSpasswd()
	{
		return spasswd;
	}

	public void setSpasswd(String spasswd)
	{
		this.spasswd = spasswd;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public String getSource()
	{
		return source;
	}

	public void setSource(String source)
	{
		this.source = source;
	}

	public List<GameServer> getGameServers()
	{
		return gameServers;
	}

	public void setGameServers(List<GameServer> gameServers)
	{
		this.gameServers = gameServers;
	}

}
