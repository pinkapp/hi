package cc.ywxm.model.gm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Rights entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "rights")
public class Right implements java.io.Serializable {

	// Fields

	private Integer rightId;
	private String rightName;
	private String iconCls;
	private String rlink;
	private String rdesc;
	private Integer parentId;
	private Integer rseq;
	private Boolean valid;

	// Constructors

	/** default constructor */
	public Right() {
	}

	/** minimal constructor */
	public Right(String rightName) {
		this.rightName = rightName;
	}

	/** full constructor */
	public Right(String rightName, String iconCls, String rlink, String rdesc,
			Integer parentId, Integer rseq, Boolean valid) {
		this.rightName = rightName;
		this.iconCls = iconCls;
		this.rlink = rlink;
		this.rdesc = rdesc;
		this.parentId = parentId;
		this.rseq = rseq;
		this.valid = valid;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "rightId", unique = true, nullable = false)
	public Integer getRightId() {
		return this.rightId;
	}

	public void setRightId(Integer rightId) {
		this.rightId = rightId;
	}

	@Column(name = "rightName", nullable = false, length = 20)
	public String getRightName() {
		return this.rightName;
	}

	public void setRightName(String rightName) {
		this.rightName = rightName;
	}

	@Column(name = "iconCls", length = 10)
	public String getIconCls() {
		return this.iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	@Column(name = "rlink", length = 50)
	public String getRlink() {
		return this.rlink;
	}

	public void setRlink(String rlink) {
		this.rlink = rlink;
	}

	@Column(name = "rdesc", length = 10)
	public String getRdesc() {
		return this.rdesc;
	}

	public void setRdesc(String rdesc) {
		this.rdesc = rdesc;
	}

	@Column(name = "parentId")
	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	@Column(name = "rseq")
	public Integer getRseq() {
		return this.rseq;
	}

	public void setRseq(Integer rseq) {
		this.rseq = rseq;
	}

	@Column(name = "valid")
	public Boolean getValid() {
		return this.valid;
	}

	public void setValid(Boolean valid) {
		this.valid = valid;
	}

}