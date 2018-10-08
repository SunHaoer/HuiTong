package pro.sunhao.ht.tool;

import java.util.List;

/**
 * 公共的分页类，用于所有列表的分页查询
 * @author 隼耗
 *
 * @param <T>
 */
public class PageBean<T> {
	
	private int currPage;	// 当前的第几页
	private int pageSize;	// 每一页的数据行数
	private int totalCount;		// 所有的数据行数
	private int totalPage;		// 所有的页数
	private List<T> pageList;		// 当前分页的数据

	public int getCurrPage() {
		return currPage;
	}
	
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public int getTotalCount() {
		return totalCount;
	}
	
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	public int getTotalPage() {
		return totalPage;
	}
	
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getPageList() {
		return pageList;
	}

	public void setPageList(List<T> pageList) {
		this.pageList = pageList;
	}

	@Override
	public String toString() {
		return "PageBean [currPage=" + currPage + ", pageSize=" + pageSize + ", totalCount=" + totalCount
				+ ", totalPage=" + totalPage + ", pageList=" + pageList + "]";
	}
	
}
