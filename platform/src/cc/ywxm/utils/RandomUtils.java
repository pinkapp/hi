package cc.ywxm.utils;

import java.util.Random;

public class RandomUtils
{
	public static String randString(int length)
	{
		String string = "";
		String s = "0123456789qwertyuiopasdfghjklzxcvbnm";
		char[] chars = s.toCharArray();
		char[] chs = new char[length];
		for (int i = 0; i < length; i++)
		{
			chs[i] = chars[getRand(0, s.length() - 1)];
		}
		string = String.valueOf(chs);
		return string;
	}

	public static int getRand(int start, int end)
	{
		if (start > end)
		{
			return -1;
		}
		Random r = new Random();
		return r.nextInt(end - start + 1) + start;
	}
}
