package cc.ywxm.dao.gm;

import java.util.List;

import cc.ywxm.model.gm.Manager;

/**
 * 数据库原子操作
 * 
 * @author hdc
 * 
 */
public interface ManagerDao
{
	void save(Manager manager);

	void delete(Manager manager);

	void update(Manager manager);

	Manager findById(Integer userId);

	int count(String userName, Short userType, Boolean valid);

	List<Manager> list(Integer rows, Integer page, String userName,
			Short userType, Boolean valid);

	boolean exist(String userName, String password);

	Manager findByUserName(String userName);

	boolean exist(String userName);

	Manager findById_(Integer userId);
	
}
