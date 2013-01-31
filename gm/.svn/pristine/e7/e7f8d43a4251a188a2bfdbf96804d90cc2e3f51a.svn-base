package cc.ywxm.model.game;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * FunctionBuildingId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class FunctionBuildingId implements java.io.Serializable, Cloneable
{

	// Fields

	private Integer player;
	private Integer id;

	// Constructors

	/** default constructor */
	public FunctionBuildingId()
	{
	}

	/** full constructor */
	public FunctionBuildingId(Integer player, Integer id)
	{
		this.player = player;
		this.id = id;
	}

	// Property accessors

	@Column(name = "player", nullable = false)
	public Integer getPlayer()
	{
		return this.player;
	}

	public void setPlayer(Integer player)
	{
		this.player = player;
	}

	@Column(name = "id", nullable = false)
	public Integer getId()
	{
		return this.id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	@Override
	public boolean equals(Object other)
	{
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof FunctionBuildingId))
			return false;
		FunctionBuildingId castOther = (FunctionBuildingId) other;

		return ((this.getPlayer() == castOther.getPlayer()) || (this
				.getPlayer() != null
				&& castOther.getPlayer() != null && this.getPlayer().equals(
				castOther.getPlayer())))
				&& ((this.getId() == castOther.getId()) || (this.getId() != null
						&& castOther.getId() != null && this.getId().equals(
						castOther.getId())));
	}

	@Override
	public int hashCode()
	{
		int result = 17;

		result = 37 * result
				+ (getPlayer() == null ? 0 : this.getPlayer().hashCode());
		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		return result;
	}

}