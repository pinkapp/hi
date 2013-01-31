package cc.ywxm.share;

import org.zeromq.ZMQ.Context;
import org.zeromq.ZMQ.Socket;

public class ShareData
{
	private static Socket socket;
	private static Context context;

	public static Socket getSocket()
	{
		return socket;
	}

	public static void setSocket(Socket socket)
	{
		ShareData.socket = socket;
	}

	public static Context getContext()
	{
		return context;
	}

	public static void setContext(Context context)
	{
		ShareData.context = context;
	}
	
}
