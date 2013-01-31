package cc.ywxm.model.game;

import java.sql.Timestamp;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * FunctionBuilding entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "function_building")
public class FunctionBuilding implements java.io.Serializable, Cloneable
{

	// Fields

	private FunctionBuildingId id;
	private Short kind;
	private Short x;
	private Short y;
	private Short aspect;
	private Short level;
	private Short progress;
	private Timestamp lastReap;

	// Constructors

	/** default constructor */
	public FunctionBuilding()
	{
	}

	/** full constructor */
	public FunctionBuilding(FunctionBuildingId id, Short kind, Short x,
			Short y, Short aspect, Short level, Short progress,
			Timestamp lastReap)
	{
		this.id = id;
		this.kind = kind;
		this.x = x;
		this.y = y;
		this.aspect = aspect;
		this.level = level;
		this.progress = progress;
		this.lastReap = lastReap;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides(
	{
			@AttributeOverride(name = "player", column = @Column(name = "player", nullable = false)),
			@AttributeOverride(name = "id", column = @Column(name = "id", nullable = false)) })
	public FunctionBuildingId getId()
	{
		return this.id;
	}

	public void setId(FunctionBuildingId id)
	{
		this.id = id;
	}

	@Column(name = "kind", nullable = false)
	public Short getKind()
	{
		return this.kind;
	}

	public void setKind(Short kind)
	{
		this.kind = kind;
	}

	@Column(name = "x", nullable = false)
	public Short getX()
	{
		return this.x;
	}

	public void setX(Short x)
	{
		this.x = x;
	}

	@Column(name = "y", nullable = false)
	public Short getY()
	{
		return this.y;
	}

	public void setY(Short y)
	{
		this.y = y;
	}

	@Column(name = "aspect", nullable = false)
	public Short getAspect()
	{
		return this.aspect;
	}

	public void setAspect(Short aspect)
	{
		this.aspect = aspect;
	}

	@Column(name = "level", nullable = false)
	public Short getLevel()
	{
		return this.level;
	}

	public void setLevel(Short level)
	{
		this.level = level;
	}

	@Column(name = "progress", nullable = false)
	public Short getProgress()
	{
		return this.progress;
	}

	public void setProgress(Short progress)
	{
		this.progress = progress;
	}

	@Column(name = "last_reap", nullable = false, length = 19)
	public Timestamp getLastReap()
	{
		return this.lastReap;
	}

	public void setLastReap(Timestamp lastReap)
	{
		this.lastReap = lastReap;
	}

	@Override
	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aspect == null) ? 0 : aspect.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((kind == null) ? 0 : kind.hashCode());
		result = prime * result
				+ ((lastReap == null) ? 0 : lastReap.hashCode());
		result = prime * result + ((level == null) ? 0 : level.hashCode());
		result = prime * result
				+ ((progress == null) ? 0 : progress.hashCode());
		result = prime * result + ((x == null) ? 0 : x.hashCode());
		result = prime * result + ((y == null) ? 0 : y.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FunctionBuilding other = (FunctionBuilding) obj;
		if (aspect == null)
		{
			if (other.aspect != null)
				return false;
		} else if (!aspect.equals(other.aspect))
			return false;
		if (id == null)
		{
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (kind == null)
		{
			if (other.kind != null)
				return false;
		} else if (!kind.equals(other.kind))
			return false;
		if (lastReap == null)
		{
			if (other.lastReap != null)
				return false;
		} else if (!lastReap.equals(other.lastReap))
			return false;
		if (level == null)
		{
			if (other.level != null)
				return false;
		} else if (!level.equals(other.level))
			return false;
		if (progress == null)
		{
			if (other.progress != null)
				return false;
		} else if (!progress.equals(other.progress))
			return false;
		if (x == null)
		{
			if (other.x != null)
				return false;
		} else if (!x.equals(other.x))
			return false;
		if (y == null)
		{
			if (other.y != null)
				return false;
		} else if (!y.equals(other.y))
			return false;
		return true;
	}

}