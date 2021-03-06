package cc.ywxm.listener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.zeromq.EmbeddedLibraryTools;
import org.zeromq.ZMQ;

import cc.ywxm.share.ShareData;

@Component
public class AppListener implements ApplicationListener
{
	Logger log = LoggerFactory.getLogger(this.getClass());

	public void onApplicationEvent(ApplicationEvent event)
	{

		String root = System.getProperty("gm.root");
		String url = "";
		try
		{
			log.info("解析配置文件:game.properties");
			InputStream inStream = new FileInputStream(root
					+ "WEB-INF/game.properties");
			Properties props = new Properties();
			props.load(inStream);
			url = props.getProperty("game.server.jzmq.url");
		} catch (FileNotFoundException e)
		{
			log.error(e.getMessage());
		} catch (IOException e)
		{
			log.error(e.getMessage());
		}

		log.info("game.server.jzmq.url:" + url);
		int oiThreads = 1;
		ZMQ.Context context = ZMQ.context(oiThreads);
		ZMQ.Socket socket = context.socket(ZMQ.XREQ);
		try
		{
			log.info("JAVA库路径:" + System.getProperty("java.library.path"));
			socket.connect(url);
			log.info("ZMQ连接准备好，ZMQ版本:" + ZMQ.getVersionString() + "，当前平台:"
					+ EmbeddedLibraryTools.getCurrentPlatformIdentifier());
		} catch (Exception e)
		{
			log.error(e.getMessage());
		}
		ShareData.setSocket(socket);
		ShareData.setContext(context);
	}

}
