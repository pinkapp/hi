package cc.ywxm.dao.game;

import java.util.List;

import cc.ywxm.model.game.BaseInfo;

/**
 * 数据库原子操作
 * 
 * @author hdc
 * 
 */
public interface BaseInfoDao
{

	void save(BaseInfo baseInfo);

	void update(BaseInfo baseInfo);

	void update(Integer player, Integer gold, Double silver, Integer exp,
			Short energy, Integer feat, Integer prestige, Short mobility,
			Short level, Short progress);

	Integer findPlayerByNickname(String nickname);

	BaseInfo get(Integer player);

	int count(String nickname);

	List<BaseInfo> list(Integer rows, Integer page, String nickname);

	List<BaseInfo> list(Integer rows, Integer page, String sort, String order,
			String nickname);

	int maxId();

	boolean nicknameExist(String nickname);

	void updateGold(Integer player, Integer value);

	void updateSilver(Integer player, Integer value);

	void updateEnergy(Integer player, Integer value);

	void updateMobility(Integer player, Integer value);

	void updateProgress(Integer player, Integer value);

	void updateRechargedGold(Integer player, Integer value);

	void updateFeat(Integer player, Integer value);

	void updatePrestige(Integer player, Integer value);

}
