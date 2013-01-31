package cc.ywxm.service.impl.gm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cc.ywxm.dao.gm.OperateLogDao;
import cc.ywxm.model.gm.OperateLog;
import cc.ywxm.service.gm.OperateLogService;

@Transactional
@Service
public class OperateLogServiceImpl implements OperateLogService
{
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Resource
	private OperateLogDao operateLogDao;

	public int add(String info, String operator, String ipAddress)
	{
		log.debug(info + "," + operator + "," + ipAddress);
		if (info == null || "".equals(info.trim()) || operator == null
				|| "".equals(operator.trim()) || ipAddress == null
				|| "".equals(ipAddress.trim()))
		{
			log.debug("参数无效");
			return 0;
		}
		operateLogDao.save(info, operator, ipAddress);
		return 1;
	}
	
	public Map<String, Object> gets(Integer rows, Integer page, String sort,
			String order, String username, String startTime, String endTime)
	{
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("rows", new ArrayList<OperateLog>());
		result.put("total", 0);
		
		if (sort == null || "".equals(sort.trim()))
		{
			sort = "logId";
		}
		if (order == null || "".equals(order.trim()))
		{
			order = "desc";
		}
		try
		{
			int total = 0;
			Object list = null;
			if (startTime != null && endTime != null && !"".equals(startTime)
					&& !"".equals(endTime))
			{
				total = operateLogDao.count(username, startTime, endTime);
				list = operateLogDao.list(rows, page, sort, order, username,
						startTime, endTime);

			} else
			{
				total = operateLogDao.count(username);
				list = operateLogDao.list(rows, page, sort, order, username);
			}
			result.put("rows", list);
			result.put("total", total);
		} catch (Exception e)
		{
			log.error(e.getMessage());
		}
		return result;
	}

	public String JSONData(Integer rows, Integer page, String sort,
			String order, String username, String startTime, String endTime)
	{
		Map<String, Object> map = this.gets(rows, page, sort, order, username,
				startTime, endTime);
		return new JSONObject(map).toString();
	}

	public List<OperateLog> gets(String username, String startTime,
			String endTime)
	{
		List<OperateLog> result = new ArrayList<OperateLog>();
		try
		{
			if (startTime != null && endTime != null && !"".equals(startTime)
					&& !"".equals(endTime))
			{
				result = operateLogDao.list(username, startTime, endTime);
			} else
			{
				result = operateLogDao.list(username);
			}
		} catch (Exception e)
		{
			log.error(e.getMessage());
		}
		return result;
		
	}
}
