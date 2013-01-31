package cc.ywxm.dao.gm;

import java.util.List;

import cc.ywxm.model.gm.Right;

/**
 * 数据库原子操作
 * 
 * @author hdc
 * 
 */
public interface RightDao {
	void save(Right right);

	void delete(Right right);

	void update(Right right);

	Right findById(Integer rightId);

	int count(Integer parentId);

	List<Right> list(Integer parentId);
	
	int count(Integer parentId,String includeRightIds);

	List<Right> list(Integer parentId, String includeRightIds);

	List<Right> list();
}
