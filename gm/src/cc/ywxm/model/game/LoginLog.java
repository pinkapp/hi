package cc.ywxm.model.game;


/**
 * @version 0.1
 * @author HuangDeCai
 * @since 2012-12-6 11:23:14 玩家登录信息
 */
public class LoginLog
{
	private Long logId;
	private Integer player;
	private String ipAddress;
	private String logTime;

	public LoginLog()
	{
		super();
	}

	public Long getLogId()
	{
		return logId;
	}

	public void setLogId(Long logId)
	{
		this.logId = logId;
	}

	public Integer getPlayer()
	{
		return player;
	}

	public void setPlayer(Integer player)
	{
		this.player = player;
	}

	public String getIpAddress()
	{
		return ipAddress;
	}

	public void setIpAddress(String ipAddress)
	{
		this.ipAddress = ipAddress;
	}

	public String getLogTime()
	{
		return logTime;
	}

	public void setLogTime(String logTime)
	{
		this.logTime = logTime;
	}

}
