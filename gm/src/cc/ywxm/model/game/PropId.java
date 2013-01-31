package cc.ywxm.model.game;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PropId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class PropId implements java.io.Serializable, Cloneable
{

	// Fields

	private Integer player;
	private Integer id;
	private Short location;
	private Short area;

	// Constructors

	/** default constructor */
	public PropId()
	{
	}

	/** full constructor */
	public PropId(Integer player, Integer id, Short location, Short area)
	{
		this.player = player;
		this.id = id;
		this.location = location;
		this.area = area;
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

	@Column(name = "location", nullable = false)
	public Short getLocation()
	{
		return this.location;
	}

	public void setLocation(Short location)
	{
		this.location = location;
	}

	@Column(name = "area", nullable = false)
	public Short getArea()
	{
		return this.area;
	}

	public void setArea(Short area)
	{
		this.area = area;
	}

	@Override
	public boolean equals(Object other)
	{
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PropId))
			return false;
		PropId castOther = (PropId) other;

		return ((this.getPlayer() == castOther.getPlayer()) || (this
				.getPlayer() != null
				&& castOther.getPlayer() != null && this.getPlayer().equals(
				castOther.getPlayer())))
				&& ((this.getId() == castOther.getId()) || (this.getId() != null
						&& castOther.getId() != null && this.getId().equals(
						castOther.getId())))
				&& ((this.getLocation() == castOther.getLocation()) || (this
						.getLocation() != null
						&& castOther.getLocation() != null && this
						.getLocation().equals(castOther.getLocation())))
				&& ((this.getArea() == castOther.getArea()) || (this.getArea() != null
						&& castOther.getArea() != null && this.getArea()
						.equals(castOther.getArea())));
	}

	@Override
	public int hashCode()
	{
		int result = 17;

		result = 37 * result
				+ (getPlayer() == null ? 0 : this.getPlayer().hashCode());
		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result
				+ (getLocation() == null ? 0 : this.getLocation().hashCode());
		result = 37 * result
				+ (getArea() == null ? 0 : this.getArea().hashCode());
		return result;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}

}