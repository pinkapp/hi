package cc.ywxm.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

public class WebUtils
{
	/**
	 * 把新对象非空属性设置到老对象
	 * 
	 * @param newObj
	 * @param oldObj
	 * @throws Exception
	 */
	public static void setNotNull(Object newObj, Object oldObj)
			throws Exception
	{
		Class<?> newClazz = newObj.getClass();
		Field[] fields = newClazz.getDeclaredFields();
		for (Field field : fields)
		{
			// if (field.get(newObj) != null) {
			// field.set(oldObj, field.get(newObj));
			// }
			Object value = getter(newObj, field.getName());
			if (value != null)
			{
				setter(oldObj, field.getName(), value);
			}
		}
	}

	private static void setter(Object obj, String fieldName, Object value)
			throws Exception
	{
		Class<?> clazz = obj.getClass();
		// HashSet不set
		if (value.getClass().getSimpleName().equalsIgnoreCase("hashset"))
		{
			return;
		}
		Method method = clazz.getMethod("set" + upperFirstChar(fieldName),
				value.getClass());
		method.invoke(obj, value);
	}

	private static Object getter(Object obj, String fieldName) throws Exception
	{
		Class<?> clazz = obj.getClass();
		Method method = clazz.getMethod("get" + upperFirstChar(fieldName));
		Object o = method.invoke(obj);
		return o;
	}

	private static String upperFirstChar(String fieldName)
	{
		byte[] items = fieldName.getBytes();
		items[0] = (byte) ((char) items[0] - 'a' + 'A');
		return new String(items);
	}

	public static String getIpAddr(HttpServletRequest request)
	{
		String ipAddress = null;
		// ipAddress = request.getRemoteAddr();
		ipAddress = request.getHeader("x-forwarded-for");
		if (ipAddress == null || ipAddress.length() == 0
				|| "unknown".equalsIgnoreCase(ipAddress))
		{
			ipAddress = request.getHeader("Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0
				|| "unknown".equalsIgnoreCase(ipAddress))
		{
			ipAddress = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0
				|| "unknown".equalsIgnoreCase(ipAddress))
		{
			ipAddress = request.getRemoteAddr();
			if (ipAddress.equals("127.0.0.1"))
			{
				// 根据网卡取本机配置的IP
				InetAddress inet = null;
				try
				{
					inet = InetAddress.getLocalHost();
				} catch (UnknownHostException e)
				{
					e.printStackTrace();
				}
				ipAddress = inet.getHostAddress();
			}

		}
		// 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
		if (ipAddress != null && ipAddress.length() > 15)
		{ // "***.***.***.***".length()
			if (ipAddress.indexOf(",") > 0)
			{
				ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
			}
		}
		return ipAddress;
	}

}
