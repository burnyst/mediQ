package page;

public class Page {
	private int totalCount;
	private int currentPage;
	private int totalPages;
	private int startPage;
	private int endPage;
	public Page(int totalCount, int currentPage, int size) {
		this.totalCount = totalCount;
		this.currentPage = currentPage;
		if (totalCount == 0) {
			totalPages = 0;
			startPage = 0;
			endPage = 0;
		} else {
			totalPages = totalCount / size; 
			if (totalCount % size > 0) {
				totalPages++;
			}
			startPage = (currentPage - 1) / 5 * 5 + 1;
			endPage = startPage + 4;
			if (endPage > totalPages) {
				endPage = totalPages;
			}
		}
	}
	public int getTotalCount() {
		return totalCount;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public int getStartPage() {
		return startPage;
	}
	public int getEndPage() {
		return endPage;
	}
}
