package cc.ywxm.model.game;

/**
 * 功绩使用日志数据模型
 * 
 * @author HuangDecai
 * @since 2012-12-31 9:18:18
 * 
 * 
 */
public class FeatLog
{

	// Fields
	// 日志ID
	private Integer logId;
	// 玩家ID
	private Integer player;
	// 减少值
	private Integer reduce;
	// 剩余值
	private Integer surplus;
	// 日志时间
	private String logTime;

	public FeatLog()
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

	public Integer getReduce()
	{
		return reduce;
	}

	public void setReduce(Integer reduce)
	{
		this.reduce = reduce;
	}

	public Integer getSurplus()
	{
		return surplus;
	}

	public void setSurplus(Integer surplus)
	{
		this.surplus = surplus;
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