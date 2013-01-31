package cc.ywxm.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zeromq.ZMQ;
import org.zeromq.ZMQ.Context;
import org.zeromq.ZMQ.Socket;

import cc.ywxm.io.CPPInputStream;
import cc.ywxm.io.CPPOutputStream;
import cc.ywxm.share.ShareData;

/**
 * ZeroMQ java远程过程调用RFC客户端 内部通讯协议
 * 
 * @author 黄德财
 * @email hd.c@qq.com
 * @since 2012-12-12 13:42:24
 */
public class ZMQutils
{
	private static Logger log = LoggerFactory.getLogger(ZMQutils.class);

	private ZMQutils()
	{
	}

	/**
	 * 无返回值调用
	 * 
	 * @param aid
	 *            玩家ID
	 * @param type
	 *            消息类型
	 * @param flag
	 * @return JSON格式字符串
	 * @throws IOException
	 */
	public static void callNoReturn(Integer aid, Integer type, Integer flag,
			String data) throws IOException
	{
		Socket socket = ShareData.getSocket();
		ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
		CPPOutputStream cppOut = new CPPOutputStream(byteArrayOut);
		writeHeader(cppOut, aid, type.shortValue(), flag.shortValue());
		cppOut.writeUTF(data);
		cppOut.close();
		byteArrayOut.close();
		// 发送
		socket.send(byteArrayOut.toByteArray(), 0);
		log.debug("send header：" + "aid:" + aid + ",type:" + type + ",flag:"
				+ flag);
		log.debug("send data：" + data);
	}

	/**
	 * 远程过程调用
	 * 
	 * @param aid
	 *            玩家ID
	 * @param type
	 *            消息类型
	 * @param flag
	 * @param data
	 *            JSON格式字符串
	 * @return JSON格式字符串
	 * @throws IOException
	 *             IO异常
	 */
	public static String call(Integer aid, Integer type, Integer flag,
			String data) throws IOException
	{
		String result = null;
		Socket socket = ShareData.getSocket();
		Context context = ShareData.getContext();
		ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
		CPPOutputStream cppOut = new CPPOutputStream(byteArrayOut);
		writeHeader(cppOut, aid, type.shortValue(), flag.shortValue());
		cppOut.writeUTF(data);
		cppOut.close();
		byteArrayOut.close();
		// 发送
		socket.send(byteArrayOut.toByteArray(), 0);
		log.debug("send header：" + "aid:" + aid + ",type:" + type + ",flag:"
				+ flag);
		log.debug("send data：" + data);
		byte[] reply = null;
		try
		{
			ZMQ.Poller poller = context.poller(1);
			poller.register(socket, ZMQ.Poller.POLLIN);
			// 等待时间（毫秒）
			poller.poll(10000);
			if (poller.pollin(0))
			{
				// 接收
				reply = socket.recv(0);
			}
		} catch (Exception e)
		{
			log.error(e.getMessage());
		}
		if (reply == null)
		{
			log.debug("receive null");
			return null;
		}
		ByteArrayInputStream byteArrayIn = new ByteArrayInputStream(reply);
		CPPInputStream cppIn = new CPPInputStream(byteArrayIn);
		int aid_ = 0;
		short type_ = 0;
		short flag_ = 0;
		String data_ = "";
		aid = cppIn.readInt();
		type_ = cppIn.readShort();
		flag_ = cppIn.readShort();
		data_ = cppIn.readUTF();
		cppIn.close();
		byteArrayIn.close();
		result = data_;
		log.debug("receive header：" + "aid:" + aid_ + ",type:" + type_
				+ ",flag:" + flag_);
		log.debug("receive data：" + data_);
		return result;
	}

	public static void writeHeader(CPPOutputStream out, int aid, short type,
			short flag) throws IOException
	{
		out.writeInt(aid);
		out.writeShort(type);
		out.writeShort(flag);
	}

}