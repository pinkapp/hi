package cc.ywxm.model.game;

/**
 * 邮件记录
 * 
 * @author HuangDeCai
 * @since 2012-12-8 9:26:17
 * 
 */
public class Mail
{

	// Fields

	private Integer player;
	private Short mailId;
	private String read_;
	private String type;
	private String hasAttach;
	private String time;
	private Integer uid;
	private String nickname;
	private String subject;
	private String content;
	private String attach;
	private String nickname1;

	// Constructors

	/** default constructor */
	public Mail()
	{
	}

	public Integer getPlayer()
	{
		return player;
	}

	public void setPlayer(Integer player)
	{
		this.player = player;
	}

	public Short getMailId()
	{
		return mailId;
	}

	public void setMailId(Short mailId)
	{
		this.mailId = mailId;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getHasAttach()
	{
		return hasAttach;
	}

	public void setHasAttach(String hasAttach)
	{
		this.hasAttach = hasAttach;
	}

	public String getTime()
	{
		return time;
	}

	public void setTime(String time)
	{
		this.time = time;
	}

	public Integer getUid()
	{
		return uid;
	}

	public void setUid(Integer uid)
	{
		this.uid = uid;
	}

	public String getNickname()
	{
		return nickname;
	}

	public void setNickname(String nickname)
	{
		this.nickname = nickname;
	}

	public String getSubject()
	{
		return subject;
	}

	public void setSubject(String subject)
	{
		this.subject = subject;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public String getAttach()
	{
		return attach;
	}

	public void setAttach(String attach)
	{
		this.attach = attach;
	}

	public String getNickname1()
	{
		return nickname1;
	}

	public void setNickname1(String nickname1)
	{
		this.nickname1 = nickname1;
	}

	public String getRead_()
	{
		return read_;
	}

	public void setRead_(String read)
	{
		read_ = read;
	}

}