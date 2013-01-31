package cc.ywxm.model.gm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ManagerType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "manager_type")
public class ManagerType implements java.io.Serializable
{

	// Fields

	private Short typeId;
	private String typeName;
	private Boolean valid;
	private String note;
	private String rights;

	// Constructors

	/** default constructor */
	public ManagerType()
	{
	}

	/** minimal constructor */
	public ManagerType(String typeName, Boolean valid)
	{
		this.typeName = typeName;
		this.valid = valid;
	}

	/** full constructor */
	public ManagerType(String typeName, Boolean valid, String note,
			String rights)
	{
		this.typeName = typeName;
		this.valid = valid;
		this.note = note;
		this.rights = rights;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "typeId", unique = true, nullable = false)
	public Short getTypeId()
	{
		return this.typeId;
	}

	public void setTypeId(Short typeId)
	{
		this.typeId = typeId;
	}

	@Column(name = "typeName", nullable = false, length = 10)
	public String getTypeName()
	{
		return this.typeName;
	}

	public void setTypeName(String typeName)
	{
		this.typeName = typeName;
	}

	@Column(name = "valid", nullable = false)
	public Boolean getValid()
	{
		return this.valid;
	}

	public void setValid(Boolean valid)
	{
		this.valid = valid;
	}

	@Column(name = "note", length = 100)
	public String getNote()
	{
		return this.note;
	}

	public void setNote(String note)
	{
		this.note = note;
	}

	@Column(name = "rights", length = 1000)
	public String getRights()
	{
		return this.rights;
	}

	public void setRights(String rights)
	{
		this.rights = rights;
	}

}