package cc.ywxm.dao.gm;

import java.util.List;

import cc.ywxm.model.game.RechargeLog;
import cc.ywxm.model.platform.PaywayCount;
import cc.ywxm.model.platform.RechargeRank;

/**
 * 充值日志数据访问对象
 * 
 * @author HuangDecai
 * @since 2012-12-26 15:57:58
 * 
 */
public interface RechargeLogDao
{
	/**
	 * 某日充值次数
	 * 
	 * @param date
	 *            记录日期
	 * @return 次数
	 */
	int count(String date);

	/**
	 * 某个充值金额范围次数
	 * 
	 * @param minMoney
	 *            最小金额
	 * @param maxMoney
	 *            最大金额
	 * @return 次数
	 */
	int count(double minMoney, double maxMoney);

	/**
	 * 某日充值人数
	 * 
	 * @param date
	 *            记录日期
	 * @return 人数
	 */
	int count1(String date);

	/**
	 * 某日充值金额
	 * 
	 * @param date
	 *            记录日期
	 * @return 金额
	 */
	double count2(String date);

	/**
	 * 充值排名
	 * 
	 * @return 前20名列表
	 */
	List<RechargeRank> rank();

	/**
	 * 月充值排名
	 * 
	 * @param year
	 *            年
	 * @param month
	 *            月
	 * @return 前20名列表
	 */
	public List<RechargeRank> rank(int year, int month);

	/**
	 * 
	 * @param startDate
	 *            开始日期
	 * @param endDate
	 *            结束日期
	 * @return 前20名列表
	 */
	public List<RechargeRank> rank(String startDate, String endDate);

	/**
	 * 按第三方支付平台
	 * 
	 * @return 按第三方支付平台使用次数统计列表
	 */
	public List<PaywayCount> countByPlatform();

	/**
	 * 按支付银行
	 * 
	 * @return 按银行分类使用次数统计列表
	 */
	public List<PaywayCount> countByBank();

	/**
	 * 统计玩家充值日志
	 * 
	 * @param player
	 *            玩家ID
	 * @return 总数
	 */
	int count(Integer player);

	/**
	 * 统计玩家某个时间段充值日志
	 * 
	 * @param player
	 *            玩家ID
	 * @param startTime
	 * @param endTime
	 * @return 总数
	 */
	int count(Integer player, String startTime, String endTime);

	/**
	 * 查询玩家充值日志(分页加排序)
	 * 
	 * @param rows
	 *            每页几条
	 * @param page
	 *            第几页
	 * @param sort
	 *            排序字段
	 * @param order
	 *            正序/反序
	 * @param player
	 *            玩家ID
	 * @return 日志列表
	 */
	List<RechargeLog> list(Integer rows, Integer page, String sort,
			String order, Integer player);

	/**
	 * 查询玩家某个时间段充值日志(分页加排序)
	 * 
	 * @param rows
	 *            每页几条
	 * @param page
	 *            第几页
	 * @param sort
	 *            排序字段
	 * @param order
	 *            正序/反序
	 * @param player
	 *            玩家ID
	 * @param startTime
	 *            开始时间
	 * @param endTime
	 *            结束时间
	 * @return 日志列表
	 */
	List<RechargeLog> list(Integer rows, Integer page, String sort,
			String order, Integer player, String startTime, String endTime);

	/**
	 * 查询玩家充值日志
	 * 
	 * @param player
	 *            玩家ID
	 * @return 日志列表
	 */
	List<RechargeLog> list(Integer player);

	/**
	 * 查询玩家某个时间段日志
	 * 
	 * @param player
	 *            玩家ID
	 * @param startTime
	 *            开始时间
	 * @param endTime
	 *            结束时间
	 * @return 日志列表
	 */
	List<RechargeLog> list(Integer player, String startTime, String endTime);

	void save(Integer player, Double money, Double surplus, Integer platform,
			Integer bank);

}
