package cc.ywxm.service.gm;

import java.util.List;

import cc.ywxm.model.gm.ManagerType;

public interface ManagerTypeService {

	/**
	 * @return 用户类型列表
	 */
	List<ManagerType> gets();

	/**
	 * 添加用户类型
	 * 
	 * @param typeName
	 * @param note
	 * @return
	 */
	int add(String typeName, String note);

	/**
	 * 修改用户类型
	 * 
	 * @param typeId
	 * @param typeName
	 * @param note
	 * @return
	 */
	int edit(Short typeId, String typeName, String note);

	/**
	 * 删除用户类型
	 * 
	 * @param typeId
	 * @return
	 */
	int remove(Short typeId);

	/**
	 * 
	 * @param typeId
	 * @return
	 */
	ManagerType get(Short typeId);

	/**
	 * 权限分派
	 * 
	 * @param typeId
	 * @param rights
	 * @return
	 */
	int assign(Short typeId, String rights);

	/**
	 * 用户类型ID--->JSON权限字符串
	 * 
	 * @param typeId
	 * @return JSON权限字符串
	 */
	String right_gets(Short typeId);

}
