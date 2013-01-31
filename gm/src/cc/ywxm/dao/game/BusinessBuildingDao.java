package cc.ywxm.dao.game;

import java.util.List;

import cc.ywxm.model.game.BusinessBuilding;

/**
 * 数据库原子操作
 * 
 * @author hdc
 * 
 */
public interface BusinessBuildingDao
{

	void save(BusinessBuilding bb);

	void delete(BusinessBuilding bb);

	void update(BusinessBuilding bb);

	BusinessBuilding findById(Integer player);

	List<BusinessBuilding> list(Integer player);

}
