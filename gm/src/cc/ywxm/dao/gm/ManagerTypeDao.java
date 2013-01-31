package cc.ywxm.dao.gm;

import java.util.List;

import cc.ywxm.model.gm.ManagerType;

/**
 * 数据库原子操作
 * 
 * @author hdc
 * 
 */
public interface ManagerTypeDao
{
	void save(ManagerType managerType);

	void delete(ManagerType managerType);

	void update(ManagerType managerType);

	ManagerType findById(Short typeId);

	int count(Object... args);

	List<ManagerType> list();
}
