package cc.ywxm.model.game;


/**
 * 玩家基本信息
 */
public class BaseInfo{

	// Fields

	private Integer player;
	private String nickname;
	private String sex;
	private String country;
	private Integer gold;
	private Double silver;
	private Integer exp;
	private Short energy;
	private Integer feat;
	private Integer prestige;
	private Short mobility;
	private Short level;
	private Short progress;
	private Short array;
	private Integer rechargedGold;
	private String guildId;
	//private String guild;

	// Constructors

	/** default constructor */
	public BaseInfo() {
	}

	public Integer getPlayer() {
		return player;
	}

	public void setPlayer(Integer player) {
		this.player = player;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getGold() {
		return gold;
	}

	public void setGold(Integer gold) {
		this.gold = gold;
	}

	public Double getSilver() {
		return silver;
	}

	public void setSilver(Double silver) {
		this.silver = silver;
	}

	public Integer getExp() {
		return exp;
	}

	public void setExp(Integer exp) {
		this.exp = exp;
	}

	public Short getEnergy() {
		return energy;
	}

	public void setEnergy(Short energy) {
		this.energy = energy;
	}

	public Integer getFeat() {
		return feat;
	}

	public void setFeat(Integer feat) {
		this.feat = feat;
	}

	public Integer getPrestige() {
		return prestige;
	}

	public void setPrestige(Integer prestige) {
		this.prestige = prestige;
	}

	public Short getMobility() {
		return mobility;
	}

	public void setMobility(Short mobility) {
		this.mobility = mobility;
	}

	public Short getLevel() {
		return level;
	}

	public void setLevel(Short level) {
		this.level = level;
	}

	public Short getProgress() {
		return progress;
	}

	public void setProgress(Short progress) {
		this.progress = progress;
	}

	public Short getArray() {
		return array;
	}

	public void setArray(Short array) {
		this.array = array;
	}

	public Integer getRechargedGold() {
		return rechargedGold;
	}

	public void setRechargedGold(Integer rechargedGold) {
		this.rechargedGold = rechargedGold;
	}

	public String getGuildId() {
		return guildId;
	}

	public void setGuildId(String guildId) {
		this.guildId = guildId;
	}

	// public String getGuild() {
	// return guild;
	// }
	//
	// public void setGuild(String guild) {
	// this.guild = guild;
	// }

}