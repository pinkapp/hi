package cc.ywxm.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import cc.ywxm.model.game.RetentionRate;
import cc.ywxm.utils.BeanRefUtil;

public class Main
{

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException
	{
		//System.out.println(net.sf.json.JSONObject.fromObject("aa"));
//		Map<String ,Object> map = new HashMap<String, Object>();
//		map.put("dd", "dfdf");
//		map.put("map", new int[]{1,3,5,5,63,6544,454});
//		map.put("map", new Manager("ss","dff"));
//		JSONObject jsonObject = new JSONObject(5);
//		System.out.println(jsonObject);
//		Calendar calendar = Calendar.getInstance();
//		int year = calendar.get(Calendar.YEAR);
//		System.out.println(year);
//		RetentionRate rate = new RetentionRate("date", 23343, "99%", "88%", "66%");
//		Map<String,Object> map = BeanRefUtil.getFieldValueMap(rate);
//		System.out.println(map.get("dfsf"));
		FileInputStream in = new FileInputStream(new File("d:/", "build.xml"));
		
		HSSFWorkbook workbook = new HSSFWorkbook(in);
	}

}
