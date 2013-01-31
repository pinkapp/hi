package cc.ywxm.service.game;

import java.io.File;

/**
 * 关键词设置业务接口
 * 
 * @author HuangDecai
 * 
 */
public interface KeywordsSettingService
{

	public static final int CODE_ZMQ_TIMEOUT = 2000;
	public static final int CODE_ZMQ_NORESPONSE = 8000;
	public static final int CODE_JSON_ERROR = 3000;
	public static final int CODE_SUCCESS = 1;
	public static final int CODE_FAIL = 0;
	public static final int CODE_FILE_NULL = 4000;
	public static final int CODE_FILEEXT_NOT_SUPPORT = 4001;

	/**
	 * 设置关键词，手动输入
	 * 
	 * @param keywords
	 *            关键词
	 * @return
	 */
	int setting(String keywords);

	/**
	 * 设置关键词，文件导入
	 * 
	 * @param file
	 *            文件
	 * @param extension
	 *            扩展名
	 * @param option
	 *            选项
	 * @return
	 */
	int setting(File file, String extension, int option);

	/**
	 * 获取关键词的字节数据[csv格式]
	 * 
	 * @return
	 */
	byte[] get();

}
