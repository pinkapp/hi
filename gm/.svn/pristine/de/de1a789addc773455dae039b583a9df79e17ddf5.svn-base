package cc.ywxm.utils;

import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;

public class JSONtool {
	/**
	 * 对象序列化未JSON格式，不包括空属性
	 * 
	 * @param object
	 * @return
	 */
	public static String serialize(Object object) {
		try {
			return JSONUtil.serialize(object, null, null, false, false, true);
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}
}
