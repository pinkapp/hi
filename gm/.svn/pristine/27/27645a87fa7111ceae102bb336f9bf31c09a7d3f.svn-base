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
import cc.ywxm.service.gm.RightService;
import cc.ywxm.utils.JSONtool;

@Transactional
@Service
public class RightServiceImpl implements RightService
{
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Resource
	private RightDao rightDao;

	public String gets()
	{
		String result = "";
		try
		{
			List<Node> nodeList = new ArrayList<Node>();
			List<Right> rightsList = rightDao.list(0);
			for (Right r : rightsList)
			{
				Node nod = new Node();
				nod.setId(r.getRightId());
				nod.setText(r.getRightName());
				nod.setIconCls(r.getIconCls());
				nod.setAttributes(r);
				nod.setRlink(r.getRlink());
				nod.setRdesc(r.getRdesc());
				nod.setRseq(r.getRseq());
				int n = rightDao.count(r.getRightId());
				if (n > 0)
				{
					nod.setState("closed");
					setChildren(nod);
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

	public String gets_()
	{
		String result = "";
		List<Node> nodeList = new ArrayList<Node>();
		Node root = new Node();
		root.setId(0);
		root.setText("根");
		root.setIconCls("icon-ok");
		root.setState("opened");
		try
		{
			setChildren(root);
			nodeList.add(root);
			result = JSONtool.serialize(nodeList);
		} catch (Exception e)
		{
			log.error(e.getMessage());
		}
		return result;

	}

	private void setChildren(Node node)
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
			nod.setRlink(r.getRlink());
			nod.setRdesc(r.getRdesc());
			nod.setRseq(r.getRseq());
			int n = rightDao.count(r.getRightId());
			if (n > 0)
			{
				// if (rList.indexOf(r) == 0) {
				// nod.setState("opened");
				// } else {
				// nod.setState("closed");
				// }
				nod.setState("closed");
				setChildren(nod);
			}
			children.add(nod);
		}
		node.setChildren(children);
	}

	public int add(String rightName, String iconCls, String rlink,
			String rdesc, Integer parentId, Integer rseq)
	{
		if (rightName == null || "".equals(rightName))
		{
			return 3;
		}
		if (parentId == null)
		{
			return -1;
		}
		if (parentId != 0)
		{
			Right r = null;
			try
			{
				r = rightDao.findById(parentId);
			} catch (Exception e)
			{
				log.error(e.getMessage());
			}
			if (r == null)
			{
				return 2;
			}
		}
		try
		{
			rseq = rseq == null ? 0 : rseq;
			Right right = new Right(rightName, iconCls, rlink, rdesc, parentId,
					rseq, true);
			rightDao.save(right);
			return 1;
		} catch (Exception e)
		{
			log.error(e.getMessage());
			return 0;
		}

	}

	public int edit(Integer rightId, String rightName, String iconCls,
			String rlink, String rdesc, Integer parentId, Integer rseq,
			Boolean valid)
	{
		if (rightName == null || "".equals(rightName))
		{
			return 2;// 空名称
		}
		if (rightId == null)
		{
			return -1;// ID无效
		}
		Right right = null;
		try
		{
			right = rightDao.findById(rightId);
		} catch (Exception e)
		{
			log.error(e.getMessage());
		}
		if (right == null)
		{
			return 4;// 权限不存在
		}
		right.setIconCls(iconCls);
		right.setParentId(parentId);
		right.setRdesc(rdesc);
		right.setRightName(rightName);
		right.setRlink(rlink);
		right.setRseq(rseq);
		try
		{
			rightDao.update(right);
			return 1;// 成功
		} catch (Exception e)
		{
			log.error(e.getMessage());
			return 0;// 未知错误
		}
	}

	public Right get(Integer rightId)
	{
		Right result = null;
		try
		{
			result = rightDao.findById(rightId);
		} catch (Exception e)
		{
			log.error(e.getMessage());
		}
		return result;

	}

	public int remove(Integer rightId)
	{
		if (rightId == null)
		{
			return -1;// ID无效
		}
		if (rightId == 1 || rightId == 2 || rightId == 3 || rightId == 4
				|| rightId == 5)
		{
			return 3;// 不能删除的ID
		}
		int n = 1;
		try
		{
			n = rightDao.count(rightId);
		} catch (Exception e)
		{
			log.error(e.getMessage());
		}
		if (n > 0)
		{
			return 4;// 存在子权限
		}
		Right right = null;
		try
		{
			right = rightDao.findById(rightId);
		} catch (Exception e)
		{
			log.error(e.getMessage());
		}
		if (right == null)
		{
			return 2;// 权限不存在
		}
		try
		{
			rightDao.delete(right);
			return 1;
		} catch (Exception e)
		{
			log.error(e.getMessage());
			return 0;
		}
	}
}
