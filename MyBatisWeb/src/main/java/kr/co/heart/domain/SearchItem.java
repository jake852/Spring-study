package kr.co.heart.domain;

public class SearchItem {

	public static final int DEFAULT_PAZE_SIZE = 10;
	
	private Integer page = 1;
	private Integer pageSize = DEFAULT_PAZE_SIZE;
	private String option = "";
	private String keyword = "";
	private Integer offset;
	
	public SearchItem() {
		
	}
	
	public SearchItem(Integer page, Integer pageSize) {	//키워드가 없어도 검색이 되어야 하니까 	
		this(page, pageSize, "", "");
	}
	
	public SearchItem(Integer page, Integer pageSize, String option, String keyword) {
		//super();
		this.page = page;
		this.pageSize = pageSize;
		this.option = option;
		this.keyword = keyword;
		this.offset = offset;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Integer getOffset() {
		return (page-1)*pageSize;
	}



	@Override
	public String toString() {
		return "SearchItem [page=" + page + ", pageSize=" + pageSize + ", option=" + option + ", keyword=" + keyword
				+ ", offset=" + offset + "]";
	}
	
	
	
}
