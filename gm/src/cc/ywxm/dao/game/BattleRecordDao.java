package cc.ywxm.dao.game;

import java.util.List;

import cc.ywxm.model.game.BattleRecord;

/**
 * 战报数据访问接口
 * 
 * @author HuangDecai
 * @since 2013-1-11 10:14:56
 * 
 */
public interface BattleRecordDao
{

	void save(BattleRecord battleRecord);

	void delete(BattleRecord battleRecord);

	void update(BattleRecord battleRecord);

	BattleRecord get(Integer id);

	List<BattleRecord> list(Integer id);

}
