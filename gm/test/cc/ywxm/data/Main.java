package cc.ywxm.data;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main
{
	public static void main(String[] args) throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://192.168.0.248:3306/game?useUnicode=true&characterEncoding=utf8&autoReconnect=true&failOverReadOnly=false";
		String user = "ywxm";
		String password = "ywxm";
		Connection conn = DriverManager.getConnection(url, user, password);
		//Gen.genRegisterLog(conn);
		//Gen.genRechargeLog(conn);
		//Gen.genLoginLog(conn);
		//Gen.genGiftbagLog(conn);
		//Gen.genMobilityLog(conn);
		Gen.genEnergyLog(conn);
	}

	
}
