package cc.ywxm.action.base;


public class PageableAction extends BaseAction implements
		Pageable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6479473006736688769L;
	private int pageNo = 1;
	private int pageSize = 10;
	private int totalCount = 0;
	private final static int DEFAULT_PAGE_NO = 1;
	private final static int DEFAULT_PAGE_SIZE = 10;

	/*
	 * (non-Javadoc)
	 * 
	 * @see cc.ywxm.utils.Page#getStart()
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see cc.ywxm.utils.Page#getStart()
	 */
	public int getStart()
	{
		return (pageNo - 1) * pageSize;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cc.ywxm.utils.Page#getEnd()
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see cc.ywxm.utils.Page#getEnd()
	 */
	public int getEnd()
	{
		return pageNo * pageSize;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cc.ywxm.utils.Page#getPageNo()
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see cc.ywxm.utils.Page#getPageNo()
	 */
	public int getPageNo()
	{
		return pageNo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cc.ywxm.utils.Page#setPageNo(int)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see cc.ywxm.utils.Page#setPageNo(int)
	 */
	public void setPageNo(int pageNo)
	{
		this.pageNo = pageNo > 0 ? pageNo : DEFAULT_PAGE_NO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cc.ywxm.utils.Page#getPageSize()
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see cc.ywxm.utils.Page#getPageSize()
	 */
	public int getPageSize()
	{
		return pageSize;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cc.ywxm.utils.Page#setPageSize(int)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see cc.ywxm.utils.Page#setPageSize(int)
	 */
	public void setPageSize(int pageSize)
	{
		this.pageSize = pageSize > 0 ? pageSize : DEFAULT_PAGE_SIZE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cc.ywxm.utils.Page#getTotalCount()
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see cc.ywxm.utils.Page#getTotalCount()
	 */
	public int getTotalCount()
	{
		return totalCount;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cc.ywxm.utils.Page#setTotalCount(int)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see cc.ywxm.utils.Page#setTotalCount(int)
	 */
	public void setTotalCount(int totalCount)
	{
		this.totalCount = totalCount;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cc.ywxm.utils.Page#getTotalPageCount()
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see cc.ywxm.utils.Page#getTotalPageCount()
	 */
	public int getTotalPageCount()
	{
		int totalPageCount = totalCount / pageSize;
		if (totalCount % pageSize > 0)
		{
			totalPageCount++;
		}
		return totalPageCount;
	}

}
