package page;

import java.util.List;

import model.History;

public class HistoryPage extends Page {
	private List<History> content;

	public HistoryPage(int totalCount, int currentPage, int size, List<History> content) {
		super(totalCount, currentPage, size);
		this.content = content;
	}

	public List<History> getContent() {
		return content;
	}
}
