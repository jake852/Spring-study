package kr.co.heart.domain;

public class PageResolver {

	private SearchItem sc;
	
	private int totalCnt;				// 게시물 총 갯수
	//private int pageSize = 10;			// 한 페이지당 게시물 갯수  , SearchItem에 있어서 굳이 없어도된다.
	public final int NAV_SIZE = 10;		// page navigation size
	
	private int totalPage;				// 전체 페이지 갯수
	//private int page;					// 현재 페이지  , SearchItem에 있어서 굳이 없어도된다.

	private int beginPage;				// 화면에 보여줄 첫 페이지
	private int endPage;				// 화면에 보여줄 마지막 페이지
	private boolean showNext = false;	// 이후를 보여줄지 여부 (endPage ==totalPage] 이면 shownext는 false)
	private boolean showPrev = false;	// 이전을 보여줄지 여부 (beginPage ==1 이 아니면 showPrev는 true)
	
	
	public PageResolver(int totalCnt, Integer page) {
		this(totalCnt, new SearchItem(page, 10));  //this()가 밑의 pageResolver(int totalCnt, SearchItem sc)을 호출한다.
	}
	
	public PageResolver(int totalCnt, Integer page, Integer pageSize ) {
		this(totalCnt, new SearchItem(page, pageSize));
	}
	
	public PageResolver(int totalCnt, SearchItem sc) {
		this.totalCnt = totalCnt;
		this.sc = sc;
		
		doPaging(totalCnt, sc);
	}
	
	public void doPaging(int tatalCnt, SearchItem sc) {
		
		this.totalPage = (int)Math.ceil(totalCnt/(double)getPageSize());			// 전체 페이지 갯수
		this.beginPage = (getPage()-1) / NAV_SIZE * NAV_SIZE +1;				// 첫 페이지 숫자
		this.endPage = Math.min(this.beginPage + this.NAV_SIZE -1, totalPage);		// 마지막 페이지 숫자
		this.showPrev = beginPage != 1;
		this.showNext = endPage != totalPage;	
	}
	
	public void print() {
		System.out.println("page = " + page);
		System.out.print(showPrev ? "PREV" : "");
		
		for (int i=beginPage; i<=endPage; i++) {
			System.out.print(i + " ");
		}
		
		System.out.println(showNext ? " Next" : "");
		
	}

	@Override
	public String toString() {
		return "PageResolver [totalCnt=" + totalCnt + ", pageSize=" + pageSize + ", NAV_SIZE=" + NAV_SIZE
				+ ", totalPage=" + totalPage + ", page=" + page + ", beginPage=" + beginPage + ", endPage=" + endPage
				+ ", showNext=" + showNext + ", showPrev=" + showPrev + "]";
	}

	
	
	public SearchItem getSc() {
		return sc;
	}

	public void setSc(SearchItem sc) {
		this.sc = sc;
	}

	public int getTotalCnt() {
		return totalCnt;
	}

	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getBeginPage() {
		return beginPage;
	}

	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isShowNext() {
		return showNext;
	}

	public void setShowNext(boolean showNext) {
		this.showNext = showNext;
	}

	public boolean isShowPrev() {
		return showPrev;
	}

	public void setShowPrev(boolean showPrev) {
		this.showPrev = showPrev;
	}

	public int getNAV_SIZE() {
		return NAV_SIZE;
	}
	
	
	
}
