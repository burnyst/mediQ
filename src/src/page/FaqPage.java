package page;

import java.util.List;
import model.Faq;

//게시물 데이터   및       페이징처리에 필요한 데이터
//P648
public class FaqPage {

	private int total;							//전체게시물수		100
	private int currentPage;				//보고싶은페이지		6
	private List<Faq> content;	//화면에 출력할 게시글 목록		10
	private int totalPages;				//전체 페이지수
	private int startPage;					//시작 페이지번호		[1 2 3 4 5]	[6 7 8 9 10]
	private int endPage;					//끝 페이지번호

	//FaqPage(전체게시물수, 보고싶은페이지,한페이지당 게시글수, List<Faq> content)
	public FaqPage(int total, int currentPage, int size, List<Faq> content) {
		this.total = total;
		this.currentPage = currentPage;
		this.content = content;
		if (total == 0) {	
			totalPages = 0;
			startPage = 0;
			endPage = 0;
		} else {
			totalPages = total / size; 		
		    //전체 페이지수  = 전체게시물수 /한페이지당 게시글수;
			if (total % size > 0) {
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

	public int getTotal() {
		return total;
	}

	public boolean hasNoFaq() {
		return total == 0;
	}

	public boolean hasFaq() {
		return total > 0;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public List<Faq> getContent() {
		return content;
	}

	public int getStartPage() {
		return startPage;
	}
	
	public int getEndPage() {
		return endPage;
	}
	

	public void setTotal(int total) {
		this.total = total;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setContent(List<Faq> content) {
		this.content = content;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	@Override
	public String toString() {
		return "FaqPage [total=" + total + ", currentPage=" + currentPage + ", content=" + content + ", totalPages="
				+ totalPages + ", startPage=" + startPage + ", endPage=" + endPage + "]";
	}
	
	
}
