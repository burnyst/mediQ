package page;

import java.util.List;

import model.Memberlist;




public class ListMemberPage extends Page {
	private List<Memberlist> content;
	

	public ListMemberPage(int totalCount, int currentPage, int size, List<Memberlist> content) {
		super(totalCount, currentPage, size);
		this.content = content;
	
	}
	public List<Memberlist> getContent() {
		return content;
	}
	
	public boolean hasNoMember() {
		return getTotalCount() == 0;
	}

	public boolean hasMember() {
		return getTotalCount() > 0;
	}
	
}
