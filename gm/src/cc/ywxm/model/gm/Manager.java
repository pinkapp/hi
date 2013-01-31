package cc.ywxm.model.gm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Managers entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "managers", uniqueConstraints = @UniqueConstraint(columnNames = "userName"))
public class Manager implements java.io.Serializable
{

	// Fields

	private Integer userId;
	private String userName;
	private String password;
	private String userType;
	private Boolean valid;
	private String note;

	// Constructors

	/** default constructor */
	public Manager()
	{
	}

	/** minimal constructor */
	public Manager(String userName, String password)
	{
		this.userName = userName;
		this.password = password;
	}

	/** full constructor */
	public Manager(String userName, String password, String userType,
			Boolean valid, String note)
	{
		this.userName = userName;
		this.password = password;
		this.userType = userType;
		this.valid = valid;
		this.note = note;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "userId", unique = true, nullable = false)
	public Integer getUserId()
	{
		return this.userId;
	}

	public void setUserId(Integer userId)
	{
		this.userId = userId;
	}

	@Column(name = "userName", unique = true, nullable = false, length = 20)
	public String getUserName()
	{
		return this.userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	@Column(name = "password", nullable = false, length = 32)
	public String getPassword()
	{
		return this.password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	@Column(name = "userType", length = 4)
	public String getUserType()
	{
		return this.userType;
	}

	public void setUserType(String userType)
	{
		this.userType = userType;
	}

	@Column(name = "valid")
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

}