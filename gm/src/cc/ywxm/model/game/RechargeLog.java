package cc.ywxm.model.game;

/**
 * 充值日志模型
 * 
 * @author HuangDecai
 * @since 2012-12-28 9:36:32
 * 
 */
public class RechargeLog
{

	// Fields

	private Integer logId;
	private Integer player;
	private Double money;
	private Double surplus;
	private Short platform;
	private Short bank;
	private String logTime;

	public RechargeLog()
	{
		super();
	}

	public Integer getLogId()
	{
		return logId;
	}

	public void setLogId(Integer logId)
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

	public Double getMoney()
	{
		return money;
	}

	public void setMoney(Double money)
	{
		this.money = money;
	}

	public Double getSurplus()
	{
		return surplus;
	}

	public void setSurplus(Double surplus)
	{
		this.surplus = surplus;
	}

	public Short getPlatform()
	{
		return platform;
	}

	public void setPlatform(Short platform)
	{
		this.platform = platform;
	}

	public Short getBank()
	{
		return bank;
	}

	public void setBank(Short bank)
	{
		this.bank = bank;
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