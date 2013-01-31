package cc.ywxm.dao.game;

import java.util.List;

import cc.ywxm.model.game.Mail;

/**
 * 数据库原子操作
 * 
 * @author hdc
 * 
 */
public interface MailDao
{

	void save(Mail mail);

	void delete(Mail mail);

	void update(Mail mail);

	Mail findByPlayer(Integer player);

	int count(Integer player);

	int count(String nickname);

	List<Mail> list(Integer rows, Integer page, Integer player);

	List<Mail> list(Integer rows, Integer page, String sort, String order,
			Integer player);

	List<Mail> list(Integer rows, Integer page, String nickname);

	List<Mail> list(Integer rows, Integer page, String sort, String order,
			String nickname);

}
