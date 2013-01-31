package cc.ywxm.model.platform;

public class RechargeRank implements Comparable<RechargeRank>
{
	// 玩家昵称
	private String nickname;
	// 充值总金额
	private int total;
	// 排行
	private int rank;

	public String getNickname()
	{
		return nickname;
	}

	public void setNickname(String nickname)
	{
		this.nickname = nickname;
	}

	public int getTotal()
	{
		return total;
	}

	public void setTotal(int total)
	{
		this.total = total;
	}

	public int getRank()
	{
		return rank;
	}

	public void setRank(int rank)
	{
		this.rank = rank;
	}

	public int compareTo(RechargeRank o)
	{
		return o.total - this.total;
	}

}
