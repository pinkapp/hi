package cc.ywxm.listener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import cc.ywxm.share.ShareData;

@Component
public class AppListener implements ApplicationListener
{
	Logger log = LoggerFactory.getLogger(this.getClass());

	public void onApplicationEvent(ApplicationEvent event)
	{

		String root = System.getProperty("platform.root");
		try
		{
			log.info("解析配置文件:platform.properties");
			InputStream inStream = new FileInputStream(root
					+ "WEB-INF/platform.properties");

			Properties props = new Properties();
			props.load(inStream);

			Map<String, String> map = new HashMap<String, String>();
			Set<Object> set = props.keySet();
			for (Object key : set)
			{
				map.put((String) key, (String) props.get(key));
			}
			// props.clear();
			// log.info("解析配置文件:client.properties");
			// inStream = new FileInputStream(root
			// + "WEB-INF/client.properties");
			// props.load(inStream);
			// set = props.keySet();
			// for (Object key : set)
			// {
			// map.put((String) key, (String) props.get(key));
			// }
			// inStream.close();
			ShareData.setMap(map);
			// System.out.println(String.format("data=%s", map));
		} catch (FileNotFoundException e)
		{
			log.error(e.getMessage());
		} catch (IOException e)
		{
			log.error(e.getMessage());
		}
	}

}
