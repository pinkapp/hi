package cc.ywxm.service.gm;

import cc.ywxm.model.gm.Right;

public interface RightService {
	/**
	 * 
	 * @return
	 */
	String gets();

	/**
	 * 
	 * @return
	 */
	String gets_();

	/**
	 * 
	 * @param rightName
	 * @param iconCls
	 * @param rlink
	 * @param rdesc
	 * @param rseq
	 * @return
	 */
	int add(String rightName, String iconCls, String rlink, String rdesc,
			Integer parentId, Integer rseq);

	/**
	 * 
	 * @param rightId
	 * @param rightName
	 * @param iconCls
	 * @param rlink
	 * @param rdesc
	 * @param rseq
	 * @param valid
	 * @return
	 */
	int edit(Integer rightId, String rightName, String iconCls, String rlink,
			String rdesc, Integer parentId, Integer rseq, Boolean valid);

	/**
	 * 
	 * @param rightId
	 * @return
	 */
	int remove(Integer rightId);

	/**
	 * 
	 * @param rightId
	 * @return
	 */
	Right get(Integer rightId);

}
