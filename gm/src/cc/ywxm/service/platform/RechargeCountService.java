package cc.ywxm.service.platform;

import java.util.List;

import cc.ywxm.model.platform.RechargeCount;
import cc.ywxm.model.platform.RechargeCount1;

/**
 * 
 * @author HuangDeCai
 * @since 2012-12-17 10:16:59
 * 
 */
public interface RechargeCountService
{

	List<RechargeCount> gets(String startDate, String endDate);

	/**
	 * 每日充值统计
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	String XMLData(String startDate, String endDate);

	/**
	 * 充值玩家统计
	 * 
	 * @return
	 */
	List<RechargeCount1> gets1();

	/**
	 * 
	 * @return
	 */
	String XMLData1();

}
