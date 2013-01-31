package cc.ywxm.model.gm;

public class OperateLog
{

	// Fields

	private Long logId;
	private String info;
	private String operator;
	private String ipAddress;
	private String logTime;

	public Long getLogId()
	{
		return logId;
	}

	public void setLogId(Long logId)
	{
		this.logId = logId;
	}

	public String getInfo()
	{
		return info;
	}

	public void setInfo(String info)
	{
		this.info = info;
	}

	public String getOperator()
	{
		return operator;
	}

	public void setOperator(String operator)
	{
		this.operator = operator;
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