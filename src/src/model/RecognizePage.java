package page;

import java.util.List;


import model.Recognize;

//게시물 데이터   및       페이징처리에 필요한 데이터
//P648
public class RecognizePage extends Page {
	private List<Recognize> content;

	public RecognizePage(int totalCount, int currentPage, int size, List<Recognize> content) {
		super(totalCount, currentPage, size);
		this.content = content;
	}

	public List<Recognize> getContent() {
		return content;
	}
}
