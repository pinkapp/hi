package cc.ywxm.service.platform;

import java.util.List;

import cc.ywxm.model.platform.AgeGroupCount;

/**
 * 
 * @author HuangDeCai
 * @since 2012-12-19 12:54:51
 * 
 */
public interface AgeGroupCountService
{

	List<AgeGroupCount> gets();

	String XMLData();

}
