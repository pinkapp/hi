package cc.ywxm.model.game;

public class BattleRecord
{

	// Fields

	private Long id;
	private byte[] record;

	// Constructors

	/** default constructor */
	public BattleRecord()
	{
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public byte[] getRecord()
	{
		return record;
	}

	public void setRecord(byte[] record)
	{
		this.record = record;
	}


}