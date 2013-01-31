package cc.ywxm.service.gm;


public interface ManagerTypeRightService
{
	/**
	 * 用户类型ID--->JSON权限字符串
	 * @param typeId
	 * @return JSON权限字符串
	 */
	String findRightsString(Short typeId);
}
