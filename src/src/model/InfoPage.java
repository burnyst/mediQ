package page;

import java.util.List;

import model.InfoModel;
import model.Recognize;
public class InfoPage extends Page {
	private List<InfoModel> info;

	public InfoPage(int totalCount, int currentPage, int size, List<InfoModel> info) {
		super(totalCount, currentPage, size);
		this.info = info;
	}

	public List<InfoModel> getContent() {
		return info;
	}
}