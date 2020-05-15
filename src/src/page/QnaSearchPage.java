package page;

import java.util.List;

import model.Qnamodel;;

public class QnaSearchPage {
	//게시물 검색에 필요한 데이터를 객체로 묶음
	private int total;				//전체게시물수  100
	private List<Qnamodel> search;	//화면에 출력할 게시글 목록 10
	private String keyword1;
	private String keyword2;
	private String keyword3;
	private String keyword4;
	
	public QnaSearchPage(int total,List<Qnamodel> search, String keyword1, String keyword2, String keyword3,String keyword4) {
		this.total =total;
		this.search = search;
		this.keyword1 = keyword1;
		this.keyword2 = keyword2;
		this.keyword3 = keyword3;
		this.keyword4 = keyword4;
		
		
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
	
	public boolean hasNoQuestions() {
		return total == 0;
	}

	public boolean hasQuestions() {
		return total > 0;
	}

	public List<Qnamodel> getSearch() {
		return search;
	}

	public void setSearch(List<Qnamodel> search) {
		this.search = search;
	}

	public String getKeyword1() {
		return keyword1;
	}

	public void setKeyword1(String keyword1) {
		this.keyword1 = keyword1;
	}

	public String getKeyword2() {
		return keyword2;
	}

	public void setKeyword2(String keyword2) {
		this.keyword2 = keyword2;
	}

	public String getKeyword3() {
		return keyword3;
	}

	public void setKeyword3(String keyword3) {
		this.keyword3 = keyword3;
	}

	public String getKeyword4() {
		return keyword4;
	}

	public void setKeyword4(String keyword4) {
		this.keyword4 = keyword4;
	}

	@Override
	public String toString() {
		return "QnaSearchPage [total=" + total + ", search=" + search + ", keyword1=" + keyword1 + ", keyword2="
				+ keyword2 + ", keyword3=" + keyword3 + ", keyword4=" + keyword4 + "]";
	}


		
}
