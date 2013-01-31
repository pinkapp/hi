package cc.ywxm.model.game;

/**
 * 礼包使用日志
 * 
 * @author HuangDecai
 * @since 2012-12-29 10:33:54
 * 
 */
public class GiftbagLog
{

	// 日志ID
	private Integer logId;
	// 玩家ID
	private Integer player;
	// 礼包类型
	private Short giftbagType;
	// 礼品
	private String gifts;
	// 日志时间
	private String logTime;
	
	public GiftbagLog()
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

	public String getGifts()
	{
		return gifts;
	}

	public void setGifts(String gifts)
	{
		this.gifts = gifts;
	}

	public String getLogTime()
	{
		return logTime;
	}

	public void setLogTime(String logTime)
	{
		this.logTime = logTime;
	}

	public Short getGiftbagType()
	{
		return giftbagType;
	}

	public void setGiftbagType(Short giftbagType)
	{
		this.giftbagType = giftbagType;
	}

}