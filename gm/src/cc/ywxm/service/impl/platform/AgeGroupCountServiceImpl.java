package cc.ywxm.service.impl.platform;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cc.ywxm.model.platform.AgeGroupCount;
import cc.ywxm.service.platform.AgeGroupCountService;

@Transactional
@Service
public class AgeGroupCountServiceImpl implements AgeGroupCountService
{
	private Logger log = LoggerFactory.getLogger(this.getClass());

	public List<AgeGroupCount> gets()
	{
		log.debug("开始模拟数据");
		List<AgeGroupCount> result = new ArrayList<AgeGroupCount>();
		AgeGroupCount[] ageGroupCounts = new AgeGroupCount[9];

		ageGroupCounts[0] = new AgeGroupCount("0-9", 0, 9,
				(int) (Math.random() * 1000));
		ageGroupCounts[1] = new AgeGroupCount("10-14", 10, 14, (int) (Math
				.random() * 1000));
		ageGroupCounts[2] = new AgeGroupCount("15-18", 15, 18, (int) (Math
				.random() * 1000));
		ageGroupCounts[3] = new AgeGroupCount("19-23", 19, 23, (int) (Math
				.random() * 1000));
		ageGroupCounts[4] = new AgeGroupCount("24-28", 24, 28, (int) (Math
				.random() * 1000));
		ageGroupCounts[5] = new AgeGroupCount("29-33", 29, 33, (int) (Math
				.random() * 1000));
		ageGroupCounts[6] = new AgeGroupCount("34-40", 34, 40, (int) (Math
				.random() * 1000));
		// 40以上
		ageGroupCounts[7] = new AgeGroupCount("40-~", 40, -1, (int) (Math
				.random() * 1000));
		// 其它，未填写年龄
		ageGroupCounts[8] = new AgeGroupCount("未填写", -1, -1, (int) (Math
				.random() * 1000));
		for (int i = 0; i < ageGroupCounts.length; i++)
		{
			result.add(ageGroupCounts[i]);
		}
		return result;
	}

	public String XMLData()
	{
		String result = "";
		List<AgeGroupCount> list = this.gets();
		StringBuffer stringBuffer = new StringBuffer();
		String s1 = "<chart yAxisName='玩家人数' caption='玩家年龄段统计' baseFont='宋体' baseFontSize='12' useRoundEdges='1' bgColor='FFFFFF,FFFFFF' showBorder='0'>";
		stringBuffer.append(s1);
		for (AgeGroupCount ageGroupCount : list)
		{
			stringBuffer.append("<set value='" + ageGroupCount.getTotal()
					+ "' label='" + ageGroupCount.getAgeGroup() + "'/>");

		}
		String s2 = "</chart>";
		stringBuffer.append(s2);
		result = stringBuffer.toString();
		return result;
	}

}
