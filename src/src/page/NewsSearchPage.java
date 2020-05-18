package page;

import java.util.List;

import model.News;


public class NewsSearchPage {
	//게시물 검색에 필요한 데이터를 객체로 묶음
	private int total;				//전체게시물수  100
	private List<News> search;	//화면에 출력할 게시글 목록 10
	private String keyword1;

	

	public NewsSearchPage(int total,List<News> search, String keyword1) {
		this.total =total;
		this.search = search;
		this.keyword1 = keyword1;
		
		
		
	}
//	public QnaSearchPage(int total,List<Qnamodel> search,String title) {
//			this.total =total;
//			this.search = search;
//			this.title =title;		
//		}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	public boolean hasNoNews() {
		return total == 0;
	}

	public boolean hasNews() {
		return total > 0;
	}

	public List<News> getSearch() {
		return search;
	}

	public void setSearch(List<News> search) {
		this.search = search;
	}

	public String getKeyword1() {
		return keyword1;
	}

	public void setKeyword1(String keyword1) {
		this.keyword1 = keyword1;
	}


	@Override
	public String toString() {
		return "NewsSearchPage [total=" + total + ", search=" + search + ", keyword1=" + keyword1 + "]";
	}
	


		
}
