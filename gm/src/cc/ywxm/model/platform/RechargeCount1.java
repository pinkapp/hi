package cc.ywxm.model.platform;

public class RechargeCount1
{
	// 金额范围
	private String moneyRange;
	// 充值人数
	private int total;

	public RechargeCount1()
	{
		super();
	}

	public RechargeCount1(String moneyRange, int total)
	{
		super();
		this.moneyRange = moneyRange;
		this.total = total;
	}

	public String getMoneyRange()
	{
		return moneyRange;
	}

	public void setMoneyRange(String moneyRange)
	{
		this.moneyRange = moneyRange;
	}

	public int getTotal()
	{
		return total;
	}

	public void setTotal(int total)
	{
		this.total = total;
	}

}
