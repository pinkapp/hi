package cc.ywxm.service.impl.gm;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cc.ywxm.dao.gm.RightDao;
import cc.ywxm.dao.gm.ManagerTypeDao;
import cc.ywxm.model.gm.Node;
import cc.ywxm.model.gm.Right;
import cc.ywxm.model.gm.ManagerType;
import cc.ywxm.service.gm.ManagerTypeService;
import cc.ywxm.utils.JSONtool;

@Transactional
@Service
public class ManagerTypeServiceImpl implements ManagerTypeService
{
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Resource
	private ManagerTypeDao userTypeDao;
	@Resource
	private RightDao rightDao;

	public List<ManagerType> gets()
	{
		try
		{
			return userTypeDao.list();
		} catch (Exception e)
		{
			log.error(e.getMessage());
			return null;
		}
	}

	public int add(String typeName, String note)
	{
		if (typeName == null || "".equals(typeName))
		{
			return 2;// 空角色名
		}
		ManagerType userType = new ManagerType(typeName, true, note, "");
		try
		{
			userTypeDao.save(userType);
			return 1;// 成功
		} catch (Exception e)
		{
			log.error(e.getMessage());
			return 0;// 未知错误
		}

	}

	public int edit(Short typeId, String typeName, String note)
	{
		if (typeName == null || "".equals(typeName))
		{
			return 2;// 空角色名
		}
		if (typeId == null)
		{
			return -1;// ID无效
		}
		if (typeId == 1)
		{
			return 5;// 超级管理员角色不能编辑
		}
		ManagerType userType = null;
		try
		{
			userType = userTypeDao.findById(typeId);
		} catch (Exception e)
		{
			log.error(e.getMessage());
		}
		if (userType == null)
		{
			return 4;// 角色不存在
		}
		userType.setNote(note);
		userType.setTypeName(typeName);
		try
		{
			userTypeDao.update(userType);
			return 1;// 成功
		} catch (Exception e)
		{
			log.error(e.getMessage());
			return 0;// 未知错误
		}
	}

	public int remove(Short typeId)
	{
		if (typeId == null)
		{
			return -1;// ID无效
		}
		if (typeId == 1)
		{
			return 3;// 超级管理员角色不能删除
		}
		ManagerType userType = null;
		try
		{
			userType = userTypeDao.findById(typeId);
		} catch (Exception e)
		{
			log.error(e.getMessage());
		}
		if (userType == null)
		{
			return 2;// 角色不存在
		}
		try
		{
			userTypeDao.delete(userType);
			return 1;
		} catch (Exception e)
		{
			log.error(e.getMessage());
			return 0;
		}
	}

	public ManagerType get(Short typeId)
	{

		ManagerType userType = null;
		try
		{
			userType = userTypeDao.findById(typeId);
		} catch (Exception e1)
		{
			e1.printStackTrace();
		}
		return userType;
	}

	public int assign(Short typeId, String rights)
	{
		if (typeId == null)
		{
			return -1;// ID无效
		}
		if (typeId == 1)
		{
			return 3;// 超级管理员角色分派无效
		}
		ManagerType userType = null;
		try
		{
			userType = userTypeDao.findById(typeId);
		} catch (Exception e)
		{
			log.error(e.getMessage());
		}
		if (userType == null)
		{
			return 2;// 角色不存在
		}
		try
		{
			if (rights != null)
			{
				rights.replace(" ", "");
			}
			userType.setRights(rights);
			userTypeDao.update(userType);
			return 1;
		} catch (Exception e)
		{
			log.error(e.getMessage());
			return 0;
		}
	}

	public String right_gets(Short typeId)
	{
		String result = "";
		try
		{
			List<Node> nodeList = new ArrayList<Node>();

			String includeRightIds = null;
			if (typeId == 1)
			{// 管理员
				List<Right> rightsAll = null;

				rightsAll = rightDao.list();

				for (Right rights : rightsAll)
				{
					if (rightsAll.indexOf(rights) == 0)
					{
						includeRightIds = rights.getRightId() + "";
					} else
					{
						includeRightIds += "," + rights.getRightId();
					}
				}
			} else
			{
				ManagerType userType = userTypeDao.findById(typeId);
				includeRightIds = userType.getRights();
			}
			List<Right> rightsList = rightDao.list(0, includeRightIds);
			for (Right r : rightsList)
			{
				Node nod = new Node();
				nod.setId(r.getRightId());
				nod.setText(r.getRightName());
				nod.setIconCls(r.getIconCls());
				nod.setAttributes(r);
				int n = rightDao.count(r.getRightId(), includeRightIds);
				if (n > 0)
				{
					// if (rightsList.indexOf(r) == 0)
					// {
					// nod.setState("opened");
					// } else
					// {
					// nod.setState("closed");
					// }
					nod.setState("closed");
					setChildren(nod, includeRightIds);
				}
				nodeList.add(nod);
			}
			result = JSONtool.serialize(nodeList);
		} catch (Exception e)
		{
			log.error(e.getMessage());
		}
		return result;

	}

	// private void setChildren(Node node) {
	//
	// List<Rights> rList = rightDao.list(node.getId());
	// List<Node> children = new ArrayList<Node>();
	// for (Rights r : rList) {
	// Node nod = new Node();
	// nod.setId(r.getRightId());
	// nod.setText(r.getRightName());
	// nod.setIconCls(r.getIconCls());
	// nod.setAttributes(r);
	// int n = rightDao.count(r.getRightId());
	// if (n > 0) {
	// setChildren(nod);
	// }
	// children.add(nod);
	// }
	// node.setChildren(children);
	// }

	private void setChildren(Node node, String includeRightIds)
	{

		List<Right> rList = rightDao.list(node.getId(), includeRightIds);
		List<Node> children = new ArrayList<Node>();
		for (Right r : rList)
		{
			Node nod = new Node();
			nod.setId(r.getRightId());
			nod.setText(r.getRightName());
			nod.setIconCls(r.getIconCls());
			nod.setAttributes(r);
			int n = rightDao.count(r.getRightId(), includeRightIds);
			if (n > 0)
			{
				setChildren(nod, includeRightIds);
			}
			children.add(nod);
		}
		node.setChildren(children);
	}

}
