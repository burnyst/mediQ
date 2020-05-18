package page;

import java.util.List;

import model.Faq;

public class FaqSearchPage {
	
	//게시물 검색에 필요한 데이터를 객체로 묶음
	private int searchtotal;
	private int currentPage;				//보고싶은페이지
	private List<Faq> searchlist;
	private String search;
	private int totalPages;				//전체 페이지수
	private int startPage;					//시작 페이지번호		[1 2 3 4 5]	[6 7 8 9 10]
	private int endPage;					//끝 페이지번호
	
	
	public FaqSearchPage(int searchtotal, List<Faq> searchlist, int currentPage, int size, String search) {
		this.searchtotal=searchtotal;
		this.searchlist=searchlist;
		this.currentPage=currentPage;
		this.search=search;
		
		if (searchtotal == 0) {	
			totalPages = 0;
			startPage = 0;
			endPage = 0;
		} else {
			totalPages = searchtotal / size; 		
		    //전체 페이지수  = 전체게시물수 /한페이지당 게시글수;
			if (searchtotal % size > 0) {
				totalPages++;
			}
			
			//아래의 5값은 한번에 출력하고 싶은 페이지 개수를 뜻한다.
			int modVal = currentPage % 5;		
			startPage = currentPage /5* 5 + 1;
			if (modVal == 0) startPage -= 5;		
			
			endPage = startPage + 4;

			if (endPage > totalPages) endPage = totalPages;
		}
	}
	public boolean hasNoFaq() {
		return searchtotal == 0;
	}

	public boolean hasFaq() {
		return searchtotal > 0;
	}
	public int getSearchtotal() {
		return searchtotal;
	}
	public void setSearchtotal(int searchtotal) {
		this.searchtotal = searchtotal;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public List<Faq> getSearchlist() {
		return searchlist;
	}
	public void setSearchlist(List<Faq> searchlist) {
		this.searchlist = searchlist;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	@Override
	public String toString() {
		return "FaqSearchPage [searchtotal=" + searchtotal + ", currentPage=" + currentPage + ", searchlist="
				+ searchlist + ", search=" + search + ", totalPages=" + totalPages + ", startPage=" + startPage
				+ ", endPage=" + endPage + "]";
	}

	
	

}
