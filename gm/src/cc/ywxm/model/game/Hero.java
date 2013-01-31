package cc.ywxm.model.game;

public class Hero
{

	// Fields

	private Integer player;
	private Short id;
	private Short level;
	private Short status;
	private Short location;
	private Integer exp;
	private byte[] bringupBin;
	private Integer trainEndTime;
	private Short trainType;
	private Integer trainExp;

	public Integer getPlayer()
	{
		return player;
	}

	public void setPlayer(Integer player)
	{
		this.player = player;
	}

	public Short getId()
	{
		return id;
	}

	public void setId(Short id)
	{
		this.id = id;
	}

	public Short getLevel()
	{
		return level;
	}

	public void setLevel(Short level)
	{
		this.level = level;
	}

	public Short getStatus()
	{
		return status;
	}

	public void setStatus(Short status)
	{
		this.status = status;
	}

	public Short getLocation()
	{
		return location;
	}

	public void setLocation(Short location)
	{
		this.location = location;
	}

	public Integer getExp()
	{
		return exp;
	}

	public void setExp(Integer exp)
	{
		this.exp = exp;
	}

	public byte[] getBringupBin()
	{
		return bringupBin;
	}

	public void setBringupBin(byte[] bringupBin)
	{
		this.bringupBin = bringupBin;
	}

	public Integer getTrainEndTime()
	{
		return trainEndTime;
	}

	public void setTrainEndTime(Integer trainEndTime)
	{
		this.trainEndTime = trainEndTime;
	}

	public Short getTrainType()
	{
		return trainType;
	}

	public void setTrainType(Short trainType)
	{
		this.trainType = trainType;
	}

	public Integer getTrainExp()
	{
		return trainExp;
	}

	public void setTrainExp(Integer trainExp)
	{
		this.trainExp = trainExp;
	}

}