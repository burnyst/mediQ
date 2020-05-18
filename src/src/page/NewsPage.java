package page;

import java.util.List;
import model.News;

public class NewsPage extends Page {
	private List<News> content;
	

	public NewsPage(int totalCount, int currentPage, int size, List<News> content) {
		super(totalCount, currentPage, size);
		this.content = content;
	
	}
	public List<News> getContent() {
		return content;
	}
	
	public boolean hasNoNews() {
		return getTotalCount() == 0;
	}

	public boolean hasNews() {
		return getTotalCount() > 0;
	}
	
}
