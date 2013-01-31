package cc.ywxm.model.game;

/**
 * 封号玩家
 * 
 * @author HuangDecai
 * @since 2012-12-10 10:07:13
 * 
 */
public class Closed
{
	private Integer player;
	private String nickname;
	private String reason;
	private String endDate;

	public Integer getPlayer()
	{
		return player;
	}

	public void setPlayer(Integer player)
	{
		this.player = player;
	}

	public String getNickname()
	{
		return nickname;
	}

	public void setNickname(String nickname)
	{
		this.nickname = nickname;
	}

	public String getReason()
	{
		return reason;
	}

	public void setReason(String reason)
	{
		this.reason = reason;
	}

	public String getEndDate()
	{
		return endDate;
	}

	public void setEndDate(String endDate)
	{
		this.endDate = endDate;
	}
}
