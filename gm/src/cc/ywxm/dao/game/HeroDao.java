package cc.ywxm.dao.game;

import java.util.List;

import cc.ywxm.model.game.Hero;

/**
 * 数据库原子操作
 * 
 * @author hdc
 * 
 */
public interface HeroDao
{

	void save(Hero hero);

	void delete(Hero hero);

	void update(Hero hero);

	Hero findById(Integer player);

	List<Hero> list(Integer player);

}
