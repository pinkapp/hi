package cc.ywxm.model.game;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Prop entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "prop")
public class Prop implements java.io.Serializable, Cloneable
{

	// Fields

	private PropId id;
	private Short amount;
	private Short kind;

	// Constructors

	/** default constructor */
	public Prop()
	{
	}

	/** full constructor */
	public Prop(PropId id, Short amount, Short kind)
	{
		this.id = id;
		this.amount = amount;
		this.kind = kind;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides(
	{
			@AttributeOverride(name = "player", column = @Column(name = "player", nullable = false)),
			@AttributeOverride(name = "id", column = @Column(name = "id", nullable = false)),
			@AttributeOverride(name = "location", column = @Column(name = "location", nullable = false)),
			@AttributeOverride(name = "area", column = @Column(name = "area", nullable = false)) })
	public PropId getId()
	{
		return this.id;
	}

	public void setId(PropId id)
	{
		this.id = id;
	}

	@Column(name = "amount", nullable = false)
	public Short getAmount()
	{
		return this.amount;
	}

	public void setAmount(Short amount)
	{
		this.amount = amount;
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

	@Override
	public Object clone()
	{
		try
		{
			return super.clone();
		} catch (CloneNotSupportedException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((kind == null) ? 0 : kind.hashCode());
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
		Prop other = (Prop) obj;
		if (amount == null)
		{
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
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
		return true;
	}

}