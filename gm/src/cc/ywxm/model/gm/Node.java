package cc.ywxm.model.gm;

import java.io.Serializable;
import java.util.List;

public class Node implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5294588017039124760L;
	private Integer id;
	private String text;
	private String iconCls;
	private List<Node> children;
	private Boolean checked;
	private String state;
	private Object attributes;
	
	private String rlink;
	private String rdesc;
	private Integer rseq;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}


	public List<Node> getChildren() {
		return children;
	}

	public void setChildren(List<Node> children) {
		this.children = children;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Object getAttributes() {
		return attributes;
	}

	public void setAttributes(Object attributes) {
		this.attributes = attributes;
	}

	public String getRlink() {
		return rlink;
	}

	public void setRlink(String rlink) {
		this.rlink = rlink;
	}

	public String getRdesc() {
		return rdesc;
	}

	public void setRdesc(String rdesc) {
		this.rdesc = rdesc;
	}

	public Integer getRseq() {
		return rseq;
	}

	public void setRseq(Integer rseq) {
		this.rseq = rseq;
	}

}
