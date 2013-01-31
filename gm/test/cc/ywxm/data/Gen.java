package cc.ywxm.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Gen
{
	/**
	 * 生成玩家消费日志
	 * 
	 * @param conn
	 * @throws Exception
	 */
	public static void genConsumeLog(Connection conn) throws Exception
	{
		PreparedStatement prep = null;
		prep = conn.prepareStatement("SELECT * FROM base_info t");
		prep.execute();
		ResultSet rs = prep.getResultSet();
		List<Integer> playerList = new ArrayList<Integer>();
		while (rs.next())
		{
			playerList.add(rs.getInt("player"));
		}
		rs.close();
		prep = conn
				.prepareStatement("INSERT INTO consume_log(player,money,useFor,logTime) VALUES(?,?,?,?)");
		String[] userFors = new String[]
		{ "买装备id=44", "买装备id=55", "买装备id=2", "买装备id=56", "买装备id=66",
				"买装备id=545" };

		for (int i = 0; i < 10000; i++)
		{
			int player = playerList.get((int) (Math.random() * (10)));
			int money = (int) (Math.random() * 10002);
			String userFor = userFors[(int) (Math.random() * (userFors.length - 1))];
			prep.setInt(1, player);
			prep.setDouble(2, money);
			prep.setString(3, userFor);
			prep.setTimestamp(4, new Timestamp(new Date().getTime()
					- (int) (Math.random() * 1000 * 60 * 60 * 24 * 7)));
			prep.addBatch();
		}

		conn.setAutoCommit(false);
		prep.executeBatch();
		conn.setAutoCommit(true);
		conn.close();
	}

	/**
	 * 生成玩家注册日志
	 * 
	 * @param conn
	 * @throws Exception
	 */
	public static void genRegisterLog(Connection conn) throws Exception
	{
		PreparedStatement prep = null;
		prep = conn.prepareStatement("SELECT * FROM base_info t");
		prep.execute();
		ResultSet rs = prep.getResultSet();
		List<Integer> playerList = new ArrayList<Integer>();
		while (rs.next())
		{
			playerList.add(rs.getInt("player"));
		}
		rs.close();
		prep = conn
				.prepareStatement("INSERT INTO register_log(player,ipAddress,logTime) VALUES (?,?,?)");
		String[] ipAddresses = new String[]
		{ "136.56.8.21", "16.6.8.21", "136.56.8.77", "136.56.8.28",
				"156.56.8.21", "26.56.7.21" };

		for (int i = 0; i < 10000; i++)
		{
			int player = playerList.get(i);
			String ipAddress = ipAddresses[(int) (Math.random() * (ipAddresses.length - 1))];
			prep.setInt(1, player);
			prep.setString(2, ipAddress);
			prep.setTimestamp(3, new Timestamp(new Date().getTime()
					- (int) (Math.random() * 1000 * 60 * 60 * 24 * 30)));
			prep.addBatch();
		}

		conn.setAutoCommit(false);
		prep.executeBatch();
		conn.setAutoCommit(true);
		conn.close();
	}

	/**
	 * 生成玩家登录日志
	 * 
	 * @param conn
	 * @throws Exception
	 */
	public static void genLoginLog(Connection conn) throws Exception
	{
		PreparedStatement prep = null;
		prep = conn.prepareStatement("SELECT * FROM base_info t");
		prep.execute();
		ResultSet rs = prep.getResultSet();
		List<Integer> playerList = new ArrayList<Integer>();
		while (rs.next())
		{
			playerList.add(rs.getInt("player"));
		}
		rs.close();
		prep = conn
				.prepareStatement("INSERT INTO login_log(player,ipAddress,logTime) VALUES (?,?,?)");
		String[] ipAddresses = new String[]
		{ "136.56.8.21", "16.6.8.21", "136.56.8.77", "136.56.8.28",
				"156.56.8.21", "26.56.7.21" };

		for (int i = 0; i < 10000; i++)
		{
			int player = playerList.get((int) (Math.random() * (10)));
			String ipAddress = ipAddresses[(int) (Math.random() * (ipAddresses.length - 1))];
			prep.setInt(1, player);
			prep.setString(2, ipAddress);
			prep.setTimestamp(3, new Timestamp(new Date().getTime()
					- (int) (Math.random() * 1000 * 60 * 60 * 24 * 30)));
			prep.addBatch();
		}

		conn.setAutoCommit(false);
		prep.executeBatch();
		conn.setAutoCommit(true);
		conn.close();
	}

	/**
	 * 生成玩家充值日志
	 * 
	 * @param conn
	 * @throws Exception
	 */
	public static void genRechargeLog(Connection conn) throws Exception
	{
		PreparedStatement prep = null;
		prep = conn.prepareStatement("SELECT * FROM base_info t");
		prep.execute();
		ResultSet rs = prep.getResultSet();
		List<Integer> playerList = new ArrayList<Integer>();
		while (rs.next())
		{
			playerList.add(rs.getInt("player"));
		}
		rs.close();
		prep = conn
				.prepareStatement("INSERT INTO recharge_log(player,money,surplus,logTime,platform,bank) VALUE (?,?,?,?,?,?)");

		for (int i = 0; i < 10000; i++)
		{
			int money = (int) (Math.random() * 1000);
			int surplus = (int) (Math.random() * 80);
			int player = playerList.get((int) (Math.random() * (10)));
			prep.setInt(1, player);
			prep.setDouble(2, money);
			prep.setDouble(3, surplus);
			prep.setTimestamp(4, new Timestamp(new Date().getTime()
					- (int) (Math.random() * 1000 * 60 * 60 * 24 * 30)));
			prep.setInt(5, 1 + (int) (Math.random() * 5));
			prep.setInt(6, 1 + (int) (Math.random() * 10));
			prep.addBatch();
		}

		conn.setAutoCommit(false);
		prep.executeBatch();
		conn.setAutoCommit(true);
		conn.close();
	}

	/**
	 * 生成礼包使用日志
	 * 
	 * @param conn
	 * @throws Exception
	 */
	public static void genGiftbagLog(Connection conn) throws Exception
	{
		PreparedStatement prep = null;
		prep = conn.prepareStatement("SELECT * FROM base_info t");
		prep.execute();
		ResultSet rs = prep.getResultSet();
		List<Integer> playerList = new ArrayList<Integer>();
		while (rs.next())
		{
			playerList.add(rs.getInt("player"));
		}
		rs.close();
		prep = conn
				.prepareStatement("INSERT INTO giftbag_log(player,giftbagType,gifts,logTime) VALUES (?,?,?,?)");
		String[] gifts = new String[]
		{ "一品武术丹、一品法术丹、一品绝技丹", "降魔法冠、降魔法袍、降魔战靴", "降魔战魂、降魔弓",
				"一品武术丹、一品法术丹、一品绝技丹", "20点体力", "30点武力", "20点绝技", "50点法术" };

		for (int i = 0; i < 10000; i++)
		{
			int player = playerList.get((int) (Math.random() * (10)));
			String gift = gifts[(int) (Math.random() * (gifts.length - 1))];
			prep.setInt(1, player);
			prep.setInt(2, 1 + (int) (Math.random() * 5));
			prep.setString(3, gift);
			prep.setTimestamp(4, new Timestamp(new Date().getTime()
					- (int) (Math.random() * 1000 * 60 * 60 * 24 * 30)));
			prep.addBatch();
		}

		conn.setAutoCommit(false);
		prep.executeBatch();
		conn.setAutoCommit(true);
		conn.close();
	}

	/**
	 * 生成行动力使用日志
	 * 
	 * @param conn
	 * @throws Exception
	 */
	public static void genMobilityLog(Connection conn) throws Exception
	{
		PreparedStatement prep = null;
		prep = conn.prepareStatement("SELECT * FROM base_info t");
		prep.execute();
		ResultSet rs = prep.getResultSet();
		List<Integer> playerList = new ArrayList<Integer>();
		while (rs.next())
		{
			playerList.add(rs.getInt("player"));
		}
		rs.close();
		prep = conn
				.prepareStatement("INSERT INTO mobility_log(player,reduce,surplus,logTime) VALUE (?,?,?,?)");

		for (int i = 0; i < 10000; i++)
		{
			int reduce = 1 + (int) (Math.random() * 10);
			int surplus = (int) (Math.random() * 100000);
			int player = playerList.get((int) (Math.random() * (10)));
			prep.setInt(1, player);
			prep.setDouble(2, reduce);
			prep.setDouble(3, surplus);
			prep.setTimestamp(4, new Timestamp(new Date().getTime()
					- (int) (Math.random() * 1000 * 60 * 60 * 24 * 30)));
			prep.addBatch();
		}

		conn.setAutoCommit(false);
		prep.executeBatch();
		conn.setAutoCommit(true);
		conn.close();
	}
	
	/**
	 * 生成活力使用日志
	 * 
	 * @param conn
	 * @throws Exception
	 */
	public static void genEnergyLog(Connection conn) throws Exception
	{
		PreparedStatement prep = null;
		prep = conn.prepareStatement("SELECT * FROM base_info t");
		prep.execute();
		ResultSet rs = prep.getResultSet();
		List<Integer> playerList = new ArrayList<Integer>();
		while (rs.next())
		{
			playerList.add(rs.getInt("player"));
		}
		rs.close();
		prep = conn
		.prepareStatement("INSERT INTO energy_log(player,reduce,surplus,logTime) VALUE (?,?,?,?)");
		
		for (int i = 0; i < 10000; i++)
		{
			int reduce = 1 + (int) (Math.random() * 10);
			int surplus = (int) (Math.random() * 100000);
			int player = playerList.get((int) (Math.random() * (10)));
			prep.setInt(1, player);
			prep.setDouble(2, reduce);
			prep.setDouble(3, surplus);
			prep.setTimestamp(4, new Timestamp(new Date().getTime()
					- (int) (Math.random() * 1000 * 60 * 60 * 24 * 30)));
			prep.addBatch();
		}
		
		conn.setAutoCommit(false);
		prep.executeBatch();
		conn.setAutoCommit(true);
		conn.close();
	}
}
