package page;

import java.util.List;

import model.Recognize;


public class RecognizeSearchPage {
	    
		//게시물 검색에 필요한 데이터를 객체로 묶음
		private int total;				//전체게시물수  100
		private List<Recognize> search;	//화면에 출력할 게시글 목록 10
		
		private String itemname;

		public RecognizeSearchPage(int total,List<Recognize> search, String itemname) {
			this.total =total;
			this.search = search;
			this.itemname = itemname;
			
			
		}
		

		public int getTotal() {
			return total;
		}

		public void setTotal(int total) {
			this.total = total;
		}

		public List<Recognize> getSearch() {
			return search;
		}

		public void setSearch(List<Recognize> search) {
			this.search = search;
		}

		public String getItemname() {
			return itemname;
		}

		public void setItemname(String itemname) {
			this.itemname = itemname;
		}

		@Override
		public String toString() {
			return "RecognizeSearchPage [total=" + total + ", search=" + search + ", itemname=" + itemname + "]";
		}
		



}