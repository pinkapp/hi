package cc.ywxm.service.impl.gm;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cc.ywxm.dao.gm.RightDao;
import cc.ywxm.model.gm.Node;
import cc.ywxm.model.gm.Right;
import cc.ywxm.service.gm.ManagerTypeRightService;
import cc.ywxm.utils.JSONtool;

@Transactional
@Service
public class ManagerTypeRightServiceImpl implements ManagerTypeRightService
{
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Resource
	private RightDao rightDao;

	public String findRightsString(Short typeId)
	{
		String result = "";
		try
		{
			result = "";
			List<Node> nodeList = new ArrayList<Node>();
			List<Right> rightsAll = rightDao.list();
			String includeRightIds = null;
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

		List<Right> rList = rightDao.list(node.getId());
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
