package hdc;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;

import cc.ywxm.secret.Auth;

public class Test
{

	/**
	 * @param args
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static void main(String[] args)
	{
		String string = "{'a':2,'b':8}";
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", "1");
		map.put("action", "logout");
		try
		{
			string = JSONUtil.serialize(map);
		} catch (JSONException e1)
		{
			e1.printStackTrace();
		}
		System.out.println(string);
		Auth auth = new Auth();
		string = auth.authcode(string, Auth.ENCODE);
		try
		{
			string = URLEncoder.encode(string, "utf-8");
		} catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}

		// DefaultHttpClient httpclient = new DefaultHttpClient();
		// try
		// {
		// HttpGet httpget = new HttpGet(
		// "http://localhost/demo/cookie.php?code=" + string);
		//
		// HttpResponse response = httpclient.execute(httpget);
		// HttpEntity entity = response.getEntity();
		//
		// System.out.println("Login form get: " + response.getStatusLine());
		// String aa =EntityUtils.toString(entity);
		// System.out.println(aa);
		// EntityUtils.consume(entity);
		//
		// System.out.println("Initial set of cookies:");
		// List<Cookie> cookies = httpclient.getCookieStore().getCookies();
		// if (cookies.isEmpty())
		// {
		// System.out.println("None");
		// } else
		// {
		// for (int i = 0; i < cookies.size(); i++)
		// {
		// System.out.println("- " + cookies.get(i).toString());
		// }
		// }
		//
		// } finally
		// {
		// // When HttpClient instance is no longer needed,
		// // shut down the connection manager to ensure
		// // immediate deallocation of all system resources
		// httpclient.getConnectionManager().shutdown();
		// }
		// }

		// HttpURLConnection conn = new
		// try
		// {
		// string = URLDecoder.decode(string, "utf-8");
		// //System.out.println(string);
		// } catch (UnsupportedEncodingException e)
		// {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// string=auth.authcode(string, Auth.DECODE);
		// System.out.println(string);
	}
}
