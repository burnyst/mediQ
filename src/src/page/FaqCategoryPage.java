package page;


import java.util.List;

import model.Faq;

public class FaqCategoryPage {
	
	//게시물 검색에 필요한 데이터를 객체로 묶음
	private int categorytotal;
	private int currentPage;				//보고싶은페이지
	private List<Faq> categorylist;
	private String category;
	private int totalPages;				//전체 페이지수
	private int startPage;					//시작 페이지번호		[1 2 3 4 5]	[6 7 8 9 10]
	private int endPage;					//끝 페이지번호
	
	public FaqCategoryPage(int categorytotal, List<Faq> categorylist, int currentPage, int size, String category) {
		this.categorytotal=categorytotal;
		this.categorylist=categorylist;
		this.currentPage=currentPage;
		this.category=category;
		
		if (categorytotal == 0) {	
			totalPages = 0;
			startPage = 0;
			endPage = 0;
		} else {
			totalPages = categorytotal / size; 		
		    //전체 페이지수  = 전체게시물수 /한페이지당 게시글수;
			if (categorytotal % size > 0) {
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
		return categorytotal == 0;
	}

	public boolean hasFaq() {
		return categorytotal > 0;
	}


	public int getCategorytotal() {
		return categorytotal;
	}


	public void setCategorytotal(int categorytotal) {
		this.categorytotal = categorytotal;
	}


	public int getCurrentPage() {
		return currentPage;
	}


	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}


	public List<Faq> getCategorylist() {
		return categorylist;
	}


	public void setCategorylist(List<Faq> categorylist) {
		this.categorylist = categorylist;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
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
		return "FaqCategoryPage [categorytotal=" + categorytotal + ", currentPage=" + currentPage + ", categorylist="
				+ categorylist + ", category=" + category + ", totalPages=" + totalPages + ", startPage=" + startPage
				+ ", endPage=" + endPage + "]";
	}


	
	
	
}
