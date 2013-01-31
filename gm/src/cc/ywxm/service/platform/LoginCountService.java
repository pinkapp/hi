package cc.ywxm.service.platform;

import java.util.List;

import cc.ywxm.model.platform.LoginCount;

/**
 * 
 * @author HuangDeCai
 * @since 2012-12-18 13:25:10
 * 
 */
public interface LoginCountService
{

	List<LoginCount> gets(String startDate, String endDate);

	/**
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	String XMLData(String startDate, String endDate);

}
